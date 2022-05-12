package test;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import MainForm;



import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPageTest extends TestBase {

    MainForm mainForm = new MainForm();




    /*@Test
    @Description("Check logo wildberries")
    @DisplayName("Check logo wildberries")*/

   /* void checkLogoTest() {
        step("Открыть https://www.wildberries.ru/", () -> {
            open("https://www.wildberries.ru/");
        });
        step("Проверить что есть элемент с классом logo и он видимый", () -> {
            $(".nav-element__logo").should(Condition.visible);
        });
    }*/

    @Test
    @Description("Check search text 'сумка'")
    @DisplayName("Check search ")
    void checkSearchTest() {
        step("Open url 'https://www.wildberries.ru/'", () ->
                open("https://www.wildberries.ru/"));

        step("Ввести в поисковую строку «сумка»", () -> {
            $(".search-catalog__input").setValue("сумка").pressEnter();
        });

        step("Проверить что появился текст По запросу «сумка» найдено", () -> {
            $(".searching-results__title").shouldHave(text("По запросу «сумка» найдено"));
        });
    }

    @Test
    @Description("Check header Tab location")
    @DisplayName("Check Tab location")
    void checkHeaderLocationTest() {
        step("Open url 'https://www.wildberries.ru/'", () ->
                open("https://www.wildberries.ru/"));

        step("Перейти на страницу Адрес", () -> {
            $(".j-item-addresses").click();
        });

        step("Проверить что появился текст Информация о доставке и пунктах выдачи", () -> {
            $(".delivery-geo__title").shouldHave(text("Информация о доставке и пунктах выдачи"));
        });
    }

    @Test
    @Description("Check error auth empty input phone")
    @DisplayName("Check error auth")
    void checkAuthTest() {
        step("Open url 'https://www.wildberries.ru/'", () ->
                open("https://www.wildberries.ru/"));

        step("Перейти на страницу Авторизации", () -> {
            $(".j-main-login").click();
        });
        step("Не заполнять поле телефон. Сразу клик на Получить код", () -> {
            $("#requestCode").click();
        });
        step("Проверка текста ошибки", () -> {
            $(".j-error-full-phone").shouldHave(text("Введите номер телефона!"));
        });
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
