package ru.otus.game;

public class GameWinnerConsolePrinter implements GameWinnerPrinter {
    @Override
    public void printWinner(Player winner) {
        if (winner.getName().equals("NoWinner")){
            System.out.println("Победитель: не выявлен");
        }else {
            System.out.printf("Победитель: %s%n", winner.getName());
        }

//        System.out.printf("Победитель: %s%n", winner.getName());
    }

}
