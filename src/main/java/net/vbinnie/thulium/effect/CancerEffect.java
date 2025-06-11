package net.vbinnie.thulium.effect;

import io.netty.channel.nio.NioEventLoop;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.world.World;
import net.vbinnie.thulium.damage_type.ModDamageTypes;

import static org.lwjgl.system.macosx.ObjCRuntime.nil;

public class CancerEffect extends StatusEffect {
    public CancerEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
            World world = entity.getWorld();


            if (!world.isClient() && entity.age % 100 == 0) {
                if(entity.hasStatusEffect(ModEffects.CANCERIMMUNITY.value())) {
                entity.removeStatusEffect(ModEffects.CANCER.value());
                }
                 else {
                    entity.damage(ModDamageTypes.of(world, ModDamageTypes.CANCERDAMAGE), 2.0f * amplifier + 1);
                }
            }
        }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {

        return true;
    }
}
