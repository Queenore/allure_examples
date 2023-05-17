import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Flaky;
import io.qameta.allure.Link;
import io.qameta.allure.Links;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import pages.FriendsPage;
import pages.MessagePage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class MessagingTests extends BaseTest {

    FriendsPage friendsPage;
    MessagePage messagePage;
    String param = "PARAMETER FOR EXAMPLE";

    @Step("зайдем на страницу друзей; param = {param}; вложенный степ")
    private void initFriendsPage(String param) {
        friendsPage = homePage.getFriendsPage();
    }

    @Step("зайдем в чат, внешний степ")
    private void initMessagePage() {
        initFriendsPage(param);
        messagePage = friendsPage.getUserGridCard().getMessagePage();
    }

    @Attachment(value = "файлик с категориями", type = "application/json", fileExtension = ".json")
    @Step("удалим последнее отправленное сообщение")
    private byte[] deleteLastSendingMessage(String message) throws IOException {
        messagePage.sendMessage(message).deleteLastSendMessage();
        return Files.readAllBytes(Paths.get("categories.json"));
    }

    @Flaky
    @Epic("манипуляции с сообщениями")
    @Description("проверка удаления отправленного сообщения")
    @Owner("Andrey Liza")
    @Severity(value = SeverityLevel.MINOR)
    @Links({
            @Link(name = "ok link", url = "https://ok.ru/"),
            @Link(name = "vk link", url = "https://vk.com/")
    })
    @Test
    public void sendAndDeleteMessageTest() throws IOException {
        initMessagePage();

        String message = RandomStringUtils.random(20, true, true);
        deleteLastSendingMessage(message);

        assertFalse(messagePage.isLastMessageVisible());
    }
}
