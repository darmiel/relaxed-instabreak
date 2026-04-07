package io.d2a.relaxedinstabreak;

/**
 * Pure behavior logic for the relaxed instabreak feature.
 * Separated from MC-dependent code for testability.
 */
public final class RelaxedBehavior {

    private RelaxedBehavior() {}

    /**
     * Determines whether the relaxed instabreak cooldown should be applied.
     *
     * @param alwaysEnabled config: always apply cooldown regardless of sneak state
     * @param reversed      config: invert the sneak toggle (cooldown when NOT sneaking)
     * @param sneaking      whether the player is currently sneaking
     * @return true if the cooldown should be applied
     */
    public static boolean isEnabled(boolean alwaysEnabled, boolean reversed, boolean sneaking) {
        if (alwaysEnabled) {
            return true;
        }
        return sneaking != reversed;
    }
}
