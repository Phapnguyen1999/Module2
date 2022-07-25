package bai3Test;

import bai3.NextDayCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextDayCalculatorTest {
    @Test
    public void testNextDayCalculator() {
        int day = 31;
        int month = 12;
        int year=2020;
        String expected="1/1/2021";
        String result = NextDayCalculator.nextDay(day,month,year);
        assertEquals(expected,result);
    }

}
