package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C4_Put_ResponseBilgileriAssertion {

    /*

               https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json formatindaki body ile
           bir PUT request gonderdigimizde
           {
                 "title":"Ahmet",

                 "body":"Merhaba",

                 "userId":10,

                 "id":70

           }
           donen Response’un,
           status code’unun 200,
           ve content type’inin application/json; charset=utf8,
           ve Server isimli Header’in degerinin cloudflare,
           ve status Line’in HTTP/1.1 200 OK


     */
    // 1 - EndPoint belirlenir
    // 2- Gerekliyse expected data hazırlanır
    // 3- Actual data kaydedilir
    // 4- Assert işlemi gerçekleştirilir

    @Test
    public void put01(){
        // 1 - EndPoint belirlenir
        String url="https://jsonplaceholder.typicode.com/posts/70";

        JSONObject requestBody=new JSONObject();
        requestBody.put("title","Ahmet");
        requestBody.put("body","Merhaba");
        requestBody.put("userId",10);
        requestBody.put("id",70);

        // 2- Gerekliyse expected data hazırlanır

        // 3- Dönen response kaydedilir

        Response response=given().contentType(ContentType.JSON).when().body(requestBody.toString()).put(url);
        // şimdi dönen responsun dergerlerini sorarak karşılaştıracağız

        // 4- Assert işlemi gerçekleştirilir
        response.then().assertThat()
                .statusCode(200)
                .header("Server","cloudflare")
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");

        System.out.println(response.prettyPrint());


    }

}
