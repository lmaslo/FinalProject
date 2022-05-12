import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    static String remoteBrowser = System.getProperty("remoteBrowser", "selenoid.autotests.cloud/wd/hub");
    static String remoteBrowserUser = System.getProperty("remoteBrowserUser", "user1");
    static String remoteBrowserPassword = System.getProperty("remoteBrowserPassword", "1234");

   /* @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = "https://www.wildberries.ru/";
        Configuration.browserSize = "1920x1080";

        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.remote = "https://" + remoteBrowserUser + ":" + remoteBrowserPassword + "@" + remoteBrowser;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }*/

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www.wildberries.ru/";
        Configuration.browserSize = "1920x1080";
    }
}
