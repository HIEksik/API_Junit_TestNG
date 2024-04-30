package tests;

import baseUrl.BaseUrl_Jsonplaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDatas.JsonPlaceData;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C24_DeSerializationPUT extends BaseUrl_Jsonplaceholder {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body’e sahip bir PUT request yolladigimizda
    donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body

        {
          ("userId",7.0);
        ("id",70.0);
       ("title","voluptatem laborum magni");
       ("body","sunt repellendus quae\nest asperiores aut deleniti esse accusamus repellendus quia aut\nquia dolorem unde\neum tempora esse dolore");

        }

     Response Body:

        {
         ("userId",7.0);
      ("id",70.0);
       ("title","voluptatem laborum magni");
       ("body","sunt repellendus quae\nest asperiores aut deleniti esse accusamus repellendus quia aut\nquia dolorem unde\neum tempora esse dolore");

        }
     */

    @Test
    public void deserializationTest(){


        spacJsonplaceholder.pathParams("pp1","posts","pp2","70");


        //1-Endpoint ve ReqBody Hazırlamak
        Map<String,Object> reqMapBody= JsonPlaceData.mapBodyOlustur();  //Endpoint

        //2-Expected Data Oluşturuldu
        Map<String,Object> expMapBody=JsonPlaceData.mapBodyOlustur();//reqBody


        //3-Dönen Response kaydedildi(JSon)
        Response response=given().spec(spacJsonplaceholder).contentType(ContentType.JSON).when().body(reqMapBody).get("/{pp1}/{pp2}");

        //expectedBody <---------> Response Body
        //    Map                      Json

        //Assertion İşlemini yapabilmek için dönen Json response map türüne çevrilir
        //İşte bu olaya deSerialization denir

        Map<String,Object> resMap=response.as(HashMap.class);// deSerializetion işlemi yapıldı

        assertEquals(expMapBody.get("userId"),resMap.get("userId"));
        assertEquals(expMapBody.get("id"),resMap.get("id"));
        assertEquals(expMapBody.get("title"),resMap.get("title"));
        assertEquals(expMapBody.get("body"),resMap.get("body"));




    }

}
