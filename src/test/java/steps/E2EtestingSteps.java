package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.ReviewQualificationsPage;
import utilities.CommonMethods;
import utilities.ConfigReader;

public class E2EtestingSteps extends CommonMethods {

    Faker faker = new Faker();
    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();
    String email = faker.internet().emailAddress();

    @When("user enters valid firstname, lastname, email, phone")
    public void user_enters_valid_firstname_lastname_email_phone() {
        sendText(createAccountPage.firstnameTextField, firstName);
        sendText(createAccountPage.lastnameTextField, lastName);
        sendText(createAccountPage.emailTextField, email);
        sendText(createAccountPage.phoneTextField, ConfigReader.getPropertyValue("phone"));


    }

    @When("user enters valid password")
    public void user_enters_valid_password() {
       sendText(createAccountPage.passwordTextField, ConfigReader.getPropertyValue("password"));
    }

    @When("user enters password to confirm")
    public void user_enters_password_to_confirm() {
        sendText(createAccountPage.confirmPasswordTextField, ConfigReader.getPropertyValue("password"));
    }

    @When("user clicks on Create an Account button")
    public void user_clicks_on_create_an_account_button() {
        Actions action = new Actions(driver);
        action.doubleClick(createAccountPage.createAccountButton).perform();
        //click(createAccountPage.createAccountButton);
    }

    @Then("user is redirected to phone verification page")
    public void user_is_redirected_to_phone_verification_page() {
        String expectedMessage = "Let’s verify your phone number.";
        String actualMessage = createAccountPage.verificationMessage.getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @When("user enters valid verification code")
    public void user_enters_valid_verification_code() {
        sendText(phoneVerificationPage.codeTextField, ConfigReader.getPropertyValue("code"));
    }
    @When("user clicks on Verify button")
    public void user_clicks_on_verify_button() {
        Actions action = new Actions(driver);
        action.doubleClick(phoneVerificationPage.verifyButton).perform();
    }

    @Then("user is successfully navigated to Property Search page and is able to see welcoming message")
    public void user_is_successfully_navigated_to_property_search_page_and_is_able_to_see_welcoming_message() {
        String expectedMessage = "Welcome " + firstName + "," + "\nPlease select which property you're applying for.";
        String actualMessage = phoneVerificationPage.welcomeMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("user selects Auto City to filter search results")
    public void user_selects_auto_city_to_filter_search_results() {
        jsClick(propertySearchPage.autoCityFilterButton);
    }
    @When("user selects first apartment in the list")
    public void user_selects_first_apartment_in_the_list() {
        click(propertySearchPage.autoCityApt12);
    }

    @When("user clicks on Ready to Apply button")
    public void user_clicks_on_ready_to_apply_button() {
        jsClick(reviewQualificationsPage.readyButton);
    }

    @Then("user is able to click on Change Property option")
    public void user_is_able_to_click_on_change_property_option() {
        click(applicationPage.changeProperty);
    }
    @When("user selects second apartment in the list")
    public void user_selects_second_apartment_in_the_list() {
        click(propertySearchPage.autoCityFilterButton);
        click(propertySearchPage.autoCityApt17);
    }
    @When("user selects move-in date the first date of the next month")
    public void user_selects_move_in_date_the_first_date_of_the_next_month() {
        click(applicationPage.selectMoveInDate);
        for (WebElement moveInDate:applicationPage.weeks) {
            if (moveInDate.getText().equals(15)){
                moveInDate.click();
                break;
            }
        }

    }
    @When("user is able to click on Start Application button and verify this button is enabled")
    public void user_is_able_to_click_on_start_application_button_and_verify_this_button_is_enabled() {
        Assert.assertTrue(applicationPage.startApplication.isEnabled());
    }
}
