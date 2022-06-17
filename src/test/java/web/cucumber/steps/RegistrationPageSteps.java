package web.cucumber.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import web.cucumber.helpers.TestContext;
import web.cucumber.pages.SignInPage;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RegistrationPageSteps {

    private TestContext testContext;

    public RegistrationPageSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("I make a registration")
    public void userMakesARegistration(DataTable dataTable) {
        SignInPage signInPage=testContext.getPageObjectManager().getSignInPage();
        signInPage.createAcct("rahulsharma21291@gmail.com");
        List<Map<String, String>> regDetailsMap = dataTable.asMaps();
        testContext.getPageObjectManager().getRegistrationPage().registerWithDetails(regDetailsMap);
    }

    @Then("^Registration should be successful$")
    public void registrationShouldBeSuccessful() {
        Assert.assertTrue(testContext.getPageObjectManager().getMyAccountPage().getMyAcctLbl().equalsIgnoreCase("My Account"));

    }
}
