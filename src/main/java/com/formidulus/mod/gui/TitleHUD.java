package com.formidulus.mod.gui;

import com.formidulus.mod.compat.TrinketsUtil;
import com.formidulus.mod.registries.ItemRegistry;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayDeque;
import java.util.Queue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.util.FastColor.ARGB32;

public class TitleHUD {
   static RandomSource rand = RandomSource.create();
   static boolean forceDelete;
   static float delay;
   static TitleHUD.TextObject activeTextObject;
   static TitleHUD.TextObject lastTextObject = new TitleHUD.TextObject(null).color(16777215).typeSpeed(30.0F).displayDuration(5.0F).deleteSpeed(100.0F);
   static Queue<TitleHUD.TextObject> textQueue = new ArrayDeque<>();
   static String targetText = "";
   static String curText = "";

   public static void render(GuiGraphics context, float delta) {
      Screen screen = Minecraft.getInstance().screen;
      if (screen == null || !screen.isPauseScreen()) {
         int width = context.guiWidth();
         int height = context.guiHeight();
         PoseStack matrices = context.pose();
         Font renderer = Minecraft.getInstance().font;
         if (activeTextObject == null && !textQueue.isEmpty()) {
            activeTextObject = textQueue.poll().complete(lastTextObject);
            targetText = activeTextObject.text().getString();
            delay = activeTextObject.delay();
         }

         if (activeTextObject != null) {
            if (delay <= 0.0F) {
               int curLength = curText.length();
               int targetLength = targetText.length();
               if (curLength > 0 && (targetLength < curLength || forceDelete)) {
                  curText = curText.substring(0, curLength - 1);
                  delay = delay + 10.0F / activeTextObject.deleteSpeed();
                  if (curLength - 1 == 0) {
                     lastTextObject = activeTextObject;
                     activeTextObject = null;
                     return;
                  }
               } else if (targetLength > curLength) {
                  if (forceDelete) {
                     forceDelete = false;
                  }

                  curText = targetText.substring(0, curLength + 1);
                  delay = delay + 10.0F / activeTextObject.typeSpeed() + (rand.nextFloat() - 0.5F) * activeTextObject.instability();
                  if (curLength + 1 == targetLength) {
                     delay = delay + activeTextObject.displayDuration();
                  }
               }
            }

            if (targetText.length() - curText.length() != 0 || delay > 0.0F) {
               delay -= delta / 10.0F;
            } else if (!targetText.isEmpty() && delay <= 0.0F) {
               forceDelete = true;
               delay = activeTextObject.displayDuration();
               targetText = "";
            }

            if (!curText.isEmpty()) {
               matrices.pushPose();
               matrices.translate((float)width / 2.0F, (float)(height - 74), 10.0F);
               matrices.scale(2.0F, 2.0F, 2.0F);
               RenderSystem.enableBlend();
               Component t = Component.nullToEmpty(curText);
               if (activeTextObject.font() != null && !TrinketsUtil.isHasTrinketEquipped(Minecraft.getInstance().player, ItemRegistry.DEER_NECKLACE)) {
                  t = (Component)t.toFlatList(Style.EMPTY.withFont(activeTextObject.font())).getFirst();
               }

               context.drawString(renderer, t, -renderer.width(t) / 2, 0, activeTextObject.color(), false);
               if (activeTextObject.jitter()) {
                  for (int i = 1; i < 3; i++) {
                     matrices.pushPose();
                     matrices.translate((rand.nextFloat() - 0.5F) * (float)i, (rand.nextFloat() - 0.5F) * (float)i, (float)(-i));
                     context.drawString(
                        renderer,
                        t,
                        -renderer.width(t) / 2,
                        0,
                        ARGB32.colorFromFloat(1.0F / (float)i, Math.max(1.0F - 0.2F * (float)i, 0.25F), 0.0F, 0.1F * (float)i + (float)(i - 1) * 0.3F),
                        false
                     );
                     matrices.popPose();
                  }
               }

               matrices.popPose();
            }
         }
      }
   }

   public static TitleHUD.TextObject makeTextObject(String text) {
      return new TitleHUD.TextObject(Component.translatable(text));
   }

   public static void queueTitle(TitleHUD.TextObject text) {
      if (text.clearPreceding) {
         textQueue.clear();
         if (!curText.isEmpty()) {
            forceDelete = true;
         }

         delay = 0.0F;
      }

      textQueue.add(text);
   }

   public static final class TextObject {
      final Component text;
      float delay = 0.0F;
      float instability = 0.0F;
      float typeSpeed = -1.0F;
      float displayDuration = -1.0F;
      float deleteSpeed = -1.0F;
      int color = -1;
      ResourceLocation font = null;
      boolean jitter;
      boolean clearPreceding;

      public TextObject(Component text) {
         this.text = text;
      }

      public Component text() {
         return this.text;
      }

      public float typeSpeed() {
         return this.typeSpeed;
      }

      public TitleHUD.TextObject typeSpeed(float f) {
         this.typeSpeed = Math.max(f, 1.0F);
         return this;
      }

      public float displayDuration() {
         return this.displayDuration;
      }

      public TitleHUD.TextObject displayDuration(float f) {
         this.displayDuration = Math.max(f, 0.0F);
         return this;
      }

      public float deleteSpeed() {
         return this.deleteSpeed;
      }

      public TitleHUD.TextObject deleteSpeed(float f) {
         this.deleteSpeed = Math.max(f, 1.0F);
         return this;
      }

      public float delay() {
         return this.delay;
      }

      public TitleHUD.TextObject delay(float f) {
         this.delay = f;
         return this;
      }

      public float instability() {
         return this.instability;
      }

      public TitleHUD.TextObject instability(float f) {
         this.instability = f;
         return this;
      }

      public int color() {
         return this.color;
      }

      public TitleHUD.TextObject color(int c) {
         this.color = c;
         return this;
      }

      public ResourceLocation font() {
         return this.font;
      }

      public TitleHUD.TextObject font(ResourceLocation id) {
         this.font = id;
         return this;
      }

      public boolean jitter() {
         return this.jitter;
      }

      public TitleHUD.TextObject jitter(boolean b) {
         this.jitter = b;
         return this;
      }

      public boolean clearPreceding() {
         return this.clearPreceding;
      }

      public TitleHUD.TextObject clearPreceding(boolean b) {
         this.clearPreceding = b;
         return this;
      }

      public TitleHUD.TextObject complete(TitleHUD.TextObject previous) {
         if (this.typeSpeed == -1.0F) {
            this.typeSpeed(previous.typeSpeed());
         }

         if (this.displayDuration == -1.0F) {
            this.displayDuration(previous.displayDuration());
         }

         if (this.deleteSpeed == -1.0F) {
            this.deleteSpeed(previous.deleteSpeed());
         }

         if (this.color == -1) {
            this.color(previous.color());
         }

         return this;
      }
   }
}
