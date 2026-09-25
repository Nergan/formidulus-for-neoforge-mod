package com.formidulus.mod.network;

import com.formidulus.mod.Formidulus;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload.Type;
import net.minecraft.resources.ResourceLocation;

public record BossMusicUpdatePayload(ResourceLocation bossId, String trackKey, boolean late) implements CustomPacketPayload {
   public static final Type<BossMusicUpdatePayload> ID = new Type(Formidulus.identifier("boss_music_update"));
   public static final StreamCodec<RegistryFriendlyByteBuf, BossMusicUpdatePayload> CODEC = StreamCodec.composite(
      ResourceLocation.STREAM_CODEC,
      BossMusicUpdatePayload::bossId,
      ByteBufCodecs.STRING_UTF8,
      BossMusicUpdatePayload::trackKey,
      ByteBufCodecs.BOOL,
      BossMusicUpdatePayload::late,
      BossMusicUpdatePayload::new
   );

   public BossMusicUpdatePayload(ResourceLocation bossId, String trackKey) {
      this(bossId, trackKey, false);
   }

   public Type<? extends CustomPacketPayload> type() {
      return ID;
   }
}
