package com.formidulus.mod.entities.goal;

import net.minecraft.world.entity.ai.goal.Goal;

public abstract class InterruptableGoal extends Goal {
   public static final byte FORCE_STOP = -1;
   public static final byte BULWARK = 100;
   byte interruptReason;

   public void start() {
      super.start();
      this.interruptReason = 0;
   }

   public void forceStop() {
      this.interruptReason = -1;
      this.stop();
   }

   public void interrupt(byte reason) {
      if (this.tryInterrupt(reason)) {
         this.interruptReason = reason;
      }
   }

   public boolean wasForceStopped() {
      return this.interruptReason == -1;
   }

   protected boolean tryInterrupt(byte reason) {
      return false;
   }
}
