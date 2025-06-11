package net.vbinnie.thulium.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.vbinnie.thulium.entity.ModEntities;
import net.vbinnie.thulium.entity.custom.CancerousRodentEntity;
import net.vbinnie.thulium.entity.custom.HamsterEntity;

public class ModRegistries {
    public static void registerModStuffs() {
        registerAttributes();

    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.HAMSTER, HamsterEntity.createAttribute());
        FabricDefaultAttributeRegistry.register(ModEntities.CANCEROUS_RODENT, CancerousRodentEntity.createAttribute());
    }
}
