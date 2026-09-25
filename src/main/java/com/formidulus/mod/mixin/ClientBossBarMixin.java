package com.formidulus.mod.mixin;

import com.formidulus.mod.accessor.BossBarAccessor;
import java.util.UUID;
import net.minecraft.client.gui.components.LerpingBossEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.BossEvent.BossBarOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({LerpingBossEvent.class})
public abstract class ClientBossBarMixin implements BossBarAccessor {
   @Unique
   float deltaPercent;

   @Shadow
   public abstract float getProgress();

   @Inject(
      method = {"<init>(Ljava/util/UUID;Lnet/minecraft/network/chat/Component;FLnet/minecraft/world/BossEvent$BossBarColor;Lnet/minecraft/world/BossEvent$BossBarOverlay;ZZZ)V"},
      at = {@At("TAIL")}
   )
   void onInit(
      UUID uuid,
      Component name,
      float percent,
      BossBarColor color,
      BossBarOverlay style,
      boolean darkenSky,
      boolean dragonMusic,
      boolean thickenFog,
      CallbackInfo ci
   ) {
      this.deltaPercent = percent;
   }

   @Override
   public float formidulus$getDeltaPercent() {
      return Math.abs(this.deltaPercent - this.getProgress());
   }

   @Override
   public void formidulus$update(float delta) {
      this.deltaPercent = Mth.lerp(delta, this.deltaPercent, this.getProgress());
   }
}
