package mod.society.common.modules;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class RusticItems
{
    public static Block rusticLogs()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("rustic:log"));
    }
    public static Item rusticHoneycomb()
    {
        return Item.REGISTRY.getObject(new ResourceLocation("rustic:honeycomb"));
    }
    public static Item rusticTallow()
    {
        return Item.REGISTRY.getObject(new ResourceLocation("rustic:tallow"));
    }
    public static Item rusticBeeswax()
    {
        return Item.REGISTRY.getObject(new ResourceLocation("rustic:beeswax"));
    }
}
