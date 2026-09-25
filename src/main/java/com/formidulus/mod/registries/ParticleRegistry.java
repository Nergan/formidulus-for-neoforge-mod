package com.formidulus.mod.registries;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.particle.BloodDropParticleEffect;
import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;

public class ParticleRegistry {
   public static final SimpleParticleType DARKNESS = (SimpleParticleType)Registry.register(
      BuiltInRegistries.PARTICLE_TYPE, Formidulus.identifier("darkness"), new SimpleParticleType(false)
   );
   public static final SimpleParticleType RISING_DARKNESS = (SimpleParticleType)Registry.register(
      BuiltInRegistries.PARTICLE_TYPE, Formidulus.identifier("rising_darkness"), new SimpleParticleType(false)
   );
   public static final SimpleParticleType GATHERING_DARKNESS = (SimpleParticleType)Registry.register(
      BuiltInRegistries.PARTICLE_TYPE, Formidulus.identifier("gathering_darkness"), new SimpleParticleType(false)
   );
   public static final ParticleType<BloodDropParticleEffect> BLOOD_DROP_PARTICLE = (ParticleType<BloodDropParticleEffect>)Registry.register(
      BuiltInRegistries.PARTICLE_TYPE,
      Formidulus.identifier("blood_drop"),
      new ParticleType<BloodDropParticleEffect>(false) {
         @Override
         public MapCodec<BloodDropParticleEffect> codec() {
            return BloodDropParticleEffect.getMapCodec();
         }

         @Override
         public StreamCodec<? super RegistryFriendlyByteBuf, BloodDropParticleEffect> streamCodec() {
            return BloodDropParticleEffect.getPacketCodec();
         }
      }
   );

   public static void register() {
   }
}
