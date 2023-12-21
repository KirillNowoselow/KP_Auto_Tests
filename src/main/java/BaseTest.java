import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.*;
import steps.Steps;

import static io.restassured.RestAssured.given;

public class BaseTest implements Steps {
    @BeforeMethod(description = "Настройки запроса")
    public void configureRestAssured() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.requestSpecification = given()
                .contentType(ContentType.JSON);
    }
}