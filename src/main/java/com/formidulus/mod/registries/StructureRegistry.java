package com.formidulus.mod.registries;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.structure.DeerCultHideoutStructure;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

public class StructureRegistry {
   public static StructureType<DeerCultHideoutStructure> DEER_CULT_HIDEOUT;
   public static StructurePieceType DEER_CULT_HIDEOUT_PIECE;

   public static void registerTypes() {
      if (DEER_CULT_HIDEOUT != null) {
         return;
      }
      DEER_CULT_HIDEOUT = Registry.register(
         BuiltInRegistries.STRUCTURE_TYPE, Formidulus.identifier("deer_cult_hideout"), () -> DeerCultHideoutStructure.CODEC
      );
   }

   public static void registerPieces() {
      if (DEER_CULT_HIDEOUT_PIECE != null) {
         return;
      }
      DEER_CULT_HIDEOUT_PIECE = Registry.register(
         BuiltInRegistries.STRUCTURE_PIECE, Formidulus.identifier("deer_cult_hideout"), DeerCultHideoutStructure.Piece::new
      );
   }
}
