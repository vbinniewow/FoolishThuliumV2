package net.vbinnie.pyrite.effect;


import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.vbinnie.pyrite.Pyrite;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> GOLDPOISONING = registerStatusEffect("cancer",
            new GoldPoisoningEffect(StatusEffectCategory.HARMFUL, 0x3ac02a));



    public static final RegistryEntry<StatusEffect> RADIOACTIVE = registerStatusEffect("radioactive",
            new RadioactiveEffect(StatusEffectCategory.HARMFUL, 0x49eb36));



    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Pyrite.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        Pyrite.LOGGER.info("Registering Mod Effects for " + Pyrite.MOD_ID);
    }
}
