package com.formidulus.mod.structure.processor;

import com.formidulus.mod.realtime.TimedEvent;
import com.formidulus.mod.realtime.TimedEventHandler;
import com.formidulus.mod.structure.FormidableStructureProcessors;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.ObserverBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate.StructureBlockInfo;
import org.jetbrains.annotations.Nullable;

public class SeasonalPumpkinProcessor extends StructureProcessor {
   public static final MapCodec<SeasonalPumpkinProcessor> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.point(new SeasonalPumpkinProcessor()));

   protected StructureProcessorType<?> getType() {
      return FormidableStructureProcessors.SEASONAL_PUMPKINS;
   }

   @Nullable
   public StructureBlockInfo processBlock(
      LevelReader world, BlockPos pos, BlockPos pivot, StructureBlockInfo originalBlockInfo, StructureBlockInfo cur, StructurePlaceSettings data
   ) {
      BlockState state = cur.state();
      if (!TimedEventHandler.isActive(TimedEvent.WEEN)) {
         if (state.is(Blocks.PUMPKIN)) {
            return new StructureBlockInfo(cur.pos(), Blocks.CAVE_AIR.defaultBlockState(), cur.nbt());
         }

         if (state.is(Blocks.CARVED_PUMPKIN) && !world.getBlockState(cur.pos().below()).is(Blocks.HAY_BLOCK)) {
            return new StructureBlockInfo(cur.pos(), Blocks.CAVE_AIR.defaultBlockState(), cur.nbt());
         }

         if (state.is(Blocks.JACK_O_LANTERN)) {
            return new StructureBlockInfo(cur.pos(), Blocks.LANTERN.defaultBlockState(), cur.nbt());
         }
      }

      if (state.is(Blocks.ORANGE_STAINED_GLASS)) {
         return new StructureBlockInfo(cur.pos(), Blocks.PUMPKIN.defaultBlockState(), cur.nbt());
      } else {
         return state.is(Blocks.OBSERVER)
            ? new StructureBlockInfo(
               cur.pos(),
               (BlockState)Blocks.CARVED_PUMPKIN.defaultBlockState().setValue(CarvedPumpkinBlock.FACING, (Direction)state.getValue(ObserverBlock.FACING)),
               cur.nbt()
            )
            : cur;
      }
   }
}
