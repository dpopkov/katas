package learn.katas.corejava.ocpkata.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionPartitioning {
    private final List<String> animals = List.of("lions", "tigers", "bears");
    private Stream<String> stream;

    @BeforeEach
    void setUp() {
        stream = animals.stream();
    }

    @Test
    void partitionToTwoGroupsByLength() {
        // Implement: partition names to List group with length <= 5 and group with length > 5.
        Map<Boolean, List<String>> partitioned = null;
        Map<Boolean, List<String>> expected = Map.of(
                Boolean.TRUE, List.of("lions", "bears"),
                Boolean.FALSE, List.of("tigers")
        );
        assertEquals(expected, partitioned);
    }

    @Test
    void partitionToTwoSetGroupsByLength() {
        // Implement: partition names to Set group with length <= 5 and group with length > 5.
        Map<Boolean, Set<String>> partitioned = null;
        Map<Boolean, Set<String>> expected = Map.of(
                Boolean.TRUE, Set.of("lions", "bears"),
                Boolean.FALSE, Set.of("tigers")
        );
        assertEquals(expected, partitioned);
    }
}
