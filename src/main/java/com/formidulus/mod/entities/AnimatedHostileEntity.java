package com.formidulus.mod.entities;

import com.formidulus.mod.entities.goal.InterruptableGoal;
import java.util.List;
import java.util.function.BiConsumer;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.SynchedEntityData.Builder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public abstract class AnimatedHostileEntity extends Monster {
   static final EntityDataAccessor<Byte> ANIMATION = SynchedEntityData.defineId(AnimatedHostileEntity.class, EntityDataSerializers.BYTE);
   static final EntityDataAccessor<Integer> ANIMATION_START = SynchedEntityData.defineId(AnimatedHostileEntity.class, EntityDataSerializers.INT);
   static final EntityDataAccessor<Integer> ATTACK_COOLDOWN = SynchedEntityData.defineId(AnimatedHostileEntity.class, EntityDataSerializers.INT);
   byte lastAnimation;
   int animFlags;

   protected AnimatedHostileEntity(EntityType<? extends Monster> entityType, Level world) {
      super(entityType, world);
   }

   protected void defineSynchedData(Builder builder) {
      super.defineSynchedData(builder);
      builder.define(ANIMATION, (byte)0);
      builder.define(ANIMATION_START, 0);
      builder.define(ATTACK_COOLDOWN, 0);
   }

   public void onSyncedDataUpdated(EntityDataAccessor<?> data) {
      super.onSyncedDataUpdated(data);
      if (this.level().isClientSide) {
         if (data.equals(ANIMATION_START)) {
            this.tickCount = (Integer)this.entityData.get(ANIMATION_START);
         }

         if (data.equals(ANIMATION)) {
            this.setAnimation((Byte)this.entityData.get(ANIMATION));
         }
      }
   }

   public void setAnimation(byte id) {
      if (!this.level().isClientSide) {
         this.entityData.set(ANIMATION_START, this.tickCount);
         this.entityData.set(ANIMATION, id);
      }

      AnimationState var3 = this.getAnimationState(this.lastAnimation);
      if (var3 instanceof AnimationState) {
         var3.stop();
      }

      var3 = this.getAnimationState(id);
      if (var3 instanceof AnimationState) {
         var3.start(this.tickCount);
      }

      this.lastAnimation = id;
      this.animFlags = 0;
   }

   public byte getCurrentAnimation() {
      return (Byte)this.entityData.get(ANIMATION);
   }

   public float getCurrentAnimationDuration() {
      return (float)(this.tickCount - (Integer)this.entityData.get(ANIMATION_START)) / 20.0F;
   }

   abstract AnimationState getAnimationState(byte var1);

   protected void setAnimationFlag(int idx, boolean state) {
      if (state) {
         this.animFlags |= 1 << idx;
      } else {
         this.animFlags &= ~(1 << idx);
      }
   }

   protected boolean getAnimationFlag(int idx) {
      return (this.animFlags >> idx & 1) == 1;
   }

   public void setAttackCooldown(int cooldown) {
      this.entityData.set(ATTACK_COOLDOWN, Math.max(cooldown, 0));
   }

   public boolean isReadyToAttack() {
      return (Integer)this.entityData.get(ATTACK_COOLDOWN) <= 0 && this.isTargetValid() && this.isNotInAttackAnimation();
   }

   public void tick() {
      super.tick();
      if (this.isTargetValid()) {
         int cd = (Integer)this.entityData.get(ATTACK_COOLDOWN);
         if (cd > 0) {
            this.entityData.set(ATTACK_COOLDOWN, cd - 1);
         }
      } else if (this.getTarget() != null) {
         this.setTarget(null);
      }
   }

   protected void forceStopActiveGoals() {
      this.navigation.stop();
      this.goalSelector.getAvailableGoals().forEach(i -> {
         if (i.getGoal() instanceof InterruptableGoal animated && i.isRunning()) {
            animated.forceStop();
         }
      });
   }

   public void tryInterruptActiveGoals(byte reason) {
      this.goalSelector.getAvailableGoals().forEach(i -> {
         if (i.getGoal() instanceof InterruptableGoal interruptable && i.isRunning()) {
            interruptable.interrupt(reason);
         }
      });
   }

   public abstract boolean isNotInAttackAnimation();

   protected float getHealthPercent() {
      return this.getHealth() / this.getMaxHealth();
   }

   public float getHorizontalDistanceToTarget() {
      return this.getHorizontalDistanceTo(this.getTarget());
   }

   public float getHorizontalDistanceTo(Vec3 pos, LivingEntity target) {
      return this.isTargetValid(target) && target != null
         ? (float)pos.multiply(1.0, 0.0, 1.0).distanceTo(target.position().multiply(1.0, 0.0, 1.0))
         : Float.MAX_VALUE;
   }

   public float getHorizontalDistanceTo(LivingEntity target) {
      return this.getHorizontalDistanceTo(this.position(), target);
   }

   public boolean isTargetValid(LivingEntity target) {
      if (target instanceof Player player && player.isCreative()) {
         return false;
      }

      return target != null && !target.isDeadOrDying() && !target.isRemoved() && !target.isSpectator() && target.canBeSeenAsEnemy();
   }

   public boolean isTargetValid() {
      return this.isTargetValid(this.getTarget());
   }

   public float getRelativeHorizontalAngleTo(Vec3 pos, LivingEntity target, Vec3 forward) {
      if (this.isTargetValid(target) && target != null) {
         Vec3 targetDir = target.position().multiply(1.0, 0.0, 1.0).subtract(pos.multiply(1.0, 0.0, 1.0)).normalize();
         forward = forward.multiply(1.0, 0.0, 1.0).normalize();
         return (float)Math.acos(targetDir.dot(forward));
      } else {
         return 0.0F;
      }
   }

   public float getRelativeHorizontalAngleTo(LivingEntity target, Vec3 forward) {
      return this.getRelativeHorizontalAngleTo(this.position(), target, forward);
   }

   public float getRelativeHorizontalAngleTo(LivingEntity target) {
      return this.getRelativeHorizontalAngleTo(target, this.getLookAngle());
   }

   public float getRelativeHorizontalTargetAngle() {
      return this.getRelativeHorizontalAngleTo(this.getTarget());
   }

   public int applyDamageInCylindricArea(
      float radius,
      float height,
      float maxAngle,
      DamageSource source,
      float amount,
      Vec3 angleCheckFowards,
      Vec3 offset,
      BiConsumer<LivingEntity, Boolean> extraProcess
   ) {
      int successfulHits = 0;
      AABB area = this.box(this.position()).inflate((double)radius, 0.0, (double)radius).expandTowards(0.0, (double)height, 0.0).move(offset);

      for (LivingEntity hit : this.level().getEntitiesOfClass(LivingEntity.class, area)) {
         if (!this.getIgnoredClasses().contains(hit.getClass())
            && !(this.getHorizontalDistanceTo(this.position().add(offset), hit) > radius)
            && !((double)this.getRelativeHorizontalAngleTo(this.position().add(offset), hit, angleCheckFowards) > Math.toRadians((double)maxAngle))) {
            boolean success = hit.hurt(source, amount);
            extraProcess.accept(hit, success);
            if (success) {
               successfulHits++;
               this.onDamageEntity(hit);
            }
         }
      }

      return successfulHits;
   }

   public int applyDamageInCylindricArea(
      float radius, float height, float maxAngle, DamageSource source, float amount, Vec3 angleCheckFowards, BiConsumer<LivingEntity, Boolean> extraProcess
   ) {
      return this.applyDamageInCylindricArea(radius, height, maxAngle, source, amount, angleCheckFowards, Vec3.ZERO, extraProcess);
   }

   public int applyDamageInCylindricArea(
      float radius, float height, float maxAngle, DamageSource source, float amount, BiConsumer<LivingEntity, Boolean> extraProcess
   ) {
      return this.applyDamageInCylindricArea(radius, height, maxAngle, source, amount, this.getLookAngle(), Vec3.ZERO, extraProcess);
   }

   public int applyDamageInCylindricArea(float radius, float height, DamageSource source, float amount, BiConsumer<LivingEntity, Boolean> extraProcess) {
      return this.applyDamageInCylindricArea(radius, height, 360.0F, source, amount, extraProcess);
   }

   public int applyDamageInCylindricArea(float radius, float height, float maxAngle, DamageSource source, float amount) {
      return this.applyDamageInCylindricArea(radius, height, maxAngle, source, amount, (i, b) -> {
      });
   }

   public int applyDamageInCylindricArea(float radius, float height, DamageSource source, float amount) {
      return this.applyDamageInCylindricArea(radius, height, 360.0F, source, amount, (i, b) -> {
      });
   }

   public List<Class<? extends LivingEntity>> getIgnoredClasses() {
      return List.of();
   }

   public void onDamageEntity(LivingEntity damaged) {
   }

   protected AABB box(Vec3 pos) {
      return new AABB(pos.subtract(0.5, 0.5, 0.5), pos.add(0.5, 0.5, 0.5));
   }
}
