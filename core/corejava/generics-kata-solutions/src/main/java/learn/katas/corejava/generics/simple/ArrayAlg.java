package learn.katas.corejava.generics.simple;

public class ArrayAlg {
    // TODO: Implement generic method returning generic result
    /** Gets the minimum and maximum of an array of strings. */
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
}
