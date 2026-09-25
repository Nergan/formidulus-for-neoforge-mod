package com.formidulus.mod.entities.goal;

import com.formidulus.mod.entities.ServantEntity;
import java.util.EnumSet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;

public class ServantTargetGoal extends Goal {
   final ServantEntity mob;

   public ServantTargetGoal(ServantEntity mob) {
      this.mob = mob;
      this.setFlags(EnumSet.of(Flag.TARGET));
   }

   public boolean canUse() {
      LivingEntity target = this.mob.getTarget();
      if (target != null && (target.isDeadOrDying() || target.isRemoved())) {
         this.mob.setTarget(null);
      }

      return this.mob.hasMaster() && this.mob.getMaster().isActive() && target == null;
   }

   public void start() {
      super.start();
      if (!this.mob.getMaster().getAllTargets().isEmpty()) {
         this.mob.setTarget(this.mob.getMaster().getRandomTarget());
      }
   }
}
