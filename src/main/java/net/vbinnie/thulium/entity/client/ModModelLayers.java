package net.vbinnie.thulium.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.vbinnie.thulium.Thulium;

public class ModModelLayers {

    public static final EntityModelLayer CANCEROUS_RODENT =
            new EntityModelLayer(new Identifier(Thulium.MOD_ID, "cancerous_rodent"), "main");


    public static final EntityModelLayer HAMSTER =
            new EntityModelLayer(new Identifier(Thulium.MOD_ID, "hamster"), "main");

}
