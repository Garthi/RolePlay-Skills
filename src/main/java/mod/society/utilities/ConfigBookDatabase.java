package mod.society.utilities;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class ConfigBookDatabase extends ConfigAbstract
{
    private static final String CONFIG_CATEGORY_BOOKS = "book.recipes";
    private static final String CONFIG_CATEGORY_USAGES = "book.usages.";
    private static final String CONFIG_VALUE_DEFAULT_BOOKS = "books";
    
    private static ConfigBookDatabase instance;

    private ConfigBookDatabase(Configuration config)
    {
        super(config);
    }

    public static ConfigBookDatabase init(File configFile)
    {
        Configuration configuration = new Configuration(configFile);
        instance = new ConfigBookDatabase(configuration);

        return instance;
    }

    public static ConfigBookDatabase get() throws NotLoadedException
    {
        if (instance == null) {
            throw new NotLoadedException("ConfigBookDatabase have no instance");
        }

        return instance;
    }
    
    public String[] getBookRecipes(String bookName)
    {
        Configuration configuration = getConfig();
        
        if (!configuration.hasKey(CONFIG_CATEGORY_BOOKS, bookName)) {
            return new String[]{};
        }

        Property config = configuration.get(CONFIG_CATEGORY_BOOKS, bookName, new String[]{});
        
        return config.getStringList();
    }

    public void addBookUsage(String playerName, String book)
    {
        Configuration configuration = getConfig();

        configuration.addCustomCategoryComment(CONFIG_CATEGORY_USAGES + playerName, "");
        Property config = configuration.get(
                CONFIG_CATEGORY_USAGES + playerName, CONFIG_VALUE_DEFAULT_BOOKS, new String[]{}
        );
        
        String[] newArray = new String[config.getStringList().length + 1];
        System.arraycopy(config.getStringList(), 0, newArray, 0, config.getStringList().length);
        
        newArray[newArray.length - 1] = book;
        
        config.setValues(newArray);

        configuration.save();
    }

    public String[] getBookUsage(String playerName)
    {
        Configuration configuration = getConfig();

        if (!configuration.hasKey(CONFIG_CATEGORY_USAGES + playerName, CONFIG_VALUE_DEFAULT_BOOKS)) {
            return new String[]{};
        }
        
        Property config = configuration.get(
                CONFIG_CATEGORY_USAGES + playerName, CONFIG_VALUE_DEFAULT_BOOKS, new String[]{}
        );
        
        return config.getStringList();
    }
    
    public void removeBookUsage(String playerName)
    {
        Configuration configuration = getConfig();
        if (!configuration.hasCategory(CONFIG_CATEGORY_USAGES + playerName)) {
            return;
        }

        configuration.removeCategory(configuration.getCategory(CONFIG_CATEGORY_USAGES + playerName));
        configuration.save();
    }

    protected void configureConfig()
    {
        Configuration configuration = getConfig();
        
        configuration.addCustomCategoryComment(CONFIG_CATEGORY_BOOKS, "books with the configured recipes");

        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.ALCHEMIST.getId(),
                DefaultBookConfigHelper.ALCHEMIST.getSkills(),
                DefaultBookConfigHelper.ALCHEMIST.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.ANIMAL_BREEDER.getId(),
                DefaultBookConfigHelper.ANIMAL_BREEDER.getSkills(),
                DefaultBookConfigHelper.ANIMAL_BREEDER.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.BAKER.getId(),
                DefaultBookConfigHelper.BAKER.getSkills(),
                DefaultBookConfigHelper.BAKER.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.BARKEEPER.getId(),
                DefaultBookConfigHelper.BARKEEPER.getSkills(),
                DefaultBookConfigHelper.BARKEEPER.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.BLACKSMITH.getId(),
                DefaultBookConfigHelper.BLACKSMITH.getSkills(),
                DefaultBookConfigHelper.BLACKSMITH.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.BURNER.getId(),
                DefaultBookConfigHelper.BURNER.getSkills(),
                DefaultBookConfigHelper.BURNER.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.BUTCHER.getId(),
                DefaultBookConfigHelper.BUTCHER.getSkills(),
                DefaultBookConfigHelper.BUTCHER.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.CARPENTER.getId(),
                DefaultBookConfigHelper.CARPENTER.getSkills(),
                DefaultBookConfigHelper.CARPENTER.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.CONFECTIONER.getId(),
                DefaultBookConfigHelper.CONFECTIONER.getSkills(),
                DefaultBookConfigHelper.CONFECTIONER.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.COOK.getId(),
                DefaultBookConfigHelper.COOK.getSkills(),
                DefaultBookConfigHelper.COOK.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.DIGGER.getId(),
                DefaultBookConfigHelper.DIGGER.getSkills(),
                DefaultBookConfigHelper.DIGGER.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.FISH_COOK.getId(),
                DefaultBookConfigHelper.FISH_COOK.getSkills(),
                DefaultBookConfigHelper.FISH_COOK.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.FISHER.getId(),
                DefaultBookConfigHelper.FISHER.getSkills(),
                DefaultBookConfigHelper.FISHER.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.FARMER.getId(),
                DefaultBookConfigHelper.FARMER.getSkills(),
                DefaultBookConfigHelper.FARMER.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.GLAZIER.getId(),
                DefaultBookConfigHelper.GLAZIER.getSkills(),
                DefaultBookConfigHelper.GLAZIER.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.HEALER.getId(),
                DefaultBookConfigHelper.HEALER.getSkills(),
                DefaultBookConfigHelper.HEALER.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.ICE_CREAM_MAKER.getId(),
                DefaultBookConfigHelper.ICE_CREAM_MAKER.getSkills(),
                DefaultBookConfigHelper.ICE_CREAM_MAKER.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.LIBRARIAN.getId(),
                DefaultBookConfigHelper.LIBRARIAN.getSkills(),
                DefaultBookConfigHelper.LIBRARIAN.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.LUMBERJACK.getId(),
                DefaultBookConfigHelper.LUMBERJACK.getSkills(),
                DefaultBookConfigHelper.LUMBERJACK.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.PLANT_BREEDER.getId(),
                DefaultBookConfigHelper.PLANT_BREEDER.getSkills(),
                DefaultBookConfigHelper.PLANT_BREEDER.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.STONEMASON.getId(),
                DefaultBookConfigHelper.STONEMASON.getSkills(),
                DefaultBookConfigHelper.STONEMASON.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.TREE_REFINER.getId(),
                DefaultBookConfigHelper.TREE_REFINER.getSkills(),
                DefaultBookConfigHelper.TREE_REFINER.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.TAILOR.getId(),
                DefaultBookConfigHelper.TAILOR.getSkills(),
                DefaultBookConfigHelper.TAILOR.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.TOOLMAKER.getId(),
                DefaultBookConfigHelper.TOOLMAKER.getSkills(),
                DefaultBookConfigHelper.TOOLMAKER.getComment()
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                DefaultBookConfigHelper.SOUP_COOK.getId(),
                DefaultBookConfigHelper.SOUP_COOK.getSkills(),
                DefaultBookConfigHelper.SOUP_COOK.getComment()
        );

        configuration.addCustomCategoryComment(CONFIG_CATEGORY_USAGES, "Players use the books");
        configuration.get(
                CONFIG_CATEGORY_USAGES + "Player1",
                CONFIG_VALUE_DEFAULT_BOOKS,
                new String[] {
                        "book_lumberjack",
                        "book_barkeeper"
                },
                "Player1 uses these books"
        );
        
        configuration.save();
    }
}
