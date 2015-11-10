package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter implements SafeParcelable, zza<String, Integer> {
    public static final zzb CREATOR;
    private final int mVersionCode;
    private final HashMap<String, Integer> zzaeL;
    private final HashMap<Integer, String> zzaeM;
    private final ArrayList<Entry> zzaeN;

    public static final class Entry implements SafeParcelable {
        public static final zzc CREATOR;
        final int versionCode;
        final String zzaeO;
        final int zzaeP;

        static {
            CREATOR = new zzc();
        }

        Entry(int i, String str, int i2) {
            this.versionCode = i;
            this.zzaeO = str;
            this.zzaeP = i2;
        }

        Entry(String str, int i) {
            this.versionCode = 1;
            this.zzaeO = str;
            this.zzaeP = i;
        }

        public int describeContents() {
            zzc com_google_android_gms_common_server_converter_zzc = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzc com_google_android_gms_common_server_converter_zzc = CREATOR;
            zzc.zza(this, parcel, i);
        }
    }

    static {
        CREATOR = new zzb();
    }

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.zzaeL = new HashMap();
        this.zzaeM = new HashMap();
        this.zzaeN = null;
    }

    StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.mVersionCode = i;
        this.zzaeL = new HashMap();
        this.zzaeM = new HashMap();
        this.zzaeN = null;
        zzb((ArrayList) arrayList);
    }

    private void zzb(ArrayList<Entry> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzi(entry.zzaeO, entry.zzaeP);
        }
    }

    public /* synthetic */ Object convertBack(Object obj) {
        return zzb((Integer) obj);
    }

    public int describeContents() {
        zzb com_google_android_gms_common_server_converter_zzb = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb com_google_android_gms_common_server_converter_zzb = CREATOR;
        zzb.zza(this, parcel, i);
    }

    public String zzb(Integer num) {
        String str = (String) this.zzaeM.get(num);
        return (str == null && this.zzaeL.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public StringToIntConverter zzi(String str, int i) {
        this.zzaeL.put(str, Integer.valueOf(i));
        this.zzaeM.put(Integer.valueOf(i), str);
        return this;
    }

    ArrayList<Entry> zzoY() {
        ArrayList<Entry> arrayList = new ArrayList();
        for (String str : this.zzaeL.keySet()) {
            arrayList.add(new Entry(str, ((Integer) this.zzaeL.get(str)).intValue()));
        }
        return arrayList;
    }

    public int zzoZ() {
        return 7;
    }

    public int zzpa() {
        return 0;
    }
}
