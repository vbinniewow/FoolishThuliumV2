package net.vbinnie.thulium;

import net.fabricmc.api.ModInitializer;
import net.vbinnie.thulium.block.ModBlocks;
import net.vbinnie.thulium.damage_type.ModDamageTypes;
import net.vbinnie.thulium.effect.ModEffects;
import net.vbinnie.thulium.entity.ModEntities;
import net.vbinnie.thulium.item.ModItemGroup;
import net.vbinnie.thulium.item.ModItems;
import net.vbinnie.thulium.util.ModRegistries;
import net.vbinnie.thulium.world.gen.ModOreGeneration;
import net.vbinnie.thulium.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thulium implements ModInitializer {

    public static final String MOD_ID = "thulium";
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

    }
}
