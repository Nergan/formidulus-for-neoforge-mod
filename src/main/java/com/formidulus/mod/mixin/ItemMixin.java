package com.formidulus.mod.mixin;

import com.formidulus.mod.item.components.AbilityComponent;
import com.formidulus.mod.registries.DataComponentRegistry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Item.class})
public class ItemMixin {
   @Inject(
      method = {"use(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/InteractionResultHolder;"},
      at = {@At("TAIL")},
      cancellable = true
   )
   void onUse(Level world, Player user, InteractionHand hand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
      if (user.getItemInHand(hand).get(DataComponentRegistry.ABILITY) instanceof AbilityComponent component) {
         component.ability()
            .onUse(user.getItemInHand(hand), user, hand, (InteractionResultHolder<ItemStack>)cir.getReturnValue())
            .ifPresent(cir::setReturnValue);
      }
   }

   @Inject(
      method = {"onUseTick(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;I)V"},
      at = {@At("TAIL")}
   )
   void onUseTick(Level world, LivingEntity user, ItemStack stack, int remainingUseTicks, CallbackInfo ci) {
      if (stack.get(DataComponentRegistry.ABILITY) instanceof AbilityComponent component) {
         component.ability().onTickUsing(stack, user, user.getUsedItemHand());
      }
   }

   @Inject(
      method = {"releaseUsing(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/LivingEntity;I)V"},
      at = {@At("TAIL")}
   )
   void onStopUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks, CallbackInfo ci) {
      if (stack.get(DataComponentRegistry.ABILITY) instanceof AbilityComponent component) {
         component.ability().onStopUsing(stack, user, user.getUsedItemHand());
      }
   }

   @Inject(
      method = {"useOn(Lnet/minecraft/world/item/context/UseOnContext;)Lnet/minecraft/world/InteractionResult;"},
      at = {@At("TAIL")},
      cancellable = true
   )
   void onUseOnBlock(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
      if (context.getItemInHand().get(DataComponentRegistry.ABILITY) instanceof AbilityComponent component) {
         component.ability().onUseOnBlock(context.getItemInHand(), context, (InteractionResult)cir.getReturnValue()).ifPresent(cir::setReturnValue);
      }
   }

   @Inject(
      method = {"interactLivingEntity(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/InteractionResult;"},
      at = {@At("TAIL")},
      cancellable = true
   )
   void onUseOnEntity(ItemStack stack, Player user, LivingEntity entity, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
      if (stack.get(DataComponentRegistry.ABILITY) instanceof AbilityComponent component) {
         component.ability().onUseOnEntity(stack, user, entity, hand, (InteractionResult)cir.getReturnValue()).ifPresent(cir::setReturnValue);
      }
   }
}
