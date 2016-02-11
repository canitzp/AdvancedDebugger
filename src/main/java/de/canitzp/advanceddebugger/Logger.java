package de.canitzp.advanceddebugger;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import javax.annotation.Nonnull;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author canitzp
 */
public class Logger {

    private List<String> toSave = new ArrayList<String>();
    private String name;
    private StringBuilder info = new StringBuilder();

    public Logger(@Nonnull String name){
        this.name = name;
    }

    public void saveToFile(){
        File fileLatest = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + File.separator + "logs" + File.separator + "latest_AdvancedDebuggerLog.log");
        File file1 = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + File.separator + "logs" + File.separator + "Old_1_AdvancedDebuggerLog.log");
        File file2 = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + File.separator + "logs" + File.separator + "Old_2_AdvancedDebuggerLog.log");
        File file3 = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath() + File.separator + "logs" + File.separator + "Old_3_AdvancedDebuggerLog.log");
        if(AdvancedDebugger.isGameRestarted){
            if(fileLatest.exists()){
                if(file1.exists()){
                    if(file2.exists()){
                        if(file3.exists()){
                            file3.delete();
                            file2.renameTo(file3);
                            file1.renameTo(file2);
                            fileLatest.renameTo(file1);
                        } else {
                            file2.renameTo(file3);
                            file1.renameTo(file2);
                            fileLatest.renameTo(file1);
                        }
                    } else {
                        file1.renameTo(file2);
                        fileLatest.renameTo(file1);
                    }
                } else {
                    fileLatest.renameTo(file1);
                }
            }
            try {
                fileLatest.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AdvancedDebugger.isGameRestarted = false;
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileLatest, true));
            for(String s : toSave){
                writer.write(s);
                writer.newLine();
            }
            writer.close();
            this.toSave.clear();
            this.info = new StringBuilder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Logger newLine(){
        this.toSave.add("[00:00:00] [" + this.name + "]: " + this.info.toString());
        this.saveToFile();
        return this;
    }

    public Logger info(@Nonnull String info){
        this.info.append(info);
        return this;
    }

    public Logger infoChat(@Nonnull String info, EntityPlayer player){
        this.info(info);
        player.addChatComponentMessage(new ChatComponentText(info));
        return this;
    }


}
