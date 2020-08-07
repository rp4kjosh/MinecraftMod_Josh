package com.josh.rp4kmod.client;

import com.josh.rp4kmod.RP4KMod;
import com.josh.rp4kmod.entities.BombEntity;
import com.josh.rp4kmod.entities.PenguinEggEntity;
import com.josh.rp4kmod.entities.render.PenguinRenderer;
import com.josh.rp4kmod.util.RegistryHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RP4KMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event)
    {
        //Entities
        RenderingRegistry.registerEntityRenderingHandler( RegistryHandler.BOMB_ENTITY.get(), renderManager -> new SpriteRenderer<BombEntity>(renderManager, Minecraft.getInstance().getItemRenderer()));
        RenderingRegistry.registerEntityRenderingHandler( RegistryHandler.PENGUIN_ENTITY.get(), PenguinRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler( RegistryHandler.PENGUIN_EGG_ENTITY.get(), renderManager -> new SpriteRenderer<PenguinEggEntity>(renderManager, Minecraft.getInstance().getItemRenderer()));
    }
}
