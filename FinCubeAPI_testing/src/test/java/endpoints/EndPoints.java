package endpoints;

import io.restassured.response.Response;
import org.json.JSONObject;
import payload_POJO.OTP_confirm.Otp_confirm;
import payload_POJO.OTP_veriy.Otp_verify;

import static endpoints.Routs.*;
import static io.restassured.RestAssured.given;



public class EndPoints {











    // POST
    public static Response otp_verify(Otp_verify phone) {
        Response response = given()
                .accept("*/*")
                .contentType("application/json")
                .header("Client-Version", "1.0.0")   // Укажите актуальную версию клиента
                .header("Platform", "IOS")     // Укажите актуальную платформу (например, Android, iOS)
                .header("Device-Id", "B17A9245-D53E-4500-AD54-7B4BB95F4404")
                .header("Accept-Language", "ru")
                .body(phone)
                .when()
                .post(otp_verify);
        return response;
    }


    public static Response otp_confirm(Otp_confirm body) {
        Response response = given()
                .accept("*/*")
                .contentType("application/json")
                .header("Client-Version", "1.0.0")   // Укажите актуальную версию клиента
                .header("Platform", "IOS")     // Укажите актуальную платформу (например, Android, iOS)
                .header("Device-Id", "B17A9245-D53E-4500-AD54-7B4BB95F4404")
                .header("Accept-Language", "ru")
                .body(body)
                .when()
                .post(otp_verify);
        return response;
    }



    // POST
    public static Response testURLPOST(JSONObject object) {
        Response response = given()
                .accept("*/*")
                .contentType("application/json")
                .body(object)
                .when()
                .post(testURL);
        return response;
    }





/*    // GET
    public static Response readUser(String userName) {
        Response response = given()
                .accept("application/json")
                .pathParam("username", userName) // имя конкретного пользователя
                .when()
                .get(get_url);

        return response;
    }

    // PUT
    public static Response updateUser(User payload, String userName) {
        Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .pathParam("username", userName) // имя конкретного пользователя
                .body(payload)
                .when()
                .put(put_url);

        return response;
    }

    // DELETE
    public static Response deleteUser(String userName) {
        Response response = given()
                .pathParam("username", userName) // query - имя конкретного пользователя
                .when()
                .delete(delete_url);

        return response;
    }*/

}
