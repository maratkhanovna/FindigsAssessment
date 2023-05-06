package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;

public class PhoneVerificationPage extends CommonMethods {

    @FindBy(xpath = "//h2[(text()='Please enter the code we sent to (123) 456-7890.')]")
    public WebElement phoneNumberDisplayed;

    @FindBy(xpath = "//div[text() = 'Re-send code']")
    public WebElement resendCode;

    @FindBy(xpath = "//div[text() = 'change phone number']")
    public WebElement changePhone;

    @FindBy(xpath = "//input[@name = 'code']")
    public WebElement codeTextField;

    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement verifyButton;

    @FindBy(xpath = "//h2[contains(text(), 'Welcome')]")
    public WebElement welcomeMessage;

    public PhoneVerificationPage(){
        PageFactory.initElements(driver, this);
    }
}
