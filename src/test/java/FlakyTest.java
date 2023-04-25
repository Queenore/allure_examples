import io.qameta.allure.Attachment;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlakyTest {

    @Flaky
    @Test
    @Link(name = "Ссылка", url = "https://ok.ru")
    @Story("flaky story")
    public void flakyTest() {
        assertTrue(Math.random() < 0.5);
    }
}
