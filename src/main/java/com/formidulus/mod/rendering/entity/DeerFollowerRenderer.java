package com.formidulus.mod.rendering.entity;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.FormidulusClient;
import com.formidulus.mod.entities.DeerFollowerEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Pose;

public class DeerFollowerRenderer extends MobRenderer<DeerFollowerEntity, DeerFollowerModel> {
   static final ResourceLocation TEX = Formidulus.identifier("textures/entity/deer_follower");

   public DeerFollowerRenderer(Context context) {
      super(context, new DeerFollowerModel(context.bakeLayer(FormidulusClient.DEER_FOLLOWER_LAYER)), 0.25F);
      this.addLayer(
         new ItemInHandLayer<DeerFollowerEntity, DeerFollowerModel>(this, context.getItemInHandRenderer()) {
            public void render(
               PoseStack matrixStack,
               MultiBufferSource vertexConsumerProvider,
               int i,
               DeerFollowerEntity entity,
               float f,
               float g,
               float h,
               float j,
               float k,
               float l
            ) {
               if (entity.isArmsVisible() && !entity.isWorshipping()) {
                  super.render(matrixStack, vertexConsumerProvider, i, entity, f, g, h, j, k, l);
               }
            }
         }
      );
   }

   public ResourceLocation getTextureLocation(DeerFollowerEntity entity) {
      return TEX.withSuffix(entity.getVariant() + ".png");
   }

   public void render(DeerFollowerEntity mob, float f, float g, PoseStack matrices, MultiBufferSource vertexConsumerProvider, int i) {
      matrices.pushPose();
      if (mob.getPose().equals(Pose.SITTING)) {
         matrices.translate(0.0F, -0.5F, 0.0F);
      }

      super.render(mob, f, g, matrices, vertexConsumerProvider, i);
      matrices.popPose();
   }
}
