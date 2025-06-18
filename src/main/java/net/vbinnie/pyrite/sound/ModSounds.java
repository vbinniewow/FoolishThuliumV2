package net.vbinnie.pyrite.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.vbinnie.pyrite.Pyrite;

public class ModSounds {
    public static final SoundEvent SPIRITUAL_PRESENCE = registerSoundEvent("spiritual_presence");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(Pyrite.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds() {
        Pyrite.LOGGER.info("Registering Mod Sounds for " + Pyrite.MOD_ID);
    }
}