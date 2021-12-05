package ru.otus.tests.unit.fakes;

import ru.otus.game.Dice;
import java.util.List;

public class DiceSpy implements Dice {
    private boolean isFirstRoll = true;
    private final List<String> actualFlow;
    private int player1Result;
    private int player2Result;

    public DiceSpy(List<String> actualFlow) {
        this.actualFlow = actualFlow;
    }

    public void setPlayer1Result(int resultOfTheThrow)  {
        player1Result = resultOfTheThrow;
    }

    public void setPlayer2Result(int resultOfTheThrow)  {
        player2Result = resultOfTheThrow;
    }


    @Override
    public int roll() {
        actualFlow.add("roll() вызван " +
                (isFirstRoll ? "для первого игрока" : "для второго игрока"));
        int resultOfTheThrow = 0;
        // Если вызывали метод чтения строки первый раз, то возвращаем 1 для первого игрока
        if (isFirstRoll) {
            isFirstRoll = false;
            resultOfTheThrow = player1Result;
            actualFlow.add(String.format("Первому игроку выпало %d", resultOfTheThrow));
            return resultOfTheThrow;
        }
        //  Если вызывали метод чтения строки второй раз, то возвращаем 2 для второго игрока
        if (!isFirstRoll) {
            isFirstRoll = true;
            resultOfTheThrow = player2Result;
            actualFlow.add(String.format("Второму игроку выпало %d", resultOfTheThrow));
            return resultOfTheThrow;
        }
        return resultOfTheThrow;
    }
}
