package ganymedes01.etfuturum.items;

import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.IConfigurable;
import ganymedes01.etfuturum.configuration.ConfigurationHandler;
import ganymedes01.etfuturum.core.utils.Utils;
import net.minecraft.item.ItemFood;

public class MuttonRaw extends ItemFood  implements IConfigurable{

    public MuttonRaw() {
        super(2, 0.3F, true);
        setTextureName("mutton_raw");
        setUnlocalizedName(Utils.getUnlocalisedName("mutton_raw"));
        setCreativeTab(isEnabled() ? EtFuturum.creativeTabItems : null);
    }
    
    @Override
    public boolean isEnabled() {
        return ConfigurationHandler.enableMutton;
    }
}