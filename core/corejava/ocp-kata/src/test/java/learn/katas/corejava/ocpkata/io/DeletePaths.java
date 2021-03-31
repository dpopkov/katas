package learn.katas.corejava.ocpkata.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeletePaths extends NioTest {

    /**
     Creates structure:
     <pre>
     users
        joe
            docs
                some.txt
                other.txt
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
    }

    @Test
    void deleteFoldersAndPaths() throws IOException {
        final Path joe = pathInMemoryFor("users/joe");

        // Implement: delete files and folders starting from joe


        final Path users = pathInMemoryFor("users");
        final String collected = Files.walk(users)
                .map(Path::toString)
                .sorted()
                .collect(Collectors.joining(NL));
        final String expected = "/testDir/users";
        assertEquals(expected, collected);
    }
}
