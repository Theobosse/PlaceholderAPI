package fr.theobosse.papi;

import cn.nukkit.plugin.PluginBase;

public class PlaceholderAPI extends PluginBase {

    public static PlaceholderAPI instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    public static PlaceholderAPI getInstance() {
        return instance;
    }

}
