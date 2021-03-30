package learn.katas.corejava.ocpkata.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class Serialization extends NioTest {

    @Test
    void simpleSerializationDeserialization() throws IOException, ClassNotFoundException, NoSuchAlgorithmException {
        final PriceList sourceList = new PriceList(LocalDate.now());
        sourceList.addItem(new Drink("Tea", 1.9));
        sourceList.addItem(new Food("Cake", 3.5));
        final Path swap = pathInMemoryFor("swap");

        // Implement: serialize PriceList to swap

        PriceList readList = null;
        // Implement: deserialize PriceList from swap

        assertNotSame(sourceList, readList);
        assertEquals(sourceList, readList);
        assertEquals(sourceList.getHash(), readList.getHash());
    }
}
