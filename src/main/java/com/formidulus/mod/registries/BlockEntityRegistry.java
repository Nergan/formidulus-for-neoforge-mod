package com.formidulus.mod.registries;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.block.BigLanternBlockEntity;
import com.formidulus.mod.block.BossSpawnerBlockEntity;
import com.formidulus.mod.block.DeerSkullBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;

public class BlockEntityRegistry {
   public static final BlockEntityType<DeerSkullBlockEntity> DEER_SKULL = (BlockEntityType<DeerSkullBlockEntity>)Registry.register(
      BuiltInRegistries.BLOCK_ENTITY_TYPE,
      Formidulus.identifier("deer_skull"),
      Builder.of(DeerSkullBlockEntity::new, new Block[]{BlockRegistry.DEER_SKULL}).build(null)
   );
   public static final BlockEntityType<BossSpawnerBlockEntity> BOSS_SPAWNER = (BlockEntityType<BossSpawnerBlockEntity>)Registry.register(
      BuiltInRegistries.BLOCK_ENTITY_TYPE,
      Formidulus.identifier("boss_spawner"),
      Builder.of(BossSpawnerBlockEntity::new, new Block[]{BlockRegistry.BOSS_SPAWNER}).build(null)
   );
   public static final BlockEntityType<BigLanternBlockEntity> BIG_LANTERN = (BlockEntityType<BigLanternBlockEntity>)Registry.register(
      BuiltInRegistries.BLOCK_ENTITY_TYPE,
      Formidulus.identifier("big_lantern"),
      Builder.of(BigLanternBlockEntity::new, new Block[]{BlockRegistry.GREAT_LANTERN}).build(null)
   );

   public static void register() {
   }
}
