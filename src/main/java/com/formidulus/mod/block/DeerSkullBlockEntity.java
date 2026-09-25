package com.formidulus.mod.block;

import com.formidulus.mod.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DeerSkullBlockEntity extends BlockEntity {
   public DeerSkullBlockEntity(BlockPos pos, BlockState state) {
      super(BlockEntityRegistry.DEER_SKULL, pos, state);
   }
}
