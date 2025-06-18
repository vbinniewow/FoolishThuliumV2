package net.vbinnie.pyrite.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.vbinnie.pyrite.Pyrite;

public class ModModelLayers {

    public static final EntityModelLayer CANCEROUS_RODENT =
            new EntityModelLayer(new Identifier(Pyrite.MOD_ID, "cancerous_rodent"), "main");


    public static final EntityModelLayer HAMSTER =
            new EntityModelLayer(new Identifier(Pyrite.MOD_ID, "hamster"), "main");

}
