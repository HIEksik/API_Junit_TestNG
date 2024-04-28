package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {

     /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
        donen response’un bookingid haric asagidaki gibi oldugunu test edin.

        Request body
        {
        "firstname" : "Hasan",
        "lastname" : "Yagmur",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
            "checkin" : "2021-06-01",
            "checkout" : "2021-06-10"
            },
        "additionalneeds" : "wi-fi"
        }

        Response Body
        {
        "bookingid":24,
        "booking":{
            "firstname":"Hasan",
            "lastname":"Yagmur",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                "checkin":"2021-06-01",
                "checkout":"2021-06-10"
                },
        "additionalneeds":"wi-fi"
        }
        }
         */

    @Test
    public void post_ExpectedDataVeJsonPathIleAssertion(){

        //1- EndPoint oluştur ve Request body oluştur
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject innerData=new JSONObject();
        innerData.put("checkin","2021-06-01");
        innerData.put("checkout" , "2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname" , "Hasan");
        reqBody.put("lastname" , "Yagmur");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("bookingdates",innerData );
        reqBody.put("additionalneeds" , "wi-fi");

        //2- Expected data hazırlama (Response body olarak verilmiş)
        JSONObject expectedData=new JSONObject();
        expectedData.put("bookingid",24);
        expectedData.put("booking",reqBody);

        //3- Dönen response kaydedilir
        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        //4- Assertion işlemi
        JsonPath resJP=response.jsonPath();

        assertEquals(expectedData.getJSONObject("booking").get("firstname"), resJP.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"), resJP.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"), resJP.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"), resJP.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resJP.get("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),resJP.get("booking.bookingdates.checkout"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));



    }


}
