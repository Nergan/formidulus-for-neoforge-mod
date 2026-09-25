package com.formidulus.mod.item;

import com.formidulus.mod.item.components.ChargeComponent;
import com.formidulus.mod.registries.BlockRegistry;
import com.formidulus.mod.registries.DataComponentRegistry;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.context.UseOnContext;

public class GreatLanternItem extends BlockItem {
   public GreatLanternItem(Properties settings) {
      super(BlockRegistry.GREAT_LANTERN, settings);
   }

   public InteractionResult useOn(UseOnContext context) {
      ChargeComponent charge = (ChargeComponent)context.getItemInHand().get(DataComponentRegistry.CHARGE);
      return charge != null && charge.isCharged(1.0F) && (context.getPlayer() == null || !context.getPlayer().isShiftKeyDown())
         ? this.use(context.getLevel(), context.getPlayer(), context.getHand()).getResult()
         : super.useOn(context);
   }
}
