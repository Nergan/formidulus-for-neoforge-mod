package com.formidulus.mod.item.abilities;

import com.formidulus.mod.damage.DamageSources;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class SoulStealAbility extends VampirismAbility {
   public SoulStealAbility(ResourceLocation id) {
      super(id);
   }

   @Override
   public MutableComponent getNameText() {
      return super.getNameText().setStyle(STYLE.withColor(ChatFormatting.AQUA));
   }

   @Override
   public int getDescriptionLines() {
      return 3;
   }

   @Override
   public void onDamageEntity(ItemStack stack, LivingEntity attacker, DamageSource source, float damage, LivingEntity target) {
      if (!source.is(DamageSources.SOUL)) {
         super.onDamageEntity(stack, attacker, source, damage, target);
         target.invulnerableTime = 0;
         target.hurt(DamageSources.get(attacker.level(), DamageSources.SOUL, attacker), 2.0F);
      }
   }

   @Override
   protected float getHealMultiplier() {
      return 0.4F;
   }
}
