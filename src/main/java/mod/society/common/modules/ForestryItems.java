package mod.society.common.modules;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class ForestryItems
{
    public static Block forestryLog0()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("forestry:logs.0"));
    }
    public static Block forestryLog1()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("forestry:logs.1"));
    }
    public static Block forestryLog2()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("forestry:logs.2"));
    }
    public static Block forestryLog3()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("forestry:logs.3"));
    }
    public static Block forestryLog4()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("forestry:logs.4"));
    }
    public static Block forestryLog5()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("forestry:logs.5"));
    }
    public static Block forestryLog6()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("forestry:logs.6"));
    }
    public static Block forestryLog7()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("forestry:logs.7"));
    }
    public static Block forestryOre()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("forestry:resources"));
    }
    public static Item forestryTinIngot()
    {
        return Item.REGISTRY.getObject(new ResourceLocation("forestry:ingot_tin"));
    }
    public static Item forestryCopperIngot()
    {
        return Item.REGISTRY.getObject(new ResourceLocation("forestry:ingot_copper"));
    }
}
