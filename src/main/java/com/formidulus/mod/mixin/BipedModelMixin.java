package com.formidulus.mod.mixin;

import com.formidulus.mod.registries.ItemRegistry;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({HumanoidModel.class})
public class BipedModelMixin {
   @Shadow
   @Final
   public ModelPart leftArm;
   @Shadow
   @Final
   public ModelPart rightArm;

   @Inject(
      method = {"setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V"},
      at = {@At("TAIL")}
   )
   void afterSetAngle(LivingEntity livingEntity, float f, float g, float h, float i, float j, CallbackInfo ci) {
      this.setArmAngle(livingEntity, InteractionHand.MAIN_HAND);
      this.setArmAngle(livingEntity, InteractionHand.OFF_HAND);
   }

   @Unique
   void setArmAngle(LivingEntity living, InteractionHand hand) {
      HumanoidArm arm = living.getMainArm();
      if (hand.equals(InteractionHand.OFF_HAND)) {
         arm = arm.getOpposite();
      }

      ModelPart armPart = arm.equals(HumanoidArm.LEFT) ? this.leftArm : this.rightArm;
      if (living.getItemInHand(hand).is(ItemRegistry.GREAT_LANTERN)) {
         armPart.xRot = armPart.xRot + (float)Math.toRadians(-20.0);
      }
   }
}
