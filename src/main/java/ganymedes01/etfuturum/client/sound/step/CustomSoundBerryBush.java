package ganymedes01.etfuturum.client.sound.step;

import ganymedes01.etfuturum.lib.Reference;
import net.minecraft.block.Block.SoundType;

public class CustomSoundBerryBush extends SoundType {

	public CustomSoundBerryBush(String p_i45393_1_, float p_i45393_2_, float p_i45393_3_) {
		super(p_i45393_1_, p_i45393_2_, p_i45393_3_);
	}

	@Override
	public String getBreakSound() {
		return Reference.MOD_ID + ":" + super.getBreakSound();
	}

	@Override
	public String getStepResourcePath() {
		return Reference.MOD_ID + ":" + super.getStepResourcePath();
	}

    public String func_150496_b()
    {
        return Reference.MOD_ID + ":" + "place." + soundName;
    }
}
