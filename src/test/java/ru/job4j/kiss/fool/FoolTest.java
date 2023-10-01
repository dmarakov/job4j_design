package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FoolTest {

    @Test
    void isThisFizzBuzz() {
        assertEquals("FizzBuzz", Fool.fizzBuzzCondition(15));
    }

    @Test
    void isThisFizz() {
        assertEquals("Fizz", Fool.fizzBuzzCondition(3));
    }

    @Test
    void isThisBuzz() {
        assertEquals("Buzz", Fool.fizzBuzzCondition(5));
    }

    @Test
    void isThisANumber() {
        assertEquals("2", Fool.fizzBuzzCondition(2));
    }

    @Test
    public void testUserInputWithError() {
        String simulatedInput = "1\n1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Exception exception = assertThrows(java.util.NoSuchElementException.class, () -> Fool.main(new String[]{}));
        String[] outputLines = outContent.toString().split(System.lineSeparator());

        assertTrue(outputLines[0].contains("Игра FizzBuzz."));
        assertEquals("1", outputLines[1].trim());
        assertEquals("Ошибка. Начинай снова.", outputLines[2].trim());
    }
}
