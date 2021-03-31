package learn.katas.corejava.ocpkata.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigateFileSystemSolution extends NioTest {

    /**
     Creates structure:
     <pre>
     users
        joe
            docs
                some.txt
                other.txt
            pics
                acme.png
                s.txt --> some.txt
     </pre>
     */
    @BeforeEach
    void setup() throws IOException {
        Path users = pathInMemoryFor("users");
        Files.createDirectory(users);
        Path joe = users.resolve("joe");
        Files.createDirectory(joe);
        Path docs = joe.resolve("docs");
        Files.createDirectories(docs);
        Path someTxt = docs.resolve("some.txt");
        Files.createFile(someTxt);
        Files.createFile(docs.resolve("other.txt"));
        Path pics = joe.resolve("pics");
        Files.createDirectories(pics);
        Files.createFile(pics.resolve("acme.png"));
        Files.createSymbolicLink(pics.resolve("s.txt"), someTxt);
    }

    @Test
    void listFolderContent() throws IOException {
        final Path joe = testDir.resolve("users/joe");

        // Implement: concatenate all items in the specified directory
        String collected = Files.list(joe)
                .map(Path::toString)
                .collect(Collectors.joining(NL));

        final String expected = ""
                + "/testDir/users/joe/docs" + NL
                + "/testDir/users/joe/pics";
        assertEquals(expected, collected);
    }

    @Test
    void walkDownFileSystemPath() throws IOException {
        final Path joe = testDir.resolve("users/joe");

        // Implement: concatenate all items in the specified directory and all sub-directories
        String collected = Files.walk(joe)
                .map(Path::toString)
                .sorted()
                .collect(Collectors.joining(NL));

        final String expected = ""
                + "/testDir/users/joe" + NL
                + "/testDir/users/joe/docs" + NL
                + "/testDir/users/joe/docs/other.txt" + NL
                + "/testDir/users/joe/docs/some.txt" + NL
                + "/testDir/users/joe/pics" + NL
                + "/testDir/users/joe/pics/acme.png" + NL
                + "/testDir/users/joe/pics/s.txt";
        assertEquals(expected, collected);
    }

    @Test
    void followSymbolicLink() throws IOException {
        final Path sTxt = testDir.resolve("users/joe/pics/s.txt");
        assertTrue(Files.isSymbolicLink(sTxt));

        // Implement: get target path of a symbolic link
        Path someTxt = Files.readSymbolicLink(sTxt);

        final String expectedPath = "/testDir/users/joe/docs/some.txt";
        assertEquals(expectedPath, someTxt.toString());
    }
}
