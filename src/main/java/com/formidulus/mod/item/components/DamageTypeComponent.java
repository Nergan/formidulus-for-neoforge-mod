package com.formidulus.mod.item.components;

import com.formidulus.mod.damage.DamageSources;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;

public record DamageTypeComponent(ResourceKey<DamageType> damageType) {
   public static final DamageTypeComponent DEFAULT = new DamageTypeComponent(DamageTypes.PLAYER_ATTACK);
   public static final Codec<DamageTypeComponent> CODEC = RecordCodecBuilder.create(
      instance -> instance.group(ResourceLocation.CODEC.fieldOf("damageType").forGetter(DamageTypeComponent::getTypeId))
            .apply(instance, DamageTypeComponent::fromIdentifier)
   );
   public static final StreamCodec<ByteBuf, DamageTypeComponent> PACKET_CODEC = StreamCodec.composite(
      ResourceLocation.STREAM_CODEC, DamageTypeComponent::getTypeId, DamageTypeComponent::fromIdentifier
   );

   public ResourceLocation getTypeId() {
      return this.damageType.registry();
   }

   public static DamageTypeComponent fromIdentifier(ResourceLocation type) {
      return new DamageTypeComponent(ResourceKey.create(Registries.DAMAGE_TYPE, type));
   }

   public DamageSource getSource(LivingEntity attacker) {
      return DamageSources.get(attacker.level(), this.damageType, attacker);
   }
}
