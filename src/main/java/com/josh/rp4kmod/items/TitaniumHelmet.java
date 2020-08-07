package com.josh.rp4kmod.items;

import com.josh.rp4kmod.RP4KMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;

public class TitaniumHelmet extends ArmorItem {

    public TitaniumHelmet() {

        super(ModArmorMaterial.TITANIUM, EquipmentSlotType.HEAD, (new Item.Properties()).group(RP4KMod.TAB));
    }
}
