package io.d2a.relaxedinstabreak.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "relaxed-instabreak")
public class ClothConfig implements RelaxedConfig, ConfigData {

    @ConfigEntry.Gui.Tooltip
    private boolean reversed;

    @Override
    public boolean isReversed() {
        return this.reversed;
    }

}
