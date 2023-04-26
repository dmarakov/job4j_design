package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, Path> map = new HashMap<>();
    private final List<Path> list = new ArrayList<>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.toFile().getName());
        if (!map.containsKey(fileProperty)) {
            map.put(fileProperty, file);
        } else {
            list.add(file);
            list.add(map.get(fileProperty));
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getPaths() {
        return list.stream()
                .distinct().collect(Collectors.toList());
    }
}