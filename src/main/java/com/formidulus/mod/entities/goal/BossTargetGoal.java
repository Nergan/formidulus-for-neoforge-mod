package com.formidulus.mod.entities.goal;

import com.formidulus.mod.entities.BossEntity;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;

public class BossTargetGoal extends Goal {
   final Class<LivingEntity>[] untargettableTypes;
   final BossEntity mob;
   final int switchInterval;
   final float range;
   final float switchChance;
   final Map<LivingEntity, Float> knownTargets = new HashMap<>();
   int lastAttackedTime;
   int lastTargetDamagedTime;
   int targetSwitchTimer;
   LivingEntity lastTarget;

   @SafeVarargs
   public BossTargetGoal(BossEntity mob, float range, int switchInterval, float switchChance, Class<LivingEntity>... untargettableTypes) {
      this.mob = mob;
      this.untargettableTypes = untargettableTypes;
      this.range = range;
      this.switchInterval = switchInterval;
      this.switchChance = switchChance;
      this.setFlags(EnumSet.of(Flag.TARGET));
   }

   public boolean canUse() {
      return true;
   }

   public void tick() {
      super.tick();
      this.validateTargetList();
      LivingEntity curTarget = this.mob.getTarget();
      if (this.mob.getLastHurtByMobTimestamp() != this.lastAttackedTime) {
         this.targetSwitchTimer = this.targetSwitchTimer - this.switchInterval / 3;
         this.lastAttackedTime = this.mob.getLastHurtMobTimestamp();
         LivingEntity lastAttacker = this.mob.getLastAttacker();
         if (this.isTargetValid(lastAttacker)) {
            this.knownTargets
               .put(
                  lastAttacker,
                  this.knownTargets.containsKey(lastAttacker)
                     ? this.knownTargets.get(lastAttacker) + this.mob.getLastDamageTaken()
                     : this.getStartPriority(lastAttacker)
               );
         }
      }

      if (this.mob.getLastTargetDamagedTime() != this.lastTargetDamagedTime) {
         this.lastTargetDamagedTime = this.mob.getLastTargetDamagedTime();
         this.targetSwitchTimer = Math.min(this.targetSwitchTimer + this.switchInterval / 6, this.switchInterval);
      }

      this.mob
         .level()
         .getEntities(
            EntityTypeTest.forClass(Player.class),
            AABB.unitCubeFromLowerCorner(this.mob.position().subtract(0.5, 0.5, 0.5)).inflate((double)this.range),
            this::isTargetValid
         )
         .forEach(p -> {
            if (!this.knownTargets.containsKey(p)) {
               this.knownTargets.put(p, 5.0F);
            }
         });
      if (curTarget != null) {
         if (!this.isTargetValid(curTarget)) {
            curTarget = null;
            this.mob.setTarget(null);
         } else if (!this.knownTargets.containsKey(curTarget)) {
            this.knownTargets.put(curTarget, this.getStartPriority(curTarget));
         }
      }

      if (!this.knownTargets.isEmpty()) {
         this.targetSwitchTimer--;
         if (!this.isTargetValid(curTarget)) {
            this.mob.setTarget(this.getBestTarget());
            this.targetSwitchTimer = this.switchInterval;
         } else if (this.targetSwitchTimer <= 0) {
            if (this.mob.getRandom().nextFloat() <= this.switchChance) {
               LivingEntity bestTarget = this.getBestTarget();
               if (bestTarget != null && this.knownTargets.size() > 1 && bestTarget.equals(this.lastTarget)) {
                  this.randomizeTarget();
               } else {
                  this.mob.setTarget(bestTarget);
               }
            }

            this.targetSwitchTimer = this.switchInterval;
         }
      }
   }

   void validateTargetList() {
      List<LivingEntity> remove = new ArrayList<>();

      for (LivingEntity living : this.knownTargets.keySet()) {
         if (!this.isTargetValid(living)) {
            remove.add(living);
         }
      }

      remove.forEach(this.knownTargets::remove);
   }

   boolean isTargetValid(LivingEntity living) {
      return this.mob.isTargetValid(living)
         && (
            !(living instanceof ServerPlayer serverPlayer)
               || this.mob.getBossFightInstance() != null && this.mob.getBossFightInstance().isParticipant(serverPlayer)
         );
   }

   float getStartPriority(LivingEntity living) {
      return living instanceof Player ? 5.0F : 0.0F;
   }

   LivingEntity getBestTarget() {
      this.validateTargetList();
      if (this.knownTargets.size() == 1) {
         return ((LivingEntity[])this.knownTargets.keySet().toArray(new LivingEntity[0]))[0];
      } else {
         float highestPriority = Float.MIN_VALUE;
         LivingEntity bestTarget = null;

         for (LivingEntity living : this.knownTargets.keySet()) {
            if (this.isTargetValid(living)) {
               float priority = this.knownTargets.get(living) - this.mob.distanceTo(living) * 0.25F;
               if (priority > highestPriority) {
                  highestPriority = priority;
                  bestTarget = living;
               }
            }
         }

         return bestTarget;
      }
   }

   public void randomizeTarget() {
      LivingEntity target = this.getRandomTarget();
      this.mob.setTarget(target);
   }

   public LivingEntity getRandomTarget() {
      List<LivingEntity> targets = this.getAllTargets();
      return targets.isEmpty() ? null : targets.get(this.mob.getRandom().nextInt(this.knownTargets.size()));
   }

   public List<LivingEntity> getAllTargets() {
      this.validateTargetList();
      return new ArrayList<>(this.knownTargets.keySet());
   }

   public boolean isHasNoTargets() {
      return this.getAllTargets().isEmpty();
   }
}
