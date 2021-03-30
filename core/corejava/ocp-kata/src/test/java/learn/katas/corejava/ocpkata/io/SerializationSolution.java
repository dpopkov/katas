package learn.katas.corejava.ocpkata.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class SerializationSolution extends NioTest {

    @Test
    void simpleSerializationDeserialization() throws IOException, ClassNotFoundException, NoSuchAlgorithmException {
        final PriceList sourceList = new PriceList(LocalDate.now());
        sourceList.addItem(new Drink("Tea", 1.9));
        sourceList.addItem(new Food("Cake", 3.5));
        final Path swap = pathInMemoryFor("swap");

        // Implement: serialize PriceList to swap
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(swap))) {
            out.writeObject(sourceList);
        }

        PriceList readList;
        // Implement: deserialize PriceList from swap
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(swap))) {
            readList = (PriceList) in.readObject();
        }

        assertNotSame(sourceList, readList);
        assertEquals(sourceList, readList);
        assertEquals(sourceList.getHash(), readList.getHash());
    }
}
