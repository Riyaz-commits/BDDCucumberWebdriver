package web.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import web.cucumber.exceptions.BrowserConfigException;
import web.cucumber.helpers.TestContext;

import java.util.concurrent.TimeUnit;

public class ApplicationHooks {
    private TestContext testContext;

    public ApplicationHooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before(order = 0)
    public void launchAppOnBrowser() {
        String browser = testContext.getConfigManager().initConfig().getProperty("browser");
        String url = testContext.getConfigManager().initConfig().getProperty("url");

        try {
            testContext.getDriverManager().setDriver(browser);
        } catch (BrowserConfigException e) {
            throw new RuntimeException(e);
        }
        testContext.getDriverManager().getDriver().manage().deleteAllCookies();
        testContext.getDriverManager().getDriver().manage().window().maximize();
        testContext.getDriverManager().getDriver().manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        //testContext.getDriverManager().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testContext.getDriverManager().getDriver().get(url);

    }

    @After(order = 0)
    public void quitBrowser() {
        testContext.getDriverManager().getDriver().quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) testContext.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }

    }

}