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

public class JollyHatModel extends Model {
   public static final ResourceLocation TEXTURE = Formidulus.identifier("textures/item/jolly_cap.png");
   private final ModelPart root;
   private final ModelPart tip;
   private final ModelPart bone;

   public JollyHatModel(ModelPart root) {
      super(RenderType::entityCutout);
      this.root = root.getChild("root");
      this.tip = this.root.getChild("tip");
      this.bone = this.tip.getChild("bone");
   }

   public static LayerDefinition getTexturedModelData() {
      MeshDefinition modelData = new MeshDefinition();
      PartDefinition modelPartData = modelData.getRoot();
      PartDefinition root = modelPartData.addOrReplaceChild(
         "root",
         CubeListBuilder.create()
            .texOffs(0, 15)
            .addBox(-5.0F, -3.0F, -5.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.25F))
            .texOffs(0, 29)
            .addBox(-5.0F, -4.115F, -5.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.25F))
            .texOffs(30, 33)
            .addBox(-5.0F, -5.23F, -5.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.25F))
            .texOffs(0, 0)
            .addBox(-5.0F, -5.0F, -5.0F, 10.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
            .texOffs(40, 0)
            .addBox(-5.0F, -5.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(-0.25F)),
         PartPose.offset(0.0F, 23.0F, 0.0F)
      );
      PartDefinition tip = root.addOrReplaceChild(
         "tip",
         CubeListBuilder.create().texOffs(31, 20).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.25F)),
         PartPose.offset(0.0F, -5.2F, -4.0F)
      );
      PartDefinition bone = tip.addOrReplaceChild(
         "bone",
         CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.5F, 0.2F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, 1.0F, 8.0F)
      );
      return LayerDefinition.create(modelData, 128, 128);
   }

   public void renderToBuffer(PoseStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
      this.root.render(matrices, vertices, light, overlay);
   }
}
