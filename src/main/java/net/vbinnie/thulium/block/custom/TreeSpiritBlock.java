package net.vbinnie.thulium.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.vbinnie.thulium.effect.ModEffects;
import net.vbinnie.thulium.entity.ModEntities;
import net.vbinnie.thulium.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class TreeSpiritBlock extends Block {
    public TreeSpiritBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient) {

                // min coords
                double minX = pos.getX() - 10;
                double minY = pos.getY() - 10;
                double minZ = pos.getZ() - 10;

                // max coords
                double maxX = pos.getX() + 10;
                double maxY = pos.getY() + 10;
                double maxZ = pos.getZ() + 10;

                // Create the Box
                Box box = new Box(minX, minY, minZ, maxX, maxY, maxZ);

            LivingEntity closest = world.getClosestEntity(
                    LivingEntity.class,
                    TargetPredicate.DEFAULT, // or null
                    null, // Entity to exclude
                    pos.getX(), pos.getY(), pos.getZ(),
                    box
            );
           if (closest.getType() == EntityType.PLAYER) {
               world.playSound(pos.getX(), pos.getY(), pos.getZ(), ModSounds.SPIRITUAL_PRESENCE, SoundCategory.BLOCKS, 1, 1, true);
           }


        }

    }
}
