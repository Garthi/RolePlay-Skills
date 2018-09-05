package com.role.play.skills.common;

import com.role.play.skills.RolePlaySkills;
import com.role.play.skills.common.modules.ModItems;
import com.role.play.skills.utilities.ConfigHelper;
import com.role.play.skills.utilities.NotLoadedException;
import com.role.play.skills.utilities.RecipeBookRemoverDatabase;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.GameType;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Level;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class RecipeBook
{
    private static final RecipeBook instance = new RecipeBook();
    
    public static RecipeBook getInstance()
    {
        return instance;
    }
    
    private RecipeBook()
    {}
    
    public void forPlayer(EntityPlayerMP player)
    {
        if (!this.isActive() || this.hasRemoveFrom(player)) {
            return;
        }
        
        this.changeGameMode(player);
        
        this.addAllRecipeAdvancements(player);
        
        this.removeCraftingRecipes(player);

        this.addRemoveNote(player);

        player.connection.disconnect(new TextComponentTranslation("role.play.skills.config.reconnect"));
    }
    
    public void removeCraftingRecipes(EntityPlayerMP player)
    {
        if (!this.isActive()) {
            return;
        }
        
        net.minecraft.stats.RecipeBook book = new net.minecraft.stats.RecipeBook();
        for (IRecipe irecipe : ForgeRegistries.RECIPES) {

            book.unlock(irecipe);
            book.markSeen(irecipe);

            if (this.isRecipeAllow(irecipe)) {
                book.markNew(irecipe);
            } else {
                book.lock(irecipe);
            }
        }

        // set the new recipe book to player
        player.getRecipeBook().copyFrom(book);
    }
    
    public void addAllCustomRecipes()
    {
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(RolePlaySkills.ID, "clean_stone"),
                null,
                new ItemStack(Blocks.STONE),
                Ingredient.fromItem(ModItems.BURNED_STONE)
        );
        GameRegistry.addShapelessRecipe(
                new ResourceLocation(RolePlaySkills.ID, "charcoal"),
                null,
                new ItemStack(Items.COAL, 1, 1),
                Ingredient.fromItem(ModItems.RAW_CHARCOAL)
        );

    }
    
    private void addAllRecipeAdvancements(EntityPlayerMP player)
    {
        for (IRecipe irecipe : ForgeRegistries.RECIPES) {
            CriteriaTriggers.RECIPE_UNLOCKED.trigger(player, irecipe);
        }
    }
    
    private boolean isRecipeAllow(IRecipe irecipe)
    {
        try {
            return ConfigHelper.get().isItDefaultRecipe(irecipe);
        } catch (NotLoadedException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    private boolean hasRemoveFrom(EntityPlayerMP player)
    {
        try {
            Property entity = RecipeBookRemoverDatabase.player(player.getName()).get();
            if (entity != null) {
                return entity.getBoolean(false);
            }
        } catch (NotLoadedException exception) {
            FMLLog.log.log(Level.ERROR, exception.getMessage());
        }
        
        return false;
    }

    private boolean addRemoveNote(EntityPlayerMP player)
    {
        try {
            RecipeBookRemoverDatabase.player(player.getName()).add();
        } catch (NotLoadedException exception) {
            FMLLog.log.log(Level.ERROR, exception.getMessage());
        }
        
        return false;
    }
    
    private boolean isActive()
    {
        try {
            return ConfigHelper.get().isRecipeRemoverActive();
        } catch (NotLoadedException exception) {
            FMLLog.log.log(Level.ERROR, exception.getMessage());
            return false;
        }
    }
    
    private void changeGameMode(EntityPlayerMP player)
    {
        if (player.isCreative() || player.isSpectator()) {
            player.setGameType(GameType.SURVIVAL);
        }
    }
}