package com.role.play.skills.common.modules;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class ModItems
{
    public static SmeltingItem SLAG_STONE;
    public static SmeltingItem SLAG_STONEBRICK_CRACKED;
    public static SmeltingItem SLAG_NETHERBRICK;
    public static SmeltingItem SLAG_IRON_INGOT;
    public static SmeltingItem SLAG_GOLD_INGOT;
    public static SmeltingItem RAW_CHARCOAL;
    public static SmeltingItem GLASS_BALL;
    public static ItemBookForgetting BOOK;
    
    public static void init()
    {
        SLAG_STONE = new SmeltingItem("slag_stone");
        SLAG_STONEBRICK_CRACKED = new SmeltingItem("slag_stonebrick_cracked");
        SLAG_NETHERBRICK = new SmeltingItem("slag_netherbrick");
        SLAG_IRON_INGOT = new SmeltingItem("slag_iron_ingot");
        SLAG_GOLD_INGOT = new SmeltingItem("slag_gold_ingot");
        RAW_CHARCOAL = new SmeltingItem("raw_charcoal");
        GLASS_BALL = new SmeltingItem("glass_ball");
        BOOK = new ItemBookForgetting();
    }
    
    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        SLAG_STONE.initModel();
        SLAG_STONEBRICK_CRACKED.initModel();
        SLAG_NETHERBRICK.initModel();
        SLAG_IRON_INGOT.initModel();
        SLAG_GOLD_INGOT.initModel();
        RAW_CHARCOAL.initModel();
        GLASS_BALL.initModel();
        BOOK.initModel();
    }
}
