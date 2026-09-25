package com.formidulus.mod.mixin;

import com.formidulus.mod.datagen.Lang;
import com.formidulus.mod.item.components.AbilityComponent;
import com.formidulus.mod.item.components.AccessoryComponent;
import com.formidulus.mod.item.components.DependencyInfoComponent;
import com.formidulus.mod.item.components.ExpandableLoreComponent;
import com.formidulus.mod.registries.DataComponentRegistry;
import com.formidulus.mod.registries.SoundRegistry;
import com.mojang.blaze3d.platform.InputConstants;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.TooltipContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Item.class})
public abstract class ClientItemMixin {
   @Inject(
      method = {"appendHoverText(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/Item$TooltipContext;Ljava/util/List;Lnet/minecraft/world/item/TooltipFlag;)V"},
      at = {@At("TAIL")}
   )
   void afterAppendToolTip(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag type, CallbackInfo ci) {
      if (stack.getComponents().has(DataComponentRegistry.DEPENDENCY_INFO)) {
         DependencyInfoComponent dependencyComponent = (DependencyInfoComponent)stack.getComponents().get(DataComponentRegistry.DEPENDENCY_INFO);
         if (dependencyComponent != null) {
            dependencyComponent.addToTooltip(context, tooltip::add, type);
         }
      } else {
         boolean displayLore = stack.has(DataComponentRegistry.EXPANDABLE_LORE) && this.shouldDisplayLore();
         AbilityComponent abilityComponent = null;
         if (stack.has(DataComponentRegistry.ABILITY)) {
            abilityComponent = (AbilityComponent)stack.getComponents().getOrDefault(DataComponentRegistry.ABILITY, AbilityComponent.DEFAULT);
            tooltip.add(abilityComponent.ability().getNameText());
         }

         if (stack.has(DataComponentRegistry.ACCESSORY) && !displayLore) {
            AccessoryComponent component = (AccessoryComponent)stack.getComponents().getOrDefault(DataComponentRegistry.ACCESSORY, AccessoryComponent.DEFAULT);
            int accessoryMode = component.activeMode() % component.modes().size();
            tooltip.add(
               Component.translatable(
                  Lang.ACCESSORY_MODE_PREFIX, new Object[]{Component.translatable("item.accessory_mode." + component.modes().get(accessoryMode))}
               )
            );
            tooltip.add(Component.translatable(Lang.ACCESSORY_MODE_HINT).setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
         }

         boolean hasAbilityDescription = abilityComponent != null && abilityComponent.ability().getDescriptionLines() > 0;
         if (stack.has(DataComponentRegistry.EXPANDABLE_LORE) || hasAbilityDescription) {
            if (this.shouldDisplayLore()) {
               if (hasAbilityDescription) {
                  tooltip.addAll(abilityComponent.ability().makeDescriptionLines());
                  tooltip.add(Component.empty());
               }

               if (stack.getComponents().get(DataComponentRegistry.EXPANDABLE_LORE) instanceof ExpandableLoreComponent component) {
                  tooltip.addAll(component.lines());
               }
            } else {
               tooltip.add(Component.translatable(Lang.EXPANDABLE_LORE_HINT).setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
            }
         }
      }
   }

   @Inject(
      method = {"overrideOtherStackedOnMe(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/inventory/Slot;Lnet/minecraft/world/inventory/ClickAction;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/entity/SlotAccess;)Z"},
      at = {@At("TAIL")},
      cancellable = true
   )
   void onClicked(
      ItemStack stack,
      ItemStack otherStack,
      Slot slot,
      ClickAction clickType,
      Player player,
      SlotAccess cursorStackReference,
      CallbackInfoReturnable<Boolean> cir
   ) {
      if (otherStack.isEmpty() && clickType != ClickAction.PRIMARY) {
         if (stack.has(DataComponentRegistry.ACCESSORY)) {
            cir.setReturnValue(true);
            if (stack.get(DataComponentRegistry.ACCESSORY) instanceof AccessoryComponent component) {
               stack.set(DataComponentRegistry.ACCESSORY, component.cycle());
            }

            if (!player.level().isClientSide && slot.index >= 5 && slot.index <= 8) {
               Holder<SoundEvent> sound = Holder.direct(SoundRegistry.ACCESSORY_CHANGE_MODE);
               if (stack.getItem() instanceof Equipable equipment) {
                  sound = equipment.getEquipSound();
               }

               player.level()
                  .playSeededSound(null, player.getX(), player.getY(), player.getZ(), sound, SoundSource.PLAYERS, 1.0F, 1.0F, player.getRandom().nextLong());
            }
         }
      }
   }

   @Unique
   boolean shouldDisplayLore() {
      long windowHandle = Minecraft.getInstance().getWindow().getWindow();
      return InputConstants.isKeyDown(windowHandle, 340) || InputConstants.isKeyDown(windowHandle, 344);
   }
}
