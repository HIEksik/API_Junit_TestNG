package tests;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C5_Get_ResponseBodyTesti {

    //https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
    //donen Response’in
    //status code'unun 200,
    //ve content type'inin "application/json; charset=utf-8",
    //ve response body'sinde bulunan userId 'nin 5
    //ve response body'sinde bulunan title 'in optio dolor molestias sit
    //oldugunu test edin.

    @Test
    public void get01(){

        //1- endpoint hazırlanır
        String url="https://jsonplaceholder.typicode.com/posts/44";

        //2 - soruda verilmişse expected data hazırlanır ama yok

        //3 - Dönen response kaydedilir
        Response response=given().when().get(url);

        //4 - Assert işlemi
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("userId", Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));

        //System.out.println(response.prettyPrint());



    }
}
