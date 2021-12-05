package ru.otus.tests.unit;

import ru.otus.assertions.Assertions;
import ru.otus.game.*;
import ru.otus.tests.unit.fakes.DiceSpy;
import ru.otus.tests.unit.fakes.GameWinnerConsolePrinterSpy;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    public void gameTestFlowPlayer2Wins() {
        String scenario = "Тест запуска игры, победитель Игрок 2";
        try {
            List<String> expectedFlow = List.of("roll() вызван для первого игрока",
                    "Первому игроку выпало 1",
                    "roll() вызван для второго игрока",
                    "Второму игроку выпало 2",
                    "Победитель: Игрок 2");
            List<String> actualFlow = new ArrayList<>();

            DiceSpy diceSpy = new DiceSpy(actualFlow);
            diceSpy.setPlayer1Result(1);
            diceSpy.setPlayer2Result(2);
            GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinterSpy(actualFlow);
            Game game = new Game(diceSpy, winnerPrinter);
            game.playGame(new Player("Игрок 1"), new Player("Игрок 2"));

            Assertions.assertEquals(expectedFlow.size(), actualFlow.size());
            for (int i = 0; i < expectedFlow.size(); i++) {
                Assertions.assertEquals(expectedFlow.get(i), actualFlow.get(i));
            }

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void gameTestFlowSameResults() {
        String scenario = "Тест запуска игры, одинаковые разультаты";
        try {
            List<String> expectedFlow = List.of("roll() вызван для первого игрока",
                    "Первому игроку выпало 3",
                    "roll() вызван для второго игрока",
                    "Второму игроку выпало 3",
                    "Победитель: не выявлен");
            List<String> actualFlow = new ArrayList<>();

            DiceSpy diceSpy = new DiceSpy(actualFlow);
            diceSpy.setPlayer1Result(3);
            diceSpy.setPlayer2Result(3);
            GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinterSpy(actualFlow);
            Game game = new Game(diceSpy, winnerPrinter);
            game.playGame(new Player("Игрок 1"), new Player("Игрок 2"));

            Assertions.assertEquals(expectedFlow.size(), actualFlow.size());
            for (int i = 0; i < expectedFlow.size(); i++) {
                Assertions.assertEquals(expectedFlow.get(i), actualFlow.get(i));
            }

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void gameTestFlowPlayer1Wins() {
        String scenario = "Тест запуска игры, победитель Игрок 1";
        try {
            List<String> expectedFlow = List.of("roll() вызван для первого игрока",
                    "Первому игроку выпало 5",
                    "roll() вызван для второго игрока",
                    "Второму игроку выпало 4",
                    "Победитель: Игрок 1");
            List<String> actualFlow = new ArrayList<>();

            DiceSpy diceSpy = new DiceSpy(actualFlow);
            diceSpy.setPlayer1Result(5);
            diceSpy.setPlayer2Result(4);
            GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinterSpy(actualFlow);
            Game game = new Game(diceSpy, winnerPrinter);
            game.playGame(new Player("Игрок 1"), new Player("Игрок 2"));

            Assertions.assertEquals(expectedFlow.size(), actualFlow.size());
            for (int i = 0; i < expectedFlow.size(); i++) {
                Assertions.assertEquals(expectedFlow.get(i), actualFlow.get(i));
            }

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
