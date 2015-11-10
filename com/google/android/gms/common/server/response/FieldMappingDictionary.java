package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary implements SafeParcelable {
    public static final zzc CREATOR;
    private final int mVersionCode;
    private final HashMap<String, Map<String, Field<?, ?>>> zzafa;
    private final ArrayList<Entry> zzafb;
    private final String zzafc;

    public static class Entry implements SafeParcelable {
        public static final zzd CREATOR;
        final String className;
        final int versionCode;
        final ArrayList<FieldMapPair> zzafd;

        static {
            CREATOR = new zzd();
        }

        Entry(int i, String str, ArrayList<FieldMapPair> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.zzafd = arrayList;
        }

        Entry(String str, Map<String, Field<?, ?>> map) {
            this.versionCode = 1;
            this.className = str;
            this.zzafd = zzD(map);
        }

        private static ArrayList<FieldMapPair> zzD(Map<String, Field<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList<FieldMapPair> arrayList = new ArrayList();
            for (String str : map.keySet()) {
                arrayList.add(new FieldMapPair(str, (Field) map.get(str)));
            }
            return arrayList;
        }

        public int describeContents() {
            zzd com_google_android_gms_common_server_response_zzd = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzd com_google_android_gms_common_server_response_zzd = CREATOR;
            zzd.zza(this, parcel, i);
        }

        HashMap<String, Field<?, ?>> zzps() {
            HashMap<String, Field<?, ?>> hashMap = new HashMap();
            int size = this.zzafd.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = (FieldMapPair) this.zzafd.get(i);
                hashMap.put(fieldMapPair.key, fieldMapPair.zzafe);
            }
            return hashMap;
        }
    }

    public static class FieldMapPair implements SafeParcelable {
        public static final zzb CREATOR;
        final String key;
        final int versionCode;
        final Field<?, ?> zzafe;

        static {
            CREATOR = new zzb();
        }

        FieldMapPair(int i, String str, Field<?, ?> field) {
            this.versionCode = i;
            this.key = str;
            this.zzafe = field;
        }

        FieldMapPair(String str, Field<?, ?> field) {
            this.versionCode = 1;
            this.key = str;
            this.zzafe = field;
        }

        public int describeContents() {
            zzb com_google_android_gms_common_server_response_zzb = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzb com_google_android_gms_common_server_response_zzb = CREATOR;
            zzb.zza(this, parcel, i);
        }
    }

    static {
        CREATOR = new zzc();
    }

    FieldMappingDictionary(int i, ArrayList<Entry> arrayList, String str) {
        this.mVersionCode = i;
        this.zzafb = null;
        this.zzafa = zzc(arrayList);
        this.zzafc = (String) zzx.zzv(str);
        zzpo();
    }

    public FieldMappingDictionary(Class<? extends FastJsonResponse> cls) {
        this.mVersionCode = 1;
        this.zzafb = null;
        this.zzafa = new HashMap();
        this.zzafc = cls.getCanonicalName();
    }

    private static HashMap<String, Map<String, Field<?, ?>>> zzc(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, Field<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) arrayList.get(i);
            hashMap.put(entry.className, entry.zzps());
        }
        return hashMap;
    }

    public int describeContents() {
        zzc com_google_android_gms_common_server_response_zzc = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.zzafa.keySet()) {
            stringBuilder.append(str).append(":\n");
            Map map = (Map) this.zzafa.get(str);
            for (String str2 : map.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(map.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc com_google_android_gms_common_server_response_zzc = CREATOR;
        zzc.zza(this, parcel, i);
    }

    public void zza(Class<? extends FastJsonResponse> cls, Map<String, Field<?, ?>> map) {
        this.zzafa.put(cls.getCanonicalName(), map);
    }

    public boolean zzb(Class<? extends FastJsonResponse> cls) {
        return this.zzafa.containsKey(cls.getCanonicalName());
    }

    public Map<String, Field<?, ?>> zzcx(String str) {
        return (Map) this.zzafa.get(str);
    }

    public void zzpo() {
        for (String str : this.zzafa.keySet()) {
            Map map = (Map) this.zzafa.get(str);
            for (String str2 : map.keySet()) {
                ((Field) map.get(str2)).zza(this);
            }
        }
    }

    public void zzpp() {
        for (String str : this.zzafa.keySet()) {
            Map map = (Map) this.zzafa.get(str);
            HashMap hashMap = new HashMap();
            for (String str2 : map.keySet()) {
                hashMap.put(str2, ((Field) map.get(str2)).zzpe());
            }
            this.zzafa.put(str, hashMap);
        }
    }

    ArrayList<Entry> zzpq() {
        ArrayList<Entry> arrayList = new ArrayList();
        for (String str : this.zzafa.keySet()) {
            arrayList.add(new Entry(str, (Map) this.zzafa.get(str)));
        }
        return arrayList;
    }

    public String zzpr() {
        return this.zzafc;
    }
}
