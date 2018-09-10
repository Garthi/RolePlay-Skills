package mod.society.commands;

import com.mojang.authlib.Agent;
import mod.society.utilities.RecipesResetCommandProfileLookupCallback;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.FMLLog;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class RecipesResetCommand extends CommandBase
{
    private static final String COMMAND_NAME = "recipesreset";

    @Override
    public String getName()
    {
        return COMMAND_NAME;
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return String.format("/%s <player>", COMMAND_NAME);
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if (args == null || args.length < 1) {
            sender.sendMessage(
                    new TextComponentTranslation("society.command.reset.help", COMMAND_NAME)
            );
            return;
        }
        
        if (sender instanceof EntityPlayer) {

            try {
                RecipesResetCommandProfileLookupCallback callback;
                callback = new RecipesResetCommandProfileLookupCallback(sender);
                
                String[] players = new String[]{args[0]};

                assert server.getServer() != null;
                server.getServer().getGameProfileRepository().findProfilesByNames(
                        players, Agent.MINECRAFT, callback
                );
            } catch (NullPointerException e) {
                FMLLog.log.catching(e);
            }
        } else {
            sender.sendMessage(new TextComponentString(
                    EntityPlayer.EnumChatVisibility.SYSTEM + "This command is not available inside the console."
            ));
        }
    }
}