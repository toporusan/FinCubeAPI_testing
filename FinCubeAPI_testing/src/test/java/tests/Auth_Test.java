package tests;

import endpoints.EndPoints;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payload_POJO.OTP_veriy.Data;
import payload_POJO.OTP_veriy.Otp_verify;
import utilities.ScannerForConsoleInput;

import java.util.Scanner;

import static utilities.PropertiesFileParser.*;

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
        phone.setPhone(getProperty("Profile_prop.properties","phone"));
        phoneNumb.setData(phone);

    }


    @Test(priority = 1)
    public void otp_Verify_test() {
       // logger.info("*** Creating user ***");

        String a = System.getenv("MY_VAR");
        System.out.println(a);

        /*Response response = EndPoints.otp_verify(phoneNumb);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);*/
       // logger.info("*** User is created ***");

    }

}
