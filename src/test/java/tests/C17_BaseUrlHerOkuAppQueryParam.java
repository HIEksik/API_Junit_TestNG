package tests;

import baseUrl.BaseUral_Herokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlHerOkuAppQueryParam extends BaseUral_Herokuapp {

    /*
     "https://restful-booker.herokuapp.com/booking endpointine
        gerekli Query parametrelerini yazarak
            “firstname” degeri “Jim” olan rezervasyon oldugunu
        test edecek bir GET request gonderdigimizde,
        donen response’un
            status code’unun 200 oldugunu
            // ve “Jim” ismine sahip 4 booking oldugunu test edin

         */


    @Test
    public void test01(){

        specHerokuapp.pathParam("pp1","booking").queryParam("firstname","Jim");

        Response response=given().when().spec(specHerokuapp).get("/{pp1}");

        response.then().assertThat().statusCode(200);


    }
}
