package com.formidulus.mod.item.abilities;

import com.formidulus.mod.item.components.AbilityComponent;
import com.formidulus.mod.registries.DataComponentRegistry;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class ItemAbility {
   public static final StreamCodec<ByteBuf, ItemAbility> PACKET_CODEC = StreamCodec.composite(
      ResourceLocation.STREAM_CODEC, i -> i.id, ByteBufCodecs.BOOL, i -> i.active, ItemAbility::new
   );
   protected static final Style STYLE = Style.EMPTY.withItalic(false).withColor(ChatFormatting.GRAY);
   public final ResourceLocation id;
   public boolean active;

   public ItemAbility(ResourceLocation id, boolean active) {
      this.id = id;
      this.active = active;
   }

   public ItemAbility(ResourceLocation id) {
      this.id = id;
      this.active = false;
   }

   public static boolean hasAbility(ItemStack stack, @NotNull ItemAbility ability) {
      AbilityComponent comp = (AbilityComponent)stack.getComponents().getOrDefault(DataComponentRegistry.ABILITY, null);
      return comp == null ? false : ability.equals(comp.ability());
   }

   public boolean isActive() {
      return this.active;
   }

   public void setActive(boolean b) {
      this.active = b;
   }

   public String getTranslationKey() {
      return "item-ability." + this.id.getNamespace() + "." + this.id.getPath();
   }

   public int getDescriptionLines() {
      return 0;
   }

   public List<MutableComponent> makeDescriptionLines() {
      if (this.getDescriptionLines() == 0) {
         return List.of();
      } else {
         List<MutableComponent> list = new ArrayList<>();

         for (int i = 0; i < this.getDescriptionLines(); i++) {
            list.add(Component.translatable(this.getTranslationKey() + ".desc" + i).setStyle(STYLE));
         }

         return list;
      }
   }

   public MutableComponent getNameText() {
      return Component.translatable(this.getTranslationKey()).setStyle(STYLE);
   }

   public void onDamageEntity(ItemStack stack, LivingEntity attacker, DamageSource source, float damage, LivingEntity target) {
   }

   public Optional<InteractionResultHolder<ItemStack>> onUse(
      ItemStack stack, LivingEntity user, InteractionHand hand, InteractionResultHolder<ItemStack> result
   ) {
      return Optional.empty();
   }

   public void onTickUsing(ItemStack stack, LivingEntity user, InteractionHand hand) {
   }

   public void onStopUsing(ItemStack stack, LivingEntity user, InteractionHand hand) {
   }

   public Optional<InteractionResult> onUseOnBlock(ItemStack stack, UseOnContext context, InteractionResult result) {
      return Optional.empty();
   }

   public Optional<InteractionResult> onUseOnEntity(ItemStack stack, Player user, LivingEntity target, InteractionHand hand, InteractionResult result) {
      return Optional.empty();
   }

   public void castActiveAbility(LivingEntity caster, ItemStack stack, Vec3 pos) {
   }
}
