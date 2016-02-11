package de.canitzp.advanceddebugger;

import net.minecraft.client.Minecraft;

import java.io.*;

/**
 * @author canitzp
 */
public class Configuration {

    public static void readProp(){
        try {
            AdvancedDebugger.properties.load(new FileInputStream(new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + File.separator + "config" + File.separator + "AdvancedDebugger.properties")));
        } catch (IOException e) {
            AdvancedDebugger.log.info("Can't find Properties! Creating new one.");
        }
        init();
    }

    public static void init(){
        addConfig("Log_Item_Entities", "false");
        addConfig("Log_EntityLiving", "true");
        addConfig("Log_EntityPlayer", "true");
    }

    public static void saveProp(){
        File f = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + File.separator + "config" + File.separator + "AdvancedDebugger.properties");
        try {
            AdvancedDebugger.properties.store(new BufferedWriter(new FileWriter(f)), "These are the properties of AdvancedDebugger. Feel free to change everything. If you change something you have to restart the game!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addConfig(String key, String defaultValue){
        if(AdvancedDebugger.properties.getProperty(key) == null){
            AdvancedDebugger.properties.setProperty(key, defaultValue);
        }
    }

    public static boolean getBoolFromProp(String value) {
        return AdvancedDebugger.properties.getProperty(value) != null && AdvancedDebugger.properties.getProperty(value).equals("true");
    }

}
