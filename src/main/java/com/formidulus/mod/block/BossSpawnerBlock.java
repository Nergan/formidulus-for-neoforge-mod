package com.formidulus.mod.block;

import net.neoforged.neoforge.network.PacketDistributor;
import com.formidulus.mod.network.OpenBossSpawnerScreenPayload;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BossSpawnerBlock extends BaseEntityBlock {
   public static final MapCodec<BossSpawnerBlock> CODEC = simpleCodec(BossSpawnerBlock::new);

   public BossSpawnerBlock(Properties settings) {
      super(settings);
   }

   protected MapCodec<? extends BaseEntityBlock> codec() {
      return CODEC;
   }

   @Nullable
   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new BossSpawnerBlockEntity(pos, state);
   }

   protected VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      return Shapes.empty();
   }

   protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      if (context instanceof EntityCollisionContext entityShapeContext && entityShapeContext.getEntity() instanceof Player player && player.isCreative()) {
         return Shapes.block();
      }

      return Shapes.empty();
   }

   @Nullable
   public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
      return world.isClientSide ? null : (w, p, s, t) -> BossSpawnerBlockEntity.tick(w.getBlockEntity(p));
   }

   protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
      if (player.hasPermissions(2)) {
         if (!world.isClientSide && player instanceof ServerPlayer serverPlayer) {
            PacketDistributor.sendToPlayer(serverPlayer, new OpenBossSpawnerScreenPayload(pos));
         }

         return InteractionResult.CONSUME;
      } else {
         return super.useWithoutItem(state, world, pos, player, hit);
      }
   }

   public BlockState playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
      if (world.getBlockEntity(pos) instanceof BossSpawnerBlockEntity spawner) {
         spawner.onBlockBroken();
      }

      return super.playerWillDestroy(world, pos, state, player);
   }
}
