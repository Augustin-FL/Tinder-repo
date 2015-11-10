package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;
import org.apache.http.HttpHost;

public class Credential implements SafeParcelable {
    public static final Creator<Credential> CREATOR;
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
    private final String mName;
    final int mVersionCode;
    private final String zzRa;
    private final String zzRb;
    private final Uri zzRc;
    private final List<IdToken> zzRd;
    private final String zzRe;
    private final String zzRf;
    private final String zzRg;
    private final String zzRh;
    private final String zzwj;

    public static class Builder {
        private String mName;
        private String zzRa;
        private String zzRb;
        private Uri zzRc;
        private List<IdToken> zzRd;
        private String zzRe;
        private String zzRf;
        private String zzRg;
        private String zzRh;
        private final String zzwj;

        public Builder(Credential credential) {
            this.zzwj = credential.zzwj;
            this.mName = credential.mName;
            this.zzRc = credential.zzRc;
            this.zzRd = credential.zzRd;
            this.zzRe = credential.zzRe;
            this.zzRf = credential.zzRf;
            this.zzRg = credential.zzRg;
            this.zzRa = credential.zzRa;
            this.zzRb = credential.zzRb;
            this.zzRh = credential.zzRh;
        }

        public Builder(String str) {
            this.zzwj = str;
        }

        public Credential build() {
            if (TextUtils.isEmpty(this.zzRe) || TextUtils.isEmpty(this.zzRf)) {
                return new Credential(2, this.zzRa, this.zzRb, this.zzwj, this.mName, this.zzRc, this.zzRd, this.zzRe, this.zzRf, this.zzRg, this.zzRh);
            }
            throw new IllegalStateException("Only one of password or accountType may be set");
        }

        public Builder setAccountType(String str) {
            String scheme = Uri.parse(str).getScheme();
            boolean z = HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
            zzx.zzZ(z);
            this.zzRf = str;
            return this;
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setPassword(String str) {
            this.zzRe = str;
            return this;
        }

        public Builder setProfilePictureUri(Uri uri) {
            this.zzRc = uri;
            return this;
        }
    }

    static {
        CREATOR = new zza();
    }

    Credential(int i, String str, String str2, String str3, String str4, Uri uri, List<IdToken> list, String str5, String str6, String str7, String str8) {
        this.mVersionCode = i;
        this.zzRa = str;
        this.zzRb = str2;
        this.zzwj = (String) zzx.zzv(str3);
        this.mName = str4;
        this.zzRc = uri;
        this.zzRd = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzRe = str5;
        this.zzRf = str6;
        this.zzRg = str7;
        this.zzRh = str8;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.zzwj, credential.zzwj) && TextUtils.equals(this.mName, credential.mName) && zzw.equal(this.zzRc, credential.zzRc) && TextUtils.equals(this.zzRe, credential.zzRe) && TextUtils.equals(this.zzRf, credential.zzRf) && TextUtils.equals(this.zzRg, credential.zzRg);
    }

    public String getAccountType() {
        return this.zzRf;
    }

    public String getGeneratedPassword() {
        return this.zzRg;
    }

    public String getId() {
        return this.zzwj;
    }

    public String getName() {
        return this.mName;
    }

    public String getPassword() {
        return this.zzRe;
    }

    public Uri getProfilePictureUri() {
        return this.zzRc;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzwj, this.mName, this.zzRc, this.zzRe, this.zzRf, this.zzRg);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzlr() {
        return this.zzRa;
    }

    public String zzls() {
        return this.zzRb;
    }

    public List<IdToken> zzlt() {
        return this.zzRd;
    }

    public String zzlu() {
        return this.zzRh;
    }
}
