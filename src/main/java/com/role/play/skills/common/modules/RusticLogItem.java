package com.role.play.skills.common.modules;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class RusticLogItem
{
    public static Block rusticOliveLog()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("rustic:log"));
    }
    
    public static Block rusticIronWoodLog()
    {
        return Block.REGISTRY.getObject(new ResourceLocation(""));
    }
}
