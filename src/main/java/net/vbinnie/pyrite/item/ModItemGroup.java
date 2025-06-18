package net.vbinnie.pyrite.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.vbinnie.pyrite.Pyrite;
import net.vbinnie.pyrite.block.ModBlocks;

public class ModItemGroup {
    public static final ItemGroup PYRITE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Pyrite.MOD_ID, "pyrite_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pyrite_group"))
                    .icon(() -> new ItemStack(ModItems.PYRITE_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_PYRITE);
                        entries.add(ModItems.PYRITE_INGOT);


                        //

                        entries.add(ModBlocks.RAW_PYRITE_BLOCK);
                        entries.add(ModBlocks.PYRITE_BLOCK);
                        entries.add(ModBlocks.PYRITE_ORE);
                        entries.add(ModBlocks.TREE_SPIRIT);




                    }).build());

    public static void registerItemGroups() {

    }
}