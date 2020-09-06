package ru.geekbrains.main.site.at;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.geekbrains.main.site.at.BaseSettingsTest.BaseSettingsTest;
import ru.geekbrains.main.site.at.block.CourseHeaderBlock;
import ru.geekbrains.main.site.at.block.NavigationBlock.NameButton;
import ru.geekbrains.main.site.at.page.AuthorizationPage;
import ru.geekbrains.main.site.at.page.CoursePage;

@Epic("Web UI Тест")
@Feature("Поиск")
@Story("Проверка отображения блоков")
@DisplayName("Страница Курсы")
@Execution(ExecutionMode.CONCURRENT)
public class CoursesWebTest extends BaseSettingsTest {

    @Test
    @DisplayName("Проверка работы фильтров")
    void testCourse() {

        ((CoursePage) new AuthorizationPage(driver)
                .openURL()
                .singIn("hks47018@eoopy.com", "hks47018")
                .checkPageName(NameButton.HOME)
                .getNavigationBlock().clickButton(NameButton.COURSES)//иногда кидает на https://courses.geekbrains.ru/

        ).getCourseHeaderBlock().clickButton(CourseHeaderBlock.NameButton.COURSES)
                .configFilter("Бесплатные", "Тестирование")
                .checkingDisplayedCourses(
                        "Тестирование ПО. Уровень 1",
                        "Тестирование ПО. Уровень 2"
                )
        ;

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
