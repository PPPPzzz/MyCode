package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(10);
        ArrayRingBuffer<Double> test = new ArrayRingBuffer<>(10);
        for(int i = 0; i < 10; i++)
        {
            double ran = Math.random();
            arb.enqueue(ran);
            test.enqueue(ran);
        }
        assertTrue(test.equals(arb));
        for(double n: arb)
        {
            System.out.println(n);
        }
        assertFalse(arb.isEmpty());
    }
}