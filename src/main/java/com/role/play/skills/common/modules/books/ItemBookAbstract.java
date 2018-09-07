package com.role.play.skills.common.modules.books;

import com.role.play.skills.RolePlaySkills;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
abstract public class ItemBookAbstract extends Item
{
    public ItemBookAbstract(String name)
    {
        this.setRegistryName(name);
        this.setUnlocalizedName(RolePlaySkills.ID + "." + name);

        this.setCreativeTab(CreativeTabs.MISC);

        this.setMaxStackSize(1);
        this.setMaxDamage(0);

        GameRegistry.findRegistry(Item.class).register(this);
    }

    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
    }
}
