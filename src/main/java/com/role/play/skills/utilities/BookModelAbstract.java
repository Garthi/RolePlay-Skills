package com.role.play.skills.utilities;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.SimpleModelFontRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import javax.vecmath.Matrix3f;
import javax.vecmath.Matrix4f;
import javax.vecmath.Vector3f;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin "Garth" Zander <garth@new-crusader.de>
 */
abstract class BookModelAbstract implements IBakedModel
{
    private static final ResourceLocation font = new ResourceLocation("minecraft", "textures/font/ascii.png");
    private static final ResourceLocation font2 = new ResourceLocation("minecraft", "font/ascii");
    
    private final IBakedModel parent;
    private List<BakedQuad> textQuads;

    @SideOnly(Side.CLIENT)
    public BookModelAbstract(IBakedModel parent)
    {
        this.parent = parent;
        this.textQuads = new ArrayList<>();
        
        initText();
    }

    @SideOnly(Side.CLIENT)
    private void initText()
    {
        Matrix4f m = new Matrix4f();
        m.m20 = 1f / 128f;
        m.m01 = m.m12 = -m.m20;
        m.m33 = 1;
        Matrix3f rotation = new Matrix3f();
        m.getRotationScale(rotation);
        Matrix3f angleZ = new Matrix3f();
        angleZ.rotZ(-1.5708F);
        rotation.mul(rotation, angleZ);
        m.setRotationScale(rotation);
        m.setScale(1F * m.getScale());
        m.setTranslation(new Vector3f(0.25F, 0.2505F, 0.328125F));

        SimpleModelFontRenderer fontRenderer = new SimpleModelFontRenderer(
                Minecraft.getMinecraft().gameSettings,
                font,
                Minecraft.getMinecraft().getTextureManager(),
                false,
                m,
                DefaultVertexFormats.ITEM
        ) {
            @SideOnly(Side.CLIENT)
            @Override
            protected float renderUnicodeChar(char c, boolean italic) {
                return super.renderDefaultChar(126, italic);
            }
        };

        int maxLineWidth = 64;
        TextureAtlasSprite fontSprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(font2.toString());
        fontRenderer.setSprite(fontSprite);
        fontRenderer.setFillBlanks(false);

        
        
        int yOffset = 2;
        String title = this.getBookName();
        List<String> lines = fontRenderer.listFormattedStringToWidth(title, maxLineWidth);
        for (int line = 0; line < lines.size(); line++) {
            int offset = ((maxLineWidth - fontRenderer.getStringWidth(lines.get(line))) / 2);
            fontRenderer.drawString(lines.get(line), offset, yOffset, 0x414141);
            yOffset += (fontRenderer.FONT_HEIGHT);
        }

        textQuads = fontRenderer.build();
    }

    abstract String getBookName();
    
    @SideOnly(Side.CLIENT)
    @Override
    public List<BakedQuad> getQuads(@Nullable IBlockState state, @Nullable EnumFacing side, long rand)
    {
        List<BakedQuad> quads = new ArrayList<>();
        quads.addAll(parent.getQuads(state, side, rand));
        quads.addAll(textQuads);
        return quads;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean isAmbientOcclusion()
    {
        return parent.isAmbientOcclusion();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean isGui3d()
    {
        return parent.isGui3d();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean isBuiltInRenderer()
    {
        return parent.isBuiltInRenderer();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public TextureAtlasSprite getParticleTexture()
    {
        return parent.getParticleTexture();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemOverrideList getOverrides()
    {
        return parent.getOverrides();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemCameraTransforms getItemCameraTransforms()
    {
        return parent.getItemCameraTransforms();
    }
}
