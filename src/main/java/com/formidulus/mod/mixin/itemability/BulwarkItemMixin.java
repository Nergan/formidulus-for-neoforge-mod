package com.formidulus.mod.mixin.itemability;

import com.formidulus.mod.item.abilities.ItemAbilities;
import com.formidulus.mod.item.abilities.ItemAbility;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({Item.class})
public class BulwarkItemMixin {
   @ModifyReturnValue(
      method = {"getUseAnimation(Lnet/minecraft/world/item/ItemStack;)Lnet/minecraft/world/item/UseAnim;"},
      at = {@At("RETURN")}
   )
   UseAnim onGetUseAction(UseAnim original, @Local(argsOnly = true) ItemStack stack) {
      return ItemAbility.hasAbility(stack, ItemAbilities.BULWARK) ? UseAnim.BLOCK : original;
   }
}
