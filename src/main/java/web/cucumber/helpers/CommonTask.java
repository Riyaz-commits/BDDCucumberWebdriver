package web.cucumber.helpers;

import org.openqa.selenium.WebDriver;

public class CommonTask {

    public static void navigateToURL(WebDriver driver,String url){
        driver.navigate().to(url);
    }
}
