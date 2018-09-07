package com.role.play.skills.common.modules;

import com.role.play.skills.common.modules.books.*;
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
    public static SmeltingItem SLAG_TIN_INGOT;
    public static SmeltingItem SLAG_COPPER_INGOT;
    public static SmeltingItem RAW_CHARCOAL;
    public static SmeltingItem GLASS_BALL;
    public static SmeltingItem SLAG_HARDENED_CLAY;
    public static SmeltingItem SLAG_GLAZED_TERRACOTTA_BLACK;
    public static SmeltingItem SLAG_GLAZED_TERRACOTTA_BLUE;
    public static SmeltingItem SLAG_GLAZED_TERRACOTTA_BROWN;
    public static SmeltingItem SLAG_GLAZED_TERRACOTTA_CYAN;
    public static SmeltingItem SLAG_GLAZED_TERRACOTTA_GRAY;
    public static SmeltingItem SLAG_GLAZED_TERRACOTTA_GREEN;
    public static SmeltingItem SLAG_GLAZED_TERRACOTTA_LIGHT_BLUE;
    public static SmeltingItem SLAG_GLAZED_TERRACOTTA_LIME;
    public static SmeltingItem SLAG_GLAZED_TERRACOTTA_MAGENTA;
    public static SmeltingItem SLAG_GLAZED_TERRACOTTA_ORANGE;
    public static SmeltingItem SLAG_GLAZED_TERRACOTTA_PINK;
    public static SmeltingItem SLAG_GLAZED_TERRACOTTA_PURPLE;
    public static SmeltingItem SLAG_GLAZED_TERRACOTTA_RED;
    public static SmeltingItem SLAG_GLAZED_TERRACOTTA_SILVER;
    public static SmeltingItem SLAG_GLAZED_TERRACOTTA_WHITE;
    public static SmeltingItem SLAG_GLAZED_TERRACOTTA_YELLOW;
    public static ItemBookForgetting BOOK_FORGETTING;
    public static ItemBookLumberjack BOOK_LUMBERJACK;
    public static ItemBookBlacksmith BOOK_BLACKSMITH;
    public static ItemBookLibrarian BOOK_LIBRARIAN;
    public static ItemBookAnimalBreeder BOOK_ANIMAL_BREEDER;
    public static ItemBookBaker BOOK_BAKER;
    public static ItemBookButcher BOOK_BUTCHER;
    public static ItemBookConfectioner BOOK_CONFECTIONER;
    public static ItemBookCook BOOK_COOK;
    public static ItemBookFishCook BOOK_FISH_COOK;
    public static ItemBookFisher BOOK_FISHER;
    
    public static void init()
    {
        SLAG_STONE = new SmeltingItem("slag_stone");
        SLAG_STONEBRICK_CRACKED = new SmeltingItem("slag_stonebrick_cracked");
        SLAG_NETHERBRICK = new SmeltingItem("slag_netherbrick");
        SLAG_IRON_INGOT = new SmeltingItem("slag_iron_ingot");
        SLAG_GOLD_INGOT = new SmeltingItem("slag_gold_ingot");
        SLAG_TIN_INGOT = new SmeltingItem("slag_tin_ingot");
        SLAG_COPPER_INGOT = new SmeltingItem("slag_copper_ingot");
        RAW_CHARCOAL = new SmeltingItem("raw_charcoal");
        GLASS_BALL = new SmeltingItem("glass_ball");
        SLAG_HARDENED_CLAY = new SmeltingItem("slag_hardened_clay");
        SLAG_GLAZED_TERRACOTTA_BLACK = new SmeltingItem("slag_glazed_terracotta_black");
        SLAG_GLAZED_TERRACOTTA_BLUE = new SmeltingItem("slag_glazed_terracotta_blue");
        SLAG_GLAZED_TERRACOTTA_BROWN = new SmeltingItem("slag_glazed_terracotta_brown");
        SLAG_GLAZED_TERRACOTTA_CYAN = new SmeltingItem("slag_glazed_terracotta_cyan");
        SLAG_GLAZED_TERRACOTTA_GRAY = new SmeltingItem("slag_glazed_terracotta_gray");
        SLAG_GLAZED_TERRACOTTA_GREEN = new SmeltingItem("slag_glazed_terracotta_green");
        SLAG_GLAZED_TERRACOTTA_LIGHT_BLUE = new SmeltingItem("slag_glazed_terracotta_light_blue");
        SLAG_GLAZED_TERRACOTTA_LIME = new SmeltingItem("slag_glazed_terracotta_lime");
        SLAG_GLAZED_TERRACOTTA_MAGENTA = new SmeltingItem("slag_glazed_terracotta_magenta");
        SLAG_GLAZED_TERRACOTTA_ORANGE = new SmeltingItem("slag_glazed_terracotta_orange");
        SLAG_GLAZED_TERRACOTTA_PINK = new SmeltingItem("slag_glazed_terracotta_pink");
        SLAG_GLAZED_TERRACOTTA_PURPLE = new SmeltingItem("slag_glazed_terracotta_purple");
        SLAG_GLAZED_TERRACOTTA_RED = new SmeltingItem("slag_glazed_terracotta_red");
        SLAG_GLAZED_TERRACOTTA_SILVER = new SmeltingItem("slag_glazed_terracotta_silver");
        SLAG_GLAZED_TERRACOTTA_WHITE = new SmeltingItem("slag_glazed_terracotta_white");
        SLAG_GLAZED_TERRACOTTA_YELLOW = new SmeltingItem("slag_glazed_terracotta_yellow");
        
        BOOK_FORGETTING = new ItemBookForgetting();
        BOOK_LUMBERJACK = new ItemBookLumberjack();
        BOOK_BLACKSMITH = new ItemBookBlacksmith();
        BOOK_LIBRARIAN = new ItemBookLibrarian();
        BOOK_ANIMAL_BREEDER = new ItemBookAnimalBreeder();
        BOOK_BAKER = new ItemBookBaker();
        BOOK_BUTCHER = new ItemBookButcher();
        BOOK_CONFECTIONER = new ItemBookConfectioner();
        BOOK_COOK = new ItemBookCook();
        BOOK_FISH_COOK = new ItemBookFishCook();
        BOOK_FISHER = new ItemBookFisher();
    }
    
    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        SLAG_STONE.initModel();
        SLAG_STONEBRICK_CRACKED.initModel();
        SLAG_NETHERBRICK.initModel();
        SLAG_IRON_INGOT.initModel();
        SLAG_GOLD_INGOT.initModel();
        SLAG_TIN_INGOT.initModel();
        SLAG_COPPER_INGOT.initModel();
        RAW_CHARCOAL.initModel();
        GLASS_BALL.initModel();
        SLAG_HARDENED_CLAY.initModel();
        SLAG_GLAZED_TERRACOTTA_BLACK.initModel();
        SLAG_GLAZED_TERRACOTTA_BLUE.initModel();
        SLAG_GLAZED_TERRACOTTA_BROWN.initModel();
        SLAG_GLAZED_TERRACOTTA_CYAN.initModel();
        SLAG_GLAZED_TERRACOTTA_GRAY.initModel();
        SLAG_GLAZED_TERRACOTTA_GREEN.initModel();
        SLAG_GLAZED_TERRACOTTA_LIGHT_BLUE.initModel();
        SLAG_GLAZED_TERRACOTTA_LIME.initModel();
        SLAG_GLAZED_TERRACOTTA_MAGENTA.initModel();
        SLAG_GLAZED_TERRACOTTA_ORANGE.initModel();
        SLAG_GLAZED_TERRACOTTA_PINK.initModel();
        SLAG_GLAZED_TERRACOTTA_PURPLE.initModel();
        SLAG_GLAZED_TERRACOTTA_RED.initModel();
        SLAG_GLAZED_TERRACOTTA_SILVER.initModel();
        SLAG_GLAZED_TERRACOTTA_WHITE.initModel();
        SLAG_GLAZED_TERRACOTTA_YELLOW.initModel();
        
        BOOK_FORGETTING.initModel();
        BOOK_LUMBERJACK.initModel();
        BOOK_BLACKSMITH.initModel();
        BOOK_LIBRARIAN.initModel();
        BOOK_ANIMAL_BREEDER.initModel();
        BOOK_BAKER.initModel();
        BOOK_BUTCHER.initModel();
        BOOK_CONFECTIONER.initModel();
        BOOK_COOK.initModel();
        BOOK_FISH_COOK.initModel();
        BOOK_FISHER.initModel();
    }
}
