package com.formidulus.mod.entities.boss;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.entities.BossEntity;
import com.formidulus.mod.registries.EntityRegistry;
import com.google.common.collect.ImmutableMap.Builder;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.Nullable;

public record BossType(
   ResourceLocation id, List<EntityType<? extends BossEntity>> bossEntities, Class<? extends BossFight> fight, String spawnerModel, boolean requiresSolidFloor
) {
   static final Map<ResourceLocation, BossType> types;
   public static final BossType DEER = new BossType(Formidulus.identifier("deer"), List.of(EntityRegistry.DEER_GOD), DeerBossFight.class, "boss_spawner_cruor");

   public BossType(ResourceLocation id, List<EntityType<? extends BossEntity>> bossEntities, Class<? extends BossFight> fight, String spawnerModel) {
      this(id, bossEntities, fight, spawnerModel, true);
   }

   @Nullable
   public static BossType fromId(ResourceLocation id) {
      return types.get(id);
   }

   @Nullable
   public BossFight beginFight(BossEntity e, @Nullable UUID id) {
      if (e.level().isClientSide) {
         return null;
      } else {
         try {
            return BossFightManager.INSTANCE.beginFight(this.fight().getConstructor(BossEntity.class, UUID.class).newInstance(e, id));
         } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException var4) {
            Formidulus.LOGGER.error("Failed to start Boss Fight of type '{}': {}", this.id, var4);
            return null;
         }
      }
   }

   public static Map<ResourceLocation, BossType> getAllTypes() {
      return Map.copyOf(types);
   }

   public static void init() {
      DeerBossFight.init();
   }

   static {
      Builder<ResourceLocation, BossType> builder = new Builder();
      builder.put(DEER.id(), DEER);
      types = builder.build();
   }
}
