package com.formidulus.mod.registries;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.effects.DarknessStatusEffect;
import com.formidulus.mod.effects.ReverenceStatusEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;

public class StatusEffectRegistry {
   public static final Holder<MobEffect> REVERENCE = Registry.registerForHolder(
      BuiltInRegistries.MOB_EFFECT,
      Formidulus.identifier("reverence"),
      new ReverenceStatusEffect()
         .addAttributeModifier(Attributes.MOVEMENT_SPEED, Formidulus.identifier("effect.reverence"), -0.5, Operation.ADD_MULTIPLIED_TOTAL)
   );
   public static final Holder<MobEffect> DARKNESS = Registry.registerForHolder(
      BuiltInRegistries.MOB_EFFECT, Formidulus.identifier("darkness"), new DarknessStatusEffect()
   );

   public static void register() {
   }
}
