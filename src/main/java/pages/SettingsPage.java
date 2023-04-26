package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class SettingsPage extends BasePage {

    private static final String MAIN_SETTINGS_AREA = "//*[@class='portlet']";
    private final String PASSWD_PAGE_BUTTON = "//*[@hrefattrs=\"st.cmd=userConfigChangePassword\"]";
    private final String PUBLICITY_SETTINGS_BUTTON = "//div[contains(@class,'tico null')][contains(text(),'Публичность')]";

    @Override
    public void checkPage() {
        Selenide.$(By.xpath(MAIN_SETTINGS_AREA)).shouldBe(Condition.visible);
    }

    public PasswordPage getPasswordPage() {
        Selenide.$(Selectors.byXpath(PASSWD_PAGE_BUTTON)).shouldBe(Condition.visible).click();
        return new PasswordPage();
    }

    public SelenideElement getRadioButton(Integer pos) {
        return Selenide.$(Selectors.byXpath("//tbody/tr[1]/td[" + ++pos + "]/input")).shouldBe(Condition.visible);
    }
}
