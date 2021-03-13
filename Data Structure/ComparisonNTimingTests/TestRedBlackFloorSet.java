import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.net.SocketPermission;

/**
 * Created by hug.
 */
public class TestRedBlackFloorSet {
    @Test
    public void randomizedTest() {
       // TODO: YOUR CODE HERE
       AListFloorSet a = new AListFloorSet();
       RedBlackFloorSet b = new RedBlackFloorSet();
       double ran;
       for(int i = 0; i < 100000; i++)
       {
           ran = StdRandom.uniform(-5000, 5000);
           a.add(ran);
           b.add(ran);
       }
       for(int i = 0; i < 100000; i++)
       {
           ran = StdRandom.uniform(-5000, 5000);
           double af = a.floor(ran);
           double bf = b.floor(ran);
           assertEquals(af, bf, 0.000001);
       }
    }
}