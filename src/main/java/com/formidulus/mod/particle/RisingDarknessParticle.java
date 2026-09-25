package com.formidulus.mod.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class RisingDarknessParticle extends DarknessParticle {
   protected RisingDarknessParticle(ClientLevel clientWorld, double x, double y, double z, double velX, double velY, double velZ, SpriteSet spriteProvider) {
      super(clientWorld, x, y, z, velX, velY, velZ, spriteProvider);
      this.lifetime = 150;
      this.friction = 0.925F;
   }

   @Override
   public void tick() {
      super.tick();
      if ((float)this.age > (float)this.lifetime / 3.0F) {
         this.yd += 0.005F;
      }
   }

   public static record Factory(SpriteSet sprite) implements ParticleProvider<SimpleParticleType> {
      static RandomSource rand = RandomSource.create();

      public Particle createParticle(
         SimpleParticleType parameters, ClientLevel world, double x, double y, double z, double velocityX, double velocityY, double velocityZ
      ) {
         RisingDarknessParticle particle = new RisingDarknessParticle(world, x, y, z, velocityX, velocityY, velocityZ, this.sprite);
         particle.lifetime = 100 + (int)(50.0F * rand.nextFloat());
         return particle;
      }
   }
}
