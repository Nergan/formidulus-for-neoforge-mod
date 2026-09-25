package com.formidulus.mod.rendering.block;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.block.BossSpawnerBlockEntity;
import com.formidulus.mod.entities.boss.BossType;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.Font.DisplayMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import org.joml.Matrix4f;

public class BossSpawnerRenderer implements BlockEntityRenderer<BossSpawnerBlockEntity> {
   static final RandomSource random = RandomSource.create();
   BlockRenderDispatcher blockRenderer;
   Font textRenderer;
   static final Map<BossType, BakedModel> spawnerModels = new HashMap<>();
   static boolean modelsInitialized;

   public BossSpawnerRenderer(Context ctx) {
      this.blockRenderer = ctx.getBlockRenderDispatcher();
      this.textRenderer = ctx.getFont();
   }

   public void render(BossSpawnerBlockEntity spawner, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
      if (!modelsInitialized) {
         initSpawnerModels();
      }

      LocalPlayer distance = Minecraft.getInstance().player;
      if (distance instanceof Player && distance.isCreative()) {
         float distancex = (float)Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().distanceTo(spawner.getBlockPos().getCenter());
         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, Mth.clamp(distancex / 4.0F - 1.0F, 0.1F, 1.0F));
         this.blockRenderer
            .renderBatched(
               spawner.getBlockState(), spawner.getBlockPos(), spawner.getLevel(), matrices, vertexConsumers.getBuffer(RenderType.translucent()), true, random
            );
         if (spawner.getBossType() != null && distancex < 16.0F) {
            matrices.pushPose();
            matrices.translate(0.5F, 1.5F, 0.5F);
            matrices.scale(0.025F, -0.025F, -0.025F);
            Camera cam = Minecraft.getInstance().gameRenderer.getMainCamera();
            matrices.mulPose(Axis.YP.rotationDegrees(cam.getYRot() - 180.0F));
            matrices.mulPose(Axis.XP.rotationDegrees(-cam.getXRot()));
            Matrix4f matrix = matrices.last().pose();
            Component t = Component.nullToEmpty(spawner.getBossType().id().toString());
            this.textRenderer
               .drawInBatch(
                  t, (float)(-this.textRenderer.width(t)) / 2.0F, 0.0F, 16777215, false, matrix, vertexConsumers, DisplayMode.NORMAL, -2013265920, 15728880
               );
            matrices.popPose();
         }

         RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      }

      if (spawnerModels.containsKey(spawner.getBossType()) && spawnerModels.get(spawner.getBossType()) instanceof BakedModel model) {
         this.blockRenderer
            .getModelRenderer()
            .tesselateBlock(
               spawner.getLevel(),
               model,
               spawner.getBlockState(),
               spawner.getBlockPos(),
               matrices,
               vertexConsumers.getBuffer(RenderType.solid()),
               false,
               random,
               0L,
               OverlayTexture.NO_OVERLAY
            );
      }
   }

   public static void initSpawnerModels() {
      ModelManager manager = Minecraft.getInstance().getModelManager();
      BossType.getAllTypes().forEach((id, type) -> {
         if (!type.spawnerModel().isEmpty()) {
            spawnerModels.put(BossType.DEER, manager.getModel(new net.minecraft.client.resources.model.ModelResourceLocation(Formidulus.identifier("block/" + type.spawnerModel()), "standalone")));
         }
      });
   }
}
