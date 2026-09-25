package com.formidulus.mod.network;

import com.formidulus.mod.Formidulus;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload.Type;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.joml.Vector3f;

public record CastActiveAbilityPayload(Vector3f pos, ResourceLocation ability, int caster, ItemStack stack) implements CustomPacketPayload {
   public static final Type<CastActiveAbilityPayload> ID = new Type(Formidulus.identifier("cast_active_ability"));
   public static final StreamCodec<RegistryFriendlyByteBuf, CastActiveAbilityPayload> CODEC = StreamCodec.composite(
      ByteBufCodecs.VECTOR3F,
      CastActiveAbilityPayload::pos,
      ResourceLocation.STREAM_CODEC,
      CastActiveAbilityPayload::ability,
      ByteBufCodecs.INT,
      CastActiveAbilityPayload::caster,
      ItemStack.STREAM_CODEC,
      CastActiveAbilityPayload::stack,
      CastActiveAbilityPayload::new
   );

   public Type<? extends CustomPacketPayload> type() {
      return ID;
   }
}
