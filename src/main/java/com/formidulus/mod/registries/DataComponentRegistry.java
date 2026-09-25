package com.formidulus.mod.registries;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.item.components.AbilityComponent;
import com.formidulus.mod.item.components.AccessoryComponent;
import com.formidulus.mod.item.components.ChargeComponent;
import com.formidulus.mod.item.components.DamageTypeComponent;
import com.formidulus.mod.item.components.DependencyInfoComponent;
import com.formidulus.mod.item.components.ExpandableLoreComponent;
import java.util.function.UnaryOperator;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponentType.Builder;
import net.minecraft.core.registries.BuiltInRegistries;

public class DataComponentRegistry {
   public static final DataComponentType<AccessoryComponent> ACCESSORY = register(
      "accessory", builder -> builder.persistent(AccessoryComponent.CODEC).networkSynchronized(AccessoryComponent.PACKET_CODEC)
   );
   public static final DataComponentType<ExpandableLoreComponent> EXPANDABLE_LORE = register(
      "expandable_lore", builder -> builder.persistent(ExpandableLoreComponent.CODEC).networkSynchronized(ExpandableLoreComponent.PACKET_CODEC)
   );
   public static final DataComponentType<DamageTypeComponent> DAMAGE_TYPE = register(
      "damage_type", builder -> builder.persistent(DamageTypeComponent.CODEC).networkSynchronized(DamageTypeComponent.PACKET_CODEC)
   );
   public static final DataComponentType<AbilityComponent> ABILITY = register(
      "ability", builder -> builder.persistent(AbilityComponent.CODEC).networkSynchronized(AbilityComponent.PACKET_CODEC)
   );
   public static final DataComponentType<ChargeComponent> CHARGE = register(
      "charge", builder -> builder.persistent(ChargeComponent.CODEC).networkSynchronized(ChargeComponent.PACKET_CODEC)
   );
   public static final DataComponentType<DependencyInfoComponent> DEPENDENCY_INFO = register(
      "dependency_info", builder -> builder.persistent(DependencyInfoComponent.CODEC).networkSynchronized(DependencyInfoComponent.PACKET_CODEC)
   );

   public static void register() {
   }

   static <T> DataComponentType<T> register(String id, UnaryOperator<Builder<T>> builder) {
      return (DataComponentType<T>)Registry.register(
         BuiltInRegistries.DATA_COMPONENT_TYPE, Formidulus.identifier(id), builder.apply(DataComponentType.builder()).build()
      );
   }
}
