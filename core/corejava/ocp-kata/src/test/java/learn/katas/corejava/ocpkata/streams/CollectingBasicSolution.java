package learn.katas.corejava.ocpkata.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectingBasicSolution {

    private final List<String> animals = List.of("lions", "tigers", "bears");
    private Stream<String> stream;

    @BeforeEach
    void setUp() {
        stream = animals.stream();
    }

    @Test
    void collectToString() {
        // Implement: collect values from stream into resulting string divided by ","
        String collected = stream.collect(Collectors.joining(","));
        String expected = "lions,tigers,bears";
        assertEquals(expected, collected);
    }

    @Test
    void collectToAverage() {
        // Implement: collect values from stream into average length of values.
        Double averageLength = stream.collect(Collectors.averagingInt(String::length));
        double expected = 5.333;
        assertEquals(expected, averageLength, 1e-3);
    }

    @Test
    void collectToCollection() {
        // Implement: collect values from stream into TreeSet.
        TreeSet<String> collectedSet = stream.collect(Collectors.toCollection(TreeSet::new));
        TreeSet<String> expected = new TreeSet<>(animals);
        assertEquals(expected, collectedSet);
    }
}
