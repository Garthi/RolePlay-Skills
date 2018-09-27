package mod.society.common.modules;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class CeramicsItems
{
    public static Item clayUnfired()
    {
        return Item.REGISTRY.getObject(new ResourceLocation("ceramics:unfired_clay"));
    }
    public static Item clayBucket()
    {
        return Item.REGISTRY.getObject(new ResourceLocation("ceramics:clay_bucket"));
    }
    public static Item clayShears()
    {
        return Item.REGISTRY.getObject(new ResourceLocation("ceramics:clay_shears"));
    }
    public static Item clayBarrel()
    {
        return Item.REGISTRY.getObject(new ResourceLocation("ceramics:clay_barrel"));
    }
    public static Block clayPorcelainUnfired()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("ceramics:clay_soft"));
    }
    public static Block clayPorcelain()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("ceramics:clay_porcelain"));
    }
    public static Item clayBarrelUnfired()
    {
        return Item.REGISTRY.getObject(new ResourceLocation("ceramics:clay_barrel_unfired"));
    }
    public static Item clayPorcelainBarrel()
    {
        return Item.REGISTRY.getObject(new ResourceLocation("ceramics:porcelain_barrel"));
    }
    public static Item clayPorcelainBarrelExtension()
    {
        return Item.REGISTRY.getObject(new ResourceLocation("ceramics:porcelain_barrel_extension"));
    }
}
