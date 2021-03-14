package learn.algo.questions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new int[] {2, 7, 11, 15}, 9, new int[] {0, 1}),
                Arguments.of(new int[] {3, 2, 4}, 6, new int[] {1, 2}),
                Arguments.of(new int[] {3, 3}, 6, new int[] {0, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void testFindIndexes(int[] nums, int target, int[] expected) {
        int[] output = new TwoSum().findIndexes(nums, target);
        assertArrayEquals(expected, output);
    }
}
