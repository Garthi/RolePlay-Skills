package com.role.play.skills.common;

import com.role.play.skills.utilities.ConfigHelper;
import com.role.play.skills.utilities.NotLoadedException;
import com.role.play.skills.utilities.RecipeBookRemoverDatabase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.stats.RecipeBook;
import net.minecraft.world.GameType;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.apache.logging.log4j.Level;

import java.util.Iterator;
import java.util.Map;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class RecipeBookRemover
{
    private static RecipeBookRemover instance;
    
    public static RecipeBookRemover getInstance()
    {
        if (instance == null) {
            instance = new RecipeBookRemover();
        }
        
        return instance;
    }
    
    private RecipeBookRemover()
    {}
    
    public void forPlayer(EntityPlayerMP player)
    {
        if (!this.isActive()) {
            return;
        }
        
        if (this.hasRemoveFrom(player)) {
            return;
        }
        
        this.changeGameMode(player);
        
        this.removeCraftingRecipes(player);

        this.addRemoveNote(player);

        FurnaceRecipes.instance().addSmelting(Items.POTATO, new ItemStack(Items.BAKED_POTATO), 0F);
    }
    
    public void removeSmeltingRecipes()
    {
        ItemStack recipeResult;
        Map<ItemStack,ItemStack> recipes = FurnaceRecipes.instance().getSmeltingList();
        Iterator<ItemStack> iterator = recipes.keySet().iterator();
        while(iterator.hasNext()) {
            ItemStack tmpRecipe = iterator.next();
            recipeResult = recipes.get(tmpRecipe);
            FMLLog.log.log(Level.INFO, "FurnaceRecipes: " + tmpRecipe.getUnlocalizedName() + " -> " + recipeResult.getUnlocalizedName());
            iterator.remove();
        }
    }
    
    private void removeCraftingRecipes(EntityPlayerMP player)
    {
        RecipeBook book = new RecipeBook();
        for (IRecipe irecipe : ForgeRegistries.RECIPES) {

            book.unlock(irecipe);
            book.markSeen(irecipe);

            if (this.isRecipeAllow(irecipe)) {
                book.markNew(irecipe);
            } else {
                book.lock(irecipe);
            }
        }

        // set the new recipe book to player
        player.getRecipeBook().copyFrom(book);
    }
    
    private boolean isRecipeAllow(IRecipe irecipe)
    {
        // TODO add a real check
        return false;
    }
    
    private boolean hasRemoveFrom(EntityPlayerMP player)
    {
        try {
            Property entity = RecipeBookRemoverDatabase.player(player.getName()).get();
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
            RecipeBookRemoverDatabase.player(player.getName()).add();
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
