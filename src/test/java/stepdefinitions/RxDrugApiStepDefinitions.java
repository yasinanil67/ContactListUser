package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static base_urls.RxDrugsBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static stepdefinitions.RxDrugSeleniumStepDefinitions.fakeEmail;
import static stepdefinitions.RxDrugSeleniumStepDefinitions.userId;

public class RxDrugApiStepDefinitions {
    Response response;

    @Given("set the url for getting user")
    public void set_the_url_for_getting_user() {
        //https://a3m-qa-gm3.quaspareparts.com/auth/api/user/:id
        spec.pathParams("first","user","second", userId);

    }
    @Given("set the expected data for getting user")
    public void set_the_expected_data_for_getting_user() {


    }

    @When("send the get request and get the response")
    public void send_the_get_request_and_get_the_response() {

        response = given(spec).get("{first}/{second}");
        response.prettyPrint();
    }
    @Then("assert response body")
    public void assert_response_body() {

        //1. Yol:
         response.then()
                 .statusCode(200)
                 .body("email", equalTo(fakeEmail));

         //2. Yol: Json Path ile alınan field değerleri assert edilebilir

        //3. yol: De-Serialization ile Map'e çevirip assert edilebilir.

        //4. yol: De-Serialization ile Pojo Classa çevirip assert edilebilir.

        //5. yol: Object Mapper De-Serialization ile Pojo Classa yada Map'e çevirip assert edilebilir.



    }



}
