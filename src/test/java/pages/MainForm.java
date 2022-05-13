package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainForm {


    //locators
    private SelenideElement elementLogo = $(".nav-element__logo");
    private SelenideElement searchInput = $(".search-catalog__input");
    private SelenideElement searchResultTitle = $(".searching-results__title");
    private SelenideElement linkPageAddress = $(".j-item-addresses");
    private SelenideElement deliveryTitle = $(".delivery-geo__title");
    private SelenideElement linkPageAuth = $(".j-main-login");
    private SelenideElement buttonGetCode = $("#requestCode");
    private SelenideElement errorMessage = $(".j-error-full-phone");
    private SelenideElement menuBurger = $(".nav-element__burger");
    private SelenideElement catalogTitle = $(".catalog-title");
    private SelenideElement searchWithPhoto = $(".search-catalog__btn--photo");
    private SelenideElement photoInput = $("[type=file]");
    private SelenideElement searchPhotoResultTitle = $(".searching-results-title");


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

    public MainForm searchText(String textForSearch) {
        step("Ввести в поисковую строку " + textForSearch, () -> {
            searchInput.setValue(textForSearch).pressEnter();
        });
        return this;
    }

    public MainForm checkSearchTitle(String textForSearch) {
        step("Проверить что появился текст По запросу «" + textForSearch + "» найдено", () -> {
            searchResultTitle.shouldHave(text("По запросу «" + textForSearch + "» найдено"));
        });
        return this;
    }

    public MainForm goToPageAddress() {
        step("Перейти на страницу Адрес", () -> {
            linkPageAddress.click();
        });
        return this;
    }

    public MainForm checkDeliveryTitle(String textDeliveryTitle) {
        step("Проверить что появился текст" + textDeliveryTitle, () -> {
            deliveryTitle.shouldHave(text(textDeliveryTitle));
        });
        return this;
    }

    public MainForm goToPageAuth() {
        step("Перейти на страницу Адрес", () -> {
            linkPageAuth.click();
        });
        return this;
    }

    public MainForm authWithOutPhone() {
        step("Не заполнять поле телефон. Сразу клик на Получить код", () -> {
            buttonGetCode.click();
        });
        return this;
    }

    public MainForm checkErrorMessage(String textErrorMassage) {
        step("Проверка текста ошибки", () -> {
            errorMessage.shouldHave(text(textErrorMassage));
        });
        return this;
    }

    public MainForm openPageInMenuBurger(String titlePage) {
        step("Перейти на страницу " + titlePage + " через меню", () -> {
            menuBurger.click();
            $(withText(titlePage)).click();
        });
        return this;
    }

    public MainForm checkPageTitle(String titlePage) {
        step("Проверить текст заголовка страницы " + titlePage, () -> {
            catalogTitle.shouldHave(text(titlePage));
        });
        return this;
    }

    public MainForm searchWithPhoto(String fileName) {
        step("Загружаем файл для поиска. Выполнить поиск", () -> {
            searchWithPhoto.click();
            photoInput.uploadFromClasspath(fileName);
        });
        return this;
    }

    public MainForm checkSearchPhotoTitle(String titleSearchPhoto) {
        step("Проверить что появился текст «" + titleSearchPhoto, () -> {
            searchPhotoResultTitle.shouldHave(text(titleSearchPhoto));
            ;
        });
        return this;
    }
}