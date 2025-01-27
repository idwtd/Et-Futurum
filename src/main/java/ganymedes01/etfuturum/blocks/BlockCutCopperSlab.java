package ganymedes01.etfuturum.blocks;

import java.util.Random;

import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.IConfigurable;
import ganymedes01.etfuturum.ModBlocks;
import ganymedes01.etfuturum.client.sound.ModSounds;
import ganymedes01.etfuturum.configuration.ConfigurationHandler;
import ganymedes01.etfuturum.core.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockCutCopperSlab extends BlockGenericSlab implements IConfigurable {

	public BlockCutCopperSlab(boolean p_i45410_1_) {
		super(p_i45410_1_, Material.iron, "", "exposed", "weathered", "oxidized", "waxed", "waxed_exposed", "waxed_weathered");
		setHardness(3);
		setResistance(6);
		setHarvestLevel("pickaxe", 1);
		setBlockName(Utils.getUnlocalisedName("cut_copper_slab"));
		setBlockTextureName("cut_copper");
		setCreativeTab(isEnabled() ? EtFuturum.creativeTabBlocks : null);
		setStepSound(ConfigurationHandler.enableNewBlocksSounds ? ModSounds.soundCopper : Block.soundTypeMetal);
		setTickRandomly(true);
	}
    
    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        if (world.isRemote)
            return;
        int meta = world.getBlockMetadata(x, y, z);
        if (meta % 8 > 2)
        	return;
        tickDegradation(world, x, y, z, rand);
    }

    private void tickDegradation(World world, int x, int y, int z, Random random) {
    	float f = 0.05688889F;
    	if (random.nextFloat() < 0.05688889F) {
    		this.tryDegrade(world, x, y, z, random);
    	}
    }

	private void tryDegrade(World world, int x, int y, int z, Random random) {
	   int i = world.getBlockMetadata(x, y, z) % 4;
	   int j = 0;
	   int k = 0;
	   
	   for(int x1 = -4; x1 <= 4; x1++) {
	       for(int y1 = -4; y1 <= 4; y1++) {
	           for(int z1 = -4; z1 <= 4; z1++) {
	               if(world.getBlock(x1 + x, y1 + y, z1 + z) instanceof BlockCutCopperSlab && (x1 != 0 || y1 != 0 || z1 != 0) && Math.abs(x1) + Math.abs(y1) + Math.abs(z1) <= 4) {
	                   int m = world.getBlockMetadata(x1 + x, y1 + y, z1 + z) % 4;
	                   
	                   if(world.getBlockMetadata(x, y, z) % 8 > 3)
	                	   continue;
	                   
	                   if (m < i) {
	                      return;
	                   }
	          
	                   if (m > i) {
	                      ++k;
	                   } else {
	                      ++j;
	                   }
	               }
	           }
	       }
	   }

       float f = (float)(k + 1) / (float)(k + j + 1);
       float g = f * f * (i == 0 ? 0.75F : 1F);
       if (random.nextFloat() < g) {
          world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 2);
       }
    }

	@Override
	public boolean isEnabled() {
		return ConfigurationHandler.enableCopper;
	}

	@Override
	public BlockGenericSlab[] getSlabTypes() {
		return new BlockGenericSlab[] {(BlockGenericSlab)ModBlocks.cut_copper_slab, (BlockGenericSlab)ModBlocks.double_cut_copper_slab};
	}

    public String func_150002_b(int meta)
    {
    	meta %= 8;
        		
        if(meta >= metaBlocks.length) {
        	meta = 0;
        }

        if(metaBlocks[meta].equals("")) {
        	return super.getUnlocalizedName();
        } else {
            return "tile.etfuturum." + metaBlocks[meta] + "_" + super.getUnlocalizedName().split("tile.etfuturum.")[1];
        }
    }

	@Override
	public IIcon[] getSlabIcons(int side) {
		IIcon[] blocks = new IIcon[7];
        for(int i = 0; i < 7; i++) {
        	blocks[i] = ModBlocks.copper_block.getIcon(side, (i % 4) + 4);
        };
        return blocks;
	}

}
