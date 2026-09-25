package com.formidulus.mod.registries;

import com.formidulus.mod.Formidulus;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;

public class FormidableMapDecorations {
   public static final Holder<MapDecorationType> CULT_HIDEOUT = register("cult_hideout", true, 9325736, false, true);

   private static Holder<MapDecorationType> register(String id, boolean showOnItemFrame, int mapColor, boolean trackCount, boolean explorationMapElement) {
      ResourceKey<MapDecorationType> registryKey = ResourceKey.create(Registries.MAP_DECORATION_TYPE, Formidulus.identifier(id));
      MapDecorationType mapDecorationType = new MapDecorationType(Formidulus.identifier(id), showOnItemFrame, mapColor, explorationMapElement, trackCount);
      return Registry.registerForHolder(BuiltInRegistries.MAP_DECORATION_TYPE, registryKey, mapDecorationType);
   }

   public static void register() {
   }
}
