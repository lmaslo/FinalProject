package test;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AddressForm;
import pages.AuthForm;
import pages.MainForm;
import pages.SearchResultForm;


public class MainPageTest extends TestBase {

    MainForm mainForm = new MainForm();
    SearchResultForm searchResultForm = new SearchResultForm();
    AddressForm addressForm = new AddressForm();
    AuthForm authForm = new AuthForm();

    String textForSearch = "Сумка";
    String textDeliveryTitle = "Информация о доставке и пунктах выдачи";
    String textErrorMessage = "Введите номер телефона!";
    String titlePage = "Аксессуары";
    String fileName = "photo.jpg";
    String titleSearchPhoto = "Поиск по фото";


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
                .searchText(textForSearch);
        searchResultForm.checkSearchTitle(textForSearch);
    }

    @Test
    @Description("Check header Tab location")
    @DisplayName("Check Tab location")
    void checkHeaderLocationTest() {
        mainForm.openPage()
                .goToPageAddress();
        addressForm.checkDeliveryTitle(textDeliveryTitle);
    }

    @Test
    @Description("Check error auth empty input phone")
    @DisplayName("Check error auth")
    void checkAuthTest() {
        mainForm.openPage()
                .goToPageAuth();
        authForm.authWithOutPhone()
                .checkErrorMessage(textErrorMessage);
    }

    @Test
    void checkMenuBurger() {
        mainForm.openPage()
                .openPageInMenuBurger(titlePage);
        searchResultForm.checkPageTitle(titlePage);
    }

    @Test
    void SearchForPhoto() {
        mainForm.openPage()
                .searchWithPhoto(fileName);
        searchResultForm.checkSearchPhotoTitle(titleSearchPhoto);
    }
}
