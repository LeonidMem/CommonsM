package ru.leonidm.commons.misc;

import org.jetbrains.annotations.NotNull;

import java.util.TreeMap;

public final class RomanNumber {

    private static final TreeMap<Integer, String> MAP = new TreeMap<>();

    static {
        MAP.put(1000, "M");
        MAP.put(900, "CM");
        MAP.put(500, "D");
        MAP.put(400, "CD");
        MAP.put(100, "C");
        MAP.put(90, "XC");
        MAP.put(50, "L");
        MAP.put(40, "XL");
        MAP.put(10, "X");
        MAP.put(9, "IX");
        MAP.put(5, "V");
        MAP.put(4, "IV");
        MAP.put(1, "I");
    }

    private RomanNumber() {

    }

    @NotNull
    public static String toRoman(int number) {
        StringBuilder builder = new StringBuilder();

        while (number > 0) {
            int l = MAP.floorKey(number);
            builder.append(MAP.get(l));
            number -= l;
        }

        return builder.toString();
    }

}
