package net.vbinnie.pyrite.entity.client.hamster;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.vbinnie.pyrite.Pyrite;
import net.vbinnie.pyrite.entity.client.ModModelLayers;
import net.vbinnie.pyrite.entity.custom.HamsterEntity;


public class HamsterRenderer extends MobEntityRenderer<HamsterEntity, HamsterModel<HamsterEntity>> {
    public HamsterRenderer(EntityRendererFactory.Context context) {
        super(context, new HamsterModel<>(context.getPart(ModModelLayers.HAMSTER)), 0.05f);
    }



    @Override
    public Identifier getTexture(HamsterEntity entity) {
        return Identifier.of(Pyrite.MOD_ID, "textures/entity/rodent/hamster.png");
    }

    @Override
    public void render(HamsterEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(.5f, .5f, .5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

}
