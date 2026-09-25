package com.formidulus.mod.advancement;

import com.formidulus.mod.Formidulus;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class CriteriaRegistry {
   public static final BossFightWonCriterion BOSSFIGHT_WIN = (BossFightWonCriterion)Registry.register(
      BuiltInRegistries.TRIGGER_TYPES, Formidulus.identifier("bossfight_win"), new BossFightWonCriterion()
   );

   public static void regiser() {
   }
}
