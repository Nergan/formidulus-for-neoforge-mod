package com.formidulus.mod.network;

import com.formidulus.mod.Formidulus;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload.Type;

public record SequenceTriggerPayload(byte sequenceID) implements CustomPacketPayload {
   public static final Type<SequenceTriggerPayload> ID = new Type(Formidulus.identifier("sequence_trigger_packet"));
   public static final StreamCodec<RegistryFriendlyByteBuf, SequenceTriggerPayload> CODEC = StreamCodec.composite(
      ByteBufCodecs.BYTE, SequenceTriggerPayload::sequenceID, SequenceTriggerPayload::new
   );
   public static final byte SPAWN_SEQUENCE = 0;
   public static final byte PROJECTILE_SEQUENCE = 1;
   public static final byte PHASE_TRANSITION_SEQUENCE = 2;
   public static final byte PLAYER_DEATH_SEQUENCE = 3;
   public static final byte DEATH_SEQUENCE = 5;

   public Type<? extends CustomPacketPayload> type() {
      return ID;
   }
}
