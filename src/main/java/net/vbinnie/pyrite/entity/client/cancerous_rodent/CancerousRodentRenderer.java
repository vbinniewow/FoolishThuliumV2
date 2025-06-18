package net.vbinnie.pyrite.entity.client.cancerous_rodent;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.vbinnie.pyrite.entity.client.ModModelLayers;
import net.vbinnie.pyrite.entity.custom.CancerousRodentEntity;
import net.vbinnie.pyrite.Pyrite;

public class CancerousRodentRenderer extends MobEntityRenderer<CancerousRodentEntity, CancerousRodentModel<CancerousRodentEntity>> {
    public CancerousRodentRenderer(EntityRendererFactory.Context context) {
        super(context, new CancerousRodentModel<>(context.getPart(ModModelLayers.CANCEROUS_RODENT)), 0.05f);
    }

    @Override
    public Identifier getTexture(net.vbinnie.pyrite.entity.custom.CancerousRodentEntity entity) {
        return Identifier.of(Pyrite.MOD_ID, "textures/entity/rodent/cancerous/cancerous_rodent.png");
    }

    @Override
    public void render(CancerousRodentEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(.5f, .5f, .5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
