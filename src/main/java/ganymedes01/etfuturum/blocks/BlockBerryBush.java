package ganymedes01.etfuturum.blocks;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.etfuturum.IConfigurable;
import ganymedes01.etfuturum.ModBlocks.IBurnableBlock;
import ganymedes01.etfuturum.ModBlocks.ISubBlocksBlock;
import ganymedes01.etfuturum.client.sound.ModSounds;
import ganymedes01.etfuturum.ModItems;
import ganymedes01.etfuturum.configuration.ConfigurationHandler;
import ganymedes01.etfuturum.core.utils.Utils;
import ganymedes01.etfuturum.lib.Reference;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class BlockBerryBush extends BlockBush implements IConfigurable, ISubBlocksBlock, IBurnableBlock {

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	public BlockBerryBush() {
		super(Material.vine);
		setStepSound(ConfigurationHandler.enableNewBlocksSounds ? ModSounds.soundBerryBush : soundTypeGrass);
    	setBlockName(Utils.getUnlocalisedName("sweet_berry_bush"));
    	setBlockTextureName("sweet_berry_bush");
        setCreativeTab(null);
        setTickRandomly(true);
	}
	
    public static final DamageSource SWEET_BERRY_BUSH = (new DamageSource("sweetBerryBush"));

    public boolean isReplaceable(IBlockAccess world, int x, int y, int z)
    {
        return false;
    }
    
    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
    	if(world.getBlockMetadata(x, y, z) >= 3)
    		return;
        int i = world.getBlockMetadata(x, y, z);
        if (i < 3 && world.rand.nextInt(5) == 0 && world.getBlockLightValue(x, y, z) >= 9) {
           world.setBlockMetadataWithNotify(x, y, z, i + 1, 2);
        }
    }
    
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if (entity instanceof EntityLivingBase) {
            entity.motionX *= 0.3405D;
            entity.motionY *= 0.3405D;
            entity.motionZ *= 0.3405D;
           if (!world.isRemote && world.getBlockMetadata(x, y, z) > 0 && (entity.lastTickPosX != entity.posX || entity.lastTickPosZ != entity.posZ)) {
              double d0 = Math.abs(entity.posX - entity.lastTickPosX);
              double d1 = Math.abs(entity.posZ - entity.lastTickPosZ);
              if (d0 >= (double)0.003F || d1 >= (double)0.003F) {
                 entity.attackEntityFrom(SWEET_BERRY_BUSH, 1.0F);
              }
           }
        }
     }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
		icons = new IIcon[4];
		for(int i = 0; i < icons.length; i++) {
			icons[i] = icon.registerIcon(getTextureName() + "_stage" + i);
		}
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
    	if(meta > 3)
    		return icons[0];
        return icons[meta];
    }
    
	@Override
	public boolean isEnabled() {
		return ConfigurationHandler.enableSweetBerryBushes;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
		return ModItems.sweet_berries;
	}
	
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
    	if(p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_) == 0) {
    		this.setBlockBounds(0.1875F, 0.0F, 0.1875F, 0.8125F, 0.5F, 0.8125F);
    	} else {
    		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, .9375F, 1.0F, 0.9375F);
    	}
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	int i = world.getBlockMetadata(x, y, z);
        boolean flag = i == 3;
        if (!flag && player.getHeldItem() != null && player.getHeldItem().getItem() == Items.dye && player.getHeldItem().getItemDamage() == 15) {
			   world.setBlockMetadataWithNotify(x, y, z, i + 1, 2);
			   return true;
       } else if (i > 1) {
           int j = 1 + world.rand.nextInt(2);
    	   ItemStack stack = new ItemStack(ModItems.sweet_berries, j + (flag ? 1 : 0));
           if (!world.isRemote && !world.restoringBlockSnapshots) {
               if (captureDrops.get()) {
                   capturedDrops.get().add(stack);
               }
               float f = 0.7F;
               double d0 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
               double d1 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
               double d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
               EntityItem entityitem = new EntityItem(world, (double)x + d0, (double)y + d1, (double)z + d2, stack);
               entityitem.delayBeforeCanPickup = 10;
               world.spawnEntityInWorld(entityitem);
           }
           world.playSound((double)x, (double)y, (double)z, Reference.MOD_ID + ":item.sweet_berries.pick_from_bush", 1.0F, 0.8F + world.rand.nextFloat() * 0.4F, false);
           world.setBlockMetadataWithNotify(x, y, z, 1, 2);
           return true;
        }
        return false;
    }
    
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        int count = metadata - world.rand.nextInt(2);
        for(int i = 0; i < count && metadata > 1; i++)
        {
            Item item = getItemDropped(metadata, world.rand, fortune);
            if (item != null)
            {
                ret.add(new ItemStack(item, 1, damageDropped(metadata)));
            }
        }
        return ret;
    }
    

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return ModItems.sweet_berries;
    }
    
	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return null;
	}

	@Override
	public int[] getFireInfo() {
		return new int[] {60, 100};
	}

}
