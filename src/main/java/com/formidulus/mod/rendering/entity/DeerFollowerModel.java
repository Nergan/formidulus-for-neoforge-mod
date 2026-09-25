package com.formidulus.mod.rendering.entity;

import com.formidulus.mod.entities.DeerFollowerEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.Pose;
import org.joml.Vector3f;

public class DeerFollowerModel extends HumanoidModel<DeerFollowerEntity> {
   private final ModelPart root;
   private final ModelPart crossedArms;
   private final ModelPart mask;
   private final ModelPart rightLegLower;
   private final ModelPart leftLegLower;
   private final ModelPart rightArmLower;
   private final ModelPart leftArmLower;

   public DeerFollowerModel(ModelPart root) {
      super(root);
      this.root = root;
      ModelPart body = root.getChild("body");
      ModelPart head = root.getChild("head");
      this.mask = head.getChild("mask");
      head.getChild("hood");
      ModelPart rightLeg = root.getChild("right_leg");
      this.rightLegLower = rightLeg.getChild("rightLegLower");
      ModelPart leftLeg = root.getChild("left_leg");
      this.leftLegLower = leftLeg.getChild("leftLegLower");
      this.crossedArms = body.getChild("crossedArms");
      ModelPart rightArm = root.getChild("right_arm");
      this.rightArmLower = rightArm.getChild("rightArmLower");
      ModelPart leftArm = root.getChild("left_arm");
      this.leftArmLower = leftArm.getChild("leftArmLower");
   }

   public static LayerDefinition getTexturedModelData() {
      MeshDefinition modelData = new MeshDefinition();
      PartDefinition root = modelData.getRoot();
      PartDefinition body = root.addOrReplaceChild(
         "body",
         CubeListBuilder.create()
            .texOffs(72, 16)
            .addBox(-4.0F, -0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
            .texOffs(0, 31)
            .addBox(-4.0F, -0.0F, -2.0F, 8.0F, 15.0F, 4.0F, new CubeDeformation(0.5F)),
         PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      PartDefinition head = root.addOrReplaceChild(
         "head",
         CubeListBuilder.create().texOffs(72, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.25F)),
         PartPose.offset(0.0F, -12.0F, 0.0F)
      );
      root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
      PartDefinition mask = head.addOrReplaceChild(
         "mask",
         CubeListBuilder.create()
            .texOffs(0, 16)
            .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
            .texOffs(0, 0)
            .addBox(-4.5F, 0.0F, 0.0F, 9.0F, 8.0F, 8.0F, new CubeDeformation(-0.15F))
            .texOffs(40, 27)
            .addBox(-2.5F, 6.0F, -5.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
            .texOffs(40, 35)
            .addBox(-2.5F, 8.0F, -4.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, -8.0F, -4.0F)
      );
      mask.addOrReplaceChild(
         "cube_r1",
         CubeListBuilder.create().texOffs(34, 0).addBox(0.0F, -8.0F, -4.0F, 0.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(5.325F, -1.85F, 8.3F, -0.3847F, 0.9575F, -0.3139F)
      );
      mask.addOrReplaceChild(
         "cube_r2",
         CubeListBuilder.create().texOffs(58, 20).addBox(0.0F, -0.9962F, -0.0872F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(1.5485F, -0.0529F, 5.0984F, -0.1723F, 0.0129F, 0.1745F)
      );
      mask.addOrReplaceChild(
         "cube_r3",
         CubeListBuilder.create().texOffs(60, 35).addBox(-3.0F, -0.9962F, -0.0872F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(-1.5485F, -0.0529F, 5.0984F, -0.1723F, -0.0129F, -0.1745F)
      );
      mask.addOrReplaceChild(
         "cube_r4",
         CubeListBuilder.create().texOffs(24, 31).addBox(0.0F, -8.0F, -4.0F, 0.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(-5.325F, -1.85F, 8.3F, -0.3847F, -0.9575F, 0.3139F)
      );
      head.addOrReplaceChild(
         "hood",
         CubeListBuilder.create().texOffs(0, 74).addBox(-4.5F, -8.0F, -4.0F, 9.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)),
         PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      PartDefinition rightLeg = root.addOrReplaceChild(
         "right_leg",
         CubeListBuilder.create().texOffs(72, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
         PartPose.offset(-2.0F, 0.0F, 0.0F)
      );
      rightLeg.addOrReplaceChild(
         "rightLegLower",
         CubeListBuilder.create().texOffs(72, 42).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, 6.0F, -2.0F)
      );
      PartDefinition leftLeg = root.addOrReplaceChild(
         "left_leg",
         CubeListBuilder.create().texOffs(88, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
         PartPose.offset(2.0F, 0.0F, 0.0F)
      );
      leftLeg.addOrReplaceChild(
         "leftLegLower",
         CubeListBuilder.create().texOffs(88, 42).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, 6.0F, -2.0F)
      );
      PartDefinition crossedArms = body.addOrReplaceChild("crossedArms", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 0.0F));
      crossedArms.addOrReplaceChild(
         "cube_r5",
         CubeListBuilder.create()
            .texOffs(54, 42)
            .addBox(-1.5F, -0.0125F, -4.0217F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
            .texOffs(40, 42)
            .addBox(-12.5F, -0.0125F, -4.0217F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(5.5F, -7.9783F, 2.0125F, -0.7854F, 0.0F, 0.0F)
      );
      crossedArms.addOrReplaceChild(
         "cube_r6",
         CubeListBuilder.create().texOffs(34, 19).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, -5.1741F, -3.6508F, -0.7854F, 0.0F, 0.0F)
      );
      PartDefinition rightArm = root.addOrReplaceChild(
         "right_arm",
         CubeListBuilder.create()
            .texOffs(72, 52)
            .addBox(-2.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
            .texOffs(72, 72)
            .addBox(-2.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.499F)),
         PartPose.offset(-5.0F, -10.0F, 0.0F)
      );
      rightArm.addOrReplaceChild(
         "rightArmLower",
         CubeListBuilder.create()
            .texOffs(72, 62)
            .addBox(-1.5F, 0.0F, -4.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
            .texOffs(72, 82)
            .addBox(-1.5F, 0.0F, -4.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.498F)),
         PartPose.offset(-0.5F, 4.0F, 2.0F)
      );
      PartDefinition leftArm = root.addOrReplaceChild(
         "left_arm",
         CubeListBuilder.create()
            .texOffs(88, 52)
            .addBox(-1.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
            .texOffs(88, 72)
            .addBox(-1.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.499F)),
         PartPose.offset(5.0F, -10.0F, 0.0F)
      );
      leftArm.addOrReplaceChild(
         "leftArmLower",
         CubeListBuilder.create()
            .texOffs(88, 62)
            .addBox(-1.5F, 0.0F, -4.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
            .texOffs(88, 82)
            .addBox(-1.5F, 0.0F, -4.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.498F)),
         PartPose.offset(0.5F, 4.0F, 2.0F)
      );
      return LayerDefinition.create(modelData, 128, 128);
   }

   public void setupAnim(DeerFollowerEntity entity, float f, float g, float h, float i, float j) {
      this.root.getAllParts().forEach(ModelPart::resetPose);
      this.riding = this.riding || entity.getPose().equals(Pose.SITTING);
      super.setupAnim(entity, f, g, h, i, j);
      this.crossedArms.visible = !entity.isArmsVisible();
      this.leftArm.getAllParts().forEach(part -> part.visible = entity.isArmsVisible());
      this.rightArm.getAllParts().forEach(part -> part.visible = entity.isArmsVisible());
      this.mask.visible = entity.isHasMask();
      switch (entity.getActivity()) {
         case 1:
            this.applyReadingPose(entity);
            break;
         case 2:
            this.applyWorshipPose();
      }
   }

   void applyReadingPose(DeerFollowerEntity entity) {
      float amount = entity.getPose().equals(Pose.SITTING) ? 20.0F : 35.0F;
      if (entity.getMainArm().equals(HumanoidArm.RIGHT)) {
         this.leftArm.offsetRotation(new Vector3f((float)Math.toRadians((double)(-amount)), 0.0F, 0.0F));
      } else {
         this.rightArm.offsetRotation(new Vector3f((float)Math.toRadians((double)(-amount)), 0.0F, 0.0F));
      }
   }

   void applyWorshipPose() {
      this.body.offsetPos(new Vector3f(0.0F, 7.0F, -8.0F));
      this.body.offsetRotation(new Vector3f(32.5F, 0.0F, 0.0F).mul((float) (Math.PI / 180.0)));
      this.rightLeg.offsetPos(new Vector3f(0.0F, 5.9F, -1.0F));
      Vector3f rot = new Vector3f(17.6922F, -4.1807F, 3.6993F).mul((float) (Math.PI / 180.0));
      this.rightLeg.xRot = rot.x;
      this.rightLeg.yRot = rot.y;
      this.rightLeg.zRot = rot.z;
      this.rightLegLower.offsetRotation(new Vector3f(75.0F, 0.0F, 0.0F).mul((float) (Math.PI / 180.0)));
      this.leftLeg.offsetPos(new Vector3f(0.0F, 5.9F, -1.0F));
      rot = new Vector3f(-0.1F, 2.88F, -4.79F).mul((float) (Math.PI / 180.0));
      this.leftLeg.xRot = rot.x;
      this.leftLeg.yRot = rot.y;
      this.leftLeg.zRot = rot.z;
      this.leftLegLower.offsetRotation(new Vector3f(80.0F, 0.0F, 0.0F).mul((float) (Math.PI / 180.0)));
      this.rightArm.offsetPos(new Vector3f(0.0F, 9.0F, -7.0F));
      this.rightArm.offsetRotation(new Vector3f(-40.1785F, -17.3519F, -21.6708F).mul((float) (Math.PI / 180.0)));
      this.rightArmLower.offsetRotation(new Vector3f(-30.0F, 0.0F, 0.0F).mul((float) (Math.PI / 180.0)));
      this.leftArm.offsetPos(new Vector3f(0.0F, 9.5F, -7.0F));
      this.leftArm.offsetRotation(new Vector3f(-50.1379F, 21.4894F, 17.5835F).mul((float) (Math.PI / 180.0)));
      this.leftArmLower.offsetRotation(new Vector3f(-25.0F, 0.0F, 0.0F).mul((float) (Math.PI / 180.0)));
      this.head.offsetPos(new Vector3f(0.0F, 7.6F, -7.8F));
   }

   public void renderToBuffer(PoseStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
      this.root.render(matrices, vertices, light, overlay);
   }
}
