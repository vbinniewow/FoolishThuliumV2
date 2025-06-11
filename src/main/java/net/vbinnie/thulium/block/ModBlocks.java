package net.vbinnie.thulium.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vbinnie.thulium.Thulium;

import static net.minecraft.block.Blocks.*;

public class ModBlocks {
    // METAL/ORE/MINERAL BLOCKS BELOW

    // THULIUM BLOCKS BELOW
    public static final Block THULIUM_BLOCK = registerBlock("thulium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block RAW_THULIUM_BLOCK = registerBlock("raw_thulium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block THULIUM_ORE = registerBlock("thulium_ore",
            new Block(FabricBlockSettings.copyOf(IRON_ORE)));
    // THULIUM BLOCKS ABOVE

    // METAL/ORE/MINERAL BLOCKS ABOVE

    // NATURAL BLOCKS BELOW

    // NATURAL BLOCKS ABOVE

    public static final Block DEV_BLOCK2 = registerBlockWithoutBlockItem("dev_block2",
            new Block(FabricBlockSettings.copyOf(Blocks.BEDROCK)));
    // DEV BLOCKS ABOVE


    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Thulium.MOD_ID, name), block);


    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Thulium.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Thulium.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Thulium.LOGGER.info("Registering ModBlocks for " + Thulium.MOD_ID);
    }
}