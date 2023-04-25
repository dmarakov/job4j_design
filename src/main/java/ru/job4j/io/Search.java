package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        validation(args);
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void validation(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("The number of parameters passed must be 2");
        }
        if (args[0].isEmpty()) {
            throw new IllegalArgumentException("Root folder is null. Usage ROOT_FOLDER.");
        }
        if (args[1].isEmpty()) {
            throw new IllegalArgumentException("File extension not specified. Use program arguments");
        }
    }
}