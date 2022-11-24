package Util;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UserUtil {
    private static String userName;
    private static ResponseBody userDetails;
    public static String getUniqueValue(String str){
        Random random = new Random();
        int val = random.nextInt(1000);
        return str.concat(String.valueOf(val));
    }
    public static ResponseBody CreateUser(){
        Map<String , String> headers = new HashMap<String,String>();
        headers.put("Content-Type","application/json");
        Response response = RestAssured.given().
                headers(headers).
                //   params(this.body).
                        when().
                        get("https://randomuser.me/api/?format=json").
                        then().
                //  contentType(ContentType.JSON).
                        statusCode(200).
                        extract().
                        response();
        ResponseBody body = response.getBody();
        body.prettyPrint();
        setResponseBody(body);
        return body;
    }
    public static String getUserName(){
        return userName;
    }
    public static void setUserName(String val){
        userName = val;
    }
    public static ResponseBody getResponseBody(){
        return userDetails;
    }
    public static void setResponseBody(ResponseBody body){
        userDetails = body;
    }
}
