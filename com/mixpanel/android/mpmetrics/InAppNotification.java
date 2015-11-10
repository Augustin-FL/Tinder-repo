package com.mixpanel.android.mpmetrics;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppNotification implements Parcelable {
    public static final Creator<InAppNotification> CREATOR;
    private static final Pattern f2736k;
    private Bitmap f2737a;
    private final JSONObject f2738b;
    private final int f2739c;
    private final int f2740d;
    private final String f2741e;
    private final String f2742f;
    private final String f2743g;
    private final String f2744h;
    private final String f2745i;
    private final String f2746j;

    /* renamed from: com.mixpanel.android.mpmetrics.InAppNotification.1 */
    static class C19971 implements Creator<InAppNotification> {
        C19971() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m4598a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m4599a(i);
        }

        public InAppNotification m4598a(Parcel parcel) {
            return new InAppNotification(parcel);
        }

        public InAppNotification[] m4599a(int i) {
            return new InAppNotification[i];
        }
    }

    public enum Type {
        UNKNOWN {
            public String toString() {
                return "*unknown_type*";
            }
        },
        MINI {
            public String toString() {
                return "mini";
            }
        },
        TAKEOVER {
            public String toString() {
                return "takeover";
            }
        };
    }

    public InAppNotification(Parcel parcel) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject(parcel.readString());
        } catch (JSONException e) {
            Log.e("MixpanelAPI InAppNotification", "Error reading JSON when creating InAppNotification from Parcel");
            jSONObject = jSONObject2;
        }
        this.f2738b = jSONObject;
        this.f2739c = parcel.readInt();
        this.f2740d = parcel.readInt();
        this.f2741e = parcel.readString();
        this.f2742f = parcel.readString();
        this.f2743g = parcel.readString();
        this.f2744h = parcel.readString();
        this.f2745i = parcel.readString();
        this.f2746j = parcel.readString();
        this.f2737a = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
    }

    InAppNotification(JSONObject jSONObject) throws BadDecideObjectException {
        try {
            this.f2738b = jSONObject;
            this.f2739c = jSONObject.getInt(ShareConstants.WEB_DIALOG_PARAM_ID);
            this.f2740d = jSONObject.getInt("message_id");
            this.f2741e = jSONObject.getString("type");
            this.f2742f = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_TITLE);
            this.f2743g = jSONObject.getString("body");
            this.f2744h = jSONObject.getString("image_url");
            this.f2737a = Bitmap.createBitmap(HttpStatus.SC_INTERNAL_SERVER_ERROR, HttpStatus.SC_INTERNAL_SERVER_ERROR, Config.ARGB_8888);
            this.f2745i = jSONObject.getString("cta");
            this.f2746j = jSONObject.getString("cta_url");
        } catch (Throwable e) {
            throw new BadDecideObjectException("Notification JSON was unexpected or bad", e);
        }
    }

    JSONObject m4601a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("campaign_id", m4603b());
            jSONObject.put("message_id", m4604c());
            jSONObject.put("message_type", "inapp");
            jSONObject.put("message_subtype", this.f2741e);
        } catch (Throwable e) {
            Log.e("MixpanelAPI InAppNotification", "Impossible JSON Exception", e);
        }
        return jSONObject;
    }

    public int m4603b() {
        return this.f2739c;
    }

    public int m4604c() {
        return this.f2740d;
    }

    public Type m4605d() {
        if (Type.MINI.toString().equals(this.f2741e)) {
            return Type.MINI;
        }
        if (Type.TAKEOVER.toString().equals(this.f2741e)) {
            return Type.TAKEOVER;
        }
        return Type.UNKNOWN;
    }

    public String m4606e() {
        return this.f2742f;
    }

    public String m4607f() {
        return this.f2743g;
    }

    public String m4608g() {
        return m4600a(this.f2744h, "@2x");
    }

    public String m4609h() {
        return m4600a(this.f2744h, "@4x");
    }

    public String m4610i() {
        return this.f2745i;
    }

    public String m4611j() {
        return this.f2746j;
    }

    void m4602a(Bitmap bitmap) {
        this.f2737a = bitmap;
    }

    public Bitmap m4612k() {
        return this.f2737a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2738b.toString());
        parcel.writeInt(this.f2739c);
        parcel.writeInt(this.f2740d);
        parcel.writeString(this.f2741e);
        parcel.writeString(this.f2742f);
        parcel.writeString(this.f2743g);
        parcel.writeString(this.f2744h);
        parcel.writeString(this.f2745i);
        parcel.writeString(this.f2746j);
        parcel.writeParcelable(this.f2737a, i);
    }

    static {
        CREATOR = new C19971();
        f2736k = Pattern.compile("(\\.[^./]+$)");
    }

    static String m4600a(String str, String str2) {
        Matcher matcher = f2736k.matcher(str);
        if (matcher.find()) {
            return matcher.replaceFirst(str2 + "$1");
        }
        return str;
    }
}
