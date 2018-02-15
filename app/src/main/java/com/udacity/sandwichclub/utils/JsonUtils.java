package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject nameObject = jsonObject.getJSONObject("name");
        String mainName = nameObject.getString("mainName");
        JSONArray jsonArray = nameObject.getJSONArray("alsoKnownAs");
        List<String>aLsoKnwos = new LinkedList<>();
        for(int x=0;x<jsonArray.length();x++)
        {
            aLsoKnwos.add(jsonArray.getString(x));
        }
        String placeOrigin = jsonObject.getString("placeOfOrigin");
        String getDescription =jsonObject.getString("description");
        String getImage = jsonObject.getString("image");
        JSONArray ingedients = jsonObject.getJSONArray("ingredients");
        List<String>mIngredients = new LinkedList<>();
        for(int x = 0; x<ingedients.length();x++)
        {
            mIngredients.add(ingedients.getString(x));
        }

        return new Sandwich(mainName,aLsoKnwos,placeOrigin,getDescription,getImage,mIngredients);
    }
}
