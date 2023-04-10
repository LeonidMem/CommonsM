package ru.leonidm.commons.tests.misc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import ru.leonidm.commons.misc.Bitmask;

public class BitmaskTest {

    @Test
    public void bitmask() {
        int bitmask = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < i; j++) {
                assertTrue(Bitmask.read(bitmask, j));
            }

            for (int j = i; j < 32; j++) {
                assertFalse(Bitmask.read(bitmask, j));
            }

            bitmask = Bitmask.write(bitmask, i, true);
        }
    }
}
