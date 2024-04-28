package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class C8_JsonPathKullanimi {

    /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
                },
    "phoneNumbers": [
                    {
                        "type": "iPhone",
                        "number": "0123-4567-8888"
                    },
                    {
                        "type": "home",
                        "number": "0123-4567-8910"
                    }
                    ]
    }

  */

    @Test
    public void jsonPathKullanimi(){

        JSONObject homeTel=new JSONObject();
        homeTel.put("type", "home");
        homeTel.put("number", "0123-4567-8910");

        JSONObject iPhoneTel=new JSONObject();
        iPhoneTel.put("type", "iPhone");
        iPhoneTel.put("number", "0123-4567-8888");

        JSONObject adress=new JSONObject();
        adress.put("streetAddress", "naist street");
        adress.put("city", "Nara");
        adress.put("postalCode", "630-0192");

        JSONArray phoneNumbers=new JSONArray();
        phoneNumbers.put(0,iPhoneTel);
        phoneNumbers.put(1,homeTel);

        JSONObject personelInfo=new JSONObject();
        personelInfo.put("firstName", "John");
        personelInfo.put("lastName", "doe");
        personelInfo.put("age", 26);
        personelInfo.put("address", adress);
        personelInfo.put("phoneNumbers",phoneNumbers);

        System.out.println("İsim: "+personelInfo.get("firstName"));
        System.out.println("Soyİsim: "+personelInfo.get("lastName"));
        System.out.println("Age: "+personelInfo.get("age"));

        System.out.println("Phone Numbers: " + personelInfo.getJSONArray("phoneNumbers").getJSONObject(0).get("type")
                                             + personelInfo.getJSONArray("phoneNumbers").getJSONObject(0).get("number")
                                             + personelInfo.getJSONArray("phoneNumbers").getJSONObject(1).get("type")
                                             + personelInfo.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));

        System.out.println("Adress :" +personelInfo.getJSONObject("address").get("streetAddress")
                                      +personelInfo.getJSONObject("address").get("city")
                                      +personelInfo.getJSONObject("address").get("postalCode"));


    }


}
