import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlakyTest {

    @Flaky
    @Test
    @Story("падающий тест")
    public void flakyTest() {
        assertTrue(Math.random() < 0.2);
    }
}
