package com.josh.rp4kmod.items;

import com.josh.rp4kmod.RP4KMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

public class TitaniumBoots extends ArmorItem {

    public TitaniumBoots() {

        super(ArmorMaterial.DIAMOND, EquipmentSlotType.FEET, (new Properties()).group(RP4KMod.TAB));
    }
}
