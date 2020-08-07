package com.josh.rp4kmod.items;

import com.josh.rp4kmod.RP4KMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

public class TitaniumChestplate extends ArmorItem {

    public TitaniumChestplate() {

        super(ModArmorMaterial.TITANIUM, EquipmentSlotType.CHEST, (new Properties()).group(RP4KMod.TAB));
    }
}
