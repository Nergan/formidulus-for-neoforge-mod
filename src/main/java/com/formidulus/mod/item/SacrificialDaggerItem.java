package com.formidulus.mod.item;

import com.formidulus.mod.Formidulus;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ItemAttributeModifiers.Entry;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class SacrificialDaggerItem extends TieredItem {
   public SacrificialDaggerItem(Tier toolMaterial, Properties settings) {
      super(toolMaterial, settings);
   }

   public static ItemAttributeModifiers createAttributeModifiers() {
      return new ItemAttributeModifiers(
         List.of(
            new Entry(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 9.0, Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND),
            new Entry(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, 1.0, Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND),
            new Entry(
               Attributes.ENTITY_INTERACTION_RANGE,
               new AttributeModifier(Formidulus.identifier("low_range_combat"), -0.75, Operation.ADD_VALUE),
               EquipmentSlotGroup.MAINHAND
            ),
            new Entry(
               Attributes.BLOCK_INTERACTION_RANGE,
               new AttributeModifier(Formidulus.identifier("low_range_mining"), -0.75, Operation.ADD_VALUE),
               EquipmentSlotGroup.MAINHAND
            )
         ),
         true
      );
   }

   public boolean canAttackBlock(BlockState state, Level world, BlockPos pos, Player miner) {
      return !miner.isCreative();
   }

   public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      return true;
   }

   public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
      stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
   }

   public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
      return enchantment.unwrapKey().isPresent() && ((ResourceKey)enchantment.unwrapKey().get()).equals(Enchantments.SWEEPING_EDGE)
         ? false
         : super.supportsEnchantment(stack, enchantment);
   }
}
