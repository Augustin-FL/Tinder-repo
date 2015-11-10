package com.tinder.parse;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.BuildConfig;
import com.tinder.enums.Gender;
import com.tinder.managers.C2913k.C2912a;
import com.tinder.managers.C2925l;
import com.tinder.managers.ManagerApp;
import com.tinder.model.CommonConnection;
import com.tinder.model.ConnectionsGroup;
import com.tinder.model.InstagramDataSet;
import com.tinder.model.Interest;
import com.tinder.model.PhotoUser;
import com.tinder.model.ProcessedPhoto;
import com.tinder.model.TinderLocation;
import com.tinder.model.TinderReportNotification;
import com.tinder.model.User;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3095y;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserParse {

    public enum RecsResponse {
        STATUS_NOT_OK,
        EXHAUSTED,
        TIMEOUT,
        NO_NEW_RECS,
        RECS
    }

    /* renamed from: com.tinder.parse.UserParse.a */
    public static class C2971a implements Comparator<TinderReportNotification> {
        public /* synthetic */ int compare(@NonNull Object obj, @NonNull Object obj2) {
            return m8897a((TinderReportNotification) obj, (TinderReportNotification) obj2);
        }

        public int m8897a(@NonNull TinderReportNotification tinderReportNotification, @NonNull TinderReportNotification tinderReportNotification2) {
            int compareTo = tinderReportNotification2.getType().compareTo(tinderReportNotification.getType());
            if (compareTo == 0) {
                return tinderReportNotification2.getTier().compareTo(tinderReportNotification.getTier());
            }
            return compareTo;
        }
    }

    @Nullable
    public static Pair<RecsResponse, ArrayList<User>> m8898a(@NonNull JSONObject jSONObject, @Nullable Map<String, Boolean> map) throws JSONException, OutOfMemoryError {
        DateFormat a = C3070i.m9366a();
        if (jSONObject.has(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
            String string = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            if (string.equals("recs exhausted")) {
                C3095y.m9471a("recs were exhausted");
                return new Pair(RecsResponse.EXHAUSTED, null);
            } else if (string.equals("recs timeout")) {
                C3095y.m9471a("recs timeout");
                return new Pair(RecsResponse.TIMEOUT, null);
            }
        }
        if (jSONObject.has(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)) {
            if (jSONObject.getInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == HttpStatus.SC_OK) {
                C3095y.m9471a("recs: " + jSONObject.toString());
                JSONArray jSONArray = jSONObject.getJSONArray("results");
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                Set hashSet = new HashSet(length);
                int i = 0;
                while (i < length) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String string2 = jSONObject2.getString("_id");
                        boolean optBoolean = jSONObject2.optBoolean("is_super_like", false);
                        if ((map == null || !map.containsKey(string2) || (!((Boolean) map.get(string2)).booleanValue() && optBoolean)) && !hashSet.contains(string2)) {
                            hashSet.add(string2);
                            Date parse = a.parse(jSONObject2.getString("birth_date"));
                            String optString = jSONObject2.optString("bio", BuildConfig.FLAVOR);
                            String string3 = jSONObject2.getString(ShareConstants.WEB_DIALOG_PARAM_NAME);
                            Gender gender = Gender.values()[jSONObject2.getInt("gender")];
                            int optInt = jSONObject2.optInt("distance_mi", 1);
                            String optString2 = jSONObject2.optString("ping_time", BuildConfig.FLAVOR);
                            boolean optBoolean2 = jSONObject2.optBoolean("is_traveling");
                            String optString3 = jSONObject2.optString("travel_location_name");
                            int optInt2 = jSONObject2.optInt("travel_distance_mi");
                            String optString4 = jSONObject2.optString("location_name");
                            String optString5 = jSONObject2.optString("location_name");
                            String optString6 = jSONObject2.optString("location_proximity");
                            JSONArray optJSONArray = jSONObject2.optJSONArray("photos");
                            int length2 = optJSONArray == null ? 0 : optJSONArray.length();
                            ArrayList arrayList2 = new ArrayList(length2);
                            if (length2 > 0) {
                                for (int i2 = 0; i2 < length2; i2++) {
                                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                                    String string4 = jSONObject3.getString(ShareConstants.WEB_DIALOG_PARAM_ID);
                                    String string5 = jSONObject3.getString(NativeProtocol.WEB_DIALOG_URL);
                                    JSONArray jSONArray2 = jSONObject3.getJSONArray("processedFiles");
                                    int length3 = jSONArray2.length();
                                    arrayList = new ArrayList(length3);
                                    for (int i3 = 0; i3 < length3; i3++) {
                                        jSONObject3 = jSONArray2.getJSONObject(i3);
                                        arrayList.add(new ProcessedPhoto(string4, string2, jSONObject3.getString(NativeProtocol.WEB_DIALOG_URL), jSONObject3.getInt("width"), jSONObject3.getInt("height")));
                                    }
                                    arrayList2.add(new PhotoUser(string5, string4, arrayList));
                                }
                            }
                            boolean optBoolean3 = jSONObject2.optBoolean("is_brand", false);
                            Pair e = m8906e(jSONObject2);
                            Pair a2 = m8899a(jSONObject2, false);
                            User user = new User(string3, optString, parse, string2, null, gender, null, null, optInt, arrayList2, optString2, optString5, optString6, jSONObject2.optBoolean("is_verified", false), optBoolean, optBoolean3);
                            user.setRecAndPassporting(optBoolean2);
                            user.setTravelLocationName(optString3);
                            user.setTravelDistanceMiles(optInt2);
                            user.setPingLocationName(optString4);
                            user.setCommonInterests((List) e.first);
                            user.setUncommonInterests((List) e.second);
                            user.setNumConnections(((Integer) a2.first).intValue());
                            user.setConnections((ConnectionsGroup) a2.second);
                            user.setInstagramDataSet(C2973b.m8912a(jSONObject2));
                            arrayList.add(user);
                            i++;
                        } else {
                            C3095y.m9471a("Found a DUPE in the json response!");
                            i++;
                        }
                    } catch (JSONException e2) {
                        C3095y.m9479c("Parse recs : " + e2.toString());
                    } catch (OutOfMemoryError e3) {
                        C3095y.m9479c("Parse recs : " + e3.toString());
                    } catch (ParseException e4) {
                        C3095y.m9479c("Parse recs : " + e4.toString());
                    }
                }
                C3095y.m9471a("newRecIds " + hashSet + " listRec " + arrayList);
                if (!hashSet.isEmpty()) {
                    return new Pair(RecsResponse.RECS, arrayList);
                }
                C3095y.m9471a("No new recs found..retrying getting recs");
                return new Pair(RecsResponse.NO_NEW_RECS, null);
            }
        }
        return new Pair(RecsResponse.STATUS_NOT_OK, null);
    }

    @Nullable
    public static User m8900a(@NonNull JSONObject jSONObject) throws Exception {
        DateFormat a = C3070i.m9366a();
        String string = jSONObject.getString("bio");
        Date parse = a.parse(jSONObject.getString("birth_date"));
        String str = null;
        if (jSONObject.has("_id")) {
            str = jSONObject.getString("_id");
        } else {
            if (jSONObject.has(ShareConstants.WEB_DIALOG_PARAM_ID)) {
                str = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_ID);
            } else {
                C3095y.m9471a("WTF no ID?!");
            }
        }
        Date parse2 = a.parse(jSONObject.getString("ping_time"));
        Gender gender = Gender.values()[jSONObject.getInt("gender")];
        String string2 = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_NAME);
        int i = (int) jSONObject.getDouble("distance_mi");
        String optString = jSONObject.optString("location_name");
        String optString2 = jSONObject.optString("location_proximity");
        JSONArray optJSONArray = jSONObject.optJSONArray("photos");
        String optString3 = jSONObject.optString("ping_time", BuildConfig.FLAVOR);
        Object arrayList = new ArrayList();
        if (optJSONArray != null) {
            m8902a(optJSONArray, arrayList, str);
        }
        Pair e = m8906e(jSONObject);
        Pair a2 = m8899a(jSONObject, false);
        boolean optBoolean = jSONObject.optBoolean("is_verified", false);
        boolean optBoolean2 = jSONObject.optBoolean("is_super_like", false);
        boolean optBoolean3 = jSONObject.optBoolean("is_brand", false);
        C3095y.m9471a("isBrand:" + optBoolean3);
        User user = new User(string2, string, parse, str, parse2, gender, null, null, i, arrayList, optString3, optString, optString2, optBoolean, optBoolean2, optBoolean3);
        user.setCommonInterests((List) e.first);
        user.setUncommonInterests((List) e.second);
        user.setNumConnections(((Integer) a2.first).intValue());
        user.setConnections((ConnectionsGroup) a2.second);
        user.setInstagramDataSet(C2973b.m8912a(jSONObject));
        return user;
    }

    @NonNull
    public static C2912a m8903b(@NonNull JSONObject jSONObject) {
        C2912a c2912a = new C2912a();
        DateFormat a = C3070i.m9366a();
        try {
            int i;
            Date date;
            boolean z;
            if (!jSONObject.isNull("pos")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("pos");
                ManagerApp.m7913d().m8194a(jSONObject2.getDouble("lat"), jSONObject2.getDouble("lon"));
            }
            int i2 = jSONObject.getInt("distance_filter");
            int i3 = jSONObject.getInt("age_filter_min");
            int i4 = jSONObject.getInt("age_filter_max");
            JSONArray optJSONArray = jSONObject.optJSONArray("purchases");
            if (optJSONArray != null) {
                boolean z2 = false;
                for (i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                    if (jSONObject3.has("product_id") && C2925l.m8621a(jSONObject3.getString("product_id"))) {
                        z2 = true;
                    }
                }
                ManagerApp.m7914e().m8792B(z2);
            }
            String string = jSONObject.getString("birth_date");
            boolean equals = string.equals("-1");
            if (equals) {
                date = null;
            } else {
                date = a.parse(string);
            }
            Date date2 = null;
            if (!TextUtils.isEmpty(jSONObject.optString("ping_time"))) {
                date2 = a.parse(jSONObject.getString("ping_time"));
            }
            i = jSONObject.getInt("gender");
            if (i == -1) {
                z = true;
            } else {
                z = false;
            }
            Gender gender = Gender.values()[Math.abs(i)];
            String optString = jSONObject.optString("bio", BuildConfig.FLAVOR);
            if (optString.length() > HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                optString = optString.substring(0, HttpStatus.SC_INTERNAL_SERVER_ERROR);
            }
            String string2 = jSONObject.getString("_id");
            String string3 = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_NAME);
            String optString2 = jSONObject.optString("facebook_id", BuildConfig.FLAVOR);
            boolean optBoolean = jSONObject.optBoolean("discoverable", true);
            C3095y.m9471a("userId=" + string2);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("photos");
            Object arrayList = new ArrayList();
            if (optJSONArray2 != null) {
                m8902a(optJSONArray2, arrayList, string2);
            }
            ArrayList arrayList2 = new ArrayList();
            int i5 = jSONObject.getInt("gender_filter");
            if (i5 == -1) {
                arrayList2.add(Gender.MALE);
                arrayList2.add(Gender.FEMALE);
            } else if (i5 == 0) {
                arrayList2.add(Gender.MALE);
            } else {
                arrayList2.add(Gender.FEMALE);
            }
            int optInt = jSONObject.optInt("user_number", -1);
            String optString3 = jSONObject.optString("ping_time", BuildConfig.FLAVOR);
            boolean optBoolean2 = jSONObject.optBoolean("banned", false);
            User user = new User(optString, date, string2, string3, date2, i2, optString2, gender, arrayList2, arrayList, optString3, jSONObject.optBoolean("is_verified", false), jSONObject.optBoolean("is_super_like", false), jSONObject.optBoolean("is_brand", false));
            List f = m8907f(jSONObject);
            Pair a2 = m8899a(jSONObject, true);
            user.setCommonInterests(f);
            user.setNumConnections(((Integer) a2.first).intValue());
            user.setConnections((ConnectionsGroup) a2.second);
            m8901a(jSONObject.optJSONArray("purchases"));
            c2912a.f6116a = optInt;
            c2912a.f6120e = user;
            c2912a.f6117b = i2;
            c2912a.f6118c = i3;
            c2912a.f6119d = i4;
            c2912a.f6121f = optBoolean2;
            c2912a.f6122g = equals;
            c2912a.f6123h = z;
            c2912a.f6124i = optBoolean;
            ManagerApp.m7918i().m8769h(optBoolean);
        } catch (Throwable e) {
            C3095y.m9474a("Failed to parse birthday or ping time for rec", e);
        } catch (Throwable e2) {
            C3095y.m9474a("Failed to parse JSON for recs response", e2);
        } catch (Throwable e22) {
            C3095y.m9474a("Unknown exception in rec parsing", e22);
        }
        CharSequence optString4 = jSONObject.optString("instagram_disconnected");
        C3095y.m9471a("setInstagramDataSet UserParse.ParseMyProfile: expiredTime: [" + optString4 + "]");
        InstagramDataSet a3 = C2973b.m8912a(jSONObject);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.equals(optString4, "null")) {
            C3095y.m9471a("setInstagramDataSet UserParse.ParseMyProfile: token expired");
            a3.setTokenRevoked(true);
        } else if (ManagerApp.m7911b().m8142c() != null) {
            C3095y.m9471a("setInstagramDataSet UserParse.ParseMyProfile: token not expired");
            c2912a.f6120e.setInstagramDataSet(a3);
        }
        return c2912a;
    }

    public static void m8901a(@Nullable JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject.has("product_id") && C2925l.m8621a(jSONObject.getString("product_id"))) {
                        ManagerApp.m7914e().m8792B(true);
                        return;
                    }
                } catch (JSONException e) {
                    C3095y.m9479c(e.toString());
                }
            }
        }
    }

    public static void m8904c(@NonNull JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("is_traveling");
        User d = ManagerApp.m7922m().m8599d();
        if (d != null) {
            d.setRecAndPassporting(optBoolean);
        }
        if (optBoolean) {
            JSONArray optJSONArray = jSONObject.optJSONArray("travel_location_info");
            if (optJSONArray != null) {
                try {
                    TinderLocation c = C2980g.m8938c(optJSONArray.getJSONObject(0));
                    JSONObject jSONObject2 = jSONObject.getJSONObject("travel_pos");
                    if (jSONObject2 != null) {
                        C2980g.m8936a(c, jSONObject2);
                    }
                    ManagerApp.m7916g().m8513a(c);
                    return;
                } catch (Exception e) {
                    ManagerApp.m7916g().m8513a(null);
                    C3095y.m9479c(e.toString());
                    return;
                }
            }
            ManagerApp.m7916g().m8513a(null);
            return;
        }
        ManagerApp.m7916g().m8513a(null);
    }

    public static void m8902a(@NonNull JSONArray jSONArray, @NonNull List<PhotoUser> list, String str) throws Exception {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String string = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_ID);
            String optString = jSONObject.optString(NativeProtocol.WEB_DIALOG_URL);
            String optString2 = jSONObject.optString("fbId");
            JSONArray jSONArray2 = jSONObject.getJSONArray("processedFiles");
            List arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                jSONObject = jSONArray2.getJSONObject(i2);
                arrayList.add(new ProcessedPhoto(string, str, jSONObject.getString(NativeProtocol.WEB_DIALOG_URL), jSONObject.getInt("width"), jSONObject.getInt("height")));
            }
            PhotoUser photoUser = new PhotoUser(optString, string, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, arrayList);
            photoUser.setFacebookId(optString2);
            list.add(photoUser);
        }
    }

    @NonNull
    public static List<TinderReportNotification> m8905d(@NonNull JSONObject jSONObject) {
        C3095y.m9471a("parse notifications");
        List<TinderReportNotification> arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("notifications");
            if (optJSONArray != null) {
                C3095y.m9471a("has notifications");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    TinderReportNotification tinderReportNotification = new TinderReportNotification();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    CharSequence optString = jSONObject2.optString("type");
                    tinderReportNotification.setType(optString);
                    jSONObject2 = jSONObject2.optJSONObject("meta");
                    if (TextUtils.equals("warning", optString)) {
                        tinderReportNotification.setTier(jSONObject2.optInt("tier"));
                        List arrayList2 = new ArrayList();
                        JSONArray optJSONArray2 = jSONObject2.optJSONArray("reasons");
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                arrayList2.add(Integer.valueOf(optJSONArray2.getInt(i2)));
                            }
                        }
                        tinderReportNotification.setReasons(arrayList2);
                    }
                    C3095y.m9471a("found notification: " + tinderReportNotification.toString());
                    arrayList.add(tinderReportNotification);
                }
            }
        } catch (Exception e) {
            C3095y.m9479c(e.getMessage());
        }
        Collections.sort(arrayList, new C2971a());
        return arrayList;
    }

    @NonNull
    public static Pair<List<Interest>, List<Interest>> m8906e(@NonNull JSONObject jSONObject) throws JSONException {
        int i = 0;
        JSONArray optJSONArray = jSONObject.optJSONArray("common_interests");
        List arrayList = new ArrayList(optJSONArray == null ? 0 : optJSONArray.length());
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                arrayList.add(new Interest(jSONObject2.getString(ShareConstants.WEB_DIALOG_PARAM_ID), jSONObject2.getString(ShareConstants.WEB_DIALOG_PARAM_NAME)));
            }
        }
        optJSONArray = jSONObject.optJSONArray("uncommon_interests");
        List arrayList2 = new ArrayList(optJSONArray == null ? 0 : optJSONArray.length());
        if (optJSONArray != null) {
            while (i < optJSONArray.length()) {
                JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                arrayList2.add(new Interest(jSONObject3.getString(ShareConstants.WEB_DIALOG_PARAM_ID), jSONObject3.getString(ShareConstants.WEB_DIALOG_PARAM_NAME)));
                i++;
            }
        }
        return new Pair(arrayList, arrayList2);
    }

    @NonNull
    public static List<Interest> m8907f(@NonNull JSONObject jSONObject) throws JSONException {
        int i = 0;
        JSONArray optJSONArray = jSONObject.optJSONArray("interests");
        List<Interest> arrayList = new ArrayList(optJSONArray == null ? 0 : optJSONArray.length());
        if (optJSONArray != null) {
            while (i < optJSONArray.length()) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                arrayList.add(new Interest(jSONObject2.getString(ShareConstants.WEB_DIALOG_PARAM_ID), jSONObject2.getString(ShareConstants.WEB_DIALOG_PARAM_NAME)));
                i++;
            }
        }
        return arrayList;
    }

    @Nullable
    public static Pair<Integer, ConnectionsGroup> m8899a(@NonNull JSONObject jSONObject, boolean z) {
        int i = 0;
        if (z) {
            User d = ManagerApp.m7922m().m8599d();
            if (d != null) {
                i = d.getNumConnections();
            }
        }
        int optInt = jSONObject.optInt("connection_count", i);
        Object obj = null;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("common_connections");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_ID, null);
                    Object optString2 = optJSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_NAME, null);
                    int optInt2 = optJSONObject.optInt("degree", 1);
                    if (TextUtils.isEmpty(optString2)) {
                        arrayList2.add(new CommonConnection(optString, optInt2, null, null, null, null));
                    } else {
                        optJSONObject = optJSONObject.optJSONObject(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
                        String str = null;
                        String str2 = null;
                        String str3 = null;
                        if (optJSONObject != null) {
                            str = optJSONObject.optString("small", null);
                            str2 = optJSONObject.optString("medium", null);
                            str3 = optJSONObject.optString("large", null);
                        }
                        arrayList.add(new CommonConnection(optString, optInt2, optString2, str, str2, str3));
                    }
                }
            }
            obj = new ConnectionsGroup(arrayList, arrayList2);
        }
        return new Pair(Integer.valueOf(optInt), obj);
    }
}
