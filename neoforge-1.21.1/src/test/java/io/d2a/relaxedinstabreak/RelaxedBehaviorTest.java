package io.d2a.relaxedinstabreak;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelaxedBehaviorTest {

    @Nested
    @DisplayName("alwaysEnabled = true")
    class AlwaysEnabled {

        @Test
        @DisplayName("returns true regardless of other settings")
        void alwaysReturnsTrue() {
            assertTrue(RelaxedBehavior.isEnabled(true, false, false));
            assertTrue(RelaxedBehavior.isEnabled(true, false, true));
            assertTrue(RelaxedBehavior.isEnabled(true, true, false));
            assertTrue(RelaxedBehavior.isEnabled(true, true, true));
        }
    }

    @Nested
    @DisplayName("default behavior (reversed = false)")
    class DefaultBehavior {

        @Test
        @DisplayName("enabled when sneaking")
        void enabledWhenSneaking() {
            assertTrue(RelaxedBehavior.isEnabled(false, false, true));
        }

        @Test
        @DisplayName("disabled when not sneaking")
        void disabledWhenNotSneaking() {
            assertFalse(RelaxedBehavior.isEnabled(false, false, false));
        }
    }

    @Nested
    @DisplayName("reversed behavior (reversed = true)")
    class ReversedBehavior {

        @Test
        @DisplayName("enabled when NOT sneaking")
        void enabledWhenNotSneaking() {
            assertTrue(RelaxedBehavior.isEnabled(false, true, false));
        }

        @Test
        @DisplayName("disabled when sneaking")
        void disabledWhenSneaking() {
            assertFalse(RelaxedBehavior.isEnabled(false, true, true));
        }
    }
}
