package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.CommonMethods;

public class YourHouseholdPage extends CommonMethods {
    @FindBy(xpath = "(//*[@class = 'check'])[1]" )
    public WebElement numberOfHouseHold0;
    @FindBy(id = "1")
    public WebElement numberOfHouseHold1;
    @FindBy(id = "2")
    public WebElement numberOfHouseHold2;
    @FindBy(id = "3")
    public WebElement numberOfHouseHold3;
    @FindBy (xpath = "//div[text() = 'Save and Continue']")
    public WebElement saveButtonAndContinue;
    @FindBy(id = "0")
    public WebElement children0;
    @FindBy(id = "1")
    public WebElement children1;
    @FindBy(id = "2")
    public WebElement children2;
    @FindBy(id = "3")
    public WebElement children3;
    @FindBy(id = "0")
    public WebElement vehicle0;
    @FindBy(id = "1")
    public WebElement vehicle01;
    @FindBy(id = "2")
    public WebElement vehicle02;
    @FindBy(id = "3")
    public WebElement vehicle03;
    @FindBy(id = "0")
    public WebElement pets0;
    @FindBy(id = "1")
    public WebElement pets1;
    @FindBy(id = "2")
    public WebElement pets2;
    @FindBy(id = "3")
    public WebElement pets3;
    @FindBy(id = "isTrue-False")
    public WebElement noSmokerButton;

}
