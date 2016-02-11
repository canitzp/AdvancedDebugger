package de.canitzp.advanceddebugger;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 * @author canitzp
 */
public class StringSerializer {

    public static String fromBlockPos(BlockPos pos){
        return "x:" + pos.getX() + " y:" + pos.getY() + " z:" + pos.getZ();
    }

    public static String fromPlayer(EntityPlayer player){
        return player.getName() + "(" + player.getUniqueID() + ")";
    }

    public static String fromBlock(Block block){
        return block.getLocalizedName() + "(" + block.getUnlocalizedName() + ")";
    }

    public static String fromBlock(IBlockState state){
        return fromBlock(state.getBlock());
    }

    public static String fromWorld(World world){
        return world.provider.getDimensionName() + "(" + world.provider.getDimensionId() + ")";
    }

    public static String fromEntity(Entity entity){
        return entity.getName();
    }

    public static String fromGenericEntity(Entity entity){
        if (entity instanceof EntityPlayer) {
            return fromPlayer((EntityPlayer) entity);
        } else {
            return fromEntity(entity);
        }
    }

}
