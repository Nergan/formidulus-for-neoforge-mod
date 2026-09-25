package com.formidulus.mod.network;

import com.formidulus.mod.Formidulus;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload.Type;
import net.minecraft.resources.ResourceLocation;

public record ModifyBossSpawnerPayload(BlockPos pos, ResourceLocation bossType, int respawnDelay) implements CustomPacketPayload {
   public static final Type<ModifyBossSpawnerPayload> ID = new Type(Formidulus.identifier("modify_boss_spawner"));
   public static final StreamCodec<RegistryFriendlyByteBuf, ModifyBossSpawnerPayload> CODEC = StreamCodec.composite(
      BlockPos.STREAM_CODEC,
      ModifyBossSpawnerPayload::pos,
      ResourceLocation.STREAM_CODEC,
      ModifyBossSpawnerPayload::bossType,
      ByteBufCodecs.INT,
      ModifyBossSpawnerPayload::respawnDelay,
      ModifyBossSpawnerPayload::new
   );

   public Type<? extends CustomPacketPayload> type() {
      return ID;
   }
}
