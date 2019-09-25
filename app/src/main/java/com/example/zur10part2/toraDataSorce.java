package com.example.zur10part2;

import android.content.res.AssetManager;

import com.example.zur10part2.utils.IO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class toraDataSorce {

    public interface  OnDataArrivedListener{
        void callbaack(ArrayList<String> data,Exception e);
    }


    public static void getData(AssetManager am, ScrollingActivity a,String  sefer) throws IOException, JSONException {

       new Thread(()-> {

           try {
               ArrayList<String> data = null;
               int mishpat=0;
               int j=0;
               System.out.println(sefer);
               data = new ArrayList<>();
               String result = IO.read(am, sefer);

               JSONObject o = new JSONObject(result);
               JSONArray text = o.getJSONArray("text");

               for (int i = 0; i < text.length(); i++) {
                   JSONArray perek = text.getJSONArray(i);
                   System.out.println(perek);
                   mishpat ++;
                   data.add( "\n                 נערך עיי צור אמנון    " + "    פרק  "+ mishpat+ "\n");
                   for ( j = 0; j < perek.length(); j++) {
                       String line = perek.getString(j);
                       data.add(line);
                   }

               }

               a.callbacke(data,null);
               System.out.println(data);
           } catch (IOException e) {
               e.printStackTrace();
           } catch (JSONException e) {
               e.printStackTrace();
               a.callbacke(null,e);
           }

       }).start();

    }

}
