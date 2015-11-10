package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Patterns;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class EmailSignInConfig implements SafeParcelable {
    public static final Creator<EmailSignInConfig> CREATOR;
    final int versionCode;
    private final Uri zzRO;
    private String zzRP;
    private Uri zzRQ;

    static {
        CREATOR = new zza();
    }

    EmailSignInConfig(int i, Uri uri, String str, Uri uri2) {
        zzx.zzb((Object) uri, (Object) "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzh(uri.toString(), "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzb(Patterns.WEB_URL.matcher(uri.toString()).matches(), (Object) "Invalid server widget url");
        this.versionCode = i;
        this.zzRO = uri;
        this.zzRP = str;
        this.zzRQ = uri2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public Uri zzlA() {
        return this.zzRO;
    }

    public Uri zzlB() {
        return this.zzRQ;
    }

    public String zzlC() {
        return this.zzRP;
    }
}
