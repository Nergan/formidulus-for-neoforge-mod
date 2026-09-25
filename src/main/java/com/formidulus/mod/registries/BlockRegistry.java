package com.formidulus.mod.registries;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.block.BigLanternBlock;
import com.formidulus.mod.block.BossSpawnerBlock;
import com.formidulus.mod.block.DeerSkullBlock;
import com.formidulus.mod.block.WeenBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class BlockRegistry {
   public static final Block WEEN = (Block)Registry.register(
      BuiltInRegistries.BLOCK, Formidulus.identifier("ween"), new WeenBlock(Properties.ofFullCopy(Blocks.CARVED_PUMPKIN))
   );
   public static final Block DEER_SKULL = (Block)Registry.register(
      BuiltInRegistries.BLOCK, Formidulus.identifier("deer_skull"), new DeerSkullBlock(Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion())
   );
   public static final Block BOSS_SPAWNER = (Block)Registry.register(
      BuiltInRegistries.BLOCK, Formidulus.identifier("boss_spawner"), new BossSpawnerBlock(Properties.ofFullCopy(Blocks.COMMAND_BLOCK).noOcclusion())
   );
   public static final Block GREAT_LANTERN = (Block)Registry.register(
      BuiltInRegistries.BLOCK,
      Formidulus.identifier("great_lantern"),
      new BigLanternBlock(
         Properties.ofFullCopy(Blocks.LANTERN)
            .noOcclusion()
            .lightLevel(BigLanternBlock::getLuminance)
            .sound(SoundType.LANTERN)
            .strength(6.0F, 10.0F)
            .requiresCorrectToolForDrops()
      )
   );

   public static void register() {
   }
}
