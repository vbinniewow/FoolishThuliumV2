package net.vbinnie.thulium.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.vbinnie.thulium.Thulium;
import net.vbinnie.thulium.block.ModBlocks;

public class ModItemGroup {
    public static final ItemGroup THULIUM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Thulium.MOD_ID, "thulium_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.thulium_group"))
                    .icon(() -> new ItemStack(ModItems.THULIUM_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_THULIUM);
                        entries.add(ModItems.THULIUM_INGOT);


                        //

                        entries.add(ModBlocks.THULIUM_BLOCK);
                        entries.add(ModBlocks.RAW_THULIUM_BLOCK);
                        entries.add(ModBlocks.THULIUM_ORE);




                    }).build());

    public static void registerItemGroups() {

    }
}