package com.formidulus.mod.item.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.util.List;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;

public record AccessoryComponent(List<String> modes, int activeMode) {
   public static final AccessoryComponent DEFAULT = new AccessoryComponent(List.of("default"), 0);
   public static final Codec<AccessoryComponent> CODEC = RecordCodecBuilder.create(
      instance -> instance.group(
               Codec.list(Codec.STRING).fieldOf("modes").forGetter(AccessoryComponent::modes),
               Codec.INT.fieldOf("activeMode").forGetter(AccessoryComponent::activeMode)
            )
            .apply(instance, AccessoryComponent::new)
   );
   public static final StreamCodec<ByteBuf, AccessoryComponent> PACKET_CODEC = StreamCodec.composite(
      ByteBufCodecs.STRING_UTF8.apply(ByteBufCodecs.list()),
      AccessoryComponent::modes,
      ByteBufCodecs.INT,
      AccessoryComponent::activeMode,
      AccessoryComponent::new
   );

   @NotNull
   public AccessoryComponent cycle() {
      return new AccessoryComponent(this.modes, (this.activeMode + 1) % this.modes.size());
   }
}
