package tests;

import baseUrl.BaseUrl_Jsonplaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C20_TestDataJsonPlaceDinamik extends BaseUrl_Jsonplaceholder {

      /*
        https://jsonplaceholder.typicode.com/posts/65 url'ine
        bir GET request yolladigimizda
        donen response’in
            status kodunun 200 olduğunu
            Connection Header değerinin keep-alive olduğunu
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
        {
             "userId": 7,
             "id": 65,
             "title": "consequatur id enim sunt et et",
             "body": "voluptatibus ex esse\nsint explicabo est aliquid cumque adipisci fuga repellat labore\nmolestiae corrupti ex saepe at asperiores et perferendis\nnatus id esse incidunt pariatur"
        }
     */

    @Test
    public void Test02(){

       spacJsonplaceholder.pathParams("pp1","posts","pp2","40");

       //2 - Expected Bdy oluşturma
        JSONObject expBod= JsonPlaceData.expectedDataOlusturmaDinamik(7,65,"enim quo cumque","voluptatibus ex esse\\nsint explicabo est aliquid cumque adipisci fuga repellat labore\\nmolestiae corrupti ex saepe at asperiores et perferendis\\nnatus id esse incidunt pariatur");

        //3- Response kaydedilir
        Response response=given().when().spec(spacJsonplaceholder).get("/{pp1}/{pp2}");

        //4- Assertions işlemi
        JsonPath resJP=response.jsonPath();

       assertEquals(JsonPlaceData.basariliSC,response.getStatusCode());
       assertEquals(JsonPlaceData.header2,response.getHeader("server"));

       assertEquals(expBod.getInt("userId"),resJP.getInt("userId"));
       assertEquals(expBod.getInt("id"),resJP.getInt("id"));

       assertEquals(expBod.getString("title"),resJP.getString("title"));
       assertEquals(expBod.getString("body"),resJP.getString("body"));




    }


}
