package test;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainForm;


public class MainPageTest extends TestBase {

    MainForm mainForm = new MainForm();
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
        mainForm.openPage()
                .openPageInMenuBurger(titlePage)
                .checkPageTitle(titlePage);
    }

    @Test
    void SearchForPhoto() {
        mainForm.openPage()
                .searchWithPhoto(fileName)
                .checkSearchPhotoTitle(titleSearchPhoto);
    }


}
