package com.formidulus.mod.rendering.entity.feature;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.entities.DeerGodEntity;
import com.formidulus.mod.rendering.entity.DeerGodModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class DeerGodEmissiveRenderFeature extends RenderLayer<DeerGodEntity, DeerGodModel> {
   static final ResourceLocation TEX = Formidulus.identifier("textures/entity/deer_god_emissive.png");
   int flickerTimer;
   boolean flicker;
   float brightness = 1.0F;

   public DeerGodEmissiveRenderFeature(RenderLayerParent<DeerGodEntity, DeerGodModel> context) {
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
         if (!Minecraft.getInstance().isPaused() && this.flickerTimer-- == 0) {
            if (entity.getRandom().nextFloat() < 0.4F) {
               this.brightness = 0.85F + entity.getRandom().nextFloat() * 0.05F;
            } else {
               this.brightness = 1.0F;
            }

            this.flickerTimer = (int)(2.0F + entity.getRandom().nextFloat() * 5.0F);
         }

         model.root()
            .render(matrices, vertexConsumers.getBuffer(RenderType.entityCutoutNoCull(TEX)), (int)(240.0F * this.brightness), OverlayTexture.NO_OVERLAY);
      }
   }
}
