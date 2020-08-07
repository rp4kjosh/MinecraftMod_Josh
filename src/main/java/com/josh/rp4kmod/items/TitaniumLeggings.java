package com.josh.rp4kmod.items;

import com.josh.rp4kmod.RP4KMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

public class TitaniumLeggings extends ArmorItem {

    public TitaniumLeggings() {

        super(ModArmorMaterial.TITANIUM, EquipmentSlotType.LEGS, (new Properties()).group(RP4KMod.TAB));
    }
}
