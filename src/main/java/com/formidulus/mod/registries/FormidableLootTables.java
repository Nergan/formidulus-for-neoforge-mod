package com.formidulus.mod.registries;

import com.formidulus.mod.Formidulus;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class FormidableLootTables {
   public static final ResourceKey<LootTable> CULT_HIDEOUT_HOUSE_CHEST = ResourceKey.create(
      Registries.LOOT_TABLE, Formidulus.identifier("chests/cult_hideout_house")
   );
   public static final ResourceKey<LootTable> CULT_HIDEOUT_CAVE_CHEST = ResourceKey.create(
      Registries.LOOT_TABLE, Formidulus.identifier("chests/cult_hideout_cave")
   );
   public static final ResourceKey<LootTable> CULT_HIDEOUT_TREE_CHEST = ResourceKey.create(
      Registries.LOOT_TABLE, Formidulus.identifier("chests/cult_hideout_tree")
   );

   public static void register() {
   }
}
