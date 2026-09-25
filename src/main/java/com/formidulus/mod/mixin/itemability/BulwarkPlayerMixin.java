package com.formidulus.mod.mixin.itemability;

import com.formidulus.mod.components.FormidableComponents;
import com.formidulus.mod.components.entity.IBulwarkComponent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Player.class})
public abstract class BulwarkPlayerMixin extends LivingEntity {
   protected BulwarkPlayerMixin(EntityType<? extends LivingEntity> type, Level world) {
      super(type, world);
   }

   public void knockback(double strength, double x, double z) {
      IBulwarkComponent comp = FormidableComponents.bulwark((Player)(Object)this);
      if (!comp.hasBulwark()) {
         super.knockback(strength, x, z);
      }
   }

   protected double getDefaultGravity() {
      IBulwarkComponent comp = FormidableComponents.bulwark((Player)(Object)this);
      return comp.hasBulwark() ? super.getDefaultGravity() * 2.0 : super.getDefaultGravity();
   }

   public boolean isShiftKeyDown() {
      IBulwarkComponent comp = FormidableComponents.bulwark((Player)(Object)this);
      return super.isShiftKeyDown() || comp.hasBulwark();
   }

   @Inject(
      method = {"jumpFromGround()V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   void onJump(CallbackInfo ci) {
      IBulwarkComponent comp = FormidableComponents.bulwark((Player)(Object)this);
      if (comp.hasBulwark()) {
         ci.cancel();
      }
   }

   @ModifyVariable(
      method = {"travel(Lnet/minecraft/world/phys/Vec3;)V"},
      at = @At("HEAD"),
      argsOnly = true
   )
   Vec3 modifyInputs(Vec3 input) {
      IBulwarkComponent comp = FormidableComponents.bulwark((Player)(Object)this);
      return comp.hasBulwark() ? input.multiply(0.0, 1.0, 0.0) : input;
   }

   public Vec3 getDeltaMovement() {
      IBulwarkComponent comp = FormidableComponents.bulwark((Player)(Object)this);
      return comp.hasBulwark() ? super.getDeltaMovement().multiply(0.3F, 1.0, 0.3F) : super.getDeltaMovement();
   }

   public void turn(double cursorDeltaX, double cursorDeltaY) {
      super.turn(cursorDeltaX, cursorDeltaY);
      IBulwarkComponent comp = FormidableComponents.bulwark((Player)(Object)this);
      if (comp.hasBulwark()) {
         float yaw = comp.getBulwarkYaw();
         this.setYBodyRot(yaw);
         float f = Mth.wrapDegrees(this.getYRot() - yaw);
         float g = Mth.clamp(f, -40.0F, 40.0F);
         this.yRotO += g - f;
         this.setYRot(this.getYRot() + g - f);
         this.setYHeadRot(this.getYRot());
      }
   }

   @Inject(
      method = {"hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"},
      at = {@At("HEAD")},
      cancellable = true
   )
   void onDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
      IBulwarkComponent comp = FormidableComponents.bulwark((Player)(Object)this);
      if (comp.hasBulwark() && comp.getBulwarkEntity() != null) {
         if (comp.getBulwarkEntity().tryBlockDamage(source, amount)) {
            cir.setReturnValue(false);
         }
      }
   }

   public boolean isBlocking() {
      IBulwarkComponent comp = FormidableComponents.bulwark((Player)(Object)this);
      return comp.hasBulwark() ? false : super.isBlocking();
   }
}
