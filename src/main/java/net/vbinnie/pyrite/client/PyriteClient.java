package net.vbinnie.pyrite.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.vbinnie.pyrite.entity.ModEntities;
import net.vbinnie.pyrite.entity.client.ModModelLayers;
import net.vbinnie.pyrite.entity.client.cancerous_rodent.CancerousRodentModel;
import net.vbinnie.pyrite.entity.client.cancerous_rodent.CancerousRodentRenderer;
import net.vbinnie.pyrite.entity.client.hamster.HamsterModel;
import net.vbinnie.pyrite.entity.client.hamster.HamsterRenderer;

public class PyriteClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.HAMSTER, HamsterModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.HAMSTER, HamsterRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CANCEROUS_RODENT, CancerousRodentModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CANCEROUS_RODENT, CancerousRodentRenderer::new);

    }
}
