package com.role.play.skills.proxy;

import com.role.play.skills.RolePlaySkills;
import com.role.play.skills.common.RecipeBook;
import com.role.play.skills.common.modules.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Level;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent e)
    {
        super.preInit(e);

        ModItems.initModels();
    }

    @Override
    public void init(FMLInitializationEvent e)
    {
        super.init(e);
    }
    
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        FMLLog.log.log(Level.INFO, "<RRS> registerModels: " + event.toString());
    }

    @SubscribeEvent
    public void initRecipes(RegistryEvent.Register<IRecipe> event)
    {
        RecipeBook recipeBook = RecipeBook.getInstance();
        recipeBook.addAllCustomRecipes();
    }
}
