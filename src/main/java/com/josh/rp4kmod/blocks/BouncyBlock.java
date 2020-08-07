package com.josh.rp4kmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BouncyBlock extends Block {

    public BouncyBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.METAL)
                .harvestLevel(1)
                .harvestTool((ToolType.PICKAXE)));
    }

    /**
     * Called when the given entity walks on this Block
     *
     * @param worldIn
     * @param pos
     * @param entityIn
     */
    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.addVelocity(0, 2, 0);
    }
}
