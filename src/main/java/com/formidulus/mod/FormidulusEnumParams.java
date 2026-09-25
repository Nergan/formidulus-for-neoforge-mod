package com.formidulus.mod;

import com.formidulus.mod.registries.SoundRegistry;
import java.util.function.Supplier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageEffects;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

public final class FormidulusEnumParams {
   public static final EnumProxy<DamageEffects> LANTERN = new EnumProxy<>(
      DamageEffects.class, "formidulus:lantern", (Supplier<SoundEvent>)() -> SoundRegistry.LANTERN_DAMAGE
   );
   public static final EnumProxy<DamageEffects> CLAW = new EnumProxy<>(
      DamageEffects.class, "formidulus:claw", (Supplier<SoundEvent>)() -> SoundRegistry.CLAW_DAMAGE
   );

   private FormidulusEnumParams() {
   }
}
