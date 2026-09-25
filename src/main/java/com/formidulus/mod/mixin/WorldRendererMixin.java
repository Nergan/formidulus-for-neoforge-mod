package com.formidulus.mod.mixin;

import com.formidulus.mod.registries.StatusEffectRegistry;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({LevelRenderer.class})
public class WorldRendererMixin {
   @ModifyReturnValue(
      method = {"doesMobEffectBlockSky(Lnet/minecraft/client/Camera;)Z"},
      at = {@At("RETURN")}
   )
   boolean modifyHasBlindnessOrDarkness(boolean original, @Local(argsOnly = true) Camera cam) {
      if (original) {
         return true;
      } else {
         if (cam.getEntity() instanceof LivingEntity living && living.hasEffect(StatusEffectRegistry.DARKNESS)) {
            return true;
         }

         return false;
      }
   }
}
