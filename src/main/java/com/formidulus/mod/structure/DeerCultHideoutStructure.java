package com.formidulus.mod.structure;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.registries.StructureRegistry;
import com.formidulus.mod.structure.processor.DeLeaferProcessor;
import com.formidulus.mod.structure.processor.DehydrationProcessor;
import com.formidulus.mod.structure.processor.GrowCropsProcessor;
import com.formidulus.mod.structure.processor.SeasonalPumpkinProcessor;
import com.mojang.serialization.MapCodec;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.Structure.GenerationContext;
import net.minecraft.world.level.levelgen.structure.Structure.GenerationStub;
import net.minecraft.world.level.levelgen.structure.Structure.StructureSettings;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

public class DeerCultHideoutStructure extends Structure {
   static final ResourceLocation ID = Formidulus.identifier("deer_cult_hideout");
   public static final MapCodec<DeerCultHideoutStructure> CODEC = simpleCodec(DeerCultHideoutStructure::new);

   public DeerCultHideoutStructure(StructureSettings config) {
      super(config);
   }

   protected Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
      return onTopOfChunkCenter(context, Types.WORLD_SURFACE_WG, collector -> this.addPieces(collector, context));
   }

   public StructureType<?> type() {
      return StructureRegistry.DEER_CULT_HIDEOUT;
   }

   private void addPieces(StructurePiecesBuilder collector, GenerationContext context) {
      this.findGenerationPoint(context)
         .ifPresent(
            pos -> collector.addPiece(
                  new DeerCultHideoutStructure.Piece(
                     StructureRegistry.DEER_CULT_HIDEOUT_PIECE,
                     0,
                     context.structureTemplateManager(),
                     ID,
                     ID.toString(),
                     new StructurePlaceSettings()
                        .setLiquidSettings(LiquidSettings.IGNORE_WATERLOGGING)
                        .setRotationPivot(pos.position().subtract(new BlockPos(30, 43, 30))),
                     pos.position().subtract(new Vec3i(30, 43, 30))
                  )
               )
         );
   }

   public static class Piece extends TemplateStructurePiece {
      public Piece(
         StructurePieceType type,
         int length,
         StructureTemplateManager structureTemplateManager,
         ResourceLocation id,
         String template,
         StructurePlaceSettings placementData,
         BlockPos pos
      ) {
         super(type, length, structureTemplateManager, id, template, placementData, pos);
      }

      public Piece(StructurePieceSerializationContext context, CompoundTag nbt) {
         super(
            StructureRegistry.DEER_CULT_HIDEOUT_PIECE,
            nbt,
            context.structureTemplateManager(),
            identifier -> new StructurePlaceSettings()
                  .addProcessor(new GrowCropsProcessor(1.0F, Blocks.WHEAT.defaultBlockState(), true))
                  .addProcessor(new SeasonalPumpkinProcessor())
                  .addProcessor(new DehydrationProcessor())
                  .addProcessor(new DeLeaferProcessor(false))
         );
      }

      public StructurePlaceSettings placeSettings() {
         return super.placeSettings();
      }

      public void postProcess(
         WorldGenLevel world,
         StructureManager structureAccessor,
         ChunkGenerator chunkGenerator,
         RandomSource random,
         BoundingBox chunkBox,
         ChunkPos chunkPos,
         BlockPos pivot
      ) {
         super.postProcess(world, structureAccessor, chunkGenerator, random, chunkBox, chunkPos, pivot);
      }

      protected void handleDataMarker(String metadata, BlockPos pos, ServerLevelAccessor world, RandomSource random, BoundingBox boundingBox) {
      }
   }
}
