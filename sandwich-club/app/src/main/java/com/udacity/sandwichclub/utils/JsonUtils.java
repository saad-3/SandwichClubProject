package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = null ;

        try {


            JSONObject sandwichO = new JSONObject(json);
            JSONObject nameObject = sandwichO.getJSONObject("name");
            JSONArray INGJson = sandwichO.getJSONArray("ingredients");
            JSONArray ALAJson = nameObject.getJSONArray("alsoKnownAs");

            String name = nameObject.getString("mainName");
            String image = sandwichO.getString("image");
            String des = sandwichO.getString("description");
            String poo = sandwichO.getString("placeOfOrigin");



            ArrayList ALA = new ArrayList();
            ArrayList ING = new ArrayList();
            for(int i =0 ; i< INGJson.length(); i++){
                ING.add(i,INGJson.get(i).toString());
            }
            for(int j =0 ; j< ALAJson.length(); j++){
                ALA.add(j,ALAJson.get(j).toString());
            }

            sandwich = new Sandwich(name,ALA,poo,des,image,ING);



        }
        catch (JSONException e){
            e.printStackTrace();
        }

        return sandwich;
    }
}
