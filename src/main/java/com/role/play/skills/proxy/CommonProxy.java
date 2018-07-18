package com.role.play.skills.proxy;

import com.role.play.skills.common.RecipeBookRemover;
import com.role.play.skills.utilities.ConfigHelper;
import com.role.play.skills.utilities.RecipeBookRemoverDatabase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import org.apache.logging.log4j.Level;

import java.io.File;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */

@Mod.EventBusSubscriber
public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigHelper.init(event.getSuggestedConfigurationFile());
        RecipeBookRemoverDatabase.init(new File(event.getModConfigurationDirectory(), "recipeBookRemoverDatabase.cfg"));
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    public void init(FMLInitializationEvent event)
    {
        FMLLog.log.log(Level.INFO, "init:" + event.toString());
    }

    @SubscribeEvent
    public static void onWorldLoad(WorldEvent.Load event)
    {
        try {
            if (!ConfigHelper.get().isRecipeRemoverActive()) {
                return;
            }
        } catch (Exception e) {
            FMLLog.log.log(Level.INFO, "Error on Loading World {} ({})", e.getMessage());
            return;
        }
        
        World world = event.getWorld();
        GameRules gRules = world.getGameRules();

        for (String rule: gRules.getRules()) {
            if (rule.equals("doLimitedCrafting")) {
                if (!gRules.getBoolean(rule)) {
                    gRules.addGameRule("doLimitedCrafting", "true", GameRules.ValueType.BOOLEAN_VALUE);
                    FMLLog.log.log(Level.INFO, "change GameRule {} to {}", rule, gRules.getBoolean(rule));
                }
                break;
            }
        }

        RecipeBookRemover.getInstance().removeSmeltingRecipes();
    }
    
    @SubscribeEvent
    public void onPlayerLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event)
    {
        RecipeBookRemover recipeBookRemover = RecipeBookRemover.getInstance();
        recipeBookRemover.forPlayer((EntityPlayerMP)event.player);
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void itemSmelted(PlayerEvent.ItemSmeltedEvent event)
    {
        // TODO
        FMLLog.log.log(Level.INFO, "itemSmelted: " + event.smelting.getUnlocalizedName());
        //event.setCanceled(true);
        //event.player.addStat(new StatBase(), 1);
    }
    
    @SubscribeEvent
    public void blockBreak(BlockEvent.BreakEvent event)
    {
        // TODO
        if (event.getPlayer() != null && !event.getPlayer().isCreative()
                && event.getState().getBlock() == Blocks.WEB)
        {
            //event.setCanceled(true);

            // send message to player
            EntityPlayer p = event.getPlayer();
            p.sendMessage(new TextComponentString("That is not allowed"));
        }
    }
}
