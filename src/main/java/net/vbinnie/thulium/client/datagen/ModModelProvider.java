package net.vbinnie.thulium.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.vbinnie.thulium.block.ModBlocks;
import net.vbinnie.thulium.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.THULIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_THULIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.THULIUM_ORE);


        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEV_BLOCK2);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_THULIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.THULIUM_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.ASBESTOS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CANCEROUS_SUBSTANCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CANCEROUS_FLESH, Models.GENERATED);
        itemModelGenerator.register(ModItems.CANCEROUS_BONE, Models.GENERATED);
    }
}
