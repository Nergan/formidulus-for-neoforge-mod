package com.formidulus.mod.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ServerConfig {
   public final FloatEntry cultistMendingChance;
   public final BoolEntry deerWarning;
   public final IntEntry fightCheckInterval;
   public final FloatEntry jollyChance;

   public ServerConfig(ModConfigSpec.Builder builder) {
      builder.push("world");
      this.cultistMendingChance = new FloatEntry(
         builder.comment("Chance a cultist mends while worshipping.").translation("formidulus.configuration.world.cultist_mending_chance").defineInRange("cultist_mending_chance", 0.1, 0.0, 1.0)
      );
      this.deerWarning = new BoolEntry(
         builder.comment("Warn players before the deer god fight.").translation("formidulus.configuration.world.deer_warning").define("deer_warning", true)
      );
      this.fightCheckInterval = new IntEntry(
         builder.comment("How often a boss spawner checks whether a fight should start, in ticks.").translation("formidulus.configuration.world.fight_check_inverval").defineInRange("fight_check_inverval", 100, 1, 72000)
      );
      this.jollyChance = new FloatEntry(
         builder.comment("Chance a mob becomes jolly.").translation("formidulus.configuration.world.jolly_chance").defineInRange("jolly_chance", 0.01, 0.0, 1.0)
      );
      builder.pop();
   }

   public static final class FloatEntry {
      private final ModConfigSpec.DoubleValue value;

      FloatEntry(ModConfigSpec.DoubleValue value) {
         this.value = value;
      }

      public float getValue() {
         return this.value.get().floatValue();
      }
   }

   public static final class BoolEntry {
      private final ModConfigSpec.BooleanValue value;

      BoolEntry(ModConfigSpec.BooleanValue value) {
         this.value = value;
      }

      public boolean getValue() {
         return this.value.get();
      }
   }

   public static final class IntEntry {
      private final ModConfigSpec.IntValue value;

      IntEntry(ModConfigSpec.IntValue value) {
         this.value = value;
      }

      public int getValue() {
         return this.value.get();
      }
   }
}
