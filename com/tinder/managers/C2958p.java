package com.tinder.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.stetho.BuildConfig;
import com.tinder.enums.Environment;
import com.tinder.model.GlobalConfig;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3095y;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* renamed from: com.tinder.managers.p */
public class C2958p {
    private static SharedPreferences f6268a;
    private static Editor f6269b;

    public C2958p(@NonNull Context context) {
        f6268a = context.getSharedPreferences("SP", 0);
        f6269b = f6268a.edit();
    }

    public static void m8779a() {
        String string = f6268a.getString("ENVIRONMENT", Environment.PROD.name());
        f6269b.clear();
        f6269b.putString("ENVIRONMENT", string);
        f6269b.commit();
    }

    public static void m8780a(boolean z) {
        f6269b.putBoolean("FETCH_CONNECTIONS", z);
        f6269b.commit();
    }

    public static void m8781b(boolean z) {
        f6269b.putBoolean("ADD_FEEDBACK_TO_MENU", z).commit();
    }

    public static boolean m8782b() {
        return f6268a.getBoolean("ADD_FEEDBACK_TO_MENU", false);
    }

    public static void m8783c(boolean z) {
        f6269b.putBoolean("ADD_RATE_TO_MENU", z).commit();
    }

    public static boolean m8784c() {
        return f6268a.getBoolean("ADD_RATE_TO_MENU", false);
    }

    public static void m8785d(boolean z) {
        f6269b.putBoolean("HAS_RATED", z).commit();
    }

    public static boolean m8786d() {
        return f6268a.getBoolean("HAS_RATED", false);
    }

    public static void m8787e(boolean z) {
        f6269b.putBoolean("HAS_SENT_FEEDBACK", z).commit();
    }

    public static boolean m8788e() {
        return f6268a.getBoolean("HAS_SENT_FEEDBACK", false);
    }

    public static boolean m8789f() {
        return f6268a.getBoolean("VERSION_IS_RATEABLE", true);
    }

    public void m8827a(@NonNull Environment environment) {
        f6269b.putString("ENVIRONMENT", environment.name());
        f6269b.commit();
    }

    public void m8843g() {
        f6269b.putInt("SWIPE_COUNTER", m8849i() + 1);
        f6269b.commit();
    }

    public void m8846h() {
        f6269b.putInt("SWIPE_COUNTER", 0);
        f6269b.commit();
    }

    public int m8849i() {
        return f6268a.getInt("SWIPE_COUNTER", 0);
    }

    public void m8842f(boolean z) {
        f6269b.putBoolean("KEY WAS IN SMALLER TEXT MODE", z);
        f6269b.commit();
    }

    public boolean m8854j() {
        return f6268a.getBoolean("KEY WAS IN SMALLER TEXT MODE", false);
    }

    @Nullable
    public String m8855k() {
        return f6268a.getString("MOMENT LIKES LAST ACTIVITY DATE", BuildConfig.FLAVOR);
    }

    @Nullable
    public String m8857l() {
        return f6268a.getString("ACCOUNT CREATED DATE", BuildConfig.FLAVOR);
    }

    public void m8828a(String str) {
        f6269b.putString("ACCOUNT CREATED DATE", str);
        f6269b.commit();
    }

    public boolean m8845g(boolean z) {
        return f6268a.getBoolean("HAVE LOADED MOCK MOMENTS", z);
    }

    public void m8848h(boolean z) {
        f6269b.putBoolean("HAVE LOADED MOCK MOMENTS", z);
        f6269b.commit();
    }

    @NonNull
    public List<String> m8859m() {
        List asList = Arrays.asList(TextUtils.split(f6268a.getString("MOCK MOMENTS URLS", BuildConfig.FLAVOR), ","));
        List<String> arrayList = new ArrayList();
        for (int i = 0; i < asList.size(); i++) {
            arrayList.add(asList.get(i));
        }
        return arrayList;
    }

    public void m8829a(@NonNull List<String> list) {
        f6269b.putString("MOCK MOMENTS URLS", TextUtils.join(",", list));
        f6269b.commit();
    }

    public int m8861n() {
        return f6268a.getInt("MOMENT LIKES UNSEEN", 0);
    }

    public void m8825a(int i) {
        f6269b.putInt("MOMENT LIKES UNSEEN", i);
        f6269b.commit();
    }

    public long m8863o() {
        return f6268a.getLong("DATE_LAST_LIKE_SEEN", 0);
    }

    public void m8826a(long j) {
        f6269b.putLong("DATE_LAST_LIKE_SEEN", j);
        f6269b.commit();
    }

    public boolean m8866p() {
        return f6268a.getBoolean("SPARKS ENABLED", true);
    }

    public void m8851i(boolean z) {
        f6269b.putBoolean("SPARKS ENABLED", z);
        f6269b.commit();
    }

    public boolean m8868q() {
        return f6268a.getBoolean("KEY_NEW_MATCH_PUSH_ENABLED", true);
    }

    public void m8853j(boolean z) {
        f6269b.putBoolean("KEY_NEW_MATCH_PUSH_ENABLED", z);
        f6269b.commit();
    }

    public boolean m8870r() {
        return f6268a.getBoolean("KEY_NEW_MESSAGE_PUSH_ENABLED", true);
    }

    public void m8856k(boolean z) {
        f6269b.putBoolean("KEY_NEW_MESSAGE_PUSH_ENABLED", z);
        f6269b.commit();
    }

    public boolean m8872s() {
        return f6268a.getBoolean("KEY_NEW_MOMENT_LIKE_PUSH_ENABLED", true);
    }

    public void m8858l(boolean z) {
        f6269b.putBoolean("KEY_NEW_MOMENT_LIKE_PUSH_ENABLED", z);
        f6269b.commit();
    }

    public boolean m8874t() {
        return f6268a.getBoolean("KEY_FRIEND_REQUEST_PUSH_ENABLED", true);
    }

    public boolean m8876u() {
        SharedPreferences sharedPreferences = f6268a;
        String str = "PREFERS MILES";
        boolean z = Locale.US.equals(Locale.getDefault()) || Locale.UK.equals(Locale.getDefault());
        return sharedPreferences.getBoolean(str, z);
    }

    public void m8860m(boolean z) {
        f6269b.putBoolean("PREFERS MILES", z);
        f6269b.commit();
    }

    public int m8877v() {
        return f6268a.getInt("USER NUMBER", -1);
    }

    public void m8831b(int i) {
        f6269b.putInt("USER NUMBER", i);
        f6269b.commit();
    }

    public boolean m8880w() {
        return f6268a.getBoolean("DISCOVER ENABLED", true);
    }

    public void m8862n(boolean z) {
        f6269b.putBoolean("DISCOVER ENABLED", z);
        f6269b.commit();
    }

    public boolean m8882x() {
        return f6268a.getBoolean("NOTIFICATION_VIEWED_TAPPING_HEART", false);
    }

    public void m8883y() {
        f6269b.putBoolean("NOTIFICATION_VIEWED_TAPPING_HEART", true);
        f6269b.commit();
    }

    public boolean m8886z() {
        return f6268a.getBoolean("KEY_NOTIFICATION_VIEWED_DRAGGING_LEFT", false);
    }

    public void m8790A() {
        f6269b.putBoolean("KEY_NOTIFICATION_VIEWED_DRAGGING_LEFT", true);
        f6269b.commit();
    }

    public boolean m8793B() {
        return f6268a.getBoolean("KEY_NOTIFICATION_VIEWED_DRAGGING_RIGHT", false);
    }

    public void m8794C() {
        f6269b.putBoolean("KEY_NOTIFICATION_VIEWED_DRAGGING_RIGHT", true);
        f6269b.commit();
    }

    public boolean m8797D() {
        return f6268a.getBoolean("NOTIFICATION_VIEWED_TAPPING_X", false);
    }

    public void m8798E() {
        f6269b.putBoolean("NOTIFICATION_VIEWED_TAPPING_X", true);
        f6269b.commit();
    }

    public boolean m8801F() {
        return f6268a.getBoolean("KEY_SUPERLIKE_FEATURE_SHOWN", true);
    }

    public void m8864o(boolean z) {
        f6269b.putBoolean("KEY_SUPERLIKE_FEATURE_SHOWN", z);
        f6269b.commit();
    }

    public boolean m8803G() {
        return f6268a.getBoolean("KEY_SUPERLIKE_REMINDER_SHOWN", true);
    }

    public void m8865p(boolean z) {
        f6269b.putBoolean("KEY_SUPERLIKE_REMINDER_SHOWN", z);
        f6269b.commit();
    }

    public void m8833b(String str) {
        f6269b.putString("APP VERSION NUM", str);
        f6269b.commit();
    }

    public boolean m8804H() {
        return f6268a.getBoolean("REGISTERED TINDER PUSH", false);
    }

    public void m8867q(boolean z) {
        f6269b.putBoolean("REGISTERED TINDER PUSH", z);
        f6269b.commit();
    }

    public void m8823a(double d) {
        f6269b.putString("LATITUDE", String.valueOf(d));
        f6269b.commit();
    }

    public double m8805I() {
        double d = -100000.0d;
        Object string = f6268a.getString("LATITUDE", BuildConfig.FLAVOR);
        if (!TextUtils.isEmpty(string)) {
            try {
                d = Double.parseDouble(string);
            } catch (Throwable e) {
                C3095y.m9474a("Failed to parse saved latitude", e);
            }
        }
        return d;
    }

    public void m8830b(double d) {
        f6269b.putString("LONGITUDE", String.valueOf(d));
        f6269b.commit();
    }

    public double m8806J() {
        double d = -100000.0d;
        Object string = f6268a.getString("LONGITUDE", BuildConfig.FLAVOR);
        if (!TextUtils.isEmpty(string)) {
            try {
                d = Double.parseDouble(string);
            } catch (Throwable e) {
                C3095y.m9474a("Failed to parse saved longitude", e);
            }
        }
        return d;
    }

    public void m8869r(boolean z) {
        f6269b.putBoolean("SETTINGS_CHANGED", z);
        f6269b.commit();
    }

    public boolean m8807K() {
        return f6268a.getBoolean("SETTINGS_CHANGED", false);
    }

    public void m8871s(boolean z) {
        f6269b.putBoolean("PASSPORT_PREFS_CHANGED", z);
        f6269b.commit();
    }

    public boolean m8808L() {
        return f6268a.getBoolean("PASSPORT_PREFS_CHANGED", false);
    }

    public void m8873t(boolean z) {
        f6269b.putBoolean("SETTINGS_IS_PUSH_ON", z);
        f6269b.commit();
    }

    public boolean m8809M() {
        return f6268a.getBoolean("SETTINGS_IS_PUSH_ON", true);
    }

    public void m8875u(boolean z) {
        f6269b.putBoolean("HAS_VIEWED_INTRO", z);
        f6269b.commit();
    }

    public int m8810N() {
        return f6268a.getInt("AGE_MIN", 18);
    }

    public void m8834c(int i) {
        f6269b.putInt("AGE_MIN", i);
        f6269b.commit();
    }

    public int m8811O() {
        return f6268a.getInt("AGE_MAX", 55);
    }

    public void m8836d(int i) {
        f6269b.putInt("AGE_MAX", i);
        f6269b.commit();
    }

    public float m8812P() {
        float f;
        try {
            f = f6268a.getFloat("DISTANCE", 50.0f);
            C3095y.m9471a("distance=" + f);
            return f;
        } catch (Exception e) {
            C3095y.m9476b("exception=" + e);
            f = (float) f6268a.getInt("DISTANCE", 50);
            C3095y.m9471a("distance=" + f);
            return f;
        }
    }

    public void m8824a(float f) {
        C3095y.m9471a("distance=" + f);
        f6269b.putFloat("DISTANCE", f);
        f6269b.commit();
    }

    public boolean m8813Q() {
        boolean z = f6268a.getBoolean("ARE_FEMALES_LIKED", false);
        C3095y.m9471a("areFemalesLiked=" + z);
        return z;
    }

    public void m8878v(boolean z) {
        C3095y.m9471a("areFemalesLiked=" + z);
        f6269b.putBoolean("ARE_FEMALES_LIKED", z);
        f6269b.commit();
    }

    public boolean m8814R() {
        return f6268a.getBoolean("ARE_MALES_LIKED", false);
    }

    public void m8879w(boolean z) {
        f6269b.putBoolean("ARE_MALES_LIKED", z);
        f6269b.commit();
    }

    @Nullable
    public Date m8815S() {
        try {
            long j = f6268a.getLong("LAST_ACTIVITY_DATE", -1);
            if (j > 0) {
                return new Date(j);
            }
        } catch (Throwable e) {
            Throwable th = e;
            String string = f6268a.getString("LAST_ACTIVITY_DATE", null);
            if (string != null) {
                Date parse;
                try {
                    parse = C3070i.m9366a().parse(string);
                    try {
                        f6268a.edit().putLong("LAST_ACTIVITY_DATE", parse.getTime()).commit();
                        return parse;
                    } catch (ParseException e2) {
                        C3095y.m9474a("Failed to parse old last activity date for migration", th);
                        f6268a.edit().remove("LAST_ACTIVITY_DATE").commit();
                        return parse;
                    }
                } catch (ParseException e3) {
                    parse = null;
                    C3095y.m9474a("Failed to parse old last activity date for migration", th);
                    f6268a.edit().remove("LAST_ACTIVITY_DATE").commit();
                    return parse;
                }
            }
        }
        return null;
    }

    public void m8816T() {
        f6269b.remove("LAST_ACTIVITY_DATE").commit();
    }

    public void m8832b(long j) {
        f6269b.putLong("LAST_ACTIVITY_DATE", j).commit();
    }

    @Nullable
    public String m8817U() {
        return f6268a.getString("LAST_ACTIVITY_DATE_FEED_MOMENTS", BuildConfig.FLAVOR);
    }

    public void m8835c(String str) {
        f6269b.putString("LAST_ACTIVITY_DATE_FEED_MOMENTS", str);
        f6269b.commit();
    }

    @Nullable
    public String m8818V() {
        return f6268a.getString("LAST_ACTIVITY_DATE_FEED_MOMENTS", BuildConfig.FLAVOR);
    }

    public void m8837d(String str) {
        f6269b.putString("LAST_ACTIVITY_DATE_FEED_MOMENTS", str);
        f6269b.commit();
    }

    @Nullable
    public String m8819W() {
        return f6268a.getString("LAST_MOMENT_ID_FEED_LIKES", BuildConfig.FLAVOR);
    }

    @Nullable
    public String m8820X() {
        return f6268a.getString("LAST_MOMENT_ID", BuildConfig.FLAVOR);
    }

    public void m8839e(String str) {
        f6269b.putString("LAST_MOMENT_ID", str);
        f6269b.commit();
    }

    @Nullable
    public String m8821Y() {
        return f6268a.getString("LAST_MOMENT_ID_MY_MOMENTS", BuildConfig.FLAVOR);
    }

    public void m8841f(String str) {
        f6269b.putString("LAST_MOMENT_ID_MY_MOMENTS", str);
        f6269b.commit();
    }

    @Nullable
    public String m8822Z() {
        return f6268a.getString("MY_LAST_MOMENT_ID", BuildConfig.FLAVOR);
    }

    public void m8844g(String str) {
        f6269b.putString("MY_LAST_MOMENT_ID", str);
        f6269b.commit();
    }

    @Nullable
    public String aa() {
        return f6268a.getString("TOKEN_TINDER", null);
    }

    public void m8847h(String str) {
        f6269b.putString("TOKEN_TINDER", str);
        f6269b.commit();
    }

    public int ab() {
        return f6268a.getInt("REC_SIZE", 40);
    }

    public int ac() {
        return f6268a.getInt("RECS_INTERVAL", GlobalConfig.DEFAULT_UPDATES_INTERVAL);
    }

    public void m8838e(int i) {
        C3095y.m9471a("recsInterval=" + i);
        f6269b.putInt("RECS_INTERVAL", i);
        f6269b.commit();
    }

    public int ad() {
        return f6268a.getInt("UPDATES_INTERVAL", GlobalConfig.DEFAULT_UPDATES_INTERVAL);
    }

    public void m8840f(int i) {
        C3095y.m9471a("updatesInterval=" + i);
        f6269b.putInt("UPDATES_INTERVAL", i);
        f6269b.commit();
    }

    @Nullable
    public String ae() {
        return f6268a.getString("USER_ID", null);
    }

    public void m8850i(String str) {
        f6269b.putString("USER_ID", str);
        f6269b.commit();
    }

    public boolean af() {
        return f6268a.getBoolean("IS_FIRST_LOAD", true);
    }

    public void m8881x(boolean z) {
        f6269b.putBoolean("IS_FIRST_LOAD", z);
        f6269b.commit();
    }

    public boolean ag() {
        return f6268a.getBoolean("IS_LOGGED_IN", false);
    }

    public void m8884y(boolean z) {
        f6269b.putBoolean("IS_LOGGED_IN", z);
        f6269b.commit();
    }

    public void m8885z(boolean z) {
        f6269b.putBoolean("HAS_BEEN_ASKED_FOR_PHOTO_PERMISSION", z);
        f6269b.commit();
    }

    @Nullable
    public String ah() {
        return f6268a.getString("TINDER ID", BuildConfig.FLAVOR);
    }

    public boolean ai() {
        return f6268a.getBoolean("HAS_SEEN_DIALOG_FIRST_MOMENT", false);
    }

    public void m8791A(boolean z) {
        f6269b.putBoolean("HAS_SEEN_DIALOG_FIRST_MOMENT", z);
        f6269b.commit();
    }

    public static boolean aj() {
        return f6268a.getBoolean("KEY_HAS_PLUS_SUBSCRIPTION_ENABLED", false);
    }

    public void m8792B(boolean z) {
        C3095y.m9471a("set plus subscription enabled: " + z);
        f6269b.putBoolean("KEY_HAS_PLUS_SUBSCRIPTION_ENABLED", z);
        f6269b.commit();
    }

    public boolean ak() {
        return f6268a.getBoolean("FB_ANALYTICS_ENABLED", Boolean.TRUE.booleanValue());
    }

    public boolean al() {
        return f6268a.getBoolean("MIXPANEL_ENABLED", true);
    }

    public void m8795C(boolean z) {
        f6269b.putBoolean("MIXPANEL_ENABLED", z);
        f6269b.commit();
    }

    public void m8796D(boolean z) {
        f6269b.putBoolean("KEY_TINDER_PLUS_ENABLED", z);
        f6269b.commit();
    }

    public boolean am() {
        return f6268a.getBoolean("KEY_TINDER_PLUS_ENABLED", false);
    }

    public boolean an() {
        return C2958p.aj() || am();
    }

    public boolean ao() {
        return f6268a.getBoolean("HAS_VIEWED_ROADBLOCK", false);
    }

    public void m8799E(boolean z) {
        f6269b.putBoolean("HAS_VIEWED_ROADBLOCK", z);
        f6269b.commit();
    }

    @Nullable
    public String ap() {
        return f6268a.getString("INSTAGRAM_USERNAME", BuildConfig.FLAVOR);
    }

    public void m8852j(String str) {
        f6269b.putString("INSTAGRAM_USERNAME", str);
        f6269b.commit();
    }

    public boolean aq() {
        return f6268a.getBoolean("INSTAGRAM_EXPIRED_SEEN", true);
    }

    public void m8800F(boolean z) {
        f6269b.putBoolean("INSTAGRAM_EXPIRED_SEEN", z);
        f6269b.commit();
    }

    public boolean ar() {
        return f6268a.getBoolean("FETCH_CONNECTIONS", true);
    }

    public boolean as() {
        return f6268a.getBoolean("KEY_SUPERLIKE_ENABLED", false);
    }

    public boolean at() {
        return as() && an();
    }

    public void m8802G(boolean z) {
        f6269b.putBoolean("KEY_SUPERLIKE_ENABLED", z);
        f6269b.commit();
    }

    public static boolean au() {
        return f6268a.getBoolean("KEY_SUPERLIKE_PUSH_ENABLED", true);
    }

    public static void m8778H(boolean z) {
        f6269b.putBoolean("KEY_SUPERLIKE_PUSH_ENABLED", z).commit();
    }
}
