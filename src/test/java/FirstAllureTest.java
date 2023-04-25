import org.junit.jupiter.api.Test;

import static java.lang.System.currentTimeMillis;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FirstAllureTest {

    @Test
    public void test() {
        assertTrue(currentTimeMillis() > 0);
    }
}
