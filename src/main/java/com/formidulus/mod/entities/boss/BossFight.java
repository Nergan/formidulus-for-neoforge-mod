package com.formidulus.mod.entities.boss;

import net.neoforged.neoforge.network.PacketDistributor;
import com.formidulus.mod.advancement.CriteriaRegistry;
import com.formidulus.mod.block.BossSpawnerBlockEntity;
import com.formidulus.mod.datagen.Lang;
import com.formidulus.mod.entities.BossEntity;
import com.formidulus.mod.network.BossMusicUpdatePayload;
import com.formidulus.mod.sound.BossMusicEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;

public abstract class BossFight {
   protected static final Map<String, BossMusicEntry> bossMusic = new HashMap<>();
   protected final Level world;
   protected final BossType type;
   protected final BlockPos origin;
   protected final UUID fightID;
   protected final List<BossEntity> activeBossEntities = new ArrayList<>();
   protected int phase;
   protected List<ServerPlayer> participants = new ArrayList<>();
   protected Map<ServerPlayer, Integer> outOfBoundsParticipants = new HashMap<>();
   protected int playerCheckIntervall = 20;
   protected int playerCheckRange = 40;
   int playerCheckTimer;
   int warmUp = 20;
   String lastMusicKey;
   boolean playerWin;
   boolean ended;

   protected BossFight(BossEntity entity, UUID id) {
      this.world = entity.level();
      this.type = entity.getBossType();
      this.origin = entity.getOriginBlock();
      if (id == null) {
         this.participants = this.world
            .getEntities(EntityTypeTest.forClass(ServerPlayer.class), new AABB(this.origin).inflate((double)this.playerCheckRange), this::isValidParticipant);
      }

      this.fightID = id == null ? UUID.randomUUID() : id;
      if (this.world.getBlockEntity(this.origin) instanceof BossSpawnerBlockEntity spawner) {
         spawner.setBossFightId(this.fightID);
      }

      this.registerBossEntity(entity);
   }

   public void registerBossEntity(BossEntity boss) {
      this.activeBossEntities.add(boss);
   }

   public void tick() {
      if (!this.ended) {
         if (this.playerCheckTimer-- <= 0) {
            this.performParticipantCheck();
         }

         this.activeBossEntities.removeIf(i -> i.isRemoved() || i.isDeadOrDying() || !i.isActive());
         String music = this.getCurMusicKey();
         if (music != null && !music.equals(this.lastMusicKey)) {
            this.onMusicChange(music);
            this.lastMusicKey = music;
         }

         if (this.warmUp-- <= 0) {
            if (this.shouldEnd()) {
               BossFightManager.INSTANCE.endFight(this);
            }
         }
      }
   }

   void performParticipantCheck() {
      List<ServerPlayer> validParticipants = this.world
         .getEntities(EntityTypeTest.forClass(ServerPlayer.class), new AABB(this.origin).inflate((double)this.playerCheckRange), this::isValidParticipant);
      List<ServerPlayer> remove = new ArrayList<>();
      this.participants.forEach(p -> {
         if (!validParticipants.contains(p)) {
            if (!this.outOfBoundsParticipants.containsKey(p)) {
               this.outOfBoundsParticipants.put(p, 10);
            }

            int oob = this.outOfBoundsParticipants.get(p);
            if (oob > 0) {
               this.outOfBoundsParticipants.put(p, oob - 1);
               p.displayClientMessage(Component.translatable(Lang.MESSAGE_OUT_OF_BOUNDS, new Object[]{oob - 1}), true);
            }
         } else {
            this.outOfBoundsParticipants.remove(p);
         }

         if (this.outOfBoundsParticipants.getOrDefault(p, 9) <= 0 || !p.canBeSeenByAnyone() || p.isCreative()) {
            remove.add(p);
         }
      });
      remove.forEach(this::leaveFight);
      validParticipants.forEach(p -> {
         if (!this.participants.contains(p) && !this.activeBossEntities.isEmpty()) {
            this.joinFight(p);
         }
      });
      this.playerCheckTimer = this.playerCheckIntervall;
   }

   protected boolean shouldEnd() {
      return this.activeBossEntities.isEmpty() || !this.hasAnyValidParticipants();
   }

   public void setPhase(int phase) {
      this.phase = phase;
   }

   public int getPhase() {
      return this.phase;
   }

   public BossMusicEntry getCurMusicEntry() {
      return getMusicEntry(this.getCurMusicKey());
   }

   public static BossMusicEntry getMusicEntry(String key) {
      return bossMusic.get(key);
   }

   protected String getCurMusicKey() {
      return "phase" + (this.phase + 1);
   }

   void onMusicChange(String key) {
      this.participants.forEach(p -> PacketDistributor.sendToPlayer(p, new BossMusicUpdatePayload(this.type.id(), key)));
   }

   public void joinFight(ServerPlayer player) {
      if (!this.participants.contains(player)) {
         this.participants.add(player);
         PacketDistributor.sendToPlayer(player, new BossMusicUpdatePayload(this.type.id(), this.getCurMusicKey(), true));
      }
   }

   public void leaveFight(ServerPlayer player) {
      if (this.participants.remove(player)) {
         PacketDistributor.sendToPlayer(player, new BossMusicUpdatePayload(this.type.id(), "cancel"));
      }

      this.outOfBoundsParticipants.remove(player);
   }

   public void onPlayerDeath(ServerPlayer player) {
      if (this.participants.contains(player)) {
         this.leaveFight(player);
         this.performParticipantCheck();
      }
   }

   public List<ServerPlayer> getAllParticipants() {
      return this.participants;
   }

   public boolean isValidParticipant(ServerPlayer player) {
      return player != null && player.canBeSeenByAnyone() && !player.isCreative();
   }

   public boolean hasAnyValidParticipants() {
      for (ServerPlayer p : this.participants) {
         if (this.isValidParticipant(p)) {
            return true;
         }
      }

      return false;
   }

   public boolean isParticipant(ServerPlayer player) {
      return this.participants.contains(player);
   }

   public void setPlayerCheckRange(int range) {
      this.playerCheckRange = range;
   }

   public void setPlayerCheckIntervall(int intervall) {
      this.playerCheckIntervall = intervall;
   }

   public void interrupt(boolean removeRemainingBossEntities) {
      if (removeRemainingBossEntities) {
         this.activeBossEntities.forEach(BossEntity::forceReset);
      }

      this.onFightEnded();
   }

   public UUID getFightID() {
      return this.fightID;
   }

   public void markWon() {
      this.playerWin = true;
   }

   void onFightEnded() {
      if (!this.ended) {
         if (this.playerWin) {
            this.participants.forEach(p -> CriteriaRegistry.BOSSFIGHT_WIN.trigger(p, this.type.id()));
            if (this.world.getBlockEntity(this.origin) instanceof BossSpawnerBlockEntity spawner && this.fightID.equals(spawner.getFightId())) {
               spawner.onFightEnded();
            }
         } else {
            this.activeBossEntities.forEach(BossEntity::forceReset);

            while (!this.participants.isEmpty()) {
               this.leaveFight(this.participants.getFirst());
            }
         }

         this.ended = true;
      }
   }

   public boolean hasEnded() {
      return this.ended;
   }
}
