package mod.society.proxy;

import mod.society.Society;
import mod.society.common.FurnaceRecipes;
import mod.society.common.RecipeBook;
import mod.society.common.modules.AbstractItem;
import mod.society.common.modules.ModItems;
import mod.society.utilities.ConfigBookDatabase;
import mod.society.utilities.ConfigHelper;
import mod.society.utilities.ConfigRecipeRemoverDatabase;
import mod.society.utilities.NotLoadedException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
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
                new File(event.getModConfigurationDirectory() + "/society", Society.ID + ".cfg")
        );

        ConfigBookDatabase.init(
                new File(event.getModConfigurationDirectory() + "/society", "book_configuration.cfg")
        );

        ModItems.init();
        
        ConfigRecipeRemoverDatabase.init(
                new File(event.getModConfigurationDirectory() + "/society", "recipe_book_remover_database.cfg")
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
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        EntityPlayerMP entityPlayerMP;
        try {
            entityPlayerMP = (EntityPlayerMP) event.getEntityPlayer();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        
        // if the item in the main hand a society book
        Item currentItem = entityPlayerMP.getHeldItemMainhand().getItem();
        if (currentItem.getUnlocalizedName().startsWith("item.society.book_")
                && !currentItem.getUnlocalizedName().equals("item.society.book_forgetting"))
        {
            if (RecipeBook.getInstance().addRecipesFromBook(entityPlayerMP, (AbstractItem)currentItem)) {
                // remove book from main hand
                entityPlayerMP.inventory.getCurrentItem().setCount(0);
                event.setCanceled(true);
            }
        } else if (currentItem.getUnlocalizedName().equals("item.society.book_forgetting")) {
            RecipeBook recipeBook = RecipeBook.getInstance();
            recipeBook.removeCraftingRecipes(entityPlayerMP);

            // remove book from main hand
            entityPlayerMP.inventory.getCurrentItem().setCount(0);

            try {
                ConfigBookDatabase.get().removeBookUsage(entityPlayerMP.getName());
                event.setCanceled(true);
            } catch (NotLoadedException e) {
                e.printStackTrace();
            }
        }
    }
    
    @SubscribeEvent
    public void onChatEvent(ServerChatEvent event)
    {
        try {
            if (ConfigHelper.get().isChatDisabled()) {
                event.setCanceled(true);
            }
        } catch (NotLoadedException e) {
            e.printStackTrace();
        }
    }

    @SubscribeEvent
    public void onCommandEvent(CommandEvent event)
    {
        try {
            if (ConfigHelper.get().isChatDisabled()) {
                if (event.getCommand().getName().equals("me")
                        || event.getCommand().getName().equals("tell"))
                {
                    event.setCanceled(true);
                }
            }
        } catch (NotLoadedException e) {
            e.printStackTrace();
        }
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
