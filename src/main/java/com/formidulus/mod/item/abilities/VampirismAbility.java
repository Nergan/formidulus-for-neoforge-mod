package com.formidulus.mod.item.abilities;

import com.formidulus.mod.damage.DamageSources;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class VampirismAbility extends ItemAbility {
   public VampirismAbility(ResourceLocation id) {
      super(id);
   }

   @Override
   public MutableComponent getNameText() {
      return super.getNameText().copy().setStyle(STYLE.withColor(ChatFormatting.DARK_RED));
   }

   @Override
   public int getDescriptionLines() {
      return 1;
   }

   @Override
   public void onDamageEntity(ItemStack stack, LivingEntity attacker, DamageSource source, float damage, LivingEntity target) {
      if (source.is(DamageSources.SACRIFICE)) {
         attacker.heal(Math.min(damage, target.getMaxHealth()) * this.getHealMultiplier());
      }
   }

   protected float getHealMultiplier() {
      return 0.3F;
   }
}
