package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzrx;
import java.util.List;
import java.util.zip.CRC32;
import org.apache.http.protocol.HTTP;

public class UsageInfo implements SafeParcelable {
    public static final zzj CREATOR;
    final int mVersionCode;
    final DocumentId zzPP;
    final long zzPQ;
    int zzPR;
    final DocumentContents zzPS;
    final boolean zzPT;
    int zzPU;
    int zzPV;
    public final String zztM;

    public static final class zza {
        private String zzJZ;
        private DocumentId zzPP;
        private long zzPQ;
        private int zzPR;
        private DocumentContents zzPS;
        private boolean zzPT;
        private int zzPU;
        private int zzPV;

        public zza() {
            this.zzPQ = -1;
            this.zzPR = -1;
            this.zzPU = -1;
            this.zzPT = false;
            this.zzPV = 0;
        }

        public zza zzO(boolean z) {
            this.zzPT = z;
            return this;
        }

        public zza zza(DocumentContents documentContents) {
            this.zzPS = documentContents;
            return this;
        }

        public zza zza(DocumentId documentId) {
            this.zzPP = documentId;
            return this;
        }

        public zza zzam(int i) {
            this.zzPR = i;
            return this;
        }

        public zza zzan(int i) {
            this.zzPV = i;
            return this;
        }

        public UsageInfo zzlf() {
            return new UsageInfo(this.zzPQ, this.zzPR, this.zzJZ, this.zzPS, this.zzPT, this.zzPU, this.zzPV, null);
        }

        public zza zzw(long j) {
            this.zzPQ = j;
            return this;
        }
    }

    static {
        CREATOR = new zzj();
    }

    UsageInfo(int i, DocumentId documentId, long j, int i2, String str, DocumentContents documentContents, boolean z, int i3, int i4) {
        this.mVersionCode = i;
        this.zzPP = documentId;
        this.zzPQ = j;
        this.zzPR = i2;
        this.zztM = str;
        this.zzPS = documentContents;
        this.zzPT = z;
        this.zzPU = i3;
        this.zzPV = i4;
    }

    private UsageInfo(DocumentId documentId, long j, int i, String str, DocumentContents documentContents, boolean z, int i2, int i3) {
        this(1, documentId, j, i, str, documentContents, z, i2, i3);
    }

    public UsageInfo(String str, Intent intent, String str2, Uri uri, String str3, List<AppIndexingLink> list, int i) {
        this(1, zza(str, intent), System.currentTimeMillis(), 0, null, zza(intent, str2, uri, str3, list).zzkY(), false, -1, i);
    }

    public static com.google.android.gms.appdatasearch.DocumentContents.zza zza(Intent intent, String str, Uri uri, String str2, List<AppIndexingLink> list) {
        com.google.android.gms.appdatasearch.DocumentContents.zza com_google_android_gms_appdatasearch_DocumentContents_zza = new com.google.android.gms.appdatasearch.DocumentContents.zza();
        com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzbA(str));
        if (uri != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzi(uri));
        }
        if (list != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzh(list));
        }
        String action = intent.getAction();
        if (action != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzq("intent_action", action));
        }
        action = intent.getDataString();
        if (action != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzq("intent_data", action));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzq("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            action = extras.getString("intent_extra_data_key");
            if (action != null) {
                com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzq("intent_extra_data", action));
            }
        }
        return com_google_android_gms_appdatasearch_DocumentContents_zza.zzbv(str2).zzK(true);
    }

    public static DocumentId zza(String str, Intent intent) {
        return zzp(str, zzg(intent));
    }

    private static DocumentSection zzbA(String str) {
        return new DocumentSection(str, new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza(ShareConstants.WEB_DIALOG_PARAM_TITLE).zzak(1).zzN(true).zzbz(ShareConstants.WEB_DIALOG_PARAM_NAME).zzld(), "text1");
    }

    private static String zzg(Intent intent) {
        String toUri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(toUri.getBytes(HTTP.UTF_8));
            return Long.toHexString(crc32.getValue());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    private static DocumentSection zzh(List<AppIndexingLink> list) {
        zzrx com_google_android_gms_internal_zznw_zza = new com.google.android.gms.internal.zznw.zza();
        com.google.android.gms.internal.zznw.zza.zza[] com_google_android_gms_internal_zznw_zza_zzaArr = new com.google.android.gms.internal.zznw.zza.zza[list.size()];
        for (int i = 0; i < com_google_android_gms_internal_zznw_zza_zzaArr.length; i++) {
            com_google_android_gms_internal_zznw_zza_zzaArr[i] = new com.google.android.gms.internal.zznw.zza.zza();
            AppIndexingLink appIndexingLink = (AppIndexingLink) list.get(i);
            com_google_android_gms_internal_zznw_zza_zzaArr[i].zzaAo = appIndexingLink.appIndexingUrl.toString();
            com_google_android_gms_internal_zznw_zza_zzaArr[i].viewId = appIndexingLink.viewId;
            if (appIndexingLink.webUrl != null) {
                com_google_android_gms_internal_zznw_zza_zzaArr[i].zzaAp = appIndexingLink.webUrl.toString();
            }
        }
        com_google_android_gms_internal_zznw_zza.zzaAm = com_google_android_gms_internal_zznw_zza_zzaArr;
        return new DocumentSection(zzrx.zzf(com_google_android_gms_internal_zznw_zza), new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("outlinks").zzM(true).zzbz(".private:outLinks").zzby("blob").zzld());
    }

    private static DocumentSection zzi(Uri uri) {
        return new DocumentSection(uri.toString(), new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("web_url").zzak(4).zzM(true).zzbz(NativeProtocol.WEB_DIALOG_URL).zzld());
    }

    private static DocumentId zzp(String str, String str2) {
        return new DocumentId(str, BuildConfig.FLAVOR, str2);
    }

    private static DocumentSection zzq(String str, String str2) {
        return new DocumentSection(str2, new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza(str).zzM(true).zzld(), str);
    }

    public int describeContents() {
        zzj com_google_android_gms_appdatasearch_zzj = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[]{this.zzPP, Long.valueOf(this.zzPQ), Integer.valueOf(this.zzPR), Integer.valueOf(this.zzPV)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj com_google_android_gms_appdatasearch_zzj = CREATOR;
        zzj.zza(this, parcel, i);
    }

    public DocumentContents zzle() {
        return this.zzPS;
    }
}
