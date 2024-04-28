package tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class C3_JsonObjesiOlusturma {

                        /*
                        C3_JsonObjesiOlusturma

                        Asagidaki JSON Objesini olusturup
                        konsolda yazdirin.
                        {
                        "title":"Ahmet",
                        "body":"Merhaba",
                        "userId":1
                        }

                                     */

    @Test
    public void jsonDataOlustur01(){

        JSONObject jsonObject=new JSONObject();

        jsonObject.put("title","Ahmet");
        jsonObject.put("body","Merhaba");
        jsonObject.put("userId",1);

        System.out.println("JSON data bilgileri "+ jsonObject);

    }

    @Test
    public void JsonDataolustur02(){

        /*
        Asagidaki JSON Objesini olusturup konsolda yazdirin.
       {
       "firstname":"Jim",
       "additionalneeds":"Breakfast",

       "bookingdates":{
                    "checkin":"2018-01-01",
                    "checkout":"2019-01-01"
                       },

       "totalprice":111,
       "depositpaid":true,
       "lastname":"Brown"
       }
         */

        JSONObject innerData=new JSONObject();

        innerData.put("checkin","2018-01-01");
        innerData.put("checkout","2019-01-01");


        JSONObject jsonObject=new JSONObject();

        jsonObject.put("firstname","Jim");
        jsonObject.put("lastname","Brown");
        jsonObject.put("bookingdates",innerData);
        jsonObject.put("totalprice",111);
        jsonObject.put("depositpaid",true);
        jsonObject.put("additionalneeds","Breakfast");

        System.out.println("Json data : " + jsonObject );



    }




}
