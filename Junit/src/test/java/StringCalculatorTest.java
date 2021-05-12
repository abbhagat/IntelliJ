import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void testWithZeroParam() {
        assertEquals(0, StringCalculator.invoke("",","));
    }

    @Test
    public void testWithOneParam() {
        assertEquals(10, StringCalculator.invoke("10",","));
    }

    @Test
    public void testWithTwoParam() {
        assertEquals(30, StringCalculator.invoke("10\n20","\n"));
    }

    @Test(expected = RuntimeException.class)
    public void testWithThreeParam() {
        StringCalculator.invoke("10,20,30",",");
    }

    @Test(expected = RuntimeException.class)
    public void testWithStringParam() {
        StringCalculator.invoke("A",",");
    }

    @Test(expected = RuntimeException.class)
    public void testWithNegativeParam() {
        StringCalculator.invoke("1,-10",",");
    }

    @Test
    public void testWith2000AsParam() {
        assertEquals(10, StringCalculator.invoke("10,2000",","));
    }

}
