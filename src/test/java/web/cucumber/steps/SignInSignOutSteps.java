package web.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import web.cucumber.helpers.TestContext;
import web.cucumber.pages.SignInPage;

public class SignInSignOutSteps {
    private TestContext testContext;

    public SignInSignOutSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("I am signed into my Account")
    public void iAmSignedIntoMyAccount() {
        SignInPage signInPage = testContext.getPageObjectManager().getHomePage().goToSignInPage();
        signInPage.signIn("rahulsharma21291@gmail.com","Apple@789!");
    }
    @When("I sign out")
    public void iSignOut() {
        testContext.getPageObjectManager().getTopNavigationBarPage().clickSignOut();
    }
    @Then("Sign out should be successful")
    public void signoutShouldBeSuccessful() {
        Assert.assertTrue(testContext.getPageObjectManager().getSignInPage().getAuthLbl().isDisplayed());
    }
}
