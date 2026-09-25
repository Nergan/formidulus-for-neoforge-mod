package com.formidulus.mod.item.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.util.Optional;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record ChargeComponent(float charge, float maxCharge) {
   public static final Codec<ChargeComponent> CODEC = RecordCodecBuilder.create(
      instance -> instance.group(
               Codec.FLOAT.fieldOf("charge").forGetter(ChargeComponent::charge), Codec.FLOAT.fieldOf("maxCharge").forGetter(ChargeComponent::maxCharge)
            )
            .apply(instance, ChargeComponent::new)
   );
   public static final StreamCodec<ByteBuf, ChargeComponent> PACKET_CODEC = StreamCodec.composite(
      ByteBufCodecs.FLOAT, ChargeComponent::charge, ByteBufCodecs.FLOAT, ChargeComponent::maxCharge, ChargeComponent::new
   );

   public boolean isCharged(float minPercent) {
      return this.getChargePercent() >= minPercent;
   }

   public ChargeComponent consumeCharge(float percent) {
      return new ChargeComponent(Math.max(this.charge - percent * this.maxCharge, 0.0F), this.maxCharge);
   }

   public Optional<ChargeComponent> tryConsumeCharge(float percent) {
      return this.getChargePercent() < percent
         ? Optional.empty()
         : Optional.of(new ChargeComponent(Math.max(this.charge - percent * this.maxCharge, 0.0F), this.maxCharge));
   }

   public Optional<ChargeComponent> tryAddCharge(float percent) {
      return this.getChargePercent() < percent
         ? Optional.empty()
         : Optional.of(new ChargeComponent(Math.min(this.charge + percent * this.maxCharge, this.maxCharge), this.maxCharge));
   }

   public float getChargePercent() {
      return this.charge / this.maxCharge;
   }
}
