package ganymedes01.etfuturum.blocks;

import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.IConfigurable;
import ganymedes01.etfuturum.ModBlocks.IBurnableBlock;
import ganymedes01.etfuturum.configuration.ConfigurationHandler;
import ganymedes01.etfuturum.core.utils.Utils;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWoodFenceGate extends BlockFenceGate implements IBurnableBlock, IConfigurable {

    private final int meta;

    public BlockWoodFenceGate(int meta) {
        this.meta = meta;
        setHardness(2.0F);
        setResistance(5.0F);
        setStepSound(soundTypeWood);
        setBlockName(Utils.getUnlocalisedName("fence_gate_" + BlockWoodDoor.names[meta]));
        setCreativeTab(isEnabled() ? EtFuturum.creativeTabBlocks : null);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return Blocks.planks.getIcon(side, this.meta);
    }

    @Override
    public boolean isEnabled() {
        return ConfigurationHandler.enableFences;
    }
    
	@Override
	public int[] getFireInfo() {
		if(meta < 6 && ConfigurationHandler.enableBurnableBlocks)
			return new int[]{5, 20};
		return null;
	}
}