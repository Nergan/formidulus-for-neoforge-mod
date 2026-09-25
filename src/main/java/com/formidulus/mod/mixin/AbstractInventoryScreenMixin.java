package com.formidulus.mod.mixin;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.registries.TagRegistry;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({EffectRenderingInventoryScreen.class})
public class AbstractInventoryScreenMixin {
   @Unique
   private static final ResourceLocation DEER_EFFECT_WIDE_TEX = Formidulus.identifier("textures/gui/deer_effect_background_wide.png");
   @Unique
   private static final ResourceLocation DEER_EFFECT_SMOL_TEX = Formidulus.identifier("textures/gui/deer_effect_background_smol.png");

   @WrapOperation(
      method = {"renderBackgrounds(Lnet/minecraft/client/gui/GuiGraphics;IILjava/lang/Iterable;Z)V"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V"
      )}
   )
   void onDrawStatusEffectBackground(
      GuiGraphics context,
      ResourceLocation texture,
      int x,
      int y,
      int width,
      int height,
      Operation<Void> original,
      @Local MobEffectInstance effect,
      @Local(argsOnly = true) boolean wide
   ) {
      if (effect.getEffect().is(TagRegistry.DEER_EFFECTS)) {
         if (wide) {
            context.blit(DEER_EFFECT_WIDE_TEX, x, y, 0.0F, 0.0F, 145, 32, 145, 32);
         } else {
            context.blit(DEER_EFFECT_SMOL_TEX, x, y, 0.0F, 0.0F, 32, 32, 32, 32);
         }
      } else {
         original.call(new Object[]{context, texture, x, y, width, height});
      }
   }

   @WrapOperation(
      method = {"renderLabels(Lnet/minecraft/client/gui/GuiGraphics;IILjava/lang/Iterable;)V"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/GuiGraphics;drawString(Lnet/minecraft/client/gui/Font;Lnet/minecraft/network/chat/Component;III)I"
      )}
   )
   int onDrawStatusEffectDescription(
      GuiGraphics context, Font textRenderer, Component text, int x, int y, int color, Operation<Integer> original, @Local MobEffectInstance effect
   ) {
      return effect.getEffect().is(TagRegistry.DEER_EFFECTS)
         ? (Integer)original.call(new Object[]{context, textRenderer, text, x, y + 2, color})
         : (Integer)original.call(new Object[]{context, textRenderer, text, x, y, color});
   }
}
