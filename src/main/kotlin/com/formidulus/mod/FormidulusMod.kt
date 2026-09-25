package com.formidulus.mod

import com.formidulus.mod.config.ServerConfig
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.IEventBus
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.Mod
import net.neoforged.fml.loading.FMLEnvironment
import net.neoforged.neoforge.common.ModConfigSpec

@Mod(Formidulus.MOD_ID)
class FormidulusMod(modBus: IEventBus, container: ModContainer) {
    init {
        val builder = ModConfigSpec.Builder()
        Formidulus.config = ServerConfig(builder)
        container.registerConfig(net.neoforged.fml.config.ModConfig.Type.SERVER, builder.build())
        Formidulus().bootstrap(modBus)
        if (FMLEnvironment.dist == Dist.CLIENT) {
            FormidulusClient.register(modBus, container)
        }
    }
}
