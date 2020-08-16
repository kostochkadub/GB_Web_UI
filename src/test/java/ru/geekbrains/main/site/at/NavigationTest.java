package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//        Перейти на сайт https://geekbrains.ru/career
//        Нажать на кнопку Форум
//        Проверить что страница Форум открылась
//        Повторить для
//        Вебинары
//        Блог
//        Тесты
//        Карьера

public class NavigationTest extends BaseSettingsTest {

    @Test
    public void checkEvents() {
        WebElement eventsButton = driver.findElement(By.cssSelector("aside nav [href=\"/events\"]"));
        eventsButton.click();

        WebElement eventsTitlePage = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Вебинары", eventsTitlePage.getText());
    }

    @Test
    public void checkContentPagesTopics() {
        //        href="/topics"
        driver.findElement(By.cssSelector("aside nav [href=\"/topics\"]")).click();
        String textTopics = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]")).getText();
        Assertions.assertEquals("Форум", textTopics);
    }
    @Test
    public void checkContentPagesPosts() {
        //        href="/posts"
        driver.findElement(By.cssSelector("aside nav [href=\"/posts\"]")).click();
        String textPosts = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]")).getText();
        Assertions.assertEquals("Блог", textPosts);
    }
    @Test
    public void checkContentPagesTests() {
        //        href="/tests"

//        driver.findElement(By.cssSelector("[class=\"gb-empopup-close\"]")).click();
//        driver.findElement(By.cssSelector("button>[class=\"svg-icon icon-popup-close-button \"]")).click();

        driver.findElement(By.cssSelector("aside nav [href=\"/tests\"]")).click();
        String textTest = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]")).getText();
        Assertions.assertEquals("Тесты", textTest);
    }
    @Test
    public void checkContentPagesCareer() {
//        href="/career"
        driver.findElement(By.cssSelector("aside nav [href=\"/career\"]")).click();
        String textCareer = driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]")).getText();
        Assertions.assertEquals("Карьера", textCareer);

    }

}