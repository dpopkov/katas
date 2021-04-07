package learn.katas.corejava.ocpkata.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectingUsingGroupingSolution {

    private final List<String> animals = List.of("lions", "tigers", "bears");
    private Stream<String> stream;

    @BeforeEach
    void setUp() {
        stream = animals.stream();
    }

    @Test
    void collectGroupingNamesByStringLength() {
        // Implement: group names to Lists by string length as key.
        Map<Integer, List<String>> collected = stream.collect(Collectors.groupingBy(String::length));
        Map<Integer, List<String>> expected = Map.of(
                5, List.of("lions", "bears"),
                6, List.of("tigers")
        );
        assertEquals(expected, collected);
    }

    @Test
    void collectGroupingNamesByStringLengthToSets() {
        // Implement: group names to Sets by string length as key.
        Map<Integer, Set<String>> collected = stream.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        Map<Integer, Set<String>> expected = Map.of(
                5, Set.of("lions", "bears"),
                6, Set.of("tigers")
        );
        assertEquals(expected, collected);
    }

    @Test
    void collectToSpecifiedMapTypeGroupingNamesByStringLengthToSets() {
        // Implement: group names to Sets by string length as key into Map of specified type.
        Map<Integer, Set<String>> collected = stream.collect(Collectors.groupingBy(
                String::length,
                TreeMap::new,
                Collectors.toSet()
        ));
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
        Map<Integer, Long> collected = stream.collect(Collectors.groupingBy(
                String::length,
                Collectors.counting()
        ));
        Map<Integer, Long> expected = Map.of(5, 2L, 6, 1L);
        assertEquals(expected, collected);
    }

    @Test
    void collectFirstLettersUsingMapping() {
        // Implement: map lengths to the first letter of the first animal alphabetically of each length
        Map<Integer, Optional<Character>> collected = stream.collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(
                                s -> s.charAt(0),
                                Collectors.minBy(Comparator.comparingInt(a -> a))
                        )
                )
        );
        Map<Integer, Optional<Character>> expected = Map.of(
                5, Optional.of('b'),    // first letter of "bears"
                6, Optional.of('t')     // first letter of "tigers"
        );
        assertEquals(expected, collected);
    }
}
