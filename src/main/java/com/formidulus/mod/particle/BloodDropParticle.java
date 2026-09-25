package com.formidulus.mod.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.util.Mth;
import org.joml.Vector3f;

public class BloodDropParticle extends SpriteAAParticle {
   Vector3f destination;
   float targetRiseSpeed;
   int attractDelay;

   protected BloodDropParticle(ClientLevel world, double x, double y, double z, SpriteSet spriteProvider, Vector3f destination) {
      super(world, x, y, z, spriteProvider);
      this.destination = destination;
      this.hasPhysics = false;
      this.gravity = 0.0F;
      this.attractDelay = (int)(this.random.nextFloat() * 40.0F);
      this.lifetime = 200 + (int)Math.ceil((double)((float)this.attractDelay * 1.5F));
      this.quadSize = 0.1F;
      this.setSpriteFromAge(spriteProvider);
   }

   public ParticleRenderType getRenderType() {
      return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
   }

   public void tick() {
      this.xo = this.x;
      this.yo = this.y;
      this.zo = this.z;
      if (this.age++ >= this.lifetime) {
         this.remove();
      } else {
         if (this.age == 35) {
            this.targetRiseSpeed = this.random.nextFloat() * 0.5F + 0.15F;
         }

         if (this.age >= 35 && this.age < 70) {
            this.yd = Mth.lerp(0.01 * (double)(this.age - 35) / 45.0, this.yd, (double)this.targetRiseSpeed);
         }

         if (this.age >= 90 + this.attractDelay && this.age < 110 + this.attractDelay) {
            this.yd = Mth.lerp((double)(this.random.nextFloat() * 0.3F), this.yd, 0.0);
         }

         if ((float)this.age >= 120.0F + (float)this.attractDelay * 1.5F) {
            Vector3f pos = new Vector3f((float)this.x, (float)this.y, (float)this.z);
            Vector3f dir = new Vector3f(this.destination).sub(pos).normalize();
            float distance = this.destination.distance(pos);
            float speed = Math.min(
               ((float)this.age - (120.0F + (float)this.attractDelay * 1.5F)) / ((float)this.lifetime - (120.0F + (float)this.attractDelay * 1.5F)), distance
            );
            Vector3f vel = new Vector3f((float)this.xd, (float)this.yd, (float)this.zd)
               .lerp(new Vector3f(dir).mul(speed), 0.1F + Math.min(1.0F - distance / 100.0F, 0.5F));
            this.xd = (double)vel.x;
            this.yd = (double)vel.y;
            this.zd = (double)vel.z;
            if (this.destination.distance(pos) < 0.4F) {
               this.remove();
            }
         }

         this.setSpriteFromAge(this.spriteProvider);
         this.move(this.xd, this.yd, this.zd);
      }
   }

   public void setSpriteFromAge(SpriteSet spriteProvider) {
      if (!this.removed) {
         this.setSprite(spriteProvider.get((int)(Math.min((float)this.age / 40.0F, 1.0F) * (float)this.lifetime), this.lifetime));
      }
   }

   public static record Factory(SpriteSet sprite) implements ParticleProvider<BloodDropParticleEffect> {
      public Particle createParticle(
         BloodDropParticleEffect parameters, ClientLevel world, double x, double y, double z, double velocityX, double velocityY, double velocityZ
      ) {
         return new BloodDropParticle(world, x, y + 0.2F, z, this.sprite, parameters.destination());
      }
   }
}
