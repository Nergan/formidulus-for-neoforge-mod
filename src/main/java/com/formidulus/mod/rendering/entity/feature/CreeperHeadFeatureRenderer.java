package com.formidulus.mod.rendering.entity.feature;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.item.ItemDisplayContext;

public class CreeperHeadFeatureRenderer extends RenderLayer<Creeper, CreeperModel<Creeper>> {
   public CreeperHeadFeatureRenderer(RenderLayerParent<Creeper, CreeperModel<Creeper>> context) {
      super(context);
   }

   public void render(
      PoseStack matrices,
      MultiBufferSource vertexConsumers,
      int light,
      Creeper entity,
      float limbAngle,
      float limbDistance,
      float tickDelta,
      float animationProgress,
      float headYaw,
      float headPitch
   ) {
      matrices.pushPose();
      matrices.translate(0.0F, 0.4F, 0.0F);
      matrices.mulPose(Axis.YP.rotationDegrees(headYaw));
      matrices.mulPose(Axis.XP.rotationDegrees(headPitch));
      matrices.translate(0.0F, -0.35F, Math.max(headPitch / 90.0F, 0.0F) * 0.04F);
      matrices.scale(0.6F, -0.6F, 0.6F);
      Minecraft.getInstance()
         .getItemRenderer()
         .renderStatic(
            entity,
            entity.getItemBySlot(EquipmentSlot.HEAD),
            ItemDisplayContext.HEAD,
            false,
            matrices,
            vertexConsumers,
            entity.level(),
            light,
            OverlayTexture.NO_OVERLAY,
            1
         );
      matrices.popPose();
   }
}
