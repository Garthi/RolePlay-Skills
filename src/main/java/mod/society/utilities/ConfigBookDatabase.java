package mod.society.utilities;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class ConfigBookDatabase extends ConfigAbstract
{
    private static final String CONFIG_CATEGORY_BOOKS = "books";
    
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
        
        if (!configuration.hasKey(CONFIG_CATEGORY_BOOKS, "book_lumberjack")) {
            return new String[]{};
        }

        Property config = configuration.get(CONFIG_CATEGORY_BOOKS, bookName, new String[]{});
        
        return config.getStringList();
    }

    protected void configureConfig()
    {
        Configuration configuration = getConfig();
        
        configuration.addCustomCategoryComment(CONFIG_CATEGORY_BOOKS, "books with the configured recipes");
        configuration.get(
                CONFIG_CATEGORY_BOOKS,
                "book_lumberjack",
                new String[] {
                        "minecraft:melon_block"
                },
                "Lumberjack book"
        );
        // TODO add default config

        configuration.save();
    }
}
