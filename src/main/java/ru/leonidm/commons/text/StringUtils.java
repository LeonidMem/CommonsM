package ru.leonidm.commons.text;

import org.jetbrains.annotations.NotNull;

public final class StringUtils {

    private static final int[] INDEXES = {2, 0, 1, 1, 1, 2};

    private StringUtils() {

    }

    /**
     * Declension of nouns in russian language for needed number
     * @param words in format ["предмет", "предмета", "предметов"]
     */
    @NotNull
    public static String getRuNounEnding(int number, @NotNull String @NotNull [] words) {
        return words[
                (number % 100 > 4 && number % 100 < 20) ? 2 : INDEXES[(number % 10 < 5) ? Math.abs(number) % 10 : 5]
                ];
    }
}
