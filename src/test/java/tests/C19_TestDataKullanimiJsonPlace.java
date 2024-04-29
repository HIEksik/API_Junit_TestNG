package tests;

import baseUrl.BaseUrl_Jsonplaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;
import testDatas.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class C19_TestDataKullanimiJsonPlace extends BaseUrl_Jsonplaceholder {


      /*
   https://jsonplaceholder.typicode.com/posts/22 url'ine
   bir GET request yolladigimizda
   donen response'in
       status kodunun 200
       content type'nın application/json; charset=utf-8
       Connection isimli Header değerinin keep-alive olduğunu
       ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

   Response body :
   {
       "userId":3,
       "id":22,
       "title":"dolor sint quo a velit explicabo quia nam",
       "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
   }
*/

   @Test
    public void test01(){

        // EndPoint oluşturma
        spacJsonplaceholder.pathParams("pp1","posts","pp2","22");

        // 2- Expected body hazırlama // response verilmiş diye
        JSONObject expectedBody= JsonPlaceData.expectedDataOlustur01();

        //3- Döenen cevabı kaydet

        Response response=given().when().spec(spacJsonplaceholder).get("/{pp1}/{pp2}");

        // 4- Assertion işlemi yapılır

        JsonPath resJP=response.jsonPath();

      assertEquals(JsonPlaceData.basariliSC,response.getStatusCode());
      assertEquals(JsonPlaceData.contentTeype,response.getContentType());
      assertEquals(JsonPlaceData.header,response.getHeader("Connection"));

      assertEquals(expectedBody.get("userId"),resJP.getInt("userId"));
      assertEquals(expectedBody.get("id"),resJP.getInt("id"));
      assertEquals(expectedBody.get("title"),resJP.getString("title"));
      assertEquals(expectedBody.get("body"),resJP.getString("body"));

    }

}
