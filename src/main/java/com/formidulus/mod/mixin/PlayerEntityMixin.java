package com.formidulus.mod.mixin;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.entities.boss.BossFightManager;
import com.formidulus.mod.item.components.AbilityComponent;
import com.formidulus.mod.item.components.DamageTypeComponent;
import com.formidulus.mod.registries.DataComponentRegistry;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({Player.class})
public abstract class PlayerEntityMixin extends Player {
   @Unique
   ItemStack lastHeldItem;
   @Unique
   boolean wasUsingItem;

   @Shadow
   @NotNull
   public abstract ItemStack getWeaponItem();

   protected PlayerEntityMixin(Level world, net.minecraft.core.BlockPos pos, float yRot, com.mojang.authlib.GameProfile profile) {
      super(world, pos, yRot, profile);
   }

   @WrapOperation(
      method = {"attack(Lnet/minecraft/world/entity/Entity;)V"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/world/damagesource/DamageSources;playerAttack(Lnet/minecraft/world/entity/player/Player;)Lnet/minecraft/world/damagesource/DamageSource;"
      )}
   )
   DamageSource onGetDamageSource(DamageSources instance, Player attacker, Operation<DamageSource> original) {
      if (this.getWeaponItem().get(DataComponentRegistry.DAMAGE_TYPE) instanceof DamageTypeComponent component) {
         if (this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).containsKey(component.damageType())) {
            return component.getSource(attacker);
         }

         Formidulus.LOGGER.warn("DamageTypeComponent -> Tried to use non-existent damage type '{}' (Item: {})", component.getTypeId(), this.getWeaponItem());
      }

      return (DamageSource)original.call(new Object[]{instance, attacker});
   }

   @Inject(
      method = {"die(Lnet/minecraft/world/damagesource/DamageSource;)V"},
      at = {@At("HEAD")}
   )
   void onDeath(DamageSource damageSource, CallbackInfo ci) {
      if ((Object)this instanceof ServerPlayer player) {
         BossFightManager.INSTANCE.onPlayerDeath(player);
      }
   }

   @Inject(
      method = {"tick()V"},
      at = {@At("HEAD")}
   )
   void preTick(CallbackInfo ci) {
      ItemStack stack = this.getMainHandItem();
      if (!stack.equals(this.lastHeldItem)) {
         if (this.wasUsingItem
            && this.getUsedItemHand().equals(InteractionHand.MAIN_HAND)
            && this.lastHeldItem != null
            && this.lastHeldItem.get(DataComponentRegistry.ABILITY) instanceof AbilityComponent ability) {
            ability.ability().onStopUsing(this.lastHeldItem, (Player)this, InteractionHand.MAIN_HAND);
         }

         this.lastHeldItem = stack;
      }

      this.wasUsingItem = this.isUsingItem();
   }
}
