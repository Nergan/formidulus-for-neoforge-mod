package com.formidulus.mod.block;

import com.formidulus.mod.registries.BlockEntityRegistry;
import com.formidulus.mod.registries.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BigLanternBlockEntity extends BlockEntity {
   private int rechargeTimer = 600;

   public BigLanternBlockEntity(BlockPos pos, BlockState state) {
      super(BlockEntityRegistry.BIG_LANTERN, pos, state);
   }

   public CompoundTag getUpdateTag(Provider registryLookup) {
      return this.saveWithoutMetadata(registryLookup);
   }

   @Nullable
   public Packet<ClientGamePacketListener> getUpdatePacket() {
      return ClientboundBlockEntityDataPacket.create(this);
   }

   public static <T extends BlockEntity> void tick(T t) {
      if (t instanceof BigLanternBlockEntity lantern) {
         lantern.tick();
      }
   }

   void tick() {
      if (this.level != null) {
         if (this.getBlockState().is(BlockRegistry.GREAT_LANTERN)) {
            if (this.rechargeTimer > 0 && (Integer)this.getBlockState().getValue(BigLanternBlock.CHARGE) < 4) {
               this.rechargeTimer--;
            } else if (this.rechargeTimer > -1) {
               int charge = (Integer)this.getBlockState().getValue(BigLanternBlock.CHARGE);
               this.level.setBlockAndUpdate(this.worldPosition, (BlockState)this.getBlockState().setValue(BigLanternBlock.CHARGE, Math.min(charge + 1, 4)));
               this.rechargeTimer = 600;
            }
         }
      }
   }

   public void startRechargeTimer() {
      if (this.rechargeTimer < 0) {
         this.rechargeTimer = 600;
      }
   }

   protected void saveAdditional(CompoundTag nbt, Provider registryLookup) {
      super.saveAdditional(nbt, registryLookup);
      nbt.putInt("RechargeTimer", this.rechargeTimer);
   }

   protected void loadAdditional(CompoundTag nbt, Provider registryLookup) {
      super.loadAdditional(nbt, registryLookup);
      if (nbt.contains("RechargeTimer", 3)) {
         this.rechargeTimer = nbt.getInt("RechargeTimer");
      }
   }
}
