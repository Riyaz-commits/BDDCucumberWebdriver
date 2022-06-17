package web.cucumber.steps;

import io.cucumber.java.en.Given;
import web.cucumber.helpers.CommonTask;
import web.cucumber.helpers.TestContext;
import web.cucumber.pages.HomePage;

public class HomePageSteps {
    private TestContext testContext;

    public HomePageSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("I am on registration page")
    public void userIsOnRegistrationPage() {
        HomePage homePage = testContext.getPageObjectManager().getHomePage();
        homePage.goToSignInPage();


    }
}
