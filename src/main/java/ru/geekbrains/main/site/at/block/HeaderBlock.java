package ru.geekbrains.main.site.at.block;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.BasePage;
import ru.geekbrains.main.site.at.page.SearchPage;

public class HeaderBlock extends BasePage {

    @FindBy(css = "h2[class=\"gb-header__title\"]")
    private WebElement headerTitlePage;

    @FindBy(css = "[id='top-menu'] [class='show-search-form'] svg")
    protected WebElement buttonSearch;

    @FindBy(css = "input[class='search-panel__search-field']")
    protected WebElement inputSearch;

    @Step("Проверка что имя страницы равно: {exampleNamePage}")
    public HeaderBlock checkNamePage(String exampleNamePage) {
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(headerTitlePage, exampleNamePage));
        return this;
    }

    @Step("Ввод в функционал Поиска текст: '{text}'")
    public SearchPage searchText(String text) {
        buttonSearch.click();
        inputSearch.sendKeys(text);
        return new SearchPage(driver);
    }

    public HeaderBlock(WebDriver driver) {
        super(driver);
    }

}
