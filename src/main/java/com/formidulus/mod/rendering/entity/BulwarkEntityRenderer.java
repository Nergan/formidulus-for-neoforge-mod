package com.formidulus.mod.rendering.entity;

import com.formidulus.mod.FormidulusClient;
import com.formidulus.mod.entities.BulwarkEntity;
import com.formidulus.mod.rendering.equipment.BulwarkModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor.ARGB32;

public class BulwarkEntityRenderer extends EntityRenderer<BulwarkEntity> {
   final BulwarkModel model;

   public BulwarkEntityRenderer(Context ctx) {
      super(ctx);
      this.model = new BulwarkModel(ctx.bakeLayer(FormidulusClient.BULWARK_LAYER));
   }

   public ResourceLocation getTextureLocation(BulwarkEntity entity) {
      return BulwarkModel.TEXTURE;
   }

   public void render(BulwarkEntity entity, float yaw, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light) {
      super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
      LocalPlayer localPlayer = Minecraft.getInstance().player;
      if (localPlayer != null) {
         matrices.pushPose();
         matrices.mulPose(Axis.YP.rotationDegrees(180.0F - yaw));
         matrices.scale(-1.0F, -1.0F, 1.0F);
         matrices.translate(0.0, -1.5, 0.0);
         this.model.setupAnim(entity, 0.0F, 0.0F, (float)entity.tickCount + tickDelta, 0.0F, 0.0F);
         VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderType.entityTranslucent(BulwarkModel.TEXTURE));
         this.model
            .renderToBuffer(
               matrices,
               vertexConsumer,
               light,
               OverlayTexture.NO_OVERLAY,
               ARGB32.colorFromFloat(localPlayer.equals(entity.getOwner()) ? 0.5F : 1.0F, 1.0F, 1.0F, 1.0F)
            );
         matrices.popPose();
      }
   }
}
