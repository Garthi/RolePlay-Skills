package mod.society.proxy;

import mod.society.common.RecipeBook;
import mod.society.common.modules.ModItems;
import mod.society.utilities.books.*;
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
        
        object = event.getModelRegistry().getObject(BookModelLumberjack.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelLumberjack customModel = new BookModelLumberjack(existingModel);
            event.getModelRegistry().putObject(BookModelLumberjack.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelBlacksmith.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelBlacksmith customModel = new BookModelBlacksmith(existingModel);
            event.getModelRegistry().putObject(BookModelBlacksmith.modelResourceLocation, customModel);
        }
        
        object = event.getModelRegistry().getObject(BookModelLibrarian.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelLibrarian customModel = new BookModelLibrarian(existingModel);
            event.getModelRegistry().putObject(BookModelLibrarian.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelAnimalBreeder.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelAnimalBreeder customModel = new BookModelAnimalBreeder(existingModel);
            event.getModelRegistry().putObject(BookModelAnimalBreeder.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelBaker.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelBaker customModel = new BookModelBaker(existingModel);
            event.getModelRegistry().putObject(BookModelBaker.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelButcher.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelButcher customModel = new BookModelButcher(existingModel);
            event.getModelRegistry().putObject(BookModelButcher.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelConfectioner.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelConfectioner customModel = new BookModelConfectioner(existingModel);
            event.getModelRegistry().putObject(BookModelConfectioner.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelCook.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelCook customModel = new BookModelCook(existingModel);
            event.getModelRegistry().putObject(BookModelCook.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelFishCook.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelFishCook customModel = new BookModelFishCook(existingModel);
            event.getModelRegistry().putObject(BookModelFishCook.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelFisher.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelFisher customModel = new BookModelFisher(existingModel);
            event.getModelRegistry().putObject(BookModelFisher.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelFarmer.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelFarmer customModel = new BookModelFarmer(existingModel);
            event.getModelRegistry().putObject(BookModelFarmer.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelPlantBreeder.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelPlantBreeder customModel = new BookModelPlantBreeder(existingModel);
            event.getModelRegistry().putObject(BookModelPlantBreeder.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelTreeRefiner.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelTreeRefiner customModel = new BookModelTreeRefiner(existingModel);
            event.getModelRegistry().putObject(BookModelTreeRefiner.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelAlchemist.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelAlchemist customModel = new BookModelAlchemist(existingModel);
            event.getModelRegistry().putObject(BookModelAlchemist.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelBarkeeper.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelBarkeeper customModel = new BookModelBarkeeper(existingModel);
            event.getModelRegistry().putObject(BookModelBarkeeper.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelBurner.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelBurner customModel = new BookModelBurner(existingModel);
            event.getModelRegistry().putObject(BookModelBurner.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelCarpenter.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelCarpenter customModel = new BookModelCarpenter(existingModel);
            event.getModelRegistry().putObject(BookModelCarpenter.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelDigger.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelDigger customModel = new BookModelDigger(existingModel);
            event.getModelRegistry().putObject(BookModelDigger.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelGlazier.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelGlazier customModel = new BookModelGlazier(existingModel);
            event.getModelRegistry().putObject(BookModelGlazier.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelHealer.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelHealer customModel = new BookModelHealer(existingModel);
            event.getModelRegistry().putObject(BookModelHealer.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelIceCreamMaker.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelIceCreamMaker customModel = new BookModelIceCreamMaker(existingModel);
            event.getModelRegistry().putObject(BookModelIceCreamMaker.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelStonemason.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelStonemason customModel = new BookModelStonemason(existingModel);
            event.getModelRegistry().putObject(BookModelStonemason.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelTailor.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelTailor customModel = new BookModelTailor(existingModel);
            event.getModelRegistry().putObject(BookModelTailor.modelResourceLocation, customModel);
        }

        object = event.getModelRegistry().getObject(BookModelToolmaker.modelResourceLocation);
        if (object instanceof IBakedModel) {
            IBakedModel existingModel = (IBakedModel) object;

            BookModelToolmaker customModel = new BookModelToolmaker(existingModel);
            event.getModelRegistry().putObject(BookModelToolmaker.modelResourceLocation, customModel);
        }
    }
}
