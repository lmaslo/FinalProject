package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class AuthForm {

    //locators
    private SelenideElement buttonGetCode = $("#requestCode");
    private SelenideElement errorMessage = $(".j-error-full-phone");

    //actions
    public AuthForm authWithOutPhone() {
        step("Не заполнять поле телефон. Сразу клик на Получить код", () -> {
            buttonGetCode.click();
        });
        return this;
    }

    public AuthForm checkErrorMessage(String textErrorMassage) {
        step("Проверка текста ошибки", () -> {
            errorMessage.shouldHave(text(textErrorMassage));
        });
        return this;
    }
}
