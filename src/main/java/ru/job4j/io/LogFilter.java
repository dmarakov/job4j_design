package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public List<String> filter(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            while (in.ready()) {
                String line = in.readLine();
                String[] splitedLine = line.split(" ");
                if ("404".equals(splitedLine[splitedLine.length - 2])) {
                    list.add(line);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("data/log.txt");
        for (String string : log) {
            System.out.println(string);

        }

    }
}