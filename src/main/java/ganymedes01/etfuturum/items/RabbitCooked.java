package ganymedes01.etfuturum.items;

import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.IConfigurable;
import ganymedes01.etfuturum.configuration.ConfigurationHandler;
import ganymedes01.etfuturum.core.utils.Utils;
import net.minecraft.item.ItemFood;

public class RabbitCooked extends ItemFood implements IConfigurable {

    public RabbitCooked() {
        super(5, 0.6F, true);
        setTextureName("rabbit_cooked");
        setUnlocalizedName(Utils.getUnlocalisedName("rabbit_cooked"));
        setCreativeTab(isEnabled() ? EtFuturum.creativeTabItems : null);
    }

    @Override
    public boolean isEnabled() {
        return ConfigurationHandler.enableRabbit;
    }
}