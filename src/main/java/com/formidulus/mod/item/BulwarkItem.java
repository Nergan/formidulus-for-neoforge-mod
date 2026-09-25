package com.formidulus.mod.item;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.registries.ItemRegistry;
import java.util.List;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ItemAttributeModifiers.Entry;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class BulwarkItem extends Item implements Equipable {
   public BulwarkItem(Properties settings) {
      super(settings);
      DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
   }

   public static ItemAttributeModifiers createAttributeModifiers() {
      return new ItemAttributeModifiers(
         List.of(
            new Entry(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.75, Operation.ADD_VALUE), EquipmentSlotGroup.HAND),
            new Entry(Attributes.MOVEMENT_SPEED, new AttributeModifier(Formidulus.identifier("heavy"), -0.05F, Operation.ADD_VALUE), EquipmentSlotGroup.HAND)
         ),
         true
      );
   }

   public boolean isValidRepairItem(ItemStack stack, ItemStack ingredient) {
      return ingredient.is(ItemRegistry.CHAINLINK);
   }

   public int getUseDuration(ItemStack stack, LivingEntity user) {
      return 72000;
   }

   public EquipmentSlot getEquipmentSlot() {
      return EquipmentSlot.OFFHAND;
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
      ItemStack itemStack = user.getItemInHand(hand);
      user.startUsingItem(hand);
      super.use(world, user, hand);
      return InteractionResultHolder.consume(itemStack);
   }
}
