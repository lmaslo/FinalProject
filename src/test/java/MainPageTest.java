import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPageTest extends TestBase{
    @Test
    @Description("Check logo wildberries")
    @DisplayName("Check logo wildberries")
    void checkLogoTest() {
        step("Открыть https://www.wildberries.ru/", () -> {
            open("https://www.wildberries.ru/");
        });
        step("Проверить что есть элемент с классом logo и он видимый", () -> {
            $(".nav-element__logo").should(Condition.visible);
        });
    }

}
