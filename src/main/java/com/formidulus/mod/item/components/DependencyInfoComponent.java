package com.formidulus.mod.item.components;

import net.neoforged.fml.ModList;
import com.formidulus.mod.datagen.Lang;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.function.Consumer;
import net.minecraft.ChatFormatting;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.chat.Style;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.component.TooltipProvider;

public record DependencyInfoComponent(String modid, Component text) implements TooltipProvider {
   private static final Style STYLE_REQUIRED = Style.EMPTY.withColor(ChatFormatting.RED).withItalic(true);
   private static final Style STYLE_ENHANCEMENT = Style.EMPTY.withColor(ChatFormatting.YELLOW).withItalic(true);
   public static final Codec<DependencyInfoComponent> CODEC = RecordCodecBuilder.create(
      instance -> instance.group(
               ExtraCodecs.NON_EMPTY_STRING.fieldOf("modid").forGetter(DependencyInfoComponent::modid),
               ComponentSerialization.FLAT_CODEC.fieldOf("text").forGetter(DependencyInfoComponent::text)
            )
            .apply(instance, DependencyInfoComponent::new)
   );
   public static final StreamCodec<RegistryFriendlyByteBuf, DependencyInfoComponent> PACKET_CODEC = StreamCodec.composite(
      ByteBufCodecs.STRING_UTF8,
      DependencyInfoComponent::modid,
      ComponentSerialization.TRUSTED_CONTEXT_FREE_STREAM_CODEC,
      DependencyInfoComponent::text,
      DependencyInfoComponent::new
   );

   public DependencyInfoComponent(String modid) {
      this(modid, true);
   }

   public DependencyInfoComponent(String modid, boolean required) {
      this(
         modid,
         Component.translatable(required ? Lang.DEPENDENCY_INFO_REQUIRED : Lang.DEPENDENCY_INFO_ENHANCEMENT, new Object[]{modid})
            .copy()
            .setStyle(required ? STYLE_REQUIRED : STYLE_ENHANCEMENT)
      );
   }

   public void addToTooltip(TooltipContext context, Consumer<Component> tooltip, TooltipFlag type) {
      if (!ModList.get().isLoaded(this.modid)) {
         tooltip.accept(this.text);
      }
   }
}
