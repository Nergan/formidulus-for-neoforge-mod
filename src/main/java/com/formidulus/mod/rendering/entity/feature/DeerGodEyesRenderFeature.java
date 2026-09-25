package com.formidulus.mod.rendering.entity.feature;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.entities.DeerGodEntity;
import com.formidulus.mod.rendering.entity.DeerGodModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor.ARGB32;

public class DeerGodEyesRenderFeature extends RenderLayer<DeerGodEntity, DeerGodModel> {
   static final ResourceLocation TEX = Formidulus.identifier("textures/entity/deer_god_eyes.png");

   public DeerGodEyesRenderFeature(RenderLayerParent<DeerGodEntity, DeerGodModel> context) {
      super(context);
   }

   public void render(
      PoseStack matrices,
      MultiBufferSource vertexConsumers,
      int light,
      DeerGodEntity entity,
      float limbAngle,
      float limbDistance,
      float tickDelta,
      float animationProgress,
      float headYaw,
      float headPitch
   ) {
      if (!entity.isInvisible()) {
         DeerGodModel model = (DeerGodModel)this.getParentModel();
         model.prepareMobModel(entity, limbAngle, limbDistance, tickDelta);
         int c = ARGB32.color((int)(255.0F * entity.getEyeGlow()), 255, 255, 255);
         model.root().render(matrices, vertexConsumers.getBuffer(RenderType.entityTranslucentEmissive(TEX)), 240, OverlayTexture.NO_OVERLAY, c);
      }
   }
}
