package com.formidulus.mod.registries;

import com.formidulus.mod.Formidulus;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;

public class TagRegistry {
   public static final TagKey<MobEffect> DEER_EFFECTS = TagKey.create(Registries.MOB_EFFECT, Formidulus.identifier("deer"));
   public static final TagKey<Structure> CULT_HIDEOUT = TagKey.create(Registries.STRUCTURE, Formidulus.identifier("cult_hideout"));
   public static final TagKey<DamageType> BOSS_DAMAGE = TagKey.create(Registries.DAMAGE_TYPE, Formidulus.identifier("boss_damage"));
   public static final TagKey<DamageType> SOUL_DAMAGE = TagKey.create(Registries.DAMAGE_TYPE, Formidulus.identifier("soul_damage"));
   public static final TagKey<DamageType> SHIELD_DISABLING_DAMAGE = TagKey.create(Registries.DAMAGE_TYPE, Formidulus.identifier("shield_disabling"));
   public static final TagKey<DamageType> BULWARK_UNBLOCKABLE_DAMAGE = TagKey.create(Registries.DAMAGE_TYPE, Formidulus.identifier("bulwark_unblockable"));
   public static final TagKey<Block> PUMPKIN = TagKey.create(Registries.BLOCK, Formidulus.identifier("pumpkin"));
   public static final TagKey<EntityType<?>> JOLLY_MOBS = TagKey.create(Registries.ENTITY_TYPE, Formidulus.identifier("jolly"));
   public static final TagKey<EntityType<?>> SOULLESS_MOBS = TagKey.create(Registries.ENTITY_TYPE, Formidulus.identifier("soulless"));
}
