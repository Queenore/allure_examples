import io.qameta.allure.Epic;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.AuthPage;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.open;

@Epic("базовый тест")
public class BaseTest {

    public static final String authPageLink = "https://ok.ru/";
    public static final String homePageLink = "https://ok.ru/feed/";
    private static final String LOGIN = "botS23AT25";
    static final String PASSWD = "autotests2023";
    static HomePage homePage = null;

    @BeforeAll
    public static void okAuth() {
        if (homePage != null) {
            return;
        }

        open(authPageLink);
        AuthPage authPage = new AuthPage();

        authPage.inputLogin(LOGIN);
        authPage.inputPassword(PASSWD);

        homePage = authPage.submitAuth();
    }

    @BeforeEach
    public void goHome() {
        open(homePageLink);
    }
}
