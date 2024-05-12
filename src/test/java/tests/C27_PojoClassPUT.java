package tests;

import baseUrl.BaseUrl_Jsonplaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoJsonPlaceHolder;
import testDatas.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_PojoClassPUT extends BaseUrl_Jsonplaceholder {
     /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body'e sahip bir PUT request yolladigimizda
    donen response'in
    status kodunun 200,
    content type'inin "application/json; charset=utf-8",
    Connection header degerinin "keep-alive"
    ve response body'sinin asagida verilen ile ayni oldugunu test ediniz
     Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Response body : // expected data
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
 */

    @Test
    public void test01(){

        //1-EndPoint ve Request body hazırlanır
        spacJsonplaceholder.pathParams("pp1","posts","pp2","70");
        PojoJsonPlaceHolder reqBodyPojo=new PojoJsonPlaceHolder("Ahmet","Merhaba",10,70);



        //2-Expected Data oluşturulur
        PojoJsonPlaceHolder expectedBodyPojo=new PojoJsonPlaceHolder("Ahmet","Merhaba",10,70);

        Response response=given().spec(spacJsonplaceholder).contentType(ContentType.JSON).when().body(reqBodyPojo).put("/{pp1}/{pp2}");
        // eger dönen response body varsa ikisinin de datasını karşılaştırabilmek için  ikisinin de data türü aynı olmalı


        // dönüştürme işlemi burda yapılır
        PojoJsonPlaceHolder resPOJO=response.as(PojoJsonPlaceHolder.class);

        assertEquals(expectedBodyPojo.getTitle(),resPOJO.getTitle());
        assertEquals(expectedBodyPojo.getBody(),resPOJO.getBody());
        assertEquals(expectedBodyPojo.getUserId(),resPOJO.getUserId());
        assertEquals(expectedBodyPojo.getId(),resPOJO.getId());

        assertEquals(JsonPlaceData.basariliSC,response.getStatusCode());
        assertEquals(JsonPlaceData.contentTeype,response.getContentType());
        assertEquals(JsonPlaceData.header,response.getHeader("Connection"));






    }


}
