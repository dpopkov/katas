package learn.algo.grokking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    private static final int[] DATA = {3, 5, 7, 11, 13, 15, 17};

    @ParameterizedTest
    @CsvSource({"3, 0", "7, 2", "11, 3", "15, 5", "17, 6", "2, -1", "10, -1", "18, -1"})
    void testFindIndex(int value, int expectedIndex) {
        int idx = BinarySearch.findIndex(DATA, value);
        assertEquals(expectedIndex, idx);
    }
}
