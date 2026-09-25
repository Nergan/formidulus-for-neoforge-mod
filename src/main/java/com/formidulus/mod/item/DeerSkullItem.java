package com.formidulus.mod.item;

import com.formidulus.mod.registries.BlockRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.DispenserBlock;

public class DeerSkullItem extends BlockItem implements Equipable {
   public static final String ACCESSORY_MODE_MASK = "mask";
   public static final String ACCESSORY_MODE_CAP = "cap";

   public DeerSkullItem(Properties settings) {
      super(BlockRegistry.DEER_SKULL, settings);
      DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
   }

   public EquipmentSlot getEquipmentSlot() {
      return EquipmentSlot.HEAD;
   }

   public boolean isEnchantable(ItemStack stack) {
      return true;
   }

   public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
      return enchantment.equals(Enchantments.BINDING_CURSE);
   }
}
