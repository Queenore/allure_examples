package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class AuthPage extends BasePage {

    private static final SelenideElement LOGIN_FORM = Selenide.$(By.className("js-login-form"));

    @Override
    public void checkPage() {
        LOGIN_FORM.shouldBe(Condition.visible);
    }

    public void inputLogin(String login) {
        LOGIN_FORM.$(Selectors.byName("st.email")).shouldBe(Condition.visible).val(login);
    }

    public void inputPassword(String passwd) {
        LOGIN_FORM.$(Selectors.byName("st.password")).shouldBe(Condition.visible).val(passwd);
    }

    public HomePage submitAuth() {
        LOGIN_FORM.$(Selectors.byValue("Войти в Одноклассники")).shouldBe(Condition.visible).click();
        return new HomePage();
    }
}