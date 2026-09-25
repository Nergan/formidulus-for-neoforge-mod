package com.formidulus.mod.block;

import net.neoforged.neoforge.common.Tags;
import com.formidulus.mod.item.abilities.HealwaveAbility;
import com.formidulus.mod.item.components.ChargeComponent;
import com.formidulus.mod.registries.DataComponentRegistry;
import com.formidulus.mod.registries.ItemRegistry;
import com.mojang.serialization.MapCodec;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BigLanternBlock extends BaseEntityBlock {
   public static final MapCodec<BigLanternBlock> CODEC = simpleCodec(BigLanternBlock::new);
   public static final BooleanProperty CHAINED = BooleanProperty.create("chained");
   public static final IntegerProperty CHARGE = IntegerProperty.create("charge", 0, 4);

   public BigLanternBlock(Properties settings) {
      super(settings);
      this.registerDefaultState((BlockState)this.defaultBlockState().setValue(CHARGE, 4));
   }

   protected MapCodec<? extends BaseEntityBlock> codec() {
      return CODEC;
   }

   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      builder.add(new Property[]{CHAINED}).add(new Property[]{CHARGE});
      super.createBlockStateDefinition(builder);
   }

   @Nullable
   public BlockState getStateForPlacement(BlockPlaceContext ctx) {
      BlockState state = (BlockState)this.defaultBlockState()
         .setValue(CHAINED, ctx.getLevel().getBlockState(ctx.getClickedPos().above()).is(Tags.Blocks.CHAINS));
      if (ctx.getItemInHand().get(DataComponentRegistry.CHARGE) instanceof ChargeComponent chargeComp) {
         state = (BlockState)state.setValue(CHARGE, (int)Mth.clamp(chargeComp.getChargePercent() * 4.0F, 0.0F, 4.0F));
      }

      return state;
   }

   protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
      if (direction.equals(Direction.UP)) {
         state = (BlockState)state.setValue(CHAINED, world.getBlockState(neighborPos).is(Tags.Blocks.CHAINS));
      }

      return state;
   }

   public BlockState playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
      if ((Integer)state.getValue(CHARGE) > 0) {
         for (int i = 0; i < 4 * state.getValue(CHARGE); i++) {
            Vec3 ppos = pos.getCenter().offsetRandom(world.getRandom(), 0.4F);
            Vec3 vel = Vec3.ZERO.offsetRandom(world.getRandom(), 0.1F);
            world.addParticle(ParticleTypes.FLAME, ppos.x, ppos.y, ppos.z, vel.x, vel.y, vel.z);
         }
      }

      return super.playerWillDestroy(world, pos, state, player);
   }

   protected List<ItemStack> getDrops(BlockState state, net.minecraft.world.level.storage.loot.LootParams.Builder builder) {
      List<ItemStack> stacks = super.getDrops(state, builder);

      for (ItemStack stack : stacks) {
         if (stack.is(this.asItem())) {
            stack.set(DataComponentRegistry.CHARGE, new ChargeComponent((float)((Integer)state.getValue(CHARGE)).intValue(), 4.0F));
         }
      }

      return stacks;
   }

   protected RenderShape getRenderShape(BlockState state) {
      return RenderShape.MODEL;
   }

   protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
      if ((Integer)state.getValue(CHARGE) != 4 || player.isShiftKeyDown() || player.getMainHandItem().is(Items.DEBUG_STICK)) {
         return super.useWithoutItem(state, world, pos, player, hit);
      } else if (world.isClientSide) {
         return InteractionResult.SUCCESS;
      } else {
         world.blockEvent(pos, this, 0, 0);
         world.setBlockAndUpdate(pos, (BlockState)state.setValue(CHARGE, 0));
         HealwaveAbility.castHealwave(player, ItemRegistry.GREAT_LANTERN.getDefaultInstance(), pos.getBottomCenter());
         if (world.getBlockEntity(pos) instanceof BigLanternBlockEntity lantern) {
            lantern.startRechargeTimer();
         }

         world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
         return InteractionResult.SUCCESS;
      }
   }

   protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      float rim = 0.15625F;
      float innerRim = 0.21875F;
      return Shapes.or(
         Shapes.box((double)rim, 0.0, (double)rim, (double)(1.0F - rim), 0.25, (double)(1.0F - rim)),
         new VoxelShape[]{
            Shapes.box((double)innerRim, 0.25, (double)innerRim, (double)(1.0F - innerRim), 1.0, (double)(1.0F - innerRim)),
            Shapes.box((double)rim, 0.875, (double)rim, (double)(1.0F - rim), 0.9375, (double)(1.0F - rim))
         }
      );
   }

   protected VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
      float rim = 0.15625F;
      return Shapes.box((double)rim, 0.0, (double)rim, (double)(1.0F - rim), 1.0, (double)(1.0F - rim));
   }

   public static int getLuminance(BlockState state) {
      return switch (state.getValue(CHARGE)) {
         case 0 -> 0;
         case 1 -> 4;
         case 2 -> 8;
         case 3 -> 12;
         default -> 15;
      };
   }

   @Nullable
   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new BigLanternBlockEntity(pos, state);
   }

   @Nullable
   public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
      return world.isClientSide ? null : (w, p, s, t) -> BigLanternBlockEntity.tick(w.getBlockEntity(p));
   }

   public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
      ItemStack stack = super.getCloneItemStack(world, pos, state);
      stack.set(DataComponentRegistry.CHARGE, new ChargeComponent((float)((Integer)state.getValue(CHARGE)).intValue(), 4.0F));
      return stack;
   }
}
