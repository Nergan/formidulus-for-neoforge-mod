package com.formidulus.mod.advancement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Optional;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.CriterionValidator;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger.SimpleInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class BossFightWonCriterion extends SimpleCriterionTrigger<BossFightWonCriterion.Conditions> {
   public Codec<BossFightWonCriterion.Conditions> codec() {
      return BossFightWonCriterion.Conditions.CODEC;
   }

   public void trigger(ServerPlayer player, ResourceLocation bossId) {
      super.trigger(player, conditions -> bossId.equals(conditions.bossId));
   }

   public static record Conditions(Optional<ContextAwarePredicate> player, ResourceLocation bossId) implements SimpleInstance {
      public static final Codec<BossFightWonCriterion.Conditions> CODEC = RecordCodecBuilder.create(
         instance -> instance.group(
                  EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(BossFightWonCriterion.Conditions::player),
                  ResourceLocation.CODEC.fieldOf("bossId").forGetter(BossFightWonCriterion.Conditions::bossId)
               )
               .apply(instance, BossFightWonCriterion.Conditions::new)
      );

      public static Criterion<BossFightWonCriterion.Conditions> createBossfigthWon(ResourceLocation bossId) {
         return CriteriaRegistry.BOSSFIGHT_WIN.createCriterion(new BossFightWonCriterion.Conditions(Optional.empty(), bossId));
      }
   }
}
