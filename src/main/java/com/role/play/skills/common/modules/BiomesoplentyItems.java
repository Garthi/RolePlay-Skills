package com.role.play.skills.common.modules;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public class BiomesoplentyItems
{
    public static Block biomesoplentyLog0()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("biomesoplenty:log_0"));
    }
    public static Block biomesoplentyLog1()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("biomesoplenty:log_1"));
    }
    public static Block biomesoplentyLog2()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("biomesoplenty:log_2"));
    }
    public static Block biomesoplentyLog3()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("biomesoplenty:log_3"));
    }
    public static Block biomesoplentyLog4()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("biomesoplenty:log_4"));
    }
    public static Block biomesoplentyWhiteSand()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("biomesoplenty:white_sand"));
    }
    public static Block biomesoplentyMud()
    {
        return Block.REGISTRY.getObject(new ResourceLocation("biomesoplenty:mud"));
    }
}
