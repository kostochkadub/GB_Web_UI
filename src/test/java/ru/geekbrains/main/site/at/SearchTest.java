package ru.geekbrains.main.site.at;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.BaseSettingsTest.BaseSettingsTest;
import ru.geekbrains.main.site.at.block.SearchTestBlock;
import ru.geekbrains.main.site.at.page.AuthorizationPage;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Перейти на сайт https://geekbrains.ru/courses
//        Нажать на кнопку Поиск
//        В поле Поиск ввести текст: java
//        Проверить что отобразились блоки:
//        Профессии
//        Курсы
//        Вебинары
//        Блоги
//        Форум
//        Тесты
//        Проекты и компании

public class SearchTest extends BaseSettingsTest {

    @Test
    public void searchTextJava() {
        driver.get("https://geekbrains.ru/login");

        driver.manage().window().maximize();

        new AuthorizationPage(driver)
                .singIn("hks47018@eoopy.com","hks47018");

        WebElement buttonSearch = driver.findElement(By.cssSelector("a>[class=\"svg-icon icon-search \"]"));
        buttonSearch.click();

        WebElement inputSearch = driver.findElement(By.cssSelector("[class=\"search-panel__search-field\"]"));
        inputSearch.sendKeys("java");

        WebElement textProfessions = driver.findElement(By.cssSelector("[id=\"professions\"] h2"));
        WebElement textCourses = driver.findElement(By.xpath("//header//h2[text()=\"Курсы\"]"));
        WebElement textWebinar = driver.findElement(By.xpath("//header//h2[text()=\"Вебинары\"]"));
        WebElement textBlog = driver.findElement(By.xpath("//header//h2[text()=\"Блоги\"]"));
        WebElement textForum = driver.findElement(By.xpath("//header//h2[text()=\"Форум\"]"));
        WebElement textTests = driver.findElement(By.xpath("//header//h2[text()=\"Тесты\"]"));
        WebElement textProject = driver.findElement(By.xpath("//header//h2[text()=\"Проекты и компании\"]"));

        wait30second.until(ExpectedConditions.visibilityOf(textProfessions));
        wait30second.until(ExpectedConditions.visibilityOf(textCourses));
        wait30second.until(ExpectedConditions.visibilityOf(textWebinar));
        wait30second.until(ExpectedConditions.visibilityOf(textBlog));
        wait30second.until(ExpectedConditions.visibilityOf(textForum));
        wait30second.until(ExpectedConditions.visibilityOf(textTests));
        wait30second.until(ExpectedConditions.visibilityOf(textProject));

        PageFactory.initElements(driver, SearchTestBlock.class)
                .checkFirstJavaJuniorAndTextGeekBrains()
                .checkCount("Профессии", greaterThanOrEqualTo(2))
                .checkCount("Курсы", greaterThan(15))
                .checkCount("Вебинары", allOf(greaterThan(180), lessThan(300)))
                .checkCount("Блоги", greaterThan(300))
                .checkCount("Форумы", not(350))
                .checkCount("Тесты", not(0));

        /*Профессий не менее чем 2
        Курсов более 15
        Вебинаров больше чем 180, но меньше 300
        В вебинарах отображается первым “Java Junior. Что нужно знать для успешного собеседования?”
        Блогов более 300
        Форумов не 350
        Тестов не 0
        В Проектах и компаниях отображается GeekBrains*/


    }
}
