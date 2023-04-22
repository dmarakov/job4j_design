package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        boolean isUnavailable = false;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            while (in.ready()) {
                String line = in.readLine();
                String[] splitLine = line.split(" ");
                if (!isUnavailable && ("400".equals(splitLine[0]) || "500".equals(splitLine[0]))) {
                    isUnavailable = true;
                    sb.append(splitLine[1]).append(";");
                } else if (isUnavailable && !("400".equals(splitLine[0]) || "500".equals(splitLine[0]))) {
                    isUnavailable = false;
                    sb.append(splitLine[1]).append(";").append(System.lineSeparator());
                }
                try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
                    out.append(sb);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}