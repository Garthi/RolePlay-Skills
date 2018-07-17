package com.role.play.skills.proxy;

import com.role.play.skills.common.RecipeBookRemover;
import com.role.play.skills.utilities.ConfigHelper;
import com.role.play.skills.utilities.RecipeBookRemoverDatabase;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.Potion;
import net.minecraft.stats.StatBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
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
import java.util.List;

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
        FMLLog.log.log(Level.INFO, "<RRS> preInit:" + event.toString());
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


    @SubscribeEvent
    public static void registerPotions(RegistryEvent.Register<Potion> event)
    {
        FMLLog.log.log(Level.ERROR, "<RRS> registerPotions:" + event.getName().toString());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        FMLLog.log.log(Level.ERROR, "<RRS> registerItems:" + event.getName().toString());
    }

    @SubscribeEvent
    public static void registerEnchantments(RegistryEvent.Register<Enchantment> event)
    {
        FMLLog.log.log(Level.ERROR, "<RRS> registerEnchantments:" + event.getName().toString());
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
    {
        FMLLog.log.log(Level.INFO, "<RRS> registerRecipes:" + event.toString());
    }
    
    @SubscribeEvent
    public void harvest(BlockEvent.HarvestDropsEvent event)
    {
        String playerName;
        try {
            playerName = event.getHarvester().getDisplayName().getFormattedText();
        } catch (NullPointerException e) {
            playerName = "World";
        }
        List<ItemStack> drops = event.getDrops();

        for (ItemStack drop: drops) {
            FMLLog.log.log(Level.INFO, String.format(
                    "<RRS> harvest: %1$s have dropped %2$dx %3$s",
                    playerName,
                    drop.getCount(),
                    drop.getUnlocalizedName()
            ));
        }
        
        // set drop chance to 0 :-)
        event.setDropChance(0);
    }

    @SubscribeEvent
    public void itemCrafted(net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent event)
    {
        FMLLog.log.log(Level.INFO, "itemCrafted: " + event.crafting.getUnlocalizedName());
    }

    @SubscribeEvent
    public void onItemPickupEvent(PlayerEvent.ItemPickupEvent event)
    {
        FMLLog.log.log(Level.INFO, "onItemPickupEvent: " + event.getOriginalEntity().getItem().getUnlocalizedName());
    }
    
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void itemSmelted(net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent event)
    {
        FMLLog.log.log(Level.INFO, "itemSmelted: " + event.smelting.getUnlocalizedName());
        //event.setCanceled(true);
        //event.player.addStat(new StatBase(), 1);
    }
    
    @SubscribeEvent
    public void blockBreak(BlockEvent.BreakEvent event)
    {
        if (event.getPlayer() != null && !event.getPlayer().isCreative()
                && event.getState().getBlock() == Blocks.WEB)
        {
            event.setCanceled(true);

            // send message to player
            EntityPlayer p = event.getPlayer();
            p.sendMessage(new TextComponentString("That is not allowed"));
        }
    }
    
    /*@SubscribeEvent
    public void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
        boolean hardOption = OresBase.config.getBoolean("RequireMillingFlour", "MILLING", false, "");
        if(hardOption) {
            RecipesUtils.RemoveRecipe(modRegistry, new ResourceLocation("minecraft:bread"), "Hard Ores");
            RecipesUtils.RemoveRecipe(modRegistry, new ResourceLocation("minecraft:cookie"), "Hard Ores");
            RecipesUtils.RemoveRecipe(modRegistry, new ResourceLocation("minecraft:cake"), "Hard Ores");
        }
        boolean stoneTools = OresBase.config.getBoolean("useDioriteStoneTools", "GENERAL", true, "If true, cobblestone cannot be used to create stone tools,\ninstead diorite is used. This prolongs the life of wood tools so it isn't \"make a wood pickaxe to\nmine 3 stone and upgrade.\"");
        if(stoneTools) {
            RecipesUtils.RemoveRecipe(modRegistry, new ResourceLocation("minecraft:stone_axe"), "Harder Ores");
            RecipesUtils.RemoveRecipe(modRegistry, new ResourceLocation("minecraft:stone_pickaxe"), "Harder Ores");
            RecipesUtils.RemoveRecipe(modRegistry, new ResourceLocation("minecraft:stone_shovel"), "Harder Ores");
            RecipesUtils.RemoveRecipe(modRegistry, new ResourceLocation("minecraft:stone_hoe"), "Harder Ores");
        }
    }*/
}
