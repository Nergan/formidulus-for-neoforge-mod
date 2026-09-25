package com.formidulus.mod.mixin;

import com.formidulus.mod.registries.StatusEffectRegistry;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.FogRenderer.FogMode;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({FogRenderer.class})
public abstract class BackgroundRendererMixin {
   @Shadow
   private static float fogRed;
   @Shadow
   private static float fogGreen;
   @Shadow
   private static float fogBlue;

   @Inject(
      method = {"setupFog(Lnet/minecraft/client/Camera;Lnet/minecraft/client/renderer/FogRenderer$FogMode;FZF)V"},
      at = {@At(
         value = "JUMP",
         ordinal = 11
      )},
      cancellable = true
   )
   private static void modifyGetFogModifier(
      Camera camera, FogMode fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci, @Local Entity entity
   ) {
      if (entity instanceof LivingEntity living && living.hasEffect(StatusEffectRegistry.DARKNESS)) {
         MobEffectInstance effect = living.getEffect(StatusEffectRegistry.DARKNESS);
         if (effect == null) {
            return;
         }

         float f = 1.0F - Math.min(1.0F, (float)effect.getDuration() / 30.0F);
         RenderSystem.setShaderFogStart(fogType == FogMode.FOG_SKY ? 0.0F : 4.0F + f * 16.0F);
         RenderSystem.setShaderFogEnd(18.0F + f * viewDistance);
         RenderSystem.setShaderFogShape(FogShape.CYLINDER);
         fogRed = Math.max(f, 0.05F);
         fogGreen = f;
         fogBlue = Math.max(f, 0.03F);
         RenderSystem.clearColor(fogRed, fogGreen, fogBlue, 0.0F);
         RenderSystem.setShaderFogColor(fogRed, fogGreen, fogBlue);
         ci.cancel();
      }
   }

   @WrapOperation(
      method = {"setupColor(Lnet/minecraft/client/Camera;FLnet/minecraft/client/multiplayer/ClientLevel;IF)V"},
      at = {@At(
         value = "INVOKE",
         target = "Lcom/mojang/blaze3d/systems/RenderSystem;clearColor(FFFF)V"
      )}
   )
   private static void modifyGetSkyColor(float red, float green, float blue, float alpha, Operation<Void> original, @Local(argsOnly = true) Camera camera) {
      if (camera.getEntity() instanceof LivingEntity living && living.hasEffect(StatusEffectRegistry.DARKNESS)) {
         original.call(new Object[]{0.0F, 0.0F, 0.0F, 0.0F});
         return;
      }

      original.call(new Object[]{red, green, blue, alpha});
   }
}
