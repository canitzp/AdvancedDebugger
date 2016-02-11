package de.canitzp.advanceddebugger.events;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;


/**
 * @author canitzp
 */
public class EventHandler {

    public static void init(FMLInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(new BlockEvents(event));
        MinecraftForge.EVENT_BUS.register(new EntityEvents(event));
    }

}
