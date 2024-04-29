package tests;

import baseUrl.BaseUrl_Jsonplaceholder;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C16_BaseUrlJsonPlaceHolder extends BaseUrl_Jsonplaceholder {

     /*
    Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
    1-  https://jsonplaceholder.typicode.com/posts endpointine bir GET request gonderdigimizde
    donen response’un status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test edin

    2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde
    donen response’un status code’unun 200 oldugunu ve “title” degerinin “optio dolor molestias sit” oldugunu test edin

    3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request gonderdigimizde,
     donen response’un status code’unun 200 oldugunu ve response body’sinin null oldugunu test edin
     */

   @Test
    public void test01(){
        spacJsonplaceholder.pathParam("pp1","posts");

       Response response=given().when().spec(spacJsonplaceholder).get("/{pp1}");

       response.then().assertThat().statusCode(200).body("id",hasSize(100));

   }

   @Test
    public void test02(){
       spacJsonplaceholder.pathParams("pp1","posts","pp2","44");

       Response response=given().when().spec(spacJsonplaceholder).get("/{pp1}/{pp2}");

       response.then().assertThat().statusCode(200).body("title",equalTo("optio dolor molestias sit"));


   }
   @Test
    public void test03(){
       spacJsonplaceholder.pathParams("pp1","posts","pp2","50");

       Response response=given().when().spec(spacJsonplaceholder).get("/{pp1}/{pp2}");

       response.then().assertThat().statusCode(200).body("title",equalTo("repellendus qui recusandae incidunt voluptates tenetur qui omnis exercitationem"));

   }



}
