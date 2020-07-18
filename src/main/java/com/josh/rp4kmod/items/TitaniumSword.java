package com.josh.rp4kmod.items;

import com.josh.rp4kmod.RP4KMod;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;

public class TitaniumSword extends SwordItem {

    public TitaniumSword() {

        super(ItemTier.DIAMOND, 5, 5.0f, new Properties().group(RP4KMod.TAB));
    }
}
