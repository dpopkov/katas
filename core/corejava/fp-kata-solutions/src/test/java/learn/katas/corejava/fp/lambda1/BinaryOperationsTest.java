package learn.katas.corejava.fp.lambda1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryOperationsTest {

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(0L, 1L, 0L),
                Arguments.of(2L, 2L, 2L),
                Arguments.of(1L, 4L, 24L),
                Arguments.of(5L, 15L, 54486432000L)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void testProduct(long left, long right, long expected) {
        List<Long> actual = BinaryOperations.product().calculate(left, right);
        for (Long result : actual) {
            assertEquals(expected, result);
        }
    }
}
