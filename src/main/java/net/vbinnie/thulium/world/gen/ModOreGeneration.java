package net.vbinnie.thulium.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.vbinnie.thulium.Thulium;

public class ModOreGeneration {
    public static final RegistryKey<PlacedFeature> THULIUM_ORE_PLACED_KEY = registerKey("thulium_ore_placed");

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Thulium.MOD_ID, name));
    }

    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, THULIUM_ORE_PLACED_KEY);
    }
}