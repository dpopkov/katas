package learn.katas.corejava.generics.simple;

public class ArrayAlg {
    // DONE: Implement generic method returning generic result
    /** Gets the minimum and maximum of an array of elements. */
    public static <T extends Comparable<T>> Pair<T> minMax(T[] data) {
        T min = data[0];
        T max = data[0];
        for (T value : data) {
            if (value.compareTo(min) < 0) {
                min = value;
            }
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        return new Pair<>(min, max);
    }

    // DONE: Implement generic method returning generic result
    /** Gets the minimum and maximum of an array of char sequences and counts chars. */
    public static <T extends Comparable<T> & CharSequence> Three<T, Long> minMaxCount(T[] data) {
        T min = data[0];
        T max = data[0];
        long count = 0;
        for (T value : data) {
            if (value.compareTo(min) < 0) {
                min = value;
            }
            if (value.compareTo(max) > 0) {
                max = value;
            }
            count += value.length();
        }
        return new Three<>(min, max, count);
    }
}
