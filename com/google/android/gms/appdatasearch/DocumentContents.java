package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class DocumentContents implements SafeParcelable {
    public static final zzb CREATOR;
    public final Account account;
    final int mVersionCode;
    final DocumentSection[] zzOS;
    public final String zzOT;
    public final boolean zzOU;

    public static class zza {
        private List<DocumentSection> zzOV;
        private String zzOW;
        private boolean zzOX;
        private Account zzOY;

        public zza zzK(boolean z) {
            this.zzOX = z;
            return this;
        }

        public zza zza(Account account) {
            this.zzOY = account;
            return this;
        }

        public zza zza(DocumentSection documentSection) {
            if (this.zzOV == null) {
                this.zzOV = new ArrayList();
            }
            this.zzOV.add(documentSection);
            return this;
        }

        public zza zzbv(String str) {
            this.zzOW = str;
            return this;
        }

        public DocumentContents zzkY() {
            return new DocumentContents(this.zzOW, this.zzOX, this.zzOY, this.zzOV != null ? (DocumentSection[]) this.zzOV.toArray(new DocumentSection[this.zzOV.size()]) : null);
        }
    }

    static {
        CREATOR = new zzb();
    }

    DocumentContents(int i, DocumentSection[] documentSectionArr, String str, boolean z, Account account) {
        this.mVersionCode = i;
        this.zzOS = documentSectionArr;
        this.zzOT = str;
        this.zzOU = z;
        this.account = account;
    }

    DocumentContents(String str, boolean z, Account account, DocumentSection... documentSectionArr) {
        this(1, documentSectionArr, str, z, account);
        BitSet bitSet = new BitSet(zzh.zzlc());
        for (DocumentSection documentSection : documentSectionArr) {
            int i = documentSection.zzPg;
            if (i != -1) {
                if (bitSet.get(i)) {
                    throw new IllegalArgumentException("Duplicate global search section type " + zzh.zzaj(i));
                }
                bitSet.set(i);
            }
        }
    }

    public int describeContents() {
        zzb com_google_android_gms_appdatasearch_zzb = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb com_google_android_gms_appdatasearch_zzb = CREATOR;
        zzb.zza(this, parcel, i);
    }

    public DocumentSection zzbu(String str) {
        zzx.zzcs(str);
        if (this.zzOS == null) {
            return null;
        }
        for (DocumentSection documentSection : this.zzOS) {
            if (str.equals(documentSection.zzkZ().name)) {
                return documentSection;
            }
        }
        return null;
    }

    public String zzkX() {
        DocumentSection zzbu = zzbu("web_url");
        return zzbu != null ? zzbu.zzPe : null;
    }
}
