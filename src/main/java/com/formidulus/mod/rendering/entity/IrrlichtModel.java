package com.formidulus.mod.rendering.entity;

import com.formidulus.mod.entities.IrrlichtEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class IrrlichtModel extends EntityModel<IrrlichtEntity> {
   private final ModelPart bb_main;

   public IrrlichtModel(ModelPart root) {
      this.bb_main = root.getChild("bb_main");
   }

   public static LayerDefinition getTexturedModelData() {
      MeshDefinition modelData = new MeshDefinition();
      PartDefinition modelPartData = modelData.getRoot();
      PartDefinition bb_main = modelPartData.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
      PartDefinition cube_r1 = bb_main.addOrReplaceChild(
         "cube_r1",
         CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, -3.0F, -1.0F, 0.0F, 2.3562F, 0.0F)
      );
      PartDefinition cube_r2 = bb_main.addOrReplaceChild(
         "cube_r2",
         CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, -3.0F, -1.0F, 0.0F, 0.7854F, 0.0F)
      );
      return LayerDefinition.create(modelData, 16, 16);
   }

   public void setupAnim(IrrlichtEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
   }

   public void renderToBuffer(PoseStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
      matrices.pushPose();
      matrices.translate(0.0F, 0.0F, 0.05F);
      this.bb_main.render(matrices, vertices, light, overlay, color);
      matrices.popPose();
   }
}
