package com.formidulus.mod.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public abstract class ServantEntity extends Monster {
   BossEntity master;

   protected ServantEntity(EntityType<? extends Monster> entityType, Level world) {
      super(entityType, world);
   }

   public BossEntity getMaster() {
      return this.master;
   }

   public void setMaster(BossEntity master) {
      this.master = master;
   }

   public boolean hasMaster() {
      return this.master != null;
   }
}
