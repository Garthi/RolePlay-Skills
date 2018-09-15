package mod.society.common;

import mod.society.Society;
import mod.society.common.modules.ForestryItems;
import mod.society.common.modules.AbstractItem;
import mod.society.common.modules.ModItems;
import mod.society.utilities.ConfigBookDatabase;
import mod.society.utilities.ConfigHelper;
import mod.society.utilities.NotLoadedException;
import mod.society.utilities.ConfigRecipeRemoverDatabase;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.GameType;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class RecipeBook
{
    private static final RecipeBook instance = new RecipeBook();
    
    public static RecipeBook getInstance()
    {
        return instance;
    }
    
    private RecipeBook()
    {}
    
    public void forPlayer(EntityPlayerMP player)
    {
        if (!this.isActive() || this.hasRemoveFrom(player)) {
            return;
        }
        
        this.changeGameMode(player);
        
        this.addAllRecipeAdvancements(player);
        this.removeCraftingRecipes(player);

        this.addRemoveNote(player);
    }
    
    public void removeCraftingRecipes(EntityPlayerMP player)
    {
        if (!this.isActive()) {
            return;
        }

        List<IRecipe> removeRecipes = new ArrayList<>();
        
        for (IRecipe irecipe : ForgeRegistries.RECIPES) {
            if (!this.isRecipeAllow(irecipe)) {
                removeRecipes.add(irecipe);
            }
        }

        // remove all not needed recipes
        player.getRecipeBook().remove(removeRecipes, player);
    }
    
    public boolean addRecipesFromBook(EntityPlayerMP entityPlayerMP, AbstractItem book)
    {
        String[] bookRecipes;
        try {
            bookRecipes = ConfigBookDatabase.get().getBookRecipes(book.toString());
        } catch (NotLoadedException e) {
            e.printStackTrace();
            return false;
        }

        List<String> recipes = Arrays.asList(bookRecipes);
        List<IRecipe> newRecipes = new ArrayList<>();

        for (IRecipe irecipe : ForgeRegistries.RECIPES) {
            assert irecipe.getRegistryName() != null;
            if (recipes.contains(irecipe.getRegistryName().toString())) {
                newRecipes.add(irecipe);
            }
        }

        if (newRecipes.isEmpty()) {
            return false;
        }

        // add the new recipes to the players RecipeBook
        entityPlayerMP.getRecipeBook().add(newRecipes, entityPlayerMP);
        
        return true;
    }
    
    public void addAllCustomRecipes()
    {
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "clean_stone"),
                null,
                new ItemStack(Blocks.STONE),
                Ingredient.fromItem(ModItems.SLAG_STONE)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "charcoal"),
                null,
                new ItemStack(Items.COAL, 4, 1),
                Ingredient.fromItem(ModItems.RAW_CHARCOAL)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "gold_ingot"),
                null,
                new ItemStack(Items.GOLD_INGOT),
                Ingredient.fromItem(ModItems.SLAG_GOLD_INGOT)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "iron_ingot"),
                null,
                new ItemStack(Items.IRON_INGOT),
                Ingredient.fromItem(ModItems.SLAG_IRON_INGOT)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "netherbrick"),
                null,
                new ItemStack(Items.NETHERBRICK),
                Ingredient.fromItem(ModItems.SLAG_NETHERBRICK)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "stonebrick_cracked"),
                null,
                new ItemStack(Blocks.STONEBRICK, 1, 2),
                Ingredient.fromItem(ModItems.SLAG_STONEBRICK_CRACKED)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glass_ball"),
                null,
                new ItemStack(Items.GLASS_BOTTLE),
                Ingredient.fromItem(ModItems.GLASS_BALL)
        );
        GameRegistry.addShapedRecipe(
                new ResourceLocation(Society.ID, "glass_pane"),
                null,
                new ItemStack(Blocks.GLASS_PANE),
                "##",
                "##",
                '#',
                new ItemStack(ModItems.GLASS_BALL)
        );
        GameRegistry.addShapedRecipe(
                new ResourceLocation(Society.ID, "glass"),
                null,
                new ItemStack(Blocks.GLASS),
                "##",
                "##",
                '#',
                new ItemStack(Blocks.GLASS_PANE)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "hardened_clay"),
                null,
                new ItemStack(Blocks.HARDENED_CLAY),
                Ingredient.fromItem(ModItems.SLAG_HARDENED_CLAY)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glazed_terracotta_black"),
                null,
                new ItemStack(Blocks.BLACK_GLAZED_TERRACOTTA),
                Ingredient.fromItem(ModItems.SLAG_GLAZED_TERRACOTTA_BLACK)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glazed_terracotta_blue"),
                null,
                new ItemStack(Blocks.BLUE_GLAZED_TERRACOTTA),
                Ingredient.fromItem(ModItems.SLAG_GLAZED_TERRACOTTA_BLUE)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glazed_terracotta_brown"),
                null,
                new ItemStack(Blocks.BROWN_GLAZED_TERRACOTTA),
                Ingredient.fromItem(ModItems.SLAG_GLAZED_TERRACOTTA_BROWN)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glazed_terracotta_cyan"),
                null,
                new ItemStack(Blocks.CYAN_GLAZED_TERRACOTTA),
                Ingredient.fromItem(ModItems.SLAG_GLAZED_TERRACOTTA_CYAN)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glazed_terracotta_gray"),
                null,
                new ItemStack(Blocks.GRAY_GLAZED_TERRACOTTA),
                Ingredient.fromItem(ModItems.SLAG_GLAZED_TERRACOTTA_GRAY)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glazed_terracotta_green"),
                null,
                new ItemStack(Blocks.GREEN_GLAZED_TERRACOTTA),
                Ingredient.fromItem(ModItems.SLAG_GLAZED_TERRACOTTA_GREEN)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glazed_terracotta_light_blue"),
                null,
                new ItemStack(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA),
                Ingredient.fromItem(ModItems.SLAG_GLAZED_TERRACOTTA_LIGHT_BLUE)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glazed_terracotta_lime"),
                null,
                new ItemStack(Blocks.LIME_GLAZED_TERRACOTTA),
                Ingredient.fromItem(ModItems.SLAG_GLAZED_TERRACOTTA_LIME)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glazed_terracotta_magenta"),
                null,
                new ItemStack(Blocks.MAGENTA_GLAZED_TERRACOTTA),
                Ingredient.fromItem(ModItems.SLAG_GLAZED_TERRACOTTA_MAGENTA)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glazed_terracotta_orange"),
                null,
                new ItemStack(Blocks.ORANGE_GLAZED_TERRACOTTA),
                Ingredient.fromItem(ModItems.SLAG_GLAZED_TERRACOTTA_ORANGE)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glazed_terracotta_pink"),
                null,
                new ItemStack(Blocks.PINK_GLAZED_TERRACOTTA),
                Ingredient.fromItem(ModItems.SLAG_GLAZED_TERRACOTTA_PINK)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glazed_terracotta_purple"),
                null,
                new ItemStack(Blocks.PURPLE_GLAZED_TERRACOTTA),
                Ingredient.fromItem(ModItems.SLAG_GLAZED_TERRACOTTA_PURPLE)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glazed_terracotta_red"),
                null,
                new ItemStack(Blocks.RED_GLAZED_TERRACOTTA),
                Ingredient.fromItem(ModItems.SLAG_GLAZED_TERRACOTTA_RED)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glazed_terracotta_silver"),
                null,
                new ItemStack(Blocks.SILVER_GLAZED_TERRACOTTA),
                Ingredient.fromItem(ModItems.SLAG_GLAZED_TERRACOTTA_SILVER)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glazed_terracotta_white"),
                null,
                new ItemStack(Blocks.WHITE_GLAZED_TERRACOTTA),
                Ingredient.fromItem(ModItems.SLAG_GLAZED_TERRACOTTA_WHITE)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(Society.ID, "glazed_terracotta_yellow"),
                null,
                new ItemStack(Blocks.YELLOW_GLAZED_TERRACOTTA),
                Ingredient.fromItem(ModItems.SLAG_GLAZED_TERRACOTTA_YELLOW)
        );

        if (Loader.isModLoaded("forestry")) {
            GameRegistry.addShapelessRecipe(
                    new ResourceLocation(Society.ID, "tin_ingot"),
                    null,
                    new ItemStack(ForestryItems.forestryTinIngot()),
                    Ingredient.fromItem(ModItems.SLAG_TIN_INGOT)
            );
            GameRegistry.addShapelessRecipe(
                    new ResourceLocation(Society.ID, "copper_ingot"),
                    null,
                    new ItemStack(ForestryItems.forestryCopperIngot()),
                    Ingredient.fromItem(ModItems.SLAG_COPPER_INGOT)
            );
        }
    }
    
    private void addAllRecipeAdvancements(EntityPlayerMP player)
    {
        for (IRecipe irecipe : ForgeRegistries.RECIPES) {
            CriteriaTriggers.RECIPE_UNLOCKED.trigger(player, irecipe);
        }
    }
    
    private boolean isRecipeAllow(IRecipe irecipe)
    {
        try {
            return ConfigHelper.get().isItDefaultRecipe(irecipe);
        } catch (NotLoadedException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    private boolean hasRemoveFrom(EntityPlayerMP player)
    {
        try {
            Property entity = ConfigRecipeRemoverDatabase.player(player.getName()).get();
            if (entity != null) {
                return entity.getBoolean(false);
            }
        } catch (NotLoadedException exception) {
            FMLLog.log.log(Level.ERROR, exception.getMessage());
        }
        
        return false;
    }

    private boolean addRemoveNote(EntityPlayerMP player)
    {
        try {
            ConfigRecipeRemoverDatabase.player(player.getName()).add();
        } catch (NotLoadedException exception) {
            FMLLog.log.log(Level.ERROR, exception.getMessage());
        }
        
        return false;
    }
    
    private boolean isActive()
    {
        try {
            return ConfigHelper.get().isRecipeRemoverActive();
        } catch (NotLoadedException exception) {
            FMLLog.log.log(Level.ERROR, exception.getMessage());
            return false;
        }
    }
    
    private void changeGameMode(EntityPlayerMP player)
    {
        if (player.isCreative() || player.isSpectator()) {
            player.setGameType(GameType.SURVIVAL);
        }
    }
}
