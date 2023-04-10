package ru.leonidm.commons.tests.reflection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import ru.leonidm.commons.reflection.ClassAnalyzeUtils;
import ru.leonidm.commons.text.StringUtils;

import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class ClassAnalyzeTest {

    @Test
    public void classAnalyze() {
        assertEquals(Integer.class, ClassAnalyzeUtils.findClosestCommonSuperclass(Integer.class, Integer.class));

        assertEquals(Number.class, ClassAnalyzeUtils.findClosestCommonSuperclass(Integer.class, Float.class));
        assertEquals(Number.class, ClassAnalyzeUtils.findClosestCommonSuperclass(Float.class, Integer.class));
        assertEquals(Number.class, ClassAnalyzeUtils.getSuperclassOfElements(List.of(1, (byte) 2, (float) 3, (double) 4, (short) 5)));

        assertEquals(Vector.class, ClassAnalyzeUtils.findClosestCommonSuperclass(Stack.class, Vector.class));
        assertEquals(Vector.class, ClassAnalyzeUtils.findClosestCommonSuperclass(Vector.class, Stack.class));
        assertEquals(Vector.class, ClassAnalyzeUtils.getSuperclassOfElements(List.of(new Vector<>(), new Stack<>())));
    }
}
