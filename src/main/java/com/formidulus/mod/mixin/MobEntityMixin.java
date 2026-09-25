package com.formidulus.mod.mixin;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.item.components.AccessoryComponent;
import com.formidulus.mod.item.components.DamageTypeComponent;
import com.formidulus.mod.realtime.TimedEvent;
import com.formidulus.mod.registries.DataComponentRegistry;
import com.formidulus.mod.registries.ItemRegistry;
import com.formidulus.mod.registries.StatusEffectRegistry;
import com.formidulus.mod.registries.TagRegistry;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Mob.class})
public abstract class MobEntityMixin extends LivingEntity {
   @Shadow
   public abstract ItemStack getItemBySlot(EquipmentSlot var1);

   @Shadow
   public abstract void setItemSlot(EquipmentSlot var1, ItemStack var2);

   @Shadow
   public abstract void setDropChance(EquipmentSlot var1, float var2);

   protected MobEntityMixin(EntityType<? extends LivingEntity> entityType, Level world) {
      super(entityType, world);
   }

   @Inject(
      method = {"serverAiStep()V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   void onTickAI(CallbackInfo ci) {
      if (this.hasEffect(StatusEffectRegistry.REVERENCE)) {
         ci.cancel();
      }
   }

   @WrapOperation(
      method = {"doHurtTarget(Lnet/minecraft/world/entity/Entity;)Z"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/world/damagesource/DamageSources;mobAttack(Lnet/minecraft/world/entity/LivingEntity;)Lnet/minecraft/world/damagesource/DamageSource;"
      )}
   )
   DamageSource onGetDamageSource(DamageSources instance, LivingEntity attacker, Operation<DamageSource> original) {
      if (this.getWeaponItem().get(DataComponentRegistry.DAMAGE_TYPE) instanceof DamageTypeComponent component) {
         if (this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).containsKey(component.damageType())) {
            return component.getSource(attacker);
         }

         Formidulus.LOGGER.warn("DamageTypeComponent -> Tried to use non-existent damage type '{}' (Item: {})", component.getTypeId(), this.getWeaponItem());
      }

      return (DamageSource)original.call(new Object[]{instance, attacker});
   }

   @Inject(
      method = {"finalizeSpawn(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/world/entity/MobSpawnType;Lnet/minecraft/world/entity/SpawnGroupData;)Lnet/minecraft/world/entity/SpawnGroupData;"},
      at = {@At("TAIL")}
   )
   void onInitialize(
      ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType spawnReason, SpawnGroupData entityData, CallbackInfoReturnable<SpawnGroupData> cir
   ) {
      if (TimedEvent.SOLSTICE_FESTIVAL.isActive()
         && this.getType().is(TagRegistry.JOLLY_MOBS)
         && this.getItemBySlot(EquipmentSlot.HEAD).isEmpty()
         && this.random.nextFloat() < (Float)Formidulus.config.jollyChance.getValue()) {
         ItemStack stack = ItemRegistry.JOLLY_HAT.getDefaultInstance();
         if ((double)this.random.nextFloat() < 0.2 && stack.getComponents().get(DataComponentRegistry.ACCESSORY) instanceof AccessoryComponent accessory) {
            stack.set(DataComponentRegistry.ACCESSORY, accessory.cycle());
         }

         this.setItemSlot(EquipmentSlot.HEAD, stack);
         this.setDropChance(EquipmentSlot.HEAD, 0.75F);
      }
   }
}
