package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class CredentialRequest implements SafeParcelable {
    public static final Creator<CredentialRequest> CREATOR;
    final int mVersionCode;
    private final boolean zzRj;
    private final String[] zzRk;
    private final CredentialPickerConfig zzRl;
    private final CredentialPickerConfig zzRm;

    public static final class Builder {
        private boolean zzRj;
        private String[] zzRk;
        private CredentialPickerConfig zzRl;
        private CredentialPickerConfig zzRm;

        public CredentialRequest build() {
            if (this.zzRk == null) {
                this.zzRk = new String[0];
            }
            if (this.zzRj || this.zzRk.length != 0) {
                return new CredentialRequest();
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        public Builder setAccountTypes(String... strArr) {
            this.zzRk = strArr;
            return this;
        }

        public Builder setCredentialHintPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzRm = credentialPickerConfig;
            return this;
        }

        public Builder setCredentialPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzRl = credentialPickerConfig;
            return this;
        }

        public Builder setSupportsPasswordLogin(boolean z) {
            this.zzRj = z;
            return this;
        }
    }

    static {
        CREATOR = new zzc();
    }

    CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2) {
        this.mVersionCode = i;
        this.zzRj = z;
        this.zzRk = (String[]) zzx.zzv(strArr);
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.zzRl = credentialPickerConfig;
        if (credentialPickerConfig2 == null) {
            credentialPickerConfig2 = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.zzRm = credentialPickerConfig2;
    }

    private CredentialRequest(Builder builder) {
        this(2, builder.zzRj, builder.zzRk, builder.zzRl, builder.zzRm);
    }

    public int describeContents() {
        return 0;
    }

    public String[] getAccountTypes() {
        return this.zzRk;
    }

    public CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.zzRm;
    }

    public CredentialPickerConfig getCredentialPickerConfig() {
        return this.zzRl;
    }

    public boolean getSupportsPasswordLogin() {
        return this.zzRj;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
