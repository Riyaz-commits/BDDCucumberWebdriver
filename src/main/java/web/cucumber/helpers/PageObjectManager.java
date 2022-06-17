package web.cucumber.helpers;

import org.openqa.selenium.WebDriver;
import web.cucumber.pages.*;

public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;

    private SignInPage signInPage;

    private MyAccountPage myAccountPage;

    private RegistrationPage registrationPage;

    private TopNavigationBarPage topNavigationBarPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        if (homePage == null)
            homePage = new HomePage(driver);
        return homePage;
    }

    public SignInPage getSignInPage() {
        if (signInPage == null)
            signInPage = new SignInPage(driver);
        return signInPage;
    }

    public MyAccountPage getMyAccountPage() {
        if (myAccountPage == null)
            myAccountPage = new MyAccountPage(driver);
        return myAccountPage;
    }

    public TopNavigationBarPage getTopNavigationBarPage() {
        if (myAccountPage == null)
            topNavigationBarPage = new TopNavigationBarPage(driver);
        return topNavigationBarPage;
    }

    public RegistrationPage getRegistrationPage() {
        if (registrationPage == null)
            registrationPage = new RegistrationPage(driver);
        return registrationPage;
    }
}
