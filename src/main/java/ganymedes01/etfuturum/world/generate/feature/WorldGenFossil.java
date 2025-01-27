package ganymedes01.etfuturum.world.generate.feature;

import java.util.Random;

import ganymedes01.etfuturum.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenFossil extends WorldGenerator {
	
	public static Block bone = ModBlocks.bone_block;
	
	public WorldGenFossil(Random rand) {
	}

	public boolean generateSpecificFossil(World world, Random random, int x, int y, int z, boolean rotated, int type, boolean hasCoal) {
		Fossil fossil = getFossilFromType(type);
		if(fossil != null) {
			fossil.build(world, random, x, y, z, type, rotated, hasCoal);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		return this.generateSpecificFossil(world, random, x, y, z, random.nextInt(2) == 1, random.nextInt(8), random.nextInt(2) == 1);
	}

	public Fossil getFossilFromType(int i) {
		switch(i) {
		case 0: return new Fossil_Skull_1();
		case 1: return new Fossil_Skull_2();
		case 2: return new Fossil_Skull_3();
		case 3: return new Fossil_Skull_4();
		case 4: return new Fossil_Spine_1();
		case 5: return new Fossil_Spine_2();
		case 6: return new Fossil_Spine_3();
		case 7: return new Fossil_Spine_4();
		default: return null;
		}
	}
	
public static abstract class Fossil {
	
	public Fossil() {
	}
	
	public void fillBlocks(World world, Block block, int x, int y, int z, int xfrom, int yfrom, int zfrom, int xto, int yto, int zto, int meta, int flag, boolean hasCoal, Random rand) {
		for(int i = x + xfrom; i < x + xfrom + xto; i++) {
			for(int j = y + yfrom; j < y + yfrom + yto; j++) {
				for(int k = z + zfrom; k < z + zfrom + zto; k++) {
					if(world.getBlock(i, j, k) == null || world.getBlock(i, j, k).getBlockHardness(world, i, j, k) > -1) {
						if(rand.nextFloat() < 0.9) {
							if(hasCoal && rand.nextFloat() > 0.9) {
								world.setBlock(i, j, k, Blocks.coal_ore, 0, flag);
							} else {
								world.setBlock(i, j, k, block, meta, flag);
							}
						}
					}
				}
			}
		}
	}
	
	public abstract void build(World world, Random rand, int x, int y, int z, int type, boolean rotated, boolean hasCoal);
	
//	public abstract int[] getCorners();
}

public class Fossil_Skull_1 extends Fossil {

	@Override
	public void build(World world, Random rand, int x, int y, int z, int type, boolean rotated, boolean hasCoal) {
		int rotation = rotated ? 8 : 4;
		int rotation2 = ~rotation & 8;
		fillBlocks(world, bone, x, y, z, 1, 0, 1, 4, 1, 3, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 0, 4, 1, 1, 2, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 0, 4, 1, 1, 2, rotation, 3, hasCoal, rand);

		fillBlocks(world, bone, x, y, z, 0, 1, 2, 1, 3, 3, rotation2, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 5, 1, 2, 1, 3, 3, rotation2, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 1, 1, 0, 1, 1, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 1, 0, 1, 1, 1, 0, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 1, 2, 0, 4, 1, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 2, 3, 0, 2, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 4, 1, 4, 1, 5, rotation, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 0, 1, 1, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 1, 5, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 5, 1, 1, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 5, 1, 5, 1, 3, 1, 0, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 1, 1, 6, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 2, 1, 6, 2, 3, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 1, 6, 1, 3, 1, 0, 3, hasCoal, rand);
	}
}

public class Fossil_Skull_2 extends Fossil {

	@Override
	public void build(World world, Random rand, int x, int y, int z, int type, boolean rotated, boolean hasCoal) {
		int rotation = rotated ? 8 : 4;
		int rotation2 = ~rotation & 8;
		fillBlocks(world, bone, x, y, z, 1, 0, 1, 5, 1, 3, rotation, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 1, 1, 4, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 2, 1, 4, 3, 3, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 5, 1, 4, 1, 3, 1, 0, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 6, 1, 1, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 6, 1, 2, 1, 3, 1, rotation2, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 6, 1, 3, 1, 3, 1, 0, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 0, 1, 1, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 1, 2, 1, 3, 1, rotation2, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 1, 3, 1, 3, 1, 0, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 1, 1, 0, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 2, 2, 0, 3, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 3, 3, 0, 1, 1, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 2, 4, 0, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 4, 0, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 5, 1, 0, 1, 3, 1, 0, 3, hasCoal, rand);

		fillBlocks(world, bone, x, y, z, 1, 4, 1, 5, 1, 3, rotation, 3, hasCoal, rand);
	}
}

public class Fossil_Skull_3 extends Fossil {

	@Override
	public void build(World world, Random rand, int x, int y, int z, int type, boolean rotated, boolean hasCoal) {
		int rotation = rotated ? 8 : 4;
		int rotation2 = ~rotation & 8;
		fillBlocks(world, bone, x, y, z, 1, 0, 1, 3, 1, 4, rotation, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 0, 0, 0, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 1, 0, 3, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 2, 2, 0, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 0, 0, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 1, 4, 3, 2, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 1, 4, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 1, 1, 1, 2, 3, rotation2, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 1, 4, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 1, 1, 1, 2, 3, rotation2, 3, hasCoal, rand);

		fillBlocks(world, bone, x, y, z, 4, 3, 0, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 3, 0, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 3, 0, 3, 1, 4, rotation, 3, hasCoal, rand);
	}
}

public class Fossil_Skull_4 extends Fossil {

	@Override
	public void build(World world, Random rand, int x, int y, int z, int type, boolean rotated, boolean hasCoal) {
		int rotation = rotated ? 8 : 4;
		int rotation2 = ~rotation & 8;
		fillBlocks(world, bone, x, y, z, 1, 0, 1, 2, 1, 2, rotation, 3, hasCoal, rand);

		fillBlocks(world, bone, x, y, z, 0, 0, 0, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 1, 0, 2, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 3, 0, 0, 1, 3, 1, 0, 3, hasCoal, rand);

		fillBlocks(world, bone, x, y, z, 3, 1, 1, 1, 2, 2, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 1, 1, 1, 2, 2, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 1, 3, 2, 2, 1, 0, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 1, 3, 0, 2, 1, 3, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 3, 0, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 3, 3, 0, 1, 1, 1, rotation, 3, hasCoal, rand);
	}
}

public class Fossil_Spine_1 extends Fossil {

	@Override
	public void build(World world, Random rand, int x, int y, int z, int type, boolean rotated, boolean hasCoal) {
		int rotation = rotated ? 8 : 4;
		int rotation2 = ~rotation & 8;
		
		fillBlocks(world, bone, x, y, z, 0, 0, 1, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 0, 3, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 0, 5, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 0, 7, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 0, 9, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 0, 11, 1, 2, 1, 0, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 2, 0, 1, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 2, 0, 3, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 2, 0, 5, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 2, 0, 7, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 2, 0, 9, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 2, 0, 11, 1, 2, 1, 0, 3, hasCoal, rand);

		fillBlocks(world, bone, x, y, z, 1, 2, 0, 1, 1, 13, rotation2, 3, hasCoal, rand);
	}
}

public class Fossil_Spine_2 extends Fossil {

	@Override
	public void build(World world, Random rand, int x, int y, int z, int type, boolean rotated, boolean hasCoal) {
		int rotation = rotated ? 8 : 4;
		int rotation2 = ~rotation & 8;
		
		fillBlocks(world, bone, x, y, z, 1, 0, 1, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 0, 3, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 0, 5, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 0, 7, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 0, 9, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 0, 11, 1, 1, 1, rotation, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 3, 0, 1, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 3, 0, 3, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 3, 0, 5, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 3, 0, 7, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 3, 0, 9, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 3, 0, 11, 1, 1, 1, rotation, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 1, 3, 1, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 3, 3, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 3, 5, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 3, 7, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 3, 9, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 3, 11, 1, 1, 1, rotation, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 3, 3, 1, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 3, 3, 3, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 3, 3, 5, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 3, 3, 7, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 3, 3, 9, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 3, 3, 11, 1, 1, 1, rotation, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 0, 1, 1, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 1, 3, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 1, 5, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 1, 7, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 1, 9, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 1, 11, 1, 2, 1, 0, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 4, 1, 1, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 1, 3, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 1, 5, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 1, 7, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 1, 9, 1, 2, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 1, 11, 1, 2, 1, 0, 3, hasCoal, rand);

		fillBlocks(world, bone, x, y, z, 2, 3, 0, 1, 1, 13, rotation2, 3, hasCoal, rand);
	}
}

public class Fossil_Spine_3 extends Fossil {

	@Override
	public void build(World world, Random rand, int x, int y, int z, int type, boolean rotated, boolean hasCoal) {
		int rotation = rotated ? 8 : 4;
		int rotation2 = ~rotation & 8;
		
		fillBlocks(world, bone, x, y, z, 0, 0, 1, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 0, 3, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 0, 5, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 0, 7, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 0, 9, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 0, 11, 1, 3, 1, 0, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 6, 0, 1, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 6, 0, 3, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 6, 0, 5, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 6, 0, 7, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 6, 0, 9, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 6, 0, 11, 1, 3, 1, 0, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 1, 0, 1, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 0, 3, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 0, 5, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 0, 7, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 0, 9, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 0, 11, 1, 1, 1, rotation, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 5, 0, 1, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 5, 0, 3, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 5, 0, 5, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 5, 0, 7, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 5, 0, 9, 1, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 5, 0, 11, 1, 1, 1, rotation, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 0, 3, 1, 3, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 3, 3, 3, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 3, 5, 3, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 3, 7, 3, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 3, 9, 3, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 3, 11, 3, 1, 1, rotation, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 4, 3, 1, 3, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 3, 3, 3, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 3, 5, 3, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 3, 7, 3, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 3, 9, 3, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 4, 3, 11, 3, 1, 1, rotation, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 3, 3, 0, 1, 1, 13, rotation2, 3, hasCoal, rand);
	}
}

public class Fossil_Spine_4 extends Fossil {

	@Override
	public void build(World world, Random rand, int x, int y, int z, int type, boolean rotated, boolean hasCoal) {
		int rotation = rotated ? 8 : 4;
		int rotation2 = ~rotation & 8;
		
		fillBlocks(world, bone, x, y, z, 1, 0, 1, 2, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 0, 3, 2, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 0, 5, 2, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 0, 7, 2, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 0, 9, 2, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 1, 0, 11, 2, 1, 1, rotation, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 6, 0, 1, 2, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 6, 0, 3, 2, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 6, 0, 5, 2, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 6, 0, 7, 2, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 6, 0, 9, 2, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 6, 0, 11, 2, 1, 1, rotation, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 0, 1, 1, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 1, 3, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 1, 5, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 1, 7, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 1, 9, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 1, 11, 1, 3, 1, 0, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 8, 1, 1, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 8, 1, 3, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 8, 1, 5, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 8, 1, 7, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 8, 1, 9, 1, 3, 1, 0, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 8, 1, 11, 1, 3, 1, 0, 3, hasCoal, rand);

		fillBlocks(world, bone, x, y, z, 0, 4, 1, 4, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 4, 3, 4, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 4, 5, 4, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 4, 7, 4, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 4, 9, 4, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 0, 4, 11, 4, 1, 1, rotation, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 5, 4, 1, 4, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 5, 4, 3, 4, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 5, 4, 5, 4, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 5, 4, 7, 4, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 5, 4, 9, 4, 1, 1, rotation, 3, hasCoal, rand);
		fillBlocks(world, bone, x, y, z, 5, 4, 11, 4, 1, 1, rotation, 3, hasCoal, rand);
		
		fillBlocks(world, bone, x, y, z, 4, 4, 0, 1, 1, 13, rotation2, 3, hasCoal, rand);
	}
}
}
