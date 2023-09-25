package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    static public String fizzBuzzCondition(int startAt) {
        String rsl;
        if (startAt % 3 == 0 && startAt % 5 == 0) {
            rsl = "FizzBuzz";
        } else if (startAt % 3 == 0) {
            rsl = "Fizz";
        } else if (startAt % 5 == 0) {
            rsl = "Buzz";
        } else {
            rsl = String.valueOf(startAt);
        }
        return rsl;
    }

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var io = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(fizzBuzzCondition(startAt));
            startAt++;
            var answer = io.nextLine();
            if (!fizzBuzzCondition(startAt).equals(answer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }
}