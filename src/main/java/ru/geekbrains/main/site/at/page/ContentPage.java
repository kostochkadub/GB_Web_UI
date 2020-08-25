package ru.geekbrains.main.site.at.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.BasePage;
import ru.geekbrains.main.site.at.block.HeaderBlock;
import ru.geekbrains.main.site.at.block.NavigationBlock;


public class ContentPage extends BasePage {
    private HeaderBlock headerBlock;
    private NavigationBlock navigationBlock;

    @FindBy(css = "[class=\"gb-empopup-close\"]")
    private WebElement popUp1;

    @FindBy(css = "button>[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement popUp2;

    public ContentPage(WebDriver driver) {
        super(driver);
        this.headerBlock = new HeaderBlock(driver);
        this.navigationBlock = new NavigationBlock(driver);
    }

    public ContentPage checkPageName(String expectedNamePage) {
        WebElement namePage = headerBlock.getNamePage();
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(namePage, expectedNamePage));
        Assertions.assertEquals(expectedNamePage, namePage.getText());
        return this;
    }

    public HeaderBlock getHeaderBlock() {
        return headerBlock;
    }

    public NavigationBlock getNavigationBlock() {
        return navigationBlock;
    }

    public WebElement getPopUp1() {
        return popUp1;
    }

    public WebElement getPopUp2() {
        return popUp2;
    }
}
