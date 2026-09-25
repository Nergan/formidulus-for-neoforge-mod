package com.formidulus.mod.rendering.equipment;

import com.formidulus.mod.FormidulusClient;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class BulwarkItemRenderer extends BlockEntityWithoutLevelRenderer {
   BulwarkModel model;

   public BulwarkItemRenderer() {
      super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
   }

   @Override
   public void renderByItem(ItemStack stack, ItemDisplayContext mode, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
      if (this.model == null) {
         this.model = new BulwarkModel(Minecraft.getInstance().getEntityModels().bakeLayer(FormidulusClient.BULWARK_LAYER));
      }

      matrices.pushPose();
      if (!mode.equals(ItemDisplayContext.GUI)) {
         matrices.translate(0.0F, 0.15F, 0.0F);
      }

      matrices.translate(0.5, 0.0, 0.96);
      matrices.translate(0.0, 1.5, 0.0);
      matrices.scale(1.0F, -1.0F, 1.0F);
      this.model.renderToBuffer(matrices, vertexConsumers.getBuffer(RenderType.entityCutoutNoCull(BulwarkModel.TEXTURE)), light, overlay);
      matrices.popPose();
   }
}
