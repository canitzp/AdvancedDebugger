package de.canitzp.advanceddebugger.events;

import de.canitzp.advanceddebugger.AdvancedDebugger;
import de.canitzp.advanceddebugger.StringSerializer;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.NoteBlockEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


/**
 * @author canitzp
 */
public class BlockEvents {

    private FMLInitializationEvent event;

    public BlockEvents(FMLInitializationEvent event) {
        this.event = event;
    }

    @SubscribeEvent
    public void onBlockPlaced(BlockEvent.PlaceEvent event){
        AdvancedDebugger.logger.info(StringSerializer.fromPlayer(event.player) + " placed " + StringSerializer.fromBlock(event.placedBlock) + " in " + StringSerializer.fromWorld(event.world) + " at " + StringSerializer.fromBlockPos(event.pos));
        AdvancedDebugger.logger.newLine();
    }

    @SubscribeEvent
    public void onBlockDestroyed(BlockEvent.BreakEvent event){
        AdvancedDebugger.logger.info(StringSerializer.fromPlayer(event.getPlayer()) + " destroyed " + StringSerializer.fromBlock(event.state) + " in " + StringSerializer.fromWorld(event.world) + " at " + StringSerializer.fromBlockPos(event.pos));
        AdvancedDebugger.logger.newLine();
    }

    @SubscribeEvent
    public void onNoteBlockPlay(NoteBlockEvent.Play event){
        AdvancedDebugger.logger.info("A Noteblock in " + StringSerializer.fromWorld(event.world) + " at " + StringSerializer.fromBlockPos(event.pos) + " with Instrument:" + event.instrument + " play Note:" + event.getNote() + " in Octave:" + event.getOctave());
        AdvancedDebugger.logger.newLine();
    }

}
