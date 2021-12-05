package ru.otus.tests;

import ru.otus.tests.unit.DiceImplTest;
import ru.otus.tests.unit.GameTest;
import ru.otus.tests.unit.GameWinnerConsolePrinterTest;

public class Tester {
    public static void main(String[] args) {
        new DiceImplTest().testRollForHexagonDice();

        new GameTest().gameTestFlowPlayer2Wins();
        new GameTest().gameTestFlowSameResults();
        new GameTest().gameTestFlowPlayer1Wins();

        new GameWinnerConsolePrinterTest().printWinnerTest();
    }
}
