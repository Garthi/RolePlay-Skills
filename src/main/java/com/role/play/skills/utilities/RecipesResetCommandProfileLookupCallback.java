package com.role.play.skills.utilities;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.ProfileLookupCallback;
import com.role.play.skills.common.RecipeBookRemover;
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
                RecipeBookRemover recipeBookRemover = RecipeBookRemover.getInstance();
                recipeBookRemover.removeCraftingRecipes(entityPlayerMP);
            }

            // feedback
            sender.sendMessage(
                    new TextComponentTranslation("role.play.skills.command.reset.success.message", gameProfile.getName())
            );
        } catch (Exception e) {
            FMLLog.log.catching(e);
            sender.sendMessage(
                    new TextComponentTranslation("role.play.skills.command.player.not.found", gameProfile.getName())
            );
        }
    }

    @Override
    public void onProfileLookupFailed(GameProfile gameProfile, Exception exception)
    {
        // feedback for fail
        sender.sendMessage(new TextComponentTranslation("role.play.skills.command.player.not.found", gameProfile.getName()));
    }
}
