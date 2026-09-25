package com.formidulus.mod.item.abilities;

import com.formidulus.mod.Formidulus;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class ItemAbilities {
   public static final Map<ResourceLocation, ItemAbility> map = new HashMap<>();
   public static final ItemAbility NONE = register(new ItemAbility(Formidulus.identifier("none")));
   public static final ItemAbility VAMPIRISM = register(new VampirismAbility(Formidulus.identifier("vampirism")));
   public static final ItemAbility SOULSTEAL = register(new SoulStealAbility(Formidulus.identifier("soulsteal")));
   public static final ItemAbility HEALWAVE = register(new HealwaveAbility(Formidulus.identifier("healwave")));
   public static final ItemAbility BULWARK = register(new BulwarkAbility(Formidulus.identifier("bulwark")));

   public static ItemAbility register(ItemAbility ability) {
      map.put(ability.id, ability);
      return ability;
   }

   @Nullable
   public static ItemAbility getFromId(ResourceLocation id) {
      return map.get(id);
   }
}
