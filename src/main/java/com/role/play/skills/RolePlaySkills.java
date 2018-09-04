package com.role.play.skills;

import com.role.play.skills.commands.RecipesResetCommand;
import com.role.play.skills.proxy.CommonProxy;
import net.minecraft.command.CommandBase;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(
        modid = RolePlaySkills.ID,
        name = RolePlaySkills.NAME,
        version = RolePlaySkills.VERSION
)
public class RolePlaySkills
{
    public static final String ID = "roleplayskills";
    public static final String NAME = "RolePlay-Skills";
    public static final String VERSION = "0.1";

    /** Commands **/
    private static CommandBase RECIPES_RESET_COMMAND = new RecipesResetCommand();

    @SidedProxy(
            clientSide = "com.role.play.skills.proxy.ClientProxy",
            serverSide = "com.role.play.skills.proxy.CommonProxy"
    )
    public static CommonProxy proxy;

    @Mod.Instance
    public static RolePlaySkills instance;
    
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
