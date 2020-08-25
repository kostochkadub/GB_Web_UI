package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.BaseSettingsTest.BaseSettingsTest;
import ru.geekbrains.main.site.at.block.NavigationBlock;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

//        Перейти на сайт https://geekbrains.ru/career
//        Нажать на кнопку Форум
//        Проверить что страница Форум открылась
//        Повторить для
//        Вебинары
//        Блог
//        Тесты
//        Карьера

public class NavigationTest extends BaseSettingsTest {

    NavigationBlock navigationBlock = PageFactory.initElements(driver,NavigationBlock.class);

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void checkTop(String expected, String cssSelectorText) {

        driver.findElement(By.cssSelector(cssSelectorText)).click();

        Assertions.assertEquals(
                expected,
                driver.findElement(By.cssSelector("h2[class=\"gb-header__title\"]")).getText()
        );
    }

    public static Stream<Arguments> dataProvider(){
        return Stream.of(
                Arguments.of("Вебинары","aside nav [href=\"/events\"]"),
                Arguments.of("Форум","aside nav [href=\"/topics\"]"),
                Arguments.of("Блог","aside nav [href=\"/posts\"]"),
                Arguments.of("Тесты","aside nav [href=\"/tests\"]"),
                Arguments.of("Карьера","aside nav [href=\"/career\"]")
        );
    }

    @AfterEach
    void headerAndFooter(){
        WebElement header =  driver.findElement(By.cssSelector("[class*=\"gb-header__content\"]"));
        WebElement footer =  driver.findElement(By.cssSelector("[class=\"site-footer\"]"));

        wait30second.until(ExpectedConditions.visibilityOf(header));
        wait30second.until(ExpectedConditions.visibilityOf(footer));
    }

}