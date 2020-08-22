package ru.geekbrains.main.site.at;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

        String numberProf = driver.findElement(By.cssSelector("[class=\"search-page-tabs\"] [data-tab=\"professions\"] span")).getText();
        int x = Integer.parseInt(numberProf);
        MatcherAssert.assertThat(x, Matchers.greaterThanOrEqualTo(2));
        //Assertions.assertTrue(x>=2);

        String numberCourse = driver.findElement(By.cssSelector("[class=\"search-page-tabs\"] [data-tab=\"courses\"] span")).getText();
        x = Integer.parseInt(numberCourse);
        MatcherAssert.assertThat(x, Matchers.greaterThan(15));
        //Assertions.assertTrue (x>15);

        String numberWebinars = driver.findElement(By.cssSelector("[class=\"search-page-tabs\"] [data-tab=\"webinars\"] span")).getText();
        x = Integer.parseInt(numberWebinars);
        MatcherAssert.assertThat(x, Matchers.allOf(Matchers.greaterThan(180), Matchers.lessThan(300)));
        //Assertions.assertTrue(x>180 && x<300);

        String numberBlogs = driver.findElement(By.cssSelector("[class=\"search-page-tabs\"] [data-tab=\"blogs\"] span")).getText();
        x = Integer.parseInt(numberBlogs);
        MatcherAssert.assertThat(x, Matchers.greaterThan(300));
        //Assertions.assertTrue (x>300);

        String numberForums = driver.findElement(By.cssSelector("[class=\"search-page-tabs\"] [data-tab=\"forums\"] span")).getText();
        x = Integer.parseInt(numberForums);
        MatcherAssert.assertThat(x, Matchers.not(15));
        //Assertions.assertTrue (x!=350);

        String numberTests = driver.findElement(By.cssSelector("[class=\"search-page-tabs\"] [data-tab=\"tests\"] span")).getText();
        x = Integer.parseInt(numberTests);
        MatcherAssert.assertThat(x, Matchers.greaterThan(0));
        //Assertions.assertTrue (x>0);

        WebElement firstJavaJunior = driver.findElement(By.xpath("//header//h2[text()=\"Вебинары\"]/../../../div[2]/div/div[1]//a[text()=\"Java Junior. Что нужно знать для успешного собеседования?\"]"));
        wait30second.until(ExpectedConditions.visibilityOf(firstJavaJunior));

        WebElement textGeekBrains = driver.findElement(By.xpath("//div[@class=\"company-item-wrapper\"]//a[text()=\"Образовательный портал GeekBrains\"]"));
        wait30second.until(ExpectedConditions.visibilityOf(textGeekBrains));

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
