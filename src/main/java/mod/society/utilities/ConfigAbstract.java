package mod.society.utilities;

import net.minecraftforge.common.config.Configuration;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
abstract class ConfigAbstract
{
    private Configuration config;
    
    protected ConfigAbstract(Configuration config)
    {
        this.config = config;
        this.configureConfig();
    }
    
    abstract void configureConfig();
    
    protected Configuration getConfig()
    {
        this.config.load();
        return this.config;
    }
}
