package tests;

import baseUrl.Baseurl_Dammy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.DummyData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C23_TestDataDummyGET extends Baseurl_Dammy {

    /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine
        bir GET request gonderdigimizde
        donen response’un status code’unun 200,
        content Type’inin application/json
        ve body’sinin asagidaki gibi oldugunu test edin.

        Response Body
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
    public void dummyGetTest(){


        specDummy.pathParams("pp1","employee","pp2","3");

        JSONObject expectedBody= DummyData.expDataOlustur(3,"Ashton Cox",86000,66,"");

        Response response=given().when().spec(specDummy).get("/{pp1}/{pp2}");

        JsonPath rsJP=response.jsonPath();

      assertEquals(DummyData.basariliSC,response.getStatusCode());
      assertEquals(DummyData.contenType,response.getContentType());
      assertEquals(expectedBody.get("status"),rsJP.get("status"));
      assertEquals(expectedBody.getJSONObject("data").get("id"),rsJP.get("data.id"));
      assertEquals(expectedBody.getJSONObject("data").get("employee_name"),rsJP.get("data.employee_name"));
      assertEquals(expectedBody.getJSONObject("data").get("employee_salary"),rsJP.get("data.employee_salary"));
      assertEquals(expectedBody.getJSONObject("data").get("employee_age"),rsJP.get("data.employee_age"));
      assertEquals(expectedBody.getJSONObject("data").get("profile_image"),rsJP.get("data.profile_image"));
      assertEquals(expectedBody.get("message"),rsJP.get("message"));




    }



}
