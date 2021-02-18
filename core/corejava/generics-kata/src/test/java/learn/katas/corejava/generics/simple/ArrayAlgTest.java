package learn.katas.corejava.generics.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("RedundantSuppression")
class ArrayAlgTest {

    @SuppressWarnings("rawtypes")
    @Test
    void testMinMax() {
        String[] data = {"B", "C", "A", "E", "F", "D"};
        Pair result = ArrayAlg.minMax(data);
        assertNotNull(result);
        assertEquals("A", result.getFirst());
        assertEquals("F", result.getSecond());
    }
}
