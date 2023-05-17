package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MessagePage extends BasePage {

    private static final String MESSENGER_MAIN = "messenger_main";
    private static final String INPUT_MSG_FIELD = "[data-tsid=\"write_msg_input-input\"]";
    private static final String MSG_FIELD = "//div[@class='js-lottie-observer']//div";
    private static final String SEND_MSG_BUTTON = "//div[@class='buttons __right']//msg-button[@data-l='t,sendButton']";
    private static final String MSG_MODIFY_BUTTON = "//msg-icon[@icon='menu']//*[name()='svg']";
    private static final String DELETE_BUTTON = "//msg-tico[@icon='delete']//span[@class='tico_tx']";
    private static final String CONFIRM_DELETE_BUTTON = "//msg-button[@data-tsid='confirm-primary']";

    private String lastSendingMessage = null;

    @Override
    public void checkPage() {
        $(By.className(MESSENGER_MAIN)).shouldBe(Condition.visible);
        $(By.cssSelector(INPUT_MSG_FIELD)).shouldBe(Condition.visible);
    }

    public MessagePage sendMessage(String message) {
        lastSendingMessage = message;
        $(By.xpath(MSG_FIELD)).should(Condition.visible).sendKeys(lastSendingMessage);
        $(By.xpath(SEND_MSG_BUTTON)).should(Condition.visible).click();
        return this;
    }

    public void deleteLastSendMessage() {
        $(By.xpath("//span[@data-tsid='message_text']//span[contains(text(),'" + lastSendingMessage + "')]"))
                .should(Condition.visible).hover();
        $(By.xpath(MSG_MODIFY_BUTTON)).should(Condition.visible).click();
        $(By.xpath(DELETE_BUTTON)).should(Condition.visible).click();
        $(By.xpath(CONFIRM_DELETE_BUTTON)).should(Condition.visible).click();
    }

    public boolean isLastMessageVisible() {
        SelenideElement msg = $(By.xpath("//div[@class=\"group\"]//span[contains(text(), '" + lastSendingMessage + "')]"));
        msg.shouldNotBe(Condition.visible.because("сообщение удалено"));
        return msg.is(Condition.visible);
    }
}

