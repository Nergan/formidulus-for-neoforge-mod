package com.formidulus.mod.mixin;

import com.formidulus.mod.components.FormidableComponents;
import com.formidulus.mod.components.entity.IBulwarkComponent;
import com.formidulus.mod.item.abilities.ItemAbilities;
import com.formidulus.mod.item.abilities.ItemAbility;
import com.formidulus.mod.registries.ItemRegistry;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ItemInHandLayer.class})
public abstract class HeldItemRendererMixin<T extends LivingEntity, M extends EntityModel<T> & ArmedModel> extends RenderLayer<T, M> {
   public HeldItemRendererMixin(RenderLayerParent<T, M> context) {
      super(context);
   }

   @Inject(
      method = {"renderArmWithItem(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;Lnet/minecraft/world/entity/HumanoidArm;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/ItemInHandRenderer;renderItem(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;ZLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V"
      )},
      cancellable = true
   )
   void onRenderItem(
      LivingEntity entity,
      ItemStack stack,
      ItemDisplayContext transformationMode,
      HumanoidArm arm,
      PoseStack matrices,
      MultiBufferSource vertexConsumers,
      int light,
      CallbackInfo ci
   ) {
      if (ItemAbility.hasAbility(stack, ItemAbilities.BULWARK) && entity instanceof Player player) {
         IBulwarkComponent comp = FormidableComponents.bulwark(player);
         if (comp.hasBulwark()) {
            matrices.popPose();
            ci.cancel();
         }
      } else {
         if (stack.is(ItemRegistry.GREAT_LANTERN)) {
            matrices.mulPose(Axis.XP.rotationDegrees(-15.0F));
            matrices.translate(0.0, -0.35, -0.3);
         }
      }
   }
}
