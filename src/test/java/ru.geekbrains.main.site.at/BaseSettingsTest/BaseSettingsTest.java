package ru.geekbrains.main.site.at.BaseSettingsTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BaseSettingsTest {

    protected ChromeDriver driver;
    protected WebDriverWait wait30second;

    @BeforeEach
    public void beforeAllTest() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("-incognito");
        chromeOptions.addArguments("--disabled-notifications");
        chromeOptions.addArguments("--disabled-popup-blocking");
        chromeOptions.addArguments("--start-maximized");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        wait30second = new WebDriverWait(driver, 30);
    }

    @AfterEach
    public void afterAllTest() {
        driver.quit();
    }
}
