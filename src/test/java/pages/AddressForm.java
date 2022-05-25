package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class AddressForm {
    //locators
    private SelenideElement deliveryTitle = $(".delivery-geo__title");

    //actions
    public AddressForm checkDeliveryTitle(String textDeliveryTitle) {
        step("Проверить что появился текст" + textDeliveryTitle, () -> {
            deliveryTitle.shouldHave(text(textDeliveryTitle));
        });
        return this;
    }
}
