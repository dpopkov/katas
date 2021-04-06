package learn.katas.corejava.ocpkata.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CollectingBasic {

    private final List<String> animals = List.of("lions", "tigers", "bears");
    private Stream<String> stream;

    @BeforeEach
    void setUp() {
        stream = animals.stream();
    }

    @Test
    void collectToString() {
        // Implement: collect values from stream into resulting string divided by ","
        String collected = null;
        String expected = "lions,tigers,bears";
        assertEquals(expected, collected);
    }

    @Test
    void collectToAverage() {
        // Implement: collect values from stream into average length of values.
        Double averageLength = null;
        double expected = 5.333;
        assertEquals(expected, averageLength, 1e-3);
    }

    @Test
    void collectToCollection() {
        // Implement: collect values from stream into TreeSet.
        TreeSet<String> collectedSet = null;
        TreeSet<String> expected = new TreeSet<>(animals);
        assertEquals(expected, collectedSet);
    }
}
