package steps;

import pages.*;

public class PageInitializer {
    public static CreateAccountPage createAccountPage;
    public static PhoneVerificationPage phoneVerificationPage;
    public static PropertySearchPage propertySearchPage;
    public static ReviewQualificationsPage reviewQualificationsPage;
    public static ApplicationPage applicationPage;


    public static void initializePageObjects(){
        createAccountPage = new CreateAccountPage();
        phoneVerificationPage = new PhoneVerificationPage();
        propertySearchPage = new PropertySearchPage();
        reviewQualificationsPage = new ReviewQualificationsPage();
        applicationPage = new ApplicationPage();
    }
}
