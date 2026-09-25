package com.formidulus.mod.components;

import com.formidulus.mod.Formidulus;
import com.formidulus.mod.components.entity.BulwarkAbilityEntityComponent;
import com.formidulus.mod.components.entity.IBulwarkComponent;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class FormidableComponents {
   public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Formidulus.MOD_ID);
   public static final Supplier<AttachmentType<BulwarkAbilityEntityComponent>> BULWARK = ATTACHMENTS.register(
      "bulwark",
      () -> AttachmentType.builder(holder -> new BulwarkAbilityEntityComponent((Player)holder)).build()
   );

   public static IBulwarkComponent bulwark(Player player) {
      return player.getData(BULWARK.get());
   }
}
