package com.formidulus.mod.item.abilities;

import com.formidulus.mod.components.FormidableComponents;
import com.formidulus.mod.components.entity.IBulwarkComponent;
import com.formidulus.mod.entities.BulwarkEntity;
import com.formidulus.mod.registries.ItemRegistry;
import java.util.Optional;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class BulwarkAbility extends ItemAbility {
   public BulwarkAbility(ResourceLocation id) {
      super(id);
   }

   @Override
   public MutableComponent getNameText() {
      return super.getNameText().setStyle(STYLE.withColor(ChatFormatting.BLUE));
   }

   @Override
   public int getDescriptionLines() {
      return 3;
   }

   @Override
   public Optional<InteractionResultHolder<ItemStack>> onUse(
      ItemStack stack, LivingEntity user, InteractionHand hand, InteractionResultHolder<ItemStack> result
   ) {
      this.active = true;
      if (user instanceof Player player && !user.level().isClientSide) {
         IBulwarkComponent comp = FormidableComponents.bulwark(player);
         if (comp.getBulwarkEntity() == null) {
            comp.setBulwark(BulwarkEntity.place(player));
         }

         user.setShiftKeyDown(true);
      }

      return super.onUse(stack, user, hand, result);
   }

   @Override
   public void onStopUsing(ItemStack stack, LivingEntity user, InteractionHand hand) {
      super.onStopUsing(stack, user, hand);
      this.active = false;
      if (user instanceof Player player && !player.level().isClientSide) {
         IBulwarkComponent comp = FormidableComponents.bulwark(player);
         BulwarkEntity var7 = comp.getBulwarkEntity();
         if (var7 instanceof BulwarkEntity && var7.getCurrentAnimation() != 3) {
            var7.setAnimation((byte)3);
         }

         comp.setBulwark(null);
         user.setShiftKeyDown(false);
      }

      if (user instanceof Player player) {
         player.getCooldowns().addCooldown(ItemRegistry.BULWARK, 40);
      }
   }
}
