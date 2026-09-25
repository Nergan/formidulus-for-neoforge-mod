package com.formidulus.mod.gui.screen;

import net.neoforged.neoforge.network.PacketDistributor;
import com.formidulus.mod.Formidulus;
import com.formidulus.mod.block.BossSpawnerBlockEntity;
import com.formidulus.mod.datagen.Lang;
import com.formidulus.mod.entities.boss.BossType;
import com.formidulus.mod.network.ModifyBossSpawnerPayload;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ObjectSelectionList;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;

public class BossSpawnerScreen extends Screen implements Lang {
   BossSpawnerScreen.BossTypeList typeList;
   BossSpawnerScreen.NumberField numberField;
   final BlockPos pos;
   int respawnDelay;
   BossType bossType;

   public BossSpawnerScreen(BossSpawnerBlockEntity spawner) {
      super(Component.translatable(SCREEN_BOSS_SPAWNER_TITLE));
      this.pos = spawner.getBlockPos();
      this.respawnDelay = spawner.getRespawnDelay();
      this.bossType = spawner.getBossType();
   }

   protected void init() {
      super.init();
      if (this.minecraft != null) {
         int y = this.height / 15 + 1;
         if (this.numberField == null) {
            this.numberField = new BossSpawnerScreen.NumberField(
               this.minecraft.font, this.width / 2 - 100, this.height / 2 - 132, 200, 20, Component.nullToEmpty(String.valueOf(this.respawnDelay))
            );
         }

         this.numberField.setPosition(this.width / 2 - 100, y);
         this.addRenderableWidget(this.numberField);
         if (this.typeList == null) {
            this.typeList = new BossSpawnerScreen.BossTypeList(this.minecraft, 200, this.height / 3 * 2, this.height / 2 - 96, 22, this.bossType);
         }

         int var2;
         this.typeList.setPosition(this.width / 2 - 100, var2 = y + 37);
         this.typeList.setHeight(this.height - var2 - 42);
         this.addRenderableWidget(this.typeList);
         this.addRenderableWidget(
            Button.builder(Component.translatable(SCREEN_BOSS_SPAWNER_CLOSE), i -> this.onClose())
               .bounds(this.width / 2 - 100, this.height - 32, 200, 20)
               .build()
         );
      }
   }

   public void render(GuiGraphics context, int mouseX, int mouseY, float delta) {
      super.render(context, mouseX, mouseY, delta);
      PoseStack matices = context.pose();
      matices.pushPose();
      matices.translate((double)((float)this.width / 2.0F - 100.0F), Math.floor((double)((float)this.height / 15.0F)) - 9.0, 0.0);
      context.drawString(this.font, Component.translatable(SCREEN_BOSS_SPAWNER_RESPAWN_DELAY), 0, 0, 16777215, true);
      matices.translate(0.0F, 35.0F, 0.0F);
      context.drawString(this.font, Component.translatable(SCREEN_BOSS_SPAWNER_BOSS_TYPE), 0, 0, 16777215, true);
      matices.popPose();
   }

   public void onClose() {
      super.onClose();
      BossSpawnerScreen.BossTypeList.Entry typeEntry = (BossSpawnerScreen.BossTypeList.Entry)this.typeList.getSelected();
      PacketDistributor.sendToServer(
         new ModifyBossSpawnerPayload(this.pos, typeEntry != null ? typeEntry.value.id() : this.bossType.id(), this.numberField.getNumber())
      );
   }

   static class BossTypeList extends ObjectSelectionList<BossSpawnerScreen.BossTypeList.Entry> {
      public BossTypeList(Minecraft minecraftClient, int width, int height, int y, int itemHeight, BossType selected) {
         super(minecraftClient, width, height, y, itemHeight);

         for (BossType type : BossType.getAllTypes().values()) {
            BossSpawnerScreen.BossTypeList.Entry e = new BossSpawnerScreen.BossTypeList.Entry(this.minecraft, type);
            this.addEntry(e);
            if (type.equals(selected)) {
               this.setSelected(e);
            }
         }
      }

      public int getRowWidth() {
         return this.width;
      }

      static class Entry extends net.minecraft.client.gui.components.ObjectSelectionList.Entry<BossSpawnerScreen.BossTypeList.Entry> {
         final Minecraft client;
         final BossType value;
         final Component label;

         Entry(Minecraft client, BossType value) {
            this.value = value;
            this.label = Component.translationArg(value.id());
            this.client = client;
         }

         public Component getNarration() {
            return this.label;
         }

         public void render(
            GuiGraphics context, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta
         ) {
            context.enableScissor(x, y, x + entryWidth - 1, y + entryWidth - 1);
            context.drawString(this.client.font, this.label, x + 2, y + (int)((float)entryHeight / 2.0F - 4.0F), hovered ? 16777215 : 8947848, true);
            context.disableScissor();
         }
      }
   }

   static class NumberField extends EditBox {
      public NumberField(Font textRenderer, int x, int y, int width, int height, Component text) {
         super(textRenderer, x, y, width, height, text);
         this.setValue(text.getString());
         this.setHint(Component.translatable(Lang.SCREEN_BOSS_SPAWNER_RESPAWN_DELAY));
      }

      public boolean charTyped(char chr, int modifiers) {
         return Character.isDigit(chr) ? super.charTyped(chr, modifiers) : false;
      }

      public int getNumber() {
         if (this.getValue().isEmpty()) {
            return 0;
         } else {
            try {
               return Integer.parseInt(this.getValue());
            } catch (NumberFormatException var2) {
               Formidulus.LOGGER.error("Failed to parse int for Boss Spawner Respawn Delay", var2);
               return 12000;
            }
         }
      }
   }
}
