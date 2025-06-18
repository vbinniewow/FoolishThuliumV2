package net.vbinnie.pyrite.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vbinnie.pyrite.Pyrite;
import net.vbinnie.pyrite.block.custom.TreeSpiritBlock;

import static net.minecraft.block.Blocks.*;

public class ModBlocks {
    // METAL/ORE/MINERAL BLOCKS BELOW

    // THULIUM BLOCKS BELOW
    public static final Block PYRITE_BLOCK = registerBlock("pyrite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block RAW_PYRITE_BLOCK = registerBlock("raw_pyrite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block PYRITE_ORE = registerBlock("pyrite_ore",
            new Block(FabricBlockSettings.copyOf(IRON_ORE)));
    // THULIUM BLOCKS ABOVE

    // METAL/ORE/MINERAL BLOCKS ABOVE

    // NATURAL BLOCKS BELOW
    // NATURAL BLOCKS ABOVE



    // MAGIC BLOCKS BELOW
    public static final Block TREE_SPIRIT = registerBlock("tree_spirit",
            new TreeSpiritBlock(FabricBlockSettings.copyOf(CHERRY_WOOD)));
    // MAGIC BLOCKS ABOVE

    // DEV BLOCKS BELOW

    public static final Block DEV_BLOCK2 = registerBlockWithoutBlockItem("dev_block2",
            new Block(FabricBlockSettings.copyOf(Blocks.BEDROCK)));

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Pyrite.MOD_ID, name), block);


    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Pyrite.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Pyrite.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Pyrite.LOGGER.info("Registering ModBlocks for " + Pyrite.MOD_ID);
    }
}