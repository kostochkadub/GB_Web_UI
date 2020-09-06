package ru.geekbrains.main.site.at;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.geekbrains.main.site.at.BaseSettingsTest.BaseSettingsTest;
import ru.geekbrains.main.site.at.block.NavigationBlock.NameButton;
import ru.geekbrains.main.site.at.page.AuthorizationPage;


@Epic("Web UI Тест")
@Feature("Авторизация")
@Story("Успешная авторизация")
@DisplayName("Авторизация")
@Execution(ExecutionMode.CONCURRENT)
public class AuthorizationWebTest extends BaseSettingsTest {

    @Test
    void name1() {
        driver.get("https://geekbrains.ru/login");
        new AuthorizationPage(driver)
                .openURL()
                .singIn("hks47018@eoopy.com","hks47018")
                .checkPageName(NameButton.HOME);
    }
}
