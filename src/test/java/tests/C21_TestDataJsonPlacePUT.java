package tests;

import baseUrl.BaseUrl_Jsonplaceholder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatas.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21_TestDataJsonPlacePUT extends BaseUrl_Jsonplaceholder {
     /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body’e sahip bir PUT request yolladigimizda
        donen response’in
            status kodunun 200,
            content type’inin “application/json; charset=utf-8”,
            Connection header degerinin “keep-alive”
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
         Request Body
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
        Response body :
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
     */

    @Test
    public void testDataJsonPlacePUT(){

        spacJsonplaceholder.pathParams("pp1","posts","pp2","70");

        JSONObject reqBody= JsonPlaceData.jsonDataOlusturmaDinamik(10,70,"Ahmet","Merhaba");

        JSONObject expectedBody=JsonPlaceData.jsonDataOlusturmaDinamik(10,70,"Ahmet","Merhaba");

        Response response=given().contentType(ContentType.JSON).when().spec(spacJsonplaceholder).body(reqBody.toString()).put("/{pp1}/{pp2}");

        JsonPath resJP=response.jsonPath();

        assertEquals(JsonPlaceData.basariliSC,response.getStatusCode());
        assertEquals(JsonPlaceData.header,response.getHeader("Connection"));
        assertEquals(JsonPlaceData.contentTeype,response.getContentType());

        assertEquals(expectedBody.getString("title"),resJP.getString("title"));
        assertEquals(expectedBody.getString("body"),resJP.getString("body"));
        assertEquals(expectedBody.getInt("userId"),resJP.getInt("userId"));
        assertEquals(expectedBody.getInt("id"),resJP.getInt("id"));





    }
}