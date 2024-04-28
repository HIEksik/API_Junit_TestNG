package tests;

import io.restassured.internal.mapping.JsonbMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class C11_Get_expectedDataOlusturma {

     /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine
        bir GET request yolladigimizda
        donen response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
        {
        "userId":3,
        "id":22,
        "title":"dolor sint quo a velit explicabo quia nam",
        "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }

     */

    @Test
    public void expectedDataOlusturma(){

        //1- EndPoint oluştur
        String url="https://jsonplaceholder.typicode.com/posts/22";

        //2- ExpectedData oluşturma (Response body olarak verilmiş onun için oluşturuyoruz)
        JSONObject expecData=new JSONObject();
        expecData.put("userId",3);
        expecData.put("id",22);
        expecData.put("title","dolor sint quo a velit explicabo quia nam");
        expecData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        //3- Dönen response kaydedilir

        Response response=given().when().get(url);

        //4- Assertion işlemi Bu defa Hard Assert ile yapacaz JUnit ten
        JsonPath respJson=response.jsonPath();

       assertEquals(expecData.get("userId"),respJson.get("userId"));
       assertEquals(expecData.get("id"),respJson.get("id"));
       assertEquals(expecData.get("title"),respJson.get("title"));
       assertEquals(expecData.get("body"),respJson.get("body"));


    }
}
