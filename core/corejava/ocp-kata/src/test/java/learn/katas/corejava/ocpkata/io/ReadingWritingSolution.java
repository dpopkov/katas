package learn.katas.corejava.ocpkata.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadingWritingSolution extends NioTest {

    @Test
    void readBytesUsingInputStream() throws IOException {
        final Path sourcePath = resourcePathFor(TEST_DATA_FILENAME);
        final byte[] expectedBytes = TEST_CONTENT.getBytes();
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Implement: read actual bytes from sourcePath
        try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(sourcePath))) {
            byte[] buf = new byte[1024];
            int length;
            while ((length = bis.read(buf)) != -1) {
                baos.write(buf, 0, length);
            }
        }

        final byte[] actual = baos.toByteArray();
        assertArrayEquals(expectedBytes, actual);
    }

    @Test
    void readWriteBytesUsingInputOutputStreams() throws IOException {
        final Path sourcePath = resourcePathFor(TEST_DATA_FILENAME);
        final byte[] expectedBytes = TEST_CONTENT.getBytes();
        final Path destPath = pathInMemoryFor("dest.bin");

        // Implement: read bytes from sourcePath and write to destPath
        try (BufferedInputStream in = new BufferedInputStream(Files.newInputStream(sourcePath));
             BufferedOutputStream out = new BufferedOutputStream(Files.newOutputStream(destPath))) {
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) != -1) {
                out.write(buf, 0, length);
            }
        }

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
        try (Reader in = Files.newBufferedReader(sourcePath);
             Writer out = Files.newBufferedWriter(destPath)) {
            char[] cbuf = new char[1024];
            int length;
            while ((length = in.read(cbuf)) != -1) {
                out.write(cbuf, 0, length);
            }
        }

        final String actualText = Files.readString(destPath);
        assertEquals(expectedText, actualText);
    }
}
