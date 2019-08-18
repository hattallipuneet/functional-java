package files;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListSubDirs {

    public static void main(String[] args) {
        listSubDirsTheHardWay();
    }

    private static void listSubDirsTheHardWay() {
        List<File> files = new ArrayList<>();
        File[] filesInCurrDirectory = new File(".").listFiles();
        for(File file: filesInCurrDirectory) {
            File[] filesInSubDirectory = file.listFiles();
            if(filesInSubDirectory != null) {
                files.addAll(Arrays.asList(filesInSubDirectory));
            }else {
                files.add(file);
            }
        }

        files.stream()
                .map(file -> String.format("%s is a DIR [%s] or a FILE [%s]",
                        file.toString(), file.isDirectory(), file.isFile()))
                .forEach(System.out::println);

        System.out.println("Total number of files "+ files.size());
    }

    private static void listSubDirsMap() {
        Stream.of(new File(".").listFiles())
                .map(file -> file.listFiles() == null ?
                        Stream.of(file) :
                        Stream.of(file.listFiles()))
                .collect(Collectors.toList());

        Stream.of(new File(".").listFiles())
                .flatMap(file -> file.listFiles() == null ?
                        Stream.of(file) :
                        Stream.of(file.listFiles()))
                .collect(Collectors.toList());

    }
}
