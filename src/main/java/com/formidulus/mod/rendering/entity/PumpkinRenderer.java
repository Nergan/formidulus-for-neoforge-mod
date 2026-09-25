package com.formidulus.mod.rendering.entity;

import com.formidulus.mod.entities.PumpkinProjectile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.phys.Vec3;

public class PumpkinRenderer extends ThrownItemRenderer<PumpkinProjectile> {
   public PumpkinRenderer(Context context) {
      super(context);
   }

   public void render(PumpkinProjectile entity, float yaw, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light) {
      matrices.pushPose();
      Vec3 dir = entity.getDeltaMovement().normalize();
      matrices.mulPose(Axis.YP.rotation((float)(-Math.atan2(dir.z, dir.x) - Math.toRadians(90.0))));
      matrices.mulPose(Axis.XP.rotation((float)Math.atan2(dir.y, Math.sqrt(1.0 - dir.y * dir.y))));
      Minecraft.getInstance()
         .getItemRenderer()
         .renderStatic(entity.getItem(), ItemDisplayContext.FIXED, 240, OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, entity.level(), entity.getId());
      matrices.popPose();
   }
}
