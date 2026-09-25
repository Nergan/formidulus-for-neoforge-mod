package com.formidulus.mod.rendering.entity;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.FormidulusClient;
import com.formidulus.mod.entities.IrrlichtEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

public class IrrlichtRenderer extends MobRenderer<IrrlichtEntity, IrrlichtModel> {
   public IrrlichtRenderer(Context ctx) {
      super(ctx, new IrrlichtModel(ctx.bakeLayer(FormidulusClient.IRRLICHT_LAYER)), 0.1F);
   }

   public ResourceLocation getTextureLocation(IrrlichtEntity entity) {
      return Formidulus.identifier("textures/entity/irrlicht_" + (entity.tickCount / 5 % 6 + 1) + ".png");
   }

   protected int getBlockLight(IrrlichtEntity entity, BlockPos pos) {
      return 15;
   }
}
