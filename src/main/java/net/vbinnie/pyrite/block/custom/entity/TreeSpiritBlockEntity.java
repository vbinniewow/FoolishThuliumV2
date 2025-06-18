package net.vbinnie.pyrite.block.custom.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.vbinnie.pyrite.block.custom.TreeSpiritBlock;
import net.vbinnie.pyrite.sound.ModSounds;

import java.util.List;

public class TreeSpiritBlockEntity extends BlockEntity {

    private boolean playerNearby = false;


    public TreeSpiritBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TREE_SPIRIT_BLOCK_ENTITY, pos, state);
    }

    public void checkForPlayers(World world, TreeSpiritBlock block, BlockPos position) {
        if (world.isClient()) return;


        List<PlayerEntity> players = world.getEntitiesByClass(PlayerEntity.class,
                new Box(position).expand(4), EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR);


if (!players.isEmpty()) {
    world.playSound(null, position, ModSounds.SPIRITUAL_PRESENCE, SoundCategory.BLOCKS, 0.05f, 2.5f);
}
        this.playerNearby = !players.isEmpty();
        world.getBlockState(position).updateNeighbors(world, pos, 1, 7);


    }

    public boolean isPlayerNearby() {
        return playerNearby;
    }

}