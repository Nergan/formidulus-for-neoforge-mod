package com.formidulus.mod.block;

import com.formidulus.mod.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EquipableCarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import org.jetbrains.annotations.Nullable;

public class WeenBlock extends EquipableCarvedPumpkinBlock {
   public WeenBlock(Properties settings) {
      super(settings);
   }

   public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
      super.setPlacedBy(world, pos, state, placer, itemStack);
      world.playSound(null, pos, SoundRegistry.WEEN, SoundSource.BLOCKS);
   }
}
