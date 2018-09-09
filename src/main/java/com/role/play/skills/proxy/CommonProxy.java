package com.role.play.skills.proxy;

import com.role.play.skills.RolePlaySkills;
import com.role.play.skills.common.FurnaceRecipes;
import com.role.play.skills.common.RecipeBook;
import com.role.play.skills.common.modules.ModItems;
import com.role.play.skills.utilities.ConfigHelper;
import com.role.play.skills.utilities.RecipeBookRemoverDatabase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
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
        ConfigHelper.init(
                new File(event.getModConfigurationDirectory() + "/society", RolePlaySkills.ID + ".cfg")
        );

        ModItems.init();
        
        RecipeBookRemoverDatabase.init(
                new File(event.getModConfigurationDirectory() + "/society", "recipeBookRemoverDatabase.cfg")
        );
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    public void init(FMLInitializationEvent event)
    {}

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
            if (rule.equals("doLimitedCrafting") && !gRules.getBoolean(rule)) {
                gRules.addGameRule("doLimitedCrafting", "true", GameRules.ValueType.BOOLEAN_VALUE);
                FMLLog.log.log(Level.INFO, "change GameRule {} to {}", rule, gRules.getBoolean(rule));
            } else if (rule.equals("announceAdvancements") && gRules.getBoolean(rule)) {
                gRules.addGameRule("announceAdvancements", "false", GameRules.ValueType.BOOLEAN_VALUE);
                FMLLog.log.log(Level.INFO, "change GameRule {} to {}", rule, gRules.getBoolean(rule));
            }
        }

        // remove all furnace recipes
        FurnaceRecipes furnaceRecipes = FurnaceRecipes.getInstance();
        furnaceRecipes.removeAllRecipes();
        
        // add the new furnace recipes
        furnaceRecipes.addCustomRecipes();
    }
    
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
    {
        this.removeRecipes((EntityPlayerMP)event.player);
    }
    
    @SubscribeEvent
    public void blockBreak(BlockEvent.BreakEvent event)
    {
        // TODO
        if (event.getPlayer() != null && !event.getPlayer().isCreative()
                && event.getState().getBlock() == Blocks.WEB)
        {
            // event.setCanceled(true);

            // TODO add a advancement system for skills
            // send message to player
            // EntityPlayer p = event.getPlayer();
            // p.sendMessage(new TextComponentString("That is not allowed"));
        }
    }

    @SubscribeEvent
    public void initRecipes(RegistryEvent.Register<IRecipe> event)
    {
        RecipeBook recipeBook = RecipeBook.getInstance();
        recipeBook.addAllCustomRecipes();
    }
    
    private void removeRecipes(EntityPlayerMP playerMP)
    {
        RecipeBook recipeBook = RecipeBook.getInstance();
        recipeBook.forPlayer(playerMP);
    }
}
