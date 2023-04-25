import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@RunWith(Parameterized.class)
public class ValidationTests extends BaseTest {

    SettingsPage settingsPage;
    PasswordPage passwordPage;

    @Step("зайдем на страницу настроек")
    private void initSettingsPage() {
        settingsPage = homePage.getSettingsPage();
    }

    @Step("зайдем на страницу изменения пароля")
    private void initPasswdPage() {
        passwordPage = settingsPage.getPasswordPage();
    }

    @Step("введем новый пароль")
    private void inputNewPasswd(String newPasswd) {
        passwordPage.setOldPassword(PASSWD).setNewPassword(newPasswd).submitPasswordChange();
    }

    @Owner("Andrey Liza")
    @Severity(value = SeverityLevel.CRITICAL)
    @Description("a test that checks the validity of a new password when changing the old one")
    @Feature("изменение пароля")
    @ParameterizedTest(name = "password validation")
    @ValueSource(strings = {"qwe", "1", "", "4d12f", "фыва3йьй4"})
    public void passwdValidationTest(String newPasswd) {
        initSettingsPage();
        initPasswdPage();
        inputNewPasswd(newPasswd);

        assertNotEquals(passwordPage.getInfoAfterChangingPasswd(), "Пароль изменен.");
    }
}
