package de.canitzp.advanceddebugger;

import de.canitzp.advanceddebugger.events.EventHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;

import java.util.Properties;

/**
 * @author canitzp
 */
@Mod(modid = AdvancedDebugger.MODID, name = AdvancedDebugger.MODNAME, version = AdvancedDebugger.MODVERSION)
public class AdvancedDebugger {

    public static final String MODID = "advanceddebugger";
    public static final String MODNAME = "AdvancedDebugger";
    public static final String MODVERSION = "@VERSION";
    public static final Logger logger = new Logger(MODNAME);
    public static boolean isGameRestarted = false;
    public static Properties properties = new Properties();
    public static org.apache.logging.log4j.Logger log = LogManager.getLogger(MODNAME);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        isGameRestarted = true;
        Configuration.readProp();
        Configuration.saveProp();
        logger.info("Started logging.");
        logger.newLine();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        EventHandler.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
    }

}
