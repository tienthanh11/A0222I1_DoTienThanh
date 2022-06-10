package demo.MaxNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxNumberTest {
    MaxNumber m = new MaxNumber();
    @Test
    public void testMax21() {
        assertEquals(8, m.max2(8,0));
    }
    @Test
    public void testMax22() {
        assertEquals(7, m.max2(4, 7)); }
}
