package ru.leonidm.commons.tests.misc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import ru.leonidm.commons.misc.Bitmask;
import ru.leonidm.commons.misc.RomanNumber;

public class RomanNumberTest {

    @Test
    public void romanNumber() {
        assertEquals("I", RomanNumber.toRoman(1));
        assertEquals("II", RomanNumber.toRoman(2));
        assertEquals("III", RomanNumber.toRoman(3));
        assertEquals("IV", RomanNumber.toRoman(4));
        assertEquals("V", RomanNumber.toRoman(5));
        assertEquals("VI", RomanNumber.toRoman(6));
        assertEquals("VII", RomanNumber.toRoman(7));
        assertEquals("VIII", RomanNumber.toRoman(8));
        assertEquals("IX", RomanNumber.toRoman(9));
        assertEquals("X", RomanNumber.toRoman(10));
    }
}
