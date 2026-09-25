package com.formidulus.mod.entities.boss;

import net.neoforged.neoforge.network.PacketDistributor;
import com.formidulus.mod.entities.BossEntity;
import com.formidulus.mod.network.BossMusicUpdatePayload;
import com.formidulus.mod.network.SequenceTriggerPayload;
import com.formidulus.mod.registries.SoundRegistry;
import com.formidulus.mod.sound.BossMusicEntry;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;

public class DeerBossFight extends BossFight {
   public DeerBossFight(BossEntity entity, UUID id) {
      super(entity, id);
   }

   @Override
   public void leaveFight(ServerPlayer player) {
      if (!this.playerWin) {
         PacketDistributor.sendToPlayer(player, new SequenceTriggerPayload((byte)3));
      }

      super.leaveFight(player);
   }

   @Override
   public void markWon() {
      super.markWon();
      this.participants.forEach(p -> PacketDistributor.sendToPlayer(p, new BossMusicUpdatePayload(this.type.id(), "end")));
   }

   public static void init() {
   }

   static {
      bossMusic.put("phase1", new BossMusicEntry(SoundRegistry.MUSIC_DEER_PHASE1, 0.0F, 2.0F).withIntro(SoundRegistry.MUSIC_DEER_INTRO, 67011, true));
      bossMusic.put(
         "phase2",
         new BossMusicEntry(SoundRegistry.MUSIC_DEER_PHASE2, 0.0F, 2.0F)
            .withIntro(SoundRegistry.MUSIC_DEER_PHASE2_INTRO, 16470)
            .withOutro(SoundRegistry.MUSIC_DEER_OUTRO, 15944)
            .withOutroDelay(950)
      );
   }
}
