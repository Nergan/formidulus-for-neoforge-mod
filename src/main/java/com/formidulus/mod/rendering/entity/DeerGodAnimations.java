package com.formidulus.mod.rendering.entity;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.animation.AnimationChannel.Interpolations;
import net.minecraft.client.animation.AnimationChannel.Targets;
import net.minecraft.client.animation.AnimationDefinition.Builder;

public class DeerGodAnimations {
   public static final AnimationDefinition unsummonedPose = initUnsummonedPoseAnim();
   public static final AnimationDefinition spawnSequence = initSpawnSequenceAnim();
   public static final AnimationDefinition summonLantern = initSummonLanternAnim();
   public static final AnimationDefinition idle = initIdleAnim();
   public static final AnimationDefinition walk = initWalkAnim();
   public static final AnimationDefinition holdLantern = initHoldLanternPose();
   public static final AnimationDefinition noLantern = initNoLanternPose();
   public static final AnimationDefinition showClaw = initShowClawPose();
   public static final AnimationDefinition showClawWithoutExtras = initShowClawNoExtrasPose();
   public static final AnimationDefinition noClaw = initNoClawPose();
   public static final AnimationDefinition run = initRunAnim();
   public static final AnimationDefinition prepareRunAttack = initPrepareRunAttack();
   public static final AnimationDefinition runLantern = initRunLanternAnim();
   public static final AnimationDefinition runLanternDrag = initRunLanternDragAnim();
   public static final AnimationDefinition runClaw = initRunClawAnim();
   public static final AnimationDefinition runClawDrag = initRunClawDragAnim();
   public static final AnimationDefinition lanternSideSwing = initLanternSideSwingAnim();
   public static final AnimationDefinition lanternSlam = initLanternSlamAnim();
   public static final AnimationDefinition phaseTransition = initPhaseTransitionAnim();
   public static final AnimationDefinition simpleClawAttack = initSimpleClawAttackAnim();
   public static final AnimationDefinition lanternSlamClaw = initLanternSlamClawAnim();
   public static final AnimationDefinition runClawAttack = initRunClawAttackAnim();
   public static final AnimationDefinition runAttackWallImpact = initRunAttackWallImpactAnim();
   public static final AnimationDefinition death = initDeathAnim();

   static AnimationDefinition initUnsummonedPoseAnim() {
      return Builder.withLength(0.0F)
         .looping()
         .addAnimation(
            "body",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -48.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hips", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "head",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "head",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "torso", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "flame", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .build();
   }

   static AnimationDefinition initSpawnSequenceAnim() {
      return Builder.withLength(18.0F)
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(14.9F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.55F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -48.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(6.5F, KeyframeAnimations.posVec(0.0F, -48.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.5F, KeyframeAnimations.posVec(0.0F, 6.1F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.7F, KeyframeAnimations.posVec(0.0F, 7.1F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.05F, KeyframeAnimations.posVec(0.0F, -7.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(10.5F, KeyframeAnimations.posVec(0.0F, -7.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.posVec(0.0F, -0.8F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.posVec(0.0F, -0.8F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.posVec(0.0F, -0.8F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.posVec(0.0F, -0.8F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.35F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(7.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(10.5F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(4.6758F, 2.2422F, -2.7032F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(4.6758F, 2.2422F, -2.7032F), Interpolations.LINEAR),
                  new Keyframe(17.35F, KeyframeAnimations.degreeVec(4.6758F, 2.2422F, -2.7032F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottomEnd",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hips",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(13.5F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(14.85F, KeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.55F, KeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 1.0F, 2.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hips",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(5.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(8.699F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(8.7F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(17.999F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(-42.8111F, -7.8418F, 1.4283F), Interpolations.LINEAR),
                  new Keyframe(8.95F, KeyframeAnimations.degreeVec(-42.8111F, -7.8418F, 1.4283F), Interpolations.LINEAR),
                  new Keyframe(9.05F, KeyframeAnimations.degreeVec(-52.8111F, -7.8418F, 1.4283F), Interpolations.LINEAR),
                  new Keyframe(10.5F, KeyframeAnimations.degreeVec(-52.8111F, -7.8418F, 1.4283F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(13.5F, KeyframeAnimations.degreeVec(-1.8577F, -17.2808F, -2.5417F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(-1.8577F, -17.2808F, -2.5417F), Interpolations.LINEAR),
                  new Keyframe(14.85F, KeyframeAnimations.degreeVec(-18.0915F, -23.4954F, -5.4331F), Interpolations.LINEAR),
                  new Keyframe(15.55F, KeyframeAnimations.degreeVec(-18.0915F, -23.4954F, -5.4331F), Interpolations.LINEAR),
                  new Keyframe(15.95F, KeyframeAnimations.degreeVec(-18.6743F, -20.3348F, -3.7262F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(9.05F, KeyframeAnimations.posVec(-0.8737F, -0.0923F, 1.5322F), Interpolations.LINEAR),
                  new Keyframe(10.5F, KeyframeAnimations.posVec(-0.8737F, -0.0923F, 1.5322F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(15.95F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(57.621F, 0.7341F, 3.009F), Interpolations.LINEAR),
                  new Keyframe(8.95F, KeyframeAnimations.degreeVec(57.621F, 0.7341F, 3.009F), Interpolations.LINEAR),
                  new Keyframe(9.05F, KeyframeAnimations.degreeVec(85.121F, 0.7341F, 3.009F), Interpolations.LINEAR),
                  new Keyframe(10.5F, KeyframeAnimations.degreeVec(85.121F, 0.7341F, 3.009F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(52.4982F, 5.0263F, 2.4467F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(52.4982F, 5.0263F, 2.4467F), Interpolations.LINEAR),
                  new Keyframe(13.25F, KeyframeAnimations.degreeVec(58.9097F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(13.5F, KeyframeAnimations.degreeVec(45.1597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(45.1597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(14.9F, KeyframeAnimations.degreeVec(45.1597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(15.55F, KeyframeAnimations.degreeVec(45.1597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(15.9F, KeyframeAnimations.degreeVec(49.0221F, 3.1449F, 3.8876F), Interpolations.LINEAR),
                  new Keyframe(17.35F, KeyframeAnimations.degreeVec(49.0221F, 3.1449F, 3.8876F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(-64.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(8.95F, KeyframeAnimations.degreeVec(-64.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(9.05F, KeyframeAnimations.degreeVec(-86.6649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(10.5F, KeyframeAnimations.degreeVec(-86.6649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(-54.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(-54.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(13.25F, KeyframeAnimations.degreeVec(-64.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(13.5F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(14.9F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(15.55F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(15.9F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofLeft",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(10.5F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(14.9F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.55F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.9F, KeyframeAnimations.degreeVec(25.92F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.35F, KeyframeAnimations.degreeVec(25.92F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.7F, KeyframeAnimations.degreeVec(-5.6157F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(8.95F, KeyframeAnimations.degreeVec(19.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(9.05F, KeyframeAnimations.degreeVec(35.116F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(10.5F, KeyframeAnimations.degreeVec(35.116F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(-17.0212F, 15.9483F, 3.6433F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(-17.0212F, 15.9483F, 3.6433F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(-17.0212F, 15.9483F, 3.6433F), Interpolations.LINEAR),
                  new Keyframe(14.9F, KeyframeAnimations.degreeVec(-14.2224F, 11.1045F, 4.9194F), Interpolations.LINEAR),
                  new Keyframe(15.55F, KeyframeAnimations.degreeVec(-14.2224F, 11.1045F, 4.9194F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(12.0F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.5F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.5F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.7F, KeyframeAnimations.degreeVec(57.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(8.9F, KeyframeAnimations.degreeVec(67.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(8.95F, KeyframeAnimations.degreeVec(57.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(9.05F, KeyframeAnimations.degreeVec(48.8012F, -0.122F, -5.1503F), Interpolations.LINEAR),
                  new Keyframe(10.5F, KeyframeAnimations.degreeVec(48.8012F, -0.122F, -5.1503F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(52.6597F, -1.0544F, -5.4887F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(52.6597F, -1.0544F, -5.4887F), Interpolations.LINEAR),
                  new Keyframe(15.55F, KeyframeAnimations.degreeVec(52.6597F, -1.0544F, -5.4887F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.7F, KeyframeAnimations.degreeVec(-81.8103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(8.95F, KeyframeAnimations.degreeVec(-56.8103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(9.05F, KeyframeAnimations.degreeVec(-63.4567F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(10.5F, KeyframeAnimations.degreeVec(-63.4567F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(-54.1649F, 1.3726F, -0.9571F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(-54.1649F, 1.3726F, -0.9571F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(-54.1649F, 1.3726F, -0.9571F), Interpolations.LINEAR),
                  new Keyframe(14.85F, KeyframeAnimations.degreeVec(-61.6649F, 1.3726F, -0.9571F), Interpolations.LINEAR),
                  new Keyframe(15.55F, KeyframeAnimations.degreeVec(-61.6649F, 1.3726F, -0.9571F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.7F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.05F, KeyframeAnimations.degreeVec(-22.99F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(10.5F, KeyframeAnimations.degreeVec(-22.99F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.55F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.95F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.05F, KeyframeAnimations.posVec(0.0F, 1.406F, 0.2706F), Interpolations.LINEAR),
                  new Keyframe(10.5F, KeyframeAnimations.posVec(0.0F, 1.406F, 0.2706F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.55F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineCenter",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(7.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(10.1402F, 10.7145F, -3.1723F), Interpolations.LINEAR),
                  new Keyframe(9.0F, KeyframeAnimations.degreeVec(10.1402F, 10.7145F, -3.1723F), Interpolations.LINEAR),
                  new Keyframe(9.1F, KeyframeAnimations.degreeVec(14.6647F, 8.9413F, -6.2761F), Interpolations.LINEAR),
                  new Keyframe(9.3F, KeyframeAnimations.degreeVec(12.1647F, 8.9413F, -6.2761F), Interpolations.LINEAR),
                  new Keyframe(10.5F, KeyframeAnimations.degreeVec(12.1647F, 8.9413F, -6.2761F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(9.9387F, -7.3584F, 0.0429F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(12.4387F, -7.3584F, 0.0429F), Interpolations.LINEAR),
                  new Keyframe(13.4F, KeyframeAnimations.degreeVec(7.5518F, -12.3157F, -0.6188F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(7.6315F, -14.7938F, -0.9585F), Interpolations.LINEAR),
                  new Keyframe(14.9F, KeyframeAnimations.degreeVec(7.6493F, 10.6431F, 1.7058F), Interpolations.LINEAR),
                  new Keyframe(15.55F, KeyframeAnimations.degreeVec(7.6493F, 10.6431F, 1.7058F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(10.2533F, 5.3516F, -1.5833F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(7.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(9.1F, KeyframeAnimations.degreeVec(39.9011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.65F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.95F, KeyframeAnimations.degreeVec(27.2642F, -0.0044F, -2.1618F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(27.2642F, -0.0044F, -2.1618F), Interpolations.LINEAR),
                  new Keyframe(16.5F, KeyframeAnimations.degreeVec(27.2642F, -0.0044F, -2.1618F), Interpolations.LINEAR),
                  new Keyframe(17.0F, KeyframeAnimations.degreeVec(27.2642F, -0.0044F, -2.1618F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-7.29F, -2.48F, 2.82F), Interpolations.LINEAR),
                  new Keyframe(2.9F, KeyframeAnimations.degreeVec(-7.29F, -2.48F, 2.82F), Interpolations.LINEAR),
                  new Keyframe(3.05F, KeyframeAnimations.degreeVec(-7.29F, 2.52F, -0.02F), Interpolations.LINEAR),
                  new Keyframe(3.65F, KeyframeAnimations.degreeVec(-7.29F, 2.52F, -0.02F), Interpolations.LINEAR),
                  new Keyframe(3.85F, KeyframeAnimations.degreeVec(-7.2888F, -2.4751F, 0.3165F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(-7.2888F, -2.4751F, 0.3165F), Interpolations.LINEAR),
                  new Keyframe(4.5F, KeyframeAnimations.degreeVec(-7.3891F, -2.1557F, 2.798F), Interpolations.LINEAR),
                  new Keyframe(4.8F, KeyframeAnimations.degreeVec(-7.3891F, -2.1557F, 2.798F), Interpolations.LINEAR),
                  new Keyframe(4.9F, KeyframeAnimations.degreeVec(-7.052F, -0.4352F, -2.5675F), Interpolations.LINEAR),
                  new Keyframe(5.1F, KeyframeAnimations.degreeVec(-7.052F, -0.4352F, -2.5675F), Interpolations.LINEAR),
                  new Keyframe(5.2F, KeyframeAnimations.degreeVec(-7.2888F, -2.4751F, 0.3165F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(-7.3891F, -2.1557F, 2.798F), Interpolations.LINEAR),
                  new Keyframe(5.4F, KeyframeAnimations.degreeVec(-6.9537F, -5.4413F, -2.1177F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(-9.7888F, -2.4751F, 0.3165F), Interpolations.LINEAR),
                  new Keyframe(5.6F, KeyframeAnimations.degreeVec(-7.5071F, 2.4786F, -0.3265F), Interpolations.LINEAR),
                  new Keyframe(5.7F, KeyframeAnimations.degreeVec(-6.9537F, -5.4413F, -2.1177F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(-9.5243F, -0.8495F, -5.0331F), Interpolations.LINEAR),
                  new Keyframe(5.9F, KeyframeAnimations.degreeVec(-7.3891F, -2.1557F, 2.798F), Interpolations.LINEAR),
                  new Keyframe(6.0F, KeyframeAnimations.degreeVec(-7.2888F, -2.4751F, 0.3165F), Interpolations.LINEAR),
                  new Keyframe(6.1F, KeyframeAnimations.degreeVec(-7.3891F, -2.1557F, 2.798F), Interpolations.LINEAR),
                  new Keyframe(6.2F, KeyframeAnimations.degreeVec(-6.9537F, -5.4413F, -2.1177F), Interpolations.LINEAR),
                  new Keyframe(6.3F, KeyframeAnimations.degreeVec(-9.7888F, -2.4751F, 0.3165F), Interpolations.LINEAR),
                  new Keyframe(6.4F, KeyframeAnimations.degreeVec(-7.5071F, 2.4786F, -0.3265F), Interpolations.LINEAR),
                  new Keyframe(6.5F, KeyframeAnimations.degreeVec(-6.9537F, -5.4413F, -2.1177F), Interpolations.LINEAR),
                  new Keyframe(6.6F, KeyframeAnimations.degreeVec(-9.5243F, -0.8495F, -5.0331F), Interpolations.LINEAR),
                  new Keyframe(6.7F, KeyframeAnimations.degreeVec(-7.3891F, -2.1557F, 2.798F), Interpolations.LINEAR),
                  new Keyframe(6.8F, KeyframeAnimations.degreeVec(-7.5071F, 2.4786F, -0.3265F), Interpolations.LINEAR),
                  new Keyframe(6.85F, KeyframeAnimations.degreeVec(-7.2888F, -2.4751F, 0.3165F), Interpolations.LINEAR),
                  new Keyframe(6.9F, KeyframeAnimations.degreeVec(-7.3891F, -2.1557F, 2.798F), Interpolations.LINEAR),
                  new Keyframe(6.95F, KeyframeAnimations.degreeVec(-6.9537F, -5.4413F, -2.1177F), Interpolations.LINEAR),
                  new Keyframe(7.0F, KeyframeAnimations.degreeVec(-9.7888F, -2.4751F, 0.3165F), Interpolations.LINEAR),
                  new Keyframe(7.05F, KeyframeAnimations.degreeVec(-7.5071F, 2.4786F, -0.3265F), Interpolations.LINEAR),
                  new Keyframe(7.1F, KeyframeAnimations.degreeVec(-6.9537F, -5.4413F, -2.1177F), Interpolations.LINEAR),
                  new Keyframe(7.15F, KeyframeAnimations.degreeVec(-7.2888F, -2.4751F, 0.3165F), Interpolations.LINEAR),
                  new Keyframe(7.2F, KeyframeAnimations.degreeVec(-7.3891F, -2.1557F, 2.798F), Interpolations.LINEAR),
                  new Keyframe(7.25F, KeyframeAnimations.degreeVec(-6.9537F, -5.4413F, -2.1177F), Interpolations.LINEAR),
                  new Keyframe(7.3F, KeyframeAnimations.degreeVec(-7.5071F, 2.4786F, -0.3265F), Interpolations.LINEAR),
                  new Keyframe(7.35F, KeyframeAnimations.degreeVec(-7.2888F, -2.4751F, 0.3165F), Interpolations.LINEAR),
                  new Keyframe(7.4F, KeyframeAnimations.degreeVec(-7.3891F, -2.1557F, 2.798F), Interpolations.LINEAR),
                  new Keyframe(7.45F, KeyframeAnimations.degreeVec(-6.9537F, -5.4413F, -2.1177F), Interpolations.LINEAR),
                  new Keyframe(7.5F, KeyframeAnimations.degreeVec(-9.7888F, -2.4751F, 0.3165F), Interpolations.LINEAR),
                  new Keyframe(7.55F, KeyframeAnimations.degreeVec(-7.5071F, 2.4786F, -0.3265F), Interpolations.LINEAR),
                  new Keyframe(7.6F, KeyframeAnimations.degreeVec(-6.9537F, -5.4413F, -2.1177F), Interpolations.LINEAR),
                  new Keyframe(7.65F, KeyframeAnimations.degreeVec(-9.5243F, -0.8495F, -5.0331F), Interpolations.LINEAR),
                  new Keyframe(7.7F, KeyframeAnimations.degreeVec(-7.3891F, -2.1557F, 2.798F), Interpolations.LINEAR),
                  new Keyframe(7.75F, KeyframeAnimations.degreeVec(-7.5071F, 2.4786F, -0.3265F), Interpolations.LINEAR),
                  new Keyframe(7.8F, KeyframeAnimations.degreeVec(-7.2888F, -2.4751F, 0.3165F), Interpolations.LINEAR),
                  new Keyframe(7.85F, KeyframeAnimations.degreeVec(-7.3891F, -2.1557F, 2.798F), Interpolations.LINEAR),
                  new Keyframe(7.9F, KeyframeAnimations.degreeVec(-6.9537F, -5.4413F, -2.1177F), Interpolations.LINEAR),
                  new Keyframe(7.95F, KeyframeAnimations.degreeVec(-9.7888F, -2.4751F, 0.3165F), Interpolations.LINEAR),
                  new Keyframe(8.0F, KeyframeAnimations.degreeVec(-7.5071F, 2.4786F, -0.3265F), Interpolations.LINEAR),
                  new Keyframe(8.05F, KeyframeAnimations.degreeVec(-6.9537F, -5.4413F, -2.1177F), Interpolations.LINEAR),
                  new Keyframe(8.1F, KeyframeAnimations.degreeVec(-9.5243F, -0.8495F, -5.0331F), Interpolations.LINEAR),
                  new Keyframe(8.15F, KeyframeAnimations.degreeVec(-7.3891F, -2.1557F, 2.798F), Interpolations.LINEAR),
                  new Keyframe(8.2F, KeyframeAnimations.degreeVec(-7.5071F, 2.4786F, -0.3265F), Interpolations.LINEAR),
                  new Keyframe(8.45F, KeyframeAnimations.degreeVec(-6.9537F, -5.4413F, -2.1177F), Interpolations.LINEAR),
                  new Keyframe(8.55F, KeyframeAnimations.degreeVec(-7.3891F, -2.1557F, 2.798F), Interpolations.LINEAR),
                  new Keyframe(8.95F, KeyframeAnimations.degreeVec(7.4929F, 2.4786F, -0.3265F), Interpolations.LINEAR),
                  new Keyframe(9.05F, KeyframeAnimations.degreeVec(2.4929F, 2.4786F, -0.3265F), Interpolations.LINEAR),
                  new Keyframe(9.2F, KeyframeAnimations.degreeVec(-2.62F, 4.8643F, -2.9406F), Interpolations.LINEAR),
                  new Keyframe(10.5F, KeyframeAnimations.degreeVec(-2.62F, 4.8643F, -2.9406F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(-4.6693F, 7.9379F, -1.9736F), Interpolations.LINEAR),
                  new Keyframe(12.5F, KeyframeAnimations.degreeVec(-2.17F, 9.0F, -3.22F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(-4.6693F, 7.9379F, -1.9736F), Interpolations.LINEAR),
                  new Keyframe(13.5F, KeyframeAnimations.degreeVec(-1.6408F, -19.5056F, 3.221F), Interpolations.LINEAR),
                  new Keyframe(14.0F, KeyframeAnimations.degreeVec(-1.6681F, -22.0045F, 3.2982F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(-1.6681F, -22.0045F, 3.2982F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(-0.2888F, 10.8328F, -2.4753F), Interpolations.LINEAR),
                  new Keyframe(15.65F, KeyframeAnimations.degreeVec(-0.1633F, 3.9056F, 0.4144F), Interpolations.LINEAR),
                  new Keyframe(15.95F, KeyframeAnimations.degreeVec(-7.2525F, 7.501F, 20.6205F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(-7.2525F, 7.501F, 20.6205F), Interpolations.LINEAR),
                  new Keyframe(16.5F, KeyframeAnimations.degreeVec(-7.218F, 5.0209F, 20.9373F), Interpolations.LINEAR),
                  new Keyframe(17.0F, KeyframeAnimations.degreeVec(-6.919F, 7.8095F, 23.1238F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 8.5351F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(4.35F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.2F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.5F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.9F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.15F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.3F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.6F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(12.65F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(1.8266F, 1.6188F, 5.4202F), Interpolations.LINEAR),
                  new Keyframe(14.75F, KeyframeAnimations.degreeVec(11.0464F, 0.181F, 2.4387F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(8.9F, KeyframeAnimations.posVec(0.0197F, 2.9888F, -0.1979F), Interpolations.LINEAR),
                  new Keyframe(9.15F, KeyframeAnimations.posVec(0.0F, 1.3513F, -0.0344F), Interpolations.LINEAR),
                  new Keyframe(9.3F, KeyframeAnimations.posVec(0.0F, 1.3513F, -0.0344F), Interpolations.LINEAR),
                  new Keyframe(9.6F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.posVec(0.0565F, 1.9829F, 0.2549F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.posVec(0.0565F, 1.9829F, 0.2549F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.posVec(0.0976F, 2.3531F, 0.3891F), Interpolations.LINEAR),
                  new Keyframe(14.75F, KeyframeAnimations.posVec(-0.0545F, 1.9888F, -0.0409F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.posVec(0.0565F, 1.9829F, 0.2549F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.posVec(0.0565F, 1.9829F, 0.2549F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(0.0437F, 4.4899F, 0.832F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(0.0437F, 4.4899F, 0.832F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0436F, -0.5101F, 0.8282F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(5.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(8.699F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(8.7F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(17.999F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(9.05F, KeyframeAnimations.degreeVec(13.4843F, 13.5362F, -33.479F), Interpolations.LINEAR),
                  new Keyframe(9.15F, KeyframeAnimations.degreeVec(23.1083F, 5.9081F, -6.6443F), Interpolations.LINEAR),
                  new Keyframe(9.3F, KeyframeAnimations.degreeVec(18.3377F, 5.1262F, -4.2587F), Interpolations.LINEAR),
                  new Keyframe(9.5F, KeyframeAnimations.degreeVec(17.846F, 6.6798F, -9.0367F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(3.14F, 13.1424F, -7.8657F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(3.14F, 13.1424F, -7.8657F), Interpolations.LINEAR),
                  new Keyframe(13.5F, KeyframeAnimations.degreeVec(4.099F, 8.9549F, -64.5955F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(3.2978F, 9.2777F, -69.6489F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.degreeVec(-26.2417F, 7.9551F, -66.912F), Interpolations.LINEAR),
                  new Keyframe(14.9F, KeyframeAnimations.degreeVec(-40.8536F, 18.0891F, -43.4106F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(-48.9283F, -2.2827F, -54.7569F), Interpolations.LINEAR),
                  new Keyframe(15.95F, KeyframeAnimations.degreeVec(-48.9283F, -2.2827F, -54.7569F), Interpolations.LINEAR),
                  new Keyframe(17.0F, KeyframeAnimations.degreeVec(-47.2907F, 14.5647F, -39.7003F), Interpolations.LINEAR),
                  new Keyframe(17.15F, KeyframeAnimations.degreeVec(-47.2907F, 14.5647F, -39.7003F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(-27.2434F, 6.6857F, -42.219F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(8.7685F, 16.9416F, -51.2783F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(9.05F, KeyframeAnimations.posVec(-0.6428F, -0.926F, -0.3495F), Interpolations.LINEAR),
                  new Keyframe(9.15F, KeyframeAnimations.posVec(-0.6428F, -0.926F, -0.3495F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.posVec(0.0F, -0.9962F, -0.0872F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.posVec(0.0F, -0.9962F, -0.0872F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(-0.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(9.0F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.1F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.25F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.45F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(13.5F, KeyframeAnimations.degreeVec(-80.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(-79.9907F, -2.462F, -0.4344F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(14.8F, KeyframeAnimations.degreeVec(-62.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.5F, KeyframeAnimations.degreeVec(-80.0093F, 0.434F, -2.4621F), Interpolations.LINEAR),
                  new Keyframe(17.0F, KeyframeAnimations.degreeVec(-80.0093F, 0.434F, -2.4621F), Interpolations.LINEAR),
                  new Keyframe(17.15F, KeyframeAnimations.degreeVec(-77.5093F, 0.434F, -2.4621F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(-60.01F, 0.43F, -2.46F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(-16.8502F, -3.6311F, -62.5178F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(-15.6263F, 22.9193F, -35.6867F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(-15.6263F, 22.9193F, -35.6867F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.degreeVec(-16.8502F, -3.6311F, -62.5178F), Interpolations.LINEAR),
                  new Keyframe(14.8F, KeyframeAnimations.degreeVec(-18.6293F, 10.8224F, -34.3553F), Interpolations.LINEAR),
                  new Keyframe(15.5F, KeyframeAnimations.degreeVec(-24.6385F, 41.1819F, -47.5377F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(-24.6385F, 41.1819F, -47.5377F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(-18.218F, 43.9278F, -20.5584F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-16.8502F, -3.6311F, -62.5178F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(-18.1429F, 15.2099F, 30.0306F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(-15.6249F, 7.9813F, 13.9032F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(-15.6249F, 7.9813F, 13.9032F), Interpolations.LINEAR),
                  new Keyframe(13.3F, KeyframeAnimations.degreeVec(-16.5037F, -5.9032F, -31.6431F), Interpolations.LINEAR),
                  new Keyframe(13.45F, KeyframeAnimations.degreeVec(-16.9384F, -4.4638F, -26.835F), Interpolations.LINEAR),
                  new Keyframe(13.65F, KeyframeAnimations.degreeVec(-17.4844F, -0.7515F, -14.8844F), Interpolations.LINEAR),
                  new Keyframe(13.95F, KeyframeAnimations.degreeVec(-17.4844F, 0.7515F, -10.1156F), Interpolations.LINEAR),
                  new Keyframe(14.5F, KeyframeAnimations.degreeVec(-17.4375F, 1.5018F, -7.7303F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(-17.3593F, -2.2494F, -19.6566F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.degreeVec(-18.1429F, 15.2099F, 30.0306F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(-18.1429F, 15.2099F, 30.0306F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-18.1429F, 15.2099F, 30.0306F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 80.0F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 60.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 60.0F), Interpolations.LINEAR),
                  new Keyframe(13.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 30.0F), Interpolations.LINEAR),
                  new Keyframe(13.6F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), Interpolations.LINEAR),
                  new Keyframe(13.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 45.0F), Interpolations.LINEAR),
                  new Keyframe(14.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 47.5F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 40.0F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 80.0F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 80.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 80.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(-4.2764F, 5.8539F, 28.3899F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(13.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -35.0F), Interpolations.LINEAR),
                  new Keyframe(13.85F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -17.5F), Interpolations.LINEAR),
                  new Keyframe(14.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -15.0F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -27.5F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.degreeVec(-4.2764F, 5.8539F, 28.3899F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(-4.2764F, 5.8539F, 28.3899F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-4.2764F, 5.8539F, 28.3899F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 75.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 75.0F), Interpolations.LINEAR),
                  new Keyframe(13.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 30.0F), Interpolations.LINEAR),
                  new Keyframe(14.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 47.5F), Interpolations.LINEAR),
                  new Keyframe(14.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 50.0F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 42.5F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(9.5744F, 6.7089F, 32.3286F), Interpolations.LINEAR),
                  new Keyframe(12.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), Interpolations.LINEAR),
                  new Keyframe(13.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), Interpolations.LINEAR),
                  new Keyframe(13.8F, KeyframeAnimations.degreeVec(15.1291F, 1.5065F, -32.6291F), Interpolations.LINEAR),
                  new Keyframe(14.1F, KeyframeAnimations.degreeVec(14.8981F, -3.06F, -15.7294F), Interpolations.LINEAR),
                  new Keyframe(14.5F, KeyframeAnimations.degreeVec(14.7554F, -3.6999F, -13.3084F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(15.1624F, -1.1125F, -22.9773F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.degreeVec(9.5744F, 6.7089F, 32.3286F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(9.5744F, 6.7089F, 32.3286F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(9.5744F, 6.7089F, 32.3286F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.2F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.2F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.2F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.2F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(13.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(13.9F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 40.0F), Interpolations.LINEAR),
                  new Keyframe(14.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 52.5F), Interpolations.LINEAR),
                  new Keyframe(14.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 45.0F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(-17.776F, -1.0873F, 55.7603F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(-60.2444F, -31.8956F, 79.1775F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(-60.2444F, -31.8956F, 79.1775F), Interpolations.LINEAR),
                  new Keyframe(13.3F, KeyframeAnimations.degreeVec(-56.0171F, -33.8662F, 75.9631F), Interpolations.LINEAR),
                  new Keyframe(14.0F, KeyframeAnimations.degreeVec(-54.2045F, -17.4308F, 84.1974F), Interpolations.LINEAR),
                  new Keyframe(14.5F, KeyframeAnimations.degreeVec(-53.0345F, -17.9608F, 80.5287F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(-44.9019F, -5.8049F, 89.529F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.degreeVec(-17.776F, -1.0873F, 55.7603F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(-17.776F, -1.0873F, 55.7603F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-17.776F, -1.0873F, 55.7603F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.posVec(0.5942F, 0.9772F, 0.0667F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.posVec(0.5942F, 0.9772F, 0.0667F), Interpolations.LINEAR),
                  new Keyframe(13.75F, KeyframeAnimations.posVec(0.5942F, 0.9772F, 0.0667F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumbTip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -52.5F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -45.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -45.0F), Interpolations.LINEAR),
                  new Keyframe(13.45F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -72.5F), Interpolations.LINEAR),
                  new Keyframe(14.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -40.0F), Interpolations.LINEAR),
                  new Keyframe(14.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -35.0F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -52.5F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -52.5F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -52.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(-7.9691F, 78.8825F, 94.5937F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(-7.9691F, 78.8825F, 94.5937F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(-7.9691F, 78.8825F, 94.5937F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(-7.9691F, 78.8825F, 94.5937F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-7.9691F, 78.8825F, 94.5937F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.posVec(-7.75F, -7.7F, -2.0F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.posVec(-7.75F, -7.7F, -2.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.posVec(-7.75F, -7.7F, -2.0F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.posVec(-7.75F, -7.7F, -2.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(-7.75F, -7.7F, -2.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(12.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(12.999F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(14.649F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(14.8F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "handle",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(-5.0F, 2.5F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-5.0F, 2.5F, 5.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chainStart",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(2.4976F, -0.109F, 2.4976F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.degreeVec(1.3433F, 3.0955F, 34.7562F), Interpolations.LINEAR),
                  new Keyframe(14.9F, KeyframeAnimations.degreeVec(-18.5366F, -4.8207F, 47.8619F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(-17.9286F, -17.1498F, 19.7228F), Interpolations.LINEAR),
                  new Keyframe(15.25F, KeyframeAnimations.degreeVec(-2.3206F, -29.479F, -8.4164F), Interpolations.LINEAR),
                  new Keyframe(15.35F, KeyframeAnimations.degreeVec(-0.9056F, -29.5493F, -11.2881F), Interpolations.LINEAR),
                  new Keyframe(15.7F, KeyframeAnimations.degreeVec(-33.6871F, -12.6247F, -2.0325F), Interpolations.LINEAR),
                  new Keyframe(15.8F, KeyframeAnimations.degreeVec(-34.5092F, -9.8204F, 2.1883F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(-30.8505F, -20.4871F, 0.8032F), Interpolations.LINEAR),
                  new Keyframe(17.0F, KeyframeAnimations.degreeVec(-15.6256F, -15.074F, 7.689F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(3.8789F, -10.2164F, -5.6478F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(2.0278F, -10.733F, 4.5085F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.8F, KeyframeAnimations.degreeVec(28.4327F, 28.2176F, 54.0908F), Interpolations.LINEAR),
                  new Keyframe(9.15F, KeyframeAnimations.degreeVec(-20.7742F, -18.1453F, 19.59F), Interpolations.LINEAR),
                  new Keyframe(9.25F, KeyframeAnimations.degreeVec(-21.9521F, -18.2166F, 19.6043F), Interpolations.LINEAR),
                  new Keyframe(9.55F, KeyframeAnimations.degreeVec(-15.7898F, -17.5355F, 19.3628F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(-4.9811F, -0.4352F, 7.5189F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(-4.9811F, -0.4352F, 7.5189F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(-15.047F, -1.0871F, 12.4767F), Interpolations.LINEAR),
                  new Keyframe(14.85F, KeyframeAnimations.degreeVec(34.3857F, -6.7853F, 20.7173F), Interpolations.LINEAR),
                  new Keyframe(15.25F, KeyframeAnimations.degreeVec(41.8857F, -6.7853F, 20.7173F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(39.3857F, -6.7853F, 20.7173F), Interpolations.LINEAR),
                  new Keyframe(16.3F, KeyframeAnimations.degreeVec(23.86F, -4.56F, 16.1F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(8.8F, KeyframeAnimations.posVec(0.0F, 0.1736F, -0.9848F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.posVec(0.4966F, -0.9829F, -0.193F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.posVec(0.4966F, -0.9829F, -0.193F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.8F, KeyframeAnimations.degreeVec(-69.3012F, -23.4908F, -16.702F), Interpolations.LINEAR),
                  new Keyframe(9.15F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.3F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.65F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(14.85F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.35F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(-33.6404F, 37.2028F, 8.1506F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(-33.6404F, 37.2028F, 8.1506F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-33.6404F, 37.2028F, 8.1506F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.posVec(0.4673F, -1.3712F, -0.605F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.posVec(0.4673F, -1.3712F, -0.605F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.4673F, -1.3712F, -0.605F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(23.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(23.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(23.224F, -7.5832F, 10.0906F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(57.679F, -4.1157F, -2.1768F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(57.679F, -4.1157F, -2.1768F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(57.679F, -4.1157F, -2.1768F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(17.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(17.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(17.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(46.282F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(46.282F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(46.282F, 3.5796F, -8.6772F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.degreeVec(-5.0F, -2.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(-5.0F, -2.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-5.0F, -2.5F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "flame",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(12.0F, KeyframeAnimations.posVec(0.0F, 12.0F, -11.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.posVec(0.0F, 12.0F, -11.0F), Interpolations.LINEAR),
                  new Keyframe(14.5F, KeyframeAnimations.posVec(0.0F, 17.75F, -11.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "flame",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(8.5F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(14.5F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(14.799F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(14.8F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(14.6F, KeyframeAnimations.degreeVec(8.1249F, -7.9813F, 26.4032F), Interpolations.LINEAR),
                  new Keyframe(15.25F, KeyframeAnimations.degreeVec(-96.5396F, -78.6126F, 83.2974F), Interpolations.LINEAR),
                  new Keyframe(15.7F, KeyframeAnimations.degreeVec(-31.4764F, -79.8585F, 41.3071F), Interpolations.LINEAR),
                  new Keyframe(16.2F, KeyframeAnimations.degreeVec(-3.8657F, -84.0424F, -4.0098F), Interpolations.LINEAR),
                  new Keyframe(17.0F, KeyframeAnimations.degreeVec(112.0573F, -83.7235F, -108.8243F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(17.7171F, -69.3934F, -42.7052F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-10.9113F, -69.7015F, 12.0549F), Interpolations.LINEAR)
               }
            )
         )
         .build();
   }

   static AnimationDefinition initSummonLanternAnim() {
      return Builder.withLength(2.75F)
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.posVec(0.0F, -0.83F, 7.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.posVec(0.0F, -0.83F, 7.0F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.posVec(0.0F, -0.8F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.posVec(0.0F, -0.8F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hips",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(0.0F, 15.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-1.8577F, -17.2808F, -2.5417F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(-1.8577F, -17.2808F, -2.5417F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.degreeVec(-7.9397F, -21.3703F, -10.0735F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(-7.9397F, -21.3703F, -10.0735F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(58.9097F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(45.1597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(45.1597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(57.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(37.6234F, 1.3956F, 6.3217F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(37.6234F, 1.3956F, 6.3217F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(-64.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(-76.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(-54.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(-54.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofLeft",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(-17.0212F, 15.9483F, 3.6433F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(-17.0212F, 15.9483F, 3.6433F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(-14.2224F, 11.1045F, 4.9194F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(-14.2224F, 11.1045F, 4.9194F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(52.6597F, -1.0544F, -5.4887F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(52.6597F, -1.0544F, -5.4887F), Interpolations.LINEAR),
                  new Keyframe(2.5F, KeyframeAnimations.degreeVec(58.7012F, -5.5411F, 3.7213F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(-54.1649F, 1.3726F, -0.9571F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(-54.1649F, 1.3726F, -0.9571F), Interpolations.LINEAR),
                  new Keyframe(2.5F, KeyframeAnimations.degreeVec(-71.883F, -5.233F, -5.0606F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.5F, KeyframeAnimations.degreeVec(23.0725F, -1.374F, 3.036F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineCenter",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.2533F, -4.6484F, 0.9167F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(7.5518F, -12.3157F, -0.6188F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(7.6315F, -14.7938F, -0.9585F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(7.6493F, 10.6431F, 1.7058F), Interpolations.LINEAR),
                  new Keyframe(2.35F, KeyframeAnimations.degreeVec(7.6493F, 10.6431F, 1.7058F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(10.2533F, 5.3516F, -1.5833F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 8.5351F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-1.6408F, -19.5056F, 3.221F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-1.6681F, -22.0045F, 3.2982F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(-1.6681F, -22.0045F, 3.2982F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-0.2888F, 10.8328F, -2.4753F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(-0.1633F, 3.9056F, 0.4144F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 8.5351F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(1.8266F, 1.6188F, 5.4202F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(11.0464F, 0.181F, 2.4387F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.posVec(0.0976F, 2.3531F, 0.3891F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.posVec(-0.0545F, 1.9888F, -0.0409F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.posVec(0.0565F, 1.9829F, 0.2549F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(19.6105F, -11.1734F, -8.7325F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(4.099F, 8.9549F, -64.5955F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(3.2978F, 9.2777F, -69.6489F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-26.2417F, 7.9551F, -66.912F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(-40.8536F, 18.0891F, -43.4106F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-47.2907F, 14.5647F, -39.7003F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(-47.2907F, 14.5647F, -39.7003F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(8.7685F, 16.9416F, -51.2783F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.posVec(0.0F, -0.9962F, -0.0872F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-80.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(-79.9907F, -2.462F, -0.4344F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(-62.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.25F, KeyframeAnimations.degreeVec(-80.0093F, 0.434F, -2.4621F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.62F, 5.95F, 1.15F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-16.8502F, -3.6311F, -62.5178F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(-18.6293F, 10.8224F, -34.3553F), Interpolations.LINEAR),
                  new Keyframe(2.1F, KeyframeAnimations.degreeVec(-24.6385F, 41.1819F, -47.5377F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(-16.8502F, -3.6311F, -62.5178F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-14.9F, 7.32F, 8.52F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-16.5037F, -5.9032F, -31.6431F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(-16.9384F, -4.4638F, -26.835F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-17.4844F, -0.7515F, -14.8844F), Interpolations.LINEAR),
                  new Keyframe(0.95F, KeyframeAnimations.degreeVec(-17.4844F, 0.7515F, -10.1156F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-17.4375F, 1.5018F, -7.7303F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(-17.3593F, -2.2494F, -19.6566F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-18.1429F, 15.2099F, 30.0306F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 12.5F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 30.0F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 45.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 47.5F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 40.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 80.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-6.0205F, 4.0361F, 8.3965F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -35.0F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -17.5F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -15.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -27.5F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-4.2764F, 5.8539F, 28.3899F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 22.5F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 30.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 47.5F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 50.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 42.5F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(6.7086F, 9.571F, 12.3299F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(15.1291F, 1.5065F, -32.6291F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(14.8981F, -3.06F, -15.7294F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(14.7554F, -3.6999F, -13.3084F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(15.1624F, -1.1125F, -22.9773F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(9.5744F, 6.7089F, 32.3286F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(1.7F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.2F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFingerTip3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 40.0F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 52.5F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 45.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-82.57F, -67.46F, 90.14F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-56.0171F, -33.8662F, 75.9631F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-54.2045F, -17.4308F, 84.1974F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-53.0345F, -17.9608F, 80.5287F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(-44.9019F, -5.8049F, 89.529F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-17.776F, -1.0873F, 55.7603F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.posVec(0.5942F, 0.9772F, 0.0667F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumbTip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -52.5F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -72.5F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -40.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -35.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -52.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(-15.047F, -1.0871F, 12.4767F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.degreeVec(34.3857F, -6.7853F, 20.7173F), Interpolations.LINEAR),
                  new Keyframe(2.25F, KeyframeAnimations.degreeVec(41.8857F, -6.7853F, 20.7173F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.posVec(0.4966F, -0.9829F, -0.193F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.35F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.posVec(0.0F, -0.8F, -1.2F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.posVec(0.0F, 0.0F, -3.9F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-7.9691F, 78.8825F, 94.5937F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(-7.75F, -7.7F, -2.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(1.649F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chainStart",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(1.3433F, 3.0955F, 34.7562F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(-18.5366F, -4.8207F, 47.8619F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(-2.3206F, -29.479F, -8.4164F), Interpolations.LINEAR),
                  new Keyframe(2.55F, KeyframeAnimations.degreeVec(-3.29F, -9.5113F, -2.669F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(-10.1014F, -8.7616F, 17.0343F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "flame",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(4.1395F, 12.0F, -11.9951F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.posVec(4.1395F, 18.0F, -11.9951F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "flame",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(1.799F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(155.6387F, -61.4708F, -109.1043F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(155.6387F, -61.4708F, -109.1043F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-84.0396F, -78.6126F, 83.2974F), Interpolations.LINEAR),
                  new Keyframe(2.25F, KeyframeAnimations.degreeVec(-91.5396F, -78.6126F, 83.2974F), Interpolations.LINEAR),
                  new Keyframe(2.55F, KeyframeAnimations.degreeVec(-38.2713F, -74.6627F, 17.6251F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(-1.2601F, -72.098F, -0.617F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottomEnd",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0436F, -0.5101F, 0.8282F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "torso", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.5F, 15.0F, -14.5F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 12.5F, 15.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .build();
   }

   static AnimationDefinition initIdleAnim() {
      return Builder.withLength(2.0F)
         .looping()
         .addAnimation(
            "body",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "body",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "spineBottomEnd",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hips",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hips", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "legLeftMid",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "legLeftBottom",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "hoofLeft",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "legRightMid",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "spineCenter",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.2533F, 5.3516F, -1.5833F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(12.7533F, 5.3516F, -1.5833F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(10.2533F, 5.3516F, -1.5833F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(39.9011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 8.5351F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(-36.844F, -6.5042F, 8.5351F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 8.5351F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0436F, -0.5101F, 0.8282F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "torso", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(-0.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chainStart",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.4609F, 0.9101F, -10.9167F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(13.8675F, 4.6031F, -9.163F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(10.4609F, 0.9101F, -10.9167F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.5F, 15.0F, -14.5F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-7.5F, 10.0F, -10.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-12.5F, 15.0F, -14.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 12.5F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 15.0F, 17.5F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 12.5F, 15.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 2.5F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, -2.5F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(1.8F, 3.3F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "flame",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(6.0F, 17.0F, -7.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "flame", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "brokenArmGore2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-1.0565F, 5.1532F, -2.5434F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-1.0F, -1.5F, -0.5F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(2.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(1.5F, 5.0F, -2.5F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .build();
   }

   static AnimationDefinition initWalkAnim() {
      return Builder.withLength(2.0F)
         .looping()
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.1F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.1F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(4.5739F, -2.4438F, 5.1971F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottomEnd",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hips",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -5.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hips", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-35.3961F, -8.4319F, 1.9128F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(16.2976F, 7.9919F, -1.8195F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(-37.8961F, -8.4319F, 1.9128F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-35.3961F, -8.4319F, 1.9128F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.posVec(0.1F, 0.0F, 1.0F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(32.3984F, 2.1192F, 1.0E-4F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(35.4845F, 3.349F, -0.158F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(36.0705F, 4.5788F, -0.3162F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(33.1566F, 2.2894F, -0.1581F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(22.7427F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(58.5705F, 2.4596F, -0.3163F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(32.3984F, 2.1192F, 1.0E-4F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-44.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(-59.4512F, -0.271F, 0.583F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-61.7376F, 0.8307F, 0.209F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(-58.2866F, -0.366F, -1.1487F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-65.3356F, -1.5628F, -2.5065F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(-81.7376F, 2.2034F, -0.748F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(-81.7376F, 2.2034F, -0.748F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-44.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofLeft",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(38.13F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(39.69F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(30.75F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(20.63F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(22.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(33.33F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(38.13F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(16.2976F, -7.9919F, 1.8195F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(-37.8961F, 8.4319F, -1.9128F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-35.3961F, 8.4319F, -1.9128F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(11.2976F, -7.9919F, 1.8195F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-0.1F, 0.0F, 1.0F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(-0.1F, 0.0F, 1.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(22.7427F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(66.0705F, -2.4596F, 0.3163F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(32.3984F, -2.1192F, -1.0E-4F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(35.4845F, -3.349F, 0.158F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(36.0705F, -4.5788F, 0.3162F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(33.1566F, -2.2894F, 0.1581F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(32.7427F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-65.3356F, 1.5628F, 2.5065F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(-81.7376F, -2.2034F, 0.748F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(-81.7376F, -2.2034F, 0.748F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-44.1649F, 1.3726F, -0.9571F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(-59.4512F, 0.271F, -0.583F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-61.7376F, -0.8307F, -0.209F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(-58.2866F, 0.366F, 1.1487F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-63.3356F, 1.5628F, 2.5065F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(22.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(33.33F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(38.13F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(39.69F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(30.75F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(20.63F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(22.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineCenter",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(13.4791F, 2.234F, 0.4505F), Interpolations.LINEAR),
                  new Keyframe(0.05F, KeyframeAnimations.degreeVec(14.7233F, 2.1283F, 0.4239F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(13.93F, 1.61F, -2.09F), Interpolations.LINEAR),
                  new Keyframe(0.95F, KeyframeAnimations.degreeVec(10.7393F, 3.3903F, -4.4152F), Interpolations.LINEAR),
                  new Keyframe(1.05F, KeyframeAnimations.degreeVec(13.2393F, 3.3903F, -4.4152F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(13.1F, 3.39F, -4.42F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.degreeVec(12.2348F, 2.3402F, 0.4747F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(13.4791F, 2.234F, 0.4505F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(37.4011F, 2.6841F, -4.22F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-32.5232F, -0.7068F, -1.1335F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-31.2474F, -1.0525F, -1.4199F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(-33.7996F, -0.3652F, -0.8534F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(-33.6945F, 1.7137F, -2.2461F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-32.4139F, 1.4025F, -2.48F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-31.1345F, 1.0863F, -2.7195F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(-33.7996F, -0.3652F, -0.8534F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(-33.7996F, -0.3652F, -0.8534F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-32.5232F, -0.7068F, -1.1335F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.17F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.95F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(9.17F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.5274F, -0.2156F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0436F, -0.5101F, 0.8282F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "torso", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(18.1573F, -1.1194F, 2.33F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-20.0F, 2.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(18.1573F, -1.1194F, 2.33F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(1.0F, KeyframeAnimations.posVec(-0.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-0.2624F, 18.5388F, -4.7891F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFingerTip2",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFingerTip3",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "chainStart",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(7.9609F, 0.9101F, -8.4167F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(5.96F, 0.91F, -6.42F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(4.96F, 0.91F, -4.42F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(4.96F, 0.91F, -4.42F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(10.4609F, 0.9101F, -10.9167F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(7.9609F, 0.9101F, -8.4167F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(7.5F, 27.5F, -12.5F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(0.0F, 22.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-2.5F, 27.03F, 6.29F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(0.0F, 33.06F, 3.0F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(2.5F, 35.28F, -9.75F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(5.0F, 35.28F, -12.25F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(7.5F, 27.5F, -12.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmGore2",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.5F, 15.0F, -14.5F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(-13.1964F, 16.4854F, -19.5487F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-20.0751F, 18.3297F, -28.8895F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(14.1025F, 7.4502F, 0.6377F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(12.688F, 4.7856F, 3.5047F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-12.5F, 15.0F, -14.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.865F, 8.3133F, 12.2626F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(9.865F, 8.3133F, 12.2626F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(24.865F, 8.3133F, 12.2626F), Interpolations.LINEAR),
                  new Keyframe(0.95F, KeyframeAnimations.degreeVec(27.365F, 8.3133F, 12.2626F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(9.865F, 8.3133F, 12.2626F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.05F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2tip",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife2",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3tip",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "flame",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(6.0F, 17.0F, -7.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "flame", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .build();
   }

   static AnimationDefinition initHoldLanternPose() {
      return Builder.withLength(0.0F)
         .looping()
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(8.7685F, 16.9416F, -51.2783F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(-0.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-16.8502F, -3.6311F, -62.5178F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-18.1429F, 15.2099F, 30.0306F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFingerTip1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 80.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFinger2",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-4.2764F, 5.8539F, 28.3899F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "leftFingerTip2",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.5744F, 6.7089F, 32.3286F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.2F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFingerTip3",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.776F, -1.0873F, 55.7603F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "thumbTip",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -52.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-7.9691F, 78.8825F, 94.5937F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(-7.75F, -7.7F, -2.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "handle",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, 2.5F, 5.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "chainStart",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-10.1014F, -8.7616F, 17.0343F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "chain1",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-4.5556F, -71.3182F, 5.4048F), Interpolations.LINEAR)}
            )
         )
         .build();
   }

   static AnimationDefinition initNoLanternPose() {
      return Builder.withLength(0.0F)
         .addAnimation(
            "spineCenter",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 2.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "head",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, -5.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(19.6105F, -11.1734F, -8.7325F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(-0.2F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hand",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.62F, 5.95F, 1.15F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hand",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-14.9F, 7.32F, 8.52F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFingerTip1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 12.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFinger2",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-6.0205F, 4.0361F, 8.3965F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "leftFingerTip2",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 22.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(6.7086F, 9.571F, 12.3299F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "leftFingerTip3",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 15.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-82.57F, -67.46F, 90.14F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "thumbTip",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -52.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .build();
   }

   static AnimationDefinition initShowClawPose() {
      return Builder.withLength(0.0F)
         .looping()
         .addAnimation(
            "spineCenter",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(7.6151F, 12.9126F, -2.1494F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 17.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(47.2947F, 20.3671F, 44.3488F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-52.1015F, 38.0036F, -18.5428F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.4673F, -1.3712F, -0.605F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(23.224F, -7.5832F, 10.0906F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "finger1tip",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(57.679F, -4.1157F, -2.1768F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "finger2tip",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(46.282F, 3.5796F, -8.6772F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "finger3tip",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, -2.5F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "flame",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(-17.0F, -6.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "chainStart",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(7.2F, 0.0F, -6.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "chain1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-0.5F, -9.0F, -1.0F), Interpolations.LINEAR)})
         )
         .build();
   }

   static AnimationDefinition initShowClawNoExtrasPose() {
      return Builder.withLength(0.0F)
         .looping()
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(47.2947F, 20.3671F, 44.3488F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-52.1015F, 38.0036F, -18.5428F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.4673F, -1.3712F, -0.605F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(23.224F, -7.5832F, 10.0906F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "finger1tip",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(57.679F, -4.1157F, -2.1768F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "finger2tip",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(46.282F, 3.5796F, -8.6772F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "finger3tip",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, -2.5F, 0.0F), Interpolations.LINEAR)})
         )
         .build();
   }

   static AnimationDefinition initNoClawPose() {
      return Builder.withLength(0.0F)
         .looping()
         .addAnimation(
            "brokenArm",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 7.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.5107F, -0.9928F, 0.06F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "brokenArmGore1",
            new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "brokenArmGore2",
            new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .build();
   }

   static AnimationDefinition initRunAnim() {
      return Builder.withLength(2.0F)
         .looping()
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(22.5F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(22.5F, 7.5F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.posVec(0.0F, -2.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.posVec(0.0F, -2.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.posVec(0.0F, -2.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.posVec(0.0F, -2.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-55.83F, -17.6906F, 0.9791F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-0.2507F, 0.8608F, -1.2818F), Interpolations.LINEAR),
                  new Keyframe(0.95F, KeyframeAnimations.degreeVec(6.5875F, 11.0808F, -2.6265F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(3.2913F, 13.0272F, -1.9922F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(-55.7724F, -14.5422F, 0.7154F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-55.83F, -17.6906F, 0.9791F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-0.6678F, 0.4294F, -1.1703F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.posVec(0.0493F, 0.266F, 1.905F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(-0.6678F, 0.4294F, -1.1703F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(73.67F, -1.61F, 2.15F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(57.3367F, -1.61F, 2.15F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(78.17F, -1.61F, 2.15F), Interpolations.LINEAR),
                  new Keyframe(0.95F, KeyframeAnimations.degreeVec(81.17F, -1.61F, 2.15F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(80.78F, -1.61F, 2.15F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(73.67F, -1.61F, 2.15F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(73.67F, -1.61F, 2.15F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-78.7F, -0.21F, -2.78F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-38.7F, -0.21F, -2.78F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(-31.2F, -0.21F, -2.78F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(-63.7F, -0.21F, -2.78F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-78.7F, -0.21F, -2.78F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofLeft",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(29.9719F, -0.7975F, 0.7311F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(8.5296F, -0.7975F, 0.7311F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(8.2219F, -0.7975F, 0.7311F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(49.9719F, -0.7975F, 0.7311F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(29.9719F, -0.7975F, 0.7311F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.2913F, -13.0272F, 1.9922F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(-56.0342F, 8.9756F, -1.2085F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-55.6951F, 12.3094F, -0.9897F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-0.2507F, -0.8608F, 1.2818F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.degreeVec(6.5875F, -11.0808F, 1.2818F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(3.2913F, -13.0272F, 1.9922F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0493F, 0.266F, 1.905F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.posVec(0.6678F, 0.4294F, -1.1703F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(0.0493F, 0.266F, 1.905F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(81.04F, -1.61F, 2.15F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(80.78F, -1.61F, 2.15F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(73.67F, -1.61F, 2.15F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(73.67F, -1.61F, 2.15F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(73.67F, -1.61F, 2.15F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(57.3367F, -1.61F, 2.15F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.degreeVec(78.17F, -1.61F, 2.15F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.degreeVec(81.17F, -1.61F, 2.15F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(81.04F, -1.61F, 2.15F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-43.7F, -0.21F, -2.78F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(-63.7F, -0.21F, -2.78F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-78.7F, -0.21F, -2.78F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(-38.7F, -0.21F, -2.78F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(-31.2F, -0.21F, -2.78F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-43.7F, -0.21F, -2.78F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(49.9719F, -0.7975F, 0.7311F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(29.9719F, -0.7975F, 0.7311F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(8.5296F, -0.7975F, 0.7311F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(8.2219F, -0.7975F, 0.7311F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(49.9719F, -0.7975F, 0.7311F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.0F, -5.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 2.0F, -5.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineCenter",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(14.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(12.5115F, 2.4407F, 0.5414F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(14.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.56F, -8.29F, 4.18F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-38.5563F, -8.2887F, 4.1788F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-41.0563F, -8.2887F, 4.1788F), Interpolations.LINEAR),
                  new Keyframe(0.95F, KeyframeAnimations.degreeVec(-43.5563F, -8.2887F, 4.1788F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(-38.5563F, -8.2887F, 4.1788F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-41.0563F, -8.2887F, 4.1788F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.degreeVec(-43.5563F, -8.2887F, 4.1788F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-42.56F, -8.29F, 4.18F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.99F, 0.09F, 0.2F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(9.9722F, 0.1524F, 0.5987F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(7.4831F, 0.1128F, 0.4F), Interpolations.LINEAR),
                  new Keyframe(1.05F, KeyframeAnimations.degreeVec(2.4956F, 0.0582F, 0.0014F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(9.9722F, 0.1524F, 0.5987F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(7.4831F, 0.1128F, 0.4F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(4.99F, 0.09F, 0.2F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-0.02F, 1.11F, -0.11F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.posVec(-0.0213F, 0.7098F, -0.1557F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.posVec(-0.0173F, 1.0061F, -0.1088F), Interpolations.LINEAR),
                  new Keyframe(1.05F, KeyframeAnimations.posVec(-0.0176F, 1.3091F, -0.0874F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.posVec(-0.0213F, 0.7098F, -0.1557F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.posVec(-0.0173F, 1.0061F, -0.1088F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(-0.02F, 1.11F, -0.11F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(-0.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "flame", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hips",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-1.5975F, -19.9303F, 5.3144F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(7.95F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(7.95F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.2F), Interpolations.LINEAR)})
         )
         .build();
   }

   static AnimationDefinition initPrepareRunAttack() {
      return Builder.withLength(1.0F)
         .addAnimation(
            "body",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -3.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -4.2F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "spineBottomEnd",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hips",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hips", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(-70.0515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-27.0515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-35.0515F, -9.6905F, -0.2746F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "legLeftMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(87.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(66.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(69.9597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(75.1597F, 1.0544F, 5.4887F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(-60.4149F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-71.6649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-74.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-71.6649F, -1.3726F, 0.9571F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofLeft",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(36.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(28.9429F, -0.8391F, 9.0314F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(31.4429F, -0.8391F, 9.0314F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "legRightMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(32.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(32.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-61.8103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-61.8103F, -3.0341F, 0.539F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "spineCenter",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.2533F, 5.3516F, -1.5833F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(15.2533F, 5.3516F, -1.5833F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineTop",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 8.5351F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-44.344F, -6.5042F, 8.5351F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 3.03F, -0.22F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0436F, -0.5101F, 0.8282F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "torso", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(8.8914F, -1.4598F, 4.9805F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(11.6383F, -7.0152F, 5.606F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(-0.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFingerTip1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFingerTip2",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFingerTip3",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "chainStart",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.4609F, 0.9101F, -10.9167F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "chain1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(2.5447F, 7.0417F, 3.1486F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.7399F, 1.6835F, 4.4826F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmGore2",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.5F, 15.0F, -14.5F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 12.5F, 15.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "finger2tip",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife2",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "finger3tip",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "flame",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(6.0F, 17.0F, -7.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "flame", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .build();
   }

   static AnimationDefinition initRunLanternAnim() {
      return Builder.withLength(2.0F)
         .looping()
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(14.9721F, -32.7419F, 3.4335F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(17.6266F, -27.427F, -8.1905F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(14.9721F, -32.7419F, 3.4335F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-0.1499F, 11.9626F, 3.8645F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(-0.7201F, -7.6155F, 12.5259F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-0.1499F, 11.9626F, 3.8645F), Interpolations.LINEAR)
               }
            )
         )
         .build();
   }

   static AnimationDefinition initRunLanternDragAnim() {
      return Builder.withLength(4.0F)
         .looping()
         .addAnimation(
            "spineCenter",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-0.3655F, -20.9089F, -0.8652F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-0.473F, 18.9591F, -19.5206F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 37.5F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 37.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(30.6174F, -2.3863F, -0.2399F), Interpolations.LINEAR),
                  new Keyframe(3.0F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(111.1532F, -28.5181F, -13.1237F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(110.4587F, -23.8048F, -11.2216F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(110.6181F, -26.3006F, -11.3337F), Interpolations.LINEAR),
                  new Keyframe(3.0F, KeyframeAnimations.degreeVec(110.4587F, -23.8048F, -11.2216F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(111.1532F, -28.5181F, -13.1237F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "handle",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(29.5144F, 3.1445F, -6.8271F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "chainStart",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0308F, 2.8143F, -6.8609F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-5.0577F, 4.1643F, -5.6693F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-8.9246F, 5.4856F, -4.5215F), Interpolations.LINEAR),
                  new Keyframe(3.0F, KeyframeAnimations.degreeVec(-9.8304F, 6.6918F, -4.4521F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-5.0308F, 2.8143F, -6.8609F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(39.088F, 1.9827F, -40.1263F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(96.4144F, -6.7161F, -97.1897F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(60.48F, 0.05F, -62.3F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(32.5344F, 2.1516F, -35.0508F), Interpolations.LINEAR),
                  new Keyframe(3.0F, KeyframeAnimations.degreeVec(24.5452F, 6.8077F, -27.4172F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(39.088F, 1.9827F, -40.1263F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.2462F, 0.0093F, -7.4896F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(-2.0696F, 2.8625F, -6.7816F), Interpolations.LINEAR),
                  new Keyframe(3.1F, KeyframeAnimations.degreeVec(4.0999F, -5.4667F, 5.4667F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.2462F, 0.0093F, -7.4896F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain2",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-0.1261F, -0.1505F, -15.0096F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-4.9042F, 1.3152F, -5.1264F), Interpolations.LINEAR),
                  new Keyframe(3.45F, KeyframeAnimations.degreeVec(3.207F, -6.3013F, -6.4831F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-0.1261F, -0.1505F, -15.0096F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain3",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain4",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.9026F, -0.7385F, -7.9076F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(0.7432F, 0.5166F, -10.7593F), Interpolations.LINEAR),
                  new Keyframe(3.2F, KeyframeAnimations.degreeVec(1.4053F, -1.6396F, -10.0707F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.9026F, -0.7385F, -7.9076F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain4",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "chain5",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.6685F, 0.3524F, -9.9649F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-4.3129F, -2.3369F, -11.7782F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-0.8877F, -1.6272F, -17.733F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(2.0713F, -1.9349F, -8.6249F), Interpolations.LINEAR),
                  new Keyframe(2.5F, KeyframeAnimations.degreeVec(3.7472F, -2.1545F, -15.793F), Interpolations.LINEAR),
                  new Keyframe(3.0F, KeyframeAnimations.degreeVec(7.1982F, -2.7845F, -25.3321F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(4.6685F, 0.3524F, -9.9649F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain5",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain6",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-3.8527F, -19.9563F, -5.5569F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(-1.12F, -7.18F, -13.82F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-0.5854F, -3.6075F, -24.0138F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.4407F, -3.0418F, -27.7048F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(3.3932F, -2.412F, -26.5733F), Interpolations.LINEAR),
                  new Keyframe(3.0F, KeyframeAnimations.degreeVec(2.1175F, 2.6101F, -15.065F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-3.8527F, -19.9563F, -5.5569F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain6",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .build();
   }

   static AnimationDefinition initRunClawAnim() {
      return Builder.withLength(4.0F)
         .looping()
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-107.7823F, -15.7391F, -12.6868F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(-1.2616F, -5.1277F, -5.7513F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-46.3264F, 18.002F, -5.218F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-107.7823F, -15.7391F, -12.6868F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.degreeVec(-1.2616F, -5.1277F, -5.7513F), Interpolations.LINEAR),
                  new Keyframe(3.1F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.5F, KeyframeAnimations.degreeVec(-46.3264F, 18.002F, -5.218F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-107.7823F, -15.7391F, -12.6868F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.1F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(-14.4008F, 7.6222F, -17.4824F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(1.7188F, 31.9975F, 18.1729F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.degreeVec(-14.4008F, 7.6222F, -17.4824F), Interpolations.LINEAR),
                  new Keyframe(3.1F, KeyframeAnimations.degreeVec(1.7188F, 31.9975F, 18.1729F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.0F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.0F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .build();
   }

   static AnimationDefinition initRunClawDragAnim() {
      return Builder.withLength(2.0F)
         .looping()
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.8722F, -4.5678F, -15.2764F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-10.5169F, -29.8469F, -19.3705F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-18.0169F, -29.8469F, -19.3705F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-10.5169F, -29.8469F, -19.3705F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-18.0169F, -29.8469F, -19.3705F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-10.5169F, -29.8469F, -19.3705F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(186.0954F, -29.1142F, -172.0498F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(191.0954F, -29.1142F, -172.0498F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(186.0954F, -29.1142F, -172.0498F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(191.0954F, -29.1142F, -172.0498F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(186.0954F, -29.1142F, -172.0498F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-11.87F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(-11.87F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(-11.87F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(-11.87F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-27.3315F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-24.8315F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-24.8315F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-25.6649F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(-22.3315F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-27.3315F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(-24.8315F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(-24.8315F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(-25.6649F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(-22.3315F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-27.3315F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-24.8315F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(-24.8315F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(-25.6649F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(-22.3315F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-27.3315F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(-24.8315F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-24.8315F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(-25.6649F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(-22.3315F, 4.7317F, 1.6251F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-27.3315F, 4.7317F, 1.6251F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-14.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-14.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-16.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-14.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 20.0F, 0.0F), Interpolations.LINEAR)})
         )
         .build();
   }

   static AnimationDefinition initLanternSideSwingAnim() {
      return Builder.withLength(2.45F)
         .addAnimation(
            "body",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "body",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(0.1205F, -30.4286F, 3.4956F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(0.1205F, -30.4286F, 3.4956F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(-1.0254F, 24.5514F, 0.8628F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-1.0254F, 24.5514F, 0.8628F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottomEnd",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hips",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(0.0F, -2.5F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hips", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(16.0543F, -7.6833F, -7.5854F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(16.0543F, -7.6833F, -7.5854F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(-36.7593F, -12.1853F, -1.039F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-36.7593F, -12.1853F, -1.039F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.posVec(-1.335F, 0.2577F, 2.4548F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.posVec(-1.335F, 0.2577F, 2.4548F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.posVec(-1.335F, 0.2577F, 2.4548F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(27.4829F, 3.7473F, 1.2718F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(27.4829F, 3.7473F, 1.2718F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(77.4829F, 3.7473F, 1.2718F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(54.9829F, 3.7473F, 1.2718F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(54.9829F, 3.7473F, 1.2718F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-64.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-64.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(-84.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(-49.1571F, 0.5186F, 2.5922F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-49.1571F, 0.5186F, 2.5922F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofLeft",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(-6.5955F, 11.8703F, 3.8141F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(-22.9627F, 9.0581F, -3.2735F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-22.9627F, 9.0581F, -3.2735F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(16.6193F, -2.6711F, 0.9954F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(16.6193F, -2.6711F, 0.9954F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.posVec(1.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(65.9927F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(49.9245F, 0.0031F, 1.2287F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(49.9245F, 0.0031F, 1.2287F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(39.9245F, 0.0031F, 1.2287F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(39.9245F, 0.0031F, 1.2287F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(-69.2204F, -1.7563F, -1.6117F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(-51.7328F, -1.487F, -1.4263F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-51.7328F, -1.487F, -1.4263F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(-79.2328F, -1.487F, -1.4263F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-79.2328F, -1.487F, -1.4263F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineCenter",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.2533F, 5.3516F, -1.5833F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(10.9957F, -21.695F, -6.6582F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(11.1992F, -24.1483F, -7.1806F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(11.2773F, 25.0073F, 2.2685F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(14.0208F, 27.458F, 2.8193F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(14.0208F, 27.458F, 2.8193F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(10.2533F, 5.3516F, -1.5833F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(37.4818F, 0.3569F, 0.2498F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 8.5351F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-36.6733F, 20.1963F, -10.3082F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-36.6733F, 20.1963F, -10.3082F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(-32.7828F, 1.7357F, -7.8572F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-32.9648F, 5.9358F, -10.5767F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.degreeVec(-44.1557F, -24.0632F, 24.3623F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 8.5351F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.95F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 3.28F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.posVec(0.0F, 3.28F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(0.95F, KeyframeAnimations.posVec(0.0F, 2.28F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.posVec(0.0F, 2.28F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0436F, -0.5101F, 0.8282F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "torso", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(8.7685F, 16.9416F, -51.2783F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(26.6316F, 19.18F, -50.1071F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(29.1316F, 19.18F, -50.1071F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(29.1316F, 19.18F, -50.1071F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(-49.645F, 21.1127F, -67.653F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-54.645F, 21.1127F, -67.653F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(8.7685F, 16.9416F, -51.2783F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(11.2685F, 16.9416F, -51.2783F), Interpolations.LINEAR),
                  new Keyframe(2.4F, KeyframeAnimations.degreeVec(8.7685F, 16.9416F, -51.2783F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.posVec(-0.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.posVec(-0.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(-72.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.2F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.4F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-16.8502F, -3.6311F, -62.5178F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-19.8239F, -30.7334F, -53.1852F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-17.1232F, 10.7215F, -66.897F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(-17.9607F, 20.259F, -70.0211F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(-30.0145F, 36.9514F, -83.1384F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(-21.6251F, 11.2872F, -59.899F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(-25.2908F, 6.6846F, -55.7835F), Interpolations.LINEAR),
                  new Keyframe(2.4F, KeyframeAnimations.degreeVec(-16.8502F, -3.6311F, -62.5178F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-18.1429F, 15.2099F, 30.0306F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFingerTip1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 80.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFinger2",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-4.2764F, 5.8539F, 28.3899F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "leftFingerTip2",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.5744F, 6.7089F, 32.3286F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.2F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFingerTip3",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.776F, -1.0873F, 55.7603F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "thumbTip",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -52.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-7.9691F, 78.8825F, 94.5937F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(-7.75F, -7.7F, -2.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "handle",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, 2.5F, 5.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "chainStart",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.0278F, -10.733F, 4.5085F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(7.4316F, -7.7148F, -28.7453F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(7.1474F, -7.505F, -28.2793F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(1.0737F, -10.8684F, 9.5969F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(1.0737F, -10.8684F, 9.5969F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(24.5445F, 8.3021F, -31.3197F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(14.5573F, 11.8194F, -32.8573F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(9.5573F, 11.8194F, -32.8573F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(9.5573F, 11.8194F, -32.8573F), Interpolations.LINEAR),
                  new Keyframe(2.25F, KeyframeAnimations.degreeVec(15.0621F, 1.7145F, 11.3779F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.degreeVec(2.0278F, -10.733F, 4.5085F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hull",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.scaleVec(0.9F, 1.1F, 1.5), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-30.8393F, -3.4553F, 34.7989F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-33.3393F, -3.4553F, 34.7989F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(24.1607F, -3.4553F, 34.7989F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(39.16F, -3.46F, 29.8F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.posVec(0.5107F, -0.9928F, 0.06F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.posVec(0.5107F, -0.9928F, 0.06F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.posVec(-0.2128F, -0.5979F, -0.4553F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.posVec(-0.2128F, -0.5979F, -0.4553F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.05F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.05F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.05F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.05F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.05F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.05F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.05F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "flame",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(6.0F, 17.0F, -7.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "flame", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "chain1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-4.5556F, -71.3182F, 5.4048F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-47.0556F, -71.3182F, 5.4048F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(-47.0556F, -71.3182F, 5.4048F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-4.5556F, -71.3182F, 5.4048F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(10.4444F, -71.3182F, 5.4048F), Interpolations.LINEAR),
                  new Keyframe(0.95F, KeyframeAnimations.degreeVec(12.9444F, -71.3182F, 5.4048F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(12.9444F, -71.3182F, 5.4048F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(48.5359F, -61.8713F, -33.0297F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(23.5359F, -61.8713F, -33.0297F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(23.5359F, -61.8713F, -33.0297F), Interpolations.LINEAR),
                  new Keyframe(2.05F, KeyframeAnimations.degreeVec(23.5359F, -61.8713F, -33.0297F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(4.3875F, -75.9206F, 15.6592F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.degreeVec(-4.5556F, -71.3182F, 5.4048F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(24.5623F, 4.2453F, -11.7678F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-17.9377F, 4.2453F, -11.7678F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.degreeVec(-17.9377F, 4.2453F, -11.7678F), Interpolations.LINEAR),
                  new Keyframe(2.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain2",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.35F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.05F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain3",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.45F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain4",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(14.1F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.05F, KeyframeAnimations.degreeVec(23.53F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(23.53F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(40.1851F, -51.9555F, -29.5418F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(23.3503F, -2.987F, 6.8826F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(-16.47F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.degreeVec(-18.97F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain4",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.55F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .build();
   }

   static AnimationDefinition initLanternSlamAnim() {
      return Builder.withLength(5.8F)
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.9F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.posVec(0.0F, -1.8F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.posVec(0.0F, -1.8F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.9F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(12.0739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(12.0739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(4.6084F, 7.4278F, -4.7955F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(4.6084F, 7.4278F, -4.7955F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(29.6084F, 7.4278F, -4.7955F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(29.6084F, 7.4278F, -4.7955F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.posVec(0.0F, -0.4F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.posVec(0.0F, -0.4F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottomEnd",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hips",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hips",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(5.799F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-37.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-37.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-35.0515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(-27.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-27.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.posVec(-1.147F, -0.4633F, 1.3739F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.posVec(-1.147F, -0.4633F, 1.3739F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(67.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(67.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(76.0468F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(57.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(57.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-61.6649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-61.6649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-68.5197F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(-64.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-64.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofLeft",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-25.6157F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-25.6157F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(-38.9588F, 10.5985F, 4.5638F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-38.9588F, 10.5985F, 4.5638F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(57.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(57.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(57.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(57.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-74.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-74.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(-69.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-69.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineCenter",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.2533F, 5.3516F, -1.5833F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(33.3334F, -12.34F, -10.9664F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(38.3334F, -12.34F, -10.9664F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(35.2084F, -12.34F, -10.9664F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-12.4513F, 12.7414F, -2.8815F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-16.3728F, 17.599F, -4.1091F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-16.3728F, 17.599F, -4.1091F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(16.0433F, -18.4734F, 6.3145F), Interpolations.LINEAR),
                  new Keyframe(3.35F, KeyframeAnimations.degreeVec(21.0433F, -18.4734F, 6.3145F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(21.0433F, -18.4734F, 6.3145F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(10.2533F, 5.3516F, -1.5833F), Interpolations.LINEAR),
                  new Keyframe(4.45F, KeyframeAnimations.degreeVec(10.7179F, 17.6445F, 0.7337F), Interpolations.LINEAR),
                  new Keyframe(4.6F, KeyframeAnimations.degreeVec(10.8132F, 18.7349F, 0.9647F), Interpolations.LINEAR),
                  new Keyframe(4.7F, KeyframeAnimations.degreeVec(10.8711F, -19.2593F, -6.1665F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(10.2533F, -4.6484F, 0.9167F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(27.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(4.6F, KeyframeAnimations.degreeVec(14.9011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 8.5351F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.degreeVec(-29.4715F, 7.9698F, -1.3284F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-29.47F, 7.97F, -1.33F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-4.6283F, -16.9537F, 0.6433F), Interpolations.LINEAR),
                  new Keyframe(4.6F, KeyframeAnimations.degreeVec(-26.4863F, -13.7139F, 7.6586F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(-34.344F, -1.5042F, 3.5351F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.35F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.3F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.8F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 3.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.posVec(0.0F, 3.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(2.35F, KeyframeAnimations.posVec(0.0F, 1.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.posVec(0.0F, 1.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(3.3F, KeyframeAnimations.posVec(0.0F, 1.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(3.8F, KeyframeAnimations.posVec(0.0F, 3.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.posVec(0.0F, 3.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0436F, -0.5101F, 0.8282F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(0.0436F, -0.5101F, 0.8282F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(5.799F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(8.7685F, 16.9416F, -51.2783F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-21.3377F, 0.9083F, -15.1628F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-21.3377F, 0.9083F, -15.1628F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-26.3377F, 0.9083F, -15.1628F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(-149.0975F, -25.7013F, 20.1036F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-151.5975F, -25.7013F, 20.1036F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.degreeVec(-79.3689F, 3.1254F, 6.6953F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-79.37F, 3.13F, 6.7F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-31.9417F, -2.1649F, -1.7865F), Interpolations.LINEAR),
                  new Keyframe(4.45F, KeyframeAnimations.degreeVec(-41.1961F, 10.6219F, -59.5705F), Interpolations.LINEAR),
                  new Keyframe(4.6F, KeyframeAnimations.degreeVec(-54.4669F, 17.5971F, -63.919F), Interpolations.LINEAR),
                  new Keyframe(4.7F, KeyframeAnimations.degreeVec(22.1534F, -0.766F, -49.7546F), Interpolations.LINEAR),
                  new Keyframe(4.9F, KeyframeAnimations.degreeVec(32.1534F, -0.766F, -49.7546F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(19.6105F, -11.1734F, -8.7325F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.posVec(-0.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.posVec(-0.7F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-61.25F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.45F, KeyframeAnimations.degreeVec(-72.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.6F, KeyframeAnimations.degreeVec(-85.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.7F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.9F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-16.8502F, -3.6311F, -62.5178F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-18.5419F, 17.099F, -71.6623F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(-10.1382F, 22.3948F, -62.2644F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-10.1382F, 22.3948F, -62.2644F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(-26.5291F, 8.7483F, -23.0854F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.degreeVec(18.4709F, 8.7483F, -23.0854F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(9.1323F, 13.2162F, -45.5604F), Interpolations.LINEAR),
                  new Keyframe(4.9F, KeyframeAnimations.degreeVec(1.01F, 7.95F, -50.86F), Interpolations.LINEAR),
                  new Keyframe(5.15F, KeyframeAnimations.degreeVec(1.6249F, 5.9453F, 1.1495F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-18.1429F, 15.2099F, 30.0306F), Interpolations.LINEAR),
                  new Keyframe(4.65F, KeyframeAnimations.degreeVec(-18.14F, 15.21F, 30.03F), Interpolations.LINEAR),
                  new Keyframe(4.75F, KeyframeAnimations.degreeVec(-14.9F, 7.3203F, 8.5207F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFingerTip1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 80.0F), Interpolations.LINEAR),
                  new Keyframe(4.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 80.0F), Interpolations.LINEAR),
                  new Keyframe(4.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 12.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-4.2764F, 5.8539F, 28.3899F), Interpolations.LINEAR),
                  new Keyframe(4.65F, KeyframeAnimations.degreeVec(-4.28F, 5.85F, 28.39F), Interpolations.LINEAR),
                  new Keyframe(4.75F, KeyframeAnimations.degreeVec(-6.0205F, 4.0361F, 8.3965F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(4.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(4.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 22.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.5744F, 6.7089F, 32.3286F), Interpolations.LINEAR),
                  new Keyframe(4.65F, KeyframeAnimations.degreeVec(9.57F, 6.71F, 32.33F), Interpolations.LINEAR),
                  new Keyframe(4.75F, KeyframeAnimations.degreeVec(6.7086F, 9.571F, 12.3299F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.2F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFingerTip3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(4.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(4.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 15.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.776F, -1.0873F, 55.7603F), Interpolations.LINEAR),
                  new Keyframe(4.65F, KeyframeAnimations.degreeVec(-17.78F, -1.09F, 55.76F), Interpolations.LINEAR),
                  new Keyframe(4.75F, KeyframeAnimations.degreeVec(-17.7071F, 1.9646F, 65.2835F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(-82.57F, -67.46F, 90.14F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "thumbTip",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -52.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-7.9691F, 78.8825F, 94.5937F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(-7.75F, -7.7F, -2.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "handle",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, 2.5F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-5.0F, 2.5F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(7.5F, 2.5F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(7.5F, 2.5F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(32.5F, 2.5F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.degreeVec(44.7356F, 6.0285F, 1.447F), Interpolations.LINEAR),
                  new Keyframe(4.7F, KeyframeAnimations.degreeVec(44.7356F, 6.0285F, 1.447F), Interpolations.LINEAR),
                  new Keyframe(4.9F, KeyframeAnimations.degreeVec(18.5621F, -41.048F, 42.3277F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "handle",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.7F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.9F, KeyframeAnimations.posVec(-57.9746F, -31.9406F, 15.5801F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "handle",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(4.7F, KeyframeAnimations.scaleVec(1.0, 1.1F, 1.0), Interpolations.LINEAR),
                  new Keyframe(4.9F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chainStart",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.3595F, -8.1485F, 6.1176F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(2.4991F, -10.6342F, 1.9664F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(2.4991F, -10.6342F, 1.9664F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(-1.8099F, -10.7714F, 24.8697F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(2.9654F, -10.515F, -0.5739F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(2.9654F, -10.515F, -0.5739F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(2.9654F, -10.515F, -0.5739F), Interpolations.LINEAR),
                  new Keyframe(4.6F, KeyframeAnimations.degreeVec(1.0737F, -10.8684F, 9.5969F), Interpolations.LINEAR),
                  new Keyframe(4.7F, KeyframeAnimations.degreeVec(5.6051F, -9.3875F, -15.7615F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hull",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(2.649F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.scaleVec(0.8F, 1.0, 1.9F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(2.899F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(2.9F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(40.0F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(4.7F, KeyframeAnimations.degreeVec(7.4366F, -0.9762F, 14.9366F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.posVec(0.5107F, -0.9928F, 0.06F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.posVec(0.5107F, -0.9928F, 0.06F), Interpolations.LINEAR),
                  new Keyframe(4.7F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.posVec(0.0F, -0.8725F, -1.552F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -1.3287F, -2.1153F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.posVec(0.0F, -1.4284F, -2.7527F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.posVec(0.0F, -1.0492F, -1.9104F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, -1.0492F, -1.9104F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, -0.9576F, -1.8717F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.posVec(0.0F, -0.9576F, -1.8717F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(10.0F, -8.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(10.0F, -8.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "flame",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(6.0F, 17.0F, -7.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "flame", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "chain1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-4.5556F, -71.3182F, 5.4048F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(7.6597F, -71.0715F, -10.1304F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(7.6597F, -71.0715F, -10.1304F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(210.8606F, -78.4812F, -171.5236F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(163.3606F, -78.4812F, -171.5236F), Interpolations.LINEAR),
                  new Keyframe(2.4F, KeyframeAnimations.degreeVec(143.3477F, -76.203F, -151.0266F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(143.3477F, -76.203F, -151.0266F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(128.3477F, -76.203F, -151.0266F), Interpolations.LINEAR),
                  new Keyframe(2.8F, KeyframeAnimations.degreeVec(145.8477F, -76.203F, -151.0266F), Interpolations.LINEAR),
                  new Keyframe(3.2F, KeyframeAnimations.degreeVec(165.8477F, -76.203F, -151.0266F), Interpolations.LINEAR),
                  new Keyframe(3.35F, KeyframeAnimations.degreeVec(126.5263F, -58.8168F, -98.7059F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(135.6892F, -64.4894F, -109.0981F), Interpolations.LINEAR),
                  new Keyframe(4.4F, KeyframeAnimations.degreeVec(155.6892F, -64.4894F, -109.0981F), Interpolations.LINEAR),
                  new Keyframe(4.6F, KeyframeAnimations.degreeVec(78.1892F, -64.4894F, -109.0981F), Interpolations.LINEAR),
                  new Keyframe(4.8F, KeyframeAnimations.degreeVec(88.1892F, -64.4894F, -109.0981F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.4F, KeyframeAnimations.degreeVec(-7.4718F, 0.6518F, 4.9574F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-7.4718F, 0.6518F, 4.9574F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(-17.4718F, 0.6518F, 4.9574F), Interpolations.LINEAR),
                  new Keyframe(2.8F, KeyframeAnimations.degreeVec(2.5282F, 0.6518F, 4.9574F), Interpolations.LINEAR),
                  new Keyframe(2.9F, KeyframeAnimations.degreeVec(2.5282F, 0.6518F, 4.9574F), Interpolations.LINEAR),
                  new Keyframe(3.1F, KeyframeAnimations.degreeVec(-22.4718F, 0.6518F, 4.9574F), Interpolations.LINEAR),
                  new Keyframe(3.5F, KeyframeAnimations.degreeVec(-12.4718F, 0.6518F, 4.9574F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-12.3703F, 1.7279F, 9.8414F), Interpolations.LINEAR),
                  new Keyframe(4.25F, KeyframeAnimations.degreeVec(9.088F, 1.7279F, 9.8414F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(9.5047F, 1.7279F, 9.8414F), Interpolations.LINEAR),
                  new Keyframe(4.5F, KeyframeAnimations.degreeVec(12.6297F, 1.7279F, 9.8414F), Interpolations.LINEAR),
                  new Keyframe(4.65F, KeyframeAnimations.degreeVec(-29.8703F, 1.7279F, 9.8414F), Interpolations.LINEAR),
                  new Keyframe(4.8F, KeyframeAnimations.degreeVec(-7.3703F, 1.7279F, 9.8414F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain2",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(1.1F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.4F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.8F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.9F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.1F, KeyframeAnimations.degreeVec(-38.1658F, 9.8874F, -7.6861F), Interpolations.LINEAR),
                  new Keyframe(3.5F, KeyframeAnimations.degreeVec(-5.6658F, 9.8874F, -7.6861F), Interpolations.LINEAR),
                  new Keyframe(3.85F, KeyframeAnimations.degreeVec(-5.13F, 11.36F, -5.26F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-12.1008F, 12.8249F, -2.836F), Interpolations.LINEAR),
                  new Keyframe(4.25F, KeyframeAnimations.degreeVec(-10.0174F, 12.8249F, -2.836F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(9.1492F, 12.8249F, -2.836F), Interpolations.LINEAR),
                  new Keyframe(4.45F, KeyframeAnimations.degreeVec(30.3992F, 12.8249F, -2.836F), Interpolations.LINEAR),
                  new Keyframe(4.65F, KeyframeAnimations.degreeVec(-17.1008F, 12.8249F, -2.836F), Interpolations.LINEAR),
                  new Keyframe(4.8F, KeyframeAnimations.degreeVec(-14.6008F, 12.8249F, -2.836F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain3",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(1.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain4",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.4F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.8F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.9F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.1F, KeyframeAnimations.degreeVec(-38.8189F, 13.8019F, -10.8653F), Interpolations.LINEAR),
                  new Keyframe(3.5F, KeyframeAnimations.degreeVec(-53.8189F, 13.8019F, -10.8653F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-53.8189F, 13.8019F, -10.8653F), Interpolations.LINEAR),
                  new Keyframe(3.9F, KeyframeAnimations.degreeVec(-55.2424F, -18.8374F, -22.4858F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(-57.4168F, -5.1806F, -11.5894F), Interpolations.LINEAR),
                  new Keyframe(4.25F, KeyframeAnimations.degreeVec(-48.6493F, 13.0285F, 2.9391F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(7.0382F, 13.0285F, 2.9391F), Interpolations.LINEAR),
                  new Keyframe(4.4F, KeyframeAnimations.degreeVec(19.1632F, 13.0285F, 2.9391F), Interpolations.LINEAR),
                  new Keyframe(4.55F, KeyframeAnimations.degreeVec(-1.1493F, 13.0285F, 2.9391F), Interpolations.LINEAR),
                  new Keyframe(4.75F, KeyframeAnimations.degreeVec(-31.1493F, 13.0285F, 2.9391F), Interpolations.LINEAR),
                  new Keyframe(4.8F, KeyframeAnimations.degreeVec(-23.6493F, 13.0285F, 2.9391F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain4",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain5",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.1F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-14.9375F, -1.5018F, -4.7697F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(-19.9375F, -1.5018F, -4.7697F), Interpolations.LINEAR),
                  new Keyframe(2.8F, KeyframeAnimations.degreeVec(-32.4375F, -1.5018F, -4.7697F), Interpolations.LINEAR),
                  new Keyframe(2.9F, KeyframeAnimations.degreeVec(-32.4375F, -1.5018F, -4.7697F), Interpolations.LINEAR),
                  new Keyframe(3.1F, KeyframeAnimations.degreeVec(-27.4375F, -1.5018F, -4.7697F), Interpolations.LINEAR),
                  new Keyframe(3.2F, KeyframeAnimations.degreeVec(-32.4375F, -1.5018F, -4.7697F), Interpolations.LINEAR),
                  new Keyframe(3.4F, KeyframeAnimations.degreeVec(-7.4375F, -1.5018F, -4.7697F), Interpolations.LINEAR),
                  new Keyframe(3.55F, KeyframeAnimations.degreeVec(-43.831F, -1.5215F, -5.2382F), Interpolations.LINEAR),
                  new Keyframe(3.75F, KeyframeAnimations.degreeVec(-22.0352F, -1.5477F, -5.8629F), Interpolations.LINEAR),
                  new Keyframe(3.9F, KeyframeAnimations.degreeVec(0.0991F, -5.8057F, -15.2322F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(-3.39F, -5.12F, -15.39F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-8.5369F, -15.3195F, -25.8836F), Interpolations.LINEAR),
                  new Keyframe(4.25F, KeyframeAnimations.degreeVec(-7.1326F, -15.0667F, -30.2347F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-28.8247F, -18.4068F, -22.4275F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(-15.8942F, -5.125F, -15.3874F), Interpolations.LINEAR),
                  new Keyframe(4.45F, KeyframeAnimations.degreeVec(22.2186F, -2.5906F, -8.2978F), Interpolations.LINEAR),
                  new Keyframe(4.6F, KeyframeAnimations.degreeVec(2.9F, -6.75F, -10.02F), Interpolations.LINEAR),
                  new Keyframe(4.65F, KeyframeAnimations.degreeVec(-19.779F, -12.4385F, -9.4752F), Interpolations.LINEAR),
                  new Keyframe(4.8F, KeyframeAnimations.degreeVec(-14.779F, -12.4385F, -9.4752F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain5",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(1.45F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain6",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.2F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-15.3453F, 14.7669F, -2.664F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(-15.3453F, 14.7669F, -2.664F), Interpolations.LINEAR),
                  new Keyframe(3.1F, KeyframeAnimations.degreeVec(-30.3453F, 14.7669F, -2.664F), Interpolations.LINEAR),
                  new Keyframe(3.2F, KeyframeAnimations.degreeVec(-37.8453F, 14.7669F, -2.664F), Interpolations.LINEAR),
                  new Keyframe(3.4F, KeyframeAnimations.degreeVec(-23.5668F, 31.3197F, 27.9537F), Interpolations.LINEAR),
                  new Keyframe(3.65F, KeyframeAnimations.degreeVec(-33.5271F, 14.7669F, -2.664F), Interpolations.LINEAR),
                  new Keyframe(3.9F, KeyframeAnimations.degreeVec(-2.1113F, 5.6975F, 11.3637F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(2.03F, 14.32F, -18.11F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(1.405F, 14.32F, -18.11F), Interpolations.LINEAR),
                  new Keyframe(4.25F, KeyframeAnimations.degreeVec(-20.47F, 14.32F, -18.11F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-26.4611F, 22.2332F, 3.8423F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(-44.4594F, 12.3855F, -14.4271F), Interpolations.LINEAR),
                  new Keyframe(4.4F, KeyframeAnimations.degreeVec(6.0487F, 15.2656F, -11.7107F), Interpolations.LINEAR),
                  new Keyframe(4.45F, KeyframeAnimations.degreeVec(15.8229F, 15.1149F, -7.8265F), Interpolations.LINEAR),
                  new Keyframe(4.6F, KeyframeAnimations.degreeVec(-4.18F, 15.11F, -7.83F), Interpolations.LINEAR),
                  new Keyframe(4.65F, KeyframeAnimations.degreeVec(-31.6303F, 15.0353F, 0.5262F), Interpolations.LINEAR),
                  new Keyframe(4.8F, KeyframeAnimations.degreeVec(-26.6303F, 15.0353F, 0.5262F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain6",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(1.85F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.1F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .build();
   }

   static AnimationDefinition initPhaseTransitionAnim() {
      return Builder.withLength(18.0F)
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(12.5F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(12.5F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(12.5F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(12.5F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(12.5F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.2F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.05F, KeyframeAnimations.posVec(0.0F, -0.9F, 12.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.posVec(0.0F, -0.9F, 14.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -0.9F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.posVec(0.0F, -0.9F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.posVec(0.0F, -0.9F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.posVec(0.0F, -0.9F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.posVec(0.0F, -0.9F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(2.2F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.posVec(0.0F, -2.1F, -4.1F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, -2.1F, -4.1F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.posVec(0.0F, -1.7F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.posVec(0.0F, -1.7F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(19.57F, 2.44F, 2.3F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(19.57F, 2.44F, 2.3F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(19.57F, 2.44F, 2.3F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(19.57F, 2.44F, 2.3F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(19.57F, 2.44F, 2.3F), Interpolations.LINEAR),
                  new Keyframe(2.2F, KeyframeAnimations.degreeVec(4.5739F, -7.5562F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.degreeVec(4.57F, -15.06F, -5.2F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(4.57F, -15.06F, -5.2F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(4.57F, -15.06F, -5.2F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(4.6084F, 7.4278F, -4.7955F), Interpolations.LINEAR),
                  new Keyframe(11.85F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(12.6F, KeyframeAnimations.degreeVec(4.57F, -7.56F, -5.2F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(4.57F, -7.56F, -5.2F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(12.07F, -7.56F, -5.2F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(12.07F, -7.56F, -5.2F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.posVec(0.0F, -11.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.posVec(0.0F, -11.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.posVec(0.0F, -11.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.posVec(0.0F, -11.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.posVec(0.0F, -11.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.posVec(-0.4F, -9.59F, 0.84F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.posVec(-0.8F, -8.19F, 1.47F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.posVec(-1.1F, -6.79F, 1.95F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.posVec(-1.4F, -5.52F, 2.1F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.posVec(-1.75F, -4.275F, 2.1F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(-1.8F, -3.084F, 2.0335F), Interpolations.LINEAR),
                  new Keyframe(2.05F, KeyframeAnimations.posVec(-1.9F, -2.01F, 1.793F), Interpolations.LINEAR),
                  new Keyframe(2.1F, KeyframeAnimations.posVec(-2.0F, -1.08F, 1.405F), Interpolations.LINEAR),
                  new Keyframe(2.15F, KeyframeAnimations.posVec(-2.0F, -0.3F, 0.9F), Interpolations.LINEAR),
                  new Keyframe(2.2F, KeyframeAnimations.posVec(-2.0F, 0.3F, 0.4F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.posVec(-2.6F, -0.1F, -0.3F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(-2.6F, -0.1F, -0.3F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(-2.6F, -0.1F, -0.3F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottomEnd",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hips",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, -5.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, -5.0F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hips",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(3.999F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(4.049F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(17.999F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(0.05F, KeyframeAnimations.degreeVec(-65.05F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-82.55F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-82.55F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-82.55F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-82.55F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-82.55F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-82.55F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-82.55F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(2.2F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.degreeVec(-12.55F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-12.55F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(-17.55F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(-32.55F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(-32.55F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(-17.55F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-17.55F, -9.69F, -0.27F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(2.2F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(65.16F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(0.05F, KeyframeAnimations.degreeVec(63.91F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(80.16F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(77.66F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(75.16F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(75.16F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(75.16F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(75.16F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(75.16F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(2.2F, KeyframeAnimations.degreeVec(50.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.degreeVec(60.66F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(60.66F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(60.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(60.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-72.91F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(0.05F, KeyframeAnimations.degreeVec(-67.28F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-84.16F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-76.66F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-76.66F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-76.66F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-76.66F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-76.66F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-76.66F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(2.2F, KeyframeAnimations.degreeVec(-54.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.degreeVec(-61.6125F, -1.585F, 1.4628F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-61.61F, -1.58F, 1.46F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(-64.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(-64.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofLeft",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(18.75F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.05F, KeyframeAnimations.degreeVec(48.13F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.2F, KeyframeAnimations.degreeVec(14.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.degreeVec(17.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(17.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(15.01F, 6.21F, 4.81F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(34.38F, 3.71F, 3.56F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(29.38F, 3.71F, 3.56F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(29.38F, 3.71F, 3.56F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(29.38F, 3.71F, 3.56F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(29.38F, 3.71F, 3.56F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(29.38F, 3.71F, 3.56F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(-43.12F, 3.71F, 3.56F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.degreeVec(-40.62F, 3.71F, 3.56F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-40.62F, 3.71F, 3.56F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(4.38F, 13.71F, 8.56F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(-10.62F, 13.71F, 8.56F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(-10.62F, 13.71F, 8.56F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.24F, -4.54F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(47.24F, -2.04F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(57.24F, -2.04F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(57.24F, -2.04F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(57.24F, -2.04F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(57.24F, -2.04F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(57.24F, -2.04F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(57.24F, -2.04F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.degreeVec(69.74F, -2.04F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(69.74F, -2.04F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(42.24F, -7.04F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(40.24F, -7.04F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(55.3154F, -7.1316F, -0.7371F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(55.3154F, -7.1316F, -0.7371F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-75.56F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-86.81F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-81.81F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-79.31F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-79.31F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-79.31F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-79.31F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-79.31F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(-64.31F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.degreeVec(-51.81F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-51.81F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(-69.31F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(-64.31F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(-69.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(-69.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(11.25F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineCenter",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.2533F, 5.3516F, -1.5833F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(30.25F, 10.35F, -1.58F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(35.25F, 10.35F, -1.58F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(35.25F, 15.35F, -1.58F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(35.25F, 15.35F, -1.58F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(35.25F, 15.35F, -1.58F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(20.25F, 15.35F, -1.58F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(20.25F, 15.35F, -1.58F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(20.25F, 15.35F, -1.58F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(20.25F, 15.35F, -1.58F), Interpolations.LINEAR),
                  new Keyframe(2.2F, KeyframeAnimations.degreeVec(7.75F, 5.35F, 3.42F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(10.25F, 5.35F, 3.42F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(20.25F, 5.35F, -1.58F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(10.2533F, 5.3516F, -1.5833F), Interpolations.LINEAR),
                  new Keyframe(5.0F, KeyframeAnimations.degreeVec(10.25F, 5.35F, -1.58F), Interpolations.LINEAR),
                  new Keyframe(5.25F, KeyframeAnimations.degreeVec(10.5364F, -14.3283F, -5.1816F), Interpolations.LINEAR),
                  new Keyframe(5.35F, KeyframeAnimations.degreeVec(10.655F, -16.4474F, -5.5962F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(10.972F, 21.0116F, 1.4287F), Interpolations.LINEAR),
                  new Keyframe(11.85F, KeyframeAnimations.degreeVec(10.972F, 21.0116F, 1.4287F), Interpolations.LINEAR),
                  new Keyframe(13.1F, KeyframeAnimations.degreeVec(10.25F, -9.65F, -1.58F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(15.25F, -9.65F, -1.58F), Interpolations.LINEAR),
                  new Keyframe(16.05F, KeyframeAnimations.degreeVec(30.25F, -9.65F, -1.58F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(32.75F, -9.65F, -1.58F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(-20.6349F, -19.0385F, 1.9789F), Interpolations.LINEAR),
                  new Keyframe(16.55F, KeyframeAnimations.degreeVec(-21.3362F, -23.7073F, 3.9013F), Interpolations.LINEAR),
                  new Keyframe(17.0F, KeyframeAnimations.degreeVec(-20.3033F, 16.2452F, -10.9333F), Interpolations.LINEAR),
                  new Keyframe(17.25F, KeyframeAnimations.degreeVec(-20.8952F, 20.9259F, -12.7887F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(17.0445F, 1.0082F, -0.66F), Interpolations.LINEAR),
                  new Keyframe(17.65F, KeyframeAnimations.degreeVec(17.21F, 2.46F, -0.77F), Interpolations.LINEAR),
                  new Keyframe(17.75F, KeyframeAnimations.degreeVec(17.8684F, 8.2642F, -1.2327F), Interpolations.LINEAR),
                  new Keyframe(17.9F, KeyframeAnimations.degreeVec(22.8684F, 8.2642F, -1.2327F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(17.8684F, 8.2642F, -1.2327F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(37.4F, -2.68F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(39.9011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(29.9F, -2.68F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(29.9F, -2.68F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(22.4F, -2.68F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(22.4F, -2.68F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(37.4F, -2.68F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(44.9F, -2.68F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(44.9F, -2.68F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(11.8384F, -15.4227F, 4.0638F), Interpolations.LINEAR),
                  new Keyframe(16.55F, KeyframeAnimations.degreeVec(11.8384F, -15.4227F, 4.0638F), Interpolations.LINEAR),
                  new Keyframe(16.8F, KeyframeAnimations.degreeVec(9.3294F, 11.3486F, -3.39F), Interpolations.LINEAR),
                  new Keyframe(17.85F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 8.5351F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-19.34F, -6.5F, 8.54F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(-24.34F, -6.5F, 8.54F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-24.34F, -6.5F, 8.54F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-24.34F, -6.5F, 8.54F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(-74.34F, -14.0F, 11.04F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-71.84F, -14.0F, 11.04F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-71.84F, -14.0F, 11.04F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(-34.34F, -9.0F, 6.04F), Interpolations.LINEAR),
                  new Keyframe(2.2F, KeyframeAnimations.degreeVec(-29.34F, -1.5F, -3.96F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-19.34F, -1.5F, -3.96F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 8.5351F), Interpolations.LINEAR),
                  new Keyframe(5.0F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 8.5351F), Interpolations.LINEAR),
                  new Keyframe(5.25F, KeyframeAnimations.degreeVec(-34.0326F, 7.9648F, -1.3017F), Interpolations.LINEAR),
                  new Keyframe(5.35F, KeyframeAnimations.degreeVec(-34.2548F, 10.0339F, -2.7223F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(-35.602F, -17.4772F, 16.1923F), Interpolations.LINEAR),
                  new Keyframe(11.85F, KeyframeAnimations.degreeVec(-35.602F, -17.4772F, 16.1923F), Interpolations.LINEAR),
                  new Keyframe(12.6F, KeyframeAnimations.degreeVec(-29.34F, 3.5F, 1.04F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(-29.34F, 3.5F, 1.04F), Interpolations.LINEAR),
                  new Keyframe(16.05F, KeyframeAnimations.degreeVec(-9.34F, 3.5F, 1.04F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(-6.84F, 3.5F, 1.04F), Interpolations.LINEAR),
                  new Keyframe(16.4F, KeyframeAnimations.degreeVec(-39.34F, 3.5F, 1.04F), Interpolations.LINEAR),
                  new Keyframe(16.45F, KeyframeAnimations.degreeVec(-41.84F, 3.5F, 1.04F), Interpolations.LINEAR),
                  new Keyframe(17.55F, KeyframeAnimations.degreeVec(-29.34F, 3.5F, 1.04F), Interpolations.LINEAR),
                  new Keyframe(17.7F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 21.0351F), Interpolations.LINEAR),
                  new Keyframe(17.8F, KeyframeAnimations.degreeVec(-31.844F, -6.5042F, 21.0351F), Interpolations.LINEAR),
                  new Keyframe(17.9F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 21.0351F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 21.0351F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.25F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.4F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.45F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.5F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.55F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.6F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.65F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.7F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.75F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.8F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.85F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.9F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.95F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.05F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.1F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.15F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.2F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.25F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.75F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.85F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.posVec(0.0F, 3.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.posVec(0.0F, 3.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 2.8274F, -0.2156F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.posVec(0.0F, 3.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.posVec(0.0F, 3.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR),
                  new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 3.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 3.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.posVec(0.0F, 3.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.posVec(0.0F, 1.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(17.75F, KeyframeAnimations.posVec(0.0F, 2.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 2.03F, -0.22F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.01F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.01F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-21.2315F, -5.5584F, -11.2783F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-68.73F, -13.06F, 1.22F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-68.73F, -13.06F, 1.22F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(-68.73F, -15.56F, 6.22F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-71.23F, -15.56F, 6.22F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-71.23F, -15.56F, 6.22F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-71.23F, -15.56F, 6.22F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(-38.73F, -15.56F, -11.28F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-38.73F, -15.56F, -11.28F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.degreeVec(-11.23F, -0.56F, -8.78F), Interpolations.LINEAR),
                  new Keyframe(2.25F, KeyframeAnimations.degreeVec(1.27F, -0.56F, -8.78F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(1.27F, -0.56F, -8.78F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(4.61F, -11.17F, -8.73F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(19.6105F, -11.1734F, -8.7325F), Interpolations.LINEAR),
                  new Keyframe(5.0F, KeyframeAnimations.degreeVec(19.6105F, -11.1734F, -8.7325F), Interpolations.LINEAR),
                  new Keyframe(5.25F, KeyframeAnimations.degreeVec(49.61F, -11.17F, -8.73F), Interpolations.LINEAR),
                  new Keyframe(5.35F, KeyframeAnimations.degreeVec(52.11F, -11.17F, -8.73F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(-45.7346F, -23.6782F, 0.334F), Interpolations.LINEAR),
                  new Keyframe(11.5F, KeyframeAnimations.degreeVec(-52.89F, -11.17F, -8.73F), Interpolations.LINEAR),
                  new Keyframe(11.6F, KeyframeAnimations.degreeVec(-47.89F, -11.17F, -8.73F), Interpolations.LINEAR),
                  new Keyframe(11.75F, KeyframeAnimations.degreeVec(-45.39F, -11.17F, -8.73F), Interpolations.LINEAR),
                  new Keyframe(11.85F, KeyframeAnimations.degreeVec(-42.89F, -11.17F, -8.73F), Interpolations.LINEAR),
                  new Keyframe(12.35F, KeyframeAnimations.degreeVec(34.61F, -11.17F, -8.73F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(39.61F, -11.17F, -8.73F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(-66.1888F, 58.2035F, -44.6516F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(-68.6888F, 58.2035F, -44.6516F), Interpolations.LINEAR),
                  new Keyframe(16.4F, KeyframeAnimations.degreeVec(44.9236F, -1.6743F, -10.2205F), Interpolations.LINEAR),
                  new Keyframe(16.75F, KeyframeAnimations.degreeVec(49.9236F, -1.6743F, -10.2205F), Interpolations.LINEAR),
                  new Keyframe(17.25F, KeyframeAnimations.degreeVec(49.9236F, -1.6743F, -10.2205F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(-1.8486F, -2.4544F, -30.2186F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(19.6105F, -11.1734F, -8.7325F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-0.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(-0.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.posVec(-0.2F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.0F, KeyframeAnimations.posVec(-0.2F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.25F, KeyframeAnimations.posVec(-0.2F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.35F, KeyframeAnimations.posVec(-0.2F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.posVec(-0.2F, 0.0F, -1.0F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.posVec(-0.2F, 0.0F, -1.0F), Interpolations.LINEAR),
                  new Keyframe(16.4F, KeyframeAnimations.posVec(-0.4F, 0.0F, -1.0F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.posVec(-0.4F, 0.0F, -1.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(-0.2F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(-24.37F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(-29.37F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.degreeVec(-15.42F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.25F, KeyframeAnimations.degreeVec(-27.92F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-32.92F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.25F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.35F, KeyframeAnimations.degreeVec(-72.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.45F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(11.5F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(11.6F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(11.75F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(11.85F, KeyframeAnimations.degreeVec(-62.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(12.35F, KeyframeAnimations.degreeVec(-85.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(-80.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(-80.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.4F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.75F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-26.8502F, 16.3689F, -32.5178F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(-26.85F, 46.37F, -32.52F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-35.18F, 51.37F, -45.85F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-59.35F, 38.87F, -72.52F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(-59.35F, 38.87F, -72.52F), Interpolations.LINEAR),
                  new Keyframe(2.25F, KeyframeAnimations.degreeVec(-59.35F, 76.37F, -57.52F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-59.35F, 76.37F, -57.52F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(1.62F, 5.95F, 1.15F), Interpolations.LINEAR),
                  new Keyframe(5.0F, KeyframeAnimations.degreeVec(1.62F, 5.95F, 1.15F), Interpolations.LINEAR),
                  new Keyframe(5.25F, KeyframeAnimations.degreeVec(25.0383F, -86.1906F, -24.0077F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(1.62F, -111.55F, 1.15F), Interpolations.LINEAR),
                  new Keyframe(11.5F, KeyframeAnimations.degreeVec(-151.6265F, -73.911F, 152.4587F), Interpolations.LINEAR),
                  new Keyframe(11.6F, KeyframeAnimations.degreeVec(-116.4858F, -56.8556F, 114.4458F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(-116.4858F, -56.8556F, 114.4458F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(-29.4444F, -5.4363F, -3.2498F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(-29.4444F, -5.4363F, -3.2498F), Interpolations.LINEAR),
                  new Keyframe(16.45F, KeyframeAnimations.degreeVec(-116.4858F, -56.8556F, 114.4458F), Interpolations.LINEAR),
                  new Keyframe(17.15F, KeyframeAnimations.degreeVec(-116.4858F, -56.8556F, 114.4458F), Interpolations.LINEAR),
                  new Keyframe(17.3F, KeyframeAnimations.degreeVec(-42.3875F, -54.2552F, 29.7495F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(-26.8502F, 16.3689F, -32.5178F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-26.8502F, 16.3689F, -32.5178F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR),
                  new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR),
                  new Keyframe(5.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.25F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-18.1429F, 15.2099F, 30.0306F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(-18.14F, 15.21F, 30.03F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-18.14F, 15.21F, 10.03F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-18.14F, 15.21F, 10.03F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(-14.9F, 7.32F, 8.52F), Interpolations.LINEAR),
                  new Keyframe(5.05F, KeyframeAnimations.degreeVec(-13.28F, 9.9755F, 19.2109F), Interpolations.LINEAR),
                  new Keyframe(11.5F, KeyframeAnimations.degreeVec(-11.5614F, 11.944F, 28.265F), Interpolations.LINEAR),
                  new Keyframe(11.6F, KeyframeAnimations.degreeVec(0.4462F, 9.0584F, 74.4846F), Interpolations.LINEAR),
                  new Keyframe(17.15F, KeyframeAnimations.degreeVec(0.4462F, 9.0584F, 74.4846F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(-18.1429F, 15.2099F, 30.0306F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-18.1429F, 15.2099F, 30.0306F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 12.5F), Interpolations.LINEAR),
                  new Keyframe(5.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 46.08F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 12.5F), Interpolations.LINEAR),
                  new Keyframe(11.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 40.0F), Interpolations.LINEAR),
                  new Keyframe(11.6F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(17.15F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 35.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-4.2764F, 5.8539F, 20.8899F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(-4.28F, 5.85F, 20.89F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-4.28F, 5.85F, -9.11F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-4.28F, 5.85F, -9.11F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(-6.0205F, 4.0361F, 8.3965F), Interpolations.LINEAR),
                  new Keyframe(5.15F, KeyframeAnimations.degreeVec(-5.0139F, 5.2002F, 20.6213F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(-6.0205F, 4.0361F, 8.3965F), Interpolations.LINEAR),
                  new Keyframe(11.4F, KeyframeAnimations.degreeVec(-4.28F, 5.85F, 28.39F), Interpolations.LINEAR),
                  new Keyframe(11.6F, KeyframeAnimations.degreeVec(1.4329F, 2.1013F, 76.0725F), Interpolations.LINEAR),
                  new Keyframe(17.15F, KeyframeAnimations.degreeVec(1.4329F, 2.1013F, 76.0725F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(-4.2764F, 5.8539F, 20.8899F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-4.2764F, 5.8539F, 20.8899F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 45.0F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 45.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 62.5F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 62.5F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 22.5F), Interpolations.LINEAR),
                  new Keyframe(5.15F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 69.74F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 22.5F), Interpolations.LINEAR),
                  new Keyframe(11.4F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 52.5F), Interpolations.LINEAR),
                  new Keyframe(11.6F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 80.0F), Interpolations.LINEAR),
                  new Keyframe(17.15F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 80.0F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 45.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 45.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.5744F, 6.7089F, 17.3286F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(9.57F, 6.71F, 17.33F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(9.57F, 6.71F, -5.17F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(9.57F, 6.71F, -5.17F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(6.7086F, 9.571F, 12.3299F), Interpolations.LINEAR),
                  new Keyframe(5.25F, KeyframeAnimations.degreeVec(9.2043F, 7.1382F, 29.5777F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(6.7086F, 9.571F, 12.3299F), Interpolations.LINEAR),
                  new Keyframe(11.3F, KeyframeAnimations.degreeVec(10.9643F, 4.0213F, 47.1538F), Interpolations.LINEAR),
                  new Keyframe(11.6F, KeyframeAnimations.degreeVec(8.3704F, 1.0131F, 87.229F), Interpolations.LINEAR),
                  new Keyframe(17.15F, KeyframeAnimations.degreeVec(8.3704F, 1.0131F, 87.229F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(9.5744F, 6.7089F, 17.3286F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(9.5744F, 6.7089F, 17.3286F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.2F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.2F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.2F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.2F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 67.5F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 67.5F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(5.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 66.79F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(11.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 50.0F), Interpolations.LINEAR),
                  new Keyframe(11.6F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 72.5F), Interpolations.LINEAR),
                  new Keyframe(17.15F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 72.5F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-27.776F, -11.0873F, 55.7603F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(-27.78F, -11.09F, 55.76F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-27.78F, -11.09F, 43.26F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-27.78F, -11.09F, 43.26F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(-82.57F, -67.46F, 90.14F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(-82.57F, -67.46F, 90.14F), Interpolations.LINEAR),
                  new Keyframe(11.5F, KeyframeAnimations.degreeVec(-126.6825F, -39.3455F, 158.175F), Interpolations.LINEAR),
                  new Keyframe(11.6F, KeyframeAnimations.degreeVec(-150.0602F, -35.7254F, 183.4385F), Interpolations.LINEAR),
                  new Keyframe(17.15F, KeyframeAnimations.degreeVec(-150.0602F, -35.7254F, 183.4385F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(-27.776F, -11.0873F, 55.7603F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-27.776F, -11.0873F, 55.7603F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(11.5F, KeyframeAnimations.posVec(1.0F, 0.7F, 0.1F), Interpolations.LINEAR),
                  new Keyframe(11.6F, KeyframeAnimations.posVec(1.0F, 0.7F, 0.1F), Interpolations.LINEAR),
                  new Keyframe(17.15F, KeyframeAnimations.posVec(1.0F, 0.7F, 0.1F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumbTip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -27.5F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -27.5F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -42.5F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -52.5F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -52.5F), Interpolations.LINEAR),
                  new Keyframe(11.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -60.0F), Interpolations.LINEAR),
                  new Keyframe(11.6F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -75.0F), Interpolations.LINEAR),
                  new Keyframe(17.15F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -75.0F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -27.5F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -27.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(18.0F, KeyframeAnimations.degreeVec(-7.97F, 78.88F, 94.59F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(18.0F, KeyframeAnimations.posVec(-7.75F, -7.7F, -2.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(18.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "handle",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(18.0F, KeyframeAnimations.degreeVec(-5.0F, 2.5F, 5.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "handle",
            new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(18.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "chainStart",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(18.0F, KeyframeAnimations.degreeVec(10.4609F, 0.9101F, -10.9167F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "chain1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(-42.5F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-42.5F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-42.5F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.degreeVec(36.7F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(2.4F, KeyframeAnimations.degreeVec(49.9F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(5.25F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(5.35F, KeyframeAnimations.degreeVec(-22.1522F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(23.4359F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(11.85F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), Interpolations.LINEAR),
                  new Keyframe(13.1F, KeyframeAnimations.degreeVec(-67.5F, -47.5F, 32.5F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(-44.9048F, -36.4413F, 50.8763F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(-56.4049F, -66.6073F, 67.4287F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(-58.9049F, -66.6073F, 67.4287F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(-7.3337F, -14.4093F, 41.2796F), Interpolations.LINEAR),
                  new Keyframe(16.55F, KeyframeAnimations.degreeVec(-7.9628F, -14.0765F, 43.8359F), Interpolations.LINEAR),
                  new Keyframe(17.0F, KeyframeAnimations.degreeVec(34.071F, -20.5906F, 61.6515F), Interpolations.LINEAR),
                  new Keyframe(17.85F, KeyframeAnimations.degreeVec(56.8933F, 28.842F, 65.0391F), Interpolations.LINEAR),
                  new Keyframe(17.9F, KeyframeAnimations.degreeVec(47.2947F, 20.3671F, 44.3488F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(47.2947F, 20.3671F, 44.3488F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.5107F, -0.9928F, 0.06F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.posVec(0.51F, -0.99F, 0.06F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.posVec(0.51F, -0.99F, 0.06F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(0.51F, -0.99F, 0.06F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.posVec(0.51F, -0.99F, 0.06F), Interpolations.LINEAR),
                  new Keyframe(11.85F, KeyframeAnimations.posVec(0.51F, -0.99F, 0.06F), Interpolations.LINEAR),
                  new Keyframe(13.1F, KeyframeAnimations.posVec(0.51F, -0.99F, -3.94F), Interpolations.LINEAR),
                  new Keyframe(17.0F, KeyframeAnimations.posVec(0.51F, -0.99F, -3.94F), Interpolations.LINEAR),
                  new Keyframe(17.85F, KeyframeAnimations.posVec(0.51F, -0.99F, 0.06F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.51F, -0.99F, 0.06F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-80.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-80.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.25F, KeyframeAnimations.degreeVec(-46.09F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.5F, KeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.25F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.35F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(11.85F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(13.1F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(-87.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(-92.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(-92.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(-72.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.0F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.25F, KeyframeAnimations.degreeVec(-77.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(-89.5631F, 4.9809F, 5.019F), Interpolations.LINEAR),
                  new Keyframe(17.75F, KeyframeAnimations.degreeVec(-82.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.85F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-33.6404F, 37.2028F, 8.1506F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(-33.64F, 37.2F, 8.15F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(-12.5F, 15.0F, -14.5F), Interpolations.LINEAR),
                  new Keyframe(14.05F, KeyframeAnimations.degreeVec(-151.763F, 24.073F, 174.2647F), Interpolations.LINEAR),
                  new Keyframe(14.1F, KeyframeAnimations.degreeVec(-167.5393F, 14.322F, 171.9128F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(-166.4897F, 26.5053F, 174.9042F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(-166.4897F, 26.5053F, 174.9042F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(-180.4214F, -7.7841F, 168.225F), Interpolations.LINEAR),
                  new Keyframe(16.55F, KeyframeAnimations.degreeVec(-180.4384F, -17.7838F, 168.3019F), Interpolations.LINEAR),
                  new Keyframe(16.75F, KeyframeAnimations.degreeVec(-180.5242F, 37.2145F, 167.8509F), Interpolations.LINEAR),
                  new Keyframe(17.75F, KeyframeAnimations.degreeVec(-57.3705F, 55.304F, 337.1772F), Interpolations.LINEAR),
                  new Keyframe(17.85F, KeyframeAnimations.degreeVec(-4.493F, 60.3027F, 380.3952F), Interpolations.LINEAR),
                  new Keyframe(17.9F, KeyframeAnimations.degreeVec(-37.0108F, 67.8559F, 346.6312F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-37.0108F, 67.8559F, 346.6312F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.4673F, -1.3712F, -0.605F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.posVec(0.47F, -1.37F, -0.6F), Interpolations.LINEAR),
                  new Keyframe(14.05F, KeyframeAnimations.posVec(0.47F, -1.37F, -0.6F), Interpolations.LINEAR),
                  new Keyframe(14.1F, KeyframeAnimations.posVec(0.47F, -1.37F, -1.6F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(0.47F, -1.37F, -1.6F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(14.099F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(14.1F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(14.2F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(23.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(23.22F, -7.58F, 10.09F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(0.0F, 12.5F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(14.55F, KeyframeAnimations.degreeVec(60.0F, 12.5F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(65.0F, 12.5F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(65.0F, 12.5F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(23.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(17.2F, KeyframeAnimations.degreeVec(8.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(17.25F, KeyframeAnimations.degreeVec(-11.776F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(17.75F, KeyframeAnimations.degreeVec(-11.776F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(17.85F, KeyframeAnimations.degreeVec(18.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(18.224F, -7.5832F, 10.0906F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(14.549F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(14.55F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(14.65F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(57.679F, -4.1157F, -2.1768F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(57.68F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(14.35F, KeyframeAnimations.degreeVec(70.18F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(72.68F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(72.68F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(50.18F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(17.2F, KeyframeAnimations.degreeVec(25.18F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(17.25F, KeyframeAnimations.degreeVec(55.18F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(55.18F, -4.12F, -2.18F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(17.52F, -2.38F, -3.25F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(47.5F, 12.5F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(15.1F, KeyframeAnimations.degreeVec(56.945F, 14.6263F, -4.8777F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(59.445F, 14.6263F, -4.8777F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(59.44F, 14.63F, -4.88F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(17.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(17.2F, KeyframeAnimations.degreeVec(10.0157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(17.25F, KeyframeAnimations.degreeVec(-22.4843F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(17.75F, KeyframeAnimations.degreeVec(-22.4843F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(17.85F, KeyframeAnimations.degreeVec(10.0157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(10.0157F, -2.3842F, -3.2522F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(14.999F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(15.1F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(14.7F, KeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(27.6945F, -0.8937F, 0.3873F), Interpolations.LINEAR),
                  new Keyframe(17.2F, KeyframeAnimations.degreeVec(15.1945F, -0.8937F, 0.3873F), Interpolations.LINEAR),
                  new Keyframe(17.25F, KeyframeAnimations.degreeVec(52.6945F, -0.8937F, 0.3873F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(52.6945F, -0.8937F, 0.3873F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(46.282F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(46.28F, 3.58F, -8.68F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.35F, KeyframeAnimations.degreeVec(64.141F, 14.7015F, -12.018F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(69.141F, 14.7015F, -12.018F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(69.14F, 14.7F, -12.02F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(11.282F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(17.2F, KeyframeAnimations.degreeVec(1.282F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(17.25F, KeyframeAnimations.degreeVec(-41.218F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(17.75F, KeyframeAnimations.degreeVec(-41.218F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(17.85F, KeyframeAnimations.degreeVec(26.282F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(26.282F, 3.5796F, -8.6772F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(15.349F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(15.35F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(15.45F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.75F, KeyframeAnimations.degreeVec(77.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.degreeVec(77.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.2F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.25F, KeyframeAnimations.degreeVec(70.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.6F, KeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, -2.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(9.4215F, 8.7295F, 9.0246F), Interpolations.LINEAR),
                  new Keyframe(4.0F, KeyframeAnimations.degreeVec(9.42F, 8.73F, 9.02F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.degreeVec(-5.0F, -2.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-5.0F, -2.5F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(16.249F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "flame",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(6.0F, 17.0F, -7.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.posVec(6.0F, 17.0F, -7.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "flame",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmGore1",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(13.099F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(13.1F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(13.2F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmGore2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmGore2",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(13.599F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(13.6F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(13.7F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife1",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(16.249F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife2",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(16.249F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(16.25F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(16.35F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .build();
   }

   static AnimationDefinition initSimpleClawAttackAnim() {
      return Builder.withLength(1.8F)
         .addAnimation(
            "body",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.posVec(0.0F, -0.9F, -12.0F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.posVec(0.0F, -1.9F, -17.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.posVec(0.0F, -1.9F, -17.0F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(-5.4261F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(-5.4261F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(-6.1944F, -16.2092F, 7.1126F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-6.1944F, -16.2092F, 7.1126F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hips",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(4.9485F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(4.9485F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(32.1603F, 9.6974F, -13.5268F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(32.1603F, 9.6974F, -13.5268F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(36.097F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(36.097F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(25.16F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(25.16F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(41.8267F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(51.8267F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(-52.41F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(-52.41F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(-57.91F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-57.91F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofLeft",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(16.25F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(16.25F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(8.75F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(8.75F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(9.58F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(32.51F, 6.21F, 4.81F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(-47.6336F, -2.8632F, -0.0798F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(-50.1336F, -2.8632F, -0.0798F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(-30.7243F, 2.7234F, -4.5926F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-30.7243F, 2.7234F, -4.5926F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(16.1754F, -9.5305F, 8.5872F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(53.0867F, -8.1047F, 6.3137F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(67.498F, -6.6788F, 4.0402F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(79.74F, -4.54F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(79.74F, -4.54F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(59.8446F, -0.2183F, -1.8873F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(59.8446F, -0.2183F, -1.8873F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(84.74F, -4.54F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(84.74F, -4.54F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(-52.9805F, -1.526F, -1.4586F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(-67.6688F, -2.3854F, -0.3166F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(-65.56F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(-68.06F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(-30.5167F, -0.8767F, -0.731F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-30.5167F, -0.8767F, -0.731F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(-80.56F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(-80.56F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(6.25F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(6.25F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineCenter",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.8684F, 18.2642F, -3.7327F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(8.8149F, 25.3844F, -1.192F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(4.43F, 29.92F, -0.84F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(3.9951F, 30.3728F, -0.8069F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(31.41F, -36.15F, -5.62F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(34.8314F, -44.4644F, -6.2177F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(17.8684F, 18.2642F, -3.7327F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(17.8684F, 18.2642F, -3.7327F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(20.3684F, 18.2642F, -3.7327F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(17.8684F, 18.2642F, -3.7327F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(37.4431F, 1.8777F, -1.7349F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(37.4431F, 1.8777F, -1.7349F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(37.4431F, 1.8777F, -1.7349F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-34.344F, -11.5042F, 26.0351F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(-32.5308F, -15.6165F, 28.9616F), Interpolations.LINEAR),
                  new Keyframe(1.05F, KeyframeAnimations.degreeVec(-32.5308F, -15.6165F, 28.9616F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(-32.6842F, -7.2718F, 23.3404F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(-34.0842F, -9.4367F, 24.6057F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-33.8778F, -7.3636F, 23.1933F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(-31.844F, -11.5042F, 26.0351F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(-34.344F, -11.5042F, 26.0351F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.posVec(0.0F, 1.73F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.posVec(0.0F, 2.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.posVec(0.0F, 2.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.posVec(0.0F, 1.73F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.posVec(0.0F, 2.03F, -0.22F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0436F, -0.5101F, 0.8282F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.01F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -12.5F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(-0.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chainStart",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.6609F, 0.9101F, -16.9167F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(9.5992F, 0.5767F, -12.8912F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-4.233F, -0.9293F, 2.1695F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(-4.6327F, -0.3018F, 4.6223F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(15.3239F, 1.0817F, -28.1569F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(15.3239F, 1.0817F, -28.1569F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(11.996F, -0.9337F, 9.7349F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(-22.5324F, -28.8634F, 35.7609F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(-12.7296F, 8.6716F, 5.4119F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(43.7012F, 3.007F, -21.6331F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(17.6609F, 0.9101F, -16.9167F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-0.5F, -9.0F, -1.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(-28.6148F, -2.3781F, 27.5107F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-17.4091F, -4.4166F, 20.6747F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(-38.0757F, -4.4166F, 20.6747F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(-38.0757F, -4.4166F, 20.6747F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(16.8025F, -4.5345F, 10.4865F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(12.5168F, -4.5345F, 10.4865F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(-10.6975F, -4.5345F, 10.4865F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-5.0054F, -5.4137F, -10.3027F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(-35.6975F, -4.5345F, 10.4865F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(-0.5F, -9.0F, -1.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(47.2947F, 20.3671F, 44.3488F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(37.4799F, -7.0607F, 70.1418F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(37.8634F, -4.0038F, 66.1661F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(-38.653F, 75.3681F, 60.7114F), Interpolations.LINEAR),
                  new Keyframe(0.95F, KeyframeAnimations.degreeVec(-22.8176F, -0.2439F, 30.0425F), Interpolations.LINEAR),
                  new Keyframe(1.05F, KeyframeAnimations.degreeVec(-22.72F, -2.18F, 25.4313F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(-22.72F, -2.18F, 25.4313F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(8.1066F, -11.8491F, 87.0155F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(36.3234F, -4.0594F, 78.6741F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(37.4799F, -7.0607F, 70.1418F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(47.2947F, 20.3671F, 44.3488F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.95F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-64.6015F, 53.0036F, -33.0428F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-21.5974F, 70.2578F, 18.0872F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(-9.0974F, 70.2578F, 18.0872F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(-180.9978F, 61.8592F, -147.6028F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(-67.7213F, 81.1606F, -52.356F), Interpolations.LINEAR),
                  new Keyframe(0.95F, KeyframeAnimations.degreeVec(-146.1153F, 57.8321F, -153.5163F), Interpolations.LINEAR),
                  new Keyframe(1.05F, KeyframeAnimations.degreeVec(-133.2656F, 55.3348F, -163.4995F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(-125.7656F, 55.3348F, -163.4995F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(-140.7872F, 40.9325F, -159.4573F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-21.5974F, 70.2578F, 18.0872F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(-119.3878F, 81.7961F, -81.1174F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(-64.6015F, 53.0036F, -33.0428F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.4673F, -1.3712F, -0.605F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "claw", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(23.224F, 4.9168F, 25.0906F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(18.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(43.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(18.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(17.6433F, 2.7903F, 18.6869F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(33.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(33.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(23.224F, 4.9168F, 25.0906F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(57.679F, -4.1157F, -2.1768F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(55.18F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(57.68F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(27.68F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(27.68F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(37.68F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(52.68F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(57.679F, -4.1157F, -2.1768F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.05F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife1",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0, 1.0, 3.0), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(10.0157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(32.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(2.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(10.0157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(10.0157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(17.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(52.6945F, -0.8937F, 0.3873F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(55.1945F, -0.8937F, 0.3873F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(35.1945F, -0.8937F, 0.3873F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(45.1945F, -0.8937F, 0.3873F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(67.6945F, -0.8937F, 0.3873F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife2",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0, 1.0, 3.0), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(46.282F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(26.282F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(23.782F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(-4.2799F, -2.1058F, -18.2955F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(28.782F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(28.782F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(46.282F, 3.5796F, -8.6772F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, -2.5F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0, 1.0, 3.0), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "flame",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(6.0F, 17.0F, -7.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "flame", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .build();
   }

   static AnimationDefinition initLanternSlamClawAnim() {
      return Builder.withLength(6.1F)
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.posVec(0.0F, -1.8F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.posVec(0.0F, -1.8F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(12.0739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(12.0739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(4.6084F, 7.4278F, -4.7955F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(4.6084F, 7.4278F, -4.7955F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(29.6084F, 7.4278F, -4.7955F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(29.6084F, 7.4278F, -4.7955F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(19.6095F, -7.5243F, -5.9974F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(19.6095F, -7.5243F, -5.9974F), Interpolations.LINEAR),
                  new Keyframe(5.6F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.posVec(0.0F, -0.4F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.posVec(0.0F, -0.4F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.posVec(0.2917F, -5.4051F, -6.955F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.posVec(0.2917F, -5.4051F, -6.955F), Interpolations.LINEAR),
                  new Keyframe(5.6F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottomEnd",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hips",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hips",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(5.949F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-37.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-37.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-35.0515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(-27.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-27.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(24.9485F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(19.95F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(19.95F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(5.6F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(-1.14F, -0.43F, 1.3F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.posVec(-1.147F, -0.4633F, 1.3739F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.posVec(-1.147F, -0.4633F, 1.3739F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(5.6F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(67.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(67.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(76.0468F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(57.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(57.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(25.1597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(45.16F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(45.16F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(5.4F, KeyframeAnimations.degreeVec(63.6599F, 1.0509F, 5.4897F), Interpolations.LINEAR),
                  new Keyframe(5.55F, KeyframeAnimations.degreeVec(66.4099F, 1.0522F, 5.4894F), Interpolations.LINEAR),
                  new Keyframe(5.65F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-61.6649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-61.6649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-68.5197F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(-64.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-64.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-51.6649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-66.66F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(-66.66F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(5.55F, KeyframeAnimations.degreeVec(-85.4124F, -1.3713F, 0.9585F), Interpolations.LINEAR),
                  new Keyframe(5.65F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofLeft",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.6F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-25.6157F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-25.6157F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(-38.9588F, 10.5985F, 4.5638F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-38.9588F, 10.5985F, 4.5638F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-47.0175F, 4.6575F, -0.1726F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-68.4924F, 5.2236F, 0.3734F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(-68.4924F, 5.2236F, 0.3734F), Interpolations.LINEAR),
                  new Keyframe(5.6F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR),
                  new Keyframe(5.6F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(57.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(57.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(57.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(57.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(67.4023F, -2.4245F, -1.3013F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(85.5173F, -2.7129F, -1.1804F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(85.5173F, -2.7129F, -1.1804F), Interpolations.LINEAR),
                  new Keyframe(5.6F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-74.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-74.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(-69.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-69.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-69.3391F, -0.6951F, 1.4221F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-76.5248F, -0.8413F, 1.3669F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(-76.5248F, -0.8413F, 1.3669F), Interpolations.LINEAR),
                  new Keyframe(5.6F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.6F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.6F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineCenter",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.2533F, 5.3516F, -1.5833F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(33.3334F, -12.34F, -10.9664F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(38.3334F, -12.34F, -10.9664F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(35.2084F, -12.34F, -10.9664F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-12.4513F, 12.7414F, -2.8815F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-16.3728F, 17.599F, -4.1091F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-16.3728F, 17.599F, -4.1091F), Interpolations.LINEAR),
                  new Keyframe(2.7F, KeyframeAnimations.degreeVec(16.0433F, -18.4734F, 6.3145F), Interpolations.LINEAR),
                  new Keyframe(3.35F, KeyframeAnimations.degreeVec(21.0433F, -18.4734F, 6.3145F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(21.0433F, -18.4734F, 6.3145F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(3.1069F, 17.733F, 0.1734F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(44.5489F, -26.5523F, -6.274F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(44.5489F, -26.5523F, -6.274F), Interpolations.LINEAR),
                  new Keyframe(5.6F, KeyframeAnimations.degreeVec(41.74F, -32.04F, -4.81F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(19.24F, 2.96F, -4.81F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(7.6151F, 12.9126F, -2.1494F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(27.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(23.83F, -2.68F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(24.41F, -2.68F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(24.41F, -2.68F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(25.01F, -2.68F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(4.9F, KeyframeAnimations.degreeVec(25.01F, -2.68F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(5.25F, KeyframeAnimations.degreeVec(14.9011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(5.45F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 8.5351F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-29.9F, 6.7F, -0.46F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.degreeVec(-29.4715F, 7.9698F, -1.3284F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-29.47F, 7.97F, -1.33F), Interpolations.LINEAR),
                  new Keyframe(4.15F, KeyframeAnimations.degreeVec(-14.6283F, -9.4537F, 0.6433F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(-4.6283F, -16.9537F, 0.6433F), Interpolations.LINEAR),
                  new Keyframe(4.45F, KeyframeAnimations.degreeVec(-4.6283F, -16.9537F, 0.6433F), Interpolations.LINEAR),
                  new Keyframe(4.9F, KeyframeAnimations.degreeVec(-2.1283F, -16.9537F, 0.6433F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(-50.24F, 24.99F, -15.15F), Interpolations.LINEAR),
                  new Keyframe(5.75F, KeyframeAnimations.degreeVec(-46.4863F, 6.2861F, 0.1586F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 8.5351F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.35F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.3F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.8F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.55F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 3.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(2.3F, KeyframeAnimations.posVec(0.0F, 3.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(2.35F, KeyframeAnimations.posVec(0.0F, 1.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(2.45F, KeyframeAnimations.posVec(0.0F, 1.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, 1.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(3.3F, KeyframeAnimations.posVec(0.0F, 1.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(3.8F, KeyframeAnimations.posVec(0.0F, 3.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(3.95F, KeyframeAnimations.posVec(0.0F, 3.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(4.05F, KeyframeAnimations.posVec(0.0F, 2.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR),
                  new Keyframe(4.55F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0436F, -0.5101F, 0.8282F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(0.04F, -0.51F, 0.83F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(0.0436F, -0.5101F, 0.8282F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(2.599F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(5.949F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(8.7685F, 16.9416F, -51.2783F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-21.3377F, 0.9083F, -15.1628F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-21.3377F, 0.9083F, -15.1628F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-26.3377F, 0.9083F, -15.1628F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(-149.0975F, -25.7013F, 20.1036F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-151.5975F, -25.7013F, 20.1036F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.degreeVec(-79.3689F, 3.1254F, 6.6953F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-79.37F, 3.13F, 6.7F), Interpolations.LINEAR),
                  new Keyframe(3.85F, KeyframeAnimations.degreeVec(-39.21F, 2.0F, 4.88F), Interpolations.LINEAR),
                  new Keyframe(4.25F, KeyframeAnimations.degreeVec(-14.21F, 2.0F, 4.88F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-57.4423F, 4.5609F, 9.9333F), Interpolations.LINEAR),
                  new Keyframe(4.45F, KeyframeAnimations.degreeVec(31.8566F, 2.9498F, -24.9001F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(-0.65F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.posVec(-0.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.posVec(-0.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-61.25F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.85F, KeyframeAnimations.degreeVec(-64.35F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-64.35F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.25F, KeyframeAnimations.degreeVec(-62.2964F, -2.0093F, 0.3553F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-59.0928F, -3.2196F, 12.681F), Interpolations.LINEAR),
                  new Keyframe(4.4F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.55F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.55F, KeyframeAnimations.degreeVec(-85.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-16.8502F, -3.6311F, -62.5178F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-18.5419F, 17.099F, -71.6623F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(-10.1382F, 22.3948F, -62.2644F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-10.1382F, 22.3948F, -62.2644F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(-26.5291F, 8.7483F, -23.0854F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.degreeVec(18.4709F, 8.7483F, -23.0854F), Interpolations.LINEAR),
                  new Keyframe(3.5F, KeyframeAnimations.degreeVec(13.97F, 10.9F, -33.91F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(13.97F, 10.9F, -33.91F), Interpolations.LINEAR),
                  new Keyframe(4.25F, KeyframeAnimations.degreeVec(-27.029F, 9.5066F, -1.158F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(3.1147F, 31.1199F, 27.1858F), Interpolations.LINEAR),
                  new Keyframe(4.5F, KeyframeAnimations.degreeVec(9.13F, 28.22F, -45.56F), Interpolations.LINEAR),
                  new Keyframe(5.4F, KeyframeAnimations.degreeVec(1.6249F, 5.9453F, 1.1495F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-18.1429F, 15.2099F, 30.0306F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-18.14F, 15.21F, 30.03F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-18.14F, 15.21F, 30.03F), Interpolations.LINEAR),
                  new Keyframe(4.4F, KeyframeAnimations.degreeVec(-14.9F, 7.3203F, 8.5207F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 80.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 80.0F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 80.0F), Interpolations.LINEAR),
                  new Keyframe(4.4F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 12.5F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-4.2764F, 5.8539F, 28.3899F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-4.28F, 5.85F, 28.39F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-4.28F, 5.85F, 28.39F), Interpolations.LINEAR),
                  new Keyframe(4.4F, KeyframeAnimations.degreeVec(-6.0205F, 4.0361F, 8.3965F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(4.4F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 22.5F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.5744F, 6.7089F, 32.3286F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(9.57F, 6.71F, 32.33F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(9.57F, 6.71F, 32.33F), Interpolations.LINEAR),
                  new Keyframe(4.4F, KeyframeAnimations.degreeVec(6.7086F, 9.571F, 12.3299F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.2F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.2F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(4.4F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.776F, -1.0873F, 55.7603F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-17.78F, -1.09F, 55.76F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-17.78F, -1.09F, 55.76F), Interpolations.LINEAR),
                  new Keyframe(4.4F, KeyframeAnimations.degreeVec(-17.7071F, 1.9646F, 65.2835F), Interpolations.LINEAR),
                  new Keyframe(5.55F, KeyframeAnimations.degreeVec(-82.57F, -67.46F, 90.14F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumbTip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -52.5F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -52.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-7.9691F, 78.8825F, 94.5937F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-7.97F, 78.88F, 94.59F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-7.75F, -7.7F, -2.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(-7.75F, -7.7F, -2.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "handle",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, 2.5F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-5.0F, 2.5F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(7.5F, 2.5F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(7.5F, 2.5F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(32.5F, 2.5F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.degreeVec(44.7356F, 6.0285F, 1.447F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(44.7356F, 6.0285F, 1.447F), Interpolations.LINEAR),
                  new Keyframe(4.55F, KeyframeAnimations.degreeVec(47.24F, 18.53F, 18.95F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "handle",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.55F, KeyframeAnimations.posVec(-32.0324F, -11.3235F, 1.3045F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "handle",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(4.55F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chainStart",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.3595F, -8.1485F, 6.1176F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(2.4991F, -10.6342F, 1.9664F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(2.4991F, -10.6342F, 1.9664F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(-1.8099F, -10.7714F, 24.8697F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(2.9654F, -10.515F, -0.5739F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(2.9654F, -10.515F, -0.5739F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-4.5556F, -71.3182F, 5.4048F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(7.6597F, -71.0715F, -10.1304F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(7.6597F, -71.0715F, -10.1304F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(210.8606F, -78.4812F, -171.5236F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(163.3606F, -78.4812F, -171.5236F), Interpolations.LINEAR),
                  new Keyframe(2.4F, KeyframeAnimations.degreeVec(143.3477F, -76.203F, -151.0266F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(143.3477F, -76.203F, -151.0266F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(128.3477F, -76.203F, -151.0266F), Interpolations.LINEAR),
                  new Keyframe(2.8F, KeyframeAnimations.degreeVec(145.8477F, -76.203F, -151.0266F), Interpolations.LINEAR),
                  new Keyframe(3.15F, KeyframeAnimations.degreeVec(165.8477F, -76.203F, -151.0266F), Interpolations.LINEAR),
                  new Keyframe(3.3F, KeyframeAnimations.degreeVec(149.6457F, -69.0757F, -124.2587F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(149.6457F, -69.0757F, -124.2587F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(129.1623F, -60.7961F, -101.7525F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(129.16F, -60.8F, -101.75F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(79.16F, -60.8F, -101.75F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.4F, KeyframeAnimations.degreeVec(-7.4718F, 0.6518F, 4.9574F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-7.4718F, 0.6518F, 4.9574F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(-17.4718F, 0.6518F, 4.9574F), Interpolations.LINEAR),
                  new Keyframe(2.8F, KeyframeAnimations.degreeVec(2.5282F, 0.6518F, 4.9574F), Interpolations.LINEAR),
                  new Keyframe(2.9F, KeyframeAnimations.degreeVec(2.5282F, 0.6518F, 4.9574F), Interpolations.LINEAR),
                  new Keyframe(3.3F, KeyframeAnimations.degreeVec(8.3894F, 3.3632F, 11.835F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(8.3894F, 3.3632F, 11.835F), Interpolations.LINEAR),
                  new Keyframe(3.9F, KeyframeAnimations.degreeVec(0.5097F, 6.0564F, -0.8061F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(15.063F, 4.208F, 6.8343F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(7.56F, 4.21F, 6.83F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(-29.94F, 4.21F, 6.83F), Interpolations.LINEAR),
                  new Keyframe(4.4F, KeyframeAnimations.degreeVec(-19.94F, 4.21F, 6.83F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain2",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(1.1F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.95F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.4F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.8F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.9F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.1F, KeyframeAnimations.degreeVec(-38.1658F, 9.8874F, -7.6861F), Interpolations.LINEAR),
                  new Keyframe(3.3F, KeyframeAnimations.degreeVec(-33.7379F, 16.7414F, 8.3811F), Interpolations.LINEAR),
                  new Keyframe(3.55F, KeyframeAnimations.degreeVec(-37.3307F, 11.1515F, 16.4562F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-37.3307F, 11.1515F, 16.4562F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-33.8839F, -34.2159F, 13.968F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-42.455F, -28.1804F, 22.3422F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(-51.38F, -34.22F, 23.97F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain3",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(1.2F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain4",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.4F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.8F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.9F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.1F, KeyframeAnimations.degreeVec(-32.9346F, 21.6203F, 2.4556F), Interpolations.LINEAR),
                  new Keyframe(3.2F, KeyframeAnimations.degreeVec(-16.3339F, 28.0952F, 20.0002F), Interpolations.LINEAR),
                  new Keyframe(3.5F, KeyframeAnimations.degreeVec(-15.309F, 33.0868F, 8.7006F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-15.309F, 33.0868F, 8.7006F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-25.038F, 24.894F, -11.1091F), Interpolations.LINEAR),
                  new Keyframe(4.25F, KeyframeAnimations.degreeVec(-51.0406F, 39.7147F, -2.588F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-22.1722F, 23.4277F, -3.5871F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(3.35F, 27.3F, 2.83F), Interpolations.LINEAR),
                  new Keyframe(4.4F, KeyframeAnimations.degreeVec(-1.65F, 27.3F, 2.83F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain4",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain5",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.1F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-14.9375F, -1.5018F, -4.7697F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(-19.9375F, -1.5018F, -4.7697F), Interpolations.LINEAR),
                  new Keyframe(2.8F, KeyframeAnimations.degreeVec(-32.4375F, -1.5018F, -4.7697F), Interpolations.LINEAR),
                  new Keyframe(2.9F, KeyframeAnimations.degreeVec(-25.681F, 6.9901F, 1.7834F), Interpolations.LINEAR),
                  new Keyframe(3.0F, KeyframeAnimations.degreeVec(-17.9426F, -2.9591F, 12.4789F), Interpolations.LINEAR),
                  new Keyframe(3.1F, KeyframeAnimations.degreeVec(-32.4492F, 1.1817F, -0.5504F), Interpolations.LINEAR),
                  new Keyframe(3.5F, KeyframeAnimations.degreeVec(-12.9085F, 3.1643F, 19.8005F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(-12.9085F, 3.1643F, 19.8005F), Interpolations.LINEAR),
                  new Keyframe(3.75F, KeyframeAnimations.degreeVec(-16.494F, 1.7781F, 14.2462F), Interpolations.LINEAR),
                  new Keyframe(3.9F, KeyframeAnimations.degreeVec(-17.2507F, -2.3805F, -2.4166F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-22.3971F, -8.4421F, -20.6632F), Interpolations.LINEAR),
                  new Keyframe(4.25F, KeyframeAnimations.degreeVec(1.0482F, -8.7637F, -4.1457F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-0.8523F, 2.4913F, 35.1106F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(8.65F, 0.49F, 15.06F), Interpolations.LINEAR),
                  new Keyframe(4.4F, KeyframeAnimations.degreeVec(-3.85F, 0.49F, 15.06F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain5",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(1.45F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain6",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.2F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-15.3453F, 14.7669F, -2.664F), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.degreeVec(-15.3453F, 14.7669F, -2.664F), Interpolations.LINEAR),
                  new Keyframe(2.9F, KeyframeAnimations.degreeVec(6.0616F, 10.7411F, 6.6994F), Interpolations.LINEAR),
                  new Keyframe(3.0F, KeyframeAnimations.degreeVec(-39.434F, 29.594F, -8.5628F), Interpolations.LINEAR),
                  new Keyframe(3.55F, KeyframeAnimations.degreeVec(11.5542F, 12.2057F, 12.5388F), Interpolations.LINEAR),
                  new Keyframe(3.65F, KeyframeAnimations.degreeVec(6.5542F, 12.2057F, 12.5388F), Interpolations.LINEAR),
                  new Keyframe(3.75F, KeyframeAnimations.degreeVec(4.2574F, 14.0167F, 2.4397F), Interpolations.LINEAR),
                  new Keyframe(3.8F, KeyframeAnimations.degreeVec(2.1527F, 12.8108F, 1.1394F), Interpolations.LINEAR),
                  new Keyframe(3.9F, KeyframeAnimations.degreeVec(2.9433F, 10.3989F, -1.4611F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-10.6704F, 4.456F, -11.5823F), Interpolations.LINEAR),
                  new Keyframe(4.25F, KeyframeAnimations.degreeVec(-4.2847F, 13.2482F, -40.7422F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(8.4348F, 14.0748F, 26.0325F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(-7.75F, 15.36F, -6.65F), Interpolations.LINEAR),
                  new Keyframe(4.4F, KeyframeAnimations.degreeVec(-7.75F, 15.36F, -6.65F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain6",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(1.85F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.1F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, -5.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hull",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(2.599F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(2.65F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.scaleVec(0.8F, 1.0, 1.9F), Interpolations.LINEAR),
                  new Keyframe(2.85F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(4.299F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(47.2947F, 20.3671F, 44.3488F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(87.2947F, 20.3671F, 51.8488F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(94.7947F, 20.3671F, 51.8488F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(87.2947F, 20.3671F, 51.8488F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(14.7947F, 20.3671F, 51.8488F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(12.2947F, 20.3671F, 51.8488F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(97.2947F, 20.3671F, 51.8488F), Interpolations.LINEAR),
                  new Keyframe(3.75F, KeyframeAnimations.degreeVec(97.2947F, 20.3671F, 51.8488F), Interpolations.LINEAR),
                  new Keyframe(3.9F, KeyframeAnimations.degreeVec(2.0143F, 58.251F, 41.2469F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-0.4857F, 65.751F, 41.2469F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-41.8428F, 3.3638F, 50.904F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(-41.8428F, 3.3638F, 50.904F), Interpolations.LINEAR),
                  new Keyframe(5.45F, KeyframeAnimations.degreeVec(24.3933F, 7.607F, 68.6305F), Interpolations.LINEAR),
                  new Keyframe(5.6F, KeyframeAnimations.degreeVec(52.823F, -10.3315F, 64.2441F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(50.5052F, 8.2141F, 58.1677F), Interpolations.LINEAR),
                  new Keyframe(5.9F, KeyframeAnimations.degreeVec(50.0379F, -1.6651F, 71.2926F), Interpolations.LINEAR),
                  new Keyframe(6.0F, KeyframeAnimations.degreeVec(47.2947F, 20.3671F, 44.3488F), Interpolations.LINEAR),
                  new Keyframe(6.1F, KeyframeAnimations.degreeVec(47.2947F, 20.3671F, 44.3488F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.posVec(0.5107F, -0.9928F, 0.06F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.51F, -0.99F, 0.06F), Interpolations.LINEAR),
                  new Keyframe(3.9F, KeyframeAnimations.posVec(0.51F, -0.99F, 0.06F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.posVec(0.51F, -0.99F, 0.06F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-130.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-142.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-150.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(-130.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.75F, KeyframeAnimations.degreeVec(-130.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.9F, KeyframeAnimations.degreeVec(-100.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-100.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.45F, KeyframeAnimations.degreeVec(-63.75F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.6F, KeyframeAnimations.degreeVec(-77.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(-92.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(6.0F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(6.1F, KeyframeAnimations.degreeVec(-77.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.posVec(0.0F, -0.8725F, -1.552F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -1.3287F, -2.1153F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.posVec(0.0F, -1.4284F, -2.7527F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.posVec(0.0F, -1.0492F, -1.9104F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(0.0F, -1.0492F, -1.9104F), Interpolations.LINEAR),
                  new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, -0.9576F, -1.8717F), Interpolations.LINEAR),
                  new Keyframe(3.9F, KeyframeAnimations.posVec(0.0F, -0.9576F, -1.8717F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.posVec(0.0F, -0.9576F, -1.8717F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.6F, KeyframeAnimations.posVec(0.0F, -0.9576F, -1.8717F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(-52.1015F, 38.0036F, -18.5428F), Interpolations.LINEAR),
                  new Keyframe(3.75F, KeyframeAnimations.degreeVec(-52.1015F, 38.0036F, -18.5428F), Interpolations.LINEAR),
                  new Keyframe(3.9F, KeyframeAnimations.degreeVec(-124.1408F, 69.8651F, -96.4627F), Interpolations.LINEAR),
                  new Keyframe(4.15F, KeyframeAnimations.degreeVec(-126.6408F, 69.8651F, -96.4627F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-60.5221F, 50.3061F, 7.3938F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(-60.5221F, 50.3061F, 7.3938F), Interpolations.LINEAR),
                  new Keyframe(5.4F, KeyframeAnimations.degreeVec(-61.6894F, 56.156F, -24.9238F), Interpolations.LINEAR),
                  new Keyframe(5.65F, KeyframeAnimations.degreeVec(-71.6894F, 56.156F, -24.9238F), Interpolations.LINEAR),
                  new Keyframe(5.8F, KeyframeAnimations.degreeVec(-68.1455F, 47.0798F, -21.7333F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(-49.6015F, 38.0036F, -18.5428F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(3.9F, KeyframeAnimations.posVec(0.1855F, -1.647F, -1.7543F), Interpolations.LINEAR),
                  new Keyframe(4.15F, KeyframeAnimations.posVec(0.1855F, -1.647F, -1.7543F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.posVec(0.19F, -2.75F, -1.75F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.posVec(0.19F, -2.75F, -1.75F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.posVec(0.4673F, -1.3712F, -0.605F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(23.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(23.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(13.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-11.776F, 2.4168F, 15.0906F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(-11.776F, 2.4168F, 15.0906F), Interpolations.LINEAR),
                  new Keyframe(5.4F, KeyframeAnimations.degreeVec(-26.776F, 2.4168F, 15.0906F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(23.224F, -7.5832F, 10.0906F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(57.679F, -4.1157F, -2.1768F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(57.679F, -4.1157F, -2.1768F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(57.679F, -4.1157F, -2.1768F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(12.68F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(12.68F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(5.4F, KeyframeAnimations.degreeVec(17.68F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(57.679F, -4.1157F, -2.1768F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(17.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(17.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-4.9843F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-9.9843F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(-9.9843F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(5.4F, KeyframeAnimations.degreeVec(-22.4843F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(17.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.55F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(46.282F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(46.282F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(-18.9954F, 7.5046F, -12.6751F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(-16.4954F, 0.0046F, -15.1751F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(-16.4954F, 0.0046F, -15.1751F), Interpolations.LINEAR),
                  new Keyframe(5.4F, KeyframeAnimations.degreeVec(-28.9954F, 0.0046F, -15.1751F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(46.282F, 3.5796F, -8.6772F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(2.75F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.7F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.5F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "flame",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(6.0F, 17.0F, -7.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.posVec(6.0F, 17.0F, -7.0F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.posVec(-17.0F, -6.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "flame",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(5.95F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife1",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(2.6F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(4.15F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.scaleVec(1.0, 1.0, 2.3F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife2",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(5.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife2",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(2.6F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(4.15F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.scaleVec(1.0, 1.0, 2.3F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(5.95F, KeyframeAnimations.degreeVec(-5.0F, -2.5F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(4.15F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(4.2F, KeyframeAnimations.scaleVec(1.0, 1.0, 2.3F), Interpolations.LINEAR),
                  new Keyframe(4.3F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(5.3F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmGore2",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(5.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .build();
   }

   static AnimationDefinition initRunClawAttackAnim() {
      return Builder.withLength(1.9F)
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -3.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hips",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-47.5F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-52.5F, -5.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.05F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(-30.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(-30.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-35.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofLeft",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(62.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.05F, KeyframeAnimations.degreeVec(-72.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(-72.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(-72.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(-72.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-70.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineCenter",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.6151F, 12.9126F, -2.1494F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(27.5339F, 18.5004F, -2.046F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(36.0339F, 18.5004F, -2.046F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-12.1075F, -16.7385F, 14.0164F), Interpolations.LINEAR),
                  new Keyframe(0.95F, KeyframeAnimations.degreeVec(-8.7468F, -14.669F, 11.0391F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(-6.2468F, -14.669F, 11.0391F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(17.8684F, 18.2642F, -3.7327F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(17.8684F, 18.2642F, -3.7327F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(20.3684F, 18.2642F, -3.7327F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.degreeVec(17.8684F, 18.2642F, -3.7327F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-15.0F, -5.0F, 2.2236F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-13.382F, -16.0767F, 9.9942F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(4.7325F, -10.899F, 7.83F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(-24.0333F, 2.2794F, 0.709F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-22.1651F, 2.3754F, 0.9343F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(-31.844F, -11.5042F, 26.0351F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(-34.344F, -11.5042F, 26.0351F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(-31.844F, -11.5042F, 26.0351F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(-34.344F, -11.5042F, 26.0351F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(20.19F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(17.61F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(12.61F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.05F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.posVec(0.0F, 0.85F, -0.03F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.posVec(0.0F, 1.39F, -0.04F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 1.39F, -0.04F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.posVec(0.0F, 2.03F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.posVec(0.0F, 1.73F, -0.22F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.posVec(0.0F, 2.03F, -0.22F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.1873F, -15.0947F, -14.6675F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(1.4543F, -14.5906F, -23.0694F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(21.1198F, -0.6754F, -0.5053F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(21.1198F, -0.6754F, -0.5053F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(3.33F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-0.7146F, 17.9195F, 18.1684F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(-0.4291F, 16.7408F, 22.3653F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(-0.4291F, 16.7408F, 22.3653F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chainStart",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(14.7F, 0.0F, -6.0F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(2.2F, 0.0F, -6.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(2.2F, 0.0F, -6.0F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(29.7F, 0.0F, -6.0F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(32.2F, 0.0F, -6.0F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(12.2F, 0.0F, -6.0F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(24.7876F, 1.5435F, -12.5285F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(17.6609F, 0.9101F, -16.9167F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-49.117F, -2.2552F, 48.6765F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(-59.9353F, 4.2102F, 60.142F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-59.9353F, 4.2102F, 60.142F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(69.8149F, 4.914F, -73.2348F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(71.9919F, 7.2044F, -75.6313F), Interpolations.LINEAR),
                  new Keyframe(1.1F, KeyframeAnimations.degreeVec(-49.117F, -2.2552F, 48.6765F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(-49.117F, -2.2552F, 48.6765F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(-49.0446F, 2.3608F, 40.5742F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(29.4375F, -3.0348F, -33.8029F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(-0.5F, -9.0F, -1.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(36.7778F, -9.4798F, 24.9783F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(36.78F, -9.48F, 24.98F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(34.28F, -9.48F, 24.98F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-59.8627F, -4.2662F, -3.8555F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(-62.4325F, -2.1033F, -2.5998F), Interpolations.LINEAR),
                  new Keyframe(1.05F, KeyframeAnimations.degreeVec(-59.9325F, -2.1033F, -2.5998F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(36.3234F, -4.0594F, 78.6741F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(37.4799F, -7.0607F, 70.1418F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(47.2947F, 20.3671F, 44.3488F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-42.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(-45.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.2F, KeyframeAnimations.degreeVec(-77.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(133.9939F, 8.8894F, -190.5926F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(136.4939F, 8.8894F, -190.5926F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(186.5978F, -13.4676F, -193.1434F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(189.0978F, -13.4676F, -193.1434F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(305.4743F, 79.116F, -65.0403F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(275.4743F, 79.116F, -65.0403F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(322.9892F, 67.8559F, -13.3688F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.4673F, -1.3712F, -0.605F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(20.724F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(10.724F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(38.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(33.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(23.224F, 4.9168F, 25.0906F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(42.679F, -4.1157F, -2.1768F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(27.679F, -4.1157F, -2.1768F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(60.179F, -4.1157F, -2.1768F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(52.68F, -4.12F, -2.18F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(57.679F, -4.1157F, -2.1768F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife1",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.55F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.scaleVec(1.0, 1.0, 2.2F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(15.0157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(2.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(40.0157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(10.0157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(17.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(50.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(67.6945F, -0.8937F, 0.3873F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife2",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.55F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.scaleVec(1.0, 1.0, 2.2F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(18.9505F, 8.3113F, -7.0521F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(2.4146F, 3.8745F, -17.363F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(27.4146F, 3.8745F, -17.363F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(28.782F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(46.282F, 3.5796F, -8.6772F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(33.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(23.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(51.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, 17.5F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.55F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.scaleVec(1.0, 1.0, 2.2F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "flame", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .build();
   }

   static AnimationDefinition initRunAttackWallImpactAnim() {
      return Builder.withLength(2.0F)
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.posVec(0.0F, -4.0F, 10.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -4.0F, 13.7F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, -4.0F, 13.7F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottomEnd",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hips",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hips",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(1.999F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(65.0532F, 0.3515F, 1.8296F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(65.1171F, 0.7732F, 4.025F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-84.7216F, -0.4575F, 0.319F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(-79.3876F, -1.0066F, 0.7018F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofLeft",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(77.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-63.1034F, -1.0114F, 0.1797F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(-68.1034F, -1.0114F, 0.1797F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(26.39F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.8F, KeyframeAnimations.degreeVec(26.39F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "spineCenter",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(10.2377F, -12.3071F, -2.2046F), Interpolations.LINEAR),
                  new Keyframe(0.25F, KeyframeAnimations.degreeVec(-4.7623F, -12.3071F, -2.2046F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(10.2377F, -12.3071F, -2.2046F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(12.7377F, -12.3071F, -2.2046F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(12.4774F, -8.6893F, -1.6129F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(12.3301F, -11.5699F, -2.6824F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(11.8698F, -3.8574F, -1.4599F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(7.6151F, 12.9126F, -2.1494F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, -5.0F), Interpolations.LINEAR),
                  new Keyframe(0.05F, KeyframeAnimations.degreeVec(-4.1667F, 3.3333F, -3.3333F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(-42.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(-2.1136F, 14.5701F, -10.6692F), Interpolations.LINEAR),
                  new Keyframe(1.35F, KeyframeAnimations.degreeVec(-3.6638F, 21.9063F, -13.6987F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(-3.1403F, -2.5624F, 9.218F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-1.193F, -2.3247F, 11.8073F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-2.4967F, 9.5567F, -10.4241F), Interpolations.LINEAR),
                  new Keyframe(1.55F, KeyframeAnimations.degreeVec(-3.6638F, 21.9063F, -13.6987F), Interpolations.LINEAR),
                  new Keyframe(1.7F, KeyframeAnimations.degreeVec(0.0F, 5.0F, -5.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-34.344F, -6.5042F, 8.5351F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 1.6F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0436F, -0.5101F, 0.8282F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0436F, -0.5101F, 0.8282F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(1.999F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(19.6105F, -11.1734F, -8.7325F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-16.3701F, -10.6147F, -28.2959F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(2.5305F, -8.9387F, -29.486F), Interpolations.LINEAR),
                  new Keyframe(0.8F, KeyframeAnimations.degreeVec(2.28F, -8.04F, -13.79F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-0.2F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(-0.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(-50.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-42.08F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.9F, KeyframeAnimations.degreeVec(-47.08F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.62F, 5.95F, 1.15F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hand",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-14.9F, 7.32F, 8.52F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFingerTip1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger2",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-6.0205F, 4.0361F, 8.3965F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "leftFingerTip2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 22.5F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(6.7086F, 9.571F, 12.3299F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "leftFingerTip3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-82.57F, -67.46F, 90.14F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "thumbTip",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -52.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "chainStart",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.4609F, 0.9101F, -10.9167F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(7.2F, 0.0F, -6.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "chain1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-0.5F, -9.0F, -1.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-55.1558F, -34.8926F, 38.197F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-75.9254F, -47.8951F, 45.5428F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(-78.4254F, -47.8951F, 45.5428F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(-69.3814F, -45.5626F, 46.8555F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(-61.8814F, -45.5626F, 46.8555F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-61.8814F, -45.5626F, 46.8555F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(-22.4071F, -7.8419F, 54.9032F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(47.2947F, 20.3671F, 44.3488F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(47.2947F, 20.3671F, 44.3488F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(47.2947F, 20.3671F, 44.3488F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.1F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.55F, KeyframeAnimations.degreeVec(-62.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(-62.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(-93.75F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.85F, KeyframeAnimations.degreeVec(-92.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.9F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-77.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmGore2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmGore2",
            new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.5F, 15.0F, -14.5F), Interpolations.LINEAR),
                  new Keyframe(0.15F, KeyframeAnimations.degreeVec(-15.5186F, -38.6112F, -1.3856F), Interpolations.LINEAR),
                  new Keyframe(0.35F, KeyframeAnimations.degreeVec(-21.5388F, -31.3548F, 9.0534F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(-12.0678F, 0.3395F, -11.2886F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(-47.4442F, 21.8618F, -15.4339F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-49.6015F, 38.0036F, -18.5428F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.POSITION, new Keyframe[]{new Keyframe(2.0F, KeyframeAnimations.posVec(0.4673F, -1.3712F, -0.605F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(23.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(0.724F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(8.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(39.0466F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(39.0466F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(23.224F, -7.5832F, 10.0906F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(23.224F, -7.5832F, 10.0906F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger1tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(57.679F, -4.1157F, -2.1768F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(35.179F, -4.1157F, -2.1768F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(47.679F, -4.1157F, -2.1768F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(81.3886F, -4.1157F, -2.1768F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(81.3886F, -4.1157F, -2.1768F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(57.679F, -4.1157F, -2.1768F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(57.679F, -4.1157F, -2.1768F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(7.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(12.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(40.3571F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(1.6F, KeyframeAnimations.degreeVec(40.3571F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(17.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(17.5157F, -2.3842F, -3.2522F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger2tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.45F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.7F, KeyframeAnimations.degreeVec(52.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(79.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(55.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(46.282F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(0.2F, KeyframeAnimations.degreeVec(33.782F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(0.75F, KeyframeAnimations.degreeVec(38.782F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(56.6509F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(46.282F, 3.5796F, -8.6772F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(46.282F, 3.5796F, -8.6772F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "finger3tip",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.65F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.85F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.5F, KeyframeAnimations.degreeVec(59.35F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.75F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(47.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, -2.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(-5.0F, -2.5F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "flame",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(6.0F, 17.0F, -7.0F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.posVec(-17.0F, -6.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "flame",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)
               }
            )
         )
         .build();
   }

   static AnimationDefinition initDeathAnim() {
      return Builder.withLength(23.25F)
         .addAnimation(
            "body",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "body",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.posVec(0.0F, -4.0F, 6.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.posVec(0.0F, -4.0F, 9.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -4.0F, 9.0F), Interpolations.LINEAR),
                  new Keyframe(1.05F, KeyframeAnimations.posVec(0.0F, -1.97F, 6.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.posVec(0.0F, -0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.posVec(0.0F, -3.9F, 2.0F), Interpolations.LINEAR),
                  new Keyframe(18.5F, KeyframeAnimations.posVec(0.0F, -4.4F, 2.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(4.5739F, 2.4438F, -5.1971F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 2.5F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(4.6758F, 2.2422F, -2.7032F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(4.68F, 2.24F, -2.7F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(12.273F, 2.034F, -0.2068F), Interpolations.LINEAR),
                  new Keyframe(21.5F, KeyframeAnimations.degreeVec(12.27F, 2.03F, -0.21F), Interpolations.LINEAR),
                  new Keyframe(22.0F, KeyframeAnimations.degreeVec(84.77F, 2.03F, -0.21F), Interpolations.LINEAR),
                  new Keyframe(22.15F, KeyframeAnimations.degreeVec(82.27F, 2.03F, -0.21F), Interpolations.LINEAR),
                  new Keyframe(22.25F, KeyframeAnimations.degreeVec(84.77F, 2.03F, -0.21F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottom",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(21.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(21.7F, KeyframeAnimations.posVec(0.0F, -9.2F, -12.2F), Interpolations.LINEAR),
                  new Keyframe(22.0F, KeyframeAnimations.posVec(0.0F, -23.0F, -23.0F), Interpolations.LINEAR),
                  new Keyframe(22.15F, KeyframeAnimations.posVec(0.0F, -22.4F, -23.6F), Interpolations.LINEAR),
                  new Keyframe(22.25F, KeyframeAnimations.posVec(0.0F, -23.0F, -23.8F), Interpolations.LINEAR),
                  new Keyframe(22.55F, KeyframeAnimations.posVec(0.0F, -23.0F, -24.4F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineBottomEnd",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hips",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hips", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(-17.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(-52.5515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(18.5F, KeyframeAnimations.degreeVec(-55.0515F, -9.6905F, -0.2746F), Interpolations.LINEAR),
                  new Keyframe(21.5F, KeyframeAnimations.degreeVec(-55.05F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(21.6F, KeyframeAnimations.degreeVec(-23.55F, -9.69F, -0.27F), Interpolations.LINEAR),
                  new Keyframe(21.75F, KeyframeAnimations.degreeVec(-7.55F, -9.69F, -0.27F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftTop",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, 0.0F, 0.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "legLeftMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(45.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(65.0532F, 0.3515F, 1.8296F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(52.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(80.1597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(18.5F, KeyframeAnimations.degreeVec(82.6597F, 1.0544F, 5.4887F), Interpolations.LINEAR),
                  new Keyframe(21.5F, KeyframeAnimations.degreeVec(82.66F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(21.6F, KeyframeAnimations.degreeVec(85.16F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(21.75F, KeyframeAnimations.degreeVec(70.16F, 1.05F, 5.49F), Interpolations.LINEAR),
                  new Keyframe(22.0F, KeyframeAnimations.degreeVec(35.16F, 1.05F, 5.49F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legLeftBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-74.7216F, -0.4575F, 0.319F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(-59.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(-64.1649F, -1.3726F, 0.9571F), Interpolations.LINEAR),
                  new Keyframe(21.5F, KeyframeAnimations.degreeVec(-64.16F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(21.6F, KeyframeAnimations.degreeVec(-36.66F, -1.37F, 0.96F), Interpolations.LINEAR),
                  new Keyframe(21.75F, KeyframeAnimations.degreeVec(-51.66F, -1.37F, 0.96F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofLeft",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(21.5F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-47.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(9.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(24.3843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(18.5F, KeyframeAnimations.degreeVec(26.8843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(21.5F, KeyframeAnimations.degreeVec(26.8843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(22.0F, KeyframeAnimations.degreeVec(-0.6157F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(22.15F, KeyframeAnimations.degreeVec(1.8843F, 13.7149F, 8.5641F), Interpolations.LINEAR),
                  new Keyframe(22.25F, KeyframeAnimations.degreeVec(-0.6157F, 13.7149F, 8.5641F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightTop",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(1.0F, 0.0F, 1.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "legRightMid",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(77.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.05F, KeyframeAnimations.degreeVec(59.8284F, -4.6923F, 0.4217F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(57.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(34.5983F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(37.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(15.7F, KeyframeAnimations.degreeVec(48.7427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(32.2427F, -7.0384F, 0.6325F), Interpolations.LINEAR),
                  new Keyframe(21.5F, KeyframeAnimations.degreeVec(32.24F, -7.04F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(21.65F, KeyframeAnimations.degreeVec(49.74F, -7.04F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(21.8F, KeyframeAnimations.degreeVec(37.24F, -7.04F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(21.9F, KeyframeAnimations.degreeVec(35.5733F, -7.04F, 0.63F), Interpolations.LINEAR),
                  new Keyframe(22.0F, KeyframeAnimations.degreeVec(27.24F, -7.04F, 0.63F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-50.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-47.6185F, -0.8299F, 0.6608F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-47.6185F, -0.8299F, 0.6608F), Interpolations.LINEAR),
                  new Keyframe(1.05F, KeyframeAnimations.degreeVec(-45.6825F, -1.5646F, 0.6202F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(-64.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(15.7F, KeyframeAnimations.degreeVec(-84.8103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(-79.3103F, -3.0341F, 0.539F), Interpolations.LINEAR),
                  new Keyframe(21.55F, KeyframeAnimations.degreeVec(-79.31F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(21.8F, KeyframeAnimations.degreeVec(-39.31F, -3.03F, 0.54F), Interpolations.LINEAR),
                  new Keyframe(22.0F, KeyframeAnimations.degreeVec(-41.81F, -3.03F, 0.54F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "legRightBottom",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hoofRight",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "spineCenter",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(10.2377F, -12.3071F, -2.2046F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(20.8111F, -19.5343F, -4.2907F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(18.3111F, -19.5343F, -4.2907F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(20.8111F, -19.5343F, -4.2907F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(24.5611F, -19.5343F, -4.2907F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(9.2455F, -10.2799F, 2.1949F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(6.7455F, -10.2799F, 2.1949F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(5.7455F, -10.2799F, 2.1949F), Interpolations.LINEAR),
                  new Keyframe(2.0F, KeyframeAnimations.degreeVec(11.7458F, -10.2799F, 2.1947F), Interpolations.LINEAR),
                  new Keyframe(2.5F, KeyframeAnimations.degreeVec(12.7458F, -10.2799F, 2.1947F), Interpolations.LINEAR),
                  new Keyframe(3.5F, KeyframeAnimations.degreeVec(6.7455F, -10.2799F, 2.1949F), Interpolations.LINEAR),
                  new Keyframe(3.85F, KeyframeAnimations.degreeVec(11.7458F, -10.2799F, 2.1947F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(12.7458F, -10.2799F, 2.1947F), Interpolations.LINEAR),
                  new Keyframe(5.35F, KeyframeAnimations.degreeVec(6.7455F, -10.2799F, 2.1949F), Interpolations.LINEAR),
                  new Keyframe(5.7F, KeyframeAnimations.degreeVec(11.7458F, -10.2799F, 2.1947F), Interpolations.LINEAR),
                  new Keyframe(6.2F, KeyframeAnimations.degreeVec(12.7458F, -10.2799F, 2.1947F), Interpolations.LINEAR),
                  new Keyframe(7.2F, KeyframeAnimations.degreeVec(6.7455F, -10.2799F, 2.1949F), Interpolations.LINEAR),
                  new Keyframe(7.55F, KeyframeAnimations.degreeVec(11.7458F, -10.2799F, 2.1947F), Interpolations.LINEAR),
                  new Keyframe(8.05F, KeyframeAnimations.degreeVec(12.7458F, -10.2799F, 2.1947F), Interpolations.LINEAR),
                  new Keyframe(9.05F, KeyframeAnimations.degreeVec(6.7455F, -10.2799F, 2.1949F), Interpolations.LINEAR),
                  new Keyframe(12.25F, KeyframeAnimations.degreeVec(6.75F, -10.28F, 2.19F), Interpolations.LINEAR),
                  new Keyframe(14.5F, KeyframeAnimations.degreeVec(9.25F, -10.28F, 2.19F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(6.75F, -10.28F, 2.19F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(21.75F, -10.28F, 2.19F), Interpolations.LINEAR),
                  new Keyframe(17.8F, KeyframeAnimations.degreeVec(29.25F, -10.28F, 2.19F), Interpolations.LINEAR),
                  new Keyframe(19.5F, KeyframeAnimations.degreeVec(29.25F, -10.28F, 2.19F), Interpolations.LINEAR),
                  new Keyframe(19.75F, KeyframeAnimations.degreeVec(43.7319F, -6.6816F, 5.7006F), Interpolations.LINEAR),
                  new Keyframe(21.0F, KeyframeAnimations.degreeVec(46.2319F, -6.6816F, 5.7006F), Interpolations.LINEAR),
                  new Keyframe(21.45F, KeyframeAnimations.degreeVec(46.2319F, -6.6816F, 5.7006F), Interpolations.LINEAR),
                  new Keyframe(21.7F, KeyframeAnimations.degreeVec(13.7319F, -6.6816F, 5.7006F), Interpolations.LINEAR),
                  new Keyframe(21.95F, KeyframeAnimations.degreeVec(11.2319F, -6.6816F, 5.7006F), Interpolations.LINEAR),
                  new Keyframe(22.15F, KeyframeAnimations.degreeVec(-3.7681F, -6.6816F, 5.7006F), Interpolations.LINEAR),
                  new Keyframe(22.25F, KeyframeAnimations.degreeVec(-5.7681F, -6.6816F, 5.7006F), Interpolations.LINEAR),
                  new Keyframe(22.5F, KeyframeAnimations.degreeVec(11.2319F, -6.6816F, 5.7006F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineCenter",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(19.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "spineTop",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(37.4011F, -2.6841F, 4.22F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.25F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.5F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.1F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.35F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.95F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(7.2F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(7.8F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.0F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.5F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(19.35F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(20.2F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(21.45F, KeyframeAnimations.degreeVec(42.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(21.75F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(22.0F, KeyframeAnimations.degreeVec(-23.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(22.15F, KeyframeAnimations.degreeVec(32.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "spineTop",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(19.35F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, -5.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-30.1258F, 5.5783F, -0.3423F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(-27.6258F, 5.5783F, -0.3423F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(-30.1258F, 5.5783F, -0.3423F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-30.1258F, 5.5783F, -0.3423F), Interpolations.LINEAR),
                  new Keyframe(1.15F, KeyframeAnimations.degreeVec(-29.9764F, 1.2497F, 2.1654F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.5F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.5F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.35F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(6.2F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(7.2F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.05F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.0F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.5F, KeyframeAnimations.degreeVec(-20.4378F, -17.1888F, 3.4647F), Interpolations.LINEAR),
                  new Keyframe(10.15F, KeyframeAnimations.degreeVec(-20.7295F, -19.5292F, 4.3907F), Interpolations.LINEAR),
                  new Keyframe(12.25F, KeyframeAnimations.degreeVec(-18.2295F, -19.5292F, 4.3907F), Interpolations.LINEAR),
                  new Keyframe(12.75F, KeyframeAnimations.degreeVec(-7.0944F, 8.3797F, -3.8783F), Interpolations.LINEAR),
                  new Keyframe(12.85F, KeyframeAnimations.degreeVec(-7.1137F, 9.372F, -4.0035F), Interpolations.LINEAR),
                  new Keyframe(13.45F, KeyframeAnimations.degreeVec(-7.2326F, -13.9492F, -1.0869F), Interpolations.LINEAR),
                  new Keyframe(13.55F, KeyframeAnimations.degreeVec(-7.2651F, -14.9412F, -0.9567F), Interpolations.LINEAR),
                  new Keyframe(14.2F, KeyframeAnimations.degreeVec(-7.0944F, 8.3797F, -3.8783F), Interpolations.LINEAR),
                  new Keyframe(14.3F, KeyframeAnimations.degreeVec(-7.1137F, 9.372F, -4.0035F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(19.35F, KeyframeAnimations.degreeVec(-30.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(20.25F, KeyframeAnimations.degreeVec(-44.8265F, 2.8631F, 6.9349F), Interpolations.LINEAR),
                  new Keyframe(21.5F, KeyframeAnimations.degreeVec(-44.83F, 2.86F, 6.93F), Interpolations.LINEAR),
                  new Keyframe(21.8F, KeyframeAnimations.degreeVec(-54.83F, 2.86F, 6.93F), Interpolations.LINEAR),
                  new Keyframe(22.0F, KeyframeAnimations.degreeVec(-62.33F, 2.86F, 6.93F), Interpolations.LINEAR),
                  new Keyframe(22.15F, KeyframeAnimations.degreeVec(-118.7189F, 2.86F, 6.93F), Interpolations.LINEAR),
                  new Keyframe(22.25F, KeyframeAnimations.degreeVec(-120.1078F, 2.86F, 6.93F), Interpolations.LINEAR),
                  new Keyframe(22.6F, KeyframeAnimations.degreeVec(-133.4466F, 12.0358F, -1.6405F), Interpolations.LINEAR),
                  new Keyframe(22.8F, KeyframeAnimations.degreeVec(-145.9466F, 12.0358F, -1.6405F), Interpolations.LINEAR),
                  new Keyframe(22.95F, KeyframeAnimations.degreeVec(-148.9274F, 13.3352F, -3.8298F), Interpolations.LINEAR),
                  new Keyframe(23.25F, KeyframeAnimations.degreeVec(-138.4466F, 12.0358F, -1.6405F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "head",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(19.35F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(22.0F, KeyframeAnimations.posVec(0.0F, 0.9F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(22.1F, KeyframeAnimations.posVec(-0.2632F, 3.1276F, -2.2214F), Interpolations.LINEAR),
                  new Keyframe(22.25F, KeyframeAnimations.posVec(-0.6405F, 10.5563F, -6.3179F), Interpolations.LINEAR),
                  new Keyframe(22.5F, KeyframeAnimations.posVec(1.1174F, 12.3449F, 7.9949F), Interpolations.LINEAR),
                  new Keyframe(22.65F, KeyframeAnimations.posVec(1.1955F, 14.7201F, 9.4393F), Interpolations.LINEAR),
                  new Keyframe(22.95F, KeyframeAnimations.posVec(0.7623F, 21.5512F, 7.1732F), Interpolations.LINEAR),
                  new Keyframe(23.1F, KeyframeAnimations.posVec(0.9267F, 21.7291F, 8.5629F), Interpolations.LINEAR),
                  new Keyframe(23.25F, KeyframeAnimations.posVec(0.8757F, 23.1324F, 8.3861F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.4F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.5F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.5F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(3.5F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(4.35F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(5.35F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(6.2F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(7.2F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(8.05F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.5F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(11.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(11.75F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(12.25F, KeyframeAnimations.degreeVec(11.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(12.75F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.85F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(19.05F, KeyframeAnimations.degreeVec(19.7197F, 3.4049F, -9.408F), Interpolations.LINEAR),
                  new Keyframe(19.2F, KeyframeAnimations.degreeVec(22.7197F, 3.4049F, -9.408F), Interpolations.LINEAR),
                  new Keyframe(19.45F, KeyframeAnimations.degreeVec(14.7197F, 3.4049F, -9.408F), Interpolations.LINEAR),
                  new Keyframe(20.25F, KeyframeAnimations.degreeVec(14.7197F, 3.4049F, -9.408F), Interpolations.LINEAR),
                  new Keyframe(20.45F, KeyframeAnimations.degreeVec(24.5638F, 4.4474F, -11.6857F), Interpolations.LINEAR),
                  new Keyframe(20.55F, KeyframeAnimations.degreeVec(17.0638F, 4.4474F, -11.6857F), Interpolations.LINEAR),
                  new Keyframe(20.75F, KeyframeAnimations.degreeVec(15.0638F, 4.4474F, -11.6857F), Interpolations.LINEAR),
                  new Keyframe(21.05F, KeyframeAnimations.degreeVec(20.0638F, 4.4474F, -11.6857F), Interpolations.LINEAR),
                  new Keyframe(21.3F, KeyframeAnimations.degreeVec(17.5638F, 4.4474F, -11.6857F), Interpolations.LINEAR),
                  new Keyframe(22.2F, KeyframeAnimations.degreeVec(17.5638F, 4.4474F, -11.6857F), Interpolations.LINEAR),
                  new Keyframe(22.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(22.7F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(23.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(23.1F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "jaw",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 2.0274F, -0.2156F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.posVec(0.0F, 1.2F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.65F, KeyframeAnimations.posVec(0.0F, 1.3F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.0F, KeyframeAnimations.posVec(0.0F, 1.3F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.5F, KeyframeAnimations.posVec(0.0F, 2.3F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(11.0F, KeyframeAnimations.posVec(0.0F, 2.3F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(11.75F, KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(12.25F, KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(12.75F, KeyframeAnimations.posVec(0.0F, 3.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(16.0F, KeyframeAnimations.posVec(0.0F, 3.1F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.85F, KeyframeAnimations.posVec(0.0F, 3.1F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(19.05F, KeyframeAnimations.posVec(-0.2F, 2.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(19.45F, KeyframeAnimations.posVec(-0.2F, 2.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(20.25F, KeyframeAnimations.posVec(-0.2F, 2.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(20.45F, KeyframeAnimations.posVec(-0.2F, 0.0F, -2.0F), Interpolations.LINEAR),
                  new Keyframe(22.15F, KeyframeAnimations.posVec(-0.2F, 0.0F, -2.0F), Interpolations.LINEAR),
                  new Keyframe(22.25F, KeyframeAnimations.posVec(0.0F, 3.1F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(22.65F, KeyframeAnimations.posVec(0.0053F, 2.6003F, 0.0178F), Interpolations.LINEAR),
                  new Keyframe(22.95F, KeyframeAnimations.posVec(0.0053F, 2.6003F, 0.0178F), Interpolations.LINEAR),
                  new Keyframe(23.1F, KeyframeAnimations.posVec(0.0F, 3.1F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "torso",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0436F, -0.5101F, 0.8282F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "torso", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(19.6105F, -11.1734F, -8.7325F), Interpolations.LINEAR),
                  new Keyframe(9.0F, KeyframeAnimations.degreeVec(19.61F, -11.17F, -8.73F), Interpolations.LINEAR),
                  new Keyframe(9.5F, KeyframeAnimations.degreeVec(-17.89F, -11.17F, -8.73F), Interpolations.LINEAR),
                  new Keyframe(9.75F, KeyframeAnimations.degreeVec(-27.89F, -11.17F, -8.73F), Interpolations.LINEAR),
                  new Keyframe(11.0F, KeyframeAnimations.degreeVec(-30.39F, -11.17F, -8.73F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(-30.39F, -11.17F, -8.73F), Interpolations.LINEAR),
                  new Keyframe(13.0F, KeyframeAnimations.degreeVec(-0.39F, -11.17F, -8.73F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(-0.39F, -11.17F, -8.73F), Interpolations.LINEAR),
                  new Keyframe(15.8F, KeyframeAnimations.degreeVec(-85.1873F, 50.35F, -63.453F), Interpolations.LINEAR),
                  new Keyframe(18.5F, KeyframeAnimations.degreeVec(-88.2075F, 50.4941F, -67.3708F), Interpolations.LINEAR),
                  new Keyframe(18.85F, KeyframeAnimations.degreeVec(-58.2075F, 50.4941F, -67.3708F), Interpolations.LINEAR),
                  new Keyframe(19.0F, KeyframeAnimations.degreeVec(-56.2075F, 50.4941F, -67.3708F), Interpolations.LINEAR),
                  new Keyframe(19.35F, KeyframeAnimations.degreeVec(-68.2075F, 50.4941F, -67.3708F), Interpolations.LINEAR),
                  new Keyframe(19.5F, KeyframeAnimations.degreeVec(-68.2075F, 50.4941F, -67.3708F), Interpolations.LINEAR),
                  new Keyframe(19.75F, KeyframeAnimations.degreeVec(-71.4135F, 31.5336F, -75.9382F), Interpolations.LINEAR),
                  new Keyframe(20.0F, KeyframeAnimations.degreeVec(-72.2831F, 26.782F, -77.7214F), Interpolations.LINEAR),
                  new Keyframe(20.15F, KeyframeAnimations.degreeVec(-72.5754F, 24.8753F, -78.3921F), Interpolations.LINEAR),
                  new Keyframe(20.5F, KeyframeAnimations.degreeVec(-71.4135F, 31.5336F, -75.9382F), Interpolations.LINEAR),
                  new Keyframe(21.0F, KeyframeAnimations.degreeVec(-72.1257F, 27.7342F, -77.3776F), Interpolations.LINEAR),
                  new Keyframe(21.45F, KeyframeAnimations.degreeVec(-71.6045F, 30.5852F, -76.3084F), Interpolations.LINEAR),
                  new Keyframe(21.85F, KeyframeAnimations.degreeVec(27.7101F, -10.1161F, -10.2285F), Interpolations.LINEAR),
                  new Keyframe(22.0F, KeyframeAnimations.degreeVec(10.0832F, 4.6519F, -7.5903F), Interpolations.LINEAR),
                  new Keyframe(22.1F, KeyframeAnimations.degreeVec(5.7082F, 4.6519F, -7.5903F), Interpolations.LINEAR),
                  new Keyframe(22.25F, KeyframeAnimations.degreeVec(8.677F, 4.6519F, -7.5903F), Interpolations.LINEAR),
                  new Keyframe(22.5F, KeyframeAnimations.degreeVec(-6.9168F, 4.6519F, -7.5903F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArm",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(-0.2F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.posVec(-0.2F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.8F, KeyframeAnimations.posVec(-0.2F, -2.0F, -1.0F), Interpolations.LINEAR),
                  new Keyframe(18.5F, KeyframeAnimations.posVec(-0.2F, -2.0F, -1.0F), Interpolations.LINEAR),
                  new Keyframe(21.85F, KeyframeAnimations.posVec(-0.2F, -2.0F, -1.0F), Interpolations.LINEAR),
                  new Keyframe(22.0F, KeyframeAnimations.posVec(-0.2F, -2.0F, -4.8F), Interpolations.LINEAR),
                  new Keyframe(22.1F, KeyframeAnimations.posVec(-0.2F, -2.0F, -6.7F), Interpolations.LINEAR),
                  new Keyframe(22.25F, KeyframeAnimations.posVec(0.7924F, -1.0622F, -6.8064F), Interpolations.LINEAR),
                  new Keyframe(22.5F, KeyframeAnimations.posVec(0.7918F, 0.9697F, -4.5245F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.0F, KeyframeAnimations.degreeVec(-40.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.5F, KeyframeAnimations.degreeVec(-52.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.75F, KeyframeAnimations.degreeVec(-55.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(10.0F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(12.0F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(13.05F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.8F, KeyframeAnimations.degreeVec(-62.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.5F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.75F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(19.05F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(19.25F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(19.45F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(21.45F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(21.85F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(22.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(22.1F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(22.25F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(22.5F, KeyframeAnimations.degreeVec(0.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftArmLower",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(15.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.62F, 5.95F, 1.15F), Interpolations.LINEAR),
                  new Keyframe(9.0F, KeyframeAnimations.degreeVec(1.62F, 5.95F, 1.15F), Interpolations.LINEAR),
                  new Keyframe(9.5F, KeyframeAnimations.degreeVec(59.422F, -88.1284F, -58.4266F), Interpolations.LINEAR),
                  new Keyframe(9.75F, KeyframeAnimations.degreeVec(169.8584F, -80.8112F, -169.0038F), Interpolations.LINEAR),
                  new Keyframe(12.25F, KeyframeAnimations.degreeVec(59.422F, -88.1284F, -58.4266F), Interpolations.LINEAR),
                  new Keyframe(13.1F, KeyframeAnimations.degreeVec(2.3734F, 0.6919F, 8.4765F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(2.37F, 0.69F, 8.48F), Interpolations.LINEAR),
                  new Keyframe(15.8F, KeyframeAnimations.degreeVec(161.2007F, -82.3655F, -142.8958F), Interpolations.LINEAR),
                  new Keyframe(17.8F, KeyframeAnimations.degreeVec(161.2F, -82.37F, -142.9F), Interpolations.LINEAR),
                  new Keyframe(18.05F, KeyframeAnimations.degreeVec(97.5683F, -17.3846F, -74.1293F), Interpolations.LINEAR),
                  new Keyframe(18.2F, KeyframeAnimations.degreeVec(97.3315F, -9.9477F, -73.1293F), Interpolations.LINEAR),
                  new Keyframe(18.5F, KeyframeAnimations.degreeVec(97.5683F, -17.3846F, -74.1293F), Interpolations.LINEAR),
                  new Keyframe(18.8F, KeyframeAnimations.degreeVec(172.7211F, -82.7792F, -162.0788F), Interpolations.LINEAR),
                  new Keyframe(19.0F, KeyframeAnimations.degreeVec(172.7211F, -82.7792F, -162.0788F), Interpolations.LINEAR),
                  new Keyframe(19.15F, KeyframeAnimations.degreeVec(111.6873F, -70.282F, -99.9398F), Interpolations.LINEAR),
                  new Keyframe(19.6F, KeyframeAnimations.degreeVec(246.2333F, -71.9788F, -236.6936F), Interpolations.LINEAR),
                  new Keyframe(20.0F, KeyframeAnimations.degreeVec(209.5207F, -81.7623F, -199.1915F), Interpolations.LINEAR),
                  new Keyframe(22.1F, KeyframeAnimations.degreeVec(209.52F, -81.76F, -199.19F), Interpolations.LINEAR),
                  new Keyframe(22.2F, KeyframeAnimations.degreeVec(255.5006F, -60.1242F, -246.7755F), Interpolations.LINEAR),
                  new Keyframe(22.3F, KeyframeAnimations.degreeVec(273.2935F, -61.1149F, -267.1424F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "hand",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR),
                  new Keyframe(9.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR),
                  new Keyframe(9.5F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.25F), Interpolations.LINEAR),
                  new Keyframe(12.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.25F), Interpolations.LINEAR),
                  new Keyframe(13.1F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR),
                  new Keyframe(17.8F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR),
                  new Keyframe(22.1F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.75F), Interpolations.LINEAR),
                  new Keyframe(22.2F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.25F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-14.9F, 7.32F, 8.52F), Interpolations.LINEAR),
                  new Keyframe(10.0F, KeyframeAnimations.degreeVec(-14.9F, 7.32F, 8.52F), Interpolations.LINEAR),
                  new Keyframe(10.5F, KeyframeAnimations.degreeVec(-5.3787F, 15.6899F, 53.7369F), Interpolations.LINEAR),
                  new Keyframe(10.65F, KeyframeAnimations.degreeVec(-5.0981F, 15.7813F, 54.7715F), Interpolations.LINEAR),
                  new Keyframe(11.25F, KeyframeAnimations.degreeVec(-14.2238F, 8.5779F, 13.4063F), Interpolations.LINEAR),
                  new Keyframe(17.05F, KeyframeAnimations.degreeVec(-14.22F, 8.58F, 13.41F), Interpolations.LINEAR),
                  new Keyframe(17.3F, KeyframeAnimations.degreeVec(-6.9128F, -15.0874F, -82.1013F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(-4.132F, -16.0524F, -92.4349F), Interpolations.LINEAR),
                  new Keyframe(17.8F, KeyframeAnimations.degreeVec(-8.2193F, -14.4286F, -76.9756F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-16.3924F, -2.3982F, -25.1723F), Interpolations.LINEAR),
                  new Keyframe(18.4F, KeyframeAnimations.degreeVec(-15.9583F, -4.4903F, -32.3881F), Interpolations.LINEAR),
                  new Keyframe(18.6F, KeyframeAnimations.degreeVec(-16.3667F, 2.5724F, -8.3878F), Interpolations.LINEAR),
                  new Keyframe(19.25F, KeyframeAnimations.degreeVec(-15.9583F, -4.4903F, -32.3881F), Interpolations.LINEAR),
                  new Keyframe(19.5F, KeyframeAnimations.degreeVec(-13.0032F, 10.3475F, 20.7998F), Interpolations.LINEAR),
                  new Keyframe(19.8F, KeyframeAnimations.degreeVec(-12.5457F, 10.9004F, 23.2804F), Interpolations.LINEAR),
                  new Keyframe(20.5F, KeyframeAnimations.degreeVec(-11.5571F, 11.945F, 28.269F), Interpolations.LINEAR),
                  new Keyframe(21.95F, KeyframeAnimations.degreeVec(-11.56F, 11.95F, 28.27F), Interpolations.LINEAR),
                  new Keyframe(22.1F, KeyframeAnimations.degreeVec(-15.9157F, 4.6628F, -1.1682F), Interpolations.LINEAR),
                  new Keyframe(22.2F, KeyframeAnimations.degreeVec(-16.1381F, -3.799F, -29.9772F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger1",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "leftFingerTip1",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 12.5F), Interpolations.LINEAR),
                  new Keyframe(10.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 12.5F), Interpolations.LINEAR),
                  new Keyframe(10.55F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 72.5F), Interpolations.LINEAR),
                  new Keyframe(10.7F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 73.5F), Interpolations.LINEAR),
                  new Keyframe(11.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 17.5F), Interpolations.LINEAR),
                  new Keyframe(17.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 17.5F), Interpolations.LINEAR),
                  new Keyframe(17.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), Interpolations.LINEAR),
                  new Keyframe(17.55F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.9F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), Interpolations.LINEAR),
                  new Keyframe(18.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), Interpolations.LINEAR),
                  new Keyframe(19.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 30.0F), Interpolations.LINEAR),
                  new Keyframe(19.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), Interpolations.LINEAR),
                  new Keyframe(19.6F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), Interpolations.LINEAR),
                  new Keyframe(19.8F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 52.5F), Interpolations.LINEAR),
                  new Keyframe(20.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 57.5F), Interpolations.LINEAR),
                  new Keyframe(21.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 57.5F), Interpolations.LINEAR),
                  new Keyframe(22.1F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), Interpolations.LINEAR),
                  new Keyframe(22.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-6.0205F, 4.0361F, 8.3965F), Interpolations.LINEAR),
                  new Keyframe(10.25F, KeyframeAnimations.degreeVec(-6.02F, 4.04F, 8.4F), Interpolations.LINEAR),
                  new Keyframe(10.75F, KeyframeAnimations.degreeVec(-3.1949F, 6.5068F, 38.4309F), Interpolations.LINEAR),
                  new Keyframe(10.85F, KeyframeAnimations.degreeVec(-3.0805F, 6.5616F, 39.4359F), Interpolations.LINEAR),
                  new Keyframe(11.5F, KeyframeAnimations.degreeVec(-5.8387F, 4.2983F, 10.8932F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-14.22F, 8.58F, 13.41F), Interpolations.LINEAR),
                  new Keyframe(18.4F, KeyframeAnimations.degreeVec(-15.9583F, -4.4903F, -32.3881F), Interpolations.LINEAR),
                  new Keyframe(18.6F, KeyframeAnimations.degreeVec(-16.3667F, 2.5724F, -8.3878F), Interpolations.LINEAR),
                  new Keyframe(19.25F, KeyframeAnimations.degreeVec(-15.5226F, -5.8475F, -37.2201F), Interpolations.LINEAR),
                  new Keyframe(19.5F, KeyframeAnimations.degreeVec(-13.4351F, 9.7757F, 18.328F), Interpolations.LINEAR),
                  new Keyframe(19.8F, KeyframeAnimations.degreeVec(-8.0842F, 3.0693F, 24.3804F), Interpolations.LINEAR),
                  new Keyframe(21.95F, KeyframeAnimations.degreeVec(-8.08F, 3.07F, 24.38F), Interpolations.LINEAR),
                  new Keyframe(22.1F, KeyframeAnimations.degreeVec(-8.2844F, -2.4618F, -12.7248F), Interpolations.LINEAR),
                  new Keyframe(22.2F, KeyframeAnimations.degreeVec(-11.5327F, 9.1788F, -39.2745F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger2",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(22.1F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(22.2F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.2F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip2",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 22.5F), Interpolations.LINEAR),
                  new Keyframe(10.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 22.5F), Interpolations.LINEAR),
                  new Keyframe(11.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 82.5F), Interpolations.LINEAR),
                  new Keyframe(11.15F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 83.5F), Interpolations.LINEAR),
                  new Keyframe(11.8F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 25.0F), Interpolations.LINEAR),
                  new Keyframe(18.15F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 25.0F), Interpolations.LINEAR),
                  new Keyframe(18.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), Interpolations.LINEAR),
                  new Keyframe(19.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 25.0F), Interpolations.LINEAR),
                  new Keyframe(19.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(19.6F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(19.8F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), Interpolations.LINEAR),
                  new Keyframe(20.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 62.5F), Interpolations.LINEAR),
                  new Keyframe(21.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 62.5F), Interpolations.LINEAR),
                  new Keyframe(22.1F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 22.5F), Interpolations.LINEAR),
                  new Keyframe(22.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFinger3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(6.7086F, 9.571F, 12.3299F), Interpolations.LINEAR),
                  new Keyframe(10.5F, KeyframeAnimations.degreeVec(6.71F, 9.57F, 12.33F), Interpolations.LINEAR),
                  new Keyframe(11.0F, KeyframeAnimations.degreeVec(10.1136F, 5.8534F, 37.2861F), Interpolations.LINEAR),
                  new Keyframe(11.1F, KeyframeAnimations.degreeVec(10.2129F, 5.6769F, 38.2754F), Interpolations.LINEAR),
                  new Keyframe(11.75F, KeyframeAnimations.degreeVec(7.1218F, 9.2689F, 14.8457F), Interpolations.LINEAR),
                  new Keyframe(18.0F, KeyframeAnimations.degreeVec(-14.22F, 8.58F, 13.41F), Interpolations.LINEAR),
                  new Keyframe(18.4F, KeyframeAnimations.degreeVec(-15.9583F, -4.4903F, -32.3881F), Interpolations.LINEAR),
                  new Keyframe(18.6F, KeyframeAnimations.degreeVec(-16.3667F, 2.5724F, -8.3878F), Interpolations.LINEAR),
                  new Keyframe(19.25F, KeyframeAnimations.degreeVec(-13.1122F, -10.208F, -54.3416F), Interpolations.LINEAR),
                  new Keyframe(19.5F, KeyframeAnimations.degreeVec(-14.22F, 8.58F, 13.41F), Interpolations.LINEAR),
                  new Keyframe(19.8F, KeyframeAnimations.degreeVec(2.2683F, 8.3133F, 23.5164F), Interpolations.LINEAR),
                  new Keyframe(20.5F, KeyframeAnimations.degreeVec(2.9884F, 8.0839F, 28.5627F), Interpolations.LINEAR),
                  new Keyframe(21.95F, KeyframeAnimations.degreeVec(2.99F, 8.08F, 28.56F), Interpolations.LINEAR),
                  new Keyframe(22.1F, KeyframeAnimations.degreeVec(-4.3077F, 7.4643F, -21.9324F), Interpolations.LINEAR),
                  new Keyframe(22.2F, KeyframeAnimations.degreeVec(-6.6009F, 5.5435F, -41.9712F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "leftFingerTip3",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(10.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 15.0F), Interpolations.LINEAR),
                  new Keyframe(10.8F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 87.5F), Interpolations.LINEAR),
                  new Keyframe(10.9F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 88.5F), Interpolations.LINEAR),
                  new Keyframe(11.55F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 17.5F), Interpolations.LINEAR),
                  new Keyframe(18.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 17.5F), Interpolations.LINEAR),
                  new Keyframe(18.55F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(19.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 37.5F), Interpolations.LINEAR),
                  new Keyframe(19.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.0F), Interpolations.LINEAR),
                  new Keyframe(19.6F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 22.5F), Interpolations.LINEAR),
                  new Keyframe(19.8F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), Interpolations.LINEAR),
                  new Keyframe(21.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), Interpolations.LINEAR),
                  new Keyframe(22.1F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 15.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-82.57F, -67.46F, 90.14F), Interpolations.LINEAR),
                  new Keyframe(9.0F, KeyframeAnimations.degreeVec(-82.57F, -67.46F, 90.14F), Interpolations.LINEAR),
                  new Keyframe(9.5F, KeyframeAnimations.degreeVec(-124.5857F, -34.4472F, 152.4688F), Interpolations.LINEAR),
                  new Keyframe(22.0F, KeyframeAnimations.degreeVec(-124.59F, -34.45F, 152.47F), Interpolations.LINEAR),
                  new Keyframe(22.2F, KeyframeAnimations.degreeVec(-118.7211F, -13.0493F, 138.2125F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumb",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(9.5F, KeyframeAnimations.posVec(1.3F, 0.9F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "thumbTip",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -52.5F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "lantern",
            new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "chainStart",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.4609F, 0.9101F, -10.9167F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "chain1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-55.1558F, -34.8926F, 38.197F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-61.4608F, -43.8361F, 32.3918F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-62.1287F, -42.614F, 29.7381F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(-60.9902F, -44.8125F, 28.091F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-67.1287F, -42.614F, 29.7381F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.degreeVec(9.2221F, 15.6764F, 65.1144F), Interpolations.LINEAR),
                  new Keyframe(1.4F, KeyframeAnimations.degreeVec(14.2221F, 15.6764F, 65.1144F), Interpolations.LINEAR),
                  new Keyframe(2.1F, KeyframeAnimations.degreeVec(13.5271F, 16.276F, 62.5899F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-7.4494F, 12.4623F, 2.889F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(-7.45F, 12.46F, 2.89F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(15.05F, 12.46F, 2.89F), Interpolations.LINEAR),
                  new Keyframe(18.75F, KeyframeAnimations.degreeVec(15.05F, 12.46F, 2.89F), Interpolations.LINEAR),
                  new Keyframe(19.1F, KeyframeAnimations.degreeVec(-48.0799F, 8.7569F, -0.5287F), Interpolations.LINEAR),
                  new Keyframe(19.35F, KeyframeAnimations.degreeVec(-60.5099F, 8.4801F, -0.1885F), Interpolations.LINEAR),
                  new Keyframe(19.65F, KeyframeAnimations.degreeVec(-40.6806F, 9.2238F, -0.9913F), Interpolations.LINEAR),
                  new Keyframe(19.9F, KeyframeAnimations.degreeVec(-35.6806F, 9.2238F, -0.9913F), Interpolations.LINEAR),
                  new Keyframe(20.5F, KeyframeAnimations.degreeVec(-58.2214F, 3.9885F, -2.484F), Interpolations.LINEAR),
                  new Keyframe(20.85F, KeyframeAnimations.degreeVec(-65.7214F, 3.9885F, -2.484F), Interpolations.LINEAR),
                  new Keyframe(21.2F, KeyframeAnimations.degreeVec(-60.7214F, 3.9885F, -2.484F), Interpolations.LINEAR),
                  new Keyframe(21.5F, KeyframeAnimations.degreeVec(-60.7214F, 3.9885F, -2.484F), Interpolations.LINEAR),
                  new Keyframe(21.75F, KeyframeAnimations.degreeVec(26.7786F, 3.9885F, -2.484F), Interpolations.LINEAR),
                  new Keyframe(21.9F, KeyframeAnimations.degreeVec(29.2786F, 3.9885F, -2.484F), Interpolations.LINEAR),
                  new Keyframe(22.0F, KeyframeAnimations.degreeVec(-10.7214F, 3.9885F, -2.484F), Interpolations.LINEAR),
                  new Keyframe(22.3F, KeyframeAnimations.degreeVec(11.7786F, 3.9885F, -2.484F), Interpolations.LINEAR),
                  new Keyframe(22.4F, KeyframeAnimations.degreeVec(14.2786F, 3.9885F, -2.484F), Interpolations.LINEAR),
                  new Keyframe(22.65F, KeyframeAnimations.degreeVec(-15.7214F, 3.9885F, -2.484F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArm",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(0.1F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), Interpolations.LINEAR),
                  new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.ROTATION,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.1F, KeyframeAnimations.degreeVec(-57.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.3F, KeyframeAnimations.degreeVec(-62.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(0.6F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.0F, KeyframeAnimations.degreeVec(-67.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.3F, KeyframeAnimations.degreeVec(-37.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(1.45F, KeyframeAnimations.degreeVec(-35.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(2.6F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(15.6F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(17.5F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.8F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(18.95F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(19.15F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(19.3F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(19.4F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(19.6F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(20.5F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(20.7F, KeyframeAnimations.degreeVec(-12.86F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(20.95F, KeyframeAnimations.degreeVec(-14.86F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(21.3F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(21.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(21.75F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(21.9F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(22.05F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(22.35F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(22.65F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmLower",
            new AnimationChannel(
               Targets.POSITION,
               new Keyframe[]{
                  new Keyframe(15.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(22.35F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
                  new Keyframe(22.65F, KeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "brokenArmGore2",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "brokenArmGore2",
            new AnimationChannel(
               Targets.SCALE,
               new Keyframe[]{
                  new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
                  new Keyframe(0.05F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)
               }
            )
         )
         .addAnimation(
            "claw",
            new AnimationChannel(
               Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.5F, 15.0F, -14.5F), Interpolations.LINEAR)}
            )
         )
         .addAnimation(
            "claw", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .addAnimation(
            "finger1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 12.5F, 15.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife1",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "finger2",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "finger2tip",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife2",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "finger3",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "finger3tip",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "knife3",
            new AnimationChannel(Targets.ROTATION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "flame",
            new AnimationChannel(Targets.POSITION, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.posVec(6.0F, 17.0F, -7.0F), Interpolations.LINEAR)})
         )
         .addAnimation(
            "flame", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.0F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)})
         )
         .build();
   }
}
