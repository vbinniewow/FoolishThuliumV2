package net.vbinnie.thulium.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vbinnie.thulium.entity.client.cancerous_rodent.CancerousRodentRenderer;
import net.vbinnie.thulium.entity.custom.CancerousRodentEntity;
import net.vbinnie.thulium.entity.custom.HamsterEntity;
import net.vbinnie.thulium.Thulium;
import net.vbinnie.thulium.entity.custom.CancerousRodentEntity;

public class ModEntities {
    public static final EntityType<net.vbinnie.thulium.entity.custom.CancerousRodentEntity> CANCEROUS_RODENT = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Thulium.MOD_ID, "cancerous_rodent"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CancerousRodentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());




    public static final EntityType<HamsterEntity> HAMSTER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Thulium.MOD_ID, "hamster"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HamsterEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());
    public static void registerModEntities() {
        Thulium.LOGGER.info("Registering Mod Entities for " + Thulium.MOD_ID);
    }
}
