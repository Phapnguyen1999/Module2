
import bai1.Calculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testCalculateAdd() {
        int a = 1;
        int b = 1;
        char o = '+';

        int result = Calculator.calculator(a, b, o);
        assertEquals(2, result);
    }

    @Test
    public void testCalculateSub() {
        int a = 2;
        int b = 1;
        char o = '-';


        int result = Calculator.calculator(a, b, o);
        assertEquals(1, result);
    }

    @Test
    public void testCalculateMul() {
        int a = 2;
        int b = 2;
        char o = '*';

        int result = Calculator.calculator(a, b, o);
        assertEquals(4, result);
    }

    @Test
    public void testCalculateDiv() {
        int a = 6;
        int b = 3;
        char o = '/';
        int result = Calculator.calculator(a, b, o);
        assertEquals(2, result);
    }

    @Test
    public void testCalculateDivByZero() {
        int a = 2;
        int b = 0;
        char o = '/';

        assertThrows(RuntimeException.class,
                ()-> {Calculator.calculator(a, b, o);});
    }

    @Test
    public void testCalculateWrongOperator() {
        int a = 2;
        int b = 0;
        char o = '=';

        assertThrows(RuntimeException.class,
                ()-> {Calculator.calculator(a, b, o);});
    }



}
