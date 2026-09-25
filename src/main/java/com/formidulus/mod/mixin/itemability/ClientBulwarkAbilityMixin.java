package com.formidulus.mod.mixin.itemability;

import com.formidulus.mod.item.abilities.BulwarkAbility;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({BulwarkAbility.class})
public class ClientBulwarkAbilityMixin {
   @Inject(
      method = {"onUse(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/InteractionResultHolder;)Ljava/util/Optional;"},
      at = {@At("HEAD")}
   )
   void onStartUsing(
      ItemStack stack,
      LivingEntity user,
      InteractionHand hand,
      InteractionResultHolder<ItemStack> result,
      CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir
   ) {
      if (user != null && user.equals(Minecraft.getInstance().player)) {
         Minecraft.getInstance().gameRenderer.setRenderHand(false);
      }
   }

   @Inject(
      method = {"onStopUsing(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/InteractionHand;)V"},
      at = {@At("HEAD")}
   )
   void onStopUsing(ItemStack stack, LivingEntity user, InteractionHand hand, CallbackInfo ci) {
      if (user != null && user.equals(Minecraft.getInstance().player)) {
         Minecraft.getInstance().gameRenderer.setRenderHand(true);
      }
   }
}
