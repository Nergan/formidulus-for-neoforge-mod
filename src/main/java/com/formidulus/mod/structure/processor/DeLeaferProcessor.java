package com.formidulus.mod.structure.processor;

import com.formidulus.mod.structure.FormidableStructureProcessors;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate.StructureBlockInfo;
import org.jetbrains.annotations.Nullable;

public class DeLeaferProcessor extends StructureProcessor {
   public static final MapCodec<DeLeaferProcessor> CODEC = RecordCodecBuilder.mapCodec(
      instance -> instance.group(Codec.BOOL.fieldOf("removePersistent").forGetter(i -> i.removePersistent)).apply(instance, DeLeaferProcessor::new)
   );
   public final boolean removePersistent;

   public DeLeaferProcessor(boolean removePersistent) {
      this.removePersistent = removePersistent;
   }

   @Nullable
   public StructureBlockInfo processBlock(
      LevelReader world, BlockPos pos, BlockPos pivot, StructureBlockInfo originalBlockInfo, StructureBlockInfo currentBlockInfo, StructurePlaceSettings data
   ) {
      return !(currentBlockInfo.state().getBlock() instanceof LeavesBlock)
            || currentBlockInfo.state().getValue(LeavesBlock.PERSISTENT) && !this.removePersistent
         ? super.processBlock(world, pos, pivot, originalBlockInfo, currentBlockInfo, data)
         : new StructureBlockInfo(currentBlockInfo.pos(), Blocks.GREEN_STAINED_GLASS.defaultBlockState(), currentBlockInfo.nbt());
   }

   protected StructureProcessorType<?> getType() {
      return FormidableStructureProcessors.DE_LEAFER;
   }
}
