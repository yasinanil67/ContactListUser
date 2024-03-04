package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.ContactListAddUserPage;
import pages.ContactListHomePage;
import pojos.UserPojo;
import utilities.Driver;

import static base_urls.ContactListBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class EndToEndTestStepDefinitions {

    ContactListHomePage contactListHomePage;
    ContactListAddUserPage contactListAddUserPage;
    String firstname;
    String lastname;
    public static String email;


    @Given("user goes to {string}")
    public void user_goes_to(String url) {

        Driver.getDriver().get(url);

    }

    @When("user clicks on sign up button")
    public void user_clicks_on_sign_up_button() {

        contactListHomePage = new ContactListHomePage();
        contactListHomePage.signup.click();

    }

    @When("User enters firstname, lastname, email, password")
    public void user_enters_firstname_lastname_email_password() {

        Faker faker = new Faker();
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        email = faker.internet().emailAddress();

        contactListAddUserPage = new ContactListAddUserPage();
        contactListAddUserPage.firstName.sendKeys(firstname);
        contactListAddUserPage.lastName.sendKeys(lastname);
        contactListAddUserPage.email.sendKeys(email);
        contactListAddUserPage.password.sendKeys("Password.123");

    }

    @When("user clicks on submit button")
    public void user_clicks_on_submit_button() throws InterruptedException {

        contactListAddUserPage.submit.click();

        Thread.sleep(1000);
        //Oluşan user'ın token değerini alarak, bu token 'a ait user bilgilerini API get request ile assert edeceğiz
//      String token = Driver.getDriver().manage().getCookieNamed("token").getValue(); //token api ile de bu şekilde alınabilir.

    }

    @Then("verify the user via API request")
    public void verify_the_user_via_api_request() {

        spec.pathParams("first","users","second","me");
        UserPojo expectedData = new UserPojo(firstname, lastname, "Password.123",email);
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();
        UserPojo actualData = response.as(UserPojo.class);
        System.out.println("actualData = " + actualData);

        assert response.statusCode()==200;
        assert actualData.getFirstName().equals(expectedData.getFirstName());
        assert actualData.getLastName().equals(expectedData.getLastName());
        assert actualData.getEmail().equals(expectedData.getEmail());

    }

    @And("user closes browser")
    public void userClosesBrowser() {

        Driver.closeDriver();

    }
}
