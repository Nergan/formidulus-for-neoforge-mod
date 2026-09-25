package com.formidulus.mod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class DeerSkullBlock extends BaseEntityBlock {
   public static final MapCodec<DeerSkullBlock> CODEC = simpleCodec(DeerSkullBlock::new);
   public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

   public DeerSkullBlock(Properties settings) {
      super(settings);
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      super.createBlockStateDefinition(builder);
      builder.add(new Property[]{FACING});
   }

   protected MapCodec<? extends BaseEntityBlock> codec() {
      return CODEC;
   }

   @Nullable
   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new DeerSkullBlockEntity(pos, state);
   }

   public BlockState getStateForPlacement(BlockPlaceContext ctx) {
      return (BlockState)this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
   }

   protected boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
      BlockPos clickedPos = pos.relative(((Direction)state.getValue(FACING)).getOpposite());
      return world.getBlockState(clickedPos).isFaceSturdy(world, clickedPos, (Direction)state.getValue(FACING));
   }

   protected RenderShape getRenderShape(BlockState state) {
      return RenderShape.MODEL;
   }

   protected VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.or(switch ((Direction)state.getValue(FACING)) {
         case NORTH -> Block.box(0.0, 0.0, 14.0, 16.0, 16.0, 16.0);
         case SOUTH -> Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 2.0);
         case WEST -> Block.box(14.0, 0.0, 0.0, 16.0, 16.0, 16.0);
         default -> Block.box(0.0, 0.0, 0.0, 2.0, 16.0, 16.0);
      }, Block.box(2.0, 2.0, 2.0, 14.0, 14.0, 14.0));
   }

   protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return this.getCollisionShape(state, world, pos, context);
   }
}
