package learn.katas.corejava.generics.simple;

public class Three<T, U> {
    private final T first;
    private final T second;
    private final U third;

    public Three(T first, T second, U third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public U getThird() {
        return third;
    }
}
