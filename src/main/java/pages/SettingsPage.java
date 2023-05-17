package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SettingsPage extends BasePage {

    private static final String MAIN_SETTINGS_AREA = "portlet";
    private static final String PASSWD_PAGE_BUTTON = "[data-l=\"t,set_password\"]";

    @Override
    public void checkPage() {
        $(By.className(MAIN_SETTINGS_AREA)).shouldBe(Condition.visible);
    }

    public PasswordPage getPasswordPage() {
        $(By.cssSelector(PASSWD_PAGE_BUTTON)).shouldBe(Condition.visible).click();
        return new PasswordPage();
    }
}
