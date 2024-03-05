package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RxDrugUsersPage {

    public RxDrugUsersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='+ Register New User']")
    public WebElement registerNewUser;

    @FindBy(className = "css-hlgwow")
    public WebElement roles;

    @FindBy(id = "react-select-2-input")
    public WebElement rolesInput;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(xpath = "//button[.='Register']")
    public WebElement register;

    @FindBy(xpath = "//button[.='Close']")
    public WebElement close;

    @FindBy(xpath = "//tbody)[3]//tr[1]//td[2]")
    public WebElement row1cell2;

    @FindBy(xpath = "//strong")
    public WebElement successMessage;




}
