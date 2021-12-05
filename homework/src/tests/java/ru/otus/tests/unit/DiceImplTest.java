package ru.otus.tests.unit;

import ru.otus.assertions.Assertions;
import ru.otus.game.DiceImpl;

public class DiceImplTest {
    private final DiceImpl dice = new DiceImpl();

    public void testRollForHexagonDice() {
        String scenario = "Тест диапазона возвращаемого значения из метода roll()";
        int minExpected = 1;
        int maxExpected = 6;
        try {
            int actual = dice.roll();
            Assertions.assertInRange(minExpected, maxExpected, actual);

            System.out.printf("\"%s\" passed %n", scenario);
        }catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
