package com.formidulus.mod.mixin;

import com.formidulus.mod.FormidulusClient;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.MusicManager;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({MusicManager.class})
public abstract class MusicTrackerMixin {
   @Shadow
   @Nullable
   private SoundInstance currentMusic;

   @Shadow
   public abstract void stopPlaying();

   @Inject(
      method = {"tick()V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   void onTick(CallbackInfo ci) {
      if (FormidulusClient.bossMusicHandler != null && FormidulusClient.bossMusicHandler.isPlayingMusic()) {
         if (this.currentMusic != null) {
            this.stopPlaying();
         }

         ci.cancel();
      }
   }
}
