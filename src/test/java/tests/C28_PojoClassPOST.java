package tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoHerOkuAppBookingdates;
import pojos.PojoHerOkuAppExpBody;
import pojos.PojoHerOkuAppReqBody;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_PojoClassPOST extends BaseUrlHerOkuApp {

    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ahmet",
    	                "lastname" : "Bulut",
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
                            "checkout":"2021-06-10"
                        ,
                        "additionalneeds":"wi-fi"
                    }
     */

    @Test
    public void test01(){


        specHerOkuApp.pathParam("pp1","booking");

        PojoHerOkuAppBookingdates bookingdatesPojo=new PojoHerOkuAppBookingdates("2021-06-01","2021-06-10");

        PojoHerOkuAppReqBody reqBodyPojo=new PojoHerOkuAppReqBody("Ahmet","Bulut",500,false,bookingdatesPojo,"wi-fi");


        PojoHerOkuAppReqBody booking=new PojoHerOkuAppReqBody("Ahmet","Bulut",500,false,bookingdatesPojo,"wi-fi");
        PojoHerOkuAppExpBody expBodyPojo=new PojoHerOkuAppExpBody(1088,booking);

        //PojoHerOkuAppExpBody expBodyPojo=new PojoHerOkuAppExpBody(2565,reqBodyPojo); // request bodyle response expected aynıysa bu şekilde olur

        Response response=given().spec(specHerOkuApp).contentType(ContentType.JSON).when().body(reqBodyPojo).post("/{pp1}");

        PojoHerOkuAppExpBody resPojo=response.as(PojoHerOkuAppExpBody.class);

        assertEquals(expBodyPojo.getBookingid(),resPojo.getBookingid());
        assertEquals(expBodyPojo.getBooking().getFirstname(),resPojo.getBooking().getFirstname());
        assertEquals(expBodyPojo.getBooking().getLastname(),resPojo.getBooking().getLastname());
        assertEquals(expBodyPojo.getBooking().getTotalprice(),resPojo.getBooking().getTotalprice());
        assertEquals(expBodyPojo.getBooking().isDepositpaid(),resPojo.getBooking().isDepositpaid());
        assertEquals(expBodyPojo.getBooking().getBookingdates().getCheckin(),resPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expBodyPojo.getBooking().getBookingdates().getCheckout(),resPojo.getBooking().getBookingdates().getCheckout());
        assertEquals(expBodyPojo.getBooking().getAdditionalneeds(),resPojo.getBooking().getAdditionalneeds());



    }


}
