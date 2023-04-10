package ru.leonidm.commons.reflection;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Objects;

public final class ClassAnalyzeUtils {

    private ClassAnalyzeUtils() {
    }

    @NotNull
    public static Class<?> getSuperclassOfElements(@NotNull Collection<?> collection) {
        Class<?> currentSuperClass = null;
        for (Object element : collection) {
            if (currentSuperClass == null) {
                currentSuperClass = element.getClass();
            } else {
                currentSuperClass = findClosestCommonSuperclass(currentSuperClass, element.getClass());
            }
        }

        return Objects.requireNonNullElse(currentSuperClass, Object.class);
    }

    @NotNull
    public static Class<?> findClosestCommonSuperclass(@NotNull Class<?> a, @NotNull Class<?> b) {
        while (!a.isAssignableFrom(b)) {
            a = a.getSuperclass();
        }

        return a;
    }
}
