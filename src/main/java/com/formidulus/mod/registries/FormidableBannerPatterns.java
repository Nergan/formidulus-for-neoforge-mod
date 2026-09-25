package com.formidulus.mod.registries;

import com.formidulus.mod.Formidulus;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public class FormidableBannerPatterns {
   public static final ResourceKey<BannerPattern> EYES = ResourceKey.create(Registries.BANNER_PATTERN, Formidulus.identifier("eyes"));
   public static final TagKey<BannerPattern> EYES_TAG = TagKey.create(Registries.BANNER_PATTERN, Formidulus.identifier("eyes"));
}
