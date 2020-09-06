package ru.geekbrains.main.site.at.page;

import org.openqa.selenium.WebDriver;

public class HomePage extends BaseContentPage implements IOpenURL{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage openURL() {
        openPageInBrowser("https://geekbrains.ru/career");
        return this;
    }
}
