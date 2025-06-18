package net.vbinnie.pyrite;

import net.fabricmc.api.ModInitializer;
import net.vbinnie.pyrite.block.ModBlocks;
import net.vbinnie.pyrite.block.custom.entity.ModBlockEntities;
import net.vbinnie.pyrite.effect.ModEffects;
import net.vbinnie.pyrite.entity.ModEntities;
import net.vbinnie.pyrite.item.ModItemGroup;
import net.vbinnie.pyrite.item.ModItems;
import net.vbinnie.pyrite.sound.ModSounds;
import net.vbinnie.pyrite.util.ModRegistries;
import net.vbinnie.pyrite.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pyrite implements ModInitializer {

    public static final String MOD_ID = "pyrite";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        ModWorldGeneration.generateModWorldGeneration();

        ModItemGroup.registerItemGroups();

        ModEffects.registerEffects();

        ModItems.registerModItems();

        ModEntities.registerModEntities();

        ModRegistries.registerModStuffs();

        ModBlocks.registerModBlocks();

        ModSounds.registerSounds();

        ModBlockEntities.registerBlockEntities();
    }
}
