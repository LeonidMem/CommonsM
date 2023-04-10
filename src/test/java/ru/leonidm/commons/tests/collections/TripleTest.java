package ru.leonidm.commons.tests.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.Test;

public class TripleTest {

    @Test
    public void triple() {
        Object a = "a";
        Object b = 1;
        Object c = (byte) 2;

        var triple = Triple.of(a, b, c);

        assertEquals(a, triple.getLeft());
        assertEquals(b, triple.getMiddle());
        assertEquals(c, triple.getRight());
    }
}
