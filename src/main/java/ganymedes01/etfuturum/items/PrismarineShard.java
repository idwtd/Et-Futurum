package ganymedes01.etfuturum.items;

import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.IConfigurable;
import ganymedes01.etfuturum.configuration.ConfigurationHandler;
import ganymedes01.etfuturum.core.utils.Utils;
import net.minecraft.item.Item;

public class PrismarineShard extends Item implements IConfigurable {

    public PrismarineShard() {
        setTextureName("prismarine_shard");
        setUnlocalizedName(Utils.getUnlocalisedName("prismarine_shard"));
        setCreativeTab(isEnabled() ? EtFuturum.creativeTabItems : null);
    }

    @Override
    public boolean isEnabled() {
        return ConfigurationHandler.enablePrismarine;
    }
}