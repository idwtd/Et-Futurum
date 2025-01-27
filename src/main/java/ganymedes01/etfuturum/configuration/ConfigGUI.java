package ganymedes01.etfuturum.configuration;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import ganymedes01.etfuturum.lib.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

public class ConfigGUI extends GuiConfig {

    public ConfigGUI(GuiScreen parent) {
        super(parent, getElements(), Reference.MOD_ID, Reference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.INSTANCE.cfg.toString()));
    }

    @SuppressWarnings({ "rawtypes" })
    private static List<IConfigElement> getElements() {
        List<IConfigElement> list = new ArrayList<IConfigElement>();
        for (String category : ConfigurationHandler.usedCategories)
            list.add(new ConfigElement(ConfigurationHandler.INSTANCE.cfg.getCategory(category)));
        return list;
    }
}