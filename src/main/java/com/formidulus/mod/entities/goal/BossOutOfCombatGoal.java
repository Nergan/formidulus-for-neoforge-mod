package com.formidulus.mod.entities.goal;

import com.formidulus.mod.entities.BossEntity;
import java.util.EnumSet;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import net.minecraft.world.phys.Vec3;

public class BossOutOfCombatGoal extends Goal {
   public static final byte BEHAVIOR_RESPAWN_AT_ORIGIN = 0;
   public static final byte BEHAVIOR_RETURN_TO_ORIGIN_AND_HEAL = 1;
   public static final byte BEHAVIOR_TELEPORT_TO_ORIGIN_AND_HEAL = 2;
   public static final byte BEHAVIOR_DESPAWN = 3;
   final BossEntity mob;
   final byte behavior;
   final float regenPerTick;
   final float speed;
   boolean wasInCombat;

   public BossOutOfCombatGoal(BossEntity mob, byte behavior) {
      this(mob, behavior, 10.0F);
   }

   public BossOutOfCombatGoal(BossEntity mob, byte behavior, float regenPerTick) {
      this(mob, behavior, regenPerTick, 0.4F);
   }

   public BossOutOfCombatGoal(BossEntity mob, byte behavior, float regenPerTick, float speed) {
      this.mob = mob;
      this.behavior = behavior;
      this.regenPerTick = regenPerTick;
      this.speed = speed;
      this.setFlags(EnumSet.of(Flag.MOVE));
   }

   public boolean canUse() {
      boolean b = !this.mob.isInCombat() && this.wasInCombat;
      this.wasInCombat = this.mob.isInCombat();
      return b;
   }

   public void start() {
      super.start();
      this.mob.beforeBossReset();
      BlockPos originBlock = (BlockPos)this.mob.getEntityData().get(BossEntity.ORIGIN);
      if (this.behavior == 2 || this.mob.getNavigation().createPath(originBlock, 1) == null) {
         this.mob.setPos(((BlockPos)this.mob.getEntityData().get(BossEntity.ORIGIN)).getBottomCenter());
      } else if (this.behavior == 3) {
         this.mob.discard();
         this.mob.afterBossReset();
      } else if (this.behavior == 0 && this.mob.level() instanceof ServerLevel serverWorld) {
         if (this.mob.getType().spawn(serverWorld, reborn -> {
            reborn.setYRot(0.0F);
            reborn.setYHeadRot(0.0F);
            reborn.setYBodyRot(0.0F);
            reborn.moveTo(reborn.position(), 0.0F, 0.0F);
         }, originBlock, MobSpawnType.MOB_SUMMONED, true, false) instanceof BossEntity boss) {
            boss.afterBossReset();
         }

         this.mob.discard();
      }
   }

   public boolean canContinueToUse() {
      if (this.mob.getTarget() != null) {
         return false;
      } else if (this.behavior != 1) {
         return this.behavior == 2 ? this.mob.getHealth() < this.mob.getMaxHealth() : false;
      } else {
         return this.mob.getHealth() < this.mob.getMaxHealth()
            && ((BlockPos)this.mob.getEntityData().get(BossEntity.ORIGIN)).closerToCenterThan(this.mob.position(), 1.0);
      }
   }

   public boolean requiresUpdateEveryTick() {
      return true;
   }

   public void tick() {
      super.tick();
      if (this.behavior == 1 || this.behavior == 2) {
         this.mob.heal(this.regenPerTick);
      }

      Vec3 origin = ((BlockPos)this.mob.getEntityData().get(BossEntity.ORIGIN)).getBottomCenter();
      if (!this.mob.blockPosition().closerToCenterThan(origin, 2.0)
         && this.mob.getNavigation().isDone()
         && !this.mob.getNavigation().moveTo(origin.x, origin.y, origin.z, (double)this.speed)) {
         this.mob.setPos(origin);
      }
   }

   public void stop() {
      super.stop();
      if (!this.mob.isRemoved()) {
         this.mob.setYRot(0.0F);
      }
   }
}
