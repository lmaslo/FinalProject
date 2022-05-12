package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class BaseForm {
    //locators
    private SelenideElement elementLogo = $(".nav-element__logo");




    //actions

    public BaseForm openPage() {
        step("Открываем главную страницу wildberries", () -> {
            open("https://www.wildberries.ru/");
        });
        return this;
    }
}
