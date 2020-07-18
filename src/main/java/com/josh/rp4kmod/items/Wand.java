package com.josh.rp4kmod.items;

import com.josh.rp4kmod.entities.BombEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.apache.logging.log4j.core.jmx.Server;

public class Wand extends ItemBase {

    public Wand()
    {
        super();
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote) {

            LightningBoltEntity lightningbolt = new LightningBoltEntity(worldIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), false);


            //(ServerWorld)worldIn.addEntity(lightningbolt);
        }
        return ActionResult.resultSuccess(itemstack);
    }



}


