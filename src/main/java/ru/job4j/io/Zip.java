package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validation(String directory, String exclude, String output) {
        if (!(Files.exists(Path.of(directory)))) {
            throw new IllegalArgumentException(String.format("Root folder '%s' is null. Usage ROOT_FOLDER.", directory));
        }
        if (!Files.isDirectory(Path.of(directory))) {
            throw new IllegalArgumentException(String.format("'%s' is not a folder. Create a folder", directory));
        }
        if (!(exclude.startsWith(".") && exclude.length() > 1)) {
            throw new IllegalArgumentException(String.format("File extension '%s' don't not specified. Use program arguments. It should start with '.' and has more than 1 symbol", exclude));
        }
        if (!(output.endsWith(".zip"))) {
            throw new IllegalArgumentException(String.format("Your file %s have to has .zip extension", output));
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException("The number of parameters passed must be 3");
        }
        ArgsName argsName = ArgsName.of(args);
        String directory = argsName.get("d");
        String exclude = argsName.get("e");
        String output = argsName.get("o");
        validation(directory, exclude, output);
        List<Path> path = Search.search(Paths.get(directory), it -> !it.toFile().getName().endsWith(exclude));
        List<File> files = path.stream().map(Path::toFile).toList();
        System.out.println(path);
        Zip zip = new Zip();
        zip.packFiles(
                files,
                new File("/Users/dmarakov/IdeaProjects/Test/" + output)
        );
    }
}