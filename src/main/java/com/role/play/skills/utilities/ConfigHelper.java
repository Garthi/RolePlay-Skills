package com.role.play.skills.utilities;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class ConfigHelper
{
    private static ConfigHelper instance;
    
    private static final String CONFIG_CATEGORY_CONFIG = "config";
    private static final String CONFIG_VALUE_REMOVE_RECIPES = "remove_recipes";
    
    private Configuration config;
    
    private ConfigHelper(Configuration config)
    {
        this.config = config;
        
        configureConfig();
    }

    public static ConfigHelper init(File configFile)
    {
        Configuration configuration = new Configuration(configFile);
        instance = new ConfigHelper(configuration);
        
        return instance;
    }
    
    public static ConfigHelper get() throws NotLoadedException
    {
        if (instance == null) {
            throw new NotLoadedException("Config Helper have no instance");
        }
        
        return instance;
    }

    public boolean isRecipeRemoverActive()
    {
        Configuration configuration = getConfig();

        if (!configuration.hasKey(CONFIG_CATEGORY_CONFIG, CONFIG_VALUE_REMOVE_RECIPES)) {
            return false;
        }

        Property config = configuration.get(CONFIG_CATEGORY_CONFIG, CONFIG_VALUE_REMOVE_RECIPES, false);

        return config.getBoolean();
    }

    private Configuration getConfig()
    {
        this.config.load();
        return this.config;
    }
    
    private void configureConfig()
    {
        Configuration configuration = getConfig();

        // add default config
        configuration.addCustomCategoryComment(CONFIG_CATEGORY_CONFIG, "mod configuration");
        configuration.get(CONFIG_CATEGORY_CONFIG, CONFIG_VALUE_REMOVE_RECIPES, false, "true or false");
        
        configuration.save();
    }
}
