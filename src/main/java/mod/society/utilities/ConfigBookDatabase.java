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
                "book_lumberjack",
                new String[] {
                        "minecraft:melon_block",
                        "rustic:gargoyle",
                        "rustic:condenser"
                },
                "Lumberjack book"
        );
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                "book_barkeeper",
                new String[] {
                        "minecraft:melon_block",
                        "rustic:candle",
                        "rustic:crop_stake"
                },
                "Lumberjack book"
        );
        
        // TODO more default config

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
