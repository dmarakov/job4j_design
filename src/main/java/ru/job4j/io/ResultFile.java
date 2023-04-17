package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("data/dataresult.txt")) {
            int size = 9;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    String string = String.format("%2d ", (i + 1) * (j + 1));
                    output.write(string.getBytes());
                }
                output.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
