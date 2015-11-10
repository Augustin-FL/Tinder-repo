package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage implements SafeParcelable {
    public static final Creator<WebImage> CREATOR;
    private final int mVersionCode;
    private final Uri zzacb;
    private final int zznP;
    private final int zznQ;

    static {
        CREATOR = new zzb();
    }

    WebImage(int i, Uri uri, int i2, int i3) {
        this.mVersionCode = i;
        this.zzacb = uri;
        this.zznP = i2;
        this.zznQ = i3;
    }

    public WebImage(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int i, int i2) throws IllegalArgumentException {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject jSONObject) throws IllegalArgumentException {
        this(zzi(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    private static Uri zzi(JSONObject jSONObject) {
        Uri uri = null;
        if (jSONObject.has(NativeProtocol.WEB_DIALOG_URL)) {
            try {
                uri = Uri.parse(jSONObject.getString(NativeProtocol.WEB_DIALOG_URL));
            } catch (JSONException e) {
            }
        }
        return uri;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return zzw.equal(this.zzacb, webImage.zzacb) && this.zznP == webImage.zznP && this.zznQ == webImage.zznQ;
    }

    public int getHeight() {
        return this.zznQ;
    }

    public Uri getUrl() {
        return this.zzacb;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int getWidth() {
        return this.zznP;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzacb, Integer.valueOf(this.zznP), Integer.valueOf(this.zznQ));
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NativeProtocol.WEB_DIALOG_URL, this.zzacb.toString());
            jSONObject.put("width", this.zznP);
            jSONObject.put("height", this.zznQ);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.zznP), Integer.valueOf(this.zznQ), this.zzacb.toString()});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
