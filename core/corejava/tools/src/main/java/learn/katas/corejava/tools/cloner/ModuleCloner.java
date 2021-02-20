package learn.katas.corejava.tools.cloner;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

import static java.nio.file.FileVisitResult.CONTINUE;

public class ModuleCloner {

    private static final String SOLUTIONS_MODULE_SUFFIX = "-solutions";
    private static final String JAVA_FILE_EXTENSION = ".java";

    private final Path sourceModule;
    private final Path targetModule;
    private final CloneCount cloneCount;
    private final boolean doCopy;

    public ModuleCloner(String source, String target, boolean doCopy) {
        sourceModule = Path.of(source);
        this.doCopy = doCopy;
        if (!Files.exists(sourceModule)) {
            throw new IllegalArgumentException("Module " + source + " does not exist");
        }
        targetModule = Path.of(target);
        if (!Files.exists(targetModule)) {
            throw new IllegalArgumentException("Module " + target + " does not exist");
        }
        cloneCount = new CloneCount();
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Parameter missing: nameOfSourceModule");
            System.exit(1);
        }
        String sourceModule = args[0];
        String targetModule = sourceModule + SOLUTIONS_MODULE_SUFFIX;
        ModuleCloner cloner = new ModuleCloner(sourceModule, targetModule, true);
        CloneCount result = cloner.cloneModule();
        System.out.println(result.getStats());
    }

    public CloneCount cloneModule() throws IOException {
        cloneCodeFiles(
                pathForCode(sourceModule, "main"),
                pathForCode(targetModule, "main")
        );
        cloneCodeFiles(
                pathForCode(sourceModule, "test"),
                pathForCode(targetModule, "test")
        );
        return cloneCount;
    }

    private Path pathForCode(Path module, String typeOfDirectory) {
        return module.resolve("src").resolve(typeOfDirectory).resolve("java");
    }

    public void cloneCodeFiles(Path source, Path target) throws IOException {
        Files.walkFileTree(source, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
                new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                            throws IOException {
                        Path targetdir = target.resolve(source.relativize(dir));
                        try {
                            System.out.println("Copying directory " + dir + " to " + targetdir);
                            if (doCopy) {
                                Files.copy(dir, targetdir);
                            }
                        } catch (FileAlreadyExistsException e) {
                            if (!Files.isDirectory(targetdir))
                                throw e;
                        }
                        return CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                            throws IOException {
                        if (file.getFileName().toString().endsWith(JAVA_FILE_EXTENSION)) {
                            final Path targetFile = target.resolve(source.relativize(file));
                            if (!Files.exists(targetFile)) {
                                System.out.println("Copying " + file + " to " + targetFile);
                                if (doCopy) {
                                    Files.copy(file, targetFile);
                                }
                                cloneCount.increment();
                            }
                        }
                        return CONTINUE;
                    }
                }
        );
    }
}
