package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage extends BasePage {

    private static final SelenideElement LOGIN_FORM = $(By.className("js-login-form"));
    private static final By USERNAME_LOCATOR = By.id("field_email");
    private static final By PASSWORD_LOCATOR = By.id("field_password");


    @Override
    public void checkPage() {
        LOGIN_FORM.shouldBe(Condition.visible);
    }

    public SelenideElement getUsernameElement() {
        return $(USERNAME_LOCATOR).shouldBe(Condition.visible);
    }

    public SelenideElement getPasswordElement() {
        return $(PASSWORD_LOCATOR).shouldBe(Condition.visible);
    }
    public HomePage login(String login, String password) {
        getUsernameElement().setValue(login).pressTab();
        getPasswordElement().setValue(password).pressEnter();
        return new HomePage();
    }
}