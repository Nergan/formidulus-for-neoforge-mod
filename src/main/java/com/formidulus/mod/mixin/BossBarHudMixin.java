package com.formidulus.mod.mixin;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.accessor.BossBarAccessor;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.BossHealthOverlay;
import net.minecraft.client.gui.components.LerpingBossEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.BossEvent.BossBarOverlay;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({BossHealthOverlay.class})
public abstract class BossBarHudMixin {
   @Shadow
   @Final
   Map<UUID, LerpingBossEvent> events;
   @Shadow
   @Final
   private Minecraft minecraft;
   @Unique
   private static final ResourceLocation TEXTURE = Formidulus.identifier("textures/gui/deer_bossbar.png");
   @Unique
   private static final RandomSource RANDOM = RandomSource.create();

   @Shadow
   protected abstract void drawBar(GuiGraphics var1, int var2, int var3, BossEvent var4);

   @Inject(
      method = {"render(Lnet/minecraft/client/gui/GuiGraphics;)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   void onRenderBossBar(GuiGraphics context, CallbackInfo ci) {
      BossBarOverlay deerStyle = BossBarOverlay.NOTCHED_20;
      if (!this.events.values().stream().noneMatch(i -> i.getOverlay().equals(deerStyle))) {
         PoseStack matrices = context.pose();
         int center = context.guiWidth() / 2;
         int y = 12;

         for (LerpingBossEvent bar : this.events.values()) {
            if (bar.getOverlay().equals(deerStyle)) {
               matrices.pushPose();
               matrices.translate((float)center, 9.0F, 0.0F);
               float shake = 0.0F;
               if (bar instanceof BossBarAccessor barr) {
                  barr.formidulus$update(0.02F);
                  shake = barr.formidulus$getDeltaPercent() * 25.0F;
               }

               context.blit(TEXTURE, -91, y - 9, 0.0F, 0.0F, 182, 9, 182, 27);
               matrices.pushPose();
               if (shake > 1.0F && bar.getProgress() < 0.5F) {
                  matrices.translate((RANDOM.nextFloat() - 0.5F) * shake, (RANDOM.nextFloat() - 0.5F) * shake, 0.0F);
               }

               context.blit(TEXTURE, -84, y - 9, 7.0F, 9.0F, Math.round(168.0F * Math.min(bar.getProgress() * 2.0F, 1.0F)), 9, 182, 27);
               if (shake > 1.0F) {
                  matrices.translate((RANDOM.nextFloat() - 0.5F) * shake, (RANDOM.nextFloat() - 0.5F) * shake, 0.0F);
               }

               context.blit(TEXTURE, -84, y - 9, 7.0F, 18.0F, Math.round(168.0F * (bar.getProgress() * 2.0F - 1.0F)), 9, 182, 27);
               matrices.popPose();
               matrices.popPose();
               Component t = bar.getName();
               context.drawString(this.minecraft.font, t, center - this.minecraft.font.width(t) / 2 - 1, y - 9, -65536, false);
               context.drawString(this.minecraft.font, t, center - this.minecraft.font.width(t) / 2 + 1, y - 9, -65536, false);
               context.drawString(this.minecraft.font, t, center - this.minecraft.font.width(t) / 2, y - 9 - 1, -65536, false);
               context.drawString(this.minecraft.font, t, center - this.minecraft.font.width(t) / 2, y - 9 + 1, -65536, false);
               context.drawString(this.minecraft.font, t, center - this.minecraft.font.width(t) / 2, y - 9, -16777216, false);
               y += 21;
               if (y > context.guiHeight() / 3) {
                  break;
               }
            } else {
               this.drawBar(context, center - 91, y, bar);
               Component t = bar.getName();
               context.drawString(this.minecraft.font, t, center - this.minecraft.font.width(t) / 2, y - 9, -1);
               y += 10 + 9;
               if (y > context.guiHeight() / 3) {
                  break;
               }
            }
         }

         ci.cancel();
      }
   }
}
