package net.vbinnie.thulium.damage_type;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import net.vbinnie.thulium.Thulium;


public class ModDamageTypes {

    public static final RegistryKey<DamageType> CANCERDAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Thulium.MOD_ID, "cancerdamage"));

    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}
