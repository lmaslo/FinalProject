import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainForm {


    //locators
    private SelenideElement elementLogo = $(".nav-element__logo");




    //actions

    public MainForm openPage() {
        step("Открываем главную страницу wildberries", () -> {
            open("https://www.wildberries.ru/");
        });
        return this;
    }

    public MainForm checkLogo() {
        step("Проверить что есть элемент с классом logo и он видимый", () -> {
            elementLogo.should(Condition.visible);
        });
        return this;
    }
}

