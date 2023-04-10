package ru.leonidm.commons.tests.text;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import ru.leonidm.commons.text.StringUtils;

public class StringUtilsTest {

    @Test
    public void ruNounEnding() {
        String[] words = {"предмет", "предмета", "предметов"};

        assertEquals("предмет", StringUtils.getRuNounEnding(1, words));
        for (int i = 2; i <= 4; i++) {
            assertEquals("предмета", StringUtils.getRuNounEnding(i, words));
        }

        for (int i = 5; i <= 19; i++) {
            assertEquals("предметов", StringUtils.getRuNounEnding(i, words));
        }

        for (int i = 2; i < 10; i++) {
            assertEquals("предметов", StringUtils.getRuNounEnding(i * 10, words));
            assertEquals("предмет", StringUtils.getRuNounEnding(i * 10 + 1, words));

            for (int j = 2; j <= 4; j++) {
                assertEquals("предмета", StringUtils.getRuNounEnding(j, words));
            }

            for (int j = 5; j <= 10; j++) {
                assertEquals("предметов", StringUtils.getRuNounEnding(j, words));
            }
        }
    }
}
