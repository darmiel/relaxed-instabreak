package io.d2a.relaxedinstabreak.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "relaxed-instabreak")
public class ClothConfig implements RelaxedConfig, ConfigData {

    @ConfigEntry.Gui.Tooltip
    private boolean alwaysEnabled = false;

    @ConfigEntry.Gui.Tooltip
    private boolean reversed = false;

    @ConfigEntry.Gui.Tooltip(count = 2)
    @ConfigEntry.BoundedDiscrete(min = 1, max = 20)
    private int delay = 5;

    @Override
    public boolean alwaysEnabled() {
        return this.alwaysEnabled;
    }

    @Override
    public boolean isReversed() {
        return this.reversed;
    }

    @Override
    public int getDelay() {
        return this.delay;
    }

}
