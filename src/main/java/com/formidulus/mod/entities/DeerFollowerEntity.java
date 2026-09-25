package com.formidulus.mod.entities;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.entities.goal.ServantTargetGoal;
import com.formidulus.mod.registries.ItemRegistry;
import com.formidulus.mod.registries.ParticleRegistry;
import com.formidulus.mod.registries.SoundRegistry;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments.Mutable;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import org.jetbrains.annotations.Nullable;

public class DeerFollowerEntity extends ServantEntity {
   static final EntityDataAccessor<Boolean> MASK = SynchedEntityData.defineId(DeerFollowerEntity.class, EntityDataSerializers.BOOLEAN);
   static final EntityDataAccessor<Byte> ACTIVITY = SynchedEntityData.defineId(DeerFollowerEntity.class, EntityDataSerializers.BYTE);
   static final EntityDataAccessor<Byte> VARIANT = SynchedEntityData.defineId(DeerFollowerEntity.class, EntityDataSerializers.BYTE);
   static final EntityDataAccessor<BlockPos> ALTAR = SynchedEntityData.defineId(DeerFollowerEntity.class, EntityDataSerializers.BLOCK_POS);
   public static final byte ACTIVITY_IDLE = 0;
   public static final byte ACTIVITY_READING = 1;
   public static final byte ACTIVITY_WORSHIP = 2;
   public static final byte ACTIVITY_HUMMING = 3;
   public static final byte STATUS_HUM_PARTICLES = -1;
   boolean hasAltar;
   byte activity;

   public DeerFollowerEntity(EntityType<? extends Monster> entityType, Level world) {
      super(entityType, world);
      this.lookControl = new LookControl(this) {
         protected boolean resetXRotOnTick() {
            return false;
         }
      };
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 0.41F, false));
      this.goalSelector.addGoal(0, new DeerFollowerEntity.ProtectTheAltarGoal(this, 0.5F));
      this.goalSelector.addGoal(1, new DeerFollowerEntity.SearchForAltarGoal(this, 0.3F));
      this.goalSelector.addGoal(1, new DeerFollowerEntity.PatrolAltarGoal(this, 0.25F));
      this.goalSelector.addGoal(1, new DeerFollowerEntity.WorshipGoal(this, 0.3F));
      this.goalSelector.addGoal(3, new DeerFollowerEntity.ReadBookGoal(this, 0.01F));
      this.goalSelector.addGoal(3, new DeerFollowerEntity.HumGoal(this, 0.001F));
      this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
      this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, DeerFollowerEntity.class, 6.0F));
      this.targetSelector.addGoal(0, new HurtByTargetGoal(this, new Class[]{DeerGodEntity.class}));
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, true));
      this.targetSelector.addGoal(1, new ServantTargetGoal(this));
   }

   protected void defineSynchedData(net.minecraft.network.syncher.SynchedEntityData.Builder builder) {
      super.defineSynchedData(builder);
      builder.define(MASK, true);
      builder.define(ACTIVITY, (byte)0);
      builder.define(VARIANT, (byte)0);
      builder.define(ALTAR, BlockPos.ZERO);
   }

   public void onSyncedDataUpdated(EntityDataAccessor<?> data) {
      super.onSyncedDataUpdated(data);
      if (this.level().isClientSide && data.equals(MASK)) {
         if (!(Boolean)this.entityData.get(MASK)) {
            this.addHeadParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.BONE_BLOCK.defaultBlockState()), 1.0F, 32);
         } else {
            this.addHeadParticles(ParticleRegistry.DARKNESS, 1.0F, 16);
         }
      }

      if (data.equals(ALTAR)) {
         this.hasAltar = !((BlockPos)this.entityData.get(ALTAR)).equals(BlockPos.ZERO);
      }

      if (data.equals(ACTIVITY)) {
         this.activity = (Byte)this.entityData.get(ACTIVITY);
      }
   }

   @Nullable
   public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType spawnReason, @Nullable SpawnGroupData entityData) {
      this.populateDefaultEquipmentSlots(this.random, difficulty);
      if (!world.isClientSide()) {
         this.entityData.set(VARIANT, (byte)((int)((double)this.random.nextFloat() * 3.99)));
      }

      return super.finalizeSpawn(world, difficulty, spawnReason, entityData);
   }

   protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance localDifficulty) {
      this.setItemSlot(EquipmentSlot.MAINHAND, ItemRegistry.SACRIFICIAL_DAGGER.getDefaultInstance());
      if (this.level() instanceof ServerLevel serverWorld && random.nextFloat() < localDifficulty.getEffectiveDifficulty() / 10.0F) {
         this.enchantSpawnedArmor(serverWorld, random, EquipmentSlot.MAINHAND, localDifficulty);
      }

      this.setDropChance(EquipmentSlot.MAINHAND, 0.1F);
      if (!(random.nextFloat() > 0.1F + localDifficulty.getEffectiveDifficulty() / 10.0F)) {
         if (!Formidulus.ENCHANCEMENT
            && this.level() instanceof ServerLevel serverWorld
            && random.nextFloat() < localDifficulty.getEffectiveDifficulty() / 7.5F) {
            ItemStack enchantedBook = Items.ENCHANTED_BOOK.getDefaultInstance();
            RegistryAccess registryManager = serverWorld.registryAccess();
            Registry<Enchantment> reg = registryManager.registryOrThrow(Registries.ENCHANTMENT);
            List<EnchantmentInstance> enchantments = EnchantmentHelper.selectEnchantment(
               random,
               Items.BOOK.getDefaultInstance(),
               30,
               this.getEnchantmentEntryStream(
                  reg,
                  List.of(
                     Enchantments.BINDING_CURSE,
                     Enchantments.VANISHING_CURSE,
                     Enchantments.FLAME,
                     Enchantments.FIRE_ASPECT,
                     Enchantments.SHARPNESS,
                     Enchantments.SMITE,
                     Enchantments.FIRE_PROTECTION
                  )
               )
            );
            Mutable componentBuilder = new Mutable((ItemEnchantments)enchantedBook.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY));
            if (random.nextFloat() < (Float)Formidulus.config.cultistMendingChance.getValue()) {
               enchantments.add(new EnchantmentInstance(reg.wrapAsHolder((Enchantment)reg.get(Enchantments.MENDING)), 1));
            }

            for (EnchantmentInstance e : enchantments) {
               componentBuilder.upgrade(e.enchantment, e.level);
            }

            enchantedBook.set(DataComponents.ENCHANTMENTS, componentBuilder.toImmutable());
            this.setItemSlot(EquipmentSlot.OFFHAND, enchantedBook);
            this.setDropChance(EquipmentSlot.OFFHAND, 1.0F);
         } else {
            this.setItemSlot(EquipmentSlot.OFFHAND, Items.BOOK.getDefaultInstance());
            this.setDropChance(EquipmentSlot.OFFHAND, 0.33F);
         }
      }
   }

   Stream<Holder<Enchantment>> getEnchantmentEntryStream(Registry<Enchantment> reg, List<ResourceKey<Enchantment>> keys) {
      Builder<Holder<Enchantment>> builder = Stream.builder();

      for (ResourceKey<Enchantment> key : keys) {
         builder.add(reg.wrapAsHolder((Enchantment)reg.get(key)));
      }

      return builder.build();
   }

   public int getArmorValue() {
      int armor = super.getArmorValue() * (this.isHasMask() ? 3 : 1);
      return armor + (this.level().getDifficulty().getId() - 1) * 5;
   }

   public boolean hurt(DamageSource source, float amount) {
      boolean b = super.hurt(source, amount);
      if (!this.level().isClientSide && (Boolean)this.entityData.get(MASK) && this.random.nextFloat() < 0.01F * amount) {
         this.entityData.set(MASK, false);
         this.makeSound(SoundRegistry.CULTIST_MASK_BREAK);
      }

      return b;
   }

   protected SoundEvent getHurtSound(DamageSource source) {
      return SoundEvents.EMPTY;
   }

   boolean isFemale() {
      return this.getVariant() < 2;
   }

   protected void playHurtSound(DamageSource damageSource) {
      if (this.isFemale()) {
         this.playSound(SoundRegistry.CULTIST_MALE_HURT, 1.0F, 0.95F + this.random.nextFloat() * 0.1F);
      } else {
         this.playSound(SoundRegistry.CULTIST_FEMALE_HURT, 1.0F, 0.8F + this.random.nextFloat() * 0.1F);
      }

      super.playHurtSound(damageSource);
   }

   protected SoundEvent getDeathSound() {
      return this.isFemale() ? SoundRegistry.CULTIST_MALE_DEATH : SoundRegistry.CULTIST_FEMALE_DEATH;
   }

   public void aiStep() {
      super.aiStep();
      if (!this.level().isClientSide && this.tickCount % 40 == 0 && this.random.nextFloat() < 0.33F) {
         if (this.isReading()) {
            this.swing(InteractionHand.OFF_HAND);
            this.makeSound(SoundRegistry.CULTIST_IDLE_FLIP_PAGE);
         }

         if (this.isHumming()) {
            this.playSound(SoundRegistry.CULTIST_IDLE_HUM, 1.0F, (this.isFemale() ? 0.9F : 0.6F) + this.random.nextFloat() * 0.1F);
            this.level().broadcastEntityEvent(this, (byte)-1);
         }
      }

      if (this.getPose().equals(Pose.SITTING) && this.moveControl.hasWanted()) {
         this.setPose(Pose.STANDING);
      }

      if (!this.isHasAltar()) {
         List<DeerGodEntity> list = this.level()
            .getEntities(
               EntityTypeTest.forClass(DeerGodEntity.class), AABB.unitCubeFromLowerCorner(this.position().subtract(0.5, 0.5, 0.5)).inflate(32.0), i -> true
            );
         if (!list.isEmpty()) {
            DeerGodEntity deer = list.getFirst();
            this.entityData.set(ALTAR, deer.getOriginBlock());
            this.setTarget(deer.getTarget());
         }
      }
   }

   void addHeadParticles(ParticleOptions type, float range, int count) {
      for (int i = 0; i < count; i++) {
         Vec3 pos = this.getEyePosition().offsetRandom(this.random, range);
         this.level().addParticle(type, pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
      }
   }

   public boolean isReading() {
      return this.getActivity() == 1;
   }

   public boolean isWorshipping() {
      return this.getActivity() == 2;
   }

   public boolean isHumming() {
      return this.getActivity() == 3;
   }

   public byte getActivity() {
      return this.activity;
   }

   public void setActivity(byte activity) {
      this.entityData.set(ACTIVITY, activity);
   }

   public boolean isArmsVisible() {
      return this.isReading() || this.isAggressive() || this.isWorshipping();
   }

   public boolean isHasMask() {
      return (Boolean)this.entityData.get(MASK);
   }

   public byte getVariant() {
      return (Byte)this.entityData.get(VARIANT);
   }

   public BlockPos getAltar() {
      return (BlockPos)this.entityData.get(ALTAR);
   }

   public Vec3 getAltarMinCorner() {
      BlockPos pos = this.getAltar();
      return new Vec3((double)pos.getX(), (double)pos.getY(), (double)pos.getZ());
   }

   public boolean isHasAltar() {
      return this.hasAltar;
   }

   public void handleEntityEvent(byte status) {
      if (status == 14) {
         this.addHeadParticles(ParticleTypes.HAPPY_VILLAGER, 0.8F, 8);
      } else if (status != 20) {
         if (status == -1) {
            this.addHeadParticles(ParticleTypes.NOTE, 1.0F, (int)(2.0F + this.random.nextFloat() * 2.5F));
         } else {
            super.handleEntityEvent(status);
         }
      } else {
         for (int i = 0; i < 16; i++) {
            Vec3 pos = this.getBoundingBox().getCenter().add(Vec3.ZERO.offsetRandom(this.random, 1.0F).multiply(1.0, 2.0, 1.0));
            this.level().addParticle(ParticleRegistry.DARKNESS, pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
         }
      }
   }

   public void readAdditionalSaveData(CompoundTag nbt) {
      super.readAdditionalSaveData(nbt);
      if (nbt.contains("Variante", 1)) {
         this.entityData.set(VARIANT, nbt.getByte("Variante"));
      } else {
         this.entityData.set(VARIANT, (byte)((int)((double)this.random.nextFloat() * 3.99)));
      }

      if (nbt.contains("Mask", 1)) {
         this.entityData.set(MASK, nbt.getBoolean("Mask"));
      }

      if (nbt.contains("Altar", 4)) {
         this.entityData.set(ALTAR, BlockPos.of(nbt.getLong("Altar")));
      }

      if (nbt.contains("Activity", 1)) {
         this.setActivity(nbt.getByte("Activity"));
      }
   }

   public void addAdditionalSaveData(CompoundTag nbt) {
      super.addAdditionalSaveData(nbt);
      nbt.putByte("Variante", (Byte)this.entityData.get(VARIANT));
      nbt.putBoolean("Mask", (Boolean)this.entityData.get(MASK));
      if (this.isHasAltar()) {
         nbt.putLong("Altar", this.getAltar().asLong());
      }
   }

   static class ActivityGoal extends Goal {
      final DeerFollowerEntity mob;
      final byte activity;
      final float chance;
      int duration;

      ActivityGoal(DeerFollowerEntity mob, byte activity, float chance) {
         this.mob = mob;
         this.activity = activity;
         this.chance = chance;
      }

      public boolean canUse() {
         return this.mob.isHasAltar()
            && this.mob.getTarget() == null
            && this.mob.navigation.isDone()
            && (this.mob.random.nextFloat() < this.chance || this.mob.getActivity() == this.activity);
      }

      public void start() {
         this.duration = 300 + (int)(this.mob.random.nextFloat() * 700.0F);
         this.mob.setActivity(this.activity);
      }

      public boolean canContinueToUse() {
         return this.canUse() && this.duration-- > 0;
      }

      public boolean isInterruptable() {
         return !this.canContinueToUse();
      }

      public void stop() {
         super.stop();
         if (this.mob.getActivity() == this.activity) {
            this.mob.setActivity((byte)0);
         }
      }
   }

   static class HumGoal extends DeerFollowerEntity.ActivityGoal {
      public HumGoal(DeerFollowerEntity mob, float chance) {
         super(mob, (byte)3, chance);
      }
   }

   static class PatrolAltarGoal extends Goal {
      final DeerFollowerEntity mob;
      final float speed;

      public PatrolAltarGoal(DeerFollowerEntity mob, float speed) {
         this.mob = mob;
         this.speed = speed;
         this.setFlags(EnumSet.of(Flag.MOVE));
      }

      public boolean canUse() {
         return this.mob.isHasAltar() && this.mob.getTarget() == null && this.mob.navigation.isDone() && this.mob.random.nextFloat() < 0.01F;
      }

      public void start() {
         super.start();
         Vec3 center = this.mob.getAltar().getBottomCenter();

         for (int i = 0; i < 16; i++) {
            Vec3 dest = center.add(((double)this.mob.random.nextFloat() - 0.5) * 2.0 * 32.0, 0.0, ((double)this.mob.random.nextFloat() - 0.5) * 2.0 * 32.0);
            BlockHitResult bHit = this.mob
               .level()
               .clip(new ClipContext(dest.add(0.0, 16.0, 0.0), dest.subtract(0.0, 32.0, 0.0), Block.COLLIDER, Fluid.NONE, this.mob));
            if (!bHit.getType().equals(Type.MISS)) {
               dest = bHit.getLocation();
               if (this.mob.level().noCollision(this.mob.getBoundingBox().move(this.mob.position().scale(-1.0)).move(dest))
                  && this.mob.navigation.moveTo(dest.x, dest.y, dest.z, (double)this.speed)) {
                  this.stop();
                  return;
               }
            }
         }
      }
   }

   static class ProtectTheAltarGoal extends Goal {
      final DeerFollowerEntity mob;
      final float speed;

      public ProtectTheAltarGoal(DeerFollowerEntity mob, float speed) {
         this.mob = mob;
         this.speed = speed;
         this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
      }

      public boolean canUse() {
         return this.mob.hasAltar && this.mob.getTarget() == null
            ? !this.mob
               .level()
               .getEntities(
                  EntityTypeTest.forClass(Player.class),
                  AABB.unitCubeFromLowerCorner(this.mob.getAltarMinCorner()).inflate(4.0),
                  i -> i.isAlive() && !i.isCreative() && !i.isSpectator()
               )
               .isEmpty()
            : false;
      }

      public void start() {
         super.start();
         Vec3 dest = this.mob.getAltar().getBottomCenter();
         if (!this.mob.navigation.moveTo(dest.x, dest.y, dest.z, 3, (double)this.speed)) {
            this.stop();
         }
      }
   }

   static class ReadBookGoal extends DeerFollowerEntity.ActivityGoal {
      public ReadBookGoal(DeerFollowerEntity mob, float chance) {
         super(mob, (byte)1, chance);
         this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
      }

      @Override
      public boolean canUse() {
         ItemStack offHand = this.mob.getOffhandItem();
         return (offHand.is(Items.BOOK) || offHand.is(Items.ENCHANTED_BOOK)) && super.canUse();
      }

      @Override
      public void start() {
         super.start();
         this.mob.navigation.stop();
         if ((double)this.mob.random.nextFloat() < 0.5) {
            this.mob.setPose(Pose.SITTING);
         }
      }

      public void tick() {
         super.tick();
         this.mob.setXRot(30.0F);
      }

      @Override
      public void stop() {
         super.stop();
         if (this.mob.getPose().equals(Pose.SITTING)) {
            this.mob.setPose(Pose.STANDING);
         }

         this.mob.setXRot(0.0F);
      }
   }

   static class SearchForAltarGoal extends RandomStrollGoal {
      final DeerFollowerEntity mob;

      public SearchForAltarGoal(DeerFollowerEntity mob, double speed) {
         super(mob, speed);
         this.mob = mob;
      }

      public boolean canUse() {
         return !this.mob.isHasAltar() && this.mob.getTarget() == null && super.canUse();
      }
   }

   static class WorshipGoal extends Goal {
      final DeerFollowerEntity mob;
      final int duration = 100;
      final float speed;
      int time;
      boolean arrived;

      public WorshipGoal(DeerFollowerEntity mob, float moveSpeed) {
         this.mob = mob;
         this.speed = moveSpeed;
         this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
      }

      public boolean canUse() {
         return this.mob.getTarget() == null
            && this.mob.hasAltar
            && (
               this.mob.random.nextFloat() < 0.001F
                  || !this.mob.isHasMask() && (double)this.mob.random.nextFloat() < 0.1
                  || this.mob.getHealth() < this.mob.getMaxHealth() && (double)this.mob.random.nextFloat() < 0.05
            );
      }

      public void start() {
         super.start();
         this.time = 100;
         this.arrived = false;
      }

      public boolean requiresUpdateEveryTick() {
         return true;
      }

      public void tick() {
         super.tick();
         Vec3 altar = this.mob.getAltar().getBottomCenter();
         if (!this.arrived && !this.mob.getAltar().closerToCenterThan(this.mob.position(), 4.0)) {
            if (this.mob.navigation.isDone()) {
               Vec3 dest = altar.add(
                  this.mob.position().subtract(altar).multiply(1.0, 0.0, 1.0).normalize().scale((double)(2.0F + this.mob.random.nextFloat()))
               );
               if (!this.mob.navigation.moveTo(dest.x, dest.y, dest.z, (double)(this.speed + (this.mob.isHasMask() ? 0.0F : 0.15F)))) {
                  this.stop();
               }
            }
         } else {
            if (!this.arrived) {
               this.arrived = true;
               this.mob.navigation.stop();
            }

            this.time--;
            this.mob.setActivity((byte)2);
            this.mob.lookAt(Anchor.EYES, altar);
         }
      }

      public boolean canContinueToUse() {
         return this.time > 0 && this.mob.getTarget() == null;
      }

      public boolean isInterruptable() {
         return !this.canContinueToUse();
      }

      public void stop() {
         super.stop();
         if (this.time <= 0) {
            if (!this.mob.isHasMask()) {
               this.mob.entityData.set(DeerFollowerEntity.MASK, true);
               this.mob.makeSound(SoundRegistry.CULTIST_MASK_RESTORE);
            } else {
               this.mob.level().broadcastEntityEvent(this.mob, (byte)14);
               this.mob.makeSound(SoundRegistry.CULTIST_WORSHIP_HEAL);
            }

            this.mob.heal(15.0F);
         }

         if (this.mob.isWorshipping()) {
            this.mob.setActivity((byte)0);
         }

         this.mob.setXRot(0.0F);
      }
   }
}
