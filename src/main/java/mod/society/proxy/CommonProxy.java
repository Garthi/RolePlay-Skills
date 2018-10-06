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
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
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
import java.util.List;
import java.util.Random;

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
        event.player.inventory.mainInventory.stream().filter(this::isBucket).forEach(this::removeLiquid);
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

    @SubscribeEvent
    public void fishingLoot(ItemFishedEvent event)
    {
        // TODO make it with config
        List<ItemStack> drops = event.getDrops();

        drops.stream().filter(drop -> !drop.getUnlocalizedName().startsWith("item.fish.")
                && !drop.getUnlocalizedName().equals("item.nameTag")
                && !drop.getUnlocalizedName().equals("item.stick")
                && !drop.getUnlocalizedName().equals("tile.waterlily")).forEach(drop -> {
            drop.setCount(0);
        });
    }
    
    @SubscribeEvent
    public void monsterLoot(LivingDropsEvent event)
    {
        // TODO make it with config
        String entityName = event.getEntityLiving().getName();
        List<EntityItem> drops = event.getDrops();

        for (EntityItem drop: drops) {

            ItemStack dropItem = drop.getItem();

            switch (entityName) {
                case "Zombie":
                case "Husk":
                case "Zombie Horse":
                case "Zombie Pigman":
                case "Zombie Villager": {
                    if (!dropItem.getUnlocalizedName().equals("item.rottenFlesh")) {
                        dropItem.setCount(0);
                    }
                    break;
                }
                case "Skeleton":
                case "Stray":
                case "Skeleton Horse": {
                    if (dropItem.getUnlocalizedName().equals("item.arrow")) {
                        Random rand = new Random();
                        dropItem.setCount((rand.nextInt(3) + 1));
                    } else if (!dropItem.getUnlocalizedName().equals("item.bone")) {
                        dropItem.setCount(0);
                    }
                    break;
                }
                case "Wither Skeleton":
                    if (!dropItem.getUnlocalizedName().equals("item.coal")
                            && !dropItem.getUnlocalizedName().equals("item.bone"))
                    {
                        dropItem.setCount(0);
                    }
                    break;
                case "Spider":
                case "Cave Spider": {
                    if (!dropItem.getUnlocalizedName().equals("item.string")
                            && !dropItem.getUnlocalizedName().equals("item.spiderEye"))
                    {
                        dropItem.setCount(0);
                    }
                    break;
                }
                case "Creeper":
                    if (dropItem.getUnlocalizedName().equals("item.sulphur")) {
                        dropItem.setCount(1);
                    } else {
                        dropItem.setCount(0);
                    }
                    break;
                case "Witch":
                    if (!dropItem.getUnlocalizedName().equals("item.stick")
                            && !dropItem.getUnlocalizedName().equals("item.glassBottle")
                            && !dropItem.getUnlocalizedName().equals("item.sugar")
                            //&& !dropItem.getUnlocalizedName().equals("item.yellowDust")
                            //&& !dropItem.getUnlocalizedName().equals("item.redstone")
                            && !dropItem.getUnlocalizedName().equals("item.potion")
                            && !dropItem.getUnlocalizedName().equals("item.sulphur")
                            && !dropItem.getUnlocalizedName().equals("item.spiderEye"))
                    {
                        dropItem.setCount(0);
                    }
                    break;
                case "Vindicator":
                    if (!dropItem.getUnlocalizedName().equals("item.emerald")) {
                        dropItem.setCount(0);
                    }
                    break;
                case "Enderman":
                    if (!dropItem.getUnlocalizedName().equals("item.enderPearl")) {
                        dropItem.setCount(0);
                    }
                    break;
            }
        }
    }

    private void removeRecipes(EntityPlayerMP playerMP)
    {
        RecipeBook recipeBook = RecipeBook.getInstance();
        recipeBook.forPlayer(playerMP);
    }
    
    // remove hot water

    @SubscribeEvent
    public void fillBucket(FillBucketEvent event)
    {
        ItemStack filledBucket = event.getFilledBucket();
        if (filledBucket != null) {
            if (isBucket(filledBucket)) {
                removeLiquid(filledBucket);
            }
        }

        ItemStack currentItem = event.getEntityPlayer().inventory.getCurrentItem();
        if (currentItem != null) {
            if (isBucket(currentItem)) {
                removeLiquid(currentItem);
            }
        }
    }

    @SubscribeEvent
    public void onEntityItemPickup(EntityItemPickupEvent event)
    {
        ItemStack item = event.getItem().getItem();
        if (isBucket(item)) {
            removeLiquid(item);
        }
    }

    private void removeLiquid(ItemStack item)
    {
        if (item.getUnlocalizedName().equals("item.ceramics.clay_bucket")) {
            item.setTagCompound(null);
            return;
        }

        item.setCount(0);
    }

    private boolean isBucket(ItemStack item)
    {
        if (item.getUnlocalizedName().equals("item.bucket")
                || item.getUnlocalizedName().equals("item.ceramics.clay_bucket")
                || item.getUnlocalizedName().equals("item.forge.bucketFilled"))
        {
            if (!item.hasTagCompound()) {
                return false;
            }

            NBTTagCompound tag;

            assert item.getTagCompound() != null;
            if (item.getTagCompound().hasKey("fluids")) {
                tag = item.getTagCompound().getCompoundTag("fluids");
            } else {
                tag = item.getTagCompound();
            }

            if (!tag.hasKey("FluidName")) {
                return false;
            }

            if (tag.getString("FluidName").equals("hot_spring_water")) {
                return true;
            }
        }

        return false;
    }
}
