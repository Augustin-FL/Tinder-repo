package com.tinder.parse;

import android.support.annotation.NonNull;
import com.tinder.model.SuperlikeStatus;
import org.json.JSONObject;

/* renamed from: com.tinder.parse.f */
public class C2979f {
    public static SuperlikeStatus m8934a(@NonNull JSONObject jSONObject) {
        SuperlikeStatus superlikeStatus = new SuperlikeStatus();
        JSONObject optJSONObject = jSONObject.optJSONObject("super_likes");
        if (optJSONObject != null) {
            int optInt = optJSONObject.optInt("remaining");
            int optInt2 = optJSONObject.optInt("allotment");
            String optString = optJSONObject.optString("resets_at");
            superlikeStatus.setRemaining(optInt);
            superlikeStatus.setAllotment(optInt2);
            superlikeStatus.setResetDate(optString);
        }
        return superlikeStatus;
    }
}
