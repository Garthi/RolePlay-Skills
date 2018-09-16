package mod.society.utilities;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.ProfileLookupCallback;
import mod.society.common.RecipeBook;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.FMLLog;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class RecipesResetCommandProfileLookupCallback implements ProfileLookupCallback
{
    private ICommandSender sender;
    
    public RecipesResetCommandProfileLookupCallback(ICommandSender sender)
    {
        this.sender = sender;
    }
    
    @Override
    public void onProfileLookupSucceeded(GameProfile gameProfile)
    {
        try {
            EntityPlayerMP entityPlayerMP;
            entityPlayerMP = (EntityPlayerMP)sender.getEntityWorld().getPlayerEntityByName(gameProfile.getName());
            
            if (entityPlayerMP != null) {
                RecipeBook recipeBook = RecipeBook.getInstance();
                recipeBook.removeCraftingRecipes(entityPlayerMP);
            }

            // feedback
            sender.sendMessage(
                    new TextComponentTranslation("society.command.reset.success.message", gameProfile.getName())
            );
        } catch (Exception e) {
            FMLLog.log.catching(e);
            sender.sendMessage(
                    new TextComponentTranslation("society.command.player.not.found", gameProfile.getName())
            );
        }
    }

    @Override
    public void onProfileLookupFailed(GameProfile gameProfile, Exception exception)
    {
        // feedback for fail
        sender.sendMessage(new TextComponentTranslation("society.command.player.not.found", gameProfile.getName()));
    }
}
