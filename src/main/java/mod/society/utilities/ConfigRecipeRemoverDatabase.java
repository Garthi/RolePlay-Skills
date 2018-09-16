package mod.society.utilities;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class ConfigRecipeRemoverDatabase extends ConfigAbstract
{
    private static ConfigRecipeRemoverDatabase instance;
    
    private String player;
    
    private ConfigRecipeRemoverDatabase(Configuration config)
    {
        super(config);
    }

    public static ConfigRecipeRemoverDatabase init(File configFile)
    {
        Configuration configuration = new Configuration(configFile);
        instance = new ConfigRecipeRemoverDatabase(configuration);
        
        return instance;
    }
    
    public static ConfigRecipeRemoverDatabase player(String player) throws NotLoadedException
    {
        if (instance == null) {
            throw new NotLoadedException("ConfigRecipeRemoverDatabase have no instance");
        }
        
        instance.player = player;
        
        return instance;
    }

    public void add()
    {
        Configuration configuration = getConfig();

        if (configuration.hasCategory(player)) {
            return;
        }

        configuration.addCustomCategoryComment(player, "removed recipe book");
        configuration.get(player, "recipe_book_removed", true);
        
        configuration.save();
    }

    public Property get()
    {
        Configuration configuration = getConfig();

        if (!configuration.hasCategory(player)) {
            return null;
        }

        return configuration.get(player, "recipe_book_removed", true);
    }

    public void remove()
    {
        Configuration configuration = getConfig();

        if (!configuration.hasCategory(player)) {
            return;
        }

        configuration.removeCategory(configuration.getCategory(player));
    }
    
    protected void configureConfig()
    {}
}
