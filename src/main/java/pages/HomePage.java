package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    private static final String NOTE = "//a[@class='pf-head_itx_a']";
    private static final String FEED_FILTER = "//div[@class='filter filter__nowrap h-mod']";
    private static final String FRIENDS = "[data-l=\"t,userFriend\"]";
    private static final String USER_DROPDOWN_MENU = "//*[@aria-controls='user-dropdown-menu']";
    private static final String SETTINGS_BUTTON = "//*[@class='u-menu']/li[1]//span[@class='u-menu_tx ellip-i lp']";

    @Override
    public void checkPage() {
        $(Selectors.byXpath(NOTE)).shouldBe(Condition.visible);
        $(Selectors.byXpath(FEED_FILTER)).shouldBe(Condition.visible);
    }

    public SettingsPage getSettingsPage() {
        $(Selectors.byXpath(USER_DROPDOWN_MENU)).shouldBe(Condition.visible).click();
        $(Selectors.byXpath(SETTINGS_BUTTON)).shouldBe(Condition.visible).click();
        return new SettingsPage();
    }

    public FriendsPage getFriendsPage() {
        $(By.cssSelector(FRIENDS)).shouldBe(Condition.visible).click();
        return new FriendsPage();
    }
}
