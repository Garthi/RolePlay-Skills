package com.role.play.skills.proxy;

import com.role.play.skills.common.RecipeBook;
import com.role.play.skills.common.modules.ModItems;
import com.role.play.skills.utilities.BookModelForgetting;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Level;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
    @SideOnly(Side.CLIENT)
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

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onModelBakeEvent(ModelBakeEvent event)
    {
        Object object = event.getModelRegistry().getObject(BookModelForgetting.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;
            
            BookModelForgetting customModel = new BookModelForgetting(existingModel);
            event.getModelRegistry().putObject(BookModelForgetting.modelResourceLocation, customModel);
        }
    }
}
