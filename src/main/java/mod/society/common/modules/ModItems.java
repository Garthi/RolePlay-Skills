package mod.society.common.modules;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class ModItems
{
    public static ItemSmelting SLAG_STONE;
    public static ItemSmelting SLAG_STONEBRICK_CRACKED;
    public static ItemSmelting SLAG_NETHERBRICK;
    public static ItemSmelting SLAG_IRON_INGOT;
    public static ItemSmelting SLAG_GOLD_INGOT;
    public static ItemSmelting SLAG_TIN_INGOT;
    public static ItemSmelting SLAG_COPPER_INGOT;
    public static ItemSmelting RAW_CHARCOAL;
    public static ItemSmelting GLASS_BALL;
    public static ItemSmelting SLAG_HARDENED_CLAY;
    public static ItemSmelting SLAG_GLAZED_TERRACOTTA_BLACK;
    public static ItemSmelting SLAG_GLAZED_TERRACOTTA_BLUE;
    public static ItemSmelting SLAG_GLAZED_TERRACOTTA_BROWN;
    public static ItemSmelting SLAG_GLAZED_TERRACOTTA_CYAN;
    public static ItemSmelting SLAG_GLAZED_TERRACOTTA_GRAY;
    public static ItemSmelting SLAG_GLAZED_TERRACOTTA_GREEN;
    public static ItemSmelting SLAG_GLAZED_TERRACOTTA_LIGHT_BLUE;
    public static ItemSmelting SLAG_GLAZED_TERRACOTTA_LIME;
    public static ItemSmelting SLAG_GLAZED_TERRACOTTA_MAGENTA;
    public static ItemSmelting SLAG_GLAZED_TERRACOTTA_ORANGE;
    public static ItemSmelting SLAG_GLAZED_TERRACOTTA_PINK;
    public static ItemSmelting SLAG_GLAZED_TERRACOTTA_PURPLE;
    public static ItemSmelting SLAG_GLAZED_TERRACOTTA_RED;
    public static ItemSmelting SLAG_GLAZED_TERRACOTTA_SILVER;
    public static ItemSmelting SLAG_GLAZED_TERRACOTTA_WHITE;
    public static ItemSmelting SLAG_GLAZED_TERRACOTTA_YELLOW;
    public static ItemSmelting SLAG_BEESWAX;
    public static ItemSmelting SLAG_TALLOW;
    public static ItemSmelting SLAG_DYE_POWDER_GREEN;
    public static ItemSmelting SLAG_CHORUS_FRUIT_POPPED;
    public static ItemSmelting SLAG_CLAY_BRICK;
    public static ItemBook BOOK_FORGETTING;
    public static ItemBook BOOK_LUMBERJACK;
    public static ItemBook BOOK_BLACKSMITH;
    public static ItemBook BOOK_LIBRARIAN;
    public static ItemBook BOOK_ANIMAL_BREEDER;
    public static ItemBook BOOK_BAKER;
    public static ItemBook BOOK_BUTCHER;
    public static ItemBook BOOK_CONFECTIONER;
    public static ItemBook BOOK_COOK;
    public static ItemBook BOOK_FISH_COOK;
    public static ItemBook BOOK_FISHER;
    public static ItemBook BOOK_FARMER;
    public static ItemBook BOOK_PLANT_BREEDER;
    public static ItemBook BOOK_TREE_REFINER;
    public static ItemBook BOOK_ALCHEMIST;
    public static ItemBook BOOK_BARKEEPER;
    public static ItemBook BOOK_BURNER;
    public static ItemBook BOOK_CARPENTER;
    public static ItemBook BOOK_DIGGER;
    public static ItemBook BOOK_GLAZIER;
    public static ItemBook BOOK_HEALER;
    public static ItemBook BOOK_ICE_CREAM_MAKER;
    public static ItemBook BOOK_STONEMASON;
    public static ItemBook BOOK_TAILOR;
    public static ItemBook BOOK_TOOLMAKER;
    
    public static void init()
    {
        SLAG_STONE = new ItemSmelting("slag_stone");
        SLAG_STONEBRICK_CRACKED = new ItemSmelting("slag_stonebrick_cracked");
        SLAG_NETHERBRICK = new ItemSmelting("slag_netherbrick");
        SLAG_IRON_INGOT = new ItemSmelting("slag_iron_ingot");
        SLAG_GOLD_INGOT = new ItemSmelting("slag_gold_ingot");
        SLAG_TIN_INGOT = new ItemSmelting("slag_tin_ingot");
        SLAG_COPPER_INGOT = new ItemSmelting("slag_copper_ingot");
        RAW_CHARCOAL = new ItemSmelting("raw_charcoal");
        GLASS_BALL = new ItemSmelting("glass_ball");
        SLAG_HARDENED_CLAY = new ItemSmelting("slag_hardened_clay");
        SLAG_GLAZED_TERRACOTTA_BLACK = new ItemSmelting("slag_glazed_terracotta_black");
        SLAG_GLAZED_TERRACOTTA_BLUE = new ItemSmelting("slag_glazed_terracotta_blue");
        SLAG_GLAZED_TERRACOTTA_BROWN = new ItemSmelting("slag_glazed_terracotta_brown");
        SLAG_GLAZED_TERRACOTTA_CYAN = new ItemSmelting("slag_glazed_terracotta_cyan");
        SLAG_GLAZED_TERRACOTTA_GRAY = new ItemSmelting("slag_glazed_terracotta_gray");
        SLAG_GLAZED_TERRACOTTA_GREEN = new ItemSmelting("slag_glazed_terracotta_green");
        SLAG_GLAZED_TERRACOTTA_LIGHT_BLUE = new ItemSmelting("slag_glazed_terracotta_light_blue");
        SLAG_GLAZED_TERRACOTTA_LIME = new ItemSmelting("slag_glazed_terracotta_lime");
        SLAG_GLAZED_TERRACOTTA_MAGENTA = new ItemSmelting("slag_glazed_terracotta_magenta");
        SLAG_GLAZED_TERRACOTTA_ORANGE = new ItemSmelting("slag_glazed_terracotta_orange");
        SLAG_GLAZED_TERRACOTTA_PINK = new ItemSmelting("slag_glazed_terracotta_pink");
        SLAG_GLAZED_TERRACOTTA_PURPLE = new ItemSmelting("slag_glazed_terracotta_purple");
        SLAG_GLAZED_TERRACOTTA_RED = new ItemSmelting("slag_glazed_terracotta_red");
        SLAG_GLAZED_TERRACOTTA_SILVER = new ItemSmelting("slag_glazed_terracotta_silver");
        SLAG_GLAZED_TERRACOTTA_WHITE = new ItemSmelting("slag_glazed_terracotta_white");
        SLAG_GLAZED_TERRACOTTA_YELLOW = new ItemSmelting("slag_glazed_terracotta_yellow");
        SLAG_BEESWAX = new ItemSmelting("slag_beeswax");
        SLAG_TALLOW = new ItemSmelting("slag_tallow");
        SLAG_DYE_POWDER_GREEN = new ItemSmelting("slag_dye_powder_green");
        SLAG_CHORUS_FRUIT_POPPED = new ItemSmelting("slag_chorus_fruit_popped");
        SLAG_CLAY_BRICK = new ItemSmelting("slag_clay_brick");
        
        BOOK_FORGETTING = new ItemBook("forgetting");
        BOOK_LUMBERJACK = new ItemBook("lumberjack");
        BOOK_BLACKSMITH = new ItemBook("blacksmith");
        BOOK_LIBRARIAN = new ItemBook("librarian");
        BOOK_ANIMAL_BREEDER = new ItemBook("animal_breeder");
        BOOK_BAKER = new ItemBook("baker");
        BOOK_BUTCHER = new ItemBook("butcher");
        BOOK_CONFECTIONER = new ItemBook("confectioner");
        BOOK_COOK = new ItemBook("cook");
        BOOK_FISH_COOK = new ItemBook("fish_cook");
        BOOK_FISHER = new ItemBook("fisher");
        BOOK_FARMER = new ItemBook("farmer");
        BOOK_PLANT_BREEDER = new ItemBook("plant_breeder");
        BOOK_TREE_REFINER = new ItemBook("tree_refiner");
        BOOK_ALCHEMIST = new ItemBook("alchemist");
        BOOK_BARKEEPER = new ItemBook("barkeeper");
        BOOK_BURNER = new ItemBook("burner");
        BOOK_CARPENTER = new ItemBook("carpenter");
        BOOK_DIGGER = new ItemBook("digger");
        BOOK_GLAZIER = new ItemBook("glazier");
        BOOK_HEALER = new ItemBook("healer");
        BOOK_ICE_CREAM_MAKER = new ItemBook("ice_cream_maker");
        BOOK_STONEMASON = new ItemBook("stonemason");
        BOOK_TAILOR = new ItemBook("tailor");
        BOOK_TOOLMAKER = new ItemBook("toolmaker");
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
        SLAG_BEESWAX.initModel();
        SLAG_TALLOW.initModel();
        SLAG_DYE_POWDER_GREEN.initModel();
        SLAG_CHORUS_FRUIT_POPPED.initModel();
        SLAG_CLAY_BRICK.initModel();
        
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
        BOOK_FARMER.initModel();
        BOOK_PLANT_BREEDER.initModel();
        BOOK_TREE_REFINER.initModel();
        BOOK_ALCHEMIST.initModel();
        BOOK_BARKEEPER.initModel();
        BOOK_BURNER.initModel();
        BOOK_CARPENTER.initModel();
        BOOK_DIGGER.initModel();
        BOOK_GLAZIER.initModel();
        BOOK_HEALER.initModel();
        BOOK_ICE_CREAM_MAKER.initModel();
        BOOK_STONEMASON.initModel();
        BOOK_TAILOR.initModel();
        BOOK_TOOLMAKER.initModel();
    }
}
