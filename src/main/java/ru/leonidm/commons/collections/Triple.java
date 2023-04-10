package ru.leonidm.commons.collections;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public final class Triple<A, B, C> {

    private A a;
    private B b;
    private C c;

    public Triple(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @NotNull
    public static <A, B, C> Triple<A, B, C> of(A a, B b, C c) {
        return new Triple<>(a, b, c);
    }

    public A getLeft() {
        return a;
    }

    public void setLeft(A a) {
        this.a = a;
    }

    public B getMiddle() {
        return b;
    }

    public void setMiddle(B b) {
        this.b = b;
    }

    public C getRight() {
        return c;
    }

    public void setRight(C c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Triple{" + a + ", " + b + ", " + c + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
        return Objects.equals(a, triple.a) && Objects.equals(b, triple.b) && Objects.equals(c, triple.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}
