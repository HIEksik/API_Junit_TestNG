package testDatas;

import org.json.JSONObject;

public class JsonPlaceData {

      /*
   https://jsonplaceholder.typicode.com/posts/22 url'ine
   bir GET request yolladigimizda
   donen response'in
       status kodunun 200
       content type'nın application/json; charset=utf-8
       Connection isimli Header değerinin keep-alive olduğunu
       ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

   Response body :
   {
       "userId":3,
       "id":22,
       "title":"dolor sint quo a velit explicabo quia nam",
       "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
   }
*/


   public static int basariliSC=200;

   public static String contentTeype="application/json; charset=utf-8";

   public static String header="keep-alive";
   public static String header2="cloudflare";

   public static JSONObject expectedDataOlustur01(){
       JSONObject expectedData=new JSONObject();
       expectedData.put("userId",3);
       expectedData.put("id",22);
       expectedData.put("title","dolor sint quo a velit explicabo quia nam");
       expectedData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");
       return expectedData;
   }

   public static JSONObject expectedDataOlusturmaDinamik(int userId, int id , String title, String body){
       JSONObject expectedData=new JSONObject();
       expectedData.put("userId",userId);
       expectedData.put("id",id);
       expectedData.put("title",title);
       expectedData.put("body",body);

       return expectedData;


   }

}
