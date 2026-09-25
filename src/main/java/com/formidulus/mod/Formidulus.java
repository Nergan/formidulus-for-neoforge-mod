package com.formidulus.mod;

import com.formidulus.mod.advancement.CriteriaRegistry;
import com.formidulus.mod.commands.Commands;
import com.formidulus.mod.components.FormidableComponents;
import com.formidulus.mod.config.ServerConfig;
import com.formidulus.mod.datagen.Lang;
import com.formidulus.mod.entities.boss.BossFightManager;
import com.formidulus.mod.entities.boss.BossType;
import com.formidulus.mod.realtime.TimedEventHandler;
import com.formidulus.mod.registries.BlockEntityRegistry;
import com.formidulus.mod.registries.BlockRegistry;
import com.formidulus.mod.registries.EntityRegistry;
import com.formidulus.mod.registries.FormidableMapDecorations;
import com.formidulus.mod.registries.ItemRegistry;
import com.formidulus.mod.registries.PacketRegistry;
import com.formidulus.mod.registries.ParticleRegistry;
import com.formidulus.mod.registries.SoundRegistry;
import com.formidulus.mod.registries.StatusEffectRegistry;
import com.formidulus.mod.registries.StructureRegistry;
import com.formidulus.mod.registries.TagRegistry;
import com.formidulus.mod.structure.FormidableStructureProcessors;
import java.util.Calendar;
import com.formidulus.mod.registries.DataComponentRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ExplorationMapFunction;
import net.minecraft.world.level.storage.loot.functions.SetNameFunction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.LootTableLoadEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Formidulus {
   public static final ResourceLocation FONT = ResourceLocation.withDefaultNamespace("illageralt");
   public static final String MOD_ID = "formidulus";
   public static final Logger LOGGER = LoggerFactory.getLogger("formidulus");
   public static ServerConfig config;
   public static boolean ENCHANCEMENT;
   public static boolean TRINKETS;
   private static final int DATE_CHECK_INTERVAL = 72000;
   private int lastDayOfYear;
   private int dateCheckTimer;

   public void bootstrap(IEventBus modBus) {
      ENCHANCEMENT = ModList.get().isLoaded("enchancement");
      TRINKETS = false;
      FormidableComponents.ATTACHMENTS.register(modBus);
      modBus.addListener(this::onRegister);
      modBus.addListener((BuildCreativeModeTabContentsEvent event) -> ItemRegistry.onCreative(event));
      PacketRegistry.register(modBus);
      Commands.register();
      TimedEventHandler.update();
      this.lastDayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
      modBus.addListener((EntityAttributeCreationEvent event) -> EntityRegistry.register(event));
      NeoForge.EVENT_BUS.addListener(this::onServerStarting);
      NeoForge.EVENT_BUS.addListener(this::onServerTick);
      NeoForge.EVENT_BUS.addListener(this::onLoot);
   }

   private void onRegister(RegisterEvent event) {
      ResourceKey<? extends Registry<?>> key = event.getRegistryKey();
      if (key.equals(Registries.BLOCK)) {
         BlockRegistry.register();
      } else if (key.equals(Registries.BLOCK_ENTITY_TYPE)) {
         BlockEntityRegistry.register();
      } else if (key.equals(Registries.ITEM)) {
         ItemRegistry.register();
      } else if (key.equals(Registries.ENTITY_TYPE)) {
         EntityRegistry.registerTypes();
         BossType.init();
      } else if (key.equals(Registries.DATA_COMPONENT_TYPE)) {
         DataComponentRegistry.register();
      } else if (key.equals(Registries.PARTICLE_TYPE)) {
         ParticleRegistry.register();
      } else if (key.equals(Registries.MOB_EFFECT)) {
         StatusEffectRegistry.register();
      } else if (key.equals(Registries.SOUND_EVENT)) {
         SoundRegistry.register();
      } else if (key.equals(Registries.TRIGGER_TYPE)) {
         CriteriaRegistry.regiser();
      } else if (key.equals(Registries.STRUCTURE_TYPE)) {
         StructureRegistry.registerTypes();
      } else if (key.equals(Registries.STRUCTURE_PIECE)) {
         StructureRegistry.registerPieces();
      } else if (key.equals(Registries.MAP_DECORATION_TYPE)) {
         FormidableMapDecorations.register();
      } else if (key.equals(Registries.STRUCTURE_PROCESSOR)) {
         FormidableStructureProcessors.register();
      }
   }

   private void onServerStarting(ServerStartingEvent event) {
      this.dateCheckTimer = DATE_CHECK_INTERVAL - Calendar.getInstance().get(Calendar.MINUTE) * 60 * 20;
   }

   private void onServerTick(ServerTickEvent.Post event) {
      BossFightManager.INSTANCE.tick();
      if (this.dateCheckTimer-- <= 0) {
         int day = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
         if (this.lastDayOfYear != day) {
            TimedEventHandler.update();
            this.lastDayOfYear = day;
         }
         this.dateCheckTimer = DATE_CHECK_INTERVAL;
      }
   }

   private void onLoot(LootTableLoadEvent event) {
      if (!event.getKey().equals(BuiltInLootTables.ANCIENT_CITY)) {
         return;
      }
      LootPool.Builder poolBuilder = LootPool.lootPool();
      poolBuilder.add(EmptyLootItem.emptyItem().setWeight(24))
         .add(LootItem.lootTableItem(Items.MAP).setWeight(1))
         .apply(
            ExplorationMapFunction.makeExplorationMap()
               .setDestination(TagRegistry.CULT_HIDEOUT)
               .setMapDecoration(FormidableMapDecorations.CULT_HIDEOUT)
               .setZoom((byte)2)
               .setSearchRadius(64)
         )
         .apply(SetNameFunction.setName(Component.translatable(Lang.MAP_CULT_HIDEOUT), SetNameFunction.Target.ITEM_NAME));
      LOGGER.debug("Ancient city map pool is built; injection depends on the loot event exposing a mutable table.");
   }

   public static ResourceLocation identifier(String path) {
      return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
   }
}
