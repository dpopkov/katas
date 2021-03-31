package learn.katas.corejava.ocpkata.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Collectors;

public class CopyMoveSolution extends NioTest {

    private static final String NL = System.lineSeparator();

    /**
     Creates structure:
     <pre>
     users
        joe
            docs
                some.txt
                other.txt
            backup
                readme.txt
     archive
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
        Path backup = joe.resolve("backup");
        Files.createDirectories(backup);
        Files.createFile(backup.resolve("readme.txt"));
        Path archive = pathInMemoryFor("archive");
        Files.createDirectory(archive);
    }

    @Test
    void copyPaths() throws IOException {
        final Path docs = pathInMemoryFor("users/joe/docs");
        final Path backup = pathInMemoryFor("users/joe/backup");

        // Implement: copy files from docs to backup
        Files.list(docs).forEach(file -> {
            try {
                Files.copy(file, backup.resolve(file.getFileName()),
                        StandardCopyOption.COPY_ATTRIBUTES,
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                log.error("Error copying", e);
            }
        });

        final String collected = Files.list(backup)
                .map(Path::toString)
                .sorted()
                .collect(Collectors.joining(NL));
        final String expected = ""
                + "/testDir/users/joe/backup/other.txt" + NL
                + "/testDir/users/joe/backup/readme.txt" + NL
                + "/testDir/users/joe/backup/some.txt";
        Assertions.assertEquals(expected, collected);
    }

    @Test
    void movePaths() throws IOException {
        final Path backup = pathInMemoryFor("users/joe/backup");
        final Path archive = pathInMemoryFor("archive");
        prepareContent(backup);

        // Implement: move paths from backup to archive
        Files.move(backup, archive,
                StandardCopyOption.COPY_ATTRIBUTES,
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.ATOMIC_MOVE);

        final String collected = Files.list(archive)
                .map(Path::toString)
                .sorted()
                .collect(Collectors.joining(NL));
        final String expected = ""
                + "/testDir/archive/other.txt" + NL
                + "/testDir/archive/readme.txt" + NL
                + "/testDir/archive/some.txt";
        Assertions.assertEquals(expected, collected);
    }

    private void prepareContent(Path backup) throws IOException {
        final Path docs = pathInMemoryFor("users/joe/docs");
        Files.list(docs).forEach(file -> {
            try {
                Files.copy(file, backup.resolve(file.getFileName()),
                        StandardCopyOption.COPY_ATTRIBUTES,
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                log.error("Error copying", e);
            }
        });
    }
}
