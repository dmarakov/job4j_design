package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;

    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        List<String> botAnswerList = new ArrayList<>(readPhrases());
        int botAnswerSize = botAnswerList.size();
        String nextLine = null;

        while (!OUT.equals(nextLine)) {
            nextLine = in.nextLine();
            String botAnswer = botAnswerList.get((int) (Math.random() * botAnswerSize));
            if (CONTINUE.equals(nextLine)) {
                System.out.println(botAnswer);
                log.add(nextLine + " - " + botAnswer + System.lineSeparator());
                saveLog(log);
                log.clear();
            }
            if (STOP.equals(nextLine)) {
                log.add(nextLine);
                while (!CONTINUE.equals(nextLine)) {
                    nextLine = in.nextLine();
                    if (CONTINUE.equals(nextLine)) {
                        System.out.println(botAnswer);
                        log.add(nextLine + " - " + botAnswer + System.lineSeparator());
                        saveLog(log);
                        log.clear();
                        break;
                    }
                    if (OUT.equals(nextLine)) {
                        log.add(nextLine + System.lineSeparator());
                        saveLog(log);
                        System.exit(0);

                    }
                    log.add(nextLine + System.lineSeparator());
                    saveLog(log);
                    log.clear();
                }
            }
        }
        in.close();
    }


    private List<String> readPhrases() {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("[A-Za-z0-9_.-]*");

        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            while (br.ready()) {
                String[] splitedLine = br.readLine().split(" ");
                for (String str : splitedLine) {
                    Matcher matcher = pattern.matcher(str);
                    if (matcher.matches()) {
                        list.add(str);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            for (String line : log) {
                pw.print(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("/Users/dmarakov/IdeaProjects/Test/log.txt", "/Users/dmarakov/IdeaProjects/Test/404.txt");
        cc.run();
    }
}