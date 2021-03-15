package learn.katas.corejava.tools.diff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiffStringsTest {

    @Test
    void testFirstDifferingIndex() {
        assertEquals(-1, DiffStrings.firstDifferingIndex("a", "a"));
        assertEquals(0, DiffStrings.firstDifferingIndex("a", "b"));
        assertEquals(2, DiffStrings.firstDifferingIndex("abc", "abd"));
        assertEquals(1, DiffStrings.firstDifferingIndex("abc", "a"));
    }
}
