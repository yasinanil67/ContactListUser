package stepdefinitions;


import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;

import pojos.User;
import pojos.UserPojo;
import pojos.UserResponsePojo;

import java.util.Map;

import static base_urls.ContactListBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApiStepDefinitions {
    static UserPojo expectedData;
    static Response response;
    static String firstname;
    static String lastname;
    static String email;
    public static String newToken;


    @Given("set the url for user creation")
    public void set_the_url_for_user_creation() {

        spec.pathParams("first", "users");

    }

    @Given("set the expected data for user creation")
    public void set_the_expected_data_for_user_creation() {
        Faker faker = new Faker();
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        email = faker.internet().emailAddress();

        expectedData = new UserPojo(firstname, lastname, "Password.123", email);
        System.out.println("expectedData = " + expectedData);
    }

    @When("send the post request for user creation and get the response")
    public void send_the_post_request_for_user_creation_and_get_the_response() {

        response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

    }

    @Then("do assertion for user creation")
    public void do_assertion_for_user_creation() {

        UserResponsePojo actualData = response.as(UserResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getFirstName(), actualData.getUser().getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getUser().getLastName());
        assertEquals(expectedData.getEmail(), actualData.getUser().getEmail());

        newToken = actualData.getToken();//Oluşan yeni user'ın token değerini alıyoruz
    }

    @Given("set the url for reading user")
    public void set_the_url_for_reading_user() {

        spec.config(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("Authorization")))//config() metodu ile overwrite edilecek headr ismini belirtiyoruz.
                .header("Authorization", "Bearer " + newToken).pathParams("first", "users", "second", "me");

    }

    @Given("set the expected data for reading user")
    public void set_the_expected_data_for_reading_user() {

        expectedData = new UserPojo(firstname, lastname, "Password.123", email);

    }

    @When("send the post request for reading user and get the response")
    public void send_the_post_request_for_reading_user_and_get_the_response() {

        response = given(spec).get("{first}/{second}");
        response.prettyPrint();

    }

    @Then("do assertion for reading user")
    public void do_assertion_for_reading_user() {

        User actualData = response.as(User.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getEmail(), actualData.getEmail());

    }

    @Given("set the url for updating user")
    public void set_the_url_for_updating_user() {

        spec.pathParams("first", "users", "second", "me");

    }

    @Given("set the expected data for updating user")
    public void set_the_expected_data_for_updating_user() {
        Faker faker = new Faker();
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        email = faker.internet().emailAddress();

        expectedData = new UserPojo(firstname, lastname, "Password.123", email);
        System.out.println("expectedData = " + expectedData);

    }

    @When("send the patch request for updating user and get the response")
    public void send_the_patch_request_for_updating_user_and_get_the_response() {

        response = given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();

    }

    @Then("do assertion for updating user")
    public void do_assertion_for_updating_user() {

        User actualData = response.as(User.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getEmail(), actualData.getEmail());

    }

    @Given("set the url for deleting user")
    public void set_the_url_for_deleting_user() {

        spec.pathParams("first","users","second","me");

    }

    @Then("do assertion for deleting user")
    public void do_assertion_for_deleting_user() {

        assert 200==response.statusCode() : "Status code is not 200";//Java assertion
        assert response.asString().isEmpty() : "Body is not empty";

    }

    @When("send the delete request for deleting user and get the response")
    public void sendTheDeleteRequestForDeletingUserAndGetTheResponse() {

        response = given(spec).delete("{first}/{second}");
        response.prettyPrint();


    }

}
