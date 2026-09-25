package com.formidulus.mod.item.components;

import com.formidulus.mod.item.abilities.ItemAbilities;
import com.formidulus.mod.item.abilities.ItemAbility;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

public record AbilityComponent(ItemAbility ability) {
   public static final AbilityComponent DEFAULT = new AbilityComponent(ItemAbilities.NONE);
   public static final Codec<AbilityComponent> CODEC = RecordCodecBuilder.create(
      instance -> instance.group(ResourceLocation.CODEC.fieldOf("ability").forGetter(AbilityComponent::getTypeId))
            .apply(instance, AbilityComponent::fromIdentifier)
   );
   public static final StreamCodec<ByteBuf, AbilityComponent> PACKET_CODEC = StreamCodec.composite(
      ItemAbility.PACKET_CODEC, AbilityComponent::ability, AbilityComponent::new
   );

   public ResourceLocation getTypeId() {
      return this.ability.id;
   }

   public static AbilityComponent fromIdentifier(ResourceLocation id) {
      return new AbilityComponent(ItemAbilities.getFromId(id));
   }
}
