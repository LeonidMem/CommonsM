package ru.leonidm.commons.tests.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import ru.leonidm.commons.collections.Pair;

public class PairTest {

    @Test
    public void pair() {
        Object a = "a";
        Object b = 1;

        var pair = Pair.of(a, b);

        assertEquals(a, pair.getLeft());
        assertEquals(b, pair.getRight());
    }
}
