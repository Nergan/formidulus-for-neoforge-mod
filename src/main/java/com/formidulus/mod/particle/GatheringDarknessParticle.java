package com.formidulus.mod.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;

public class GatheringDarknessParticle extends DarknessParticle {
   Vec3 center;

   protected GatheringDarknessParticle(ClientLevel clientWorld, double x, double y, double z, double velX, double velY, double velZ, SpriteSet spriteProvider) {
      super(clientWorld, x + velX, y + velY, z + velZ, 0.0, -0.1, 0.0, spriteProvider);
      this.center = new Vec3(x, y, z);
   }

   @Override
   public void tick() {
      super.tick();
      Vec3 pos = new Vec3(this.x, this.y, this.z).lerp(this.center, (double)((float)this.age / (float)this.lifetime / 6.0F));
      this.setPos(pos.x, pos.y, pos.z);
   }

   public static record Factory(SpriteSet sprite) implements ParticleProvider<SimpleParticleType> {
      static RandomSource rand = RandomSource.create();

      public Particle createParticle(
         SimpleParticleType parameters, ClientLevel world, double x, double y, double z, double velocityX, double velocityY, double velocityZ
      ) {
         GatheringDarknessParticle particle = new GatheringDarknessParticle(world, x, y, z, velocityX, velocityY, velocityZ, this.sprite);
         particle.lifetime = 20 + (int)(10.0F * rand.nextFloat());
         return particle;
      }
   }
}
