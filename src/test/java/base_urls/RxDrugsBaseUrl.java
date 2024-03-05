package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.Authentication.generateAccessToken;
import static utilities.Authentication.generateToken;

public class RxDrugsBaseUrl {

    public static RequestSpecification spec;


        static {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://a3m-qa-gm3.quaspareparts.com/auth/api")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Bearer "+generateAccessToken())
                .build();
    }



}
