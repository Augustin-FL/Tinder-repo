package com.tinder.iap.util;

import android.support.annotation.NonNull;
import com.facebook.share.internal.ShareConstants;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tinder.iap.util.g */
public class C2770g {
    final String f5560a;
    final String f5561b;
    final String f5562c;
    final String f5563d;
    final String f5564e;
    final String f5565f;
    final String f5566g;
    final String f5567h;
    final long f5568i;
    private List<String> f5569j;

    public C2770g(String str, String str2) throws JSONException {
        this.f5560a = str;
        this.f5566g = str2;
        JSONObject jSONObject = new JSONObject(this.f5566g);
        this.f5561b = jSONObject.optString("productId");
        this.f5562c = jSONObject.optString("type");
        this.f5563d = jSONObject.optString("price");
        this.f5564e = jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_TITLE);
        this.f5565f = jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_DESCRIPTION);
        this.f5568i = jSONObject.optLong("price_amount_micros");
        this.f5567h = jSONObject.optString("price_currency_code");
    }

    public String m7886a() {
        return this.f5567h;
    }

    public String m7888b() {
        return this.f5561b;
    }

    public long m7889c() {
        return this.f5568i;
    }

    public float m7890d() {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);
        decimalFormat.applyPattern("#.00");
        decimalFormat.setGroupingUsed(false);
        return Float.valueOf(decimalFormat.format((double) (((float) this.f5568i) / 1000000.0f))).floatValue();
    }

    public List<String> m7891e() {
        return this.f5569j;
    }

    public void m7887a(List<String> list) {
        this.f5569j = list;
    }

    @NonNull
    public String toString() {
        return "SkuDetails:" + this.f5566g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2770g c2770g = (C2770g) obj;
        if (this.f5568i != c2770g.f5568i) {
            return false;
        }
        if (this.f5561b == null ? c2770g.f5561b != null : !this.f5561b.equals(c2770g.f5561b)) {
            return false;
        }
        if (this.f5567h != null) {
            if (this.f5567h.equals(c2770g.f5567h)) {
                return true;
            }
        } else if (c2770g.f5567h == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f5561b != null) {
            hashCode = this.f5561b.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode *= 31;
        if (this.f5567h != null) {
            i = this.f5567h.hashCode();
        }
        return ((hashCode + i) * 31) + ((int) (this.f5568i ^ (this.f5568i >>> 32)));
    }
}
