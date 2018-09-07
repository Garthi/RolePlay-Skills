package com.role.play.skills.common.modules.books;

import com.role.play.skills.common.RecipeBook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class ItemBookForgetting extends ItemBookAbstract
{
    public ItemBookForgetting()
    {
        super("book_forgetting");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        try {
            RecipeBook recipeBook = RecipeBook.getInstance();
            recipeBook.removeCraftingRecipes((EntityPlayerMP) playerIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
}
