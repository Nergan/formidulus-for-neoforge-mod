package com.formidulus.mod.rendering.block;

import com.formidulus.mod.block.DeerSkullBlock;
import com.formidulus.mod.block.DeerSkullBlockEntity;
import com.formidulus.mod.registries.ItemRegistry;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.world.item.ItemDisplayContext;
import org.joml.Vector3f;

public class DeerSkullBlockEntityRenderer implements BlockEntityRenderer<DeerSkullBlockEntity> {
   BlockRenderDispatcher blockRenderer;
   ItemRenderer itemRenderer;

   public DeerSkullBlockEntityRenderer(Context ctx) {
      this.itemRenderer = ctx.getItemRenderer();
      this.blockRenderer = ctx.getBlockRenderDispatcher();
   }

   public void render(DeerSkullBlockEntity entity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
      matrices.pushPose();
      Direction dir = (Direction)entity.getBlockState().getValue(DeerSkullBlock.FACING);
      Vector3f offset = dir.getOpposite().step().mul(0.025F);
      matrices.translate(0.5F + offset.x, 0.4F, 0.5F + offset.z);
      boolean b = dir.getAxisDirection().equals(AxisDirection.POSITIVE);
      if (dir.getAxis().equals(Axis.X)) {
         matrices.mulPose(com.mojang.math.Axis.ZP.rotationDegrees(b ? -27.5F : 27.5F));
      } else {
         matrices.mulPose(com.mojang.math.Axis.XP.rotationDegrees(b ? 27.5F : -27.5F));
      }

      matrices.mulPose(com.mojang.math.Axis.YP.rotationDegrees(-dir.getOpposite().toYRot()));
      this.itemRenderer
         .renderStatic(ItemRegistry.DEER_SKULL.getDefaultInstance(), ItemDisplayContext.GROUND, light, overlay, matrices, vertexConsumers, entity.getLevel(), 0);
      matrices.popPose();
   }
}
