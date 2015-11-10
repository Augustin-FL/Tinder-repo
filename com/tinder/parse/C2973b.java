package com.tinder.parse;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.tinder.model.InstagramAuthError;
import com.tinder.model.InstagramCodeError;
import com.tinder.model.InstagramCodeError.Builder;
import com.tinder.model.InstagramDataSet;
import com.tinder.model.InstagramPhoto;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tinder.parse.b */
public class C2973b {
    @NonNull
    public static InstagramDataSet m8912a(@NonNull JSONObject jSONObject) {
        int i = 0;
        InstagramDataSet instagramDataSet = new InstagramDataSet();
        JSONObject optJSONObject = jSONObject.optJSONObject("instagram");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("last_fetch_time");
            String optString2 = optJSONObject.optString("profile_picture");
            String optString3 = optJSONObject.optString("username");
            int optInt = optJSONObject.optInt("media_count", 0);
            instagramDataSet.setLastFetchTime(optString);
            instagramDataSet.setProfilePictureUrl(optString2);
            instagramDataSet.setUserName(optString3);
            instagramDataSet.setMediaCount(optInt);
            JSONArray optJSONArray = optJSONObject.optJSONArray("photos");
            List arrayList = new ArrayList();
            if (optJSONArray != null) {
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    InstagramPhoto instagramPhoto = new InstagramPhoto();
                    instagramPhoto.setUrlLarge(optJSONObject2.optString("image"));
                    instagramPhoto.setUrlSmall(optJSONObject2.optString("thumbnail"));
                    String optString4 = optJSONObject2.optString(ShareConstants.WEB_DIALOG_PARAM_LINK);
                    String optString5 = optJSONObject2.optString(ShareConstants.WEB_DIALOG_PARAM_ID);
                    instagramPhoto.setTimestamp(optJSONObject2.optLong("ts") * 1000);
                    instagramPhoto.setLink(optString4);
                    instagramPhoto.setPhotoId(optString5);
                    arrayList.add(instagramPhoto);
                    i++;
                }
            }
            instagramDataSet.setInstagramPhotos(arrayList);
        }
        return instagramDataSet;
    }

    @NonNull
    public static InstagramCodeError m8911a(@NonNull Uri uri) {
        int i = 0;
        Object queryParameter = uri.getQueryParameter(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        if (!TextUtils.isEmpty(queryParameter)) {
            i = Integer.parseInt(queryParameter);
        }
        String queryParameter2 = uri.getQueryParameter(NativeProtocol.BRIDGE_ARG_ERROR_BUNDLE);
        String queryParameter3 = uri.getQueryParameter("errorReason");
        return new Builder(queryParameter2).ErrorReason(queryParameter3).ErrorDescription(uri.getQueryParameter("errorDescription")).StatusCode(i).build();
    }

    @NonNull
    public static InstagramAuthError m8913b(@NonNull JSONObject jSONObject) {
        return new InstagramAuthError(jSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS), jSONObject.optString(NativeProtocol.BRIDGE_ARG_ERROR_BUNDLE));
    }
}
