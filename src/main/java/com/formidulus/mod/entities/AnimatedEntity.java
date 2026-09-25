package com.formidulus.mod.entities;

import java.util.List;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.SynchedEntityData.Builder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public abstract class AnimatedEntity extends LivingEntity {
   public static final EntityDataAccessor<Byte> ANIMATION = SynchedEntityData.defineId(AnimatedEntity.class, EntityDataSerializers.BYTE);
   public static final EntityDataAccessor<Integer> ANIMATION_START = SynchedEntityData.defineId(AnimatedEntity.class, EntityDataSerializers.INT);
   byte lastAnimation;
   int animFlags;

   protected AnimatedEntity(EntityType<? extends LivingEntity> entityType, Level world) {
      super(entityType, world);
   }

   protected void defineSynchedData(Builder builder) {
      super.defineSynchedData(builder);
      builder.define(ANIMATION, (byte)0);
      builder.define(ANIMATION_START, 0);
   }

   public void onSyncedDataUpdated(EntityDataAccessor<?> data) {
      super.onSyncedDataUpdated(data);
      if (this.level().isClientSide) {
         if (data.equals(ANIMATION_START)) {
            this.tickCount = (Integer)this.entityData.get(ANIMATION_START);
         }

         if (data.equals(ANIMATION) && (Byte)this.entityData.get(ANIMATION) > -1) {
            this.setAnimation((Byte)this.entityData.get(ANIMATION));
         }
      }
   }

   public void setAnimation(byte id) {
      if (!this.level().isClientSide) {
         this.entityData.set(ANIMATION_START, this.tickCount);
         this.entityData.set(ANIMATION, (byte)-1);
         this.entityData.set(ANIMATION, id);
      }

      AnimationState var3 = this.getAnimationState(this.lastAnimation);
      if (var3 instanceof AnimationState) {
         var3.stop();
      }

      var3 = this.getAnimationState(id);
      if (var3 instanceof AnimationState) {
         var3.start(this.tickCount);
      }

      this.lastAnimation = id;
      this.animFlags = 0;
   }

   @Nullable
   protected abstract AnimationState getAnimationState(byte var1);

   public byte getCurrentAnimation() {
      return (Byte)this.entityData.get(ANIMATION);
   }

   public float getCurrentAnimationDuration() {
      return (float)(this.tickCount - (Integer)this.entityData.get(ANIMATION_START)) / 20.0F;
   }

   protected void setAnimationFlag(int idx, boolean state) {
      if (state) {
         this.animFlags |= 1 << idx;
      } else {
         this.animFlags &= ~(1 << idx);
      }
   }

   protected boolean getAnimationFlag(int idx) {
      return (this.animFlags >> idx & 1) == 1;
   }

   public boolean hurt(DamageSource source, float amount) {
      return super.hurt(source, amount);
   }

   public float getRelativeHorizontalAngleTo(Vec3 pos, Vec3 target, Vec3 forward) {
      Vec3 targetDir = target.multiply(1.0, 0.0, 1.0).subtract(pos.multiply(1.0, 0.0, 1.0)).normalize();
      forward = forward.multiply(1.0, 0.0, 1.0).normalize();
      return (float)targetDir.dot(forward);
   }

   public Iterable<ItemStack> getArmorSlots() {
      return List.of();
   }

   public ItemStack getItemBySlot(EquipmentSlot slot) {
      return ItemStack.EMPTY;
   }

   public void setItemSlot(EquipmentSlot slot, ItemStack stack) {
   }

   public HumanoidArm getMainArm() {
      return HumanoidArm.RIGHT;
   }
}
