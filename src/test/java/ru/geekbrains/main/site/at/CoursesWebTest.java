package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.BaseSettingsTest.BaseSettingsTest;
import ru.geekbrains.main.site.at.page.AuthorizationPage;

public class CoursesWebTest extends BaseSettingsTest {
    @Test
    void testCourse() {
        driver.get("https://geekbrains.ru/login");
        driver.manage().window().maximize();

        PageFactory.initElements(driver, AuthorizationPage.class)
                .singIn("hks47018@eoopy.com", "hks47018")
                .checkPageName("Главная")
                .getNavigationBlock().clickButton("Курсы")
                .clickButton("Курсы")
                .setFilterFreeAndTest()
                .checkTabsInCourse();

        /*Реализовать тест:
        1. Перейти на страницу авторизация https://geekbrains.ru/login
        2. Ввести логин : hks47018@eoopy.com
        3. Пароль: hks47018
        4. Нажать кнопку войти
        5. Проверить что отобразилась страница "Главная"
        6. Нажать в навигации "Курсы"
        7. Нажать в шапке сайта "Курсы"
        8. Выбрать в фильтрах чекбокс "Бесплатные"
        9. Выбрать в фильтрах чекбокс "Тестирование"
        10. Проверить что в выборке отображается курсы "Тестирование ПО. Уровень 1"
        11. Проверить что в выборке отображается курсы "Тестирование ПО. Уровень 2"*/
    }
}
