package tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.HerokuAppData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_TestDataHerOKuAppPost extends BaseUrlHerOkuApp {

     /*
                https://restful-booker.herokuapp.com/booking url’ine
                asagidaki body'ye sahip bir POST request gonderdigimizde
                donen response’un bookingid haric asagidaki gibi oldugunu test edin.
                Request body
                       {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                                },
                        "additionalneeds" : "wi-fi"
                        }
               Expected response body
                        {
                         "bookingid":24,
                         "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
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
    public void herokuappPostTest(){

        specHerOkuApp.pathParam("pp1","booking");
        JSONObject reqBody= HerokuAppData.reqBodyOlustur();

        JSONObject expectedBody=HerokuAppData.expectedBodyOlustur();

        Response response=given().contentType(ContentType.JSON).when().spec(specHerOkuApp).body(reqBody.toString()).post("/{pp1}");

        JsonPath resJP=response.jsonPath();
        assertEquals(expectedBody.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
        assertEquals(expectedBody.getJSONObject("booking").get("lastname"),resJP.get("booking.lastname"));
        assertEquals(expectedBody.getJSONObject("booking").get("totalprice"),resJP.get("booking.totalprice"));
        assertEquals(expectedBody.getJSONObject("booking").get("depositpaid"),resJP.get("booking.depositpaid"));
        assertEquals(expectedBody.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));
        assertEquals(expectedBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resJP.get("booking.bookingdates.checkin"));
        assertEquals(expectedBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),resJP.get("booking.bookingdates.checkout"));





    }

}
