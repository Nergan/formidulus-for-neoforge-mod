package com.formidulus.mod.damage;

import com.formidulus.mod.Formidulus;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public class DamageSources {
   public static final ResourceKey<DamageType> LANTERN = ResourceKey.create(Registries.DAMAGE_TYPE, Formidulus.identifier("lantern"));
   public static final ResourceKey<DamageType> CLAW = ResourceKey.create(Registries.DAMAGE_TYPE, Formidulus.identifier("claw"));
   public static final ResourceKey<DamageType> SACRIFICE = ResourceKey.create(Registries.DAMAGE_TYPE, Formidulus.identifier("sacrifice"));
   public static final ResourceKey<DamageType> SOUL = ResourceKey.create(Registries.DAMAGE_TYPE, Formidulus.identifier("soul"));
   public static final ResourceKey<DamageType> TRAMPLE = ResourceKey.create(Registries.DAMAGE_TYPE, Formidulus.identifier("trample"));
   public static final ResourceKey<DamageType> SCORCH = ResourceKey.create(Registries.DAMAGE_TYPE, Formidulus.identifier("scorch"));

   public static DamageSource get(Level world, ResourceKey<DamageType> type) {
      return new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(type));
   }

   public static DamageSource get(Level world, ResourceKey<DamageType> type, Entity attacker) {
      return new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(type), attacker);
   }

   public static DamageSource get(Level world, ResourceKey<DamageType> type, Entity source, Entity attacker) {
      return new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(type), source, attacker);
   }
}
