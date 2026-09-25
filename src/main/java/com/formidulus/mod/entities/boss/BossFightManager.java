package com.formidulus.mod.entities.boss;

import net.neoforged.neoforge.network.PacketDistributor;
import com.formidulus.mod.network.BossMusicUpdatePayload;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.Nullable;

public class BossFightManager {
   public static final BossFightManager INSTANCE = new BossFightManager();
   static final Map<UUID, BossFight> activeFights = new HashMap<>();
   static final Map<BossType, List<UUID>> activeFightIdsByType = new HashMap<>();
   static final List<BossFight> endedFights = new ArrayList<>();
   static final List<BossFight> newFights = new ArrayList<>();

   public void tick() {
      activeFights.values().forEach(BossFight::tick);
      List.copyOf(newFights).forEach(fight -> {
         activeFights.put(fight.fightID, fight);
         if (!activeFightIdsByType.containsKey(fight.type)) {
            activeFightIdsByType.put(fight.type, new ArrayList<>());
         }

         activeFightIdsByType.get(fight.type).add(fight.fightID);
      });
      newFights.clear();
      List.copyOf(endedFights).forEach(fight -> {
         BossFight removed = activeFights.remove(fight.fightID);
         if (removed != null) {
            removed.onFightEnded();
         }

         if (activeFightIdsByType.containsKey(fight.type)) {
            activeFightIdsByType.get(fight.type).remove(fight.fightID);
         }
      });
      endedFights.clear();
   }

   public <T extends BossFight> T beginFight(T sender) {
      if (!newFights.contains(sender)) {
         newFights.add(sender);
      }

      return sender;
   }

   public void endFight(BossFight sender) {
      if (!endedFights.contains(sender)) {
         endedFights.add(sender);
      }
   }

   public void onPlayerDeath(ServerPlayer player) {
      activeFights.values().forEach(f -> f.onPlayerDeath(player));
      PacketDistributor.sendToPlayer(player, new BossMusicUpdatePayload(null, "cancelAll"));
   }

   public boolean isActive(BossFight bossFight) {
      return this.isActive(bossFight.fightID);
   }

   public boolean isActive(UUID id) {
      return activeFights.containsKey(id);
   }

   @Nullable
   public BossFight fromId(UUID id) {
      return activeFights.get(id);
   }
}
