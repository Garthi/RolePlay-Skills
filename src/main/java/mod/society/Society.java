package mod.society;

import mod.society.commands.RecipesResetCommand;
import mod.society.proxy.CommonProxy;
import net.minecraft.command.CommandBase;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(
        modid = Society.ID,
        name = Society.NAME,
        version = Society.VERSION
)
public class Society
{
    public static final String ID = "society";
    public static final String NAME = "The Society Mod";
    public static final String VERSION = "0.1";

    /** Commands **/
    private static CommandBase RECIPES_RESET_COMMAND = new RecipesResetCommand();

    @SidedProxy(
            clientSide = "mod.society.proxy.ClientProxy",
            serverSide = "mod.society.proxy.CommonProxy"
    )
    public static CommonProxy proxy;

    @Mod.Instance
    public static Society instance;
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }
    
    @Mod.EventHandler
    public void registerCommands(FMLServerStartingEvent event)
    {
        event.registerServerCommand(RECIPES_RESET_COMMAND);
    }
}
