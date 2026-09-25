package com.formidulus.mod.sound;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.entities.boss.BossType;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.resources.ResourceLocation;

public class BossMusicHandler {
   static SoundManager manager;
   BossMusicEntry last;
   BossMusicEntry current;
   BossMusicEntry next;
   int introTicks;
   int outroTicks;
   int outroDelayTicks;
   boolean playIntro;
   boolean playOutro;
   boolean stopping;
   boolean late;
   boolean noOutro;
   boolean noFade;
   boolean startedOutro;
   List<SimpleSoundInstance> soundInstances = new ArrayList<>();
   FadingMusicInstance mainInstance;
   FadingMusicInstance introInstance;
   FadingMusicInstance outroInstance;

   public void startTrack(ResourceLocation bossId, String musicKey, boolean late) {
      this.late = late;
      if (late) {
         this.introTicks = 0;
      }

      try {
         BossType type = BossType.fromId(bossId);
         if (type == null) {
            return;
         }

         if (type.fight().getMethod("getMusicEntry", String.class).invoke(null, musicKey) instanceof BossMusicEntry musicEntry) {
            if (!musicEntry.equals(this.current)) {
               this.next = musicEntry;
            }
         } else {
            Formidulus.LOGGER.warn("BossMusicHandler -> Received invalid musicKey; '{}' does not exist in '{}'s fight class!", musicKey, bossId);
         }
      } catch (NoSuchMethodException var7) {
         Formidulus.LOGGER.warn("BossMusicHandler -> Couldn't find 'getMusicEntry' in BossType '{}'s fight class!", bossId, var7);
      } catch (Exception var8) {
         Formidulus.LOGGER.warn("BossMusicHandler -> Something went wrong trying to get musicEntry from '{}'s fight class!", bossId, var8);
      }
   }

   public void stopCurrentTrack() {
      this.stopping = true;
   }

   public void stopCurrentTrackNoOutro() {
      this.stopping = true;
      this.noOutro = true;
   }

   public void stopCurrentTrackNoFade() {
      this.stopping = true;
      this.noFade = true;
      this.noOutro = false;
   }

   public void tick() {
      if (manager == null) {
         manager = Minecraft.getInstance().getSoundManager();
      } else {
         if (this.introTicks > 0) {
            this.introTicks--;
         }

         if (this.outroTicks > 0) {
            this.outroTicks--;
         }

         if (this.stopping && !this.playOutro) {
            if (!this.startedOutro) {
               if (this.mainInstance != null) {
                  if (this.noFade) {
                     this.mainInstance.stopImmediately();
                     this.noFade = false;
                  } else {
                     this.mainInstance.startFadeOut();
                  }
               }

               if (this.introTicks > 0) {
                  if (this.introInstance != null) {
                     if (this.noFade) {
                        this.introInstance.stopImmediately();
                        this.noFade = false;
                     } else {
                        this.introInstance.startFadeOut();
                     }
                  }

                  this.introTicks = 0;
               }

               this.startedOutro = true;
            }

            if (!this.noOutro && this.current != null && this.current.hasOutro()) {
               if (this.outroDelayTicks <= 0) {
                  this.playOutro = true;
               } else {
                  this.outroDelayTicks--;
               }
            } else {
               this.current = null;
               this.stopping = false;
               this.noOutro = false;
            }
         } else if (this.introTicks > 0) {
            if (this.next != null) {
               this.playIntro = false;
               this.introInstance.startFadeOut();
               this.introTicks = 0;
            }
         } else if (this.outroTicks <= 0) {
            if (this.current != null) {
               if (this.playIntro) {
                  if (this.next == null) {
                     this.mainInstance.startFadeIn();
                     manager.play(this.mainInstance);
                  }

                  this.playIntro = false;
                  return;
               }

               if (this.playOutro) {
                  this.outroInstance.setFullVolume();
                  manager.play(this.outroInstance);
                  this.outroTicks = this.current.outroTicks;
                  this.playOutro = false;
                  this.last = this.current;
                  this.current = null;
                  return;
               }
            }

            if (this.next != null) {
               if (this.playIntro) {
                  this.playIntro = false;
               }

               this.current = this.next;
               this.mainInstance = new FadingMusicInstance(this.current.mainSound, this.current.fadeIn, this.current.fadeOut, true);
               this.next = null;
               if (!this.current.hasIntro() || this.current.skipIntroIfLate && this.late) {
                  this.mainInstance.startFadeIn();
                  manager.play(this.mainInstance);
                  if (this.late) {
                     this.late = false;
                  }
               } else {
                  this.introInstance = new FadingMusicInstance(this.current.introSound, 0.0F, this.current.fadeOut, false);
                  this.introInstance.setFullVolume();
                  manager.play(this.introInstance);
                  this.introTicks = this.current.introTicks;
                  this.playIntro = true;
               }

               if (this.current.hasOutro()) {
                  this.outroInstance = new FadingMusicInstance(this.current.outroSound, this.current.fadeIn, 0.0F, false);
               }

               this.outroDelayTicks = this.current.outroDelayTicks;
               this.startedOutro = false;
            }
         }
      }
   }

   public void cancelAll() {
      this.stopCurrentTrackNoOutro();
      this.next = null;
      this.outroDelayTicks = 0;
   }

   public void stopAll() {
      this.soundInstances.forEach(manager::stop);
      this.soundInstances.clear();
      this.last = this.current = this.next = null;
      this.introTicks = this.outroTicks = this.outroDelayTicks = 0;
   }

   public boolean isPlayingMusic() {
      return this.current != null || this.next != null;
   }
}
