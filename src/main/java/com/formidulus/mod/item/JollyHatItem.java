package com.formidulus.mod.item;

import com.formidulus.mod.item.components.AccessoryComponent;
import com.formidulus.mod.registries.DataComponentRegistry;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

public class JollyHatItem extends Item implements Equipable {
   public static final String ACCESSORY_MODE_ACTIVE = "active";
   public static final String ACCESSORY_MODE_INACTIVE = "inactive";

   public JollyHatItem(Properties settings) {
      super(settings);
      DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
   }

   public EquipmentSlot getEquipmentSlot() {
      return EquipmentSlot.HEAD;
   }

   public static boolean tickSnowfall(LivingEntity entity, ItemStack stack) {
      AccessoryComponent accessory = (AccessoryComponent)stack.get(DataComponentRegistry.ACCESSORY);
      if (accessory != null && accessory.modes().get(accessory.activeMode()).equals("active")) {
         RandomSource random = entity.getRandom();
         if (random.nextFloat() > 0.2F) {
            return true;
         } else {
            Vec3 pos = Vec3.ZERO.offsetRandom(random, 1.0F).multiply(1.5, 0.2F, 1.5).add(entity.getEyePosition()).add(0.0, 1.0, 0.0);
            if (!entity.level().clip(new ClipContext(entity.getEyePosition(), pos, Block.COLLIDER, Fluid.ANY, entity)).getType().equals(Type.MISS)) {
               return true;
            } else {
               entity.level()
                  .addParticle(new BlockParticleOption(ParticleTypes.FALLING_DUST, Blocks.SNOW_BLOCK.defaultBlockState()), pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
               return true;
            }
         }
      } else {
         return false;
      }
   }
}
