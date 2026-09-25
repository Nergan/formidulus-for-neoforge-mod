package com.formidulus.mod.rendering.equipment;

import com.formidulus.mod.Formidulus;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class DeerGodSkullModel extends Model {
   public static final ResourceLocation TEXTURE = Formidulus.identifier("textures/entity/deer_god.png");
   private final ModelPart root;

   public DeerGodSkullModel(ModelPart root) {
      super(RenderType::entityCutout);
      this.root = root;
   }

   public static LayerDefinition getTexturedModelData() {
      MeshDefinition modelData = new MeshDefinition();
      PartDefinition modelPartData = modelData.getRoot();
      PartDefinition head = modelPartData.addOrReplaceChild(
         "head",
         CubeListBuilder.create()
            .texOffs(2, 0)
            .addBox(-5.5F, -10.0F, -10.0F, 11.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
            .texOffs(0, 18)
            .addBox(-4.5F, -2.0F, -10.0F, 9.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
            .texOffs(38, 18)
            .addBox(-4.5F, -3.0F, -10.0F, 9.0F, 3.0F, 10.0F, new CubeDeformation(-0.2F))
            .texOffs(44, 0)
            .addBox(-5.5F, -10.0F, -10.0F, 11.0F, 8.0F, 10.0F, new CubeDeformation(-0.2F))
            .texOffs(34, 0)
            .addBox(-4.5F, -9.0F, -10.0F, 9.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(0, 31)
            .addBox(-3.5F, -2.0F, -12.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(10, 35)
            .addBox(-2.5F, -2.0F, -17.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
            .texOffs(30, 35)
            .addBox(-2.5F, 0.0F, -15.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
            .texOffs(18, 30)
            .addBox(-3.5F, 0.0F, -12.0F, 7.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, 24.0F, 8.0F)
      );
      head.addOrReplaceChild(
         "cube_r1",
         CubeListBuilder.create().texOffs(88, -20).mirror().addBox(0.0F, -18.0F, -4.0F, 0.0F, 21.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false),
         PartPose.offsetAndRotation(6.75F, -11.75F, 0.25F, -0.3847F, 0.9575F, -0.3139F)
      );
      head.addOrReplaceChild(
         "cube_r2",
         CubeListBuilder.create().texOffs(0, 6).mirror().addBox(0.0F, -0.9962F, -0.0872F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
         PartPose.offsetAndRotation(2.4735F, -10.0529F, -2.9516F, -0.1723F, 0.0129F, 0.1745F)
      );
      head.addOrReplaceChild(
         "cube_r3",
         CubeListBuilder.create().texOffs(88, -20).addBox(0.0F, -18.0F, -4.0F, 0.0F, 21.0F, 20.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(-6.75F, -11.75F, 0.25F, -0.3847F, -0.9575F, 0.3139F)
      );
      head.addOrReplaceChild(
         "cube_r4",
         CubeListBuilder.create().texOffs(0, 6).addBox(-3.0F, -0.9962F, -0.0872F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(-2.4735F, -10.0529F, -2.9516F, -0.1723F, -0.0129F, -0.1745F)
      );
      return LayerDefinition.create(modelData, 128, 128);
   }

   public void renderToBuffer(PoseStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
      this.root.render(matrices, vertices, light, overlay, color);
   }
}
