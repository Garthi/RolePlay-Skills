package com.role.play.skills.utilities;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class ConfigHelper
{
    private static ConfigHelper instance;
    
    private static final String CONFIG_CATEGORY_CONFIG = "all.config";
    private static final String CONFIG_CATEGORY_RECIPES = "all.recipes";
    private static final String CONFIG_VALUE_REMOVE_RECIPES = "remove_recipes";
    private static final String CONFIG_VALUE_DEFAULT_RECIPES = "default_recipes";
    
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

    public boolean isItDefaultRecipe(IRecipe recipe)
    {
        Configuration configuration = getConfig();

        if (!configuration.hasKey(CONFIG_CATEGORY_RECIPES, CONFIG_VALUE_DEFAULT_RECIPES)) {
            return false;
        }

        Property config = configuration.get(CONFIG_CATEGORY_RECIPES, CONFIG_VALUE_DEFAULT_RECIPES, new String[]{});

        String[] defaultRecipes = config.getStringList();
        for (String defaultRecipe: defaultRecipes) {
            try {
                assert recipe.getRegistryName() != null;
                if (defaultRecipe.equals(recipe.getRegistryName().toString())) {
                    return true;
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        return false;
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
        configuration.get(CONFIG_CATEGORY_CONFIG, CONFIG_VALUE_REMOVE_RECIPES, true, "true or false");
        
        configuration.addCustomCategoryComment(CONFIG_CATEGORY_RECIPES, "allowed recipes for all players");
        configuration.get(
                CONFIG_CATEGORY_RECIPES,
                CONFIG_VALUE_DEFAULT_RECIPES,
                new String[] {
                        "nomisma:coinageup_0",
                        "nomisma:coinagedown_0",
                        "nomisma:coinageup_1",
                        "nomisma:coinagedown_1",
                        "nomisma:coinageup_2",
                        "nomisma:coinagedown_2",
                        "nomisma:coinageup_3",
                        "nomisma:coinagedown_3",
                        "nomisma:coinageup_4",
                        "nomisma:coinagedown_4",
                        "nomisma:coinageup_5",
                        "nomisma:coinagedown_5",
                        "nomisma:coinageup_6",
                        "nomisma:coinagedown_6",
                        "nomisma:coinageup_7",
                        "nomisma:coinagedown_7",
                        "nomisma:coinageup_8",
                        "nomisma:coinagedown_8",
                        "nomisma:coinageup_9",
                        "nomisma:coinagedown_9",
                        "nomisma:coinageup_10",
                        "nomisma:coinagedown_10"
                },
                "add recipes registry name to this list to allow as default");
        
        configuration.save();
    }
}
