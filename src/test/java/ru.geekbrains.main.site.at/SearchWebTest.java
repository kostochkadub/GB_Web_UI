package ru.geekbrains.main.site.at;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.BaseSettingsTest.BaseSettingsTest;
import ru.geekbrains.main.site.at.block.NavigationBlock;
import ru.geekbrains.main.site.at.block.SearchTestBlock;
import ru.geekbrains.main.site.at.page.AuthorizationPage;

import static org.hamcrest.Matchers.*;

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

@Epic("Web UI Тест")
@Feature("Поиск")
@Story("Проверка отображения всех блоков")
@DisplayName("Поиск")
@Execution(ExecutionMode.CONCURRENT)
public class SearchWebTest extends BaseSettingsTest {

    @DisplayName("Проверка количества контента")
    @Test
    @Description("Дополнительная информация по тесту")
    public void searchTextJava() {

        new AuthorizationPage(driver)
                .openURL()
                .singIn("hks47018@eoopy.com","hks47018")
                .checkPageName(NavigationBlock.NameButton.HOME)
                .getHeaderBlock()
                .searchText("java");

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
                .checkCount(SearchTestBlock.NameSearchButton.PROFESSION, greaterThanOrEqualTo(2))
                .checkCount(SearchTestBlock.NameSearchButton.COURSES, greaterThan(15))
                .checkCount(SearchTestBlock.NameSearchButton.WEBINARS, allOf(greaterThan(180), lessThan(300)))
                .checkCount(SearchTestBlock.NameSearchButton.BLOG, greaterThan(300))
                .checkCount(SearchTestBlock.NameSearchButton.FORUM, not(350))
                .checkCount(SearchTestBlock.NameSearchButton.TESTS, not(0));

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
