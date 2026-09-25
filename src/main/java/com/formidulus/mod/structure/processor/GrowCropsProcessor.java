package com.formidulus.mod.structure.processor;

import com.formidulus.mod.structure.FormidableStructureProcessors;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate.StructureBlockInfo;
import org.jetbrains.annotations.Nullable;

public class GrowCropsProcessor extends StructureProcessor {
   public static final MapCodec<GrowCropsProcessor> CODEC = RecordCodecBuilder.mapCodec(
      instance -> instance.group(
               Codec.FLOAT.fieldOf("chance").orElse(1.0F).forGetter(i -> i.chance),
               BlockState.CODEC.fieldOf("crop").orElse(Blocks.WHEAT.defaultBlockState()).forGetter(i -> i.crop),
               Codec.BOOL.fieldOf("randomlyAge").orElse(false).forGetter(i -> i.randomlyAge)
            )
            .apply(instance, GrowCropsProcessor::new)
   );
   static final RandomSource random = RandomSource.create();
   final float chance;
   final BlockState crop;
   final boolean randomlyAge;

   public GrowCropsProcessor(float chance, BlockState crop, boolean randomlyAge) {
      this.chance = chance;
      this.crop = crop;
      this.randomlyAge = randomlyAge;
   }

   @Nullable
   public StructureBlockInfo processBlock(
      LevelReader world, BlockPos pos, BlockPos pivot, StructureBlockInfo originalBlockInfo, StructureBlockInfo cur, StructurePlaceSettings data
   ) {
      if (cur.state().is(BlockTags.CROPS)) {
         BlockState state = this.crop;
         if (this.randomlyAge) {
            state = (BlockState)state.setValue(CropBlock.AGE, random.nextInt(7));
         }

         return new StructureBlockInfo(cur.pos(), state, cur.nbt());
      } else {
         return cur;
      }
   }

   protected StructureProcessorType<?> getType() {
      return FormidableStructureProcessors.GROW_CROPS;
   }
}
