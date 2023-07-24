Feature: End-to-End Test for Findigs Rental Application

  @assessment
  Scenario: End-to-End Test for Findigs Rental Application
    # Given user is navigated to Findigs homepage
    When user enters valid firstname, lastname, email, phone
    And user enters valid password
    And user enters password to confirm
    And user clicks on Create an Account button
    Then user is redirected to phone verification page
    When user enters valid verification code
    And user clicks on Verify button
    Then user is successfully navigated to Property Search page and is able to see welcoming message
    When user selects Auto City to filter search results
    And user selects first apartment in the list
    And user clicks on Ready to Apply button
    And user is able to click on Change Property option
    When user selects Auto City to filter search results
    And user selects second apartment in the list
    When user selects move-in date the first date of the next month
    And user is able to click on Start Application button and verify this button is enabled
    * user selects the number of co-applicants over eighteen years and clicks on Save and continue button
    * user selects the number of people under eighteen years and clicks on Save and continue button
    * user selects number of vehicles he has and clicks on Save and continue button
    * user selects number of animals he has and clicks on Save and continue button
    * user selects and clicks on the answer No

    #ctr+alt+shift+j

    # user is successfully completed household section and is able to click on Next button
    # user enters valid current address
    # user selects state from the dropdown and clicks on Save and continue button
    # user selects current housing status and clicks on Save and continue button
    ## user enters company name, email, phone number and clicks on Save and continue button
    # user enters random number as a total current rent and clicks on Save and continue button
    # user enters random number as a share of current rent and clicks on Save and continue button
    # user refuses to verify with a bank account and clicks on Skip Button
    # user is able to skip to document upload
    # user upload landlord reference letter and clicks on Save and continue button
    # user enters random number, company name and clicks on Save and continue button
    # user enters random date and clicks on Save and continue button
    # user selects and clicks on the answer "No" four times with time interval
    # user is successfully completed housing history section and is able to click on Next button
    # user selects employment status and clicks on Save and continue button
    # user enters company name", job title, random date, address, email and clicks on Save and continue button
    # user selects income cadence from dropdown, enters random number and clicks on Save and continue button
    # user selects verification option and clicks on Save and continue button
    # user is able to click Continue button in a new window
    # user clicks on company name
    # user enters valid username and password and clicks on Continue button
    # user is able to close a window by clicking Close button
    # user clicks on Save and continue button
    # user selects and clicks on the answer "No" five times with time interval
    # user is successfully completed income section and is able to click on Next button
    # user clicks on Skip button
    # user is able to skip to document upload
    # user uploads a photo of ID card, selects document type from dropdown and clicks on Save and continue button
    # user uploads a photo the back of ID card, selects document type from dropdown and clicks on Save and continue button
    # user uploads a selfie photo and clicks on Save and continue button
    # user is able to verify credit history and clicks on Verify button
    # user verifies firstName and lastName and clicks on Save and continue button
    # user verifies the address and clicks on Save and continue button
    # user enters random DOB and clicks on Save and continue button
    # user enters random SSN and clicks on Save and continue button
    # user agrees to the policies by clicking the checkbox and clicks on Save and continue button
    # user selects one of the given answers and clicks on Save and continue button
    # user selects one of the given answers and clicks on Save and continue button
    # user selects one of the given answers and clicks on Save and continue button
    # user clicks on Save and continue button
    # user selects and clicks on the answer No
    # user is able to click on Finalize and Submit application button
    # user enters agent's name, credit card details, full name, signature and clicks Complete button
    # user is able to Submit application for Review and verify Submitted message


