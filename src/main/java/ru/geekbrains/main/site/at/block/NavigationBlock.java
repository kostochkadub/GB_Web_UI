package ru.geekbrains.main.site.at.block;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.BasePage;
import ru.geekbrains.main.site.at.page.*;
import ru.geekbrains.main.site.at.utils.ButtonNotFoundException;

public class NavigationBlock extends BasePage {

    @FindBy(css = "[class=\"gb-left-menu__logo \"]")
    private WebElement icon;

    @FindBy(css = "[class=\"gb-left-menu__nav\"] [href=\"/courses\"]")
    private WebElement buttonCourses;

    @FindBy(css = "[class=\"gb-left-menu__nav\"] [href='/events']")
    private WebElement buttonWebinars;

    @FindBy(css = "[class=\"gb-left-menu__nav\"] [href=\"/topics\"]")
    private WebElement buttonForum;

    @FindBy(css = "[class=\"gb-left-menu__nav\"] [href=\"/posts\"]")
    private WebElement buttonBlog;

    @FindBy(css = "[class=\"gb-left-menu__nav\"] [href=\"/tests\"]")
    private WebElement buttonTests;

    @FindBy(css = "[class=\"gb-left-menu__nav\"] [href=\"/career\"]")
    private WebElement buttonCareer;


    public NavigationBlock(WebDriver driver) {
        super(driver);
    }

    @Step("Нажатие в Навигации на кнопку: '{nameButton}'")
    public BaseContentPage clickButton(NameButton nameButton) {
        BaseContentPage baseContentPage = null;

        switch (nameButton) {
        case HOME: {
            baseContentPage = new HomePage(driver);
            break;
        }
        case COURSES: {
            this.buttonCourses.click();
            baseContentPage = new CoursePage(driver);
            break;
        }
        case WEBINARS: {
            this.buttonWebinars.click();
            baseContentPage = new WebinarsPage(driver);
            break;
        }
        case FORUM: {
            this.buttonForum.click();
            baseContentPage = new ForumPage(driver);
            break;
        }
        case BLOG: {
            this.buttonBlog.click();
            baseContentPage = new BlogPage(driver);
            break;
        }
        case TESTS: {
            this.buttonTests.click();
            baseContentPage = new TestsPage(driver);
            break;
        }
        case CAREER: {
            this.buttonCareer.click();
            baseContentPage = new CareerPage(driver);
            break;
        } default:{
            throw new ButtonNotFoundException("Кнопки: " + nameButton + " нет на странице!\n" +
                    "Или условие не описано в switch!");
        }
    }
        return  baseContentPage;
}

    public enum NameButton {
        HOME("Главная"),
        COURSES("Курсы"),
        WEBINARS("Вебинары"),
        FORUM("Форум"),
        BLOG("Блог"),
        TESTS("Тесты"),
        CAREER("Карьера");

        NameButton(String text) {
            this.text = text;
        }

        private String text;

        public String getText() {
            return text;
        }
    }
}
