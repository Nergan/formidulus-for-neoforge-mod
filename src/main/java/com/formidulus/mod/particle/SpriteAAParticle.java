package com.formidulus.mod.particle;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

public abstract class SpriteAAParticle extends TextureSheetParticle {
   protected final SpriteSet spriteProvider;
   protected Vec3 scale3d;

   protected SpriteAAParticle(ClientLevel world, double x, double y, double z, SpriteSet spriteProvider) {
      super(world, x, y, z);
      float s = 0.1F * (this.random.nextFloat() * 0.5F + 0.5F) * 2.0F;
      this.scale3d = new Vec3((double)s, (double)s, (double)s);
      this.spriteProvider = spriteProvider;
      this.sprite = spriteProvider.get(this.random);
   }

   public void render(VertexConsumer vertexConsumer, Camera camera, float tickDelta) {
      Vec3 camPos = camera.getPosition();
      Vec3 dir = new Vec3(this.x, this.y, this.z).subtract(camPos).normalize();
      float f = (float)(Mth.lerp((double)tickDelta, this.xo, this.x) - camPos.x());
      float g = (float)(Mth.lerp((double)tickDelta, this.yo, this.y) - camPos.y());
      float h = (float)(Mth.lerp((double)tickDelta, this.zo, this.z) - camPos.z());
      Vector3f[] Vectors = new Vector3f[]{
         new Vector3f(-1.0F, -1.0F, 0.0F), new Vector3f(-1.0F, 1.0F, 0.0F), new Vector3f(1.0F, 1.0F, 0.0F), new Vector3f(1.0F, -1.0F, 0.0F)
      };

      for (int k = 0; k < 4; k++) {
         Vector3f vec = Vectors[k];
         vec = vec.rotateY((float)Math.atan2(dir.x, dir.z));
         vec = vec.mul((float)this.scale3d.x(), (float)this.scale3d.y(), (float)this.scale3d.z());
         Vectors[k] = vec.add(f, g, h);
      }

      int n = this.getLightColor(tickDelta);
      vertexConsumer.addVertex(Vectors[0].x, Vectors[0].y, Vectors[0].z)
         .setUv(this.getU1(), this.getV1())
         .setColor(this.rCol, this.gCol, this.bCol, this.alpha)
         .setLight(n);
      vertexConsumer.addVertex(Vectors[1].x, Vectors[1].y, Vectors[1].z)
         .setUv(this.getU1(), this.getV0())
         .setColor(this.rCol, this.gCol, this.bCol, this.alpha)
         .setLight(n);
      vertexConsumer.addVertex(Vectors[2].x, Vectors[2].y, Vectors[2].z)
         .setUv(this.getU0(), this.getV0())
         .setColor(this.rCol, this.gCol, this.bCol, this.alpha)
         .setLight(n);
      vertexConsumer.addVertex(Vectors[3].x, Vectors[3].y, Vectors[3].z)
         .setUv(this.getU0(), this.getV1())
         .setColor(this.rCol, this.gCol, this.bCol, this.alpha)
         .setLight(n);
   }
}
