package com.formidulus.mod.entities;

import net.neoforged.neoforge.network.PacketDistributor;
import com.formidulus.mod.Formidulus;
import com.formidulus.mod.block.BossSpawnerBlockEntity;
import com.formidulus.mod.components.FormidableComponents;
import com.formidulus.mod.components.entity.IBulwarkComponent;
import com.formidulus.mod.damage.DamageSources;
import com.formidulus.mod.datagen.Lang;
import com.formidulus.mod.entities.boss.BossFightManager;
import com.formidulus.mod.entities.boss.BossType;
import com.formidulus.mod.entities.goal.AnimatedAttackGoal;
import com.formidulus.mod.entities.goal.BossOutOfCombatGoal;
import com.formidulus.mod.entities.goal.BossTargetGoal;
import com.formidulus.mod.entities.goal.InterruptableGoal;
import com.formidulus.mod.network.BossMusicUpdatePayload;
import com.formidulus.mod.network.SequenceTriggerPayload;
import com.formidulus.mod.particle.BloodDropParticleEffect;
import com.formidulus.mod.registries.EntityRegistry;
import com.formidulus.mod.registries.ParticleRegistry;
import com.formidulus.mod.registries.SoundRegistry;
import com.formidulus.mod.registries.StatusEffectRegistry;
import java.util.EnumSet;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.SynchedEntityData.Builder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent.BossBarOverlay;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal.Flag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class DeerGodEntity extends BossEntity {
   static final List<Class<? extends LivingEntity>> ignoredClasses = List.of(DeerGodEntity.class, IrrlichtEntity.class);
   static final EntityDataAccessor<Boolean> SUMMONED = SynchedEntityData.defineId(DeerGodEntity.class, EntityDataSerializers.BOOLEAN);
   static final EntityDataAccessor<Boolean> LANTERN = SynchedEntityData.defineId(DeerGodEntity.class, EntityDataSerializers.BOOLEAN);
   static final EntityDataAccessor<Boolean> CLAW = SynchedEntityData.defineId(DeerGodEntity.class, EntityDataSerializers.BOOLEAN);
   static final EntityDataAccessor<Boolean> RANGED = SynchedEntityData.defineId(DeerGodEntity.class, EntityDataSerializers.BOOLEAN);
   static final EntityDataAccessor<Boolean> DYING = SynchedEntityData.defineId(DeerGodEntity.class, EntityDataSerializers.BOOLEAN);
   static final EntityDataAccessor<Byte> RUN_ATTACK = SynchedEntityData.defineId(DeerGodEntity.class, EntityDataSerializers.BYTE);
   static final EntityDataAccessor<Integer> TELEPORT_TIMER = SynchedEntityData.defineId(DeerGodEntity.class, EntityDataSerializers.INT);
   static final EntityDataAccessor<Integer> TELEPORT_COOLDOWN = SynchedEntityData.defineId(DeerGodEntity.class, EntityDataSerializers.INT);
   static final EntityDataAccessor<Integer> RANGED_COOLDOWN = SynchedEntityData.defineId(DeerGodEntity.class, EntityDataSerializers.INT);
   static final EntityDataAccessor<Integer> SCHEDULED_SPAWNS = SynchedEntityData.defineId(DeerGodEntity.class, EntityDataSerializers.INT);
   static final EntityDataAccessor<Integer> SWARM_TRANSITION_TICKS = SynchedEntityData.defineId(DeerGodEntity.class, EntityDataSerializers.INT);
   static final EntityDataAccessor<Integer> STRONG_COOLDOWN = SynchedEntityData.defineId(DeerGodEntity.class, EntityDataSerializers.INT);
   static final EntityDataAccessor<Integer> RUN_ATTACK_ANIM_SPEED = SynchedEntityData.defineId(DeerGodEntity.class, EntityDataSerializers.INT);
   static final EntityDataAccessor<Vector3f> NEXT_TELEPORT_DEST = SynchedEntityData.defineId(DeerGodEntity.class, EntityDataSerializers.VECTOR3);
   static final byte UNSUMMONED_POSE = 0;
   static final byte SPAWN_SEQUENCE_ANIM = 1;
   static final byte IDLE_ANIM = 2;
   static final byte SUMMON_LANTERN_ANIM = 3;
   static final byte SWING_ANIM = 4;
   static final byte SLAM_ANIM = 5;
   static final byte PHASE_TRANSITION_ANIM = 6;
   static final byte PREPARE_RUN_ATTACK_ANIM = 7;
   static final byte SIMPLE_CLAW_ATTACK_ANIM = 8;
   static final byte SLAM_CLAW_ATTACK_ANIM = 9;
   static final byte RUN_ATTACK_CLAW_ANIM = 10;
   static final byte RUN_ATTACK_LANTERN_ANIM = 11;
   static final byte RUN_ATTACK_WALL_IMPACT_ANIM = 12;
   static final byte DEATH_SEQUENCE_ANIM = 69;
   public static final byte RUN_ATTACK_NONE = 0;
   public static final byte RUN_ATTACK_CLAW = 1;
   public static final byte RUN_ATTACK_LANTERN = 2;
   public AnimationState unsummonedPoseAnimationState = new AnimationState();
   public AnimationState spawnSequenceAnimationState = new AnimationState();
   public AnimationState idleAnimationState = new AnimationState();
   public AnimationState swingAnimationState = new AnimationState();
   public AnimationState slamAnimationState = new AnimationState();
   public AnimationState summonLanternAnimationState = new AnimationState();
   public AnimationState holdLanternAnimationState = new AnimationState();
   public AnimationState noLanternAnimationState = new AnimationState();
   public AnimationState noClawAnimationState = new AnimationState();
   public AnimationState showClawAnimationState = new AnimationState();
   public AnimationState showClawWithoutExtrasAnimationState = new AnimationState();
   public AnimationState phaseTransitionAnimationState = new AnimationState();
   public AnimationState simpleClawAttackAnimationState = new AnimationState();
   public AnimationState slamClawAnimationState = new AnimationState();
   public AnimationState prepareRunAttackAnimationState = new AnimationState();
   public AnimationState runAttackClawAnimationState = new AnimationState();
   public AnimationState runAttackLanternAnimationState = new AnimationState();
   public AnimationState runAttackWallImpactAnimationState = new AnimationState();
   public AnimationState deathAnimationState = new AnimationState();
   int swingChain;
   int swarmAttack;
   int warnTimer;
   DamageSource killingBlow;
   Player killer;
   float rangedDamageTaken;
   float eyeGlow;
   boolean swarmAttackPending;

   public DeerGodEntity(EntityType<? extends BossEntity> entityType, Level world) {
      super(entityType, world, BossType.DEER);
      this.unsummonedPoseAnimationState.start(this.tickCount);
      this.holdLanternAnimationState.start(this.tickCount);
      this.noLanternAnimationState.start(this.tickCount);
      this.noClawAnimationState.start(this.tickCount);
      this.showClawAnimationState.start(this.tickCount);
      this.showClawWithoutExtrasAnimationState.start(this.tickCount);
      this.entityData.set(ANIMATION_START, this.tickCount);
   }

   @Override
   protected void defineSynchedData(Builder builder) {
      super.defineSynchedData(builder);
      builder.define(SUMMONED, false);
      builder.define(LANTERN, true);
      builder.define(CLAW, false);
      builder.define(RANGED, false);
      builder.define(DYING, false);
      builder.define(RUN_ATTACK, (byte)0);
      builder.define(TELEPORT_TIMER, Integer.MIN_VALUE);
      builder.define(TELEPORT_COOLDOWN, 200);
      builder.define(RANGED_COOLDOWN, 100);
      builder.define(SCHEDULED_SPAWNS, 0);
      builder.define(SWARM_TRANSITION_TICKS, 0);
      builder.define(STRONG_COOLDOWN, 40);
      builder.define(RUN_ATTACK_ANIM_SPEED, 1);
      builder.define(NEXT_TELEPORT_DEST, this.position().toVector3f());
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(0, new DeerGodEntity.SwarmGoal(this));
      this.goalSelector.addGoal(0, this.outOfCombatGoal = new BossOutOfCombatGoal(this, (byte)0));
      this.goalSelector.addGoal(0, new DeerGodEntity.TeleportAwayFromTargets(this));
      this.goalSelector.addGoal(0, new DeerGodEntity.TeleportRandomlyGoal(this));
      this.goalSelector.addGoal(1, new DeerGodEntity.RunClawAttackGoal(this, 0.9F));
      this.goalSelector.addGoal(1, new DeerGodEntity.SimpleClawAttackGoal(this));
      this.goalSelector.addGoal(1, new DeerGodEntity.SummonLanternGoal(this));
      this.goalSelector.addGoal(1, new DeerGodEntity.LanternSwingGoal(this));
      this.goalSelector.addGoal(1, new DeerGodEntity.LanternSlamClawGoal(this));
      this.goalSelector.addGoal(1, new DeerGodEntity.LanternSlamGoal(this));
      this.goalSelector.addGoal(1, new DeerGodEntity.ProjectileGoal(this));
      this.goalSelector.addGoal(2, new DeerGodEntity.TeleportToTargetGoal(this));
      this.goalSelector.addGoal(2, new DeerGodEntity.ApproachTargetGoal(this, 0.45F));
      this.targetSelector.addGoal(0, this.targetGoal = new BossTargetGoal(this, 16.0F, 200, 0.4F));
   }

   protected Component getTypeName() {
      return (Component)super.getTypeName().toFlatList(Style.EMPTY.withFont(Formidulus.FONT)).getFirst();
   }

   @Override
   public boolean isBossBarVisible() {
      return super.isBossBarVisible() && (Boolean)this.entityData.get(SUMMONED) && (Byte)this.entityData.get(ANIMATION) != 1;
   }

   @Override
   BossBarOverlay getBossBarStyle() {
      return BossBarOverlay.NOTCHED_20;
   }

   public float maxUpStep() {
      return 1.0F;
   }

   public void push(Entity entity) {
   }

   protected void doPush(Entity entity) {
   }

   public boolean isPickable() {
      List<Player> closePlayers = this.level().getEntities(EntityTypeTest.forClass(Player.class), this.getBoundingBox().inflate(1.0), Player::isCreative);
      if (!closePlayers.isEmpty()) {
         ItemStack stack = closePlayers.getFirst().getMainHandItem();
         if (stack.getItem() instanceof SpawnEggItem egg && this.getType().equals(egg.getType(stack))) {
            return true;
         }
      }

      return this.getVanishingPercent() < 0.5F && (Boolean)this.entityData.get(SUMMONED);
   }

   public boolean isPushedByFluid() {
      return false;
   }

   public boolean fireImmune() {
      return true;
   }

   @Override
   public void tick() {
      super.tick();
      if (!(Boolean)this.entityData.get(SUMMONED)) {
         this.tickCount = 0;
         if ((Boolean)Formidulus.config.deerWarning.getValue() && this.warnTimer-- <= 0 && !this.level().isClientSide) {
            this.level()
               .getEntities(
                  EntityTypeTest.forClass(ServerPlayer.class),
                  this.getBoundingBox().inflate(48.0, 32.0, 48.0),
                  p -> p.canBeSeenAsEnemy() && p.getArmorValue() < 20
               )
               .forEach(
                  p -> p.displayClientMessage(
                        Component.translatable(Lang.MESSAGE_DEER_WARNING + this.random.nextInt(4)).setStyle(Style.EMPTY.withColor(ChatFormatting.RED)), true
                     )
               );
            this.warnTimer = 500;
         }

         if (this.level().getGameTime() % 20L == 0L) {
            if (!this.isAnyCultistNearby()
               && !this.level()
                  .getEntities(EntityTypeTest.forClass(Player.class), this.getBoundingBox().inflate(12.0), p -> !p.isSpectator() && !p.isCreative())
                  .isEmpty()) {
               this.beginFight();
               this.setAnimation((byte)1);
               this.triggerMonologueSequence((byte)0);
               this.entityData.set(SUMMONED, true);
            } else if (this.level().getGameTime() % 1200L == 0L && this.getAllNearbyCultists().size() < this.getMaxCultists()) {
               this.spawnCultist(new Vec2(3.0F, 8.0F), true);
            }
         }
      } else {
         int teleportTimer = this.getTeleportTimer();
         if (teleportTimer == this.getTeleportFadeDuration() - 1) {
            this.playSound(SoundRegistry.DEER_PREPARE_TELEPORT, 1.0F, 1.0F + (1.0F - (float)this.getTeleportFadeDuration() / 40.0F));
         }

         if (teleportTimer == 0) {
            Vec3 dest = this.getNextTeleportDestination();
            this.playSound(SoundRegistry.DEER_PERFORM_TELEPORT, 0.6F, 1.0F);
            this.setPos(dest.x, dest.y, dest.z);
            if (this.getTarget() != null && this.distanceTo(this.getTarget()) < 6.0F) {
               this.lookAt(Anchor.FEET, this.getTarget().position());
            }

            this.playSound(SoundRegistry.DEER_PERFORM_TELEPORT, 0.6F, 1.0F);
         }

         if (!this.level().isClientSide) {
            if ((this.getTarget() == null || this.getTarget().isRemoved()) && !this.isNotInAttackAnimation() && !this.isInSequence()) {
               this.forceStopActiveGoals();
            }

            if (this.getHealth() < this.getMaxHealth() * 0.75F && (Integer)this.entityData.get(TELEPORT_COOLDOWN) > 0) {
               this.entityData.set(TELEPORT_COOLDOWN, (Integer)this.entityData.get(TELEPORT_COOLDOWN) - (int)(1.0F + this.getCooldownBonusSpeed()));
            }

            if (this.isTeleporting()) {
               this.entityData.set(TELEPORT_TIMER, (Integer)this.entityData.get(TELEPORT_TIMER) - 1);
            }

            if (this.rangedDamageTaken > 0.0F) {
               this.rangedDamageTaken -= 0.05F;
            }

            if ((Boolean)this.entityData.get(RANGED) && this.isTargetValid()) {
               this.entityData.set(RANGED_COOLDOWN, (Integer)this.entityData.get(RANGED_COOLDOWN) - (int)(1.0F + this.getCooldownBonusSpeed()));
            }

            if (!(Boolean)this.entityData.get(RANGED) && this.rangedDamageTaken > 50.0F) {
               this.entityData.set(RANGED, true);
               this.triggerMonologueSequence((byte)1);
            }

            if (this.isTargetValid() && this.hasClaw() && (Integer)this.entityData.get(STRONG_COOLDOWN) > 0) {
               this.entityData.set(STRONG_COOLDOWN, (Integer)this.entityData.get(STRONG_COOLDOWN) - (int)(1.0F + this.getCooldownBonusSpeed()));
            }

            this.yBodyRot = this.yHeadRot;
         }
      }
   }

   float getCooldownBonusSpeed() {
      return (float)this.level().getDifficulty().getId() * 0.44F * (1.0F - this.getHealthPercent());
   }

   public void aiStep() {
      super.aiStep();
      this.tickTimedAnimationEffects(this.getCurrentAnimation());
      if (this.shouldEyesGlow()) {
         this.eyeGlow = Math.min(this.eyeGlow + 0.05F, 1.0F);
      } else {
         this.eyeGlow = Math.max(this.eyeGlow - 0.05F, 0.0F);
      }

      float vanishing = this.getVanishingPercent();
      if (vanishing > 0.0F) {
         this.eyeGlow = Math.max(Mth.clamp(vanishing * 2.0F - Math.max(vanishing * 10.0F - 6.0F, 0.0F), 0.0F, 1.0F), this.eyeGlow);
      }

      if (vanishing > 0.0F) {
         int particles = (int)Math.ceil((double)(vanishing * 6.0F));
         if (this.isTeleporting()) {
            this.spawnVanishingParticles(particles, new Vec3(this.getX(), this.getY(), this.getZ()));
            this.spawnVanishingParticles(particles, this.getNextTeleportDestination());
            return;
         }

         int swarmTicks = (Integer)this.entityData.get(SWARM_TRANSITION_TICKS);
         if (swarmTicks > 0 && swarmTicks < 50) {
            if ((Integer)this.entityData.get(SCHEDULED_SPAWNS) > 0) {
               this.spawnVanishingParticles(
                  particles, new Vec3(this.getX(), this.getY(), this.getZ()), this.entityData.get(SCHEDULED_SPAWNS) == 0 ? 1.0F : 1.0F - vanishing
               );

               for (int i = 0; (float)i < (1.0F - (float)Math.abs(swarmTicks - 25) / 25.0F) * 32.0F; i++) {
                  Vec3 dir = Vec3.ZERO
                     .offsetRandom(this.random, 1.0F)
                     .multiply(1.0, 0.0, 1.0)
                     .normalize()
                     .scale((double)(0.05F + this.random.nextFloat() * 0.1F));
                  this.level().addParticle(ParticleRegistry.RISING_DARKNESS, true, this.getX(), this.getY() + 0.2F, this.getZ(), dir.x, dir.y, dir.z);
               }
            } else {
               this.spawnVanishingParticles(
                  particles, new Vec3(this.getX(), this.getY(), this.getZ()), this.entityData.get(SCHEDULED_SPAWNS) == 0 ? 1.0F : 1.0F - vanishing
               );
            }
         }
      }
   }

   void tickTimedAnimationEffects(byte animationID) {
      float duration = this.getCurrentAnimationDuration();
      switch (animationID) {
         case 1:
            float darkness = duration - 6.5F;
            if (!this.getAnimationFlag(0)) {
               this.setAnimationFlag(0, true);
               this.setAttackCooldown(20);
               if (!this.level().isClientSide) {
                  this.entityData.set(ORIGIN, this.blockPosition());
               }
            }

            if (duration < 8.7F) {
               for (int i = 0; (float)i < darkness * 3.0F; i++) {
                  Vec3 pos = new Vec3(this.getX(), this.getY(), this.getZ())
                     .add(
                        (double)((this.random.nextFloat() - 0.5F) * 2.2F),
                        (double)(this.random.nextFloat() * 4.5F * darkness) / 2.1999999999999993,
                        (double)((this.random.nextFloat() - 0.5F) * 2.2F)
                     );
                  this.level().addParticle(ParticleRegistry.DARKNESS, pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
               }
            }

            this.applyReverence(18.0F - duration);
            if (!this.level().isClientSide && duration >= 18.0F) {
               this.setAnimation((byte)2);
            }
            break;
         case 4:
            if (!this.getAnimationFlag(0) && duration >= 1.1F) {
               this.setAnimationFlag(0, true);
               this.playSound(SoundRegistry.DEER_SWING, 0.8F, 0.6F);
            }
            break;
         case 5:
            if (!this.getAnimationFlag(0) && duration >= 1.25F) {
               this.setAnimationFlag(0, true);
               this.playSound(SoundRegistry.DEER_SWING, 0.8F, 0.6F);
            }

            if (!this.getAnimationFlag(1) && duration >= 2.65F) {
               this.setAnimationFlag(1, true);
               this.playSound(SoundRegistry.DEER_SWING, 1.0F, 0.5F);
            }

            if (!this.getAnimationFlag(2) && duration >= 2.9F) {
               this.setAnimationFlag(2, true);
               Vec3 impactOffsetx = new Vec3(0.5, 0.0, 3.0).yRot((float)Math.toRadians((double)(-this.getYRot())));
               this.breakLanternEffect(impactOffsetx, true);

               for (int ix = 0; ix < (this.hasClaw() ? 6 : 3); ix++) {
                  Vec3 vel = Vec3.ZERO.offsetRandom(this.random, 1.5F);
                  vel = new Vec3(vel.x, Math.abs(vel.y * 0.2F), vel.z);
                  IrrlichtEntity funke = new IrrlichtEntity(EntityRegistry.IRRLICHT, this.level());
                  funke.setOwner(this);
                  funke.setPos(this.position().add(impactOffsetx));
                  funke.setDeltaMovement(vel);
                  funke.setLifetime(300 + (int)(this.random.nextFloat() * 50.0F));
                  this.level().addFreshEntity(funke);
               }

               BlockState state = this.level().getBlockState(BlockPos.containing(this.position().add(impactOffsetx).subtract(0.0, 0.5, 0.0)));

               for (int ix = 0; ix < 32; ix++) {
                  Vec3 rand = Vec3.ZERO.offsetRandom(this.random, 2.0F);
                  Vec3 pos = this.position().add(impactOffsetx).add(0.0, 0.1F, 0.0).add(rand.multiply(1.0, 0.0, 1.0));
                  this.level().addParticle(new BlockParticleOption(ParticleTypes.DUST_PILLAR, state), pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
               }
            }
            break;
         case 6:
            if (!this.hasClaw()) {
               this.setHasClaw(true);
            }

            if (this.hasLantern()) {
               this.setHasLantern(false);
            }

            if (!this.getAnimationFlag(0) && duration >= 0.0F) {
               this.setAnimationFlag(0, true);
               this.triggerMonologueSequence((byte)2);
               this.setAttackCooldown(20);
               if (!this.level().isClientSide) {
                  this.bossFight.getAllParticipants().forEach(p -> PacketDistributor.sendToPlayer(p, new BossMusicUpdatePayload(this.type.id(), "cancel")));
               }
            }

            if (!this.level().isClientSide && !this.getAnimationFlag(10) && duration >= 1.75F) {
               this.setAnimationFlag(10, true);
               this.bossFight.setPhase(1);
            }

            if (duration >= 3.5F && duration <= 4.0F) {
               if (!this.getAnimationFlag(1)) {
                  this.setAnimationFlag(1, true);
                  this.playSound(SoundRegistry.DEER_PREPARE_TELEPORT, 0.6F, 1.0F);
               }

               this.spawnVanishingParticles(12, this.position());
               this.spawnVanishingParticles(12, this.getOriginBlock().getBottomCenter());
            }

            if (!this.getAnimationFlag(2) && duration >= 4.05F) {
               this.setAnimationFlag(2, true);
               BlockPos pos = (BlockPos)this.entityData.get(ORIGIN);
               this.playSound(SoundRegistry.DEER_PERFORM_TELEPORT, 0.6F, 1.0F);
               this.setPos((double)((float)pos.getX() + 0.5F), (double)pos.getY(), (double)((float)pos.getZ() + 0.5F));
               this.playSound(SoundRegistry.DEER_PERFORM_TELEPORT, 0.6F, 1.0F);
               this.setYRot(this.yRotO = this.yHeadRot = this.yHeadRotO = this.yBodyRot = this.yBodyRotO = 0.0F);
            }

            if (!this.getAnimationFlag(3) && duration >= 5.5F) {
               this.setAnimationFlag(3, true);
               this.playSound(SoundRegistry.DEER_SUMMON_BLOOD, 0.5F, 0.75F);
               if (this.level().isClientSide) {
                  Vec3 dest = this.position()
                     .add((double)((float)this.getLookAngle().x), (double)(this.getBbHeight() / 2.0F), (double)((float)this.getLookAngle().z));

                  for (int i = 0; i < 111; i++) {
                     Vec3 dir = Vec3.ZERO.offsetRandom(this.random, 1.0F).multiply(1.0, 0.0, 1.0);
                     Vec3 pos = this.position().add(dir.normalize().scale((double)((this.getRandom().nextFloat() - 0.5F) * 2.0F * 16.0F)));
                     BlockHitResult bHit = this.level()
                        .clip(new ClipContext(pos.add(0.0, 2.0, 0.0), pos.subtract(0.0, 2.0, 0.0), Block.COLLIDER, Fluid.NONE, this));
                     if (!bHit.getType().equals(Type.MISS)) {
                        this.level()
                           .addParticle(
                              new BloodDropParticleEffect(dest.toVector3f()),
                              (double)((float)pos.x),
                              (double)((float)bHit.getLocation().y),
                              (double)((float)pos.z),
                              0.0,
                              0.0,
                              0.0
                           );
                     }
                  }
               }

               for (int ix = 0; ix < 6; ix++) {
                  Vec3 dir = Vec3.ZERO.offsetRandom(this.random, 1.0F).multiply(1.0, 0.0, 1.0);
                  Vec3 pos = this.position().add(dir.normalize().scale((double)((this.getRandom().nextFloat() - 0.5F) * 2.0F * 16.0F)));
                  this.level()
                     .playSound(this, BlockPos.containing(pos), SoundRegistry.DEER_BUBBLING, SoundSource.HOSTILE, 1.0F, 0.95F + this.random.nextFloat() * 0.1F);
               }
            }

            if (!this.getAnimationFlag(4) && duration >= 13.0F) {
               this.setAnimationFlag(4, true);
               this.playSound(SoundRegistry.DEER_SHAPE_FLESH, 5.0F, 0.6F);
            }

            if (!this.getAnimationFlag(6) && duration >= 16.0F) {
               this.setAnimationFlag(6, true);
               this.playSound(SoundRegistry.DEER_DRAW_CLAWS, 15.0F, 1.0F);
            }

            if (!this.getAnimationFlag(5) && duration >= 16.25F) {
               this.setAnimationFlag(5, true);
               this.playSound(SoundRegistry.DEER_ROAR, 15.0F, 1.0F);
               if (this.bossFight != null && !this.level().isClientSide) {
                  this.bossFight.getAllParticipants().forEach(ix -> ix.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 0, 2, false, false)));
               }
            }

            if (duration > 4.05F) {
               this.applyReverence(18.0F - duration);
            }

            if (!this.level().isClientSide && duration >= 18.05F) {
               this.setAnimation((byte)2);
            }
            break;
         case 7:
            for (int ix = 0; ix < 4; ix++) {
               Vec3 pos = this.position().add(Vec3.ZERO.offsetRandom(this.random, 2.0F).multiply(1.0, 0.0, 1.0)).add(0.0, 0.1, 0.0);
               Vec3 vel = Vec3.ZERO.offsetRandom(this.random, 0.5F);
               this.level().addParticle(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER, true, pos.x, pos.y, pos.z, 0.0, vel.y, 0.0);
            }
            break;
         case 8:
            if (!this.getAnimationFlag(1) && duration >= 0.5F) {
               this.setAnimationFlag(1, true);
               this.playSound(SoundRegistry.DEER_SWING, 1.0F, 0.5F);
            }
            break;
         case 9:
            if (duration <= 2.7F) {
               this.tickTimedAnimationEffects((byte)5);
               return;
            }

            if (!this.getAnimationFlag(2) && duration >= 2.9F) {
               this.setAnimationFlag(2, true);
               this.playSound(SoundRegistry.DEER_LANTERN_IMPACT, 5.0F, 0.5F);
            }

            if (!this.getAnimationFlag(3) && duration >= 4.2F) {
               this.setAnimationFlag(3, true);
               this.playSound(SoundRegistry.DEER_SWING, 1.0F, 0.5F);
            }

            if (duration >= 4.3F && duration <= 5.3F) {
               Vec3 impactOffset = new Vec3(0.5, 0.0, 3.0).yRot((float)Math.toRadians((double)(-this.getYRot())));
               if (!this.getAnimationFlag(4)) {
                  this.setAnimationFlag(4, true);
                  this.breakLanternEffect(impactOffset, false);
                  this.playSound(SoundRegistry.DEER_LANTERN_CRUSH, 1.0F, 0.75F);
                  BlockState state = this.level().getBlockState(BlockPos.containing(this.position().add(impactOffset).subtract(0.0, 0.5, 0.0)));

                  for (int ix = 0; ix < 32; ix++) {
                     Vec3 rand = Vec3.ZERO.offsetRandom(this.random, 3.0F);
                     Vec3 pos = this.position().add(impactOffset).add(0.0, 0.1F, 0.0).add(rand.multiply(1.0, 0.0, 1.0));
                     this.level().addParticle(new BlockParticleOption(ParticleTypes.DUST_PILLAR, state), pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
                  }
               }

               float intensity = 1.0F - (duration - 4.3F);
               Vec3 pos = this.position().add(impactOffset).add(0.0, 0.1F, 0.0);

               for (int ix = 0; ix < Math.round(48.0F * intensity); ix++) {
                  Vec3 dir = Vec3.ZERO
                     .offsetRandom(this.random, 1.0F)
                     .multiply(1.0, 0.0, 1.0)
                     .normalize()
                     .scale((double)(this.random.nextFloat() + 0.5F * (intensity + 0.1F)));
                  this.level().addParticle(ParticleTypes.FLAME, true, pos.x, pos.y, pos.z, dir.x, dir.y, dir.z);
               }

               for (int ix = 0; ix < Math.round(6.0F * intensity); ix++) {
                  this.level().addParticle(ParticleTypes.LAVA, true, pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
               }

               if (this.tickCount % 3 == 0) {
                  this.playSound(SoundRegistry.DEER_SCORCH, 1.5F, 0.9F + this.random.nextFloat() * 0.2F);
               }
            }
            break;
         case 10:
            if (!this.getAnimationFlag(1) && duration >= 0.0F) {
               this.setAnimationFlag(1, true);
               this.playSound(SoundRegistry.DEER_KNIFE, 1.0F, 1.0F);
            }

            if (!this.getAnimationFlag(2) && duration >= 0.5F) {
               Vec3 offset = new Vec3(0.0, 0.0, 2.0).yRot((float)Math.toRadians((double)(-this.getYRot())));
               this.setAnimationFlag(2, true);
               BlockState state = this.level().getBlockState(BlockPos.containing(this.position().subtract(0.0, 0.5, 0.0)));

               for (int ix = 0; ix < 32; ix++) {
                  Vec3 rand = Vec3.ZERO.offsetRandom(this.random, 2.0F);
                  Vec3 pos = this.position().add(offset).add(0.0, 0.15F, 0.0).add(rand.multiply(1.5, 0.0, 1.5));
                  this.level().addParticle(new BlockParticleOption(ParticleTypes.DUST_PILLAR, state), pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
               }
            }
            break;
         case 12:
            if (!this.getAnimationFlag(0)) {
               this.setAnimationFlag(0, true);
               if (this.hasLantern()) {
                  this.breakLanternEffect(new Vec3(1.0, 0.0, 0.0).yRot((float)Math.toRadians((double)(-this.getYRot()))), true);
               }

               this.playSound(SoundRegistry.DEER_WALL_IMPACT, 1.0F, 0.8F);
            }

            this.setHasLantern(false);
            break;
         case 69:
            if (this.getCurrentAnimation() == 69) {
               this.applyReverence(20.0F - duration);
            }

            if (duration >= 28.0F && !this.isRemoved() && !this.level().isClientSide) {
               this.level().broadcastEntityEvent(this, (byte)60);
               this.remove(RemovalReason.KILLED);
               this.dropFromLootTable(this.killingBlow, this.killer != null);
            }
      }

      if ((Byte)this.entityData.get(RUN_ATTACK) == 1 && (Byte)this.entityData.get(ANIMATION) == 2 && this.tickCount % 15 == 0) {
         this.playSound(SoundRegistry.DEER_GRIND, 0.8F, 0.7F);
      }

      if (this.isInSequence() && (Integer)this.entityData.get(SWARM_TRANSITION_TICKS) > 0) {
         this.entityData.set(SWARM_TRANSITION_TICKS, 0);
      }
   }

   void breakLanternEffect(Vec3 offset, boolean flames) {
      if (flames) {
         for (int i = 0; i < 32; i++) {
            Vec3 pos = this.position().add(offset).offsetRandom(this.random, 0.5F);
            Vec3 vel = Vec3.ZERO.offsetRandom(this.random, 0.75F);
            vel = new Vec3(vel.x, Math.abs(vel.y), vel.z);
            this.level().addParticle(ParticleTypes.FLAME, pos.x, pos.y, pos.z, vel.x, vel.y, vel.z);
         }
      }

      for (int i = 0; i < 64; i++) {
         Vec3 pos = this.position().add(0.0, 0.75, 0.0).add(offset).offsetRandom(this.random, 1.5F);
         this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.LANTERN.defaultBlockState()), pos.x, pos.y, pos.z, 0.0, 0.0, 0.0);
      }

      this.playSound(SoundRegistry.DEER_LANTERN_BREAK, 0.8F, 0.6F);
      this.playSound(SoundRegistry.DEER_LANTERN_IMPACT, 5.0F, 0.5F);
   }

   void spawnVanishingParticles(int count, Vec3 origin) {
      this.spawnVanishingParticles(count, origin, 1.0F);
   }

   void spawnVanishingParticles(int count, Vec3 origin, float heightPercent) {
      for (int i = 0; i < count; i++) {
         Vec3 pos = origin.add(
            (double)((this.random.nextFloat() - 0.5F) * 2.0F),
            (double)(this.random.nextFloat() * 4.5F * heightPercent),
            (double)((this.random.nextFloat() - 0.5F) * 2.0F)
         );
         Vec3 vel = Vec3.ZERO.offsetRandom(this.random, 0.02F);
         this.level().addParticle(ParticleRegistry.DARKNESS, true, pos.x, pos.y, pos.z, vel.x, vel.y, vel.z);
      }
   }

   protected void playStepSound(BlockPos pos, BlockState state) {
      super.playStepSound(pos, state);
      if (this.hasLantern()) {
         this.playSound(SoundRegistry.DEER_STEP_LANTERN, 0.1F, 0.6F);
      }
   }

   protected void playHurtSound(DamageSource damageSource) {
      super.playHurtSound(damageSource);
      this.playSound(SoundRegistry.DEER_HURT, 0.5F, 0.6F);
   }

   void applyReverence(float remainingTime) {
      if (!this.level().isClientSide) {
         if (remainingTime > 2.0F) {
            this.bossFight.getAllParticipants().forEach(p -> p.addEffect(new MobEffectInstance(StatusEffectRegistry.REVERENCE, 20, 0, false, false)));
         }

         if (remainingTime > 0.0F) {
            this.level().getEntities(this, this.getBoundingBox().inflate(32.0), i -> !i.isAlwaysTicking()).forEach(e -> {
               if (!(e instanceof Player) && e instanceof LivingEntity living) {
                  living.addEffect(new MobEffectInstance(StatusEffectRegistry.REVERENCE, 40, 0, false, true));
               }
            });
         }
      }
   }

   void applyDarkness(int duration) {
      if (!this.level().isClientSide) {
         this.bossFight.getAllParticipants().forEach(p -> p.addEffect(new MobEffectInstance(StatusEffectRegistry.DARKNESS, duration, 0, false, false, true)));
      }
   }

   @Override
   public Vec3 getFocusPos() {
      if (this.getCurrentAnimation() == 1 && this.getCurrentAnimationDuration() <= 8.5F) {
         float height = this.getCurrentAnimationDuration() - 6.5F;
         return this.position().add(0.0, (double)(Math.max(height / 2.0F, 0.0F) * (this.getEyeHeight() - 0.5F)), 0.0);
      } else {
         return this.getCurrentAnimation() == 69 && this.getCurrentAnimationDuration() > 15.0F
            ? super.getFocusPos().subtract(0.0, (double)(0.5F + Math.min((this.getCurrentAnimationDuration() - 15.0F) / 2.0F, 1.0F)), 0.0)
            : super.getFocusPos().subtract(0.0, 0.5, 0.0);
      }
   }

   void triggerMonologueSequence(byte id) {
      if (!this.level().isClientSide && this.bossFight != null) {
         this.bossFight.getAllParticipants().forEach(i -> PacketDistributor.sendToPlayer(i, new SequenceTriggerPayload(id)));
      }
   }

   @Nullable
   @Override
   protected AnimationState getAnimationState(byte id) {
      return switch (id) {
         case 0 -> this.unsummonedPoseAnimationState;
         case 1 -> this.spawnSequenceAnimationState;
         case 2 -> this.idleAnimationState;
         case 3 -> this.summonLanternAnimationState;
         case 4 -> this.swingAnimationState;
         case 5 -> this.slamAnimationState;
         case 6 -> this.phaseTransitionAnimationState;
         case 7 -> this.prepareRunAttackAnimationState;
         case 8 -> this.simpleClawAttackAnimationState;
         case 9 -> this.slamClawAnimationState;
         case 10 -> this.runAttackClawAnimationState;
         case 11 -> this.runAttackLanternAnimationState;
         case 12 -> this.runAttackWallImpactAnimationState;
         case 69 -> this.deathAnimationState;
         default -> null;
      };
   }

   @Override
   public boolean isTargetValid() {
      return super.isTargetValid() && !this.isInSequence();
   }

   @Override
   public boolean isInSequence() {
      byte anim = this.getCurrentAnimation();
      return anim == 1 || anim == 6 || anim == 69;
   }

   @Override
   public boolean isNotInAttackAnimation() {
      byte anim = this.getCurrentAnimation();
      return anim != 4 && anim != 5 && anim != 3 && anim != 8 && anim != 7 && anim != 10 && anim != 9 && anim != 11;
   }

   public boolean shouldEyesGlow() {
      float animDuration = this.getCurrentAnimationDuration();
      return this.getCurrentAnimation() == 1
         ? animDuration > 2.0F && animDuration < 8.5F
         : this.hasClaw() && (this.getCurrentAnimation() != 6 || !(animDuration < 2.0F)) && this.getCurrentAnimation() != 69;
   }

   public float getEyeGlow() {
      return this.eyeGlow;
   }

   public boolean isSpineVisible() {
      return this.getCurrentAnimation() == 1 ? this.getCurrentAnimationDuration() >= 8.7F : true;
   }

   public boolean hasLantern() {
      return (Boolean)this.entityData.get(LANTERN);
   }

   public void setHasLantern(boolean b) {
      this.entityData.set(LANTERN, b);
   }

   public boolean hasClaw() {
      return (Boolean)this.entityData.get(CLAW);
   }

   public void setHasClaw(boolean b) {
      this.entityData.set(CLAW, b);
   }

   public boolean shouldApplyLampArmPose() {
      byte anim = this.getCurrentAnimation();
      return anim == 2 || anim == 10 || anim == 7 || anim == 8;
   }

   public boolean shouldApplyClawPose() {
      byte anim = this.getCurrentAnimation();
      return anim != 6 && anim != 69 && anim != 10 && anim != 8 && anim != 12 && anim != 9;
   }

   public boolean shouldShowClawWithoutExtras() {
      return this.getCurrentAnimation() == 5 || this.getCurrentAnimation() == 4;
   }

   public boolean shouldRun() {
      return this.hasClaw();
   }

   public boolean shouldPlayRunAnimation() {
      return this.shouldRun() && this.getDeltaMovement().length() > 0.1F;
   }

   public byte getRunAttackState() {
      return (Byte)this.entityData.get(RUN_ATTACK);
   }

   public void setRunAttackState(byte attackType) {
      this.entityData.set(RUN_ATTACK, (byte)(attackType % 3));
   }

   public int getStrongAttackCooldown() {
      return (Integer)this.entityData.get(STRONG_COOLDOWN);
   }

   public void setStrongCooldown(int ticks) {
      this.entityData.set(STRONG_COOLDOWN, ticks);
   }

   public boolean canSpawnSprintParticle() {
      return this.shouldPlayRunAnimation();
   }

   protected void spawnSprintParticle() {
      super.spawnSprintParticle();
      if (this.getRunAttackState() == 1) {
         Vec3 pos = this.position()
            .subtract(new Vec3(1.0, 0.0, 1.5).yRot((float)Math.toRadians((double)(-this.getYRot()))))
            .add(Vec3.ZERO.offsetRandom(this.random, 1.0F).multiply(1.0, 0.0, 1.0));
         this.level().addParticle(ParticleTypes.CRIT, pos.x, pos.y, pos.z, 0.0, (double)(1.0F + this.random.nextFloat() * 0.15F), 0.0);
      }
   }

   @Override
   public boolean hurt(DamageSource source, float amount) {
      if (!source.is(DamageTypes.FELL_OUT_OF_WORLD) && !source.is(DamageTypes.GENERIC_KILL)) {
         if (!this.isInSequence() && !(this.getVanishingPercent() > 0.5F) && this.isActive()) {
            boolean b = super.hurt(source, amount);
            if (this.level().isClientSide) {
               return b;
            } else {
               if (b && source.getEntity() != null && this.distanceTo(source.getEntity()) > 10.0F
                  || source.getDirectEntity() != null && source.getDirectEntity() instanceof Projectile) {
                  this.rangedDamageTaken += amount;
               }

               if (this.getHealth() <= 0.0F) {
                  this.entityData.set(DYING, true);
                  this.forceStopActiveGoals();
                  this.setAnimation((byte)69);
                  this.triggerMonologueSequence((byte)5);
                  this.shouldUpdateBossbar = false;
                  if (this.bossBar != null) {
                     this.bossBar.setProgress(0.0F);
                  }

                  this.setHealth(1.0F);
                  this.killingBlow = source;
                  if (source.getEntity() instanceof Player player) {
                     this.killer = player;
                  }

                  if (this.killer == null && source.getDirectEntity() instanceof Player player) {
                     this.killer = player;
                  }

                  if (this.killer != null) {
                     this.lookAt(Anchor.EYES, this.killer.getEyePosition());
                  }

                  this.bossFight.markWon();
                  BossFightManager.INSTANCE.endFight(this.bossFight);
                  return b;
               } else if (!(Boolean)this.entityData.get(CLAW) && b && this.getHealth() <= this.getMaxHealth() / 2.0F && this.getHealth() > 0.0F) {
                  this.forceStopActiveGoals();
                  this.setAnimation((byte)6);
                  this.entityData.set(CLAW, true);
                  this.setHealth(this.getMaxHealth() / 2.0F);
                  return true;
               } else {
                  if (this.swarmAttack == 0 && this.getHealthPercent() < 0.75F || this.swarmAttack == 1 && this.getHealthPercent() < 0.25F) {
                     this.swarmAttackPending = true;
                     this.swarmAttack++;
                  }

                  return b;
               }
            }
         } else {
            return false;
         }
      } else {
         return super.hurt(source, amount);
      }
   }

   @Override
   protected void forceStopActiveGoals() {
      super.forceStopActiveGoals();
      this.entityData.set(TELEPORT_TIMER, Integer.MIN_VALUE);
      this.setAnimation((byte)2);
      this.entityData.set(SWARM_TRANSITION_TICKS, 0);
      this.entityData.set(SCHEDULED_SPAWNS, 0);
      this.entityData.set(TELEPORT_TIMER, Integer.MIN_VALUE);
      this.level()
         .getEntities(EntityTypeTest.forClass(IrrlichtEntity.class), this.box(this.position()).inflate(32.0), i -> i.owner == this)
         .forEach(LivingEntity::kill);
   }

   protected boolean canRide(Entity entity) {
      return false;
   }

   protected boolean shouldDropLoot() {
      return false;
   }

   protected void tickDeath() {
      DamageSource var2 = this.getLastDamageSource();
      if (var2 instanceof DamageSource && (var2.is(DamageTypes.GENERIC_KILL) || var2.is(DamageTypes.FELL_OUT_OF_WORLD))) {
         this.level().broadcastEntityEvent(this, (byte)60);
         this.remove(RemovalReason.KILLED);
      }
   }

   public void handleEntityEvent(byte status) {
      if (status != 60) {
         super.handleEntityEvent(status);
      } else {
         for (int i = 0; i < 160; i++) {
            Vec3 pos = new Vec3(this.getX(), this.getY(), this.getZ())
               .add(
                  new Vec3(
                        (double)((this.random.nextFloat() - 0.5F) * 2.0F),
                        (double)(this.random.nextFloat() * 0.75F),
                        (double)((this.random.nextFloat() - 0.5F) * 4.0F)
                     )
                     .yRot((float)Math.toRadians((double)(-this.yBodyRot)))
               );
            Vec3 vel = Vec3.ZERO.offsetRandom(this.random, 0.01F).multiply(1.0, 0.0, 1.0);
            this.level().addParticle(ParticleRegistry.RISING_DARKNESS, pos.x, pos.y, pos.z, vel.x, vel.y, vel.z);
         }
      }
   }

   void setNextTeleport(Vec3 destination, int delay) {
      this.entityData.set(TELEPORT_TIMER, delay);
      this.entityData.set(NEXT_TELEPORT_DEST, destination.toVector3f());
   }

   public int getTeleportTimer() {
      return (Integer)this.entityData.get(TELEPORT_TIMER);
   }

   public Vec3 getNextTeleportDestination() {
      return new Vec3((Vector3f)this.entityData.get(NEXT_TELEPORT_DEST));
   }

   public float getVanishingPercent() {
      if (this.isInSequence()) {
         return 0.0F;
      } else {
         return this.entityData.get(SWARM_TRANSITION_TICKS) > 0
            ? Math.min((float)((Integer)this.entityData.get(SWARM_TRANSITION_TICKS)).intValue() / 20.0F, 1.0F)
            : Mth.clamp(1.0F - Math.abs((float)this.getTeleportTimer()) / (float)this.getTeleportFadeDuration(), 0.0F, 1.0F);
      }
   }

   @Override
   public boolean isReadyToAttack() {
      return super.isReadyToAttack()
         && (Boolean)this.entityData.get(SUMMONED)
         && !this.isInSequence()
         && this.getVanishingPercent() < 0.33F
         && !this.isAboutToTeleport()
         && (Integer)this.entityData.get(SCHEDULED_SPAWNS) == 0
         && this.getRunAttackState() == 0
         && !(Boolean)this.entityData.get(DYING);
   }

   public boolean isReadyToTeleport() {
      return (Integer)this.entityData.get(TELEPORT_COOLDOWN) <= 0 && this.getHealthPercent() <= 0.75F;
   }

   public void setTeleportCooldown(int cooldown) {
      this.entityData.set(TELEPORT_COOLDOWN, cooldown);
   }

   public int getTeleportFadeDuration() {
      return 40 - 20 * Math.round(1.0F - (Math.max(this.getHealthPercent(), 0.5F) - 0.5F) * 4.0F);
   }

   public boolean isTeleporting() {
      return (Integer)this.entityData.get(TELEPORT_TIMER) > -this.getTeleportFadeDuration();
   }

   public boolean isAboutToTeleport() {
      return (Integer)this.entityData.get(TELEPORT_TIMER) >= 0;
   }

   protected float getDamageAfterArmorAbsorb(DamageSource source, float amount) {
      float armor = (float)this.getAttributeValue(Attributes.ARMOR) * ((float)this.level().getDifficulty().getId() * 0.75F + 1.0F);
      float toughness = (float)this.getAttributeValue(Attributes.ARMOR_TOUGHNESS) * ((float)this.level().getDifficulty().getId() * 0.75F + 1.0F);
      return CombatRules.getDamageAfterAbsorb(this, amount, source, armor, toughness);
   }

   @Override
   public void beforeBossReset() {
      this.getAllNearbyCultists().forEach(i -> {
         if (this.equals(i.getMaster())) {
            i.discard();
         }
      });
   }

   @Override
   public void afterBossReset() {
      Vec2 range = new Vec2(2.0F, 7.0F);
      int count = this.getMaxCultists() - this.getAllNearbyCultists().size();

      for (int i = 0; i < count; i++) {
         this.spawnCultist(range, true);
      }

      if (this.level() instanceof ServerLevel serverWorld && serverWorld.getBlockEntity(this.blockPosition()) instanceof BossSpawnerBlockEntity bossSpawner) {
         bossSpawner.addBossEntity(this);
      }
   }

   @Override
   public BossType getBossType() {
      return BossType.DEER;
   }

   @Override
   public boolean isActive() {
      return (Boolean)this.entityData.get(SUMMONED);
   }

   int getMaxCultists() {
      return 4 + Math.max(this.level().getDifficulty().getId() - 2, 0);
   }

   boolean isAnyCultistNearby() {
      return !this.getAllNearbyCultists().isEmpty();
   }

   List<DeerFollowerEntity> getAllNearbyCultists() {
      return this.level()
         .getEntities(
            EntityTypeTest.forClass(DeerFollowerEntity.class),
            AABB.unitCubeFromLowerCorner(this.getOriginBlockMinCorner()).inflate(48.0),
            LivingEntity::canBeSeenByAnyone
         );
   }

   public boolean isInvisible() {
      return super.isInvisible() || (Integer)this.entityData.get(SWARM_TRANSITION_TICKS) == 50;
   }

   public void spawnCultist(Vec2 distanceRange, boolean persistent) {
      if (this.level() instanceof ServerLevel serverWorld) {
         DeerFollowerEntity var10 = new DeerFollowerEntity(EntityRegistry.DEER_FOLLOWER, this.level());
         Vec3 pos = null;

         for (int ii = 0; ii < 16; ii++) {
            Vec3 dir = Vec3.ZERO.offsetRandom(this.random, 1.0F).multiply(1.0, 0.0, 1.0).normalize();
            Vec3 randomPos = this.position().add(dir.scale((double)Mth.lerp(this.random.nextFloat(), distanceRange.x, distanceRange.y)));
            BlockHitResult bHit = this.level()
               .clip(new ClipContext(randomPos.add(0.0, 6.0, 0.0), randomPos.subtract(0.0, 12.0, 0.0), Block.COLLIDER, Fluid.NONE, this));
            if (!bHit.getType().equals(Type.MISS) && this.level().noCollision(var10.getBoundingBox().move(bHit.getLocation()))) {
               pos = bHit.getLocation();
               break;
            }
         }

         if (pos == null) {
            var10.discard();
            Formidulus.LOGGER.warn("Couldn't find valid spot to spawn Cultist around Deer at [{} {} {}]", new Object[]{this.getX(), this.getY(), this.getZ()});
         } else {
            var10.setMaster(this);
            var10.setPos(pos);
            var10.setTarget(this.getRandomTarget());
            if (persistent) {
               var10.setPersistenceRequired();
            }

            if (this.level().addFreshEntity(var10)) {
               this.level().broadcastEntityEvent(var10, (byte)20);
               var10.finalizeSpawn(serverWorld, this.level().getCurrentDifficultyAt(this.blockPosition()), MobSpawnType.SPAWNER, null);
               var10.playSound(SoundRegistry.DEER_SUMMON_CULTIST, 1.0F, 1.0F);
            }
         }
      }
   }

   public boolean killedEntity(ServerLevel world, LivingEntity other) {
      if (this.targetGoal.isHasNoTargets()) {
         this.combatTimer = 0;
      }

      return super.killedEntity(world, other);
   }

   @Override
   public List<Class<? extends LivingEntity>> getIgnoredClasses() {
      return ignoredClasses;
   }

   public int getRunAttackAnimSpeed() {
      return (Integer)this.entityData.get(RUN_ATTACK_ANIM_SPEED);
   }

   @Override
   int getFightPhase() {
      if (!(Boolean)this.entityData.get(SUMMONED)) {
         return -1;
      } else {
         return this.entityData.get(CLAW) ? 1 : 0;
      }
   }

   @Override
   public void readAdditionalSaveData(CompoundTag nbt) {
      if (nbt.contains("Summoned", 1)) {
         this.entityData.set(SUMMONED, nbt.getBoolean("Summoned"));
         this.setAnimation((byte)2);
      }

      if (nbt.contains("Claw", 1)) {
         this.entityData.set(CLAW, nbt.getBoolean("Claw"));
      }

      if (nbt.contains("Lantern", 1)) {
         this.entityData.set(LANTERN, nbt.getBoolean("Lantern"));
      }

      if (nbt.contains("Ranged", 1)) {
         this.entityData.set(RANGED, nbt.getBoolean("Ranged"));
      }

      if (nbt.contains("RangedDamageTaken", 5)) {
         this.rangedDamageTaken = nbt.getFloat("RangedDamageTaken");
      }

      if (nbt.contains("SwarmAttack", 3)) {
         this.swarmAttack = nbt.getInt("SwarmAttack");
      }

      super.readAdditionalSaveData(nbt);
   }

   @Override
   public void addAdditionalSaveData(CompoundTag nbt) {
      super.addAdditionalSaveData(nbt);
      if ((Boolean)this.entityData.get(SUMMONED)) {
         nbt.putBoolean("Summoned", true);
      }

      if ((Boolean)this.entityData.get(LANTERN)) {
         nbt.putBoolean("Lantern", true);
      }

      if ((Boolean)this.entityData.get(CLAW)) {
         nbt.putBoolean("Claw", true);
      }

      if ((Boolean)this.entityData.get(RANGED)) {
         nbt.putBoolean("Ranged", true);
      }

      if (this.rangedDamageTaken > 0.0F) {
         nbt.putFloat("RangedDamageTaken", this.rangedDamageTaken);
      }

      if (this.swarmAttack > 0) {
         nbt.putInt("SwarmAttack", this.swarmAttack);
      }
   }

   static class ApproachTargetGoal extends InterruptableGoal {
      final DeerGodEntity mob;
      int time;
      boolean failed;
      float speed;

      public ApproachTargetGoal(DeerGodEntity mob, float speed) {
         this.mob = mob;
         this.speed = speed;
         this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
      }

      public boolean canUse() {
         return this.mob.isReadyToAttack();
      }

      @Override
      public void start() {
         super.start();
         this.failed = false;
         this.time = 0;
      }

      public boolean canContinueToUse() {
         return this.mob.isTargetValid()
            && this.mob.isNotInAttackAnimation()
            && !(this.mob.distanceTo(this.mob.getTarget()) <= 3.0F)
            && !this.failed
            && !this.mob.isTeleporting();
      }

      public void tick() {
         this.time++;
         super.tick();
         if (this.mob.getTarget() != null && !this.mob.getTarget().isRemoved()) {
            this.failed = this.mob.getTarget().position().distanceTo(this.mob.getOriginBlock().getBottomCenter()) > 32.0 || ++this.time > 200;
            if (!(this.mob.distanceTo(this.mob.getTarget()) <= 3.0F) && !this.failed) {
               Vec3 target = this.mob.getTarget().position();
               if (this.mob
                  .level()
                  .clip(
                     new ClipContext(
                        this.mob.position().add(0.0, 1.5, 0.0), this.mob.getTarget().position().add(0.0, 1.5, 0.0), Block.COLLIDER, Fluid.NONE, this.mob
                     )
                  )
                  .getType()
                  .equals(Type.BLOCK)) {
                  this.mob.navigation.moveTo(this.mob.getTarget(), (double)(this.speed * (this.mob.shouldRun() ? 1.5F : 1.0F)));
               } else {
                  this.mob.moveControl.setWantedPosition(target.x, target.y, target.z, (double)(this.speed * (this.mob.shouldRun() ? 1.75F : 1.25F)));
               }
            }
         } else {
            this.mob.navigation.stop();
            this.mob.moveControl.setWantedPosition(this.mob.getX(), this.mob.getY(), this.mob.getZ(), 0.0);
            this.failed = true;
            this.stop();
         }
      }

      public void stop() {
         this.mob.navigation.stop();
         this.mob.moveControl.setWantedPosition(this.mob.getX(), this.mob.getY(), this.mob.getZ(), 0.0);
         super.stop();
         if (this.failed) {
            this.mob.setTeleportCooldown(0);
         }
      }
   }

   abstract static class DeerTeleportGoal extends InterruptableGoal {
      final DeerGodEntity mob;

      public DeerTeleportGoal(DeerGodEntity mob) {
         this.mob = mob;
      }

      public boolean canUse() {
         return this.mob.isReadyToAttack() && this.mob.isReadyToTeleport();
      }

      @Override
      public void start() {
         super.start();
         this.mob.navigation.stop();
         Vec3 dest = this.getTeleportDestination();
         if (dest != null && this.isDestinationFree(dest)) {
            this.mob.setNextTeleport(dest, this.getTeleportDelay());
            this.mob.navigation.stop();
         } else {
            Formidulus.LOGGER.warn("Deer couldn't find a free spot to teleport to!");
         }

         this.mob.setTeleportCooldown((int)((200.0F + this.mob.random.nextFloat()) * Math.max(this.mob.getHealth() / this.mob.getMaxHealth(), 0.2F)));
         this.stop();
      }

      @Nullable
      protected abstract Vec3 getTeleportDestination();

      protected int getTeleportDelay() {
         return this.mob.getTeleportFadeDuration();
      }

      boolean isDestinationFree(Vec3 dest) {
         return this.mob.level().noCollision(this.mob.getBoundingBox().move(this.mob.position().scale(-1.0)).move(dest));
      }

      protected boolean isCanReachTarget() {
         return this.mob.navigation.createPath(this.mob.getTarget(), 16) != null;
      }
   }

   static class LanternSlamClawGoal extends DeerGodEntity.LanternSlamGoal {
      public LanternSlamClawGoal(DeerGodEntity mob) {
         super(mob, (byte)9, 6.1F, (byte)2);
      }

      @Override
      public boolean canUse() {
         return super.canUse() && this.mob.hasClaw() && this.mob.random.nextFloat() < 0.666F;
      }

      @Override
      public void tick() {
         if (this.time != 58) {
            super.tick();
         } else {
            this.impact(7.5F, 6.0F, 0.6F);
            this.time++;
         }

         if (this.time >= 86 && this.time <= 106) {
            this.mob.setHasLantern(false);
            float strength = 1.0F - (float)(this.time - 86) / 20.0F;
            Vec3 impact = this.mob.position().add(new Vec3(0.5, 0.0, 3.0).yRot((float)Math.toRadians((double)(-this.mob.getYRot()))));
            float radius = Math.max(1.0F - Math.abs(1.0F - strength - 0.25F) * 2.0F, 0.333F) * 20.0F;
            this.mob
               .applyDamageInCylindricArea(
                  radius, 0.8F, DamageSources.get(this.mob.level(), DamageSources.SCORCH, this.mob), strength * 15.0F, (hit, success) -> {
                     if (strength * 15.0F > 0.0F && success) {
                        hit.setRemainingFireTicks(Math.max(hit.getRemainingFireTicks() + 40 * (this.mob.level().getDifficulty().getId() + 1), 0));
                     } else if (this.mob.tickCount % 3 == 0) {
                        hit.setRemainingFireTicks(Math.max(hit.getRemainingFireTicks() + 40 * (this.mob.level().getDifficulty().getId() + 1), 0));
                     }

                     float distanceFactor = 1.0F - (float)Math.min(hit.position().distanceTo(impact) / (double)radius + 0.5, 1.0);
                     hit.setDeltaMovement(hit.position().subtract(impact).normalize().scale((double)(strength * 4.0F * distanceFactor)).add(0.0, 0.1F, 0.0));
                  }
               );
         }
      }

      @Override
      protected int getAttackCooldown() {
         return (int)((float)super.getAttackCooldown() * 1.25F);
      }
   }

   static class LanternSlamGoal extends AnimatedAttackGoal<DeerGodEntity> {
      public LanternSlamGoal(DeerGodEntity mob) {
         super(mob, (byte)5, 5.8F, (byte)2);
      }

      public LanternSlamGoal(DeerGodEntity mob, byte attackAnimationId, float duration, byte postAnimationId) {
         super(mob, attackAnimationId, duration, postAnimationId);
      }

      @Override
      public boolean canUse() {
         return this.mob.hasLantern()
            && super.canUse()
            && this.mob.distanceTo(this.mob.getTarget()) < 7.0F
            && (this.mob.swingChain > 1 || this.mob.random.nextFloat() < 0.01F);
      }

      @Override
      public void start() {
         super.start();
         this.mob.navigation.stop();
         this.mob.lookAt(Anchor.EYES, this.target.getEyePosition());
         this.mob.yBodyRotO = this.mob.yBodyRot = this.mob.yHeadRot;
         this.mob.swingChain = 0;
      }

      @Override
      public boolean canContinueToUse() {
         return super.canContinueToUse() && !this.mob.isInSequence();
      }

      @Override
      public void tick() {
         super.tick();
         if (this.time < 40) {
            this.mob.lookAt(Anchor.EYES, this.target.getEyePosition());
            this.mob.yBodyRotO = this.mob.yBodyRot = this.mob.yHeadRot;
         }

         if (this.time >= 25 && this.time <= 27) {
            this.mob
               .applyDamageInCylindricArea(
                  4.0F, this.mob.getBbHeight(), 22.5F, DamageSources.get(this.mob.level(), DamageSources.LANTERN, this.mob), 12.0F, (hit, success) -> {
                     if (success) {
                        hit.setDeltaMovement(this.mob.getLookAngle().multiply(1.0, 0.0, 1.0).normalize().scale(0.5).add(0.0, 1.5, 0.0));
                     }
                  }
               );
         }

         if (this.time == 58) {
            this.mob.setHasLantern(false);
            this.impact(9.0F, 7.5F, 1.0F);
         }
      }

      protected void impact(float radius, float falloffDistance, float strengthMultiplier) {
         Vec3 impact = this.mob.position().add(new Vec3(0.5, 0.0, 3.0).yRot((float)Math.toRadians((double)(-this.mob.getYRot()))));

         for (LivingEntity hit : this.mob
            .level()
            .getEntitiesOfClass(LivingEntity.class, AABB.unitCubeFromLowerCorner(impact.subtract(0.5, 0.5, 0.5)).inflate((double)radius))) {
            if (!this.mob.getIgnoredClasses().contains(hit.getClass())) {
               float strength = Math.max(1.0F - (float)impact.distanceTo(hit.position()) / falloffDistance, 0.0F) * strengthMultiplier;
               if (!(strength <= 0.0F)
                  && strength * 20.0F > 0.0F
                  && hit.hurt(DamageSources.get(this.mob.level(), DamageSources.LANTERN, this.mob), strength * 20.0F)) {
                  hit.setDeltaMovement(hit.position().subtract(impact).normalize().scale((double)(strength * 4.0F)).add(0.0, (double)strength, 0.0));
                  this.mob.onDamageEntity(hit);
               }
            }
         }
      }

      @Override
      protected int getAttackCooldown() {
         return (int)((20.0F + this.mob.random.nextFloat() * 30.0F) * Math.max(this.mob.getHealth() / this.mob.getMaxHealth(), 0.2F));
      }
   }

   static class LanternSwingGoal extends AnimatedAttackGoal<DeerGodEntity> {
      public LanternSwingGoal(DeerGodEntity mob) {
         super(mob, (byte)4, 2.45F, (byte)2);
      }

      @Override
      public boolean canUse() {
         return this.mob.hasLantern()
            && super.canUse()
            && this.mob.distanceTo(this.mob.getTarget()) < 4.0F
            && this.mob.random.nextFloat() <= 1.2F / (float)(this.mob.swingChain + 1);
      }

      @Override
      public void start() {
         super.start();
         this.mob.navigation.stop();
         this.mob.lookAt(Anchor.EYES, this.target.getEyePosition());
         this.mob.yBodyRotO = this.mob.yBodyRot = this.mob.yHeadRot;
         this.mob.swingChain++;
      }

      @Override
      public boolean canContinueToUse() {
         return super.canContinueToUse() && !this.mob.isInSequence();
      }

      @Override
      public void tick() {
         super.tick();
         if (this.time >= 22 && this.time <= 30) {
            float rotation = (float)Math.toRadians((double)(135.0F - ((float)this.time - 22.0F) / 8.0F * 225.0F));
            Vec3 forwards = this.mob.getLookAngle().yRot(rotation);
            this.mob
               .applyDamageInCylindricArea(
                  4.5F,
                  this.mob.getBbHeight() * 0.75F,
                  28.125F,
                  DamageSources.get(this.mob.level(), DamageSources.LANTERN, this.mob),
                  15.0F,
                  forwards,
                  (hit, success) -> {
                     if (success) {
                        hit.setDeltaMovement(forwards.normalize().scale(2.0).add(0.0, 0.2F, 0.0));
                     }
                  }
               );
         }
      }

      @Override
      protected int getAttackCooldown() {
         return 1;
      }
   }

   static class ProjectileGoal extends InterruptableGoal {
      final DeerGodEntity mob;

      public ProjectileGoal(DeerGodEntity mob) {
         this.mob = mob;
      }

      public boolean canUse() {
         return !this.mob.isInSequence()
            && (Boolean)this.mob.entityData.get(DeerGodEntity.RANGED)
            && (Integer)this.mob.entityData.get(DeerGodEntity.RANGED_COOLDOWN) <= 0
            && this.mob.rangedDamageTaken > 10.0F;
      }

      @Override
      public void start() {
         super.start();
         float amount = (1.0F - this.mob.getHealth() / this.mob.getMaxHealth()) * 4.0F + (float)this.mob.level().getDifficulty().getId() * 0.33F;

         for (int i = 0; (float)i < Math.max(amount, 1.0F); i++) {
            Vec3 pos = this.mob
               .position()
               .add(0.0, -1.0, 0.0)
               .add((double)((this.mob.random.nextFloat() - 0.5F) * 2.0F * 4.0F), 0.0, (double)((this.mob.random.nextFloat() - 0.5F) * 2.0F * 4.0F));
            IrrlichtEntity funke = new IrrlichtEntity(EntityRegistry.IRRLICHT, this.mob.level());
            funke.setOwner(this.mob);
            funke.setPos(pos);
            funke.setType((byte)1);
            funke.lifetime = 100 - (int)(this.mob.random.nextFloat() * 40.0F);
            this.mob.level().addFreshEntity(funke);
         }

         this.mob
            .entityData
            .set(
               DeerGodEntity.RANGED_COOLDOWN,
               (int)(
                  (100.0F + this.mob.random.nextFloat() * 200.0F - (float)(this.mob.level().getDifficulty().getId() * 20))
                     * (this.mob.getHealth() / this.mob.getMaxHealth() < 0.5F ? 0.5F : 1.0F)
               )
            );
         this.mob.rangedDamageTaken = this.mob.rangedDamageTaken - amount / (float)Math.max(this.mob.level().getDifficulty().getId(), 1);
      }
   }

   abstract static class RunAttackGoal extends AnimatedAttackGoal<DeerGodEntity> {
      static final byte WALL_IMPACT = 1;
      protected final byte type;
      protected final float speed;
      boolean arrived;
      int preparationTime;
      int impactTicks;
      Vec3 start;
      Vec3 dir;
      LivingEntity newTarget;
      int chain;
      int animSpeed;
      boolean firstInChain;

      public RunAttackGoal(DeerGodEntity mob, byte attackAnimationId, float duration, byte postAnimationID, byte runAttackType, float speed) {
         super(mob, attackAnimationId, duration, postAnimationID);
         this.type = runAttackType;
         this.speed = speed;
         this.setFlags(EnumSet.of(Flag.MOVE, Flag.TARGET, Flag.LOOK));
      }

      @Override
      public boolean canUse() {
         return super.canUse() && this.mob.shouldRun() && this.mob.getStrongAttackCooldown() <= 0;
      }

      @Override
      protected boolean shouldImmediatelyStartAttackAnim() {
         return false;
      }

      @Override
      public void start() {
         super.start();
         boolean targetAccessible = false;

         for (int i = 0; i < (this.mob.targetGoal.getAllTargets().size() > 1 ? 4 : 1); i++) {
            this.mob.targetGoal.randomizeTarget();
            if (this.mob.getTarget() != null
               && this.mob
                  .level()
                  .clip(new ClipContext(this.mob.position().add(0.0, 1.5, 0.0), this.mob.getTarget().position(), Block.COLLIDER, Fluid.NONE, this.mob))
                  .getType()
                  .equals(Type.MISS)) {
               targetAccessible = true;
               break;
            }
         }

         if (this.mob.getTarget() != null && targetAccessible) {
            this.mob.setRunAttackState(this.type);
            this.arrived = false;
            this.preparationTime = 20;
            this.start = this.mob.position();
            this.dir = null;
            this.mob.setAnimation((byte)7);
            this.mob.playSound(SoundRegistry.DEER_ROAR_SHORT, 10.0F, 1.0F);
            this.impactTicks = -1;
            this.firstInChain = this.chain == 0;
            if (this.firstInChain) {
               this.chain = (int)Math.max(
                  (float)this.mob.level().getDifficulty().getId()
                     - 1.0F
                     + (0.5F - this.mob.getHealthPercent()) * 2.0F * (float)this.mob.level().getDifficulty().getId(),
                  0.0F
               );
               this.setAnimSpeed(1);
            } else {
               this.updateAnimSpeed();
            }
         } else {
            this.forceStop();
         }
      }

      void updateAnimSpeed() {
         this.setAnimSpeed((int)((float)this.chain / 2.0F) + 1);
      }

      void setAnimSpeed(int speed) {
         this.animSpeed = speed;
         this.mob.entityData.set(DeerGodEntity.RUN_ATTACK_ANIM_SPEED, this.animSpeed);
      }

      @Override
      public void tick() {
         if (!this.wasForceStopped()) {
            if (this.impactTicks > 0) {
               if (--this.impactTicks == 0) {
                  if (this.mob.getCurrentAnimation() == 12) {
                     this.mob.setAnimation((byte)2);
                  }

                  this.forceStop();
               }
            } else if (this.mob.getTarget() == null) {
               this.forceStop();
            } else if (this.preparationTime > 0) {
               this.preparationTime = Math.max(this.preparationTime - this.animSpeed, 0);
               if (this.preparationTime == 0 && this.mob.getCurrentAnimation() == 7) {
                  this.mob.setAnimation((byte)2);
               }

               if (this.preparationTime > 2) {
                  Vec3 dirNow = this.mob.getTarget().position().subtract(this.mob.position()).multiply(1.0, 0.0, 1.0).normalize();
                  if (this.dir == null) {
                     this.dir = dirNow;
                  } else {
                     this.dir = this.dir
                        .lerp(
                           dirNow.add(this.target.getDeltaMovement().scale(5.0)),
                           (double)((float)this.mob.level().getDifficulty().getId() / 3.0F * (float)this.animSpeed)
                        )
                        .multiply(1.0, 0.0, 1.0)
                        .normalize();
                  }

                  this.mob.lookAt(Anchor.FEET, this.mob.position().add(this.dir));
               }
            } else {
               Vec3 targetDir = this.mob.getTarget().position().subtract(this.mob.position());
               float curYaw = this.mob.getYRot();
               float targetYaw = (float)Math.toDegrees(Mth.atan2(targetDir.z, targetDir.x)) - 90.0F;
               float yaw = Mth.rotLerp(0.0175F * (float)this.mob.level().getDifficulty().getId(), curYaw, targetYaw);
               if (Math.abs(curYaw - targetYaw) < 25.0F + (float)this.mob.level().getDifficulty().getId() * 5.0F) {
                  this.dir = this.dir.yRot((float)(-Math.toRadians((double)(yaw - curYaw))));
                  this.mob.setYRot(yaw);
               }

               this.mob
                  .applyDamageInCylindricArea(
                     this.mob.getBbWidth(),
                     this.mob.getBbHeight(),
                     DamageSources.get(this.mob.level(), DamageSources.TRAMPLE, this.mob),
                     4.0F,
                     (hit, success) -> {
                        if (hit instanceof BulwarkEntity bulwarkEntity && bulwarkEntity.isPosInFront(this.mob.position())) {
                           this.interrupt((byte)100);
                           return;
                        }

                        if (success) {
                           hit.setDeltaMovement(this.mob.getLookAngle().multiply(1.0, 0.0, 1.0).normalize().scale(2.5).add(0.0, 0.2F, 0.0));
                        }
                     }
                  );
               if (this.arrived) {
                  for (int i = 0; i < this.animSpeed; i++) {
                     super.tick();
                     this.tickAttackAnim();
                  }
               } else {
                  Vec3 dest = this.mob.position().add(this.dir);
                  this.mob
                     .getMoveControl()
                     .setWantedPosition(dest.x, dest.y, dest.z, (double)(this.speed + (float)this.mob.level().getDifficulty().getId() * 0.05F));
                  if (this.mob
                     .level()
                     .clip(new ClipContext(this.mob.position().add(0.0, 1.5, 0.0), dest.add(0.0, 1.5, 0.0), Block.COLLIDER, Fluid.NONE, this.mob))
                     .getType()
                     .equals(Type.BLOCK)) {
                     this.interrupt((byte)1);
                  } else {
                     boolean targetBehindBlock = this.mob
                        .level()
                        .clip(
                           new ClipContext(
                              this.mob.position().add(0.0, 1.5, 0.0), this.target.position().add(0.0, 1.5, 0.0), Block.COLLIDER, Fluid.NONE, this.mob
                           )
                        )
                        .getType()
                        .equals(Type.BLOCK);
                     if (!targetBehindBlock && this.target instanceof Player player) {
                        IBulwarkComponent comp = FormidableComponents.bulwark(player);
                        targetBehindBlock = comp.hasBulwark() && comp.getBulwarkEntity() != null && !comp.getBulwarkEntity().isPosInFront(this.mob.position());
                     }

                     if (this.mob.distanceTo(this.target) < 4.0F && !targetBehindBlock || this.mob.position().distanceTo(this.start) > 16.0) {
                        this.arrived = true;
                        this.mob.setAnimation(this.attackAnimationId);
                        this.onArrive();
                        if (this.firstInChain) {
                           this.updateAnimSpeed();
                        }
                     }
                  }
               }
            }
         }
      }

      @Override
      public boolean isInterruptable() {
         return (super.isInterruptable() || this.impactTicks == 0) && this.chain <= 0;
      }

      @Override
      public boolean canContinueToUse() {
         return super.canContinueToUse() && this.impactTicks != 0;
      }

      protected void onArrive() {
         this.mob.getMoveControl().setWantedPosition(this.mob.getX(), this.mob.getY(), this.mob.getZ(), 0.0);
      }

      @Override
      public void stop() {
         super.stop();
         this.newTarget = null;
         this.mob.setRunAttackState((byte)0);
         if (this.mob.getCurrentAnimation() == 7 || this.mob.getCurrentAnimation() == this.attackAnimationId) {
            this.mob.setAnimation(this.postAnimationID);
         }

         if (this.mob.moveControl.hasWanted()) {
            this.mob.moveControl.setWantedPosition(this.mob.getX(), this.mob.getY(), this.mob.getZ(), 0.0);
         }

         if (this.wasForceStopped()) {
            this.arrived = false;
            this.impactTicks = 0;
         }
      }

      protected abstract void tickAttackAnim();

      @Override
      protected boolean tryInterrupt(byte reason) {
         if (reason != 1 && reason != 100) {
            return false;
         } else {
            this.impactTicks = 40;
            this.mob.setAnimation((byte)12);
            this.mob.getMoveControl().setWantedPosition(this.mob.getX(), this.mob.getY(), this.mob.getZ(), 0.0);
            this.mob.push(this.mob.getLookAngle().multiply(1.0, 0.0, 1.0).normalize().scale(-1.5));
            return true;
         }
      }
   }

   static class RunClawAttackGoal extends DeerGodEntity.RunAttackGoal {
      public RunClawAttackGoal(DeerGodEntity mob, float speed) {
         super(mob, (byte)10, 1.9F, (byte)2, (byte)1, speed);
      }

      @Override
      public boolean canUse() {
         return super.canUse() && this.mob.hasClaw();
      }

      @Override
      protected void tickAttackAnim() {
         if (this.time <= 7) {
            this.mob
               .applyDamageInCylindricArea(
                  this.mob.getBbWidth(),
                  this.mob.getBbHeight(),
                  DamageSources.get(this.mob.level(), DamageSources.TRAMPLE, this.mob),
                  2.0F,
                  (hit, success) -> {
                     if (success) {
                        hit.setDeltaMovement(
                           this.mob.getLookAngle().multiply(1.0, 0.0, 1.0).normalize().scale(this.mob.getDeltaMovement().length() * 1.5).add(0.0, 0.2F, 0.0)
                        );
                     }
                  }
               );
         }

         if (this.time > 11 && this.time < 14) {
            this.mob
               .applyDamageInCylindricArea(
                  6.5F,
                  3.5F,
                  35.0F,
                  DamageSources.get(this.mob.level(), DamageSources.CLAW, this.mob),
                  15.0F,
                  this.mob.getLookAngle(),
                  this.mob.getLookAngle().scale(-1.5),
                  (hit, success) -> {
                     if (success) {
                        hit.setDeltaMovement(this.mob.getLookAngle().multiply(1.0, 0.0, 1.0).normalize().scale(2.0).add(0.0, 1.5, 0.0));
                     }
                  }
               );
         }

         if ((float)this.time >= this.duration * 20.0F && this.chain > 0) {
            this.chain--;
            if (this.chain == 0) {
               this.chain = -1;
            }

            this.start();
         }
      }

      @Override
      protected void onArrive() {
         Vec3 dest = this.mob.position().add(this.dir.scale(2.0));
         this.mob.moveControl.setWantedPosition(dest.x, dest.y, dest.z, 1.0);
      }

      @Override
      public void stop() {
         this.mob.setStrongCooldown(200 - this.mob.level().getDifficulty().getId() * 15);
         super.stop();
         this.chain = 0;
      }

      @Override
      protected int getAttackCooldown() {
         return 0;
      }

      @Override
      public void forceStop() {
         super.forceStop();
         this.chain = 0;
      }
   }

   static class SimpleClawAttackGoal extends AnimatedAttackGoal<DeerGodEntity> {
      public SimpleClawAttackGoal(DeerGodEntity mob) {
         super(mob, (byte)8, 1.8F, (byte)2);
      }

      @Override
      public boolean canUse() {
         return this.mob.hasClaw() && super.canUse() && this.mob.distanceTo(this.mob.getTarget()) < 4.0F && this.mob.random.nextFloat() < 0.5F;
      }

      @Override
      public boolean canContinueToUse() {
         return super.canContinueToUse() && !this.mob.isInSequence();
      }

      @Override
      public void tick() {
         super.tick();
         if (this.time < 10 && this.mob.getTarget() != null) {
            this.mob.lookAt(Anchor.EYES, this.mob.getTarget().getEyePosition());
         }

         if (this.time > 16 && this.time < 20) {
            this.mob
               .applyDamageInCylindricArea(
                  4.25F, this.mob.getBbHeight(), 50.0F, DamageSources.get(this.mob.level(), DamageSources.CLAW, this.mob), 20.0F, (hit, success) -> {
                     if (success) {
                        hit.setDeltaMovement(this.mob.getLookAngle().multiply(1.0, 0.0, 1.0).normalize().scale(2.0));
                     }
                  }
               );
         }
      }

      @Override
      protected int getAttackCooldown() {
         return 0;
      }
   }

   static class SummonLanternGoal extends AnimatedAttackGoal<DeerGodEntity> {
      public SummonLanternGoal(DeerGodEntity mob) {
         super(mob, (byte)3, 2.75F, (byte)2);
      }

      @Override
      public boolean canUse() {
         return !this.mob.hasLantern() && super.canUse() && (this.mob.random.nextFloat() < 0.33F || !this.mob.hasClaw());
      }

      @Override
      public void start() {
         super.start();
         this.mob.navigation.stop();
      }

      @Override
      public void tick() {
         super.tick();
         if (this.time == 35) {
            this.mob.setHasLantern(true);
         }
      }

      @Override
      public boolean isInterruptable() {
         return true;
      }

      @Override
      protected int getAttackCooldown() {
         return 10 + (int)(this.mob.random.nextFloat() * 5.0F);
      }
   }

   static class SwarmGoal extends InterruptableGoal {
      final DeerGodEntity mob;
      int fade;
      int spawnCooldown;

      public SwarmGoal(DeerGodEntity mob) {
         this.mob = mob;
      }

      public boolean canUse() {
         return this.mob.swarmAttackPending && this.mob.isReadyToAttack();
      }

      @Override
      public void start() {
         super.start();
         this.mob.entityData.set(DeerGodEntity.SCHEDULED_SPAWNS, 4 + this.mob.level().getDifficulty().getId() * this.mob.swarmAttack);
         this.mob.navigation.stop();
         this.mob.moveControl.setWantedPosition(this.mob.getX(), this.mob.getY(), this.mob.getZ(), 0.0);
         this.mob.playSound(SoundRegistry.DEER_VANISH, 1.0F, 1.0F);
      }

      public boolean requiresUpdateEveryTick() {
         return true;
      }

      public boolean canContinueToUse() {
         return (
               this.fade > 0
                  || (Integer)this.mob.entityData.get(DeerGodEntity.SCHEDULED_SPAWNS) > 0
                  || (Integer)this.mob.entityData.get(DeerGodEntity.SWARM_TRANSITION_TICKS) > 0
                  || this.mob.isAnyCultistNearby()
            )
            && !this.mob.isInSequence();
      }

      public void tick() {
         int cultists = this.mob.getAllNearbyCultists().size();
         if (this.fade < 50 && (Integer)this.mob.entityData.get(DeerGodEntity.SCHEDULED_SPAWNS) > 0) {
            this.mob.entityData.set(DeerGodEntity.SWARM_TRANSITION_TICKS, ++this.fade);
         } else if (this.fade > 0 && (Integer)this.mob.entityData.get(DeerGodEntity.SCHEDULED_SPAWNS) <= 0 && cultists == 0) {
            this.mob.entityData.set(DeerGodEntity.SWARM_TRANSITION_TICKS, --this.fade);
         }

         if (this.fade > 20) {
            this.mob.applyDarkness(this.fade - 10);
         }

         if (cultists <= 1) {
            this.spawnCooldown -= 2;
         }

         if (this.fade >= 50
            && (Integer)this.mob.entityData.get(DeerGodEntity.SCHEDULED_SPAWNS) > 0
            && this.spawnCooldown-- <= 0
            && cultists < this.mob.getMaxCultists()) {
            if (this.mob.position().distanceTo(this.mob.getOriginBlock().getBottomCenter()) > 1.0) {
               this.mob.setPos(this.mob.getOriginBlock().getCenter());
            }

            this.mob.spawnCultist(new Vec2(10.0F, 15.0F), false);
            this.mob.setTarget(this.mob.getRandomTarget());
            this.spawnCooldown = 80 * cultists - 10 * this.mob.level().getDifficulty().getId();
            this.mob.entityData.set(DeerGodEntity.SCHEDULED_SPAWNS, (Integer)this.mob.entityData.get(DeerGodEntity.SCHEDULED_SPAWNS) - 1);
         }
      }

      public boolean isInterruptable() {
         return false;
      }

      public void stop() {
         super.stop();
         this.mob.swarmAttackPending = false;
      }

      @Override
      public void forceStop() {
         super.forceStop();
         this.mob.entityData.set(DeerGodEntity.SWARM_TRANSITION_TICKS, 0);
         this.mob.entityData.set(DeerGodEntity.SCHEDULED_SPAWNS, 0);
      }
   }

   static class TeleportAwayFromTargets extends DeerGodEntity.TeleportRandomlyGoal {
      public TeleportAwayFromTargets(DeerGodEntity mob) {
         super(mob);
      }

      @Override
      public boolean canUse() {
         return this.mob.isReadyToAttack()
            && this.mob.isReadyToTeleport()
            && !this.mob.hasClaw()
            && !this.mob.hasLantern()
            && this.mob.getTarget() != null
            && this.mob.distanceTo(this.mob.getTarget()) < 8.0F;
      }

      @Override
      protected int getMaxAttempts() {
         return 32;
      }

      @Override
      boolean isDestinationFree(Vec3 dest) {
         float distanceMult = 1.0F - (float)this.attempt / (float)this.getMaxAttempts();

         for (LivingEntity target : this.mob.targetGoal.getAllTargets()) {
            if (target != null && target.canBeSeenByAnyone() && target.distanceTo(this.mob) > 10.0F * distanceMult) {
               return false;
            }
         }

         return super.isDestinationFree(dest);
      }
   }

   static class TeleportRandomlyGoal extends DeerGodEntity.DeerTeleportGoal {
      Vec3 origin;
      int attempt;

      public TeleportRandomlyGoal(DeerGodEntity mob) {
         super(mob);
      }

      @Override
      public boolean canUse() {
         return super.canUse() && this.mob.random.nextFloat() < (this.isCanReachTarget() ? 0.01F : 0.05F);
      }

      @Override
      public void start() {
         this.origin = this.mob.getOriginBlock().getBottomCenter();
         super.start();
      }

      @Nullable
      @Override
      protected Vec3 getTeleportDestination() {
         for (this.attempt = 0; this.attempt < this.getMaxAttempts(); this.attempt++) {
            Vec3 dest = this.origin
               .add(((double)this.mob.random.nextFloat() - 0.5) * 2.0 * 16.0, 8.0, ((double)this.mob.random.nextFloat() - 0.5) * 2.0 * 16.0);
            BlockHitResult bHit = this.mob.level().clip(new ClipContext(dest, dest.subtract(0.0, 16.0, 0.0), Block.COLLIDER, Fluid.NONE, this.mob));
            if (!bHit.getType().equals(Type.MISS) && this.isDestinationFree(bHit.getLocation())) {
               return bHit.getLocation();
            }
         }

         return null;
      }

      protected int getMaxAttempts() {
         return 16;
      }
   }

   static class TeleportToTargetGoal extends DeerGodEntity.DeerTeleportGoal {
      public TeleportToTargetGoal(DeerGodEntity mob) {
         super(mob);
      }

      @Override
      public boolean canUse() {
         return super.canUse() && this.mob.getTarget() != null && (this.mob.distanceTo(this.mob.getTarget()) > 10.0F || !this.isCanReachTarget());
      }

      @Override
      public void start() {
         super.start();
         if (this.mob.getTarget() != null) {
            this.mob.lookAt(Anchor.FEET, this.mob.getTarget().position());
         }
      }

      @Nullable
      @Override
      protected Vec3 getTeleportDestination() {
         LivingEntity target = this.mob.getTarget();
         if (target == null) {
            return null;
         } else {
            Vec3 dir = this.mob.position().subtract(target.position()).multiply(1.0, 0.0, 1.0).normalize();

            for (int i = 0; i < 36; i++) {
               float rot = (float)i / 2.0F * (float)(i % 2 == 0 ? -1 : 1) * 20.0F;
               Vec3 dest = target.position().add(dir.yRot((float)Math.toRadians((double)rot)).scale((double)(2.5F + this.mob.random.nextFloat())));
               BlockHitResult bHit = this.mob
                  .level()
                  .clip(new ClipContext(dest.add(0.0, 2.0, 0.0), dest.subtract(0.0, 2.0, 0.0), Block.COLLIDER, Fluid.NONE, this.mob));
               if (!bHit.getType().equals(Type.MISS) && this.isDestinationFree(bHit.getLocation())) {
                  return bHit.getLocation();
               }
            }

            return null;
         }
      }
   }
}
