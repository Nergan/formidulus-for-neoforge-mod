package com.formidulus.mod.rendering.equipment;

import com.formidulus.mod.FormidulusClient;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class JollyHatRenderer extends BlockEntityWithoutLevelRenderer {
   JollyHatModel model;

   public JollyHatRenderer() {
      super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
   }

   @Override
   public void renderByItem(ItemStack stack, ItemDisplayContext mode, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
      if (this.model == null) {
         this.model = new JollyHatModel(Minecraft.getInstance().getEntityModels().bakeLayer(FormidulusClient.JOLLY_HAT_LAYER));
      }

      matrices.pushPose();
      matrices.translate(0.5, 1.475, 0.5);
      matrices.scale(1.0F, -1.0F, 1.0F);
      this.model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityCutoutNoCull(JollyHatModel.TEXTURE)), light, overlay);
      matrices.popPose();
   }
}
