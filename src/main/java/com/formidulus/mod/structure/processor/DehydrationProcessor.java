package com.formidulus.mod.structure.processor;

import com.formidulus.mod.structure.FormidableStructureProcessors;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate.StructureBlockInfo;
import org.jetbrains.annotations.Nullable;

public class DehydrationProcessor extends StructureProcessor {
   public static final MapCodec<DehydrationProcessor> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.stable(new DehydrationProcessor()));

   @Nullable
   public StructureBlockInfo processBlock(
      LevelReader world, BlockPos pos, BlockPos pivot, StructureBlockInfo originalBlockInfo, StructureBlockInfo cur, StructurePlaceSettings data
   ) {
      BlockState state = cur.state();
      if (state.getBlock() instanceof SimpleWaterloggedBlock && !state.is(Blocks.MANGROVE_ROOTS)) {
         return new StructureBlockInfo(cur.pos(), (BlockState)state.setValue(BlockStateProperties.WATERLOGGED, false), cur.nbt());
      } else {
         return state.is(Blocks.WATER) ? new StructureBlockInfo(cur.pos(), Blocks.AIR.defaultBlockState(), cur.nbt()) : cur;
      }
   }

   protected StructureProcessorType<?> getType() {
      return FormidableStructureProcessors.DEHYDRATOR;
   }
}
