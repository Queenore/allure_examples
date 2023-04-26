package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    private static final String NOTE = "//a[@class='pf-head_itx_a']";
    private static final String FEED_FILTER = "//div[@class='filter filter__nowrap h-mod']";
    private final String FRIENDS = "//*[@aria-label='Друзья']";
    private final String USER_DROPDOWN_MENU = "//*[@aria-controls='user-dropdown-menu']";
    private final String SETTINGS_BUTTON = "//*[@class='u-menu']/li[1]//span[@class='u-menu_tx ellip-i lp']";

    @Override
    public void checkPage() {
        Selenide.$(Selectors.byClassName("photo")).shouldBe(Condition.visible);
        Selenide.$(Selectors.byXpath(NOTE)).shouldBe(Condition.visible);
        Selenide.$(Selectors.byXpath(FEED_FILTER)).shouldBe(Condition.visible);
    }

    public SettingsPage getSettingsPage() {
        Selenide.$(Selectors.byXpath(USER_DROPDOWN_MENU)).shouldBe(Condition.visible).click();
        Selenide.$(Selectors.byXpath(SETTINGS_BUTTON)).shouldBe(Condition.visible).click();
        return new SettingsPage();
    }

    public FriendsPage getFriendsPage() {
        $(byXpath(FRIENDS)).shouldBe(Condition.visible).click();
        return new FriendsPage();
    }
}
