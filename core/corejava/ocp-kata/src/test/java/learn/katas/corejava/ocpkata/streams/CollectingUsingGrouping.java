package learn.katas.corejava.ocpkata.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CollectingUsingGrouping {

    private final List<String> animals = List.of("lions", "tigers", "bears");
    private Stream<String> stream;

    @BeforeEach
    void setUp() {
        stream = animals.stream();
    }

    @Test
    void collectGroupingNamesByStringLength() {
        // Implement: group names to Lists by string length as key.
        Map<Integer, List<String>> collected = null;
        Map<Integer, List<String>> expected = Map.of(
                5, List.of("lions", "bears"),
                6, List.of("tigers")
        );
        assertEquals(expected, collected);
    }

    @Test
    void collectGroupingNamesByStringLengthToSets() {
        // Implement: group names to Sets by string length as key.
        Map<Integer, Set<String>> collected = null;
        Map<Integer, Set<String>> expected = Map.of(
                5, Set.of("lions", "bears"),
                6, Set.of("tigers")
        );
        assertEquals(expected, collected);
    }

    @Test
    void collectToSpecifiedMapTypeGroupingNamesByStringLengthToSets() {
        // Implement: group names to Sets by string length as key into Map of specified type.
        Map<Integer, Set<String>> collected = null;
        Map<Integer, Set<String>> expected = Map.of(
                5, Set.of("lions", "bears"),
                6, Set.of("tigers")
        );
        assertEquals(expected, collected);
        assertEquals(TreeMap.class, collected.getClass());
    }

    @Test
    void collectHowManyLengths() {
        // Implement: group into map with lengths as key and count of names with the length as value.
        Map<Integer, Long> collected = null;
        Map<Integer, Long> expected = Map.of(5, 2L, 6, 1L);
        assertEquals(expected, collected);
    }

    @Test
    void collectFirstLettersUsingMapping() {
        // Implement: map lengths to the first letter of the first animal alphabetically of each length
        Map<Integer, Optional<Character>> collected = null;
        Map<Integer, Optional<Character>> expected = Map.of(
                5, Optional.of('b'),    // first letter of "bears"
                6, Optional.of('t')     // first letter of "tigers"
        );
        assertEquals(expected, collected);
    }
}
