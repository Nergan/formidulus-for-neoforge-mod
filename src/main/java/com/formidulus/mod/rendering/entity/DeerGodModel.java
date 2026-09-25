package com.formidulus.mod.rendering.entity;

import com.formidulus.mod.entities.DeerGodEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import org.joml.Vector3f;

public class DeerGodModel extends HierarchicalModel<DeerGodEntity> {
   private static final Vector3f TEMP = new Vector3f();
   private final ModelPart root;
   private final ModelPart spineBottom;
   private final ModelPart spineBottomEnd;
   private final ModelPart spineCenter;
   private final ModelPart spineTop;
   private final ModelPart brokenArmGore1;
   private final ModelPart brokenArmGore2;

   public DeerGodModel(ModelPart root) {
      this.root = root;
      ModelPart body = root.getChild("body");
      this.spineBottom = body.getChild("spineBottom");
      this.spineBottomEnd = this.spineBottom.getChild("spineBottomEnd");
      ModelPart hips = this.spineBottom.getChild("hips");
      ModelPart legLeftTop = hips.getChild("legLeftTop");
      ModelPart legLeftMid = legLeftTop.getChild("legLeftMid");
      ModelPart legLeftBottom = legLeftMid.getChild("legLeftBottom");
      legLeftBottom.getChild("hoofLeft");
      ModelPart legRightTop = hips.getChild("legRightTop");
      ModelPart legRightMid = legRightTop.getChild("legRightMid");
      ModelPart legRightBottom = legRightMid.getChild("legRightBottom");
      legRightBottom.getChild("hoofRight");
      this.spineCenter = this.spineBottom.getChild("spineCenter");
      this.spineTop = this.spineCenter.getChild("spineTop");
      ModelPart head = this.spineTop.getChild("head");
      head.getChild("jaw");
      ModelPart torso = this.spineCenter.getChild("torso");
      ModelPart leftArm = torso.getChild("leftArm");
      ModelPart leftArmLower = leftArm.getChild("leftArmLower");
      ModelPart hand = leftArmLower.getChild("hand");
      ModelPart leftFinger1 = hand.getChild("leftFinger1");
      leftFinger1.getChild("leftFingerTip1");
      ModelPart leftFinger2 = hand.getChild("leftFinger2");
      leftFinger2.getChild("leftFingerTip2");
      ModelPart leftFinger3 = hand.getChild("leftFinger3");
      leftFinger3.getChild("leftFingerTip3");
      ModelPart thumb = hand.getChild("thumb");
      thumb.getChild("thumbTip");
      ModelPart lantern = hand.getChild("lantern");
      ModelPart handle = lantern.getChild("handle");
      ModelPart chainStart = handle.getChild("chainStart");
      ModelPart chain1 = chainStart.getChild("chain1");
      ModelPart chain2 = chain1.getChild("chain2");
      ModelPart chain3 = chain2.getChild("chain3");
      ModelPart chain4 = chain3.getChild("chain4");
      ModelPart chain5 = chain4.getChild("chain5");
      ModelPart chain6 = chain5.getChild("chain6");
      chain6.getChild("hull");
      ModelPart brokenArm = torso.getChild("brokenArm");
      this.brokenArmGore1 = brokenArm.getChild("brokenArmGore1");
      ModelPart brokenArmLower = brokenArm.getChild("brokenArmLower");
      this.brokenArmGore2 = brokenArmLower.getChild("brokenArmGore2");
      ModelPart claw = this.brokenArmGore2.getChild("claw");
      ModelPart finger1 = claw.getChild("finger1");
      ModelPart finger1tip = finger1.getChild("finger1tip");
      finger1tip.getChild("knife1");
      ModelPart finger2 = claw.getChild("finger2");
      ModelPart finger2tip = finger2.getChild("finger2tip");
      finger2tip.getChild("knife2");
      ModelPart finger3 = claw.getChild("finger3");
      ModelPart finger3tip = finger3.getChild("finger3tip");
      finger3tip.getChild("knife3");
      body.getChild("flame");
      this.brokenArmGore1.skipDraw = true;
      this.brokenArmGore2.getAllParts().forEach(i -> i.skipDraw = true);
   }

   public static LayerDefinition getTexturedModelData() {
      MeshDefinition modelData = new MeshDefinition();
      PartDefinition modelPartData = modelData.getRoot();
      PartDefinition body = modelPartData.addOrReplaceChild(
         "body", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F), PartPose.offset(0.0F, 22.0F, 0.0F)
      );
      PartDefinition spineBottom = body.addOrReplaceChild(
         "spineBottom",
         CubeListBuilder.create().texOffs(118, 117).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 9.0F, 1.0F, new CubeDeformation(0.001F)),
         PartPose.offset(-0.5F, -36.0F, 9.0F)
      );
      spineBottom.addOrReplaceChild(
         "spineBottomEnd",
         CubeListBuilder.create().texOffs(110, 122).addBox(-1.0F, 0.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.002F)),
         PartPose.offset(0.0F, 9.0F, -1.0F)
      );
      PartDefinition hips = spineBottom.addOrReplaceChild(
         "hips",
         CubeListBuilder.create().texOffs(81, 49).addBox(-7.5F, 0.0F, -8.0F, 15.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.5F, 6.0F, -1.0F)
      );
      PartDefinition legLeftTop = hips.addOrReplaceChild(
         "legLeftTop",
         CubeListBuilder.create().texOffs(94, 114).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.002F)),
         PartPose.offset(5.5F, 7.0F, -6.0F)
      );
      PartDefinition legLeftMid = legLeftTop.addOrReplaceChild(
         "legLeftMid",
         CubeListBuilder.create().texOffs(80, 105).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.001F)),
         PartPose.offset(0.5F, 10.0F, -2.0F)
      );
      PartDefinition legLeftBottom = legLeftMid.addOrReplaceChild(
         "legLeftBottom",
         CubeListBuilder.create().texOffs(82, 118).addBox(-2.0F, 0.0F, -3.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, 9.0F, 3.0F)
      );
      legLeftBottom.addOrReplaceChild(
         "hoofLeft",
         CubeListBuilder.create().texOffs(70, 121).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-0.001F)),
         PartPose.offset(0.0F, 7.0F, -3.0F)
      );
      PartDefinition legRightTop = hips.addOrReplaceChild(
         "legRightTop",
         CubeListBuilder.create().texOffs(94, 114).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.002F)).mirror(false),
         PartPose.offset(-5.5F, 7.0F, -6.0F)
      );
      PartDefinition legRightMid = legRightTop.addOrReplaceChild(
         "legRightMid",
         CubeListBuilder.create().texOffs(80, 105).mirror().addBox(-1.0F, 0.0F, 0.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.001F)).mirror(false),
         PartPose.offset(-0.5F, 10.0F, -2.0F)
      );
      PartDefinition legRightBottom = legRightMid.addOrReplaceChild(
         "legRightBottom",
         CubeListBuilder.create().texOffs(82, 118).mirror().addBox(-1.0F, 0.0F, -3.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false),
         PartPose.offset(0.0F, 9.0F, 3.0F)
      );
      legRightBottom.addOrReplaceChild(
         "hoofRight",
         CubeListBuilder.create().texOffs(70, 121).mirror().addBox(-1.0F, 0.0F, 0.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-0.001F)).mirror(false),
         PartPose.offset(0.0F, 7.0F, -3.0F)
      );
      PartDefinition spineCenter = spineBottom.addOrReplaceChild(
         "spineCenter",
         CubeListBuilder.create().texOffs(118, 107).addBox(-1.5F, -9.0F, 0.0F, 3.0F, 9.0F, 1.0F, new CubeDeformation(0.002F)),
         PartPose.offset(0.5F, 0.0F, -1.0F)
      );
      PartDefinition spineTop = spineCenter.addOrReplaceChild(
         "spineTop",
         CubeListBuilder.create().texOffs(118, 99).addBox(-1.5F, -7.0F, -1.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.001F)),
         PartPose.offset(0.0F, -9.0F, 1.0F)
      );
      PartDefinition head = spineTop.addOrReplaceChild(
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
         PartPose.offset(0.0F, -4.0F, 0.0F)
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
      head.addOrReplaceChild(
         "jaw",
         CubeListBuilder.create()
            .texOffs(38, 32)
            .addBox(-2.5F, 5.0F, -8.0F, 5.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
            .texOffs(28, 41)
            .addBox(-2.5F, 0.0F, -8.0F, 5.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
            .texOffs(10, 45)
            .addBox(-2.5F, 0.0F, 0.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, 0.0F, -7.0F)
      );
      PartDefinition torso = spineCenter.addOrReplaceChild(
         "torso",
         CubeListBuilder.create().texOffs(84, 80).addBox(-7.5F, -11.0F, -7.0F, 15.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      PartDefinition leftArm = torso.addOrReplaceChild(
         "leftArm",
         CubeListBuilder.create().texOffs(42, 110).mirror().addBox(-1.5F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
         PartPose.offset(9.5F, -9.0F, -3.5F)
      );
      PartDefinition leftArmLower = leftArm.addOrReplaceChild(
         "leftArmLower",
         CubeListBuilder.create().texOffs(14, 110).mirror().addBox(-1.5F, 0.0F, -4.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.01F)).mirror(false),
         PartPose.offset(0.0F, 12.0F, 2.0F)
      );
      PartDefinition hand = leftArmLower.addOrReplaceChild(
         "hand",
         CubeListBuilder.create().texOffs(24, 107).mirror().addBox(0.0F, 0.0F, -2.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.01F)).mirror(false),
         PartPose.offset(-0.5F, 14.0F, -2.0F)
      );
      PartDefinition leftFinger1 = hand.addOrReplaceChild(
         "leftFinger1",
         CubeListBuilder.create().texOffs(56, 113).mirror().addBox(-1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false),
         PartPose.offset(1.0F, 4.0F, -1.5F)
      );
      leftFinger1.addOrReplaceChild(
         "leftFingerTip1",
         CubeListBuilder.create().texOffs(56, 108).mirror().addBox(-1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false),
         PartPose.offset(0.0F, 3.0F, 0.0F)
      );
      PartDefinition leftFinger2 = hand.addOrReplaceChild(
         "leftFinger2",
         CubeListBuilder.create().texOffs(56, 113).mirror().addBox(-1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false),
         PartPose.offset(1.0F, 4.0F, -0.5F)
      );
      leftFinger2.addOrReplaceChild(
         "leftFingerTip2",
         CubeListBuilder.create().texOffs(56, 108).mirror().addBox(-1.0F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false),
         PartPose.offset(0.0F, 3.0F, 0.0F)
      );
      PartDefinition leftFinger3 = hand.addOrReplaceChild(
         "leftFinger3",
         CubeListBuilder.create().texOffs(56, 113).mirror().addBox(-1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false),
         PartPose.offset(1.0F, 4.0F, 0.5F)
      );
      leftFinger3.addOrReplaceChild(
         "leftFingerTip3",
         CubeListBuilder.create().texOffs(56, 108).mirror().addBox(-1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false),
         PartPose.offset(0.0F, 3.0F, 0.0F)
      );
      PartDefinition thumb = hand.addOrReplaceChild(
         "thumb",
         CubeListBuilder.create().texOffs(60, 113).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false),
         PartPose.offset(0.0F, 1.0F, -2.0F)
      );
      thumb.addOrReplaceChild(
         "thumbTip",
         CubeListBuilder.create().texOffs(56, 108).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false),
         PartPose.offset(0.0F, 4.0F, 0.0F)
      );
      PartDefinition lantern = hand.addOrReplaceChild("lantern", CubeListBuilder.create(), PartPose.offset(7.5F, -4.0F, 1.0F));
      PartDefinition handle = lantern.addOrReplaceChild(
         "handle",
         CubeListBuilder.create().texOffs(49, 56).addBox(-4.0F, -1.0F, -1.5F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, 1.0F, 0.0F)
      );
      PartDefinition chainStart = handle.addOrReplaceChild("chainStart", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 0.0F));
      chainStart.addOrReplaceChild(
         "cube_r5",
         CubeListBuilder.create().texOffs(21, 63).addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, -0.7854F, 0.0F)
      );
      chainStart.addOrReplaceChild(
         "cube_r6",
         CubeListBuilder.create().texOffs(21, 63).addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.7854F, 0.0F)
      );
      PartDefinition chain1 = chainStart.addOrReplaceChild("chain1", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));
      chain1.addOrReplaceChild(
         "cube_r7",
         CubeListBuilder.create().texOffs(21, 63).addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.7854F, 0.0F)
      );
      chain1.addOrReplaceChild(
         "cube_r8",
         CubeListBuilder.create().texOffs(21, 63).addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, -0.7854F, 0.0F)
      );
      PartDefinition chain2 = chain1.addOrReplaceChild("chain2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      chain2.addOrReplaceChild(
         "cube_r9",
         CubeListBuilder.create().texOffs(21, 63).addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.7854F, 0.0F)
      );
      chain2.addOrReplaceChild(
         "cube_r10",
         CubeListBuilder.create().texOffs(21, 63).addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, -0.7854F, 0.0F)
      );
      PartDefinition chain3 = chain2.addOrReplaceChild("chain3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      chain3.addOrReplaceChild(
         "cube_r11",
         CubeListBuilder.create().texOffs(21, 63).addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.7854F, 0.0F)
      );
      chain3.addOrReplaceChild(
         "cube_r12",
         CubeListBuilder.create().texOffs(21, 63).addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, -0.7854F, 0.0F)
      );
      PartDefinition chain4 = chain3.addOrReplaceChild("chain4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      chain4.addOrReplaceChild(
         "cube_r13",
         CubeListBuilder.create().texOffs(21, 63).addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.7854F, 0.0F)
      );
      chain4.addOrReplaceChild(
         "cube_r14",
         CubeListBuilder.create().texOffs(21, 63).addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, -0.7854F, 0.0F)
      );
      PartDefinition chain5 = chain4.addOrReplaceChild("chain5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      chain5.addOrReplaceChild(
         "cube_r15",
         CubeListBuilder.create().texOffs(21, 63).addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.7854F, 0.0F)
      );
      chain5.addOrReplaceChild(
         "cube_r16",
         CubeListBuilder.create().texOffs(21, 63).addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, -0.7854F, 0.0F)
      );
      PartDefinition chain6 = chain5.addOrReplaceChild("chain6", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
      chain6.addOrReplaceChild(
         "cube_r17",
         CubeListBuilder.create().texOffs(21, 63).addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.7854F, 0.0F)
      );
      chain6.addOrReplaceChild(
         "cube_r18",
         CubeListBuilder.create().texOffs(21, 63).addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, -0.7854F, 0.0F)
      );
      chain6.addOrReplaceChild(
         "hull",
         CubeListBuilder.create()
            .texOffs(10, 69)
            .addBox(-5.5F, 14.0F, -5.5F, 11.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
            .texOffs(16, 57)
            .addBox(-5.5F, 3.0F, -5.5F, 11.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
            .texOffs(89, 70)
            .addBox(-4.5F, 2.0F, -4.5F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
            .texOffs(53, 61)
            .addBox(-4.5F, 4.0F, -4.5F, 9.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      PartDefinition brokenArm = torso.addOrReplaceChild(
         "brokenArm",
         CubeListBuilder.create().texOffs(42, 110).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)),
         PartPose.offset(-9.5F, -9.0F, -3.5F)
      );
      brokenArm.addOrReplaceChild(
         "brokenArmGore1",
         CubeListBuilder.create().texOffs(22, 88).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.25F)),
         PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      PartDefinition brokenArmLower = brokenArm.addOrReplaceChild(
         "brokenArmLower",
         CubeListBuilder.create().texOffs(28, 110).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.01F)),
         PartPose.offset(0.0F, 12.0F, 2.0F)
      );
      PartDefinition brokenArmGore2 = brokenArmLower.addOrReplaceChild(
         "brokenArmGore2",
         CubeListBuilder.create().texOffs(37, 84).addBox(-2.5F, 16.0F, -2.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.27F)),
         PartPose.offset(0.0F, -16.0F, -2.0F)
      );
      PartDefinition claw = brokenArmGore2.addOrReplaceChild(
         "claw",
         CubeListBuilder.create().texOffs(0, 85).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)),
         PartPose.offset(-0.5F, 34.0F, 1.5F)
      );
      PartDefinition finger1 = claw.addOrReplaceChild(
         "finger1",
         CubeListBuilder.create().texOffs(10, 95).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.001F)),
         PartPose.offset(-3.0F, 5.0F, -3.0F)
      );
      PartDefinition finger1tip = finger1.addOrReplaceChild(
         "finger1tip",
         CubeListBuilder.create().texOffs(0, 95).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, 6.0F, 0.0F)
      );
      PartDefinition knife1 = finger1tip.addOrReplaceChild("knife1", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 1.0F));
      knife1.addOrReplaceChild(
         "cube_r19",
         CubeListBuilder.create().texOffs(0, 97).addBox(0.0F, 0.0F, -3.0F, 0.0F, 24.0F, 7.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, -3.0F, -0.4F, 0.1309F, 0.0F, 0.0F)
      );
      PartDefinition finger2 = claw.addOrReplaceChild(
         "finger2",
         CubeListBuilder.create().texOffs(10, 95).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.001F)),
         PartPose.offset(0.0F, 5.0F, -3.0F)
      );
      PartDefinition finger2tip = finger2.addOrReplaceChild(
         "finger2tip",
         CubeListBuilder.create().texOffs(0, 95).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, 6.0F, 0.0F)
      );
      PartDefinition knife2 = finger2tip.addOrReplaceChild("knife2", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 1.0F));
      knife2.addOrReplaceChild(
         "cube_r20",
         CubeListBuilder.create().texOffs(0, 97).addBox(0.0F, 0.0F, -3.0F, 0.0F, 24.0F, 7.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, -3.0F, -0.4F, 0.1309F, 0.0F, 0.0F)
      );
      PartDefinition finger3 = claw.addOrReplaceChild(
         "finger3",
         CubeListBuilder.create().texOffs(10, 95).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.001F)),
         PartPose.offset(3.0F, 5.0F, -3.0F)
      );
      PartDefinition finger3tip = finger3.addOrReplaceChild(
         "finger3tip",
         CubeListBuilder.create().texOffs(0, 95).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
         PartPose.offset(0.0F, 6.0F, 0.0F)
      );
      PartDefinition knife3 = finger3tip.addOrReplaceChild("knife3", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 1.0F));
      knife3.addOrReplaceChild(
         "cube_r21",
         CubeListBuilder.create().texOffs(0, 97).addBox(0.0F, 0.0F, -3.0F, 0.0F, 24.0F, 7.0F, new CubeDeformation(0.001F)),
         PartPose.offsetAndRotation(0.0F, -3.0F, -0.4F, 0.1309F, 0.0F, 0.0F)
      );
      PartDefinition flame = body.addOrReplaceChild("flame", CubeListBuilder.create(), PartPose.offset(17.5F, -6.0F, -6.5F));
      flame.addOrReplaceChild(
         "cube_r22",
         CubeListBuilder.create().texOffs(43, 73).addBox(-2.5F, -7.0F, 0.0F, 5.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.7854F, 0.0F)
      );
      flame.addOrReplaceChild(
         "cube_r23",
         CubeListBuilder.create().texOffs(43, 73).addBox(-2.5F, -7.0F, 0.0F, 5.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
         PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, -0.7854F, 0.0F)
      );
      return LayerDefinition.create(modelData, 128, 128);
   }

   public void setupAnim(DeerGodEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.root().getAllParts().forEach(ModelPart::resetPose);
      boolean running = entity.shouldPlayRunAnimation();
      if (entity.idleAnimationState.isStarted()) {
         if (running) {
            this.blendMovement(DeerGodAnimations.idle, DeerGodAnimations.run, limbSwing, ageInTicks, limbSwingAmount, 1.0F, 2.5F, 5.0F);
         } else {
            this.blendMovement(DeerGodAnimations.idle, DeerGodAnimations.walk, limbSwing, ageInTicks, limbSwingAmount, 1.0F, 2.5F, 5.0F);
         }
      }

      this.animate(entity.unsummonedPoseAnimationState, DeerGodAnimations.unsummonedPose, ageInTicks);
      this.animate(entity.spawnSequenceAnimationState, DeerGodAnimations.spawnSequence, ageInTicks);
      this.animate(entity.swingAnimationState, DeerGodAnimations.lanternSideSwing, ageInTicks);
      this.animate(entity.slamAnimationState, DeerGodAnimations.lanternSlam, ageInTicks);
      this.animate(entity.summonLanternAnimationState, DeerGodAnimations.summonLantern, ageInTicks);
      this.animate(entity.phaseTransitionAnimationState, DeerGodAnimations.phaseTransition, ageInTicks);
      this.animate(entity.simpleClawAttackAnimationState, DeerGodAnimations.simpleClawAttack, ageInTicks);
      this.animate(entity.slamClawAnimationState, DeerGodAnimations.lanternSlamClaw, ageInTicks);
      int runAttackSpeed = entity.getRunAttackAnimSpeed();
      this.animate(entity.prepareRunAttackAnimationState, DeerGodAnimations.prepareRunAttack, ageInTicks, (float)runAttackSpeed);
      this.animate(entity.runAttackClawAnimationState, DeerGodAnimations.runClawAttack, ageInTicks, (float)runAttackSpeed);
      this.animate(entity.runAttackWallImpactAnimationState, DeerGodAnimations.runAttackWallImpact, ageInTicks);
      this.animate(entity.deathAnimationState, DeerGodAnimations.death, ageInTicks);
      if (entity.shouldApplyLampArmPose()) {
         if (entity.hasLantern()) {
            this.animate(entity.holdLanternAnimationState, DeerGodAnimations.holdLantern, ageInTicks);
            if (running) {
               this.simpleMovement(
                  entity.getRunAttackState() == 2 ? DeerGodAnimations.runLanternDrag : DeerGodAnimations.runLantern, limbSwing, limbSwingAmount, 4.0F, 4.0F
               );
            }
         } else {
            this.animate(entity.noLanternAnimationState, DeerGodAnimations.noLantern, ageInTicks);
         }
      }

      boolean claw = entity.hasClaw();
      this.brokenArmGore1.skipDraw = !claw;
      this.brokenArmGore2.getAllParts().forEach(i -> i.skipDraw = !claw);
      boolean spine = entity.isSpineVisible();
      this.spineBottomEnd.skipDraw = this.spineBottom.skipDraw = this.spineCenter.skipDraw = this.spineTop.skipDraw = !spine;
      if (entity.shouldApplyClawPose()) {
         if (entity.hasClaw()) {
            if (entity.shouldShowClawWithoutExtras()) {
               this.animate(entity.showClawWithoutExtrasAnimationState, DeerGodAnimations.showClawWithoutExtras, ageInTicks);
            } else {
               this.animate(entity.showClawAnimationState, DeerGodAnimations.showClaw, ageInTicks);
            }

            if (running) {
               this.simpleMovement(
                  entity.getRunAttackState() == 1 ? DeerGodAnimations.runClawDrag : DeerGodAnimations.runClaw, limbSwing, limbSwingAmount, 4.0F, 4.0F
               );
            }
         } else {
            this.animate(entity.noClawAnimationState, DeerGodAnimations.noClaw, ageInTicks);
         }
      }
   }

   float getMovementAnimScale(float interpolation, float interpolationScale) {
      return Math.min(interpolation * interpolationScale, 1.0F);
   }

   void blendMovement(
      AnimationDefinition idleAnim,
      AnimationDefinition moveAnim,
      float limbAngle,
      float ageInTicks,
      float interpolation,
      float idleAnimSpeed,
      float moveAnimSpeed,
      float interpolationScale
   ) {
      long moveTime = (long)(limbAngle * 50.0F * moveAnimSpeed);
      long idleTime = (long)(ageInTicks * 50.0F * idleAnimSpeed);
      float scale = this.getMovementAnimScale(interpolation, interpolationScale);
      KeyframeAnimations.animate(this, moveAnim, moveTime, scale, TEMP);
      KeyframeAnimations.animate(this, idleAnim, idleTime, 1.0F - scale, TEMP);
   }

   void simpleMovement(AnimationDefinition anim, float limbAngle, float interpolation, float animSpeed, float interpolationScale) {
      long time = (long)(limbAngle * 50.0F * animSpeed);
      float scale = this.getMovementAnimScale(interpolation, interpolationScale);
      KeyframeAnimations.animate(this, anim, time, scale, TEMP);
   }

   public void renderToBuffer(PoseStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
      this.root().render(matrices, vertices, light, overlay);
   }

   public ModelPart root() {
      return this.root;
   }
}
