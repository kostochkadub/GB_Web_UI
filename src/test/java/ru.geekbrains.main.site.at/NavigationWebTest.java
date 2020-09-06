package ru.geekbrains.main.site.at;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.BaseSettingsTest.BaseSettingsTest;
import ru.geekbrains.main.site.at.page.HomePage;

import java.util.stream.Stream;

import static ru.geekbrains.main.site.at.block.NavigationBlock.NameButton;

//        Перейти на сайт https://geekbrains.ru/career
//        Нажать на кнопку Форум
//        Проверить что страница Форум открылась
//        Повторить для
//        Вебинары
//        Блог
//        Тесты
//        Карьера

@Epic("Web UI тесты")
@Feature("Навигация")
@Story("Переход по навигации")
@DisplayName("Навигация")
@Execution(ExecutionMode.CONCURRENT)
public class NavigationWebTest extends BaseSettingsTest {

    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
    @MethodSource("dataProvider")
    public void checkNavigationNotPopUp(NameButton nameButton) {
        new HomePage(driver)
                .openURL()
                .getNavigationBlock().clickButton(nameButton)
                .checkPageName(nameButton);
    }

    public static Stream<NameButton> dataProvider(){
        return Stream.of(
                NameButton.WEBINARS,
                NameButton.FORUM,
                NameButton.BLOG,
                NameButton.TESTS,
                NameButton.CAREER
        );
    }

    @DisplayName("Проверка страницы Блог с PopUP")
    @Test
    public void checkNavigationPopUp() {

        new HomePage(driver)
                .openURL()
                .getNavigationBlock().clickButton(NameButton.BLOG)
                .closePopUp()
                .checkPageName(NameButton.BLOG);
    }

    @AfterEach
    void headerAndFooter(){
        WebElement header =  driver.findElement(By.cssSelector("[class*=\"gb-header__content\"]"));
        WebElement footer =  driver.findElement(By.cssSelector("[class=\"site-footer\"]"));

        wait30second.until(ExpectedConditions.visibilityOf(header));
        wait30second.until(ExpectedConditions.visibilityOf(footer));
    }

}