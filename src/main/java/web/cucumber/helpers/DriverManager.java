package web.cucumber.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import web.cucumber.exceptions.BrowserConfigException;

public class DriverManager {
    private ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public void setDriver(String browser) throws BrowserConfigException {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            tlDriver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
            tlDriver.set(new FirefoxDriver());
        } else throw new BrowserConfigException("Browser not Supported"+browser);
    }

    public synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
}
