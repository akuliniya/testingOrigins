package ru.otus.tests;


import ru.otus.tests.unit.DiceImplTest;
import ru.otus.tests.unit.GameTest;
import ru.otus.tests.unit.GameWinnerConsolePrinterTest;

public class HomeWork {

    /*
        Заготовка для ДЗ представляет собой игру в кости.
        При вызове game.playGame(), два игрока кидают кости.
        Выигрывает игрок, у кого результат (1-6) больше

        Написать тесты (минимум 4) на классы DiceImpl и Game.
        Тесты должны найти не менее двух ошибок.

        Информацию о пройденном тесте предлагается выводить в System.out, а об упавшем в System.err
     */
    public static void main(String[] args) {
        new DiceImplTest().testRollForHexagonDice();

        new GameTest().gameTestFlowPlayer2Wins();
        new GameTest().gameTestFlowSameResults();
        new GameTest().gameTestFlowPlayer1Wins();

        new GameWinnerConsolePrinterTest().printWinnerTest();
    }
    
}