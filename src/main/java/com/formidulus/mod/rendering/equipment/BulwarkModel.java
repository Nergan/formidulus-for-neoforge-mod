package com.formidulus.mod.rendering.equipment;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.entities.BulwarkEntity;
import com.formidulus.mod.rendering.entity.BulwarkAnimations;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class BulwarkModel extends HierarchicalModel<BulwarkEntity> {
   public static final ResourceLocation TEXTURE = Formidulus.identifier("textures/entity/bulwark.png");
   private final ModelPart root;

   public BulwarkModel(ModelPart root) {
      this.root = root.getChild("root");
   }

   public static LayerDefinition getTexturedModelData() {
      MeshDefinition modelData = new MeshDefinition();
      PartDefinition modelPartData = modelData.getRoot();
      modelPartData.addOrReplaceChild(
         "root",
         CubeListBuilder.create()
            .texOffs(15, 15)
            .addBox(-7.5F, -9.0F, -4.0F, 15.0F, 19.0F, 1.0F, new CubeDeformation(0.0F))
            .texOffs(47, 11)
            .addBox(-1.5F, -3.0F, -3.0F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
            .texOffs(13, 36)
            .addBox(-8.5F, 10.0F, -5.0F, 17.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(15, 43)
            .addBox(-8.5F, 15.0F, -4.0F, 17.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, 9.0F, -4.0F)
      );
      return LayerDefinition.create(modelData, 64, 64);
   }

   public void renderToBuffer(PoseStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
      this.root.render(matrices, vertices, light, overlay, color);
   }

   public ModelPart root() {
      return this.root;
   }

   public void setupAnim(BulwarkEntity entity, float limbAngle, float limbDistance, float ageInTicks, float headYaw, float headPitch) {
      this.root.getAllParts().forEach(ModelPart::resetPose);
      this.animate(entity.prePlaceAnimationState, BulwarkAnimations.prePlace, ageInTicks);
      this.animate(entity.placeAnimationState, BulwarkAnimations.place, ageInTicks);
      this.animate(entity.hitAnimationState, BulwarkAnimations.hit, ageInTicks);
      this.animate(entity.removeAnimationState, BulwarkAnimations.unplace, ageInTicks);
   }
}
