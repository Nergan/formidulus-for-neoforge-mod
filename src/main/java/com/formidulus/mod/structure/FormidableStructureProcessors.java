package com.formidulus.mod.structure;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.structure.processor.DeLeaferProcessor;
import com.formidulus.mod.structure.processor.DehydrationProcessor;
import com.formidulus.mod.structure.processor.GrowCropsProcessor;
import com.formidulus.mod.structure.processor.SeasonalPumpkinProcessor;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class FormidableStructureProcessors {
   public static final StructureProcessorType<GrowCropsProcessor> GROW_CROPS = (StructureProcessorType<GrowCropsProcessor>)Registry.register(
      BuiltInRegistries.STRUCTURE_PROCESSOR, Formidulus.identifier("grow_crops"), (StructureProcessorType)() -> GrowCropsProcessor.CODEC
   );
   public static final StructureProcessorType<SeasonalPumpkinProcessor> SEASONAL_PUMPKINS = (StructureProcessorType<SeasonalPumpkinProcessor>)Registry.register(
      BuiltInRegistries.STRUCTURE_PROCESSOR, Formidulus.identifier("seasonal_pumpkins"), (StructureProcessorType)() -> SeasonalPumpkinProcessor.CODEC
   );
   public static final StructureProcessorType<DehydrationProcessor> DEHYDRATOR = (StructureProcessorType<DehydrationProcessor>)Registry.register(
      BuiltInRegistries.STRUCTURE_PROCESSOR, Formidulus.identifier("dehydrator"), (StructureProcessorType)() -> DehydrationProcessor.CODEC
   );
   public static final StructureProcessorType<DeLeaferProcessor> DE_LEAFER = (StructureProcessorType<DeLeaferProcessor>)Registry.register(
      BuiltInRegistries.STRUCTURE_PROCESSOR, Formidulus.identifier("deleafer"), (StructureProcessorType)() -> DeLeaferProcessor.CODEC
   );

   public static void register() {
   }
}
