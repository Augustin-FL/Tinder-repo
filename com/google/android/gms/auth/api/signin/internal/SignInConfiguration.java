package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.EmailSignInConfig;
import com.google.android.gms.auth.api.signin.FacebookSignInConfig;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class SignInConfiguration implements SafeParcelable {
    public static final Creator<SignInConfiguration> CREATOR;
    final int versionCode;
    private final String zzRT;
    private String zzRU;
    private EmailSignInConfig zzRV;
    private GoogleSignInConfig zzRW;
    private FacebookSignInConfig zzRX;
    private String zzRY;

    static {
        CREATOR = new zze();
    }

    SignInConfiguration(int i, String str, String str2, EmailSignInConfig emailSignInConfig, GoogleSignInConfig googleSignInConfig, FacebookSignInConfig facebookSignInConfig, String str3) {
        this.versionCode = i;
        this.zzRT = zzx.zzcs(str);
        this.zzRU = str2;
        this.zzRV = emailSignInConfig;
        this.zzRW = googleSignInConfig;
        this.zzRX = facebookSignInConfig;
        this.zzRY = str3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public String zzlF() {
        return this.zzRT;
    }

    public String zzlG() {
        return this.zzRU;
    }

    public EmailSignInConfig zzlH() {
        return this.zzRV;
    }

    public GoogleSignInConfig zzlI() {
        return this.zzRW;
    }

    public FacebookSignInConfig zzlJ() {
        return this.zzRX;
    }

    public String zzlK() {
        return this.zzRY;
    }
}
