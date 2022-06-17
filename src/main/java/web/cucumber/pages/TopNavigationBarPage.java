package web.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopNavigationBarPage {
    WebDriver driver;

    public TopNavigationBarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@title='Log me out']")
    private WebElement signOutBtn;

    public void clickSignOut(){
        signOutBtn.click();
    }


}
