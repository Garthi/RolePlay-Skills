package com.role.play.skills.common;

import com.role.play.skills.common.modules.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

import java.util.Iterator;
import java.util.Map;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class FurnaceRecipes
{
    private static final FurnaceRecipes instance = new FurnaceRecipes();

    public static FurnaceRecipes getInstance()
    {
        return instance;
    }
    
    private FurnaceRecipes()
    {}

    public void removeAllRecipes()
    {
        ItemStack recipeResult;
        Map<ItemStack,ItemStack> recipes = net.minecraft.item.crafting.FurnaceRecipes.instance().getSmeltingList();
        Iterator<ItemStack> iterator = recipes.keySet().iterator();
        while(iterator.hasNext()) {
            ItemStack tmpRecipe = iterator.next();
            recipeResult = recipes.get(tmpRecipe);
            FMLLog.log.log(
                    Level.INFO,
                    "FurnaceRecipes: " + tmpRecipe.getUnlocalizedName() + " -> " + recipeResult.getUnlocalizedName()
            );
            iterator.remove();
        }
    }
    
    public void addCustomRecipes()
    {
        net.minecraft.item.crafting.FurnaceRecipes furnaceRecipes;
        furnaceRecipes = net.minecraft.item.crafting.FurnaceRecipes.instance();
        
        // original recipes
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.SPONGE, 1, 1),
                new ItemStack(Blocks.SPONGE, 1, 0),
                0.15F
        );

        // custom recipes
        furnaceRecipes.addSmeltingRecipeForBlock(
                Blocks.COBBLESTONE,
                new ItemStack(ModItems.BURNED_STONE),
                0.1F
        );
    }
}
