package com.josh.rp4kmod;

import com.josh.rp4kmod.entities.BombEntity;
import com.josh.rp4kmod.entities.PenguinEggEntity;
import com.josh.rp4kmod.entities.render.PenguinRenderer;
import com.josh.rp4kmod.util.RegistryHandler;
import com.josh.rp4kmod.world.gen.OreGenerator;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("rp4kmod")
@Mod.EventBusSubscriber(modid = RP4KMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RP4KMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "rp4kmod";

    public RP4KMod() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {

        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);

        RenderingRegistry.registerEntityRenderingHandler( RegistryHandler.BOMB_ENTITY.get(), renderManager -> new SpriteRenderer<BombEntity>(renderManager, Minecraft.getInstance().getItemRenderer()));
        RenderingRegistry.registerEntityRenderingHandler( RegistryHandler.PENGUIN_ENTITY.get(), PenguinRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler( RegistryHandler.PENGUIN_EGG_ENTITY.get(), renderManager -> new SpriteRenderer<PenguinEggEntity>(renderManager, Minecraft.getInstance().getItemRenderer()));

        LOGGER.debug("Registered Entity Renderers.");
    }

    public static final ItemGroup TAB = new ItemGroup("rp4ktab") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.TITANIUM_PICKAXE.get());
        }
    };

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
        OreGenerator.generateOre();
    }

}
