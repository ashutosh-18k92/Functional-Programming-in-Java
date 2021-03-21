package chapter_3_string_comparators_filters.collectors;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListingFiles {

    public static void main(String[] args) throws IOException {
        /*List files in current directory*/
        Files.list(Paths.get(".")).forEach(System.out::println);

        /*List only directories*/
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(file -> System.out.println(file.getFileName()));

    }
}
