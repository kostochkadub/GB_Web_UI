package ru.geekbrains.main.site.at.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.BasePage;

public class CoursePage extends BasePage {

    @FindBy(css = "[class*=\"nav \"] [href=\"#cour-new\"]")
    private WebElement coursesInCourses;

    @FindBy(css = "#filter-0")
    private WebElement freeCheckBox;

    @FindBy(css = "#filter-9")
    private WebElement testCheckBox;

    @FindBy(xpath = "//*[@id=\"courses-tab\"]//span[text()=\"Тестирование ПО. Уровень 2\"]")
    private WebElement coursesTabLevel2;

    @FindBy(xpath = "//*[@id=\"courses-tab\"]//span[text()=\"Тестирование ПО. Уровень 1\"]")
    private WebElement coursesTabLevel1;


    public CoursePage(WebDriver driver) {
        super(driver);
    }

    @Step("Поставить фильтры Бесплатные и Тестирование")
    public CoursePage setFilterFreeAndTest(){
        getFreeCheckBox().click();
        getTestCheckBox().click();
        return this;
    }

    @Step("Проверка, что обображается Тестирование ПО. Уровень 1 и Тестирование ПО. Уровень 2")
    public CoursePage checkTabsInCourse(){
        ExpectedConditions.visibilityOf(coursesTabLevel1);
        ExpectedConditions.visibilityOf(coursesTabLevel2);
        return this;
    }



    public WebElement getCoursesInCourses() {
        return coursesInCourses;
    }

    public WebElement getFreeCheckBox() {
        return freeCheckBox;
    }

    public WebElement getTestCheckBox() {
        return testCheckBox;
    }

    public WebElement getCoursesTabLevel2() {
        return coursesTabLevel2;
    }

    public WebElement getCoursesTabLevel1() {
        return coursesTabLevel1;
    }
}
