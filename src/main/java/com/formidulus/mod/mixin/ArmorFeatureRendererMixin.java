package com.formidulus.mod.mixin;

import com.formidulus.mod.compat.TrinketsUtil;
import com.formidulus.mod.item.components.AccessoryComponent;
import com.formidulus.mod.registries.DataComponentRegistry;
import com.formidulus.mod.registries.ItemRegistry;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({HumanoidArmorLayer.class})
public abstract class ArmorFeatureRendererMixin<T extends LivingEntity, M extends HumanoidModel<T>, A extends HumanoidModel<T>> extends RenderLayer<T, M> {
   public ArmorFeatureRendererMixin(RenderLayerParent<T, M> context) {
      super(context);
   }

   @WrapOperation(
      method = {"render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/LivingEntity;FFFFFF)V"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/entity/layers/HumanoidArmorLayer;renderArmorPiece(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/EquipmentSlot;ILnet/minecraft/client/model/HumanoidModel;)V"
      )}
   )
   void wrapRenderArmor(
      HumanoidArmorLayer<T, M, A> instance,
      PoseStack matrices,
      MultiBufferSource vertexConsumers,
      T entity,
      EquipmentSlot armorSlot,
      int light,
      A model,
      Operation<Void> original
   ) {
      if (armorSlot.equals(EquipmentSlot.HEAD)) {
         boolean cancelHelmetRender = TrinketsUtil.performIfPresent(entity, ItemRegistry.DEER_SKULL, stack -> {
            AccessoryComponent accessory = (AccessoryComponent)stack.getComponents().get(DataComponentRegistry.ACCESSORY);
            return accessory != null && accessory.modes().get(accessory.activeMode()).equals("mask");
         });
         if (!cancelHelmetRender) {
            cancelHelmetRender = TrinketsUtil.isHasTrinketEquipped(entity, ItemRegistry.JOLLY_HAT);
         }

         if (cancelHelmetRender) {
            return;
         }
      }

      original.call(new Object[]{instance, matrices, vertexConsumers, entity, armorSlot, light, model});
   }
}
