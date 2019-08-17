package files;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListHiddenFiles {

    public static void main(String[] args) {
        try {
            final File files[] = new File(".")
                    .listFiles(File::isHidden);
            for (File file: files) {
                System.out.println(file);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
