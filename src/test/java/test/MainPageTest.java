package test;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainForm;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class MainPageTest extends TestBase {

    MainForm mainForm = new MainForm();
    String textForSearch = "Сумка";
    String textDeliveryTitle = "Информация о доставке и пунктах выдачи";
    String textErrorMessage = "Введите номер телефона!";

    @Test
    @Description("Checking the logo on the main page wildberries in the top menu")
    @DisplayName("Check logo wildberries")
    void checkLogoTest() {
        mainForm.openPage()
                .checkLogo();
    }

    @Test
    @Description("Check search text 'сумка'")
    @DisplayName("Check search ")
    void checkSearchTest() {
        mainForm.openPage()
                .searchText(textForSearch)
                .checkSearchTitle(textForSearch);
    }

    @Test
    @Description("Check header Tab location")
    @DisplayName("Check Tab location")
    void checkHeaderLocationTest() {
        mainForm.openPage()
                .goToPageAddress()
                .checkDeliveryTitle(textDeliveryTitle);
    }

    @Test
    @Description("Check error auth empty input phone")
    @DisplayName("Check error auth")
    void checkAuthTest() {
        mainForm.openPage()
                .goToPageAuth()
                .authWithOutPhone()
                .checkErrorMessage(textErrorMessage);
    }

    @Test
    void checkMenuBurger() {
        open("https://www.wildberries.ru/");
        $(".nav-element__burger").click();
        $(withText("Аксессуары")).click();
        $(".catalog-title").shouldHave(text("Аксессуары"));
    }

    @Test
    void SearchForPhoto() {
        open("https://www.wildberries.ru/");
        $(".search-catalog__btn--photo").click();
        $("[type=file]").uploadFromClasspath("photo.jpg");
        $(".searching-results-title").shouldHave(text("Поиск по фото"));
    }


}
