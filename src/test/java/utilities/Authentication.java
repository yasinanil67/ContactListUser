package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateToken(){
        String strBody = "{\"email\": \"clarusway@hotmail.com\",\"password\": \"Clarusway.123\"}";
        Response response = given().contentType(ContentType.JSON).body(strBody).post("https://thinking-tester-contact-list.herokuapp.com/users/login");
        return response.jsonPath().getString("token");
    }


}
