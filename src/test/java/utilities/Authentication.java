package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepdefinitions.EndToEndTestStepDefinitions.email;

public class Authentication {

    public static String generateToken() {//Contact List

        Map<String, String> mapBody = new HashMap<>();

        if (email == null) {//email selenium ile oluşturulduğundan selenium çalışmadığında null olarak kalacaktır. Bu durumlarda token sabit bir kullanıcı ile alınacaktır.
            mapBody.put("email", "alican@yahoo.com");
            mapBody.put("password", "Ali.123");
        } else {
            mapBody.put("email", email);
            mapBody.put("password", "Password.123");
        }

        Response response = given()
                .contentType(ContentType.JSON)
                .body(mapBody)
                .post("https://thinking-tester-contact-list.herokuapp.com/users/login");
        return response.jsonPath().getString("token");
    }

    public static String generateAccessToken(){//RX Drug Token

        //Önce Selenium ile session id 'yi cookie olarak dinamik bir şekilde alıyoruz
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
        driver.get("https://qa-gm3.quaspareparts.com/");
        driver.findElement(By.id("loginButton")).click();
        driver.findElement(By.id("username")).sendKeys("bo2@qualitron.com");
        driver.findElement(By.id("password")).sendKeys("4c2EIk3O8brPF0C"+ Keys.ENTER);

        String sessionId = driver.manage().getCookieNamed("GSESSIONID").getValue();
        driver.quit();

       Response response = given()
               .header("Cookie", "GSESSIONID="+sessionId)//Selenium ile alınan session id ile token üretiyoruz
               .get("https://qa-gm3.quaspareparts.com/auth/userinfo");

        return response.jsonPath().getString("access_token");

    }


}
