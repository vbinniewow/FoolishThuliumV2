package net.vbinnie.pyrite.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.vbinnie.pyrite.entity.ModEntities;
import net.vbinnie.pyrite.entity.custom.HamsterEntity;

public class ModRegistries {
    public static void registerModStuffs() {
        registerAttributes();

    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.HAMSTER, HamsterEntity.createAttribute());
//        FabricDefaultAttributeRegistry.register(ModEntities.CANCEROUS_RODENT, CancerousRodentEntity.createAttribute());
    }
}
