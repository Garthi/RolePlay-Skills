package mod.society.common.modules;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class ItemBook extends AbstractItem
{
    public ItemBook(String name)
    {
        super("book_" + name);
        
        this.setMaxStackSize(1);
        this.setMaxDamage(0);

        GameRegistry.findRegistry(Item.class).register(this);
    }
}
