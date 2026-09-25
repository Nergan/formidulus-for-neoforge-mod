package com.formidulus.mod.network;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.FormidulusClient;
import com.formidulus.mod.block.BossSpawnerBlockEntity;
import com.formidulus.mod.gui.TitleHUD;
import com.formidulus.mod.gui.screen.BossSpawnerScreen;
import com.formidulus.mod.item.abilities.ItemAbilities;
import com.formidulus.mod.item.abilities.ItemAbility;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class ClientPacketHandler {
   public static void sequence(SequenceTriggerPayload payload, net.neoforged.neoforge.network.handling.IPayloadContext context) {
            switch (payload.sequenceID()) {
               case 0:
                  TitleHUD.queueTitle(
                     TitleHUD.makeTextObject("dialogue.deer.intro1")
                        .color(0)
                        .jitter(true)
                        .font(Formidulus.FONT)
                        .typeSpeed(20.0F)
                        .displayDuration(5.0F)
                        .instability(0.7F)
                        .color(0)
                        .clearPreceding(true)
                  );
                  TitleHUD.queueTitle(
                     TitleHUD.makeTextObject("dialogue.deer.intro2")
                        .jitter(true)
                        .font(Formidulus.FONT)
                        .typeSpeed(50.0F)
                        .displayDuration(4.0F)
                        .instability(0.5F)
                  );
                  TitleHUD.queueTitle(TitleHUD.makeTextObject("dialogue.deer.intro3").jitter(true).font(Formidulus.FONT).typeSpeed(50.0F).displayDuration(4.0F));
                  TitleHUD.queueTitle(
                     TitleHUD.makeTextObject("dialogue.deer.intro4")
                        .jitter(true)
                        .font(Formidulus.FONT)
                        .typeSpeed(50.0F)
                        .displayDuration(4.0F)
                        .instability(0.5F)
                  );
                  break;
               case 1:
                  TitleHUD.queueTitle(
                     TitleHUD.makeTextObject("dialogue.deer.projectile1")
                        .color(0)
                        .jitter(true)
                        .font(Formidulus.FONT)
                        .typeSpeed(40.0F)
                        .instability(0.3F)
                        .displayDuration(3.0F)
                        .clearPreceding(true)
                  );
                  TitleHUD.queueTitle(
                     TitleHUD.makeTextObject("dialogue.deer.projectile2")
                        .jitter(true)
                        .font(Formidulus.FONT)
                        .typeSpeed(40.0F)
                        .instability(0.3F)
                        .displayDuration(3.0F)
                  );
                  break;
               case 2:
                  TitleHUD.queueTitle(
                     TitleHUD.makeTextObject("dialogue.deer.phase-transition1")
                        .color(0)
                        .jitter(true)
                        .font(Formidulus.FONT)
                        .typeSpeed(40.0F)
                        .instability(0.3F)
                        .displayDuration(6.0F)
                        .clearPreceding(true)
                  );
                  TitleHUD.queueTitle(
                     TitleHUD.makeTextObject("dialogue.deer.phase-transition2").jitter(true).font(Formidulus.FONT).typeSpeed(80.0F).displayDuration(6.0F)
                  );
                  TitleHUD.queueTitle(
                     TitleHUD.makeTextObject("dialogue.deer.phase-transition3")
                        .jitter(true)
                        .font(Formidulus.FONT)
                        .typeSpeed(80.0F)
                        .delay(1.0F)
                        .displayDuration(3.0F)
                  );
                  TitleHUD.queueTitle(
                     TitleHUD.makeTextObject("dialogue.deer.phase-transition4")
                        .jitter(true)
                        .font(Formidulus.FONT)
                        .typeSpeed(80.0F)
                        .delay(1.0F)
                        .displayDuration(3.0F)
                  );
                  TitleHUD.queueTitle(
                     TitleHUD.makeTextObject("dialogue.deer.phase-transition5")
                        .jitter(true)
                        .font(Formidulus.FONT)
                        .typeSpeed(50.0F)
                        .delay(2.0F)
                        .displayDuration(5.0F)
                  );
                  break;
               case 3:
                  TitleHUD.queueTitle(
                     TitleHUD.makeTextObject("dialogue.deer.player-death1")
                        .color(0)
                        .jitter(true)
                        .font(Formidulus.FONT)
                        .delay(5.0F)
                        .displayDuration(5.0F)
                        .clearPreceding(true)
                  );
                  break;
               case 5:
                  TitleHUD.queueTitle(
                     TitleHUD.makeTextObject("dialogue.deer.death1")
                        .color(0)
                        .jitter(true)
                        .font(Formidulus.FONT)
                        .delay(1.0F)
                        .typeSpeed(40.0F)
                        .displayDuration(4.0F)
                        .clearPreceding(true)
                  );
                  TitleHUD.queueTitle(TitleHUD.makeTextObject("dialogue.deer.death2").jitter(true).font(Formidulus.FONT).typeSpeed(30.0F).displayDuration(5.0F));
                  TitleHUD.queueTitle(TitleHUD.makeTextObject("dialogue.deer.death3").jitter(true).font(Formidulus.FONT).typeSpeed(30.0F).displayDuration(7.0F));
                  TitleHUD.queueTitle(TitleHUD.makeTextObject("dialogue.deer.death4").jitter(true).font(Formidulus.FONT).typeSpeed(30.0F).displayDuration(6.0F));
                  TitleHUD.queueTitle(TitleHUD.makeTextObject("dialogue.deer.death5").jitter(true).font(Formidulus.FONT).typeSpeed(10.0F).displayDuration(6.0F));
                  break;
               case 69:
                  TitleHUD.queueTitle(
                     TitleHUD.makeTextObject("dialogue.deer.what")
                        .color(0)
                        .jitter(true)
                        .font(Formidulus.FONT)
                        .delay(1.0F)
                        .typeSpeed(40.0F)
                        .displayDuration(4.0F)
                        .clearPreceding(true)
                  );
            }
   }

   public static void music(BossMusicUpdatePayload payload, net.neoforged.neoforge.network.handling.IPayloadContext context) {
      String key = payload.trackKey();
      switch (key) {
         case "cancel":
            FormidulusClient.bossMusicHandler.stopCurrentTrackNoOutro();
            break;
         case "cancelAll":
            FormidulusClient.bossMusicHandler.cancelAll();
            break;
         case "stopImmediately":
            FormidulusClient.bossMusicHandler.stopCurrentTrackNoFade();
            break;
         case "end":
            FormidulusClient.bossMusicHandler.stopCurrentTrack();
            break;
         default:
            FormidulusClient.bossMusicHandler.startTrack(payload.bossId(), key, payload.late());
      }
   }

   public static void openSpawner(OpenBossSpawnerScreenPayload payload, net.neoforged.neoforge.network.handling.IPayloadContext context) {
      if (context.player().level().getBlockEntity(payload.pos()) instanceof BossSpawnerBlockEntity spawner) {
         net.minecraft.client.Minecraft.getInstance().setScreen(new BossSpawnerScreen(spawner));
      }
   }

   public static void castAbility(CastActiveAbilityPayload payload, net.neoforged.neoforge.network.handling.IPayloadContext context) {
      Level world = net.minecraft.client.Minecraft.getInstance().level;
      if (world != null && world.getEntity(payload.caster()) instanceof LivingEntity caster) {
         ItemAbility ability = ItemAbilities.getFromId(payload.ability());
         if (ability != null) {
            ability.castActiveAbility(caster, payload.stack(), new Vec3(payload.pos()));
         }
      }
   }
}
