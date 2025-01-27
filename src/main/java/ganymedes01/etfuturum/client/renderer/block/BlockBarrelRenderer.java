package ganymedes01.etfuturum.client.renderer.block;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import ganymedes01.etfuturum.ModBlocks;
import ganymedes01.etfuturum.blocks.BlockBarrel;
import ganymedes01.etfuturum.client.OpenGLHelper;
import ganymedes01.etfuturum.lib.RenderIDs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.src.FMLRenderAccessLibrary;
import net.minecraft.world.IBlockAccess;

public class BlockBarrelRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int meta, int modelID, RenderBlocks renderer) {
		Tessellator tessellator = Tessellator.instance;
		OpenGLHelper.translate(-0.5F, -0.5F, -0.5F);

		int metadata = BlockPistonBase.getPistonOrientation(meta);
		switch(metadata) {
		case 0: metadata = 1;
		break;
		case 1: metadata = 0;
		break;
		
		default: metadata = meta;
		break;
		}
		renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1.0F, 0.0F);
		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
		tessellator.setNormal(0.0F, 0.0F, -1.0F);
		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
		tessellator.setNormal(-1.0F, 0.0F, 0.0F);
		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
		tessellator.draw();

		OpenGLHelper.translate(0.5F, 0.5F, 0.5F);
		OpenGLHelper.disableBlend();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        int l = BlockPistonBase.getPistonOrientation(renderer.blockAccess.getBlockMetadata(x, y, z));

            switch (l)
            {
            case 0:
                renderer.uvRotateEast = 3;
                renderer.uvRotateWest = 3;
                renderer.uvRotateSouth = 3;
                renderer.uvRotateNorth = 3;
                break;
            case 1:
                break;
            case 2:
                renderer.uvRotateSouth = 1;
                renderer.uvRotateNorth = 2;
                renderer.uvRotateEast = 3;
                break;
            case 3:
                renderer.uvRotateSouth = 2;
                renderer.uvRotateNorth = 1;
                renderer.uvRotateWest = 3;
                renderer.uvRotateTop = 3;
                renderer.uvRotateBottom = 3;
                break;
            case 4:
                renderer.uvRotateEast = 1;
                renderer.uvRotateWest = 2;
                renderer.uvRotateNorth = 3;
                renderer.uvRotateTop = 2;
                renderer.uvRotateBottom = 1;
                break;
            case 5:
                renderer.uvRotateEast = 2;
                renderer.uvRotateWest = 1;
                renderer.uvRotateSouth = 3;
                renderer.uvRotateTop = 1;
                renderer.uvRotateBottom = 2;
                break;
        }

            renderer.renderStandardBlock(block, x, y, z);
            renderer.uvRotateEast = 0;
            renderer.uvRotateWest = 0;
            renderer.uvRotateSouth = 0;
            renderer.uvRotateNorth = 0;
            renderer.uvRotateTop = 0;
            renderer.uvRotateBottom = 0;

        return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return RenderIDs.BARREL;
	}

}
