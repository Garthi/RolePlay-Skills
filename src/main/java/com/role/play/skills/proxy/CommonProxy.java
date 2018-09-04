package com.role.play.skills.proxy;

import com.role.play.skills.RolePlaySkills;
import com.role.play.skills.common.RecipeBookRemover;
import com.role.play.skills.common.modules.ModItems;
import com.role.play.skills.utilities.ConfigHelper;
import com.role.play.skills.utilities.RecipeBookRemoverDatabase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
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
import net.minecraftforge.fml.common.registry.GameRegistry;
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

        ModItems.init();
        
        RecipeBookRemoverDatabase.init(new File(event.getModConfigurationDirectory(), "recipeBookRemoverDatabase.cfg"));
        
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

        // remove and replace smelting recipes
        RecipeBookRemover.getInstance().removeSmeltingRecipes();
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
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(RolePlaySkills.ID, "clean_stone"),
                null,
                new ItemStack(Blocks.STONE),
                Ingredient.fromItem(ModItems.BURNED_STONE)
        );
    }
    
    private void removeRecipes(EntityPlayerMP playerMP)
    {
        RecipeBookRemover recipeBookRemover = RecipeBookRemover.getInstance();
        recipeBookRemover.forPlayer(playerMP);
    }
}
