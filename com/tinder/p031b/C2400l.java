package com.tinder.p031b;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.util.Pair;
import com.tinder.enums.RateType;
import com.tinder.enums.SqlDataType;
import com.tinder.utils.C3095y;
import java.util.HashMap;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.b.l */
public class C2400l extends C2388c {

    /* renamed from: com.tinder.b.l.1 */
    static /* synthetic */ class C23991 {
        static final /* synthetic */ int[] f4284a;

        static {
            f4284a = new int[RateType.values().length];
            try {
                f4284a[RateType.LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4284a[RateType.SUPERLIKE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4284a[RateType.PASS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public C2400l() {
        this.a = "ratings_failed";
        this.b = new C2387a[]{new C2387a("rec_id", SqlDataType.TEXT, true), new C2387a("is_like", SqlDataType.BOOLEAN, false), new C2387a("is_superlike", SqlDataType.BOOLEAN, false)};
    }

    public static boolean m6557a(String str, RateType rateType) {
        C3095y.m9485e("recId=" + str);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("rec_id", str);
            switch (C23991.f4284a[rateType.ordinal()]) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    contentValues.put("is_like", Integer.valueOf(1));
                    contentValues.put("is_superlike", Integer.valueOf(0));
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    contentValues.put("is_like", Integer.valueOf(0));
                    contentValues.put("is_superlike", Integer.valueOf(1));
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    contentValues.put("is_like", Integer.valueOf(0));
                    contentValues.put("is_superlike", Integer.valueOf(0));
                    break;
            }
            C2405q.m6574a().m6583a("ratings_failed", contentValues);
            return true;
        } catch (Exception e) {
            C3095y.m9479c(e.getMessage() + e.toString());
            return false;
        }
    }

    @NonNull
    public HashMap<String, Pair<Boolean, Boolean>> m6559b() {
        HashMap<String, Pair<Boolean, Boolean>> hashMap = new HashMap();
        Cursor a = C2405q.m6574a().m6576a("ratings_failed");
        while (a.moveToNext()) {
            try {
                boolean z;
                String string = a.getString(0);
                Boolean valueOf = Boolean.valueOf(a.getInt(1) == 1);
                if (a.getInt(2) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                hashMap.put(string, new Pair(valueOf, Boolean.valueOf(z)));
            } finally {
                C2404p.m6572a(a);
            }
        }
        return hashMap;
    }

    public void m6558a(String str) {
        C3095y.m9471a("recId=" + str);
        C2405q.m6574a().m6581a("ratings_failed", "rec_id", str);
    }
}
