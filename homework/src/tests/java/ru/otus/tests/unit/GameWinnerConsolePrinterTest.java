package ru.otus.tests.unit;

import ru.otus.assertions.Assertions;
import ru.otus.game.*;
import ru.otus.tests.unit.fakes.DiceSpy;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class GameWinnerConsolePrinterTest {
    public void printWinnerTest() {
        String scenario = "Тест вывода в консоль имени победителя";
        try {
            String expectedWinnerName = "Some name";
            String expected = "Победитель: " + expectedWinnerName;
            GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
            Player winner = new Player(expectedWinnerName);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            PrintStream old = System.out;
            System.setOut(printStream);
            winnerPrinter.printWinner(winner);
            System.out.flush();
            System.setOut(old);

            String actual = outputStream.toString();

            Assertions.assertEquals(expected + System.getProperty("line.separator"), actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
