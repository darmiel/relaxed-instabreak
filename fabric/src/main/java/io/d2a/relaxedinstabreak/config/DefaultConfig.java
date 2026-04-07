package io.d2a.relaxedinstabreak.config;

public class DefaultConfig implements RelaxedConfig {

    @Override
    public boolean alwaysEnabled() {
        return false;
    }

    @Override
    public boolean isReversed() {
        return false;
    }

    @Override
    public int getDelay() {
        return 5; // creative mode has a default delay of 5
    }

}
