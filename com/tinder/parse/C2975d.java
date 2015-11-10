package com.tinder.parse;

import android.support.annotation.NonNull;
import android.util.Pair;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.BuildConfig;
import com.tinder.enums.MomentAction;
import com.tinder.enums.PhotoSizeMoment;
import com.tinder.model.Moment;
import com.tinder.model.Moment.RatedType;
import com.tinder.model.MomentLike;
import com.tinder.model.PhotoMoment;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3095y;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tinder.parse.d */
public class C2975d {
    public static Pair<String, ArrayList<MomentLike>> m8922a(@NonNull JSONObject jSONObject, @NonNull Map<String, Moment> map) {
        try {
            ArrayList arrayList = new ArrayList();
            String optString = jSONObject.optString("last_activity_date");
            JSONArray jSONArray = jSONObject.getJSONArray("likes");
            DateFormat b = C3070i.m9369b();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(C2975d.m8923a(map, b, jSONArray.getJSONObject(i)));
            }
            return new Pair(optString, arrayList);
        } catch (Exception e) {
            C3095y.m9479c(BuildConfig.FLAVOR + e);
            return null;
        }
    }

    public static Pair<String, ArrayList<Moment>> m8921a(@NonNull JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        String str = BuildConfig.FLAVOR;
        try {
            String optString = jSONObject.optString("last_activity_date");
            JSONArray jSONArray = jSONObject.getJSONArray("moments");
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(C2975d.m8924b(jSONArray.getJSONObject(i)));
            }
            return new Pair(optString, arrayList);
        } catch (Exception e) {
            C3095y.m9479c(e.toString());
            return null;
        }
    }

    @NonNull
    public static MomentLike m8923a(@NonNull Map<String, Moment> map, @NonNull DateFormat dateFormat, @NonNull JSONObject jSONObject) throws ParseException {
        String optString = jSONObject.optString("liked_by");
        String optString2 = jSONObject.optString("date");
        String optString3 = jSONObject.optString("moment");
        String optString4 = jSONObject.optString("thumb", BuildConfig.FLAVOR);
        if (map.containsKey(optString3)) {
            optString4 = ((Moment) map.get(optString3)).getMomentPhoto().getProcessedFile(PhotoSizeMoment.SMALL);
        }
        return new MomentLike(optString2, optString3, optString, optString4, dateFormat.parse(optString2).getTime());
    }

    @NonNull
    public static Moment m8924b(@NonNull JSONObject jSONObject) throws Exception {
        RatedType ratedType;
        String str = null;
        String str2 = null;
        String str3 = null;
        PhotoMoment photoMoment = null;
        String optString = jSONObject.optString("_id");
        MomentAction momentAction = MomentAction.get(jSONObject.optString(NativeProtocol.WEB_DIALOG_ACTION, MomentAction.CREATE.getAction()));
        String optString2 = jSONObject.optString("created_by");
        long a = C3070i.m9362a(jSONObject.optString("date"));
        String optString3 = jSONObject.optString("text");
        String optString4 = jSONObject.optString("filter");
        JSONObject optJSONObject = jSONObject.optJSONObject("text_attributes");
        if (optJSONObject != null) {
            str = optJSONObject.optString("alignment");
            str2 = optJSONObject.optString("size");
            str3 = optJSONObject.optString("height");
        }
        optJSONObject = jSONObject.optJSONObject("media");
        if (optJSONObject != null) {
            String optString5 = optJSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_ID);
            optJSONObject = optJSONObject.getJSONObject("processedFiles");
            photoMoment = new PhotoMoment(optString5, new String[]{optJSONObject.optString("large"), optJSONObject.optString("medium"), optJSONObject.optString("orig"), optJSONObject.optString("small"), optJSONObject.optString("thumb")});
        }
        int optInt = jSONObject.optInt("viewed", RatedType.UNRATED.getIntConst());
        int optInt2 = jSONObject.optInt("likes_count", 0);
        if (optInt == 1) {
            ratedType = RatedType.LIKED;
        } else if (optInt == -1) {
            ratedType = RatedType.PASSED;
        } else {
            ratedType = RatedType.UNRATED;
        }
        Moment moment = new Moment(optString, optString2, a, optString3, photoMoment, optString4, str, str2, str3, null, false, momentAction, optInt2);
        moment.setRatedType(ratedType);
        return moment;
    }
}
