package com.formidulus.mod.entities;

import com.formidulus.mod.entities.boss.BossFight;
import com.formidulus.mod.entities.boss.BossType;
import com.formidulus.mod.entities.goal.BossOutOfCombatGoal;
import com.formidulus.mod.entities.goal.BossTargetGoal;
import java.util.List;
import java.util.UUID;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.SynchedEntityData.Builder;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.BossEvent.BossBarOverlay;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public abstract class BossEntity extends AnimatedHostileEntity {
   public static final EntityDataAccessor<BlockPos> ORIGIN = SynchedEntityData.defineId(BossEntity.class, EntityDataSerializers.BLOCK_POS);
   protected ServerBossEvent bossBar;
   boolean wasBossbarVisible;
   boolean shouldUpdateBossbar = true;
   float lastDamageTakenRaw;
   float lastDamageTaken;
   int lastTargetDamagedTime;
   int combatTimer;
   BossTargetGoal targetGoal;
   BossOutOfCombatGoal outOfCombatGoal;
   BossFight bossFight;
   BossType type;

   protected BossEntity(EntityType<? extends AnimatedHostileEntity> entityType, Level world, BossType type) {
      super(entityType, world);
      this.type = type;
   }

   @Override
   protected void defineSynchedData(Builder builder) {
      super.defineSynchedData(builder);
      builder.define(ORIGIN, this.blockPosition());
   }

   protected ServerBossEvent initBossBar() {
      return new ServerBossEvent(this.getDisplayName(), BossBarColor.RED, this.getBossBarStyle());
   }

   abstract BossBarOverlay getBossBarStyle();

   public void setCustomName(@Nullable Component name) {
      super.setCustomName(name);
      if (this.isBossBarVisible()) {
         this.bossBar.setName(this.getDisplayName());
      }
   }

   public boolean isBossBarVisible() {
      if (this.bossBar == null) {
         this.bossBar = this.initBossBar();
      }

      return true;
   }

   public void startSeenByPlayer(ServerPlayer player) {
      super.startSeenByPlayer(player);
      if (this.isBossBarVisible()) {
         this.bossBar.addPlayer(player);
      }
   }

   public void stopSeenByPlayer(ServerPlayer player) {
      super.stopSeenByPlayer(player);
      if (this.isBossBarVisible()) {
         this.bossBar.removePlayer(player);
      }
   }

   protected void customServerAiStep() {
      super.customServerAiStep();
      if (this.isBossBarVisible() && this.shouldUpdateBossbar) {
         this.bossBar.setProgress(this.getHealth() / this.getMaxHealth());
      }

      if (!this.level().isClientSide) {
         LivingEntity var2 = this.getTarget();
         if (var2 instanceof LivingEntity && var2.isAlive() && !var2.isRemoved()) {
            this.combatTimer = 10;
         } else if (this.combatTimer > 0) {
            this.combatTimer--;
         }

         if (((BlockPos)this.entityData.get(ORIGIN)).equals(BlockPos.ZERO)) {
            this.entityData.set(ORIGIN, this.blockPosition());
         }

         if (this.wasBossbarVisible && !this.isBossBarVisible()) {
            this.bossBar.removeAllPlayers();
         } else if (!this.wasBossbarVisible && this.isBossBarVisible()) {
            this.level()
               .getEntities(EntityTypeTest.forClass(Player.class), this.getBoundingBox().inflate(64.0), p -> true)
               .forEach(p -> this.bossBar.addPlayer((ServerPlayer)p));
         }

         this.wasBossbarVisible = this.isBossBarVisible();
      }
   }

   public boolean requiresCustomPersistence() {
      return true;
   }

   abstract boolean isInSequence();

   public Vec3 getFocusPos() {
      return this.getEyePosition().subtract(0.0, 0.5, 0.0);
   }

   public float getLastDamageTakenRaw() {
      return this.lastDamageTakenRaw;
   }

   public float getLastDamageTaken() {
      return this.lastDamageTaken;
   }

   public int getLastTargetDamagedTime() {
      return this.lastTargetDamagedTime;
   }

   @Nullable
   public LivingEntity getRandomTarget() {
      return this.targetGoal != null ? this.targetGoal.getRandomTarget() : null;
   }

   public List<LivingEntity> getAllTargets() {
      return this.targetGoal != null ? this.targetGoal.getAllTargets() : List.of();
   }

   public boolean hurt(DamageSource source, float amount) {
      boolean b = super.hurt(source, amount);
      if (b) {
         this.lastDamageTakenRaw = amount;
         this.lastDamageTaken = this.getDamageAfterArmorAbsorb(source, amount);
      }

      return b;
   }

   @Override
   public void onDamageEntity(LivingEntity damaged) {
      if (damaged.equals(this.getTarget())) {
         this.lastTargetDamagedTime = this.tickCount;
      }
   }

   public boolean isInCombat() {
      return this.combatTimer > 0;
   }

   public abstract void beforeBossReset();

   public abstract void afterBossReset();

   public abstract BossType getBossType();

   public abstract boolean isActive();

   public BlockPos getOriginBlock() {
      return (BlockPos)this.entityData.get(ORIGIN);
   }

   public Vec3 getOriginBlockMinCorner() {
      BlockPos pos = this.getOriginBlock();
      return new Vec3((double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
   }

   public void setOriginBlock(BlockPos pos) {
      this.entityData.set(ORIGIN, pos);
   }

   protected void beginFight() {
      this.bossFight = this.type.beginFight(this, this.getFightId());
   }

   public UUID getFightId() {
      return this.bossFight == null ? null : this.bossFight.getFightID();
   }

   public BossFight getBossFightInstance() {
      return this.bossFight;
   }

   public void forceReset() {
      this.forceStopActiveGoals();
      if (this.outOfCombatGoal != null) {
         this.outOfCombatGoal.start();
      }
   }

   abstract int getFightPhase();

   public void readAdditionalSaveData(CompoundTag nbt) {
      super.readAdditionalSaveData(nbt);
      if (nbt.contains("Origin", 4)) {
         this.entityData.set(ORIGIN, BlockPos.of(nbt.getLong("Origin")));
      }

      if (nbt.contains("CombatTimer", 3)) {
         this.combatTimer = nbt.getInt("CombatTimer");
      }

      if (!nbt.hasUUID("FightId") || this.bossFight != null && !this.bossFight.hasEnded()) {
         if (this.getFightPhase() >= 0 && (this.bossFight == null || this.bossFight.hasEnded())) {
            this.beginFight();
            this.bossFight.setPhase(this.getFightPhase());
         }
      } else {
         this.bossFight = this.type.beginFight(this, nbt.getUUID("FightId"));
      }
   }

   public void addAdditionalSaveData(CompoundTag nbt) {
      super.addAdditionalSaveData(nbt);
      if (!((BlockPos)this.entityData.get(ORIGIN)).equals(BlockPos.ZERO)) {
         nbt.putLong("Origin", ((BlockPos)this.entityData.get(ORIGIN)).asLong());
      }

      if (this.isInCombat()) {
         nbt.putInt("CombatTimer", this.combatTimer);
      }

      if (this.bossFight != null) {
         nbt.putUUID("FightId", this.bossFight.getFightID());
      }
   }
}
