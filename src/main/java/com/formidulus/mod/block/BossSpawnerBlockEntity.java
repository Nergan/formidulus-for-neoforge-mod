package com.formidulus.mod.block;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.entities.BossEntity;
import com.formidulus.mod.entities.boss.BossFightManager;
import com.formidulus.mod.entities.boss.BossType;
import com.formidulus.mod.registries.BlockEntityRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

public class BossSpawnerBlockEntity extends BlockEntity {
   final List<UUID> bossEntities = new ArrayList<>();
   BossType bossType = BossType.DEER;
   UUID bossFightId;
   int respawnDelay = 12000;
   int fightCheckTimer;
   long lastFightEnded;
   boolean wasBossfightActive;

   public BossSpawnerBlockEntity(BlockPos pos, BlockState state) {
      super(BlockEntityRegistry.BOSS_SPAWNER, pos, state);
   }

   public CompoundTag getUpdateTag(Provider registryLookup) {
      return this.saveWithoutMetadata(registryLookup);
   }

   @Nullable
   public Packet<ClientGamePacketListener> getUpdatePacket() {
      return ClientboundBlockEntityDataPacket.create(this);
   }

   public static <T extends BlockEntity> void tick(T t) {
      if (t instanceof BossSpawnerBlockEntity spawner) {
         spawner.tick();
      }
   }

   void tick() {
      if (this.fightCheckTimer-- <= 0) {
         boolean active = BossFightManager.INSTANCE.isActive(this.bossFightId);
         if (this.wasBossfightActive && !active) {
            this.onFightEnded();
         }

         if (this.level instanceof ServerLevel serverWorld && !this.wasBossfightActive) {
            if (this.bossEntities.isEmpty() && (System.currentTimeMillis() > this.lastFightEnded + (long)this.respawnDelay * 50L || this.lastFightEnded == 0L)) {
               if (this.isSpawnAreaValid()) {
                  this.trySpawnBoss();
               } else {
                  this.lastFightEnded += 10000L;
               }
            }

            this.bossEntities.removeIf(i -> {
               Entity entity = serverWorld.getEntity(i);
               return entity == null || !entity.isAlive() || entity.isRemoved();
            });
            List<? extends BossEntity> list = serverWorld.getEntities(
               (EntityTypeTest)this.bossType.bossEntities().getFirst(),
               new AABB(this.worldPosition),
               i -> !i.isAlive() && !this.bossEntities.contains(i.getUUID())
            );
            list.forEach(i -> {
               i.discard();
               this.lastFightEnded = 0L;
               Formidulus.LOGGER.warn("discarded duplicate boss at {}", this.worldPosition);
            });
         }

         this.fightCheckTimer = (Integer)Formidulus.config.fightCheckInterval.getValue();
         this.wasBossfightActive = active;
      }
   }

   void trySpawnBoss() {
      if (this.bossType == null) {
         this.bossType = BossType.DEER;
      }

      if (this.level instanceof ServerLevel serverWorld) {
         for (BossEntity boss : serverWorld.getEntities(EntityTypeTest.forClass(BossEntity.class), i -> true)) {
            if (boss.getBossType().equals(this.bossType) && this.worldPosition.equals(boss.getOriginBlock())) {
               this.bossEntities.add(boss.getUUID());
               return;
            }
         }

         BossEntity entity = (BossEntity)this.bossType.bossEntities().getFirst().spawn(serverWorld, e -> {
            e.setYRot(0.0F);
            e.setYHeadRot(0.0F);
            e.setYBodyRot(0.0F);
            e.moveTo(e.position(), 0.0F, 0.0F);
            if (e instanceof BossEntity) {
               e.setOriginBlock(this.worldPosition);
               e.afterBossReset();
            }
         }, this.worldPosition, MobSpawnType.SPAWNER, false, false);
         if (entity != null) {
            this.bossEntities.add(entity.getUUID());
         }
      }
   }

   public void addBossEntity(BossEntity entity) {
      if (this.bossType.bossEntities().contains(entity.getType())) {
         this.bossEntities.add(entity.getUUID());
      }
   }

   boolean isSpawnAreaValid() {
      if (this.level == null) {
         return false;
      } else {
         return this.bossType.requiresSolidFloor()
               && !this.level.getBlockState(this.worldPosition.below()).isFaceSturdy(this.level, this.worldPosition.below(), Direction.UP)
            ? false
            : this.level
               .noCollision(
                  this.bossType
                     .bossEntities()
                     .getFirst()
                     .getSpawnAABB((double)this.worldPosition.getX() + 0.5, (double)this.worldPosition.getY(), (double)this.worldPosition.getZ() + 0.5)
               );
      }
   }

   boolean isBossFightActive(UUID id) {
      return BossFightManager.INSTANCE.isActive(id);
   }

   public UUID getFightId() {
      return this.bossFightId;
   }

   public void setBossFightId(UUID bossFightId) {
      this.bossFightId = bossFightId;
      this.setChanged();
      if (this.level != null) {
         this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 2);
      }
   }

   public BossType getBossType() {
      return this.bossType;
   }

   public void setBossType(BossType bossType) {
      this.bossType = bossType;
      this.setChanged();
      if (this.level != null) {
         this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 2);
      }
   }

   public int getRespawnDelay() {
      return this.respawnDelay;
   }

   public void setRespawnDelay(int respawnDelay) {
      this.respawnDelay = respawnDelay;
      this.setChanged();
      if (this.level != null) {
         this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 2);
      }
   }

   public void onFightEnded() {
      if (this.level != null) {
         this.lastFightEnded = System.currentTimeMillis();
         this.setChanged();
         this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 2);
      }
   }

   public void onBlockBroken() {
      if (this.level instanceof ServerLevel serverWorld) {
         for (UUID id : this.bossEntities) {
            if (serverWorld.getEntity(id) instanceof BossEntity boss) {
               boss.discard();
            }
         }
      }
   }

   protected void saveAdditional(CompoundTag nbt, Provider registryLookup) {
      super.saveAdditional(nbt, registryLookup);
      nbt.putInt("RespawnDelay", this.respawnDelay);
      nbt.putLong("LastFightEnded", this.lastFightEnded);
      if (this.bossType != null) {
         nbt.putString("BossType", this.bossType.id().toString());
      }

      if (this.isBossFightActive(this.bossFightId)) {
         nbt.putUUID("BossFightId", this.bossFightId);
      }

      if (!this.bossEntities.isEmpty()) {
         ListTag list = new ListTag();

         for (UUID id : this.bossEntities) {
            CompoundTag compound = new CompoundTag();
            compound.putUUID("ID", id);
            list.add(compound);
         }

         nbt.put("LivingBossEntities", list);
      }
   }

   protected void loadAdditional(CompoundTag nbt, Provider registryLookup) {
      super.loadAdditional(nbt, registryLookup);
      if (nbt.contains("RespawnDelay", 3)) {
         this.respawnDelay = nbt.getInt("RespawnDelay");
      }

      if (nbt.contains("LastFightEnded", 4)) {
         this.lastFightEnded = nbt.getLong("LastFightEnded");
      }

      if (nbt.contains("BossType", 8)) {
         this.bossType = BossType.fromId(ResourceLocation.tryParse(nbt.getString("BossType")));
      }

      if (nbt.hasUUID("BossFightId")) {
         this.bossFightId = nbt.getUUID("BossFightId");
      }

      if (nbt.contains("LivingBossEntities", 9)) {
         ListTag list = nbt.getList("LivingBossEntities", 10);
         list.forEach(i -> {
            if (i instanceof CompoundTag compound && compound.hasUUID("ID")) {
               this.bossEntities.add(compound.getUUID("ID"));
            }
         });
      }
   }
}
