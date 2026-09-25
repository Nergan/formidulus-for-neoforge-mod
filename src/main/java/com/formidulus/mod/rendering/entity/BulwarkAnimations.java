package com.formidulus.mod.rendering.entity;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.animation.AnimationChannel.Interpolations;
import net.minecraft.client.animation.AnimationChannel.Targets;
import net.minecraft.client.animation.AnimationDefinition.Builder;

public class BulwarkAnimations {
   public static final AnimationDefinition prePlace = Builder.withLength(0.25F)
      .addAnimation(
         "root",
         new AnimationChannel(
            Targets.ROTATION,
            new Keyframe[]{
               new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), Interpolations.LINEAR),
               new Keyframe(0.1F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), Interpolations.LINEAR),
               new Keyframe(0.25F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR)
            }
         )
      )
      .addAnimation(
         "root",
         new AnimationChannel(
            Targets.POSITION,
            new Keyframe[]{
               new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 9.0F, 2.0F), Interpolations.LINEAR),
               new Keyframe(0.1F, KeyframeAnimations.posVec(0.0F, 10.0F, 2.0F), Interpolations.LINEAR),
               new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 11.0F, 2.0F), Interpolations.LINEAR)
            }
         )
      )
      .addAnimation(
         "root", new AnimationChannel(Targets.SCALE, new Keyframe[]{new Keyframe(0.25F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)})
      )
      .build();
   public static final AnimationDefinition place = Builder.withLength(0.1F)
      .addAnimation(
         "root",
         new AnimationChannel(
            Targets.ROTATION,
            new Keyframe[]{
               new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.5F, 0.0F, 0.0F), Interpolations.LINEAR),
               new Keyframe(0.1F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR)
            }
         )
      )
      .addAnimation(
         "root",
         new AnimationChannel(
            Targets.POSITION,
            new Keyframe[]{
               new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 11.0F, 2.0F), Interpolations.LINEAR),
               new Keyframe(0.05F, KeyframeAnimations.posVec(0.0F, 7.45F, 1.0F), Interpolations.LINEAR),
               new Keyframe(0.1F, KeyframeAnimations.posVec(0.0F, -0.1F, 0.0F), Interpolations.LINEAR)
            }
         )
      )
      .addAnimation(
         "root",
         new AnimationChannel(
            Targets.SCALE,
            new Keyframe[]{
               new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
               new Keyframe(0.05F, KeyframeAnimations.scaleVec(1.0, 1.2F, 1.0), Interpolations.LINEAR),
               new Keyframe(0.1F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR)
            }
         )
      )
      .build();
   public static final AnimationDefinition hit = Builder.withLength(0.3F)
      .addAnimation(
         "root",
         new AnimationChannel(
            Targets.ROTATION,
            new Keyframe[]{
               new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
               new Keyframe(0.05F, KeyframeAnimations.degreeVec(-7.0F, 0.0F, 0.0F), Interpolations.LINEAR),
               new Keyframe(0.15F, KeyframeAnimations.degreeVec(-8.0F, 0.0F, 0.0F), Interpolations.LINEAR),
               new Keyframe(0.3F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR)
            }
         )
      )
      .addAnimation(
         "root",
         new AnimationChannel(
            Targets.POSITION,
            new Keyframe[]{
               new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.1F, 0.0F), Interpolations.LINEAR),
               new Keyframe(0.05F, KeyframeAnimations.posVec(0.0F, -0.1F, 1.3F), Interpolations.LINEAR),
               new Keyframe(0.15F, KeyframeAnimations.posVec(0.0F, -0.2F, 1.5F), Interpolations.LINEAR),
               new Keyframe(0.3F, KeyframeAnimations.posVec(0.0F, -0.1F, 0.0F), Interpolations.LINEAR)
            }
         )
      )
      .build();
   public static final AnimationDefinition unplace = Builder.withLength(0.75F)
      .addAnimation(
         "root",
         new AnimationChannel(
            Targets.ROTATION,
            new Keyframe[]{
               new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
               new Keyframe(0.2F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), Interpolations.LINEAR),
               new Keyframe(0.25F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), Interpolations.LINEAR),
               new Keyframe(0.4F, KeyframeAnimations.degreeVec(-13.33F, 0.0F, 0.0F), Interpolations.LINEAR),
               new Keyframe(0.55F, KeyframeAnimations.degreeVec(-10.83F, 0.0F, 0.0F), Interpolations.LINEAR),
               new Keyframe(0.75F, KeyframeAnimations.degreeVec(-3.33F, 0.0F, 0.0F), Interpolations.LINEAR)
            }
         )
      )
      .addAnimation(
         "root",
         new AnimationChannel(
            Targets.POSITION,
            new Keyframe[]{
               new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.1F, 0.0F), Interpolations.LINEAR),
               new Keyframe(0.2F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.6F), Interpolations.LINEAR),
               new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, -0.1F, 0.0F), Interpolations.LINEAR),
               new Keyframe(0.3F, KeyframeAnimations.posVec(0.0F, 3.91F, 0.22F), Interpolations.LINEAR),
               new Keyframe(0.4F, KeyframeAnimations.posVec(0.0F, 6.0F, 2.0F), Interpolations.LINEAR),
               new Keyframe(0.55F, KeyframeAnimations.posVec(0.0F, 5.0F, 2.0F), Interpolations.LINEAR),
               new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -8.0F, 6.0F), Interpolations.LINEAR)
            }
         )
      )
      .addAnimation(
         "root",
         new AnimationChannel(
            Targets.SCALE,
            new Keyframe[]{
               new Keyframe(0.6F, KeyframeAnimations.scaleVec(1.0, 1.0, 1.0), Interpolations.LINEAR),
               new Keyframe(0.7F, KeyframeAnimations.scaleVec(0.2F, 0.5, 1.0), Interpolations.LINEAR),
               new Keyframe(0.75F, KeyframeAnimations.scaleVec(0.0, 0.0, 0.0), Interpolations.LINEAR)
            }
         )
      )
      .build();
}
