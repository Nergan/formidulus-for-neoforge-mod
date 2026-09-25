package com.formidulus.mod.entities;

import com.formidulus.mod.damage.DamageSources;
import com.formidulus.mod.registries.ItemRegistry;
import com.formidulus.mod.registries.SoundRegistry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class PumpkinProjectile extends ThrowableItemProjectile {
   public PumpkinProjectile(EntityType<? extends ThrowableItemProjectile> entityType, Level world) {
      super(entityType, world);
      this.stuckSpeedMultiplier = new Vec3(1.01F, 1.01F, 1.01F);
      if (this.random.nextFloat() <= 0.25F) {
         this.setItem(ItemRegistry.WEEN.getDefaultInstance());
      }
   }

   protected Item getDefaultItem() {
      return Items.JACK_O_LANTERN;
   }

   public boolean isNoGravity() {
      return true;
   }

   public void tick() {
      super.tick();
      if (!this.level().isClientSide && this.tickCount >= 200) {
         this.level().broadcastEntityEvent(this, (byte)3);
         this.discard();
      } else {
         if (this.tickCount == 1) {
            Vec3 dest = this.position().add(this.getDeltaMovement().normalize().scale(32.0));

            for (int i = 0; i < 64; i++) {
               Vec3 pos = this.position().lerp(dest, (double)((float)i / 64.0F));
               this.level().addParticle(ParticleTypes.CRIT, pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
            }
         }

         if (this.level().isClientSide) {
            Vec3 pos = this.position().offsetRandom(this.random, 0.15F);
            if (this.random.nextBoolean()) {
               this.level().addParticle(ParticleTypes.SMOKE, pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
            } else {
               this.level().addParticle(ParticleTypes.FLAME, pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
            }
         }
      }
   }

   public void handleEntityEvent(byte status) {
      super.handleEntityEvent(status);
      if (status == 3) {
         for (int i = 0; i < 16; i++) {
            Vec3 vel = Vec3.ZERO.offsetRandom(this.random, 0.2F);
            this.level().addParticle(ParticleTypes.LAVA, this.getX(), this.getY(), this.getZ(), vel.x, vel.y, vel.z);
         }

         this.level().playSound(null, this.blockPosition(), SoundRegistry.PUMPKIN_IMPACT, SoundSource.HOSTILE, 1.0F, 1.0F);
      }
   }

   protected void onHit(HitResult hitResult) {
      super.onHit(hitResult);
      if (!this.level().isClientSide) {
         this.level().broadcastEntityEvent(this, (byte)3);
         this.discard();
      }

      this.level()
         .getEntities(EntityTypeTest.forClass(LivingEntity.class), this.getBoundingBox().inflate(0.2F), i -> !i.equals(this.getOwner()))
         .forEach(this::hitLiving);
      this.level().playSound(null, this.blockPosition(), SoundRegistry.PUMPKIN_IMPACT, SoundSource.HOSTILE, 0.4F, 1.0F);
   }

   protected void onHitEntity(EntityHitResult eHit) {
      super.onHitEntity(eHit);
      if (eHit.getEntity() instanceof LivingEntity living && !eHit.getEntity().equals(this.getOwner())) {
         this.hitLiving(living);
         return;
      }
   }

   void hitLiving(LivingEntity living) {
      living.hurt(DamageSources.get(this.level(), DamageTypes.FIREBALL, this, this.getOwner()), 6.0F);
      living.setRemainingFireTicks(living.getRemainingFireTicks() + 40 * (this.level().getDifficulty().getId() + 1));
   }

   protected boolean canHitEntity(Entity entity) {
      return entity instanceof IrrlichtEntity ? false : super.canHitEntity(entity);
   }
}
