package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class C1_Get_ApiSorgulama {
    /*
    https://restful booker.herokuapp.com/booking/10 url’ine bir GET request
gonderdigimizde donen Response’un,
status code’unun 200,
ve content type’inin application/json; charset=utf8
ve Server isimli Header’in degerinin Cowboy,
ve status Line’in HTTP/1.1 200 OK
ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
     */
    // API testlerinde dört işlem ile test yapılır

    // 1 - EndPoint belirlenir
    // 2- Gerekliyse expected data hazırlanır
    // 3- Actual data kaydedilir
    // 4- Assert işlemi gerçekleştirilir


    @Test
    public void gett01(){

        // 1 - EndPoint belirlenir
            String url="https://restful-booker.herokuapp.com/booking/10";

            // 2- Gerekliyse expected data hazırlanır

        // 3- Actual data kaydedilir
        Response response=given().when().get(url);

        // 4- Assert işlemi gerçekleştirilir
        System.out.println("Status.Code: " + response.getStatusCode());
        System.out.println("Content Type: "+response.getContentType());
        System.out.println("Server: "+response.getHeader("Server"));
        System.out.println("Status Line: "+response.getStatusLine());
        System.out.println("Test time: "+response.getTime()+ " ms");


    }


}
