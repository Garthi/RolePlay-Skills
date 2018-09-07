package com.role.play.skills.utilities.books;

import com.role.play.skills.common.modules.ModItems;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class BookModelLumberjack extends BookModelAbstract
{
    public static final ModelResourceLocation modelResourceLocation = new ModelResourceLocation(
            ModItems.BOOK_LUMBERJACK.getRegistryName().toString()
    );
    
    @SideOnly(Side.CLIENT)
    public BookModelLumberjack(IBakedModel parent)
    {
        super(parent);
    }
    
    protected String getBookName()
    {
        return new TextComponentTranslation("item.roleplayskills.book_lumberjack.name").getFormattedText();
    }
}