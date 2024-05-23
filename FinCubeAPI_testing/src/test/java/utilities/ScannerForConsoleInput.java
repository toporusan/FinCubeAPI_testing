package utilities;

import endpoints.EndPoints;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import payload_POJO.OTP_confirm.Otp_confirm;
import payload_POJO.OTP_veriy.Data;
import payload_POJO.OTP_veriy.Otp_verify;

import java.util.Scanner;

import static utilities.Properties_pars.getProperty;

public class ScannerForConsoleInput {

    public static String getConsoleInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static void main(String[] args) {

        payload_POJO.OTP_veriy.Data phone = new payload_POJO.OTP_veriy.Data();
        phone.setPhone(getProperty("Profile_prop.properties", "phone"));
        Otp_verify phoneNumb = new Otp_verify();
        phoneNumb.setData(phone);

        // /api/otp/verify
        Response response = EndPoints.otp_verify(phoneNumb);
        String a = response.getBody().asPrettyString(); // получили тело (массив объектов)
        System.out.println(a);
        JSONObject jo = new JSONObject(a);// Создали новый JSONObject();
        String otpId = jo.getJSONObject("data").get("otpId").toString();
        Properties_pars.setProperty("Profile_prop.properties", "otpId", otpId);

        // /api/otp/verify
        payload_POJO.OTP_confirm.Data otpVerify = new payload_POJO.OTP_confirm.Data();
        otpVerify.setOtpId(Properties_pars.getProperty("Profile_prop.properties", "otpId"));
        otpVerify.setOtpId(Properties_pars.getProperty("Profile_prop.properties", "otp"));
        payload_POJO.OTP_confirm.Otp_confirm confirm = new payload_POJO.OTP_confirm.Otp_confirm();

        Response response2 = EndPoints.otp_confirm();


        Assert.assertEquals(response.getStatusCode(), 200);


    }
}
