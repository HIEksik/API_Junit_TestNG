package tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDatas.HerokuAppData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C26_DeSerializationPOST extends BaseUrlHerOkuApp {

     /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
        donen response’un asagidaki gibi oldugunu test edin.
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
                            Response Body // expected data
                        {
                        "bookingid":24,
                        "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                "checkin":"2021-06-01",
                                "checkout":"2021-06-10",
                            "additionalneeds":"wi-fi"
                        }
         */

    @Test
    public void mapPostTestDeSerilization(){

        specHerOkuApp.pathParam("pp1","booking");
        Map<String,Object> reqBody= HerokuAppData.reqMapBodyOlustur();

        Map<String,Object> expBody=HerokuAppData.expBodyMapOlustur();

        Response response=given().spec(specHerOkuApp).contentType(ContentType.JSON).when().body(reqBody).post("/{pp1}");

        Map<String,Object> resMap=response.as(HashMap.class);
        assertEquals(expBody.get("bookingid"),resMap.get("bookingid"));
        assertEquals(((Map)expBody.get("booking")).get("firstname"),((Map)resMap.get("booking")).get("firstname"));
        assertEquals(((Map)expBody.get("booking")).get("lastname"),((Map)resMap.get("booking")).get("lastname"));
        assertEquals(((Map)expBody.get("booking")).get("totalprice"),((Map)resMap.get("booking")).get("totalprice"));
        assertEquals(((Map)expBody.get("booking")).get("depositpaid"),((Map)resMap.get("booking")).get("depositpaid"));
        assertEquals(((Map)expBody.get("booking")).get("additionalneeds"),((Map)resMap.get("booking")).get("additionalneeds"));

        assertEquals(((Map)((Map)expBody.get("booking")).get("bookingdates")).get("checkin"),((Map)((Map)resMap.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(((Map)((Map)expBody.get("booking")).get("bookingdates")).get("checkout"),((Map)((Map)resMap.get("booking")).get("bookingdates")).get("checkout"));

    }
}
