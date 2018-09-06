package com.role.play.skills.common.modules;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class ModItems
{
    public static SmeltingItem SLAG_STONE;
    public static SmeltingItem RAW_CHARCOAL;
    public static ItemBookForgetting BOOK;
    
    public static void init()
    {
        SLAG_STONE = new SmeltingItem("slag_stone");
        RAW_CHARCOAL = new SmeltingItem("raw_charcoal");
        BOOK = new ItemBookForgetting();
    }
    
    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        SLAG_STONE.initModel();
        RAW_CHARCOAL.initModel();
        BOOK.initModel();
    }
}
