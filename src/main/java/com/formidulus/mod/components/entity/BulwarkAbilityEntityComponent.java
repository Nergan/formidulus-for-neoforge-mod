package com.formidulus.mod.components.entity;

import com.formidulus.mod.components.FormidableComponents;
import com.formidulus.mod.entities.BulwarkEntity;
import com.formidulus.mod.item.abilities.ItemAbilities;
import com.formidulus.mod.item.abilities.ItemAbility;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class BulwarkAbilityEntityComponent implements IBulwarkComponent {
   Player provider;
   int bulwark = -1;
   float bulwarkYaw;

   public BulwarkAbilityEntityComponent(Player provider) {
      this.provider = provider;
   }

   @Override
   public void setBulwark(BulwarkEntity entity) {
      this.bulwark = entity == null ? -1 : entity.getId();
      this.bulwarkYaw = entity == null ? 0.0F : entity.getYRot();
      this.provider.syncData(FormidableComponents.BULWARK.get());
   }

   @Override
   public BulwarkEntity getBulwarkEntity() {
      if (this.bulwark == -1) {
         return null;
      } else {
         if (this.provider.level().getEntity(this.bulwark) instanceof BulwarkEntity b && b.getOwner().equals(this.provider)) {
            return b;
         }

         return null;
      }
   }

   @Override
   public boolean hasBulwark() {
      return this.bulwark > -1;
   }

   @Override
   public float getBulwarkYaw() {
      return this.bulwarkYaw;
   }

   @Override
   public void onBulwarkBreak() {
      if (!this.provider.level().isClientSide) {
         ItemStack active = this.provider.getUseItem();
         if (ItemAbility.hasAbility(active, ItemAbilities.BULWARK)) {
            this.provider.releaseUsingItem();
            this.provider.stopUsingItem();
            this.provider.getCooldowns().addCooldown(active.getItem(), 200);
         }
      }
   }

   public void readFromNbt(CompoundTag tag, Provider registryLookup) {
      if (tag.contains("Bulwark", 3)) {
         this.bulwark = tag.getInt("Bulwark");
      }

      if (tag.contains("BulwarkYaw", 5)) {
         this.bulwarkYaw = tag.getFloat("BulwarkYaw");
      }
   }

   public void writeToNbt(CompoundTag tag, Provider registryLookup) {
      tag.putInt("Bulwark", this.bulwark);
      tag.putFloat("BulwarkYaw", this.bulwarkYaw);
   }
}
