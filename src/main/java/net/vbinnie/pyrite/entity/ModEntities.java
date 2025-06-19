package net.vbinnie.pyrite.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vbinnie.pyrite.Pyrite;
import net.vbinnie.pyrite.entity.custom.HamsterEntity;

public class ModEntities {



    public static final EntityType<HamsterEntity> HAMSTER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Pyrite.MOD_ID, "hamster"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HamsterEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());
    public static void registerModEntities() {
        Pyrite.LOGGER.info("Registering Mod Entities for " + Pyrite.MOD_ID);
    }
}
