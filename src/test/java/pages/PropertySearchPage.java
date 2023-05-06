package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;

public class PropertySearchPage extends CommonMethods {

    @FindBy(xpath = "//input[@type = 'text']")
    public WebElement searchTextField;

    @FindBy(xpath = "//button[text() = 'all cities']")
    public WebElement allCitiesFilterButton;

    @FindBy(xpath = "//button[text() = 'auto city']")
    public WebElement autoCityFilterButton;

    @FindBy(xpath = "//button[contains(text(), 'long city')]")
    public WebElement longCityFilterButton;

    @FindBy(xpath = "//button[text() = 'manual city']")
    public WebElement manualCityFilterButton;

    @FindBy(xpath = "(//div[@class = 'index-module_select-button__faPTj'])[1]")
    public WebElement autoCityApt12;

    @FindBy(xpath = "(//div[@class = 'index-module_select-button__faPTj'])[2]")
    public WebElement autoCityApt17;

    @FindBy(xpath = "(//h2[@class = 'index-module_text-hover__z4b5N'])[1]")
    public WebElement autoCityApt12Header;

    @FindBy(xpath = "(//h2[@class = 'index-module_text-hover__z4b5N'])[3]")
    public WebElement autoCityApt17Header;

    public PropertySearchPage(){
        PageFactory.initElements(driver, this);
    }
}
