package ru.leonidm.commons.tests.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import ru.leonidm.commons.text.StringUtils;
import ru.leonidm.commons.text.TextCase;

public class TextCaseTest {

    @Test
    public void textCase() {
        String a = "snake_case";
        String b = "SNAKE_CASE";
        assertEquals(TextCase.SNAKE, TextCase.from(a), a);
        assertEquals(TextCase.SNAKE, TextCase.from(b), b);

        String c = "PascalCase";
        assertEquals(TextCase.PASCAL, TextCase.from(c), c);

        String d = "camelCase";
        assertEquals(TextCase.CAMEL, TextCase.from(d), d);

        String e = "Bad case";
        assertNull(TextCase.from(e), e);
    }
}
