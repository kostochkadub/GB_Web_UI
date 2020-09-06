package ru.geekbrains.main.site.at.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.block.CourseHeaderBlock;

import java.util.List;

public class CoursePage extends BaseContentPage {

    private CourseHeaderBlock courseHeaderBlock;

    @FindBy(css = "[class*=\"nav \"] [href=\"#cour-new\"]")
    private WebElement coursesInCourses;

    @FindBy(xpath = "//form/ul//label")
    private List<WebElement> filterList;

    @FindBy(css = "#filter-0")
    private WebElement freeCheckBox;

    @FindBy(xpath = "//a/div/div/span")
    private List<WebElement> courseList;

    @FindBy(css = "#filter-9")
    private WebElement testCheckBox;

    @FindBy(xpath = "//*[@id=\"courses-tab\"]//span[text()=\"Тестирование ПО. Уровень 2\"]")
    private WebElement coursesTabLevel2;

    @FindBy(xpath = "//*[@id=\"courses-tab\"]//span[text()=\"Тестирование ПО. Уровень 1\"]")
    private WebElement coursesTabLevel1;


    public CoursePage(WebDriver driver) {
        super(driver);
        this.courseHeaderBlock = new CourseHeaderBlock(driver);
    }

    @Step("Настройка фильтра курсов: '{args}'")
    public CoursePage configFilter(String... args) {
        for (String test : args) {
            WebElement element = findElement(filterList, test);
            element.click();
        }
        return this;
    }

    @Step("Проверка отображения курсов: '{args}'")
    public CoursePage checkingDisplayedCourses(String... args) {
        for (String test : args) {
            WebElement element = findElement(courseList, test);
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
        }
        return this;
    }

    public CourseHeaderBlock getCourseHeaderBlock() {
        return courseHeaderBlock;
    }

}
