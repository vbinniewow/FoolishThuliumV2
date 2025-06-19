package net.vbinnie.pyrite.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.world.World;
import net.vbinnie.pyrite.damage_type.ModDamageTypes;

public class GoldPoisoningEffect extends StatusEffect {
    public GoldPoisoningEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
            World world = entity.getWorld();


            if (!world.isClient() && entity.age % 100 == 0) {
                    entity.damage(ModDamageTypes.of(world, ModDamageTypes.GOLDPOISONING), 2.0f * amplifier + 1);

            }
        }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {

        return true;
    }
}
