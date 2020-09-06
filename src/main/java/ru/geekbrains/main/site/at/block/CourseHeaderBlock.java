package ru.geekbrains.main.site.at.block;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.BasePage;
import ru.geekbrains.main.site.at.page.CoursePage;

public class CourseHeaderBlock extends BasePage {

    @FindBy(css = "#prof-link")
    private WebElement buttonProfessions;

    @FindBy(css = "#free-link")
    private WebElement buttonFreeIntensive;

    @FindBy(css = "[class*='nav nav-tabs'] [id='cour-link']")
    private WebElement buttonCourses;

    @FindBy(css = "[class*=\"nav nav-tabs\"] [href*=\"https://forbusiness.geekbrains\"]")
    private WebElement buttonCompanies;

    public CourseHeaderBlock(WebDriver driver) {
        super(driver);
    }

    public CoursePage clickButton(NameButton nameButton) {
        switch (nameButton) {
            case PROFESSIONS: {
                this.buttonProfessions.click();
                break;
            }
            case FREEINTENSIVE:{
                this.buttonFreeIntensive.click();
                break;
            }
            case COURSES: {
                this.buttonCourses.click();
                break;
            }
            case COMPANIES:{
                this.buttonCompanies.click();
                break;
            }
            default: {
                throw new NotFoundException("Не найдена кнопка с именем: " + nameButton);
            }
        }
        return new CoursePage(driver);
    }

    public enum NameButton {
        PROFESSIONS("Профессии"),
        FREEINTENSIVE("Бесплатные интенсивы"),
        COURSES("Курсы"),
        COMPANIES("Компаниям");

        NameButton(String text) {
            this.text = text;
        }

        private String text;

        public String getText() {
            return text;
        }
    }
}
