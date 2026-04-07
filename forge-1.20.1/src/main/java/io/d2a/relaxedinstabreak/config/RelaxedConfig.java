package io.d2a.relaxedinstabreak.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class RelaxedConfig {

    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue ALWAYS_ENABLED;
    public static final ForgeConfigSpec.BooleanValue REVERSED;
    public static final ForgeConfigSpec.IntValue DELAY;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("general");

        ALWAYS_ENABLED = builder
                .comment("If enabled, the block-breaking cooldown is always active")
                .define("alwaysEnabled", false);

        REVERSED = builder
                .comment("If enabled, the cooldown is active when NOT sneaking instead of when sneaking")
                .define("reversed", false);

        DELAY = builder
                .comment("Cooldown in ticks after each block break (1-20, default: 5)")
                .defineInRange("delay", 5, 1, 20);

        builder.pop();
        SPEC = builder.build();
    }

    public static boolean alwaysEnabled() {
        return ALWAYS_ENABLED.get();
    }

    public static boolean isReversed() {
        return REVERSED.get();
    }

    public static int getDelay() {
        return DELAY.get();
    }
}
