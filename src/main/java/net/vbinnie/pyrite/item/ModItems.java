package net.vbinnie.pyrite.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vbinnie.pyrite.Pyrite;

public class ModItems {
    public static final Item PYRITE_INGOT = registerItem("pyrite_ingot",
            new Item(new FabricItemSettings()));
    public static final Item RAW_PYRITE = registerItem("raw_pyrite",
            new Item(new FabricItemSettings()));




    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Pyrite.MOD_ID, name), item);
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
    }

    public static void registerModItems() {
        Pyrite.LOGGER.info("Registering Mod Items for " + Pyrite.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}