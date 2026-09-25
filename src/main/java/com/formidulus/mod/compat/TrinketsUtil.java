package com.formidulus.mod.compat;

import java.util.function.Function;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class TrinketsUtil {
   public static boolean isHasTrinketEquipped(LivingEntity living, Item item) {
      return false;
   }

   public static boolean performIfPresent(LivingEntity living, Item item, Function<ItemStack, Boolean> function) {
      return false;
   }

   public static int performForEachPresent(LivingEntity living, Item item, Function<ItemStack, Boolean> function) {
      return 0;
   }
}
