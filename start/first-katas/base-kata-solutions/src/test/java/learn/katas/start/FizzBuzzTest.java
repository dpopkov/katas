package learn.katas.start;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FizzBuzzTest {

    private final FizzBuzz fizzBuzz = new FizzBuzz();

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12, 18})
    void testMultiplesOf3(int value) {
        assertEquals("Fizz", fizzBuzz.toFizzBuzzString(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 25})
    void testMultiplesOf5(int value) {
        assertEquals("Buzz", fizzBuzz.toFizzBuzzString(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30})
    void testMultiplesOf3And5(int value) {
        assertEquals("FizzBuzz", fizzBuzz.toFizzBuzzString(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 7, 13, 17})
    void testOthers(int value) {
        assertEquals(String.valueOf(value), fizzBuzz.toFizzBuzzString(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 101})
    void testOutOfRangeNegative(int value) {
        assertThrows(IllegalArgumentException.class, () -> fizzBuzz.toFizzBuzzString(value));
    }
}
