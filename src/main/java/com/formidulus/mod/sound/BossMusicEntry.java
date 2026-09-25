package com.formidulus.mod.sound;

import net.minecraft.sounds.SoundEvent;

public class BossMusicEntry {
   protected final SoundEvent mainSound;
   protected final float fadeIn;
   protected final float fadeOut;
   SoundEvent introSound;
   SoundEvent outroSound;
   boolean intro;
   boolean outro;
   boolean skipIntroIfLate;
   int introTicks;
   int outroTicks;
   int outroDelayTicks;

   public BossMusicEntry(SoundEvent mainSound, float fadeIn, float fadeOut) {
      this.mainSound = mainSound;
      this.fadeIn = fadeIn;
      this.fadeOut = fadeOut;
   }

   public BossMusicEntry withIntro(SoundEvent sound, int lengthMs) {
      return this.withIntro(sound, lengthMs, true);
   }

   public BossMusicEntry withIntro(SoundEvent sound, int lengthMs, boolean skipIfLate) {
      this.introSound = sound;
      this.intro = true;
      this.skipIntroIfLate = skipIfLate;
      this.introTicks = this.millisecondsToTicks(lengthMs);
      return this;
   }

   public boolean hasIntro() {
      return this.intro;
   }

   public BossMusicEntry withOutro(SoundEvent sound, int lengthMs) {
      this.outroSound = sound;
      this.outro = true;
      this.outroTicks = this.millisecondsToTicks(lengthMs);
      return this;
   }

   public BossMusicEntry withOutroDelay(int delayMs) {
      this.outroDelayTicks = this.millisecondsToTicks(delayMs);
      return this;
   }

   public boolean hasOutro() {
      return this.outro;
   }

   int millisecondsToTicks(int milliseconds) {
      return Math.round((float)milliseconds / 50.0F);
   }
}
