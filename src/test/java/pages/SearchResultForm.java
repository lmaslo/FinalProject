package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SearchResultForm {

    //locators
    private SelenideElement searchResultTitle = $(".searching-results__title");
    private SelenideElement catalogTitle = $(".catalog-title");
    private SelenideElement searchPhotoResultTitle = $(".searching-results-title");

    //actions
    public SearchResultForm checkSearchTitle(String textForSearch) {
        step("Проверить что появился текст По запросу «" + textForSearch + "» найдено", () -> {
            searchResultTitle.shouldHave(text("По запросу «" + textForSearch + "» найдено"));
        });
        return this;
    }

    public SearchResultForm checkPageTitle(String titlePage) {
        step("Проверить текст заголовка страницы " + titlePage, () -> {
            catalogTitle.shouldHave(text(titlePage));
        });
        return this;
    }

    public SearchResultForm checkSearchPhotoTitle(String titleSearchPhoto) {
        step("Проверить что появился текст «" + titleSearchPhoto, () -> {
            searchPhotoResultTitle.shouldHave(text(titleSearchPhoto));
        });
        return this;
    }
}
