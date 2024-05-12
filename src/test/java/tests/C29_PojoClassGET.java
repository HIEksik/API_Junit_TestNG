package tests;

import baseUrl.Baseurl_Dammy;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.DummyDataPojos;
import pojos.DummyExpBodyPojos;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C29_PojoClassGET extends Baseurl_Dammy {

      /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine
    bir GET request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

	Response Body
	// expected data
        {
        "status":"success",
        "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
        "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void test01(){

        specDummy.pathParams("pp1","employee","pp2","3");

        DummyDataPojos dataPojo=new DummyDataPojos(3,"Ashton Cox",86000,66,"");

        DummyExpBodyPojos expBodyPojo=new DummyExpBodyPojos("success",dataPojo,"Successfully! Record has been fetched.");

        Response response=given().spec(specDummy).when().get("/{pp1}/{pp2}");

        DummyExpBodyPojos resPOJO=response.as(DummyExpBodyPojos.class);

        assertEquals(expBodyPojo.getStatus(),resPOJO.getStatus());
        assertEquals(expBodyPojo.getMessage(),resPOJO.getMessage());
        assertEquals(expBodyPojo.getData().getId(),resPOJO.getData().getId());
        assertEquals(expBodyPojo.getData().getEmployee_name(),resPOJO.getData().getEmployee_name());
        assertEquals(expBodyPojo.getData().getEmployee_salary(),resPOJO.getData().getEmployee_salary());
        assertEquals(expBodyPojo.getData().getEmployee_age(),resPOJO.getData().getEmployee_age());
        assertEquals(expBodyPojo.getData().getProfile_image(),resPOJO.getData().getProfile_image());



    }


}
