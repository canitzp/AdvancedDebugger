package de.canitzp.advanceddebugger.events;

import de.canitzp.advanceddebugger.AdvancedDebugger;
import de.canitzp.advanceddebugger.Configuration;
import de.canitzp.advanceddebugger.StringSerializer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author canitzp
 */
public class EntityEvents {

    private FMLInitializationEvent event;

    public EntityEvents(FMLInitializationEvent event) {
        this.event = event;
    }

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if(event.entity instanceof EntityItem && !Configuration.getBoolFromProp("Log_Item_Entities")){
            return;
        }
        if(event.entity instanceof EntityPlayer && !Configuration.getBoolFromProp("Log_EntityPlayer")){
            return;
        }
        if(event.entity instanceof EntityLiving && !Configuration.getBoolFromProp("Log_EntityLiving")){
            return;
        }
        AdvancedDebugger.logger.info(StringSerializer.fromGenericEntity(event.entity) + " joined " + StringSerializer.fromWorld(event.world) + " at " + StringSerializer.fromBlockPos(event.entity.getPosition())).newLine();
    }

}
