package ganymedes01.etfuturum.world.nether.dimension;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.chunk.IChunkProvider;

public class NetherWorldProvider extends WorldProviderHell {
	@Override
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new NetherWorldChunkManager(worldObj);
		this.isHellWorld = true;
		this.hasNoSky = true;
		this.dimensionId = -1;
	}

	@Override
	public IChunkProvider createChunkGenerator() {
//		if (WorldgenConfiguration.BigNether) {
//			return new MaxHeightNetherChunkProvider(this.worldObj, this.worldObj.getSeed());
//		} else {
			return new NetherChunkProvider(this.worldObj, this.worldObj.getSeed());
//		}
	}
	
//	@Override
//	protected void generateLightBrightnessTable() {
//		float minBrightness = (float) (1.0F / 10000000.0F * Math.pow(75, 3.2F) + 0.002F);
//		for(int i = 0; i <= 15; i++) {
//			float f1 = 1F - (i*i) / (15F*15F);
//			this.lightBrightnessTable[i] = ((1F - f1) / (f1 * 6F + 1F) * (1F - minBrightness) + minBrightness);
//		}
//		System.arraycopy(this.lightBrightnessTable, 0, new float[16], 0, 16);
//	}

//	@SideOnly(Side.CLIENT)
//    public boolean getWorldHasVoidParticles()
//    {
//        return true;
//    }
	
	@Override
	public boolean canRespawnHere() {
		return false;
	}

	@Override
	public boolean canCoordinateBeSpawn(int x, int z) {
		if (this.worldObj.getTopBlock(x, z) == Blocks.bedrock || this.worldObj.getTopBlock(x, z) == Blocks.air) {
			return false;
		}
		return true;
	}

	@Override
	public int getRespawnDimension(EntityPlayerMP player) {
//		if (NetherliciousConfiguration.canRespawnInNether) {
//			ChunkCoordinates coords = player.getBedLocation(-1);
//			if (coords != null)
//				return -1;
//		} // Nether spawn system is shid
		return super.getRespawnDimension(player);

	}

	public int getActualHeight() {
		return 128;
	}

}