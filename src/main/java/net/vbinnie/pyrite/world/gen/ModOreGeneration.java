package net.vbinnie.pyrite.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.vbinnie.pyrite.Pyrite;

public class ModOreGeneration {
    public static final RegistryKey<PlacedFeature> THULIUM_ORE_PLACED_KEY = registerKey("pyrite_ore_placed");

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Pyrite.MOD_ID, name));
    }

    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, THULIUM_ORE_PLACED_KEY);
    }
}