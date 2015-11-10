package com.tinder.parse;

import android.support.annotation.NonNull;
import com.facebook.share.internal.ShareConstants;
import com.tinder.managers.C2828c;
import com.tinder.model.FacebookAlbum;
import com.tinder.model.FacebookPhoto;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tinder.parse.a */
public class C2972a {
    @NonNull
    public static ArrayList<FacebookAlbum> m8909a(@NonNull JSONObject jSONObject, String str) throws JSONException {
        ArrayList<FacebookAlbum> arrayList = new ArrayList();
        if (jSONObject.has("albums")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("albums");
            if (jSONObject2.has(ShareConstants.WEB_DIALOG_PARAM_DATA)) {
                JSONArray jSONArray = jSONObject2.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
                for (int i = 0; i < jSONArray.length(); i++) {
                    int parseInt;
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    FacebookAlbum facebookAlbum = new FacebookAlbum();
                    facebookAlbum.setId(jSONObject3.optString(ShareConstants.WEB_DIALOG_PARAM_ID));
                    facebookAlbum.setName(jSONObject3.optString(ShareConstants.WEB_DIALOG_PARAM_NAME));
                    String optString = jSONObject3.optString("count");
                    if (optString.length() > 0) {
                        parseInt = Integer.parseInt(optString);
                    } else {
                        parseInt = 0;
                    }
                    facebookAlbum.setCount(parseInt);
                    facebookAlbum.setThumbUrl(C2828c.m8159b(facebookAlbum.getId(), str));
                    if (facebookAlbum.getId() != null) {
                        arrayList.add(facebookAlbum);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public static FacebookAlbum m8908a(@NonNull JSONObject jSONObject) throws JSONException {
        FacebookAlbum facebookAlbum = new FacebookAlbum();
        if (jSONObject.has("photos")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("photos");
            if (jSONObject2.has(ShareConstants.WEB_DIALOG_PARAM_DATA)) {
                JSONArray jSONArray = jSONObject2.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
                facebookAlbum.setThumbUrl(jSONArray.getJSONObject(0).getString(ShareConstants.WEB_DIALOG_PARAM_PICTURE));
                facebookAlbum.setCount(jSONArray.length());
                facebookAlbum.setId("tagged");
                facebookAlbum.setName("Photos of Me");
            }
        }
        return facebookAlbum;
    }

    @NonNull
    public static ArrayList<FacebookPhoto> m8910b(@NonNull JSONObject jSONObject) throws JSONException {
        ArrayList<FacebookPhoto> arrayList = new ArrayList();
        if (jSONObject.has(ShareConstants.WEB_DIALOG_PARAM_DATA)) {
            JSONArray jSONArray = jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                FacebookPhoto facebookPhoto = new FacebookPhoto();
                facebookPhoto.setSourceUrl(jSONObject2.getString(ShareConstants.FEED_SOURCE_PARAM));
                facebookPhoto.setId(jSONObject2.getString(ShareConstants.WEB_DIALOG_PARAM_ID));
                facebookPhoto.setThumb(jSONObject2.getString(ShareConstants.WEB_DIALOG_PARAM_PICTURE));
                if (facebookPhoto.getId() != null) {
                    arrayList.add(facebookPhoto);
                }
            }
        }
        return arrayList;
    }
}
