package com.formidulus.mod.mixin.itemability;

import com.formidulus.mod.components.FormidableComponents;
import com.formidulus.mod.components.entity.IBulwarkComponent;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({LocalPlayer.class})
public abstract class ClientBulwarkAbilityPlayerMixin extends Player {
   @Shadow
   public float yBobO;
   @Shadow
   public float xBobO;
   @Shadow
   public float xBob;
   @Shadow
   public float yBob;

   public ClientBulwarkAbilityPlayerMixin(Level world, BlockPos pos, float yaw, GameProfile gameProfile) {
      super(world, pos, yaw, gameProfile);
   }

   @ModifyReturnValue(
      method = {"isShiftKeyDown()Z"},
      at = {@At("RETURN")}
   )
   boolean modifySneaking(boolean original) {
      IBulwarkComponent comp = FormidableComponents.bulwark(this);
      return original || comp.hasBulwark();
   }

   @Inject(
      method = {"serverAiStep()V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   void onTickNewAi(CallbackInfo ci) {
      IBulwarkComponent comp = FormidableComponents.bulwark(this);
      if (comp.getBulwarkEntity() != null && !comp.getBulwarkEntity().isRemoved()) {
         ci.cancel();
         this.yBobO = this.yBob;
         this.xBobO = this.xBob;
         this.xBob = this.xBob + (this.getXRot() - this.xBob) * 0.5F;
         this.yBob = this.yBob + (this.getYRot() - this.yBob) * 0.5F;
      }
   }

   @Inject(
      method = {"tickDeath()V"},
      at = {@At("HEAD")}
   )
   void onPostDeath(CallbackInfo ci) {
      IBulwarkComponent comp = FormidableComponents.bulwark(this);
      if (comp.hasBulwark()) {
         Minecraft.getInstance().gameRenderer.setRenderHand(true);
      }
   }
}
