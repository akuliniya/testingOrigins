package ru.otus.tests.unit.fakes;

import ru.otus.game.GameWinnerPrinter;
import ru.otus.game.Player;

import java.util.List;

public class GameWinnerConsolePrinterSpy implements GameWinnerPrinter {
    private final List<String> actualFlow;

    public GameWinnerConsolePrinterSpy(List<String> actualFlow) {
        this.actualFlow = actualFlow;
    }

    @Override
    public void printWinner(Player winner) {
        if (winner.getName().equals("NoWinner")){
            actualFlow.add("Победитель: не выявлен");
        }else {
            actualFlow.add("Победитель: " + winner.getName());
        }
    }
}
