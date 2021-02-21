package learn.katas.start;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimaryTest {

    private final Primary primary = new Primary();

    @Test
    void testFirst() {
        long[] actual = primary.first(6);
        long[] expected = {2, 3, 5, 7, 11, 13};
        assertArrayEquals(expected, actual);
    }
}
