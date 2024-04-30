package testDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HerokuAppData {
    /*
     {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                                },
                        "additionalneeds" : "wi-fi"
                        }
     */


    public static JSONObject reqBodyOlustur(){

        JSONObject innerData=new JSONObject();
        innerData.put("checkin" , "2021-06-01");
        innerData.put("checkout" , "2021-06-10");

        JSONObject reqaData=new JSONObject();
        reqaData.put("firstname" , "Ahmet");
        reqaData.put("lastname" , "Bulut");
        reqaData.put("totalprice" , 500);
        reqaData.put("depositpaid" , false);
        reqaData.put("bookingdates",innerData);
        reqaData.put("additionalneeds" , "wi-fi");
    return reqaData;
    }

    public static JSONObject expectedBodyOlustur() {

        JSONObject expectData=new JSONObject();
        expectData.put("bookingid","24");
        JSONObject booking=reqBodyOlustur();
        expectData.put("booking", booking);

        return expectData;

    }

    public static Map<String,Object> reqMapBodyOlustur(){
        Map<String,Object> reqData=new HashMap<>();
        Map<String,Object> bookingdatesMap=new HashMap<>();

        bookingdatesMap.put("checkin" , "2021-06-01");
        bookingdatesMap.put("checkout" , "2021-06-10");

        reqData.put("firstname" , "Ahmet");
        reqData.put("lastname" , "Bulut");
        reqData.put("totalprice" , 4757.0);
        reqData.put("depositpaid" , false);
        reqData.put("bookingdates",bookingdatesMap);
        reqData.put("additionalneeds" , "wi-fi");

        return reqData;

    }

    public static Map<String,Object> expBodyMapOlustur(){

        Map<String,Object> expBodyMap=new HashMap<>();
        expBodyMap.put("bookingid",4326.0);
        expBodyMap.put("bookingid",reqMapBodyOlustur());

        return expBodyMap;

    }

}
