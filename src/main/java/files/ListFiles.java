package files;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Predicate;

public class ListFiles {

    public static void main(String[] args) {
//        listAllFiles();
//        listOnlyDirectories();
//        fileFilterAnnonymousClass();
//        fileFilterDirectoryStream();
        listOnlyFilesEndingWith();
    }

    private static void listAllFiles() {
        try {
            Files.list(Paths.get(""))
                    .forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void listOnlyDirectories() {
        try{
            Files.list(Paths.get(""))
                    .filter(Files::isDirectory)
                    .forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void fileFilterAnnonymousClass() {
        try{
            final String[] file = new File(".").list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".gradle");
                }
            });
            System.out.println(Arrays.deepToString(file));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void fileFilterDirectoryStream() {
        try{
            Files.newDirectoryStream(
                    Paths.get("."),
                    path -> path.toString().endsWith(".gradle")
            ).forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void listOnlyFilesEndingWith() {
        try {
            Predicate<Path> isDirectory = Files::isDirectory;
            Predicate<Path> fileEndsWith = (Path path) -> path.toString().endsWith(".gradle");
            Files.list(Paths.get(""))
                    .filter(
                            fileEndsWith.and(
                                    isDirectory.negate()
                            )
                    )
                    .forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
