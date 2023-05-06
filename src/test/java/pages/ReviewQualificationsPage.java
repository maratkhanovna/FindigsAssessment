package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;

public class ReviewQualificationsPage extends CommonMethods {

    @FindBy(xpath = "(//div[@class = 'index-module_inner-text__4qU1f'])[12]")
    public WebElement readyButton;

    @FindBy(xpath = "(//div[@class = 'index-module_inner-text__4qU1f'])[11]")
    public WebElement goBackButton;

    public ReviewQualificationsPage(){
        PageFactory.initElements(driver, this);
    }

}

