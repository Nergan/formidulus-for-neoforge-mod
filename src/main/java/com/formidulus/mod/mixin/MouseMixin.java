package com.formidulus.mod.mixin;

import com.formidulus.mod.entities.BossEntity;
import com.formidulus.mod.registries.StatusEffectRegistry;
import com.formidulus.mod.util.RotationUtil;
import com.mojang.blaze3d.Blaze3D;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.SmoothDouble;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityTypeTest;
import org.joml.Vector2f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({MouseHandler.class})
public abstract class MouseMixin {
   @Shadow
   @Final
   private SmoothDouble smoothTurnX;
   @Shadow
   @Final
   private SmoothDouble smoothTurnY;
   @Unique
   float lastTickTime;

   @Shadow
   public abstract boolean isMouseGrabbed();

   @Shadow
   protected abstract void turnPlayer(double var1);

   @Inject(
      method = {"handleAccumulatedMovement()V"},
      at = {@At("TAIL")}
   )
   void onTick(CallbackInfo ci) {
      double time = Blaze3D.getTime();
      double timeDelta = time - (double)this.lastTickTime;
      this.lastTickTime = (float)time;
      if (!this.isMouseGrabbed()) {
         LocalPlayer var7 = Minecraft.getInstance().player;
         if (var7 instanceof LocalPlayer && var7.hasEffect(StatusEffectRegistry.REVERENCE)) {
            this.turnPlayer(timeDelta);
         }
      }
   }

   @Inject(
      method = {"turnPlayer(D)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   void onUpdateMouse(double timeDelta, CallbackInfo ci) {
      LocalPlayer world = Minecraft.getInstance().player;
      if (world instanceof LocalPlayer && world.hasEffect(StatusEffectRegistry.REVERENCE)) {
         Level worldx = world.level();
         if (world.hasEffect(StatusEffectRegistry.REVERENCE)) {
            List<BossEntity> targets = worldx.getEntities(EntityTypeTest.forClass(BossEntity.class), world.getBoundingBox().inflate(32.0), i -> true);
            BossEntity closest = (BossEntity)worldx.getNearestEntity(
               targets, TargetingConditions.forNonCombat().selector(i -> true), world, world.getX(), world.getY(), world.getZ()
            );
            if (closest == null || closest.distanceTo(world) > 32.0F) {
               return;
            }

            Vector2f targetRot = RotationUtil.getRotationTowards(world.getEyePosition(), closest.getFocusPos());
            Vector2f rot = new Vector2f(world.getYRot(), world.getXRot());
            Vector2f diff = new Vector2f(targetRot).sub(rot);
            diff = new Vector2f(Mth.wrapDegrees(diff.x), Mth.wrapDegrees(diff.y));
            Vector2f dir = new Vector2f(diff.x, diff.y).normalize();
            if (diff.length() > 0.0F) {
               double dx = this.smoothTurnX.getNewDeltaValue((double)(dir.x * diff.length() * 0.33F), timeDelta * 10.0);
               double dy = this.smoothTurnY.getNewDeltaValue((double)(dir.y * diff.length() * 0.33F), timeDelta * 10.0);
               world.turn(dx, dy);
            }
         }

         ci.cancel();
      }
   }
}
