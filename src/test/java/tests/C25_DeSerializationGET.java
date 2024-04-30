package tests;

import baseUrl.Baseurl_Dammy;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDatas.DummyData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_DeSerializationGET extends Baseurl_Dammy {

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
                    "employee_age":66,f
                    "profile_image":""
                    },
            "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void getDeSerializationGET(){

        specDummy.pathParams("pp1","employee","pp2","3");

        Map<String,Object> expBody= DummyData.mapBodyOlustur();

        Response response=given().spec(specDummy).when().get("/{pp1}/{pp2}");

        Map<String,Object> resMap=response.as(HashMap.class); ////bir map objesinin içine cevabın map'e döndürülmüş halini ekledik

        assertEquals(DummyData.contenType,response.getContentType());
        assertEquals(DummyData.basariliSC,response.getStatusCode());
        assertEquals(expBody.get("status"),resMap.get("status"));
        assertEquals(expBody.get("message"),resMap.get("message"));

        // iç içe datalar olursa .. Assertion işleminde Map e Dönüştürerek yapmalıyız
        assertEquals(((Map)expBody.get("data")).get("id"),((Map)resMap.get("data")).get("id"));
       assertEquals(((Map)expBody.get("data")).get("employee_name"),((Map)resMap.get("data")).get("employee_name"));
       assertEquals(((Map)expBody.get("data")).get("employee_salary"),((Map)resMap.get("data")).get("employee_salary"));
       assertEquals(((Map)expBody.get("data")).get("employee_age"),((Map)resMap.get("data")).get("employee_age"));
       assertEquals(((Map)expBody.get("data")).get("profile_image"),((Map)resMap.get("data")).get("profile_image"));






    }


}
