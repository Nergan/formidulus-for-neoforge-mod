package com.formidulus.mod.sound;

import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance.Attenuation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

public class FadingMusicInstance extends SimpleSoundInstance implements TickableSoundInstance {
   boolean active;
   float fadeIn;
   float fadeOut;

   public FadingMusicInstance(SoundEvent sound, float fadeIn, float fadeOut, boolean loop) {
      super(sound.getLocation(), SoundSource.MUSIC, 0.01F, 1.0F, SoundInstance.createUnseededRandom(), loop, 0, Attenuation.NONE, 0.0, 0.0, 0.0, true);
      this.fadeIn = fadeIn;
      this.fadeOut = fadeOut;
   }

   public void setFullVolume() {
      this.volume = 1.0F;
      this.active = true;
   }

   public void startFadeIn() {
      this.volume = 0.01F;
      this.active = true;
   }

   public void startFadeOut() {
      this.active = false;
   }

   public void stopImmediately() {
      this.active = false;
      this.volume = 0.0F;
   }

   public void tick() {
      if (this.active && this.volume < 1.0F) {
         this.volume = Math.min(this.fadeIn <= 0.0F ? 1.0F : this.volume + 0.05F / this.fadeIn, 1.0F);
      }

      if (!this.active && this.volume > 0.0F) {
         this.volume = Math.max(this.fadeOut <= 0.0F ? 0.0F : this.volume - 0.05F / this.fadeOut, 0.0F);
      }
   }

   public boolean isStopped() {
      return !this.active && this.volume <= 0.0F;
   }
}
