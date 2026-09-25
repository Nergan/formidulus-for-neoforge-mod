package com.formidulus.mod.mixin;

import com.formidulus.mod.accessor.LivingEntityAccessor;
import com.formidulus.mod.compat.TrinketsUtil;
import com.formidulus.mod.damage.DamageSources;
import com.formidulus.mod.entities.BossEntity;
import com.formidulus.mod.item.JollyHatItem;
import com.formidulus.mod.item.components.AbilityComponent;
import com.formidulus.mod.registries.DataComponentRegistry;
import com.formidulus.mod.registries.ItemRegistry;
import com.formidulus.mod.registries.StatusEffectRegistry;
import com.formidulus.mod.registries.TagRegistry;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({LivingEntity.class})
public abstract class LivingEntityMixin extends LivingEntity implements LivingEntityAccessor {
   @Unique
   int bossImmunity;
   @Unique
   int soulImmunity;
   @Unique
   int shieldBreakImmunity;

   public LivingEntityMixin(EntityType<? extends LivingEntity> type, Level world) {
      super(type, world);
   }

   @Shadow
   public abstract boolean hasEffect(Holder<MobEffect> var1);

   @Shadow
   public abstract boolean isInvulnerableTo(DamageSource var1);

   @Shadow
   public abstract ItemStack getItemBySlot(EquipmentSlot var1);

   @ModifyReturnValue(
      method = {"isInvulnerableTo(Lnet/minecraft/world/damagesource/DamageSource;)Z"},
      at = {@At("RETURN")}
   )
   private boolean modifyIsInvulnerable(boolean original) {
      return original || this.hasEffect(StatusEffectRegistry.REVERENCE);
   }

   @Inject(
      method = {"actuallyHurt(Lnet/minecraft/world/damagesource/DamageSource;F)V"},
      at = {@At("TAIL")}
   )
   void onDamage(DamageSource source, float amount, CallbackInfo ci) {
      if (!this.isInvulnerableTo(source) && !(amount <= 0.0F)) {
         if (source.getEntity() instanceof LivingEntity attacker
            && attacker.getWeaponItem().get(DataComponentRegistry.ABILITY) instanceof AbilityComponent component) {
            component.ability().onDamageEntity(attacker.getWeaponItem(), attacker, source, amount, (LivingEntity)this);
         }
      }
   }

   @Inject(
      method = {"baseTick()V"},
      at = {@At("HEAD")}
   )
   void onBaseTick(CallbackInfo ci) {
      if (this.bossImmunity > 0) {
         this.bossImmunity--;
      }

      if (this.soulImmunity > 0) {
         this.soulImmunity--;
      }

      if (this.shieldBreakImmunity > 0) {
         this.shieldBreakImmunity--;
      }
   }

   @Inject(
      method = {"hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"},
      at = {@At("HEAD")},
      cancellable = true
   )
   void preDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
      if (source.is(DamageSources.SOUL) && this.getType().is(TagRegistry.SOULLESS_MOBS)) {
         cir.setReturnValue(false);
      } else {
         if (this.shieldBreakImmunity > 0) {
            cir.setReturnValue(false);
         }
      }
   }

   @ModifyExpressionValue(
      method = {"hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/world/damagesource/DamageSource;is(Lnet/minecraft/tags/TagKey;)Z",
         ordinal = 4
      )}
   )
   boolean modifyIgnoresCooldown(boolean original, @Local(argsOnly = true) DamageSource source) {
      return original
         || (source.getEntity() instanceof BossEntity || source.getDirectEntity() instanceof BossEntity)
            && source.is(TagRegistry.BOSS_DAMAGE)
            && this.bossImmunity <= 0
         || source.is(TagRegistry.SOUL_DAMAGE) && this.soulImmunity <= 0;
   }

   @Inject(
      method = {"hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"},
      at = {@At("TAIL")}
   )
   void modifyTimeUntilRegen(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
      if (source.is(TagRegistry.SOUL_DAMAGE) && this.level() instanceof ServerLevel serverWorld) {
         serverWorld.sendParticles(
            ParticleTypes.SOUL_FIRE_FLAME,
            this.getX(),
            this.getBoundingBox().getCenter().y,
            this.getZ(),
            (int)(amount * 2.0F),
            (double)(this.getBbWidth() / 2.0F),
            (double)(this.getBbHeight() / 2.0F),
            (double)(this.getBbWidth() / 2.0F),
            0.025F
         );
      }
   }

   @ModifyConstant(
      method = {"hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"},
      constant = {@Constant(
         intValue = 20
      )}
   )
   int modifyTimeUntilRegen(int constant, @Local(argsOnly = true) DamageSource source) {
      if (source.is(TagRegistry.BOSS_DAMAGE)) {
         this.bossImmunity = 10;
      }

      if (source.is(TagRegistry.SOUL_DAMAGE)) {
         this.soulImmunity = 15;
      }

      return constant;
   }

   @Inject(
      method = {"hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/world/entity/LivingEntity;hurtCurrentlyUsedShield(F)V"
      )}
   )
   void onDamageShield(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
      if (source.is(TagRegistry.SHIELD_DISABLING_DAMAGE) && (Object)this instanceof Player player) {
         player.disableShield();
         this.shieldBreakImmunity = 5;
      }
   }

   @ModifyConstant(
      method = {"handleDamageEvent(Lnet/minecraft/world/damagesource/DamageSource;)V"},
      constant = {@Constant(
         intValue = 20
      )}
   )
   int modifyTimeUntilRegenOnDamaged(int constant, @Local(argsOnly = true) DamageSource source) {
      if (source.is(TagRegistry.BOSS_DAMAGE)) {
         this.bossImmunity = 10;
      }

      if (source.is(TagRegistry.SOUL_DAMAGE)) {
         this.soulImmunity = 15;
      }

      return constant;
   }

   @Inject(
      method = {"aiStep()V"},
      at = {@At("TAIL")}
   )
   void onTickMovement(CallbackInfo ci) {
      LivingEntity self = (LivingEntity)this;
      if (this.level().isClientSide) {
         ItemStack head = this.getItemBySlot(EquipmentSlot.HEAD);
         if (!TrinketsUtil.performIfPresent(self, ItemRegistry.JOLLY_HAT, i -> JollyHatItem.tickSnowfall(self, i)) && head.is(ItemRegistry.JOLLY_HAT)) {
            JollyHatItem.tickSnowfall(self, head);
         }
      }
   }

   @Override
   public void setBossImmunity(int bossImmunity) {
      this.bossImmunity = bossImmunity;
   }

   @Override
   public int getBossImmunity() {
      return this.bossImmunity;
   }

   @Override
   public void setSoulImmunity(int soulImmunity) {
      this.soulImmunity = soulImmunity;
   }

   @Override
   public int getSoulImmunity() {
      return this.soulImmunity;
   }

   @Override
   public void setShieldBreakImmunity(int shieldBreakImmunity) {
      this.shieldBreakImmunity = shieldBreakImmunity;
   }

   @Override
   public int getShieldBreakImmunity() {
      return this.shieldBreakImmunity;
   }
}
