package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FriendsPage extends BasePage {

    private SelenideElement userGridCard = null;

    private static final String FRIENDS_AREA = "//*[@class='portlet']";
    private static final String GRID_CARD = "//*[@class='user-grid-card __s']";
    private static final String SEND_MSG = "[data-l=\"t,sendMessage\"]";

    @Override
    public void checkPage() {
        $(By.xpath(FRIENDS_AREA)).shouldBe(Condition.visible);
    }

    public FriendsPage getUserGridCard() {
        userGridCard = $(By.xpath(GRID_CARD));
        userGridCard.shouldBe(Condition.visible.because("друг есть!"));
        return this;
    }

    public MessagePage getMessagePage() {
        if (userGridCard == null) {
            throw new IllegalStateException(
                    "userGridCard variable should be not null; call before getUserGridCard() method or make friends"
            );
        }
        userGridCard.$(By.cssSelector(SEND_MSG)).click();
        return new MessagePage();
    }
}
