package com.formidulus.mod.mixin;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.gui.TitleHUD;
import com.formidulus.mod.registries.StatusEffectRegistry;
import com.formidulus.mod.registries.TagRegistry;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Gui.class})
public class InGameHudMixin {
   @Unique
   private static final ResourceLocation DEER_EFFECT_TEX = Formidulus.identifier("textures/gui/deer_effect_background_hud.png");
   @Unique
   private static final ResourceLocation DEER_EFFECT_AMBIENT_TEX = Formidulus.identifier("textures/gui/deer_effect_background_hud_ambient.png");
   @Unique
   float cinematicBars;

   @Inject(
      method = {"renderTitle(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/client/DeltaTracker;)V"},
      at = {@At("HEAD")}
   )
   private void init(GuiGraphics context, DeltaTracker tickCounter, CallbackInfo ci) {
      TitleHUD.render(context, tickCounter.getGameTimeDeltaTicks());
      LocalPlayer var5 = Minecraft.getInstance().player;
      if (var5 instanceof LivingEntity && var5.hasEffect(StatusEffectRegistry.REVERENCE)) {
         this.cinematicBars = Math.min(this.cinematicBars + tickCounter.getGameTimeDeltaPartialTick(true) / 20.0F, 1.0F);
      } else if (this.cinematicBars > 0.0F) {
         this.cinematicBars = Math.max(this.cinematicBars - tickCounter.getGameTimeDeltaPartialTick(true) / 5.0F, 0.0F);
      }

      if (this.cinematicBars > 0.0F) {
         context.fill(0, 0, context.guiWidth(), (int)(50.0F * this.cinematicBars), -16777216);
         int y = context.guiHeight();
         context.fill(0, (int)((float)y - 50.0F * this.cinematicBars), context.guiWidth(), y, -16777216);
      }
   }

   @WrapOperation(
      method = {"renderEffects(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/client/DeltaTracker;)V"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V"
      )}
   )
   void onDrawStatusEffectBackground(
      GuiGraphics context, ResourceLocation texture, int x, int y, int width, int height, Operation<Void> original, @Local MobEffectInstance effect
   ) {
      if (effect.getEffect().is(TagRegistry.DEER_EFFECTS)) {
         if (effect.isAmbient()) {
            context.blit(DEER_EFFECT_AMBIENT_TEX, x, y, 0.0F, 0.0F, 24, 24, 24, 24);
         } else {
            context.blit(DEER_EFFECT_TEX, x, y, 0.0F, 0.0F, 24, 24, 24, 24);
         }
      } else {
         original.call(new Object[]{context, texture, x, y, width, height});
      }
   }
}
