package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Test;
import ru.geekbrains.main.site.at.BaseSettingsTest.BaseSettingsTest;
import ru.geekbrains.main.site.at.page.AuthorizationPage;
import ru.geekbrains.main.site.at.page.ContentPage;

public class AuthorizationWebTest extends BaseSettingsTest {
    @Test
    void name() {
        driver.get("https://geekbrains.ru/login");
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.getInputLogin().sendKeys("hks47018@eoopy.com");
        authorizationPage.getInputPassword().sendKeys("hks47018");
        authorizationPage.getButtonSingIn().click();
        ContentPage contentPage = new ContentPage(driver);
        contentPage.checkPageName("Главная");
    }

    @Test
    void name1() {
        driver.get("https://geekbrains.ru/login");
        new AuthorizationPage(driver)
                .singIn("hks47018@eoopy.com","hks47018")
                .checkPageName("Главная");
    }
}
