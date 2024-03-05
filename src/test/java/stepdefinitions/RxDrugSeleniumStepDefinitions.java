package stepdefinitions;


import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.RxDrugAccountManPage;
import pages.RxDrugUsersPage;
import pages.RxDrugsHomePage;
import utilities.Driver;

import static org.junit.Assert.assertEquals;


public class RxDrugSeleniumStepDefinitions {
    RxDrugsHomePage homePage;
    RxDrugUsersPage usersPage;
    RxDrugAccountManPage manPage;
    public static String fakeEmail;
    public static String userId;

    @When("user enters email and password and click on sign in")
    public void user_enters_email_and_password_and_click_on_sign_in() throws InterruptedException {

        homePage = new RxDrugsHomePage();
        homePage.username.sendKeys("bo2@qualitron.com");
        homePage.password.sendKeys("4c2EIk3O8brPF0C"+ Keys.ENTER);
        Thread.sleep(1000);

    }
    @When("user clicks on Users Link")
    public void user_clicks_on_users_link() throws InterruptedException {

        manPage = new RxDrugAccountManPage();
        manPage.usersLink.click();
        Thread.sleep(1000);

    }
    @When("user clicks on Register New User Link")
    public void user_clicks_on_register_new_user_link() throws InterruptedException {

        usersPage = new RxDrugUsersPage();
        usersPage.registerNewUser.click();
        Thread.sleep(1000);

    }
    @When("user selects role")
    public void user_selects_role() throws InterruptedException {

        new Actions(Driver.getDriver()).sendKeys(Keys.TAB).sendKeys("Business Owner" + Keys.ENTER).perform();
        Thread.sleep(1000);

    }
    @When("user enters email for user")
    public void user_enters_email_for_user() throws InterruptedException {

        fakeEmail = Faker.instance().internet().emailAddress();
        usersPage.email.sendKeys(fakeEmail);
        Thread.sleep(1000);

    }
    @When("user clicks on Register button")
    public void user_clicks_on_register_button() throws InterruptedException {

        usersPage.register.click();
        Thread.sleep(1000);

    }
    @Then("user verifies success message")
    public void user_verifies_success_message() {

        assertEquals(usersPage.successMessage.getText(),"Successful");

        usersPage.close.click();

        String href = Driver.getDriver().findElement(By.xpath("//a[.='"+fakeEmail+"']")).getAttribute("href");
        userId = href.substring(href.lastIndexOf("/")+1);
        System.out.println("id = " + userId);


    }


}
