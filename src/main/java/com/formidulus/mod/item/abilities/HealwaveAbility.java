package com.formidulus.mod.item.abilities;

import net.neoforged.neoforge.network.PacketDistributor;
import com.formidulus.mod.item.components.ChargeComponent;
import com.formidulus.mod.network.CastActiveAbilityPayload;
import com.formidulus.mod.registries.DataComponentRegistry;
import com.formidulus.mod.registries.SoundRegistry;
import java.util.Optional;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class HealwaveAbility extends ItemAbility {
   public HealwaveAbility(ResourceLocation id) {
      super(id);
   }

   @Override
   public MutableComponent getNameText() {
      return super.getNameText().setStyle(STYLE.withColor(ChatFormatting.GOLD));
   }

   @Override
   public int getDescriptionLines() {
      return 2;
   }

   @Override
   public Optional<InteractionResultHolder<ItemStack>> onUse(
      ItemStack stack, LivingEntity user, InteractionHand hand, InteractionResultHolder<ItemStack> result
   ) {
      super.onUse(stack, user, hand, result);
      if (user.isShiftKeyDown() && user.onGround()) {
         return Optional.empty();
      } else if (stack.get(DataComponentRegistry.CHARGE) instanceof ChargeComponent comp) {
         Optional<ChargeComponent> newCharge = comp.tryConsumeCharge(1.0F);
         if (newCharge.isEmpty()) {
            return Optional.empty();
         } else {
            if (!user.hasInfiniteMaterials()) {
               stack.set(DataComponentRegistry.CHARGE, newCharge.get());
            } else if (user instanceof Player player) {
               player.getCooldowns().addCooldown(stack.getItem(), 5);
            }

            this.castActiveAbility(user, stack, user.position().add(0.0, 0.3F, 0.0));
            return Optional.of(InteractionResultHolder.success(stack));
         }
      } else {
         return Optional.empty();
      }
   }

   @Override
   public void castActiveAbility(LivingEntity caster, ItemStack stack, Vec3 pos) {
      if (!caster.isShiftKeyDown() || !caster.onGround()) {
         castHealwave(caster, stack, pos);
      }
   }

   public static void castHealwave(LivingEntity caster, ItemStack stack, Vec3 pos) {
      Level world = caster.level();
      if (!world.isClientSide) {
         world.getEntities(
               EntityTypeTest.forClass(LivingEntity.class),
               AABB.unitCubeFromLowerCorner(pos).inflate(6.0, 3.0, 6.0).move(0.0, 1.0, 0.0),
               ix -> ix.distanceToSqr(pos) < 36.0 && !(ix instanceof Monster)
            )
            .forEach(living -> living.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 3)));
         world.playSound(null, BlockPos.containing(pos), SoundRegistry.BIG_LANTERN_HEALWAVE, SoundSource.BLOCKS, 1.0F, 0.8F);
         if (world instanceof ServerLevel serverWorld) {
            serverWorld.players()
               .forEach(p -> PacketDistributor.sendToPlayer(p, new CastActiveAbilityPayload(pos.toVector3f(), ItemAbilities.HEALWAVE.id, caster.getId(), stack)));
         }
      } else {
         for (int i = 0; i < 4; i++) {
            Vec3 ppos = pos.add(0.0, 0.1 + (double)((float)i * 0.33F), 0.0);

            for (int ii = 0; ii < 32; ii++) {
               Vec3 vel = new Vec3(0.0, 0.0, 0.25 + (double)world.getRandom().nextFloat() * 0.2)
                  .yRot((float)Math.toRadians((double)((float)ii / 32.0F * 360.0F + world.getRandom().nextFloat() * 10.0F)));
               world.addParticle(ParticleTypes.FLAME, ppos.x, ppos.y, ppos.z, vel.x, vel.y, vel.z);
            }
         }
      }
   }
}
