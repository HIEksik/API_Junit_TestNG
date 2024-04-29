package testDatas;

import org.json.JSONObject;

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
}
