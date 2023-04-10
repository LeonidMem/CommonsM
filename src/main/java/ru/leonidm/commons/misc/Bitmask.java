package ru.leonidm.commons.misc;

public final class Bitmask {

    private Bitmask() {

    }

    public static int readInt(int bitmask, int bit) {
        return bitmask >> bit & 1;
    }

    public static boolean read(int bitmask, int bit) {
        return readInt(bitmask, bit) == 1;
    }

    public static int write(int bitmask, int bit, boolean value) {
        return value ? bitmask | (int) Math.pow(2, bit) : bitmask & ~((int) Math.pow(2, bit));
    }

    public static int switchBit(int bitmask, int bit) {
        return write(bitmask, bit, !read(bitmask, bit));
    }
}
