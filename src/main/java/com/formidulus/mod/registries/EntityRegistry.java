package com.formidulus.mod.registries;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.entities.BulwarkEntity;
import com.formidulus.mod.entities.DeerFollowerEntity;
import com.formidulus.mod.entities.DeerGodEntity;
import com.formidulus.mod.entities.IrrlichtEntity;
import com.formidulus.mod.entities.PumpkinProjectile;
import net.minecraft.core.Registry;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EntityRegistry {
   public static final EntityType<DeerGodEntity> DEER_GOD = (EntityType<DeerGodEntity>)Registry.register(
      BuiltInRegistries.ENTITY_TYPE,
      Formidulus.identifier("deer_god"),
      Builder.of(DeerGodEntity::new, MobCategory.MONSTER).sized(1.0F, 3.65F).build("deer_god")
   );
   public static final EntityType<IrrlichtEntity> IRRLICHT = (EntityType<IrrlichtEntity>)Registry.register(
      BuiltInRegistries.ENTITY_TYPE, Formidulus.identifier("irrlicht"), Builder.of(IrrlichtEntity::new, MobCategory.MISC).sized(0.2F, 0.4F).build("irrlicht")
   );
   public static final EntityType<PumpkinProjectile> PUMPKIN = (EntityType<PumpkinProjectile>)Registry.register(
      BuiltInRegistries.ENTITY_TYPE, Formidulus.identifier("pumpkin"), Builder.of(PumpkinProjectile::new, MobCategory.MISC).sized(0.4F, 0.4F).build("pumpkin")
   );
   public static final EntityType<DeerFollowerEntity> DEER_FOLLOWER = (EntityType<DeerFollowerEntity>)Registry.register(
      BuiltInRegistries.ENTITY_TYPE,
      Formidulus.identifier("deer_follower"),
      Builder.of(DeerFollowerEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).build("deer_follower")
   );
   public static final EntityType<BulwarkEntity> BULWARK = (EntityType<BulwarkEntity>)Registry.register(
      BuiltInRegistries.ENTITY_TYPE, Formidulus.identifier("bulwark"), Builder.of(BulwarkEntity::new, MobCategory.MISC).sized(0.8F, 2.0F).build("bulwark")
   );

   public static void registerTypes() {
   }

   public static void register(EntityAttributeCreationEvent event) {
      event.put(
         DEER_GOD,
         DeerGodEntity.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 300.0)
            .add(Attributes.KNOCKBACK_RESISTANCE, 1.0)
            .add(Attributes.ARMOR, 10.0)
            .add(Attributes.ARMOR_TOUGHNESS, 5.0)
            .add(Attributes.FOLLOW_RANGE, 32.0)
            .add(Attributes.WATER_MOVEMENT_EFFICIENCY, 0.666F)
            .build()
      );
      event.put(IRRLICHT, IrrlichtEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0).build());
      event.put(
         DEER_FOLLOWER,
         DeerFollowerEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 25.0).add(Attributes.ATTACK_DAMAGE, 2.0).add(Attributes.ARMOR, 3.0).build()
      );
      event.put(BULWARK, IrrlichtEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 40.0).build());
   }
}
