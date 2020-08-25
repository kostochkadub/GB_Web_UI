package ru.geekbrains.main.site.at.block;

import io.qameta.allure.Step;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.BasePage;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTestBlock extends BasePage {

    @FindBy(css = "[class='search-page-tabs'] [data-tab='professions']")
    private WebElement tabProf;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"courses\"]")
    private WebElement tabCourse;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"webinars\"]")
    private WebElement tabWebinars;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"blogs\"]")
    private WebElement tabBlogs;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"forums\"]")
    private WebElement tabForums;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"tests\"]")
    private WebElement tabTests;

    @FindBy(xpath = "//header//h2[text()=\"Вебинары\"]/../../../div[2]/div/div[1]//a[text()=\"Java Junior. Что нужно знать для успешного собеседования?\"]")
    private WebElement firstJavaJunior;

    @FindBy(xpath = "//div[@class=\"company-item-wrapper\"]//a[text()=\"Образовательный портал GeekBrains\"]")
    private WebElement textGeekBrains;

    public SearchTestBlock(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка задания из 5-ого урока")
    public SearchTestBlock checkFirstJavaJuniorAndTextGeekBrains() {
        ExpectedConditions.visibilityOf(firstJavaJunior);
        ExpectedConditions.visibilityOf(textGeekBrains);
        return this;
    }

    @Step("Проверка кол-ва {tabName}")
    public SearchTestBlock checkCount(String tabName, Matcher<Integer> matcher) {
        String actualCount = getTab(tabName).findElement(By.cssSelector("span")).getText();
        assertThat(Integer.parseInt(actualCount), matcher);
        return this;
    }


    private WebElement getTab(String tabName) {
        switch (tabName) {
            case "Профессии":
                return tabProf;
            case "Курсы":
                return tabCourse;
            case "Вебинары":
                return tabWebinars;
            case "Блоги":
                return tabBlogs;
            case "Форумы":
                return tabForums;
            case "Тесты":
                return tabTests;
            default:
                throw new RuntimeException("Элемента: " + tabName + " нет на странице!");
        }
    }

}
