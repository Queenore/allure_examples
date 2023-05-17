package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PasswordPage extends BasePage {

    private static final String PASSWD_CHANGE_AREA = "user-settings_password_body";
    private static final String SAVE_PASSWD = "[data-l=\"t,submit\"]";
    private static final String INFO_AFTER_CHANGING = "//div[@class='iblock __warn user-settings_info_block __nomargin']//span";
    private static final String ID_OLD_PASSWORD = "field_oldPassword";
    private static final String ID_NEW_PASSWORD = "field_newPassword";
    private static final String ID_RETYPE_NEW_PASSWORD = "field_retypePassword";

    @Override
    public void checkPage() {
        $(By.className(PASSWD_CHANGE_AREA)).shouldBe(Condition.visible);
    }

    public PasswordPage setOldPassword(String oldPasswd) {
        $(By.id(ID_OLD_PASSWORD)).shouldBe(Condition.visible).val(oldPasswd);
        return this;
    }

    public PasswordPage setNewPassword(String newPasswd) {
        $(By.id(ID_NEW_PASSWORD)).shouldBe(Condition.visible).val(newPasswd);
        $(By.id(ID_RETYPE_NEW_PASSWORD)).shouldBe(Condition.visible).val(newPasswd);
        return this;
    }

    public void submitPasswordChange() {
        $(By.cssSelector(SAVE_PASSWD)).shouldBe(Condition.visible).click();
    }

    public String getInfoAfterChangingPasswd() {
        return $(By.xpath(INFO_AFTER_CHANGING)).shouldBe(Condition.exist).getText();
    }
}
