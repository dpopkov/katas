package learn.katas.corejava.generics.simple;

// TODO: Implement simple generic class
public class Pair<T> {

    private final T first;
    private final T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    T getFirst() {
        return first;
    }

    T getSecond() {
        return second;
    }
}
