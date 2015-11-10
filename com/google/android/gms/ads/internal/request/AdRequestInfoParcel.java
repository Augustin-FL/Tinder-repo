package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgk;
import java.util.Collections;
import java.util.List;

@zzgk
public final class AdRequestInfoParcel implements SafeParcelable {
    public static final zzf CREATOR;
    public final ApplicationInfo applicationInfo;
    public final int versionCode;
    public final String zzDA;
    public final String zzDB;
    public final String zzDC;
    public final Bundle zzDD;
    public final int zzDE;
    public final Bundle zzDF;
    public final boolean zzDG;
    public final Messenger zzDH;
    public final int zzDI;
    public final int zzDJ;
    public final float zzDK;
    public final String zzDL;
    public final boolean zzDM;
    public final int zzDN;
    public final String zzDO;
    public final long zzDP;
    public final String zzDQ;
    public final List<String> zzDR;
    public final List<String> zzDS;
    public final long zzDT;
    public final CapabilityParcel zzDU;
    public final Bundle zzDx;
    public final AdRequestParcel zzDy;
    public final PackageInfo zzDz;
    public final String zzpY;
    public final String zzpZ;
    public final VersionInfoParcel zzqb;
    public final AdSizeParcel zzqf;
    public final NativeAdOptionsParcel zzqt;
    public final List<String> zzqv;

    @zzgk
    public static final class zza {
        public final ApplicationInfo applicationInfo;
        public final String zzDB;
        public final String zzDC;
        public final Bundle zzDD;
        public final int zzDE;
        public final Bundle zzDF;
        public final boolean zzDG;
        public final Messenger zzDH;
        public final int zzDI;
        public final int zzDJ;
        public final float zzDK;
        public final String zzDL;
        public final boolean zzDM;
        public final int zzDN;
        public final long zzDP;
        public final String zzDQ;
        public final List<String> zzDR;
        public final List<String> zzDS;
        public final CapabilityParcel zzDU;
        public final Bundle zzDx;
        public final AdRequestParcel zzDy;
        public final PackageInfo zzDz;
        public final String zzpY;
        public final String zzpZ;
        public final VersionInfoParcel zzqb;
        public final AdSizeParcel zzqf;
        public final NativeAdOptionsParcel zzqt;
        public final List<String> zzqv;

        public zza(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, VersionInfoParcel versionInfoParcel, Bundle bundle2, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i, int i2, float f, String str4, boolean z2, int i3, long j, String str5, List<String> list3, String str6, NativeAdOptionsParcel nativeAdOptionsParcel, CapabilityParcel capabilityParcel) {
            this.zzDx = bundle;
            this.zzDy = adRequestParcel;
            this.zzqf = adSizeParcel;
            this.zzpZ = str;
            this.applicationInfo = applicationInfo;
            this.zzDz = packageInfo;
            this.zzDB = str2;
            this.zzDC = str3;
            this.zzqb = versionInfoParcel;
            this.zzDD = bundle2;
            this.zzDG = z;
            this.zzDH = messenger;
            this.zzDI = i;
            this.zzDJ = i2;
            this.zzDK = f;
            if (list == null || list.size() <= 0) {
                this.zzDE = 0;
                this.zzqv = null;
                this.zzDS = null;
            } else {
                this.zzDE = 3;
                this.zzqv = list;
                this.zzDS = list2;
            }
            this.zzDF = bundle3;
            this.zzDL = str4;
            this.zzDM = z2;
            this.zzDN = i3;
            this.zzDP = j;
            this.zzDQ = str5;
            this.zzDR = list3;
            this.zzpY = str6;
            this.zzqt = nativeAdOptionsParcel;
            this.zzDU = capabilityParcel;
        }
    }

    static {
        CREATOR = new zzf();
    }

    AdRequestInfoParcel(int i, Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, Messenger messenger, int i3, int i4, float f, String str5, boolean z2, int i5, String str6, long j, String str7, List<String> list2, String str8, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list3, long j2, CapabilityParcel capabilityParcel) {
        this.versionCode = i;
        this.zzDx = bundle;
        this.zzDy = adRequestParcel;
        this.zzqf = adSizeParcel;
        this.zzpZ = str;
        this.applicationInfo = applicationInfo;
        this.zzDz = packageInfo;
        this.zzDA = str2;
        this.zzDB = str3;
        this.zzDC = str4;
        this.zzqb = versionInfoParcel;
        this.zzDD = bundle2;
        this.zzDE = i2;
        this.zzqv = list;
        this.zzDS = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzDF = bundle3;
        this.zzDG = z;
        this.zzDH = messenger;
        this.zzDI = i3;
        this.zzDJ = i4;
        this.zzDK = f;
        this.zzDL = str5;
        this.zzDM = z2;
        this.zzDN = i5;
        this.zzDO = str6;
        this.zzDP = j;
        this.zzDQ = str7;
        this.zzDR = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzpY = str8;
        this.zzqt = nativeAdOptionsParcel;
        this.zzDT = j2;
        this.zzDU = capabilityParcel;
    }

    public AdRequestInfoParcel(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i2, int i3, float f, String str5, boolean z2, int i4, String str6, long j, String str7, List<String> list3, String str8, NativeAdOptionsParcel nativeAdOptionsParcel, long j2, CapabilityParcel capabilityParcel) {
        this(11, bundle, adRequestParcel, adSizeParcel, str, applicationInfo, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i, list, bundle3, z, messenger, i2, i3, f, str5, z2, i4, str6, j, str7, list3, str8, nativeAdOptionsParcel, list2, j2, capabilityParcel);
    }

    public AdRequestInfoParcel(zza com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza, String str, String str2, long j) {
        String str3 = str;
        String str4 = str2;
        long j2 = j;
        this(com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDx, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDy, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzqf, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzpZ, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.applicationInfo, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDz, str3, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDB, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDC, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzqb, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDD, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDE, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzqv, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDS, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDF, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDG, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDH, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDI, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDJ, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDK, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDL, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDM, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDN, str4, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDP, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDQ, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDR, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzpY, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzqt, j2, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzDU);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
