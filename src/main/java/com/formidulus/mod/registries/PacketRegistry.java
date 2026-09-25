package com.formidulus.mod.registries;

import com.formidulus.mod.block.BossSpawnerBlockEntity;
import com.formidulus.mod.entities.boss.BossType;
import com.formidulus.mod.network.BossMusicUpdatePayload;
import com.formidulus.mod.network.CastActiveAbilityPayload;
import com.formidulus.mod.network.ClientPacketHandler;
import com.formidulus.mod.network.ModifyBossSpawnerPayload;
import com.formidulus.mod.network.OpenBossSpawnerScreenPayload;
import com.formidulus.mod.network.SequenceTriggerPayload;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

public class PacketRegistry {
   public static void register(IEventBus modBus) {
      modBus.addListener(PacketRegistry::registerPayloads);
   }

   private static void registerPayloads(RegisterPayloadHandlersEvent event) {
      var registrar = event.registrar("1");
      if (FMLEnvironment.dist == Dist.CLIENT) {
         registrar.playToClient(SequenceTriggerPayload.ID, SequenceTriggerPayload.CODEC, ClientPacketHandler::sequence);
         registrar.playToClient(BossMusicUpdatePayload.ID, BossMusicUpdatePayload.CODEC, ClientPacketHandler::music);
         registrar.playToClient(OpenBossSpawnerScreenPayload.ID, OpenBossSpawnerScreenPayload.CODEC, ClientPacketHandler::openSpawner);
         registrar.playToClient(CastActiveAbilityPayload.ID, CastActiveAbilityPayload.CODEC, ClientPacketHandler::castAbility);
      } else {
         registrar.playToClient(SequenceTriggerPayload.ID, SequenceTriggerPayload.CODEC, (payload, context) -> {});
         registrar.playToClient(BossMusicUpdatePayload.ID, BossMusicUpdatePayload.CODEC, (payload, context) -> {});
         registrar.playToClient(OpenBossSpawnerScreenPayload.ID, OpenBossSpawnerScreenPayload.CODEC, (payload, context) -> {});
         registrar.playToClient(CastActiveAbilityPayload.ID, CastActiveAbilityPayload.CODEC, (payload, context) -> {});
      }
      registrar.playToServer(ModifyBossSpawnerPayload.ID, ModifyBossSpawnerPayload.CODEC, (payload, context) -> context.enqueueWork(() -> {
         if (context.player().level().getBlockEntity(payload.pos()) instanceof BossSpawnerBlockEntity spawner) {
            spawner.setBossType(BossType.fromId(payload.bossType()));
            spawner.setRespawnDelay(payload.respawnDelay());
         }
      }));
   }
}
