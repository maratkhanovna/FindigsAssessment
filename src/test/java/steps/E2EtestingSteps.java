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
        click(applicationPage.startApplication);
    }

    @When("user selects the number of co-applicants over eighteen years and clicks on Save and continue button")
    public void user_selects_the_number_of_co_applicants_over_eighteen_years_and_clicks_on_save_and_continue_button() {
       click(yourHouseholdPage.numberOfHouseHold0);
       click(yourHouseholdPage.saveButtonAndContinue);
    }

    @When("user selects the number of people under eighteen years and clicks on Save and continue button")
    public void user_selects_the_number_of_people_under_eighteen_years_and_clicks_on_save_and_continue_button() {
       yourHouseholdPage.children0.click();
       click(yourHouseholdPage.saveButtonAndContinue);
    }
    @When("user selects number of vehicles he has and clicks on Save and continue button")
    public void user_selects_number_of_vehicles_he_has_and_clicks_on_save_and_continue_button() {
        yourHouseholdPage.vehicle0.click();
        click(yourHouseholdPage.saveButtonAndContinue);
    }
    @When("user selects number of animals he has and clicks on Save and continue button")
    public void user_selects_number_of_animals_he_has_and_clicks_on_save_and_continue_button() {
       yourHouseholdPage.pets0.click();
       click(yourHouseholdPage.saveButtonAndContinue);
    }
    @When("user selects and clicks on the answer No")
    public void user_selects_and_clicks_on_the_answer_no() {
        yourHouseholdPage.noSmokerButton.click();
    }
    /**
    @When("user is successfully completed household section and is able to click on Next button")
    public void user_is_successfully_completed_household_section_and_is_able_to_click_on_next_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters valid current address")
    public void user_enters_valid_current_address() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user selects state from the dropdown and clicks on Save and continue button")
    public void user_selects_state_from_the_dropdown_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user selects current housing status and clicks on Save and continue button")
    public void user_selects_current_housing_status_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters company name, email, phone number and clicks on Save and continue button")
    public void user_enters_company_name_email_phone_number_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters random number as a total current rent and clicks on Save and continue button")
    public void user_enters_random_number_as_a_total_current_rent_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters random number as a share of current rent and clicks on Save and continue button")
    public void user_enters_random_number_as_a_share_of_current_rent_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user refuses to verify with a bank account and clicks on Skip Button")
    public void user_refuses_to_verify_with_a_bank_account_and_clicks_on_skip_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user is able to skip to document upload")
    public void user_is_able_to_skip_to_document_upload() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user upload landlord reference letter and clicks on Save and continue button")
    public void user_upload_landlord_reference_letter_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters random number, company name and clicks on Save and continue button")
    public void user_enters_random_number_company_name_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters random date and clicks on Save and continue button")
    public void user_enters_random_date_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user selects and clicks on the answer {string} four times with time interval")
    public void user_selects_and_clicks_on_the_answer_four_times_with_time_interval(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user is successfully completed housing history section and is able to click on Next button")
    public void user_is_successfully_completed_housing_history_section_and_is_able_to_click_on_next_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user selects employment status and clicks on Save and continue button")
    public void user_selects_employment_status_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters company name\", job title, random date, address, email and clicks on Save and continue button")
    public void user_enters_company_name_job_title_random_date_address_email_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user selects income cadence from dropdown, enters random number and clicks on Save and continue button")
    public void user_selects_income_cadence_from_dropdown_enters_random_number_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user selects verification option and clicks on Save and continue button")
    public void user_selects_verification_option_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user is able to click Continue button in a new window")
    public void user_is_able_to_click_continue_button_in_a_new_window() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user clicks on company name")
    public void user_clicks_on_company_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters valid username and password and clicks on Continue button")
    public void user_enters_valid_username_and_password_and_clicks_on_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user is able to close a window by clicking Close button")
    public void user_is_able_to_close_a_window_by_clicking_close_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user clicks on Save and continue button")
    public void user_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user selects and clicks on the answer {string} five times with time interval")
    public void user_selects_and_clicks_on_the_answer_five_times_with_time_interval(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user is successfully completed income section and is able to click on Next button")
    public void user_is_successfully_completed_income_section_and_is_able_to_click_on_next_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user clicks on Skip button")
    public void user_clicks_on_skip_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user uploads a photo of ID card, selects document type from dropdown and clicks on Save and continue button")
    public void user_uploads_a_photo_of_id_card_selects_document_type_from_dropdown_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user uploads a photo the back of ID card, selects document type from dropdown and clicks on Save and continue button")
    public void user_uploads_a_photo_the_back_of_id_card_selects_document_type_from_dropdown_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user uploads a selfie photo and clicks on Save and continue button")
    public void user_uploads_a_selfie_photo_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user is able to verify credit history and clicks on Verify button")
    public void user_is_able_to_verify_credit_history_and_clicks_on_verify_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user verifies firstName and lastName and clicks on Save and continue button")
    public void user_verifies_first_name_and_last_name_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user verifies the address and clicks on Save and continue button")
    public void user_verifies_the_address_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters random DOB and clicks on Save and continue button")
    public void user_enters_random_dob_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters random SSN and clicks on Save and continue button")
    public void user_enters_random_ssn_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user agrees to the policies by clicking the checkbox and clicks on Save and continue button")
    public void user_agrees_to_the_policies_by_clicking_the_checkbox_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user selects one of the given answers and clicks on Save and continue button")
    public void user_selects_one_of_the_given_answers_and_clicks_on_save_and_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user is able to click on Finalize and Submit application button")
    public void user_is_able_to_click_on_finalize_and_submit_application_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters agent's name, credit card details, full name, signature and clicks Complete button")
    public void user_enters_agent_s_name_credit_card_details_full_name_signature_and_clicks_complete_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user is able to Submit application for Review and verify Submitted message")
    public void user_is_able_to_submit_application_for_review_and_verify_submitted_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
*/
}
