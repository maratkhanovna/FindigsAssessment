package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;

import java.util.List;

public class ApplicationPage extends CommonMethods {

    @FindBy(xpath = "//div[text() = 'Change property']")
    public WebElement changeProperty;

    @FindBy(xpath = "//div[text() = 'Select One']")
    public WebElement selectMoveInDate;

    @FindBy(xpath = "//button[@data-qa = 'application-button']")
    public WebElement startApplication;

    @FindBy(xpath = "(//div[@class = 'Header-Text mt-1'])[1]")
    public WebElement unitHeader;

    @FindBy(xpath = "//div[@class = 'react-datepicker__week']")
    public List<WebElement> weeks;

    public ApplicationPage(){
        PageFactory.initElements(driver, this);
    }

}
