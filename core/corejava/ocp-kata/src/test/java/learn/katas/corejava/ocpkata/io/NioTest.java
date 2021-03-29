package learn.katas.corejava.ocpkata.io;

import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class NioTest {
    protected static final Logger log = LogManager.getLogger(NioTest.class);
    protected static final String TEST_DATA_FILENAME = "data.txt";
    protected static final String TEST_LINE = "Test content";
    protected static final String TEST_CONTENT = TEST_LINE + System.lineSeparator();

    protected final Path testDir;

    protected NioTest() {
        testDir = Jimfs.newFileSystem(Configuration.unix()).getPath("/testDir");
        try {
            Files.createDirectory(testDir);
        } catch (IOException e) {
            log.error("Error creating test directory", e);
        }
    }

    protected Path pathInMemoryFor(String filename) {
        return testDir.resolve(filename);
    }

    protected Path resourcePathFor(String resourceFileName) {
        URL resourceUrl = getClass().getResource("/" + resourceFileName);
        String pathAsString = resourceUrl.getPath();
        return Paths.get(pathAsString);
    }
}
