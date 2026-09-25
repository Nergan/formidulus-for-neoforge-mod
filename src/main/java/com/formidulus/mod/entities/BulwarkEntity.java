package com.formidulus.mod.entities;

import com.formidulus.mod.accessor.LivingEntityAccessor;
import com.formidulus.mod.components.FormidableComponents;
import com.formidulus.mod.components.entity.IBulwarkComponent;
import com.formidulus.mod.registries.EntityRegistry;
import com.formidulus.mod.registries.SoundRegistry;
import com.formidulus.mod.registries.TagRegistry;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.SynchedEntityData.Builder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class BulwarkEntity extends AnimatedEntity {
   public static final EntityDataAccessor<Optional<UUID>> OWNER = SynchedEntityData.defineId(BulwarkEntity.class, EntityDataSerializers.OPTIONAL_UUID);
   public static final EntityDataAccessor<Boolean> SMASH = SynchedEntityData.defineId(BulwarkEntity.class, EntityDataSerializers.BOOLEAN);
   public AnimationState prePlaceAnimationState = new AnimationState();
   public AnimationState placeAnimationState = new AnimationState();
   public AnimationState hitAnimationState = new AnimationState();
   public AnimationState removeAnimationState = new AnimationState();
   static final byte PREPLACE_ANIM = 0;
   static final byte PLACE_ANIM = 1;
   static final byte HIT_ANIM = 2;
   static final byte REMOVE_ANIM = 3;

   public BulwarkEntity(EntityType<? extends AnimatedEntity> type, Level world) {
      super(type, world);
   }

   @Override
   protected void defineSynchedData(Builder builder) {
      super.defineSynchedData(builder);
      builder.define(OWNER, Optional.empty());
      builder.define(SMASH, false);
   }

   public static BulwarkEntity place(Player owner) {
      if (owner != null && owner.isAlive()) {
         BulwarkEntity bulwark = new BulwarkEntity(EntityRegistry.BULWARK, owner.level());
         bulwark.setOwner(owner);
         bulwark.setPos(owner.position().add(owner.getLookAngle().multiply(1.0, 0.0, 1.0).normalize().scale(0.4F)));
         bulwark.setYRot(owner.getYRot());
         owner.level().addFreshEntity(bulwark);
         bulwark.setYRot(owner.getYRot());
         bulwark.setYHeadRot(owner.getYRot());
         bulwark.setYBodyRot(owner.getYRot());
         bulwark.setAnimation((byte)0);
         if (!owner.onGround()) {
            bulwark.entityData.set(SMASH, true);
         }

         return bulwark;
      } else {
         return null;
      }
   }

   public void setOwner(Player owner) {
      if (owner == null) {
         this.entityData.set(OWNER, Optional.empty());
      } else {
         this.entityData.set(OWNER, Optional.of(owner.getUUID()));
      }
   }

   public Player getOwner() {
      return ((Optional)this.entityData.get(OWNER)).isEmpty() ? null : this.level().getPlayerByUUID((UUID)((Optional)this.entityData.get(OWNER)).get());
   }

   @Nullable
   @Override
   protected AnimationState getAnimationState(byte id) {
      return switch (id) {
         case 0 -> this.prePlaceAnimationState;
         case 1 -> this.placeAnimationState;
         case 2 -> this.hitAnimationState;
         case 3 -> this.removeAnimationState;
         default -> null;
      };
   }

   public boolean canBeSeenAsEnemy() {
      return this.getCurrentAnimation() == 2 || this.getCurrentAnimation() == 1 && this.getCurrentAnimationDuration() > 0.35F;
   }

   public void push(Entity entity) {
   }

   protected void doPush(Entity entity) {
   }

   protected void moveTowardsClosestSpace(double x, double y, double z) {
   }

   public boolean isPushedByFluid() {
      return false;
   }

   public boolean isNoGravity() {
      return true;
   }

   public void knockback(double strength, double x, double z) {
   }

   public int getAirSupply() {
      return 20;
   }

   @Override
   public boolean hurt(DamageSource source, float amount) {
      return source.is(DamageTypes.ON_FIRE) ? super.hurt(source, amount) : false;
   }

   public void redirectDamage(DamageSource source, float amount) {
      boolean b = super.hurt(source, amount);
      if (b) {
         if (this.getHealth() <= 0.0F) {
            this.setAnimation((byte)3);
            Player owner = this.getOwner();
            if (owner instanceof LivingEntityAccessor living) {
               living.setShieldBreakImmunity(5);
            }

            IBulwarkComponent comp = FormidableComponents.bulwark(owner);
            comp.onBulwarkBreak();
            this.playSound(SoundRegistry.BULWARK_BREAK, 1.0F, 0.8F);
         } else {
            this.setAnimation((byte)2);
         }
      }
   }

   public boolean isPickable() {
      return false;
   }

   protected void playHurtSound(DamageSource damageSource) {
      this.playSound(SoundRegistry.BULWARK_BLOCK, 1.0F, 0.8F);
   }

   protected void tickDeath() {
   }

   public void setDeltaMovement(Vec3 velocity) {
   }

   public void tick() {
      super.tick();
      if (!this.level().isClientSide
         && this.getOwner() != null
         && this.getOwner().onGround()
         && this.getCurrentAnimation() == 0
         && this.getCurrentAnimationDuration() > 0.25F) {
         this.setAnimation((byte)1);
      }

      this.setDeltaMovement(Vec3.ZERO);
      if (!this.isRemoved()) {
         if (this.getCurrentAnimation() == 3) {
            if (this.getCurrentAnimationDuration() > 0.75F) {
               this.discard();
            }
         } else if (!this.isRemoved()) {
            if (((Optional)this.entityData.get(OWNER)).isEmpty()) {
               this.setAnimation((byte)3);
            } else {
               Player owner = this.level().getPlayerByUUID((UUID)((Optional)this.entityData.get(OWNER)).get());
               if (!this.level().isClientSide
                  && (
                     owner == null
                        || !owner.isAlive()
                        || new Vec2((float)this.getX(), (float)this.getZ()).distanceToSqr(new Vec2((float)owner.getX(), (float)owner.getZ())) > 1.0F
                  )) {
                  this.setAnimation((byte)3);
               }

               if (this.getCurrentAnimation() == 1 && this.getCurrentAnimationDuration() >= 0.1F && !this.getAnimationFlag(0)) {
                  if (!(Boolean)this.entityData.get(SMASH)) {
                     this.playSound(SoundRegistry.BULWARK_PLACE, 1.0F, 0.9F);

                     for (int i = 0; i < 16; i++) {
                        Vec3 ppos = this.position().add(Vec3.ZERO.offsetRandom(this.random, 1.25F).multiply(1.0, 0.0, 1.0));
                        this.level()
                           .addParticle(
                              new BlockParticleOption(ParticleTypes.BLOCK, this.level().getBlockState(BlockPos.containing(ppos).below())),
                              ppos.x,
                              ppos.y,
                              ppos.z,
                              0.0,
                              0.0,
                              0.0
                           );
                     }
                  } else {
                     this.playSound(SoundRegistry.BULWARK_SMASH, 1.0F, 0.9F);

                     for (int i = 0; i < 32; i++) {
                        Vec3 ppos = this.position().add(Vec3.ZERO.offsetRandom(this.random, 2.0F).multiply(1.0, 0.0, 1.0));
                        this.level()
                           .addParticle(
                              new BlockParticleOption(ParticleTypes.DUST_PILLAR, this.level().getBlockState(BlockPos.containing(ppos).below())),
                              ppos.x,
                              ppos.y,
                              ppos.z,
                              0.0,
                              0.33F,
                              0.0
                           );
                     }

                     if (!this.level().isClientSide) {
                        this.level()
                           .getEntities(
                              EntityTypeTest.forClass(LivingEntity.class),
                              this.getBoundingBox().inflate(3.0, 1.0, 3.0),
                              ix -> ix.canBeSeenAsEnemy() && !ix.equals(owner) && !ix.equals(this)
                           )
                           .forEach(
                              living -> {
                                 Vec3 dir = living.position().subtract(this.position()).multiply(1.0, 0.0, 1.0).normalize();
                                 living.push(
                                    dir.scale(2.0)
                                       .add(0.0, 0.2F, 0.0)
                                       .scale(
                                          Math.max(
                                             1.0
                                                - living.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE)
                                                - this.position().multiply(1.0, 0.0, 1.0).distanceTo(living.position().multiply(1.0, 0.0, 1.0)) / 4.0,
                                             0.0
                                          )
                                       )
                                 );
                                 if (owner != null) {
                                    living.setLastHurtByMob(owner);
                                 }
                              }
                           );
                     }
                  }

                  this.setAnimationFlag(0, true);
               }

               if (owner != null) {
                  this.setPos(owner.getX(), owner.getY(), owner.getZ());
               }
            }
         }
      }
   }

   public boolean tryBlockDamage(DamageSource source, float amount) {
      if (!this.canBeSeenAsEnemy()) {
         return false;
      } else if (source.is(TagRegistry.BULWARK_UNBLOCKABLE_DAMAGE)) {
         return false;
      } else {
         Entity var4 = source.getDirectEntity();
         if (var4 instanceof Entity && this.tryBlockDamage(var4, source, amount)) {
            return true;
         } else {
            var4 = source.getEntity();
            return var4 instanceof Entity && this.tryBlockDamage(var4, source, amount);
         }
      }
   }

   public boolean tryBlockDamage(Entity sourceEntity, DamageSource source, float amount) {
      if (this.isPosInFront(sourceEntity.position()) && !source.is(TagRegistry.BULWARK_UNBLOCKABLE_DAMAGE)) {
         this.redirectDamage(source, amount);
         if (sourceEntity instanceof AnimatedHostileEntity entity) {
            entity.tryInterruptActiveGoals((byte)100);
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean isPosInFront(Vec3 pos) {
      float angle = this.getRelativeHorizontalAngleTo(this.position(), pos, this.getLookAngle());
      return angle > 0.3F;
   }
}
