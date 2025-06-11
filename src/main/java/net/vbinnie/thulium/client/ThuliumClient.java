package net.vbinnie.thulium.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.vbinnie.thulium.entity.ModEntities;
import net.vbinnie.thulium.entity.client.ModModelLayers;
import net.vbinnie.thulium.entity.client.cancerous_rodent.CancerousRodentModel;
import net.vbinnie.thulium.entity.client.cancerous_rodent.CancerousRodentRenderer;
import net.vbinnie.thulium.entity.client.hamster.HamsterModel;
import net.vbinnie.thulium.entity.client.hamster.HamsterRenderer;

public class ThuliumClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.HAMSTER, HamsterModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.HAMSTER, HamsterRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CANCEROUS_RODENT, CancerousRodentModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CANCEROUS_RODENT, CancerousRodentRenderer::new);

    }
}
