package com.formidulus.mod.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;

public class DarknessParticle extends TextureSheetParticle {
   private final SpriteSet spriteProvider;

   protected DarknessParticle(ClientLevel clientWorld, double x, double y, double z, double velX, double velY, double velZ, SpriteSet spriteProvider) {
      super(clientWorld, x, y, z);
      this.spriteProvider = spriteProvider;
      this.setParticleSpeed(velX, velY, velZ);
      this.quadSize = 0.35F + this.random.nextFloat() * 0.1F;
      this.lifetime = 20 + (int)(this.random.nextFloat() * 25.0F);
      this.speedUpWhenYMotionIsBlocked = true;
      this.setColor(0.0F, 0.0F, 0.0F);
      this.setSpriteFromAge(spriteProvider);
      this.hasPhysics = false;
   }

   public ParticleRenderType getRenderType() {
      return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
   }

   public void tick() {
      super.tick();
      this.setSpriteFromAge(this.spriteProvider);
   }

   public static record Factory(SpriteSet sprite) implements ParticleProvider<SimpleParticleType> {
      public Particle createParticle(
         SimpleParticleType parameters, ClientLevel world, double x, double y, double z, double velocityX, double velocityY, double velocityZ
      ) {
         return new DarknessParticle(world, x, y, z, velocityX, velocityY, velocityZ, this.sprite);
      }
   }
}
