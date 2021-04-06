package learn.katas.corejava.ocpkata.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CollectingIntoMaps {

    private final List<String> animals = List.of("lions", "tigers", "bears");
    private Stream<String> stream;

    @BeforeEach
    void setUp() {
        stream = animals.stream();
    }

    @Test
    void createSimpleMapFromStream() {
        // Implement: collect values from stream into map with names as keys, and lengths as values.
        Map<String, Integer> collected = null;
        Map<String, Integer> expected = Map.of("lions", 5, "tigers", 6, "bears", 5);
        assertEquals(expected, collected);
    }

    @Test
    void createMapFromStreamWithKeyCollisions() {
        // Implement: collect values from stream into map with lengths as keys, and joined names as values.
        Map<Integer, String> collected = null;
        Map<Integer, String> expected = Map.of(5, "lions,bears", 6, "tigers");
        assertEquals(expected, collected);
    }

    @Test
    void createMapOfSpecifiedType() {
        // Implement: collect values from stream into map of specified type with lengths as keys, and joined names as values.
        Map<Integer, String> collected = null;
        Map<Integer, String> expected = Map.of(5, "lions,bears", 6, "tigers");
        assertEquals(expected, collected);
        assertEquals(TreeMap.class, collected.getClass());
    }
}
