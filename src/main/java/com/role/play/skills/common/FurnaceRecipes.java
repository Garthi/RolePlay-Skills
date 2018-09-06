package com.role.play.skills.common;

import com.role.play.skills.common.modules.BiomesoplentyItems;
import com.role.play.skills.common.modules.ForestryItems;
import com.role.play.skills.common.modules.ModItems;
import com.role.play.skills.common.modules.RusticItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
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
        furnaceRecipes.addSmelting(Items.CHORUS_FRUIT, new ItemStack(Items.CHORUS_FRUIT_POPPED), 0.1F);

        // custom recipes
        furnaceRecipes.addSmeltingRecipeForBlock(
                Blocks.COBBLESTONE,
                new ItemStack(ModItems.SLAG_STONE),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipeForBlock(
                Blocks.LOG,
                new ItemStack(ModItems.RAW_CHARCOAL),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipeForBlock(
                Blocks.LOG2,
                new ItemStack(ModItems.RAW_CHARCOAL),
                0.1F
        );

        if (Loader.isModLoaded("rustic")) {
            furnaceRecipes.addSmeltingRecipeForBlock(
                    RusticItems.rusticLogs(),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
        }

        if (Loader.isModLoaded("forestry")) {
            furnaceRecipes.addSmeltingRecipeForBlock(
                    ForestryItems.forestryLog0(),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipeForBlock(
                    ForestryItems.forestryLog1(),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipeForBlock(
                    ForestryItems.forestryLog2(),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipeForBlock(
                    ForestryItems.forestryLog3(),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipeForBlock(
                    ForestryItems.forestryLog4(),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipeForBlock(
                    ForestryItems.forestryLog5(),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipeForBlock(
                    ForestryItems.forestryLog6(),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipeForBlock(
                    ForestryItems.forestryLog7(),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
        }
        
        if (Loader.isModLoaded("biomesoplenty")) {
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog0(), 1, 4),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog0(), 1, 5),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog0(), 1, 6),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog0(), 1, 7),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog1(), 1, 4),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog1(), 1, 5),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog1(), 1, 6),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog1(), 1, 7),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog2(), 1, 4),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog2(), 1, 5),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog2(), 1, 6),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog2(), 1, 7),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog3(), 1, 4),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog3(), 1, 5),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog3(), 1, 6),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog3(), 1, 7),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyLog4(), 1, 5),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
        }
    }
}
