package demo.Calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {
    Calculator cal = new Calculator();
    @Test
    public void testAdd1() {
        assertEquals(3, cal.add(2, 1));
    }

    @Test
    public void testAdd2() {
        long a = cal.add(2000000000, 2000000000);
        boolean b = a > 2000000000;
        assertTrue(b);
    }

    @Test
    public void testAdd3() {
        long c = cal.add(-2000000000, -2000000000);
        boolean d = c < -2000000000;
        assertTrue(d);
    }
}





