package com.formidulus.mod.network;

import com.formidulus.mod.Formidulus;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload.Type;

public record OpenBossSpawnerScreenPayload(BlockPos pos) implements CustomPacketPayload {
   public static final Type<OpenBossSpawnerScreenPayload> ID = new Type(Formidulus.identifier("boss_spawner_screen"));
   public static final StreamCodec<RegistryFriendlyByteBuf, OpenBossSpawnerScreenPayload> CODEC = StreamCodec.composite(
      BlockPos.STREAM_CODEC, OpenBossSpawnerScreenPayload::pos, OpenBossSpawnerScreenPayload::new
   );

   public Type<? extends CustomPacketPayload> type() {
      return ID;
   }
}
