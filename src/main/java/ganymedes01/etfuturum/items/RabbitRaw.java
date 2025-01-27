package ganymedes01.etfuturum.items;

import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.IConfigurable;
import ganymedes01.etfuturum.configuration.ConfigurationHandler;
import ganymedes01.etfuturum.core.utils.Utils;
import net.minecraft.item.ItemFood;

public class RabbitRaw extends ItemFood implements IConfigurable {

    public RabbitRaw() {
        super(3, 0.3F, true);
        setTextureName("rabbit_raw");
        setUnlocalizedName(Utils.getUnlocalisedName("rabbit_raw"));
        setCreativeTab(isEnabled() ? EtFuturum.creativeTabItems : null);
    }

    @Override
    public boolean isEnabled() {
        return ConfigurationHandler.enableRabbit;
    }
}