package com.josh.rp4kmod.blocks;

import com.josh.rp4kmod.RP4KMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class BlockItemBase extends BlockItem {
    public BlockItemBase(Block block) {

        super(block, new Properties().group(RP4KMod.TAB));
    }
}
