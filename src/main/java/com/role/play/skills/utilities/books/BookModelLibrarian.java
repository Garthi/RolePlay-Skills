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
public class BookModelLibrarian extends BookModelAbstract
{
    public static final ModelResourceLocation modelResourceLocation = new ModelResourceLocation(
            ModItems.BOOK_LIBRARIAN.getRegistryName().toString()
    );
    
    @SideOnly(Side.CLIENT)
    public BookModelLibrarian(IBakedModel parent)
    {
        super(parent);
    }
    
    protected String getBookName()
    {
        return new TextComponentTranslation("item.roleplayskills.book_librarian.name").getFormattedText();
    }
}