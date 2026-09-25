package com.formidulus.mod.entities.goal;

import com.formidulus.mod.entities.AnimatedHostileEntity;
import net.minecraft.world.entity.LivingEntity;

public abstract class AnimatedAttackGoal<T extends AnimatedHostileEntity> extends InterruptableGoal {
   protected final T mob;
   protected final float duration;
   protected final byte attackAnimationId;
   protected final byte postAnimationID;
   protected int time;
   protected LivingEntity target;

   public AnimatedAttackGoal(T mob, byte attackAnimationId, float duration, byte postAnimationID) {
      this.mob = mob;
      this.duration = duration;
      this.attackAnimationId = attackAnimationId;
      this.postAnimationID = postAnimationID;
   }

   public boolean canUse() {
      return this.mob.isReadyToAttack() && this.mob.getTarget() != null;
   }

   @Override
   public void start() {
      super.start();
      this.time = 0;
      if (this.shouldImmediatelyStartAttackAnim()) {
         this.mob.setAnimation(this.attackAnimationId);
      }

      this.target = this.mob.getTarget();
   }

   public void tick() {
      super.tick();
      if ((float)this.time <= this.duration * 20.0F) {
         this.time++;
      }
   }

   public boolean requiresUpdateEveryTick() {
      return true;
   }

   public boolean isInterruptable() {
      return !this.canUse() || (float)this.time > this.duration * 20.0F;
   }

   public boolean canContinueToUse() {
      return (float)this.time <= this.duration * 20.0F && this.target != null && !this.target.isDeadOrDying() && !this.target.isRemoved();
   }

   protected boolean shouldImmediatelyStartAttackAnim() {
      return true;
   }

   protected abstract int getAttackCooldown();

   public void stop() {
      super.stop();
      if (this.mob.getCurrentAnimation() == this.attackAnimationId) {
         this.mob.setAnimation(this.postAnimationID);
      }

      if (!this.wasForceStopped()) {
         this.mob.setAttackCooldown(this.getAttackCooldown());
      }
   }
}
