package net.vbinnie.thulium.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.vbinnie.thulium.Thulium;

public class ModSounds {
    public static final SoundEvent SPIRITUAL_PRESENCE = registerSoundEvent("spiritual_presence");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(Thulium.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds() {
        Thulium.LOGGER.info("Registering Mod Sounds for " + Thulium.MOD_ID);
    }
}