package mod.society.common;

import mod.society.common.modules.BiomesoplentyItems;
import mod.society.common.modules.ForestryItems;
import mod.society.common.modules.ModItems;
import mod.society.common.modules.RusticItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;

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
        Map<ItemStack,ItemStack> recipes = net.minecraft.item.crafting.FurnaceRecipes.instance().getSmeltingList();
        Iterator<ItemStack> iterator = recipes.keySet().iterator();
        while(iterator.hasNext()) {
            iterator.next();
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
        furnaceRecipes.addSmelting(Items.CLAY_BALL, new ItemStack(ModItems.SLAG_CLAY_BRICK), 0.3F);
        furnaceRecipes.addSmeltingRecipeForBlock(Blocks.CACTUS, new ItemStack(ModItems.SLAG_DYE_POWDER_GREEN), 0.2F);
        furnaceRecipes.addSmelting(Items.CHORUS_FRUIT, new ItemStack(ModItems.SLAG_CHORUS_FRUIT_POPPED), 0.1F);

        // custom recipes
        furnaceRecipes.addSmeltingRecipeForBlock(
                Blocks.COBBLESTONE,
                new ItemStack(ModItems.SLAG_STONE),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipeForBlock(
                Blocks.STONEBRICK,
                new ItemStack(ModItems.SLAG_STONEBRICK_CRACKED),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipeForBlock(Blocks.NETHERRACK, new ItemStack(ModItems.SLAG_NETHERBRICK), 0.1F);
        furnaceRecipes.addSmeltingRecipeForBlock(Blocks.IRON_ORE, new ItemStack(ModItems.SLAG_IRON_INGOT), 0.7F);
        furnaceRecipes.addSmeltingRecipeForBlock(Blocks.GOLD_ORE, new ItemStack(ModItems.SLAG_GOLD_INGOT), 1.0F);
        furnaceRecipes.addSmeltingRecipeForBlock(Blocks.LOG, new ItemStack(ModItems.RAW_CHARCOAL), 0.1F);
        furnaceRecipes.addSmeltingRecipeForBlock(Blocks.LOG2, new ItemStack(ModItems.RAW_CHARCOAL), 0.1F);
        furnaceRecipes.addSmeltingRecipeForBlock(Blocks.SAND, new ItemStack(ModItems.GLASS_BALL), 0.1F);
        furnaceRecipes.addSmeltingRecipeForBlock(Blocks.CLAY, new ItemStack(ModItems.SLAG_HARDENED_CLAY), 0.35F);
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.WHITE.getMetadata()),
                new ItemStack(ModItems.SLAG_GLAZED_TERRACOTTA_WHITE),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.ORANGE.getMetadata()),
                new ItemStack(ModItems.SLAG_GLAZED_TERRACOTTA_ORANGE),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.MAGENTA.getMetadata()),
                new ItemStack(ModItems.SLAG_GLAZED_TERRACOTTA_MAGENTA),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.LIGHT_BLUE.getMetadata()),
                new ItemStack(ModItems.SLAG_GLAZED_TERRACOTTA_LIGHT_BLUE),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.YELLOW.getMetadata()),
                new ItemStack(ModItems.SLAG_GLAZED_TERRACOTTA_YELLOW),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.LIME.getMetadata()),
                new ItemStack(ModItems.SLAG_GLAZED_TERRACOTTA_LIME),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.PINK.getMetadata()),
                new ItemStack(ModItems.SLAG_GLAZED_TERRACOTTA_PINK),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.GRAY.getMetadata()),
                new ItemStack(ModItems.SLAG_GLAZED_TERRACOTTA_GRAY),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.SILVER.getMetadata()),
                new ItemStack(ModItems.SLAG_GLAZED_TERRACOTTA_SILVER),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.CYAN.getMetadata()),
                new ItemStack(ModItems.SLAG_GLAZED_TERRACOTTA_CYAN),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.PURPLE.getMetadata()),
                new ItemStack(ModItems.SLAG_GLAZED_TERRACOTTA_PURPLE),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.BLUE.getMetadata()),
                new ItemStack(ModItems.SLAG_GLAZED_TERRACOTTA_BLUE),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.BROWN.getMetadata()),
                new ItemStack(ModItems.SLAG_GLAZED_TERRACOTTA_BROWN),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.GREEN.getMetadata()),
                new ItemStack(ModItems.SLAG_GLAZED_TERRACOTTA_GREEN),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.RED.getMetadata()),
                new ItemStack(ModItems.SLAG_GLAZED_TERRACOTTA_RED),
                0.1F
        );
        furnaceRecipes.addSmeltingRecipe(
                new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, EnumDyeColor.BLACK.getMetadata()),
                new ItemStack(ModItems.SLAG_GLAZED_TERRACOTTA_BLACK),
                0.1F
        );

        if (Loader.isModLoaded("rustic")) {
            furnaceRecipes.addSmeltingRecipeForBlock(
                    RusticItems.rusticLogs(),
                    new ItemStack(ModItems.RAW_CHARCOAL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(Items.ROTTEN_FLESH),
                    new ItemStack(ModItems.SLAG_TALLOW),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(RusticItems.rusticHoneycomb()),
                    new ItemStack(ModItems.SLAG_BEESWAX),
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
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(ForestryItems.forestryOre(), 1, 2),
                    new ItemStack(ModItems.SLAG_TIN_INGOT),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(ForestryItems.forestryOre(), 1, 1),
                    new ItemStack(ModItems.SLAG_COPPER_INGOT),
                    0.1F
            );
        }
        
        if (Loader.isModLoaded("biomesoplenty")) {
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyMud(), 1, 0),
                    new ItemStack(Blocks.DIRT),
                    0.1F
            );
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
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyWhiteSand(), 1, 0),
                    new ItemStack(ModItems.GLASS_BALL),
                    0.1F
            );
            furnaceRecipes.addSmeltingRecipe(
                    new ItemStack(BiomesoplentyItems.biomesoplentyPlant1(), 1, 6),
                    new ItemStack(ModItems.SLAG_DYE_POWDER_GREEN),
                    0.1F
            );
        }
    }
}
