package com.role.play.skills.common.modules.books;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class ItemBookCook extends ItemBookAbstract
{
    public ItemBookCook()
    {
        super("book_cook");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        // TODO add recipes
        FMLLog.log.log(Level.INFO, "use book cook item");
        
        return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
}