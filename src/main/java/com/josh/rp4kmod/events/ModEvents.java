package com.josh.rp4kmod.events;

import com.josh.rp4kmod.RP4KMod;
import com.josh.rp4kmod.command.HelloCommand;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

@Mod.EventBusSubscriber(modid = RP4KMod.MOD_ID)
public class ModEvents {



    @SubscribeEvent
    public static void onServerStarting(final FMLServerStartingEvent event){
        HelloCommand.register(event.getCommandDispatcher());
        System.out.println("ON SERVER STARTING EVENT");
    }
}
