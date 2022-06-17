package web.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_gender1")
    private WebElement titlemRBtn;

    @FindBy(id = "id_gender2")
    private WebElement titlemRsBtn;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameTxt;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameTxt;
    @FindBy(id = "address1")
    private WebElement addressTxt;
    @FindBy(id = "passwd")
    private WebElement passwordTxt;

    @FindBy(id = "city")
    private WebElement cityTxt;

    @FindBy(id = "postcode")
    private WebElement zipCodeTxt;

    @FindBy(id = "id_state")
    private WebElement stateSlct;

    @FindBy(id = "phone_mobile")
    private WebElement phoneTxt;

    @FindBy(id = "submitAccount")
    private WebElement registerBtn;

    public void registerWithDetails(List<Map<String, String>> regDetailsMap) {
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(titlemRBtn));
        selectTitle(regDetailsMap, titlemRBtn, titlemRsBtn);
        firstNameTxt.sendKeys(regDetailsMap.get(0).get("firstName"));
        lastNameTxt.sendKeys(regDetailsMap.get(0).get("lastName"));
        addressTxt.sendKeys(regDetailsMap.get(0).get("address"));
        passwordTxt.sendKeys(regDetailsMap.get(0).get("password"));
        cityTxt.sendKeys(regDetailsMap.get(0).get("city"));
        selectState(regDetailsMap, stateSlct);
        zipCodeTxt.sendKeys(regDetailsMap.get(0).get("postCode"));
        registerBtn.click();
    }

    private static void selectState(List<Map<String, String>> regDetailsMap, WebElement stateSlct) {
        Select stateSelect = new Select(stateSlct);
        stateSelect.selectByVisibleText(regDetailsMap.get(0).get("state"));
    }

    private static void selectTitle(List<Map<String, String>> regDetailsMap, WebElement titlemRBtn, WebElement titlemRsBtn) {
        if (regDetailsMap.get(0).get("title").equalsIgnoreCase("mr"))
            titlemRBtn.click();
        else if (regDetailsMap.get(0).get("title").equalsIgnoreCase("mrs")) {
            titlemRsBtn.click();
        } else throw new RuntimeException("Title isn't matching syntax");
    }


}
