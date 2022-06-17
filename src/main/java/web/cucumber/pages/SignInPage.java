package web.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;
    public SignInPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "email_create")
    private WebElement createEmailAddressTxt;

    @FindBy(id="SubmitCreate")
    private WebElement createAcctBtn;

    @FindBy(id="email")
    private WebElement emailTxt;

    @FindBy(id="passwd")
    private WebElement passwordTxt;
    @FindBy(id="SubmitLogin")
    private WebElement signInBtn;

    @FindBy(xpath = "//h1[contains(text(),'Authentication')]")
    private WebElement authLbl;
    public RegistrationPage createAcct(String email){
        createEmailAddressTxt.sendKeys(email);
        createAcctBtn.click();
        return new RegistrationPage(driver);
    }
    public MyAccountPage signIn(String email,String password){
        emailTxt.sendKeys(email);
        passwordTxt.sendKeys(password);
        signInBtn.click();
        return new MyAccountPage(driver);
    }

    public WebElement getAuthLbl(){
        return authLbl;
    }

}
