package com.formidulus.mod.registries;

import net.neoforged.fml.loading.FMLEnvironment;
import com.formidulus.mod.Formidulus;
import com.formidulus.mod.damage.DamageSources;
import com.formidulus.mod.datagen.Lang;
import com.formidulus.mod.item.BulwarkItem;
import com.formidulus.mod.item.DeerSkullItem;
import com.formidulus.mod.item.GreatLanternItem;
import com.formidulus.mod.item.JollyHatItem;
import com.formidulus.mod.item.SacrificialDaggerItem;
import com.formidulus.mod.item.abilities.ItemAbilities;
import com.formidulus.mod.item.components.AbilityComponent;
import com.formidulus.mod.item.components.AccessoryComponent;
import com.formidulus.mod.item.components.ChargeComponent;
import com.formidulus.mod.item.components.DamageTypeComponent;
import com.formidulus.mod.item.components.DependencyInfoComponent;
import com.formidulus.mod.item.components.ExpandableLoreComponent;
import java.util.List;
import java.util.function.Function;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BannerPatternItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.component.ItemLore;

public class ItemRegistry {
   public static final DeerSkullItem DEER_SKULL = register(
      Formidulus.identifier("deer_skull"),
      id -> new DeerSkullItem(
            new Properties()
               .stacksTo(1)
               .rarity(Rarity.RARE)
               .component(DataComponentRegistry.ACCESSORY, new AccessoryComponent(List.of("cap", "mask"), 0))
               .component(DataComponentRegistry.EXPANDABLE_LORE, ExpandableLoreComponent.makeGenericBlock(id, 6))
         )
   );
   public static final BlockItem WEEN = register(
      Formidulus.identifier("ween"),
      id -> new BlockItem(
            BlockRegistry.WEEN,
            new Properties()
               .rarity(Rarity.UNCOMMON)
               .component(DataComponents.LORE, new ItemLore(List.of(Component.translatable(BlockRegistry.WEEN.getDescriptionId() + ".lore"))))
         )
   );
   public static final SacrificialDaggerItem SACRIFICIAL_DAGGER = register(
      Formidulus.identifier("sacrificial_dagger"),
      id -> new SacrificialDaggerItem(
            Tiers.IRON,
            new Properties()
               .rarity(Rarity.UNCOMMON)
               .component(DataComponents.MAX_DAMAGE, 640)
               .component(DataComponentRegistry.DAMAGE_TYPE, new DamageTypeComponent(DamageSources.SACRIFICE))
               .component(DataComponents.ATTRIBUTE_MODIFIERS, SacrificialDaggerItem.createAttributeModifiers())
               .component(DataComponentRegistry.ABILITY, new AbilityComponent(ItemAbilities.VAMPIRISM))
               .component(DataComponentRegistry.EXPANDABLE_LORE, ExpandableLoreComponent.makeGeneric(id, 2))
         )
   );
   public static final SacrificialDaggerItem SOUL_DAGGER = register(
      Formidulus.identifier("soul_dagger"),
      id -> new SacrificialDaggerItem(
            Tiers.DIAMOND,
            new Properties()
               .rarity(Rarity.UNCOMMON)
               .component(DataComponents.MAX_DAMAGE, 320)
               .component(DataComponentRegistry.DAMAGE_TYPE, new DamageTypeComponent(DamageSources.SACRIFICE))
               .component(DataComponents.ATTRIBUTE_MODIFIERS, SacrificialDaggerItem.createAttributeModifiers())
               .component(DataComponentRegistry.ABILITY, new AbilityComponent(ItemAbilities.SOULSTEAL))
               .component(DataComponentRegistry.EXPANDABLE_LORE, ExpandableLoreComponent.makeGeneric(id, 2))
         )
   );
   public static final BannerPatternItem EYES_BANNER_PATTERN = register(
      Formidulus.identifier("eyes_pattern"), id -> new BannerPatternItem(FormidableBannerPatterns.EYES_TAG, new Properties().rarity(Rarity.RARE).stacksTo(1))
   );
   public static final GreatLanternItem GREAT_LANTERN = register(
      Formidulus.identifier("great_lantern"),
      id -> new GreatLanternItem(
            new Properties()
               .rarity(Rarity.RARE)
               .stacksTo(1)
               .component(DataComponentRegistry.ABILITY, new AbilityComponent(ItemAbilities.HEALWAVE))
               .component(DataComponentRegistry.EXPANDABLE_LORE, ExpandableLoreComponent.makeGenericBlock(id, 5))
               .component(DataComponentRegistry.CHARGE, new ChargeComponent(4.0F, 4.0F))
         )
   );
   public static final Item CHAINLINK = register(Formidulus.identifier("chainlink"), id -> new Item(new Properties()));
   public static final Item BULWARK = register(
      Formidulus.identifier("bulwark"),
      id -> new BulwarkItem(
            new Properties()
               .rarity(Rarity.RARE)
               .stacksTo(1)
               .component(DataComponents.ATTRIBUTE_MODIFIERS, BulwarkItem.createAttributeModifiers())
               .component(DataComponentRegistry.ABILITY, new AbilityComponent(ItemAbilities.BULWARK))
         )
   );
   public static final Item DEER_NECKLACE = register(Formidulus.identifier("deer_necklace"), id -> {
      Properties settings = new Properties();
      if (!markNYI(settings)) {
         settings.stacksTo(1).component(DataComponentRegistry.EXPANDABLE_LORE, ExpandableLoreComponent.makeGeneric(id, 1));
      }

      if (!Formidulus.TRINKETS) {
         settings.component(DataComponentRegistry.DEPENDENCY_INFO, new DependencyInfoComponent("trinkets"));
      }

      return new Item(settings);
   });
   public static final JollyHatItem JOLLY_HAT = register(Formidulus.identifier("jolly_hat"), id -> {
      Properties settings = new Properties().stacksTo(1);
      settings.component(DataComponentRegistry.ACCESSORY, new AccessoryComponent(List.of("inactive", "active"), 0));
      if (!Formidulus.TRINKETS) {
         settings.component(DataComponentRegistry.DEPENDENCY_INFO, new DependencyInfoComponent("trinkets", false));
      }

      return new JollyHatItem(settings);
   });
   public static final Item DEER_PHASE1_MUSIC_DISC = register(
      Formidulus.identifier("deer_phase1_disc"), id -> new Item(new Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(FormidableTunes.DEER_PHASE1))
   );
   public static final Item DEER_PHASE2_MUSIC_DISC = register(
      Formidulus.identifier("deer_phase2_disc"), id -> new Item(new Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(FormidableTunes.DEER_PHASE2))
   );
   public static final SpawnEggItem CULTIST_SPAWN_EGG = register(
      Formidulus.identifier("cultist_spawn_egg"), id -> new SpawnEggItem(EntityRegistry.DEER_FOLLOWER, 3086400, 16281615, new Properties())
   );
   public static final SpawnEggItem CRUOR_SPAWN_EGG = register(
      Formidulus.identifier("deer_spawn_egg"), id -> new SpawnEggItem(EntityRegistry.DEER_GOD, 7077888, 13893646, new Properties())
   );
   public static final BlockItem BOSS_SPAWNER = register(
      Formidulus.identifier("boss_spawner"), id -> new BlockItem(BlockRegistry.BOSS_SPAWNER, new Properties().rarity(Rarity.EPIC))
   );

   public static <T extends Item> T register(ResourceLocation id, Function<ResourceLocation, T> factory) {
      return (T)Registry.register(BuiltInRegistries.ITEM, id, factory.apply(id));
   }

   static boolean markNYI(Properties settings) {
      if (!FMLEnvironment.production) {
         return false;
      } else {
         settings.stacksTo(0)
            .component(DataComponents.LORE, new ItemLore(List.of(Component.translatable(Lang.NOT_YET_IMPLEMENTED).setStyle(Style.EMPTY.withColor(-65536)))));
         return true;
      }
   }

   public static void register() {
   }

   public static void onCreative(BuildCreativeModeTabContentsEvent event) {
      if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
         event.accept(WEEN);
      } else if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
         event.accept(GREAT_LANTERN);
      } else if (event.getTabKey() == CreativeModeTabs.COMBAT) {
         event.accept(DEER_SKULL);
         event.accept(SACRIFICIAL_DAGGER);
         event.accept(SOUL_DAGGER);
         event.accept(GREAT_LANTERN);
         event.accept(BULWARK);
         event.accept(JOLLY_HAT);
      } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
         event.accept(EYES_BANNER_PATTERN);
         event.accept(CHAINLINK);
      } else if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
         event.accept(DEER_PHASE1_MUSIC_DISC);
         event.accept(DEER_PHASE2_MUSIC_DISC);
      } else if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
         event.accept(CULTIST_SPAWN_EGG);
         event.accept(CRUOR_SPAWN_EGG);
      } else if (event.getTabKey() == CreativeModeTabs.OP_BLOCKS) {
         event.accept(BOSS_SPAWNER);
      }
   }
}
