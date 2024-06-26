package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RxDrugsHomePage {

    public RxDrugsHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "loginButton")
    public WebElement loginButton;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//button[.='Account Management']")
    public WebElement accountManagement;



}
