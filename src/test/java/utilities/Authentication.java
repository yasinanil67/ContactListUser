package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepdefinitions.EndToEndTestStepDefinitions.email;

public class Authentication {

    public static String generateToken(){

        Map<String, String> mapBody = new HashMap<>();
        mapBody.put("email", email);
        mapBody.put("password", "Password.123");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(mapBody)
                .post("https://thinking-tester-contact-list.herokuapp.com/users/login");
        return response.jsonPath().getString("token");
    }


}
