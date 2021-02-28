import org.junit.Test;
import static org.junit.Assert.*;
public class TestOffByN {
    static CharacterComparator ofbn = new OffByN(5);
    @Test
    public void testoff()
    {
        assertTrue(ofbn.equalChars('a', 'f'));
        assertTrue(ofbn.equalChars('f', 'a'));
        assertFalse(ofbn.equalChars('f', 'h'));
    }
}