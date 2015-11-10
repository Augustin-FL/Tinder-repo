package com.tinder.parse;

import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.tinder.parse.h */
public class C2981h {
    public static List<String> m8939a(JSONArray jSONArray) {
        C3095y.m9471a("tutorials parsing");
        List<String> arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.optString(i));
            }
        } else {
            C3095y.m9471a("tutorials empty");
        }
        return arrayList;
    }
}
