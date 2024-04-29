package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrl_Jsonplaceholder {



    protected RequestSpecification spacJsonplaceholder;

    @Before
    public void setup(){

        spacJsonplaceholder=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();



    }


}
