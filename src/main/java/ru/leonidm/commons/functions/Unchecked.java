package ru.leonidm.commons.functions;

import org.jetbrains.annotations.NotNull;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class Unchecked {

    private Unchecked() {

    }

    public static <T, R> Function<T, R> function(@NotNull UncheckedFunction<T, R> function) {
        return t -> {
            try {
                return function.apply(t);
            } catch (Exception e) {
                throw new UncheckedException(e);
            }
        };
    }

    public static <T, U, R> BiFunction<T, U, R> biFunction(@NotNull UncheckedBiFunction<T, U, R> function) {
        return (t, u) -> {
            try {
                return function.apply(t, u);
            } catch (Exception e) {
                throw new UncheckedException(e);
            }
        };
    }

    public static <T> Predicate<T> predicate(@NotNull UncheckedPredicate<T> predicate) {
        return t -> {
            try {
                return predicate.test(t);
            } catch (Exception e) {
                throw new UncheckedException(e);
            }
        };
    }

    public static <T, U> BiPredicate<T, U> biPredicate(@NotNull UncheckedBiPredicate<T, U> predicate) {
        return (t, u) -> {
            try {
                return predicate.test(t, u);
            } catch (Exception e) {
                throw new UncheckedException(e);
            }
        };
    }

    public static <T> Consumer<T> consumer(@NotNull UncheckedConsumer<T> consumer) {
        return t -> {
            try {
                consumer.accept(t);
            } catch (Exception e) {
                throw new UncheckedException(e);
            }
        };
    }

    public static <T> Supplier<T> supplier(@NotNull UncheckedSupplier<T> supplier) {
        return () -> {
            try {
                return supplier.get();
            } catch (Exception e) {
                throw new UncheckedException(e);
            }
        };
    }

    @FunctionalInterface
    public interface UncheckedFunction<T, R> {
        @SuppressWarnings("java:S112")
        // Подавление варнинга на Exception, а не более конкретный тип
        R apply(T t) throws Exception;
    }

    @FunctionalInterface
    public interface UncheckedBiFunction<T, U, R> {
        @SuppressWarnings("java:S112")
        // Подавление варнинга на Exception, а не более конкретный тип
        R apply(T t, U u) throws Exception;
    }

    @FunctionalInterface
    public interface UncheckedPredicate<T> {
        @SuppressWarnings("java:S112")
        // Подавление варнинга на Exception, а не более конкретный тип
        boolean test(T t) throws Exception;
    }

    @FunctionalInterface
    public interface UncheckedBiPredicate<T, U> {
        @SuppressWarnings("java:S112")
        // Подавление варнинга на Exception, а не более конкретный тип
        boolean test(T t, U u) throws Exception;
    }

    @FunctionalInterface
    public interface UncheckedConsumer<T> {
        @SuppressWarnings("java:S112")
        // Подавление варнинга на Exception, а не более конкретный тип
        void accept(T t) throws Exception;
    }

    @FunctionalInterface
    public interface UncheckedSupplier<T> {
        @SuppressWarnings("java:S112")
        // Подавление варнинга на Exception, а не более конкретный тип
        T get() throws Exception;
    }
}
