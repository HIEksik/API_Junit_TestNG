package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

public class Baseurl_Dammy{

    protected RequestSpecification specDummy;


    @Before
    public void setUp(){

        specDummy=new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/api/v1").build();



    }
}
