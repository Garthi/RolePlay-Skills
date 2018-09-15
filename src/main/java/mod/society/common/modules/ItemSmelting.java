package mod.society.common.modules;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class ItemSmelting extends AbstractItem
{
    public ItemSmelting(String name)
    {
        super(name);

        GameRegistry.findRegistry(Item.class).register(this);
    }
}
