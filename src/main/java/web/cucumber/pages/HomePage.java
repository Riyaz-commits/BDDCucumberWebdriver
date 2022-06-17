package web.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }
    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement signInBtn;

    public SignInPage goToSignInPage(){
        signInBtn.click();
        return new SignInPage(driver);
    }

}
