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
    public SearchTestBlock checkCount(NameSearchButton nameSearchButton, Matcher<Integer> matcher) {
        String actualCount = getTab(nameSearchButton).findElement(By.cssSelector("span")).getText();
        assertThat(Integer.parseInt(actualCount), matcher);
        return this;
    }

    private WebElement getTab(NameSearchButton nameSearchButton) {
        switch (nameSearchButton) {
            case PROFESSION:
                return tabProf;
            case COURSES:
                return tabCourse;
            case WEBINARS:
                return tabWebinars;
            case BLOG:
                return tabBlogs;
            case FORUM:
                return tabForums;
            case TESTS:
                return tabTests;
            default:
                throw new RuntimeException("Элемента: " + nameSearchButton + " нет на странице!");
        }
    }

    public enum NameSearchButton {
        PROFESSION("Главная"),
        COURSES("Курсы"),
        WEBINARS("Вебинары"),
        FORUM("Форум"),
        BLOG("Блог"),
        TESTS("Тесты");

        NameSearchButton(String text) {
            this.text = text;
        }

        private String text;

        public String getText() {
            return text;
        }
    }

}
