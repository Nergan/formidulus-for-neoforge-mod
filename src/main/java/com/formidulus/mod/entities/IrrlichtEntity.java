package com.formidulus.mod.entities;

import com.formidulus.mod.registries.EntityRegistry;
import com.formidulus.mod.registries.SoundRegistry;
import java.util.List;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.SynchedEntityData.Builder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class IrrlichtEntity extends Mob {
   public static final byte FOLLOWER_TYPE = 0;
   public static final byte PROJECTILE_TYPE = 1;
   static final EntityDataAccessor<Byte> TYPE = SynchedEntityData.defineId(IrrlichtEntity.class, EntityDataSerializers.BYTE);
   int lifetime = 200;
   int targetCheckTimer;
   Entity owner;

   public IrrlichtEntity(EntityType<? extends Mob> entityType, Level world) {
      super(entityType, world);
      this.setNoGravity(true);
      this.noPhysics = true;
   }

   protected void defineSynchedData(Builder builder) {
      super.defineSynchedData(builder);
      builder.define(TYPE, (byte)0);
   }

   public void tick() {
      super.tick();
      if (!this.isDeadOrDying() && !this.isRemoved()) {
         if (this.level().isClientSide) {
            if (this.random.nextFloat() < 0.1F) {
               this.level().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + (double)this.getBbHeight(), this.getZ(), 0.0, 0.0, 0.0);
            }
         } else {
            switch (this.entityData.get(TYPE)) {
               case 0:
                  this.tickFollower();
                  break;
               case 1:
                  this.tickProjectile();
            }

            if (this.lifetime-- <= 0) {
               this.level().broadcastEntityEvent(this, (byte)60);
               this.remove(RemovalReason.KILLED);
            }
         }
      }
   }

   void tickFollower() {
      float targetDistance = Float.MAX_VALUE;
      LivingEntity target = null;
      if (this.targetCheckTimer-- <= 0) {
         for (Player p : this.level()
            .getEntities(EntityTypeTest.forClass(Player.class), this.getBoundingBox().inflate(16.0), i -> !i.isCreative() && !i.isDeadOrDying())) {
            if (target == null) {
               target = p;
               targetDistance = this.distanceTo(p);
            } else if (targetDistance > this.distanceTo(p)) {
               target = p;
            }
         }

         this.setTarget(target);
      }

      Vec3 targetVelocity;
      if (target != null) {
         targetVelocity = target.position().add(0.0, 1.0, 0.0).subtract(this.position()).normalize().scale(0.15 * (double)this.getSpeed());
      } else {
         targetVelocity = Vec3.ZERO;
      }

      this.setDeltaMovement(this.getDeltaMovement().lerp(targetVelocity, 0.1F));
      if (this.getTarget() != null && this.position().distanceTo(this.getTarget().getBoundingBox().getCenter()) < 0.2F) {
         this.getTarget().setRemainingFireTicks(this.getTarget().getRemainingFireTicks() + 60);
         this.level().broadcastEntityEvent(this, (byte)60);
         this.remove(RemovalReason.KILLED);
      }
   }

   void tickProjectile() {
      this.setDeltaMovement(0.0, 0.4 * (double)((float)this.lifetime / 100.0F), 0.0);
      if (this.lifetime == 1) {
         Vec3 checkPos = this.position().subtract(0.5, 0.5, 0.5);
         if (this.owner != null) {
            checkPos = this.owner.position();
         }

         LivingEntity target = null;
         if (this.owner instanceof BossEntity boss) {
            target = boss.getRandomTarget();
         } else {
            List<Player> targets = this.level()
               .getEntities(
                  EntityTypeTest.forClass(Player.class), AABB.unitCubeFromLowerCorner(checkPos).inflate(32.0), i -> this.isAlive() && !i.isSpectator()
               );
            if (!targets.isEmpty()) {
               target = (LivingEntity)targets.get(this.random.nextInt(targets.size()));
            }
         }

         if (target != null) {
            PumpkinProjectile pumpkin = new PumpkinProjectile(EntityRegistry.PUMPKIN, this.level());
            pumpkin.setOwner(this.owner);
            pumpkin.setPos(this.position());
            Vec3 vel = target.getBoundingBox().getCenter().subtract(this.position());
            pumpkin.setDeltaMovement(vel.normalize().scale((double)(0.5F * Math.max((float)this.level().getDifficulty().getId(), 1.0F))));
            this.level().addFreshEntity(pumpkin);
         }
      }
   }

   public float getSpeed() {
      return 1.0F + (float)this.level().getDifficulty().getId() * 0.25F;
   }

   public void setLifetime(int lifetime) {
      this.lifetime = lifetime;
   }

   public void setType(byte type) {
      this.entityData.set(TYPE, type);
   }

   public void setOwner(Entity owner) {
      this.owner = owner;
   }

   protected void doPush(Entity entity) {
   }

   public void push(Entity entity) {
   }

   @Nullable
   protected SoundEvent getDeathSound() {
      return SoundRegistry.IRRLICHT_DEATH;
   }

   @Nullable
   protected SoundEvent getAmbientSound() {
      return SoundRegistry.IRRLICHT_IDLE;
   }

   public void handleEntityEvent(byte status) {
      if (status != 60) {
         super.handleEntityEvent(status);
      } else {
         for (int i = 0; i < 5; i++) {
            Vec3 vel = Vec3.ZERO.offsetRandom(this.random, 0.1F);
            this.level().addParticle(ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), vel.x, vel.y, vel.z);
         }
      }
   }

   public void addAdditionalSaveData(CompoundTag nbt) {
      super.addAdditionalSaveData(nbt);
      nbt.putByte("Type", (Byte)this.entityData.get(TYPE));
   }

   public void readAdditionalSaveData(CompoundTag nbt) {
      super.readAdditionalSaveData(nbt);
      if (nbt.contains("Type", 1)) {
         this.entityData.set(TYPE, nbt.getByte("Type"));
      }
   }
}
