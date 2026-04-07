package io.d2a.relaxedinstabreak.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class RelaxedConfig {

    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.BooleanValue ALWAYS_ENABLED;
    public static final ModConfigSpec.BooleanValue REVERSED;
    public static final ModConfigSpec.IntValue DELAY;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

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
