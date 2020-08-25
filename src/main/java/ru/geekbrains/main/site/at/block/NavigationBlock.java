package ru.geekbrains.main.site.at.block;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.BasePage;
import ru.geekbrains.main.site.at.page.CoursePage;

public class NavigationBlock extends BasePage {

    @FindBy(css = "[class=\"gb-left-menu__logo \"]")
    private WebElement icon;

    @FindBy(css = "[class=\"gb-left-menu__nav\"] [href=\"/courses\"]")
    private WebElement buttonCourses;

    @FindBy(css = "[class=\"gb-left-menu__nav\"] href='/events']")
    private WebElement buttonWebinars;

    @FindBy(css = "[class=\"gb-left-menu__nav\"] href=\"/topics\"]")
    private WebElement buttonForum;

    @FindBy(css = "[class=\"gb-left-menu__nav\"] href=\"/posts\"]")
    private WebElement buttonBlog;

    @FindBy(css = "[class=\"gb-left-menu__nav\"] href=\"/tests\"]")
    private WebElement buttonTests;

    @FindBy(css = "[class=\"gb-left-menu__nav\"] href=\"/career\"]")
    private WebElement buttonCareer;

    public NavigationBlock(WebDriver driver) {
        super(driver);
    }

    public CourseHeaderBlock clickButton(String nameButton){
        switch (nameButton){
            case "Иконка" : {
                this.icon.click();
                break;
            }
            case "Курсы" : {
                this.buttonCourses.click();
                break;
            }
            case "Вебинары" : {
                this.buttonWebinars.click();
                break;
            }
            case "Форум" : {
                this.buttonForum.click();
                break;
            }
            case "Блог" : {
                this.buttonBlog.click();
                break;
            }
            case "Тесты" : {
                this.buttonTests.click();
                break;
            }
            case "Карьера" : {
                this.buttonCareer.click();
                break;
            }
            default:{
                throw new RuntimeException("Кнопки: "+nameButton+" нет на странице!");
            }
        }
        return PageFactory.initElements(driver, CourseHeaderBlock.class);
    }
}
