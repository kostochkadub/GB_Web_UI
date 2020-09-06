package ru.geekbrains.main.site.at.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.BasePage;
import ru.geekbrains.main.site.at.block.HeaderBlock;
import ru.geekbrains.main.site.at.block.NavigationBlock;


public class BaseContentPage extends BasePage {

    private HeaderBlock headerBlock;
    private NavigationBlock navigationBlock;

    @FindBy(css = "[class=\"gb-empopup-close\"]")
    private WebElement popUp1;

    @FindBy(css = "button>[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement popUp2;

    public BaseContentPage(WebDriver driver) {
        super(driver);
        this.headerBlock = new HeaderBlock(driver);
        this.navigationBlock = new NavigationBlock(driver);
    }

    public BaseContentPage checkPageName(NavigationBlock.NameButton nameButton) {
        headerBlock.checkNamePage(nameButton.getText());
        return this;
    }

    @Step("Закрытие PopUp-ов")
    public BaseContentPage closePopUp(){
        //popUp1.click();
        popUp2.click();
        return this;
    }

    public HeaderBlock getHeaderBlock() {
        return headerBlock;
    }

    public NavigationBlock getNavigationBlock() {
        return navigationBlock;
    }

}
