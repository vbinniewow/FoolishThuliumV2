package net.vbinnie.pyrite.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.vbinnie.pyrite.block.ModBlocks;
import net.vbinnie.pyrite.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PYRITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PYRITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PYRITE_ORE);


        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEV_BLOCK2);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_PYRITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PYRITE_INGOT, Models.GENERATED);
    }
}
