package com.tinder.parse;

import android.support.annotation.NonNull;
import com.tinder.model.TinderLocation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tinder.parse.g */
public class C2980g {
    @NonNull
    public static List<TinderLocation> m8935a(@NonNull JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("results");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(C2980g.m8938c(optJSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    @NonNull
    public static TinderLocation m8937b(@NonNull JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("results");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return new TinderLocation();
        }
        return C2980g.m8938c(optJSONArray.getJSONObject(0));
    }

    @NonNull
    public static TinderLocation m8938c(@NonNull JSONObject jSONObject) throws JSONException {
        TinderLocation tinderLocation = new TinderLocation();
        if (jSONObject.has("locality")) {
            tinderLocation.setCity(jSONObject.getJSONObject("locality").optString("long_name"));
        }
        if (jSONObject.has("administrative_area_level_1")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("administrative_area_level_1");
            String optString = jSONObject2.optString("short_name");
            String optString2 = jSONObject2.optString("long_name");
            tinderLocation.setStateProvinceShort(optString);
            tinderLocation.setStateProvinceLong(optString2);
        }
        if (jSONObject.has("administrative_area_level_2")) {
            tinderLocation.setCounty(jSONObject.optJSONObject("administrative_area_level_2").optString("long_name"));
        }
        if (jSONObject.has("country")) {
            jSONObject2 = jSONObject.getJSONObject("country");
            optString = jSONObject2.optString("short_name");
            tinderLocation.setCountryLong(jSONObject2.optString("long_name"));
            tinderLocation.setCountryShort(optString);
        }
        if (jSONObject.has("route")) {
            tinderLocation.setRoute(jSONObject.getJSONObject("route").optString("short_name"));
        }
        if (jSONObject.has("street_number")) {
            tinderLocation.setStreetNumber(jSONObject.getJSONObject("street_number").getString("short_name"));
        }
        tinderLocation.setAddress(jSONObject.optString("street_address"));
        tinderLocation.setLatitude(jSONObject.optDouble("lat"));
        tinderLocation.setLongitude(jSONObject.optDouble("lon"));
        return tinderLocation;
    }

    public static void m8936a(@NonNull TinderLocation tinderLocation, @NonNull JSONObject jSONObject) {
        tinderLocation.setLatitude(jSONObject.optDouble("lat"));
        tinderLocation.setLongitude(jSONObject.optDouble("lon"));
    }
}
