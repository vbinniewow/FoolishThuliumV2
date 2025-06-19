package net.vbinnie.pyrite.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.vbinnie.pyrite.Pyrite;
import net.vbinnie.pyrite.block.custom.entity.ModBlockEntities;
import net.vbinnie.pyrite.block.custom.entity.TreeSpiritBlockEntity;

import net.vbinnie.pyrite.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class TreeSpiritBlock extends BlockWithEntity implements BlockEntityProvider {

    public TreeSpiritBlock(Settings settings) {
        super(settings);
           }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TreeSpiritBlockEntity(pos, state);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        world.updateComparators(pos, this);

        super.neighborUpdate(state, world, pos, block, fromPos, notify);
    }



    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return world.getBlockEntity(pos) instanceof TreeSpiritBlockEntity sensor
                ? sensor.isPlayerNearby()? 15 : 0
                : 0;
    }


    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return world.getBlockEntity(pos) instanceof TreeSpiritBlockEntity sensor
                ? sensor.isPlayerNearby() ? 15 : 0
                : 0;
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!world.isClient()) {
            world.scheduleBlockTick(pos, this, 65);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof TreeSpiritBlockEntity sensor) {
            world.updateNeighbors(pos, this);
            sensor.checkForPlayers(world, this, pos);
            world.updateListeners(pos, state, state, 3);
            world.scheduleBlockTick(pos, this, 10);
        }
    }
}
