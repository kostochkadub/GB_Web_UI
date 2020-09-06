package ru.geekbrains.main.site.at;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.block.HeaderBlock;
import ru.geekbrains.main.site.at.block.NavigationBlock;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    private HeaderBlock headerBlock;
    private NavigationBlock navigationBlock;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    @Step("Открыта страница {url}")
    protected void openPageInBrowser(String url){

        driver.get(url);
    }

    @Step("Поиск элемента в коллекции по тексту: '{expectedText}'")
    protected WebElement findElement(List<WebElement> list, String expectedText) {
        List<String> arrayList = new ArrayList<>();
        for (WebElement webElement : list) {
            String actualText = webElement.getText();
            arrayList.add(actualText);
            if (actualText.toLowerCase().trim().equals(expectedText.toLowerCase().trim())) {
                return webElement;
            }
        }
        throw new RuntimeException("В коллекции элементов: " + arrayList + "\nНе найден элемент с тектом: " + expectedText);
    }

    public NavigationBlock getNavigationBlock() {
        return navigationBlock;
    }
}
