package com.josh.rp4kmod.items;

import com.google.common.collect.ImmutableSet;
import com.josh.rp4kmod.RP4KMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;

import java.util.Set;

public class TitaniumPickaxe extends PickaxeItem {

    public TitaniumPickaxe() {

        super(ItemTier.DIAMOND, 5, 5.0f, new Item.Properties().group(RP4KMod.TAB));
    }
}
