package ru.geekbrains.main.site.at.block;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.BasePage;

public class HeaderBlock extends BasePage {

    @FindBy(css = "h2[class=\"gb-header__title\"]")
    private WebElement namePage;

    public HeaderBlock(WebDriver driver) {
        super(driver);
    }

    public WebElement getNamePage() {
        return namePage;
    }
}
