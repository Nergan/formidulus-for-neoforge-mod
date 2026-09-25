package com.formidulus.mod.structure;

import com.formidulus.mod.Formidulus;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class FormidableStructures {
   public static final ResourceKey<StructureSet> DEER_CULT_HIDEOUT_SET = ResourceKey.create(
      Registries.STRUCTURE_SET, Formidulus.identifier("deer_cult_hideout")
   );
   public static final ResourceKey<Structure> DEER_CULT_HIDEOUT = ResourceKey.create(Registries.STRUCTURE, Formidulus.identifier("deer_cult_hideout"));
   public static final ResourceKey<StructureTemplatePool> DEER_CULT_HIDEOUT_POOL = ResourceKey.create(
      Registries.TEMPLATE_POOL, Formidulus.identifier("deer_cult_hideout")
   );
   public static final ResourceKey<StructureProcessorList> DEER_CULT_PROCESSORS = ResourceKey.create(
      Registries.PROCESSOR_LIST, Formidulus.identifier("deer_cult_hideout")
   );
}
