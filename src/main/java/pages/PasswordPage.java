package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class PasswordPage extends BasePage {

    private static final String PASSWD_CHANGE_AREA = "//div[@class='user-settings_password_body']";
    private final String SAVE_PASSWD = "//input[@value='Сохранить']";
    private final String INFO_AFTER_CHANGING = "//div[@class='iblock __warn user-settings_info_block __nomargin']//span";

    @Override
    public void checkPage() {
        Selenide.$(By.xpath(PASSWD_CHANGE_AREA)).shouldBe(Condition.visible);
    }

    public PasswordPage setOldPassword(String oldPasswd) {
        Selenide.$(By.id("field_oldPassword")).shouldBe(Condition.visible).val(oldPasswd);
        return this;
    }

    public PasswordPage setNewPassword(String newPasswd) {
        Selenide.$(By.id("field_newPassword")).shouldBe(Condition.visible).val(newPasswd);
        Selenide.$(By.id("field_retypePassword")).shouldBe(Condition.visible).val(newPasswd);
        return this;
    }

    public void submitPasswordChange() {
        Selenide.$(By.xpath(SAVE_PASSWD)).shouldBe(Condition.visible).click();
    }

    public String getInfoAfterChangingPasswd() {
        return Selenide.$(By.xpath(INFO_AFTER_CHANGING)).shouldBe(Condition.exist).getText();
    }
}
