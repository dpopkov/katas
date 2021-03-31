package learn.katas.corejava.ocpkata.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstructPaths extends NioTest {

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
        Files.createFile(docs.resolve("some.txt"));
        Files.createFile(docs.resolve("other.txt"));
        Path pics = joe.resolve("pics");
        Files.createDirectories(pics);
        Files.createFile(pics.resolve("acme.png"));
    }

    @Test
    void constructFileSystemPaths() throws IOException {
        // Implement: build paths according to the file structure above

        Path someTxt = null;
        assertEquals("/testDir/users/joe/docs/some.txt", someTxt.toString());

        Path someTextFileName = null;
        assertEquals("some.txt", someTextFileName.toString());

        Path docsFolder = null;
        assertEquals("/testDir/users/joe/docs", docsFolder.toString());

        Path acmePng = null;
        assertEquals("/testDir/users/joe/docs/../pics/acme.png", acmePng.toString());

        Path normalizedAcmePng = null;
        assertEquals("/testDir/users/joe/pics/acme.png", normalizedAcmePng.toString());

        Path existingAcmePng = null;
        Path verifiedAcmePng = null;
        assertEquals("/testDir/users/joe/pics/acme.png", verifiedAcmePng.toString());
        assertTrue(Files.exists(verifiedAcmePng));

        Path otherTxt = null;
        assertEquals("/testDir/users/joe/docs/other.txt", otherTxt.toString());

        Path betweenSomeTxtAndAcmePng = null;
        assertEquals("../../pics/acme.png", betweenSomeTxtAndAcmePng.toString());
    }
}
