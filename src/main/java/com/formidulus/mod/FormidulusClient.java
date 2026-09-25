package com.formidulus.mod;

import com.formidulus.mod.entities.boss.BossType;
import com.formidulus.mod.gui.TitleHUD;
import com.formidulus.mod.item.components.AccessoryComponent;
import com.formidulus.mod.item.components.ChargeComponent;
import com.formidulus.mod.particle.BloodDropParticle;
import com.formidulus.mod.particle.DarknessParticle;
import com.formidulus.mod.particle.GatheringDarknessParticle;
import com.formidulus.mod.particle.RisingDarknessParticle;
import com.formidulus.mod.registries.BlockEntityRegistry;
import com.formidulus.mod.registries.BlockRegistry;
import com.formidulus.mod.registries.DataComponentRegistry;
import com.formidulus.mod.registries.EntityRegistry;
import com.formidulus.mod.registries.ItemRegistry;
import com.formidulus.mod.registries.ParticleRegistry;
import com.formidulus.mod.rendering.block.BossSpawnerRenderer;
import com.formidulus.mod.rendering.block.DeerSkullBlockEntityRenderer;
import com.formidulus.mod.rendering.entity.BulwarkEntityRenderer;
import com.formidulus.mod.rendering.entity.DeerFollowerModel;
import com.formidulus.mod.rendering.entity.DeerFollowerRenderer;
import com.formidulus.mod.rendering.entity.DeerGodModel;
import com.formidulus.mod.rendering.entity.DeerGodRenderer;
import com.formidulus.mod.rendering.entity.IrrlichtModel;
import com.formidulus.mod.rendering.entity.IrrlichtRenderer;
import com.formidulus.mod.rendering.entity.PumpkinRenderer;
import com.formidulus.mod.rendering.entity.feature.CreeperHeadFeatureRenderer;
import com.formidulus.mod.rendering.equipment.BulwarkItemRenderer;
import com.formidulus.mod.rendering.equipment.BulwarkModel;
import com.formidulus.mod.rendering.equipment.DeerGodSkullModel;
import com.formidulus.mod.rendering.equipment.DeerGodSkullRenderer;
import com.formidulus.mod.rendering.equipment.JollyHatModel;
import com.formidulus.mod.rendering.equipment.JollyHatRenderer;
import com.formidulus.mod.sound.BossMusicHandler;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

public class FormidulusClient {
   public static final ModelLayerLocation DEER_GOD_LAYER = new ModelLayerLocation(Formidulus.identifier("deer_god"), "deer_god");
   public static final ModelLayerLocation DEER_GOD_SKULL_LAYER = new ModelLayerLocation(Formidulus.identifier("deer_god_skull"), "deer_god_skull");
   public static final ModelLayerLocation IRRLICHT_LAYER = new ModelLayerLocation(Formidulus.identifier("irrlicht"), "irrlicht");
   public static final ModelLayerLocation DEER_FOLLOWER_LAYER = new ModelLayerLocation(Formidulus.identifier("deer_follower"), "deer_follower");
   public static final ModelLayerLocation JOLLY_HAT_LAYER = new ModelLayerLocation(Formidulus.identifier("jolly_hat"), "jolly_hat");
   public static final ModelLayerLocation BULWARK_LAYER = new ModelLayerLocation(Formidulus.identifier("bulwark"), "bulwark");
   public static BossMusicHandler bossMusicHandler;

   public static void register(IEventBus modBus, net.neoforged.fml.ModContainer container) {
      modBus.addListener(FormidulusClient::registerRenderers);
      modBus.addListener(FormidulusClient::registerLayers);
      modBus.addListener(FormidulusClient::registerParticles);
      modBus.addListener(FormidulusClient::registerModels);
      modBus.addListener(FormidulusClient::addLayers);
      modBus.addListener(FormidulusClient::registerExtensions);
      NeoForge.EVENT_BUS.addListener(FormidulusClient::renderHud);
      NeoForge.EVENT_BUS.addListener(FormidulusClient::clientTick);
      NeoForge.EVENT_BUS.addListener(FormidulusClient::loggedOut);
      modBus.addListener(FormidulusClient::clientSetup);
      bossMusicHandler = new BossMusicHandler();
      container.registerExtensionPoint(
         net.neoforged.neoforge.client.gui.IConfigScreenFactory.class,
         new net.neoforged.neoforge.client.gui.IConfigScreenFactory() {
            @Override
            public net.minecraft.client.gui.screens.Screen createScreen(net.neoforged.fml.ModContainer modContainer, net.minecraft.client.gui.screens.Screen parent) {
               return new net.neoforged.neoforge.client.gui.ConfigurationScreen(modContainer, parent);
            }
         }
      );
   }

   private static void clientSetup(FMLClientSetupEvent event) {
      event.enqueueWork(() -> {
         ItemProperties.registerGeneric(Formidulus.identifier("accessory_mode"), (stack, world, entity, seed) -> {
            AccessoryComponent component = stack.getOrDefault(DataComponentRegistry.ACCESSORY, AccessoryComponent.DEFAULT);
            return (float)(component.activeMode() % component.modes().size());
         });
         ItemProperties.registerGeneric(Formidulus.identifier("charge"), (stack, world, entity, seed) -> {
            ChargeComponent stateComp = stack.get(DataComponentRegistry.CHARGE);
            return stateComp == null ? 0.0F : stateComp.getChargePercent();
         });
         ItemBlockRenderTypes.setRenderLayer(BlockRegistry.GREAT_LANTERN, RenderType.cutout());
      });
   }

   private static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
      event.registerEntityRenderer(EntityRegistry.DEER_GOD, DeerGodRenderer::new);
      event.registerEntityRenderer(EntityRegistry.IRRLICHT, IrrlichtRenderer::new);
      event.registerEntityRenderer(EntityRegistry.PUMPKIN, PumpkinRenderer::new);
      event.registerEntityRenderer(EntityRegistry.DEER_FOLLOWER, DeerFollowerRenderer::new);
      event.registerEntityRenderer(EntityRegistry.BULWARK, BulwarkEntityRenderer::new);
      event.registerBlockEntityRenderer(BlockEntityRegistry.DEER_SKULL, DeerSkullBlockEntityRenderer::new);
      event.registerBlockEntityRenderer(BlockEntityRegistry.BOSS_SPAWNER, BossSpawnerRenderer::new);
   }

   private static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
      event.registerLayerDefinition(DEER_GOD_LAYER, DeerGodModel::getTexturedModelData);
      event.registerLayerDefinition(IRRLICHT_LAYER, IrrlichtModel::getTexturedModelData);
      event.registerLayerDefinition(DEER_FOLLOWER_LAYER, DeerFollowerModel::getTexturedModelData);
      event.registerLayerDefinition(DEER_GOD_SKULL_LAYER, DeerGodSkullModel::getTexturedModelData);
      event.registerLayerDefinition(JOLLY_HAT_LAYER, JollyHatModel::getTexturedModelData);
      event.registerLayerDefinition(BULWARK_LAYER, BulwarkModel::getTexturedModelData);
   }

   private static void registerParticles(RegisterParticleProvidersEvent event) {
      event.registerSpriteSet(ParticleRegistry.BLOOD_DROP_PARTICLE, BloodDropParticle.Factory::new);
      event.registerSpriteSet(ParticleRegistry.DARKNESS, DarknessParticle.Factory::new);
      event.registerSpriteSet(ParticleRegistry.RISING_DARKNESS, RisingDarknessParticle.Factory::new);
      event.registerSpriteSet(ParticleRegistry.GATHERING_DARKNESS, GatheringDarknessParticle.Factory::new);
   }

   private static void registerModels(ModelEvent.RegisterAdditional event) {
      BossType.getAllTypes().forEach((id, type) -> {
         if (!type.spawnerModel().isEmpty()) {
            event.register(new net.minecraft.client.resources.model.ModelResourceLocation(Formidulus.identifier("block/" + type.spawnerModel()), "standalone"));
         }
      });
   }

   private static void addLayers(EntityRenderersEvent.AddLayers event) {
      var renderer = event.getRenderer(EntityType.CREEPER);
      if (renderer instanceof CreeperRenderer creeperRenderer) {
         creeperRenderer.addLayer(new CreeperHeadFeatureRenderer(creeperRenderer));
      }
   }

   private static void registerExtensions(RegisterClientExtensionsEvent event) {
      event.registerItem(renderer(new DeerGodSkullRenderer()), ItemRegistry.DEER_SKULL);
      event.registerItem(renderer(new JollyHatRenderer()), ItemRegistry.JOLLY_HAT);
      event.registerItem(renderer(new BulwarkItemRenderer()), ItemRegistry.BULWARK);
   }

   private static IClientItemExtensions renderer(net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer custom) {
      return new IClientItemExtensions() {
         @Override
         public net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer getCustomRenderer() {
            return custom;
         }
      };
   }

   private static void renderHud(RenderGuiEvent.Post event) {
      TitleHUD.render(event.getGuiGraphics(), event.getPartialTick().getGameTimeDeltaTicks());
   }

   private static void clientTick(net.neoforged.neoforge.client.event.ClientTickEvent.Post event) {
      var client = net.minecraft.client.Minecraft.getInstance();
      if (!client.isPaused() && bossMusicHandler != null) {
         bossMusicHandler.tick();
      }
   }

   private static void loggedOut(net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent.LoggingOut event) {
      if (bossMusicHandler != null) {
         bossMusicHandler.stopAll();
      }
   }
}
