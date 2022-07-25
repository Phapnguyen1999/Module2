package bai5Test;

import bai5.FizzBuzzTranslate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    public void testFizzBuzz(){
        int number=14;
        String expected="mười bốn";
        String result= FizzBuzzTranslate.fizzBuzz(number);
        assertEquals(expected,result);
    }
}
