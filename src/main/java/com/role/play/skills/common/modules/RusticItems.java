package com.role.play.skills.common.modules;

import net.minecraft.block.Block;
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
}
