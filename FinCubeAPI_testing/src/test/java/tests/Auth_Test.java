package tests;

import endpoints.EndPoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payload_POJO.OTP_veriy.Data;
import payload_POJO.OTP_veriy.Otp_verify;

import java.util.Scanner;

import static endpoints.Routs.testURL;
import static io.restassured.RestAssured.given;
import static utilities.Properties_pars.*;

public class Auth_Test {
    public Logger logger;

    public Otp_verify phoneNumb;
    public Data phone;


    @BeforeClass
    public void setupDate() {
        /*
        //Logs
        logger = LogManager.getLogger(this.getClass()); // включение логгера*/

        phoneNumb = new Otp_verify();
        phone = new Data();
        phone.setPhone(getProperty("Profile_prop.properties", "phone"));
        phoneNumb.setData(phone);

    }


/*    @Test(priority = 1)
    public void authorization() {
        // logger.info("*** Authorization ***");

        Response response = EndPoints.otp_verify(phoneNumb);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        // logger.info("*** User is created ***");



    }*/

    @Test(priority = 1)
    public void authorization() {
        // logger.info("*** Authorization ***");

        Response res = given()
                .accept("application/json")
                .when()
                .get(testURL);
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(), 200);


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


/*        JSONObject book5 = new JSONObject();
        book5.put("title", "232eqweqwe");
        book5.put("author", "WERT");

        JSONObject lib = new JSONObject();
        lib.put("book5", book5);*/

        String requestBody = "{\n" +
                "  \"data\": {\n" +
                "    \"book5\": {\n" +
                "      \"title\": \"New Book Title 2\",\n" +
                "      \"author\": \"New Author 2\"\n" +
                "    }\n" +
                "  }\n" +
                "}";


        given()
                .accept("application/json")
                .body(requestBody)
                .when()
                .post(testURL)
                .then()
                .log().all();

    }


}


