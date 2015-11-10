package com.tinder.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mixpanel.android.mpmetrics.C2042h;
import com.tinder.managers.ManagerApp;
import com.tinder.utils.C3095y;
import org.json.JSONException;
import org.json.JSONObject;

public class MixpanelUtils {
    private static final String TOKEN = "99c8f3b33cbfcd9fa176ab13adf58fd4";
    private static String[] sEventsToFilter;
    private static Gson sGson;
    private static C2042h sMixpanelAPI;

    static {
        sGson = new GsonBuilder().serializeNulls().create();
        sEventsToFilter = new String[]{"Device"};
    }

    private static boolean isEventIgnored(@NonNull String str) {
        for (Object equals : sEventsToFilter) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static void trackFromSparksEvent(@NonNull SparksEvent sparksEvent) {
        if (!isEventIgnored(sparksEvent.getName()) && sMixpanelAPI != null && sGson != null) {
            try {
                JSONObject jSONObject = new JSONObject(sGson.toJson(sparksEvent.getParams()));
                jSONObject.remove("appVersion");
                jSONObject.remove("ts");
                jSONObject.remove("deviceId");
                sMixpanelAPI.m4786a(sparksEvent.getName(), jSONObject);
            } catch (JSONException e) {
                C3095y.m9479c(e.toString());
            }
        }
    }

    public static void start() {
        sMixpanelAPI = C2042h.m4769a(ManagerApp.m7917h(), TOKEN);
    }

    public static void flushMixpanel() {
        sMixpanelAPI.m4784a();
    }

    public static void setMixpanelForUser(@Nullable User user) {
        if (user != null) {
            sMixpanelAPI.m4785a(user.getId());
        }
    }
}
