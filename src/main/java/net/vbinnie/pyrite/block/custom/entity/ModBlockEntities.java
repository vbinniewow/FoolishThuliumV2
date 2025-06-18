package net.vbinnie.pyrite.block.custom.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vbinnie.pyrite.Pyrite;
import net.vbinnie.pyrite.block.ModBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<TreeSpiritBlockEntity> TREE_SPIRIT_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Pyrite.MOD_ID, "tree_spirit_block_entity"),
                    FabricBlockEntityTypeBuilder.create(TreeSpiritBlockEntity::new,
                            ModBlocks.TREE_SPIRIT).build(null));

    public static void registerBlockEntities() {
        Pyrite.LOGGER.info("Registering Block Entities for " + Pyrite.MOD_ID);
    }
}
