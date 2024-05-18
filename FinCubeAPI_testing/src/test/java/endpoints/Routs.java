package endpoints;

public class Routs {
    public static String base_url = "https://mobapi.apexbank.uz";


    public static String otp_verify = base_url + "/api/otp/verify";
    public static String otp_confirm = base_url + "/api/otp/confirm";
    public static String customer_existence = base_url + "api/registration/customer/existence";
    public static String auth_token = base_url + "/api/auth/token";
    public static String refresh_token = base_url + "/api/auth/refresh-token";
    public static String customer_info = base_url + "/api/customer/gateway/customer";

    //Cards
    public static String card_balance = base_url + "/api/card/balance";
    public static String card = base_url + "/api/card";
    public static String account_wallets = base_url + "/account-gateway/account";
    public static String transfer_info = base_url + "/api/transfer/info";
    public static String transfer = base_url + "/api/transfer";
    public static String transfer_confirm = base_url + "/api/transfer/confirm";






    // User module
    // public static String post_url = base_url + "/user";
    // public static String get_url = base_url + "/user/{username}";
    // public static String put_url = base_url + "/user/{username}";
    // public static String delete_url = base_url + "/user/{username}";
//

}


