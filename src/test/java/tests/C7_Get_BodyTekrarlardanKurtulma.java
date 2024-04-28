package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C7_Get_BodyTekrarlardanKurtulma {

    /*

    https://restful-booker.herokuapp.com/booking/11 url’ine bir GET request gonderdigimizde donen Response’un,
            status code’unun 200,
            ve content type’inin application/json,
            ve response body’sindeki
            “firstname”in, “John”,
            ve “lastname”in, “Smith”,
            ve “totalprice”in, 111,
            ve “depositpaid”in, true,
	        ve “additionalneeds”in, “Breakfast” oldugunu test edin
	        NOT: Veriler değişiyor Postman'de dataları kontrol ediniz
     */

    @Test
    public void bodyTekrarlardanKurtulma(){

        //1- Endpoint hazırlama
        String url="https://restful-booker.herokuapp.com/booking/11";

        // 2- soruda verilmedigi için expected body hazırlanmadı

        //3- dönen response kaydedilir

        Response response=given().when().get(url); // Get oldugu için  veri göndermedigimiz için contentType koymuyoruz.. body koymuyoruz

        //4-Assertion işlemi

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("firstname", equalTo("Josh"),
                        "lastname",equalTo("Allen"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "additionalneeds",equalTo("midnight snack"));



    }



}
