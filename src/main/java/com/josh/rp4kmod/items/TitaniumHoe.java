package com.josh.rp4kmod.items;

import com.josh.rp4kmod.RP4KMod;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;

public class TitaniumHoe extends HoeItem {

    public TitaniumHoe() {

        super(ItemTier.DIAMOND, 5, new Properties().group(RP4KMod.TAB));
    }
}
