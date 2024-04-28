package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti{

     /*
   http://dummy.restapiexample.com/api/v1/employee/3 url'ine
   bir GET request gonderdigimizde donen response'un asagidaki gibi oldugunu test edin.

      (Response Body verilmiş  ) Expected hazırlanacak
       {
           "status":"success",
           "data":{
                     "id": 12,
                     "employee_name": "Quinn Flynn",
                     "employee_salary": 342000,
                     "employee_age": 22,
                     "profile_image": ""
                   },
           "message":"Successfully! Record has been fetched."
       }
  */


    @Test
    public void softAssertTesti(){

        // EndPoint hazırlama (Request body verilirse o da burada hazırlanır)
        String url="http://dummy.restapiexample.com/api/v1/employee/3";

        // 2- Expected Body hazırlıyoruz
        JSONObject data=new JSONObject();
        data.put("id", 3);
        data.put("employee_name", "Ashton Cox");
        data.put("employee_salary", 86000);
        data.put("employee_age", 66);
        data.put("profile_image", "");

        JSONObject expectedBody=new JSONObject();
        expectedBody.put("status","success");
        expectedBody.put("data",data);
        expectedBody.put("message","Successfully! Record has been fetched.");


        // 3- Dönen responseyi kaydedelim
        Response response=given().when().get(url);

        // 4- Assertion işlemi
        JsonPath resJP=response.jsonPath();// gelen cevap JsonPath türüne çevirilir
        SoftAssert softAssert=new SoftAssert();

       softAssert.assertEquals(resJP.get("status"),expectedBody.get("status"));
       softAssert.assertEquals(resJP.get("data.id"),expectedBody.getJSONObject("data").get("id"));
       softAssert.assertEquals(resJP.get("data.employee_name"),expectedBody.getJSONObject("data").get("employee_name"));
       softAssert.assertEquals(resJP.get("data.employee_salary"),expectedBody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(resJP.get("data.employee_age"),expectedBody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(resJP.get("data.profile_image"),expectedBody.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(resJP.get("message"),expectedBody.get("message"));
        softAssert.assertAll();


    }


}
