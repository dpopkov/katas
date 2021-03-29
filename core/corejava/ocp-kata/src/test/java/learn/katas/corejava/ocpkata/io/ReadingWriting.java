package learn.katas.corejava.ocpkata.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class ReadingWriting extends NioTest {

    @Test
    void readBytesUsingInputStream() throws IOException {
        final Path sourcePath = resourcePathFor(TEST_DATA_FILENAME);
        final byte[] expectedBytes = TEST_CONTENT.getBytes();
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Implement: read actual bytes from sourcePath

        final byte[] actual = baos.toByteArray();
        assertArrayEquals(expectedBytes, actual);
    }

    @Test
    void readWriteBytesUsingInputOutputStreams() throws IOException {
        final Path sourcePath = resourcePathFor(TEST_DATA_FILENAME);
        final byte[] expectedBytes = TEST_CONTENT.getBytes();
        final Path destPath = pathInMemoryFor("dest.bin");

        // Implement: read bytes from sourcePath and write to destPath

        final byte[] actualBytes = Files.readAllBytes(destPath);
        assertArrayEquals(expectedBytes, actualBytes);
    }

    @Test
    void readWriteTextUsingReaderWriter() throws IOException {
        final Path sourcePath = resourcePathFor(TEST_DATA_FILENAME);
        @SuppressWarnings("UnnecessaryLocalVariable")
        final String expectedText = TEST_CONTENT;
        final Path destPath = pathInMemoryFor("dest.txt");

        // Implement: read text from sourcePath and write to destPath

        final String actualText = Files.readString(destPath);
        assertEquals(expectedText, actualText);
    }
}
