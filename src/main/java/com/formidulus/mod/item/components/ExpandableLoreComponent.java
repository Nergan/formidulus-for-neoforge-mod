package com.formidulus.mod.item.components;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.network.chat.Style;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

public record ExpandableLoreComponent(List<Component> lines) {
   private static final Style STYLE = Style.EMPTY.withColor(ChatFormatting.DARK_PURPLE).withItalic(true);
   public static final Codec<ExpandableLoreComponent> CODEC = ComponentSerialization.FLAT_CODEC
      .sizeLimitedListOf(256)
      .xmap(ExpandableLoreComponent::new, ExpandableLoreComponent::lines);
   public static final StreamCodec<RegistryFriendlyByteBuf, ExpandableLoreComponent> PACKET_CODEC = ComponentSerialization.STREAM_CODEC
      .apply(ByteBufCodecs.list(256))
      .map(ExpandableLoreComponent::new, ExpandableLoreComponent::lines);

   public static ExpandableLoreComponent makeGeneric(ResourceLocation itemId, int lines) {
      String key = "item." + itemId.getNamespace() + "." + itemId.getPath() + ".lore";
      List<Component> list = new ArrayList<>();

      for (int i = 0; i < lines; i++) {
         list.add(Component.translatable(key + i).setStyle(STYLE));
      }

      Lists.transform(list, line -> ComponentUtils.mergeStyles(line.copy(), STYLE));
      return new ExpandableLoreComponent(list);
   }

   public static ExpandableLoreComponent makeGenericBlock(ResourceLocation itemId, int lines) {
      String key = "block." + itemId.getNamespace() + "." + itemId.getPath() + ".lore";
      List<Component> list = new ArrayList<>();

      for (int i = 0; i < lines; i++) {
         list.add(Component.translatable(key + i).setStyle(STYLE));
      }

      Lists.transform(list, line -> ComponentUtils.mergeStyles(line.copy(), STYLE));
      return new ExpandableLoreComponent(list);
   }

   public static ExpandableLoreComponent makeGeneric(ResourceLocation itemId, int lines, Style style) {
      String key = "item." + itemId.getNamespace() + "." + itemId.getPath() + ".lore";
      List<Component> list = new ArrayList<>();

      for (int i = 0; i < lines; i++) {
         list.add(Component.translatable(key + i));
      }

      Lists.transform(list, line -> ComponentUtils.mergeStyles(line.copy(), style));
      return new ExpandableLoreComponent(list);
   }
}
