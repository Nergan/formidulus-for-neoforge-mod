package com.formidulus.mod.rendering.entity;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.FormidulusClient;
import com.formidulus.mod.entities.DeerGodEntity;
import com.formidulus.mod.rendering.entity.feature.DeerGodEmissiveRenderFeature;
import com.formidulus.mod.rendering.entity.feature.DeerGodEyesRenderFeature;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class DeerGodRenderer extends MobRenderer<DeerGodEntity, DeerGodModel> {
   static final ResourceLocation TEX = Formidulus.identifier("textures/entity/deer_god.png");

   public DeerGodRenderer(Context ctx) {
      super(ctx, new DeerGodModel(ctx.bakeLayer(FormidulusClient.DEER_GOD_LAYER)), 1.0F);
      this.addLayer(new DeerGodEmissiveRenderFeature(this));
      this.addLayer(new DeerGodEyesRenderFeature(this));
   }

   public ResourceLocation getTextureLocation(DeerGodEntity entity) {
      return TEX;
   }

   public void render(DeerGodEntity livingEntity, float f, float tickDelta, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i) {
      float vanishing = livingEntity.getVanishingPercent();
      if (!(vanishing >= 0.9F)) {
         float c = Math.max(1.0F - vanishing * 2.0F, 0.0F);
         RenderSystem.setShaderColor(c, c, c, Math.min(1.0F - (vanishing * 6.0F - 4.0F), 1.0F));
         super.render(livingEntity, f, tickDelta, matrixStack, vertexConsumerProvider, i);
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      }
   }

   @Nullable
   protected RenderType getRenderLayer(DeerGodEntity entity, boolean showBody, boolean translucent, boolean showOutline) {
      return RenderType.entityTranslucent(this.getTextureLocation(entity));
   }
}
