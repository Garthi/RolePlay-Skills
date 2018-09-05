package com.role.play.skills.common.modules;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 * @package RolePlay-Skills
 */
public class ModItems
{
    public static SmeltingItem BURNED_STONE;
    public static SmeltingItem RAW_CHARCOAL;
    
    public static void init()
    {
        BURNED_STONE = new SmeltingItem("burned_stone");
        RAW_CHARCOAL = new SmeltingItem("raw_charcoal");
    }
    
    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        BURNED_STONE.initModel();
        RAW_CHARCOAL.initModel();
    }
}
