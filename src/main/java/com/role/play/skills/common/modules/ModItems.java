package com.role.play.skills.common.modules;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 * @package RolePlay-Skills
 */
public class ModItems
{
    public static SmeltingItem BURNED_STONE;
    
    public static void init()
    {
        BURNED_STONE = new SmeltingItem("burned_stone");
    }
    
    public static void initModels()
    {
        BURNED_STONE.initModel();
    }
}
