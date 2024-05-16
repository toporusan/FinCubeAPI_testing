package ALessons.Day_8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUser {

    @Test
    void getUser(ITestContext context) {

        //int id = (Integer) context.getAttribute("user_id"); // переменная видна в пределах теста
        int id = (Integer) context.getSuite().getAttribute("user_id"); // переменная видна в пределах test-suite
        String bearerToken = "abf14747f06d50e5e225ed0ceec8b4b5d9cdaeede1448100344eb3bc28347e80";

         given()
                .headers("Authorization", "Bearer " + bearerToken)
                .pathParam("id", id)
                .contentType("application/json")
                .when()
                .get("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .statusCode(200)
                .log().all();
    }
}
