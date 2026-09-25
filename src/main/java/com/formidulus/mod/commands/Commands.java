package com.formidulus.mod.commands;

import com.formidulus.mod.realtime.TimedEventHandler;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

public class Commands {
   public static void register() {
      NeoForge.EVENT_BUS.addListener(Commands::onRegister);
   }

   private static void onRegister(RegisterCommandsEvent event) {
      event.getDispatcher()
         .register(
            net.minecraft.commands.Commands.literal("formidulus")
               .requires(CommandSourceStack::isPlayer)
               .requires(source -> source.hasPermission(2))
               .then(net.minecraft.commands.Commands.literal("debug").then(net.minecraft.commands.Commands.literal("forceUpdateTimedEvents").executes(Commands::executeDebugForceUpdateTimedEvents)))
         );
   }

   private static int executeDebugForceUpdateTimedEvents(CommandContext<CommandSourceStack> context) {
      if (context.getSource().getPlayer() == null) {
         return 0;
      }
      TimedEventHandler.update();
      return 1;
   }
}
