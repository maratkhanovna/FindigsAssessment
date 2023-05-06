package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;

public class CreateAccountPage extends CommonMethods {

    @FindBy(xpath = "//input[@name = 'firstName']")
    public WebElement firstnameTextField;

    @FindBy(xpath = "//input[@name = 'lastName']")
    public WebElement lastnameTextField;

    @FindBy(xpath = "//input[@name = 'email']")
    public WebElement emailTextField;

    @FindBy(xpath = "//input[@name = 'phoneNumber']")
    public WebElement phoneTextField;

    @FindBy(xpath = "//input[@name = 'newPassword']")
    public WebElement passwordTextField;

    @FindBy(xpath = "//input[@name = 'confirmNewPassword']")
    public WebElement confirmPasswordTextField;

    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//h2[text() = 'Let’s verify your phone number.']")
    public WebElement verificationMessage;

    public CreateAccountPage(){
        PageFactory.initElements(driver, this);
    }

}
