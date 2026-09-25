package com.formidulus.mod.mixin;

import com.formidulus.mod.registries.BlockRegistry;
import com.formidulus.mod.registries.SoundRegistry;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import java.time.LocalDateTime;
import java.time.Month;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.PumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({PumpkinBlock.class})
public class PumpkinMixin {
   @WrapOperation(
      method = {"useItemOn(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/phys/BlockHitResult;)Lnet/minecraft/world/ItemInteractionResult;"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/world/level/Level;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z"
      )}
   )
   public boolean onSetCarvedBlock(
      Level instance, BlockPos pos, BlockState state, int flags, Operation<Boolean> original, @Local(argsOnly = true) Player player
   ) {
      LocalDateTime dateTime = LocalDateTime.now();
      float weenChance = 1.0E-4F;
      if (dateTime.getMonth().equals(Month.OCTOBER)) {
         weenChance = weenChance * 100.0F + (float)dateTime.getDayOfMonth() / 31.0F * 0.1F;
      } else {
         weenChance = Math.max(weenChance * 10.0F * (1.0F - (float)Math.abs(dateTime.getMonthValue() - 10) / 10.0F), weenChance);
      }

      if (instance.getRandom().nextFloat() <= weenChance) {
         if (player instanceof ServerPlayer serverPlayer) {
            var ween = serverPlayer.server.getAdvancements().get(com.formidulus.mod.Formidulus.identifier("ween")); if (ween != null) serverPlayer.getAdvancements().award(ween, "ween");
         }

         instance.playSound(null, pos, SoundRegistry.WEEN, SoundSource.BLOCKS, 1.0F, 1.0F);
         return instance.setBlock(
            pos,
            (BlockState)BlockRegistry.WEEN.defaultBlockState().setValue(CarvedPumpkinBlock.FACING, (Direction)state.getValue(CarvedPumpkinBlock.FACING)),
            flags
         );
      } else {
         return (Boolean)original.call(new Object[]{instance, pos, state, flags});
      }
   }
}
