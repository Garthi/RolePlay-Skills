package mod.society.common.modules;

import mod.society.Society;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
public abstract class AbstractItem extends Item
{
    private String name;
    
    public AbstractItem(String name)
    {
        this.name = name;
        
        this.setRegistryName(name);
        this.setUnlocalizedName(Society.ID + "." + name);
        
        this.setCreativeTab(CreativeTabs.MISC);
    }

    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
    }

    @Override
    public String toString()
    {
        return name;
    }
}
