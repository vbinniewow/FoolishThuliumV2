package net.vbinnie.pyrite.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.vbinnie.pyrite.entity.ModEntities;


public class RadioactiveEffect extends StatusEffect {

    public RadioactiveEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        if (!world.isClient) {
            Box box = entity.getBoundingBox().expand(10);

            LivingEntity closest = world.getClosestEntity(
                    LivingEntity.class,
                    TargetPredicate.DEFAULT, // or null
                    entity, // exclusion
                    entity.getX(), entity.getY(), entity.getZ(),
                    box
            );
//            if (entity.getType() == ModEntities.CANCEROUS_RODENT) {
//                if (closest!=null) {
//                    closest.addStatusEffect(new StatusEffectInstance(ModEffects.GOLDPOISONING.value(), 400));
//                    for (StatusEffectInstance effect : entity.getStatusEffects()) {
//
//                        closest.addStatusEffect(effect);
//                    }
//                }
//            } else
            if (closest!=null) {

                if (entity.getStatusEffects() != null) {

                    for (StatusEffectInstance effect : entity.getStatusEffects()) {

                        closest.addStatusEffect(effect);
                    }

                }
            }


        }

    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
