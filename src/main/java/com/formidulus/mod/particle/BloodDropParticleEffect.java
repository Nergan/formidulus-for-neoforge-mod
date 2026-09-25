package com.formidulus.mod.particle;

import com.formidulus.mod.registries.ParticleRegistry;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import org.joml.Vector3f;

public record BloodDropParticleEffect(Vector3f destination) implements ParticleOptions {
   public ParticleType<?> getType() {
      return ParticleRegistry.BLOOD_DROP_PARTICLE;
   }

   public static MapCodec<BloodDropParticleEffect> getMapCodec() {
      return ExtraCodecs.VECTOR3F.xmap(BloodDropParticleEffect::new, BloodDropParticleEffect::destination).fieldOf("destination");
   }

   public static StreamCodec<? super RegistryFriendlyByteBuf, BloodDropParticleEffect> getPacketCodec() {
      return ByteBufCodecs.VECTOR3F.map(BloodDropParticleEffect::new, BloodDropParticleEffect::destination);
   }
}
