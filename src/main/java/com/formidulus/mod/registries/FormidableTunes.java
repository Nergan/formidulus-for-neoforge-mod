package com.formidulus.mod.registries;

import com.formidulus.mod.Formidulus;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

public class FormidableTunes {
   public static final ResourceKey<JukeboxSong> DEER_PHASE1 = ResourceKey.create(Registries.JUKEBOX_SONG, Formidulus.identifier("deer_phase1"));
   public static final ResourceKey<JukeboxSong> DEER_PHASE2 = ResourceKey.create(Registries.JUKEBOX_SONG, Formidulus.identifier("deer_phase2"));
}
