package com.google.android.gms.tagmanager;

import com.facebook.internal.ServerProtocol;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.internal.zzag.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class zzdf {
    private static final Object zzaSN;
    private static Long zzaSO;
    private static Double zzaSP;
    private static zzde zzaSQ;
    private static String zzaSR;
    private static Boolean zzaSS;
    private static List<Object> zzaST;
    private static Map<Object, Object> zzaSU;
    private static zza zzaSV;

    static {
        zzaSN = null;
        zzaSO = new Long(0);
        zzaSP = new Double(0.0d);
        zzaSQ = zzde.zzT(0);
        zzaSR = new String(BuildConfig.FLAVOR);
        zzaSS = new Boolean(false);
        zzaST = new ArrayList(0);
        zzaSU = new HashMap();
        zzaSV = zzK(zzaSR);
    }

    private static double getDouble(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        zzbg.m1004e("getDouble received non-Number");
        return 0.0d;
    }

    public static Object zzBa() {
        return zzaSN;
    }

    public static Long zzBb() {
        return zzaSO;
    }

    public static Double zzBc() {
        return zzaSP;
    }

    public static Boolean zzBd() {
        return zzaSS;
    }

    public static zzde zzBe() {
        return zzaSQ;
    }

    public static String zzBf() {
        return zzaSR;
    }

    public static zza zzBg() {
        return zzaSV;
    }

    public static String zzF(Object obj) {
        return obj == null ? zzaSR : obj.toString();
    }

    public static zzde zzG(Object obj) {
        return obj instanceof zzde ? (zzde) obj : zzM(obj) ? zzde.zzT(zzN(obj)) : zzL(obj) ? zzde.zza(Double.valueOf(getDouble(obj))) : zzeZ(zzF(obj));
    }

    public static Long zzH(Object obj) {
        return zzM(obj) ? Long.valueOf(zzN(obj)) : zzfa(zzF(obj));
    }

    public static Double zzI(Object obj) {
        return zzL(obj) ? Double.valueOf(getDouble(obj)) : zzfb(zzF(obj));
    }

    public static Boolean zzJ(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : zzfc(zzF(obj));
    }

    public static zza zzK(Object obj) {
        boolean z = false;
        zza com_google_android_gms_internal_zzag_zza = new zza();
        if (obj instanceof zza) {
            return (zza) obj;
        }
        if (obj instanceof String) {
            com_google_android_gms_internal_zzag_zza.type = 1;
            com_google_android_gms_internal_zzag_zza.zziU = (String) obj;
        } else if (obj instanceof List) {
            com_google_android_gms_internal_zzag_zza.type = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object zzK : list) {
                zza zzK2 = zzK(zzK);
                if (zzK2 == zzaSV) {
                    return zzaSV;
                }
                r0 = r1 || zzK2.zzje;
                r5.add(zzK2);
                r1 = r0;
            }
            com_google_android_gms_internal_zzag_zza.zziV = (zza[]) r5.toArray(new zza[0]);
            z = r1;
        } else if (obj instanceof Map) {
            com_google_android_gms_internal_zzag_zza.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                zza zzK3 = zzK(entry.getKey());
                zza zzK4 = zzK(entry.getValue());
                if (zzK3 == zzaSV || zzK4 == zzaSV) {
                    return zzaSV;
                }
                r0 = r1 || zzK3.zzje || zzK4.zzje;
                r5.add(zzK3);
                arrayList.add(zzK4);
                r1 = r0;
            }
            com_google_android_gms_internal_zzag_zza.zziW = (zza[]) r5.toArray(new zza[0]);
            com_google_android_gms_internal_zzag_zza.zziX = (zza[]) arrayList.toArray(new zza[0]);
            z = r1;
        } else if (zzL(obj)) {
            com_google_android_gms_internal_zzag_zza.type = 1;
            com_google_android_gms_internal_zzag_zza.zziU = obj.toString();
        } else if (zzM(obj)) {
            com_google_android_gms_internal_zzag_zza.type = 6;
            com_google_android_gms_internal_zzag_zza.zzja = zzN(obj);
        } else if (obj instanceof Boolean) {
            com_google_android_gms_internal_zzag_zza.type = 8;
            com_google_android_gms_internal_zzag_zza.zzjb = ((Boolean) obj).booleanValue();
        } else {
            zzbg.m1004e("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return zzaSV;
        }
        com_google_android_gms_internal_zzag_zza.zzje = z;
        return com_google_android_gms_internal_zzag_zza;
    }

    private static boolean zzL(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof zzde) && ((zzde) obj).zzAV());
    }

    private static boolean zzM(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof zzde) && ((zzde) obj).zzAW());
    }

    private static long zzN(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzbg.m1004e("getInt64 received non-Number");
        return 0;
    }

    public static zza zzeY(String str) {
        zza com_google_android_gms_internal_zzag_zza = new zza();
        com_google_android_gms_internal_zzag_zza.type = 5;
        com_google_android_gms_internal_zzag_zza.zziZ = str;
        return com_google_android_gms_internal_zzag_zza;
    }

    private static zzde zzeZ(String str) {
        try {
            return zzde.zzeX(str);
        } catch (NumberFormatException e) {
            zzbg.m1004e("Failed to convert '" + str + "' to a number.");
            return zzaSQ;
        }
    }

    private static Long zzfa(String str) {
        zzde zzeZ = zzeZ(str);
        return zzeZ == zzaSQ ? zzaSO : Long.valueOf(zzeZ.longValue());
    }

    private static Double zzfb(String str) {
        zzde zzeZ = zzeZ(str);
        return zzeZ == zzaSQ ? zzaSP : Double.valueOf(zzeZ.doubleValue());
    }

    private static Boolean zzfc(String str) {
        return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : zzaSS;
    }

    public static String zzg(zza com_google_android_gms_internal_zzag_zza) {
        return zzF(zzl(com_google_android_gms_internal_zzag_zza));
    }

    public static zzde zzh(zza com_google_android_gms_internal_zzag_zza) {
        return zzG(zzl(com_google_android_gms_internal_zzag_zza));
    }

    public static Long zzi(zza com_google_android_gms_internal_zzag_zza) {
        return zzH(zzl(com_google_android_gms_internal_zzag_zza));
    }

    public static Double zzj(zza com_google_android_gms_internal_zzag_zza) {
        return zzI(zzl(com_google_android_gms_internal_zzag_zza));
    }

    public static Boolean zzk(zza com_google_android_gms_internal_zzag_zza) {
        return zzJ(zzl(com_google_android_gms_internal_zzag_zza));
    }

    public static Object zzl(zza com_google_android_gms_internal_zzag_zza) {
        int i = 0;
        if (com_google_android_gms_internal_zzag_zza == null) {
            return zzaSN;
        }
        zza[] com_google_android_gms_internal_zzag_zzaArr;
        int length;
        switch (com_google_android_gms_internal_zzag_zza.type) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return com_google_android_gms_internal_zzag_zza.zziU;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                ArrayList arrayList = new ArrayList(com_google_android_gms_internal_zzag_zza.zziV.length);
                com_google_android_gms_internal_zzag_zzaArr = com_google_android_gms_internal_zzag_zza.zziV;
                length = com_google_android_gms_internal_zzag_zzaArr.length;
                while (i < length) {
                    Object zzl = zzl(com_google_android_gms_internal_zzag_zzaArr[i]);
                    if (zzl == zzaSN) {
                        return zzaSN;
                    }
                    arrayList.add(zzl);
                    i++;
                }
                return arrayList;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                if (com_google_android_gms_internal_zzag_zza.zziW.length != com_google_android_gms_internal_zzag_zza.zziX.length) {
                    zzbg.m1004e("Converting an invalid value to object: " + com_google_android_gms_internal_zzag_zza.toString());
                    return zzaSN;
                }
                Map hashMap = new HashMap(com_google_android_gms_internal_zzag_zza.zziX.length);
                while (i < com_google_android_gms_internal_zzag_zza.zziW.length) {
                    Object zzl2 = zzl(com_google_android_gms_internal_zzag_zza.zziW[i]);
                    Object zzl3 = zzl(com_google_android_gms_internal_zzag_zza.zziX[i]);
                    if (zzl2 == zzaSN || zzl3 == zzaSN) {
                        return zzaSN;
                    }
                    hashMap.put(zzl2, zzl3);
                    i++;
                }
                return hashMap;
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                zzbg.m1004e("Trying to convert a macro reference to object");
                return zzaSN;
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                zzbg.m1004e("Trying to convert a function id to object");
                return zzaSN;
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                return Long.valueOf(com_google_android_gms_internal_zzag_zza.zzja);
            case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                StringBuffer stringBuffer = new StringBuffer();
                com_google_android_gms_internal_zzag_zzaArr = com_google_android_gms_internal_zzag_zza.zzjc;
                length = com_google_android_gms_internal_zzag_zzaArr.length;
                while (i < length) {
                    String zzg = zzg(com_google_android_gms_internal_zzag_zzaArr[i]);
                    if (zzg == zzaSR) {
                        return zzaSN;
                    }
                    stringBuffer.append(zzg);
                    i++;
                }
                return stringBuffer.toString();
            case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                return Boolean.valueOf(com_google_android_gms_internal_zzag_zza.zzjb);
            default:
                zzbg.m1004e("Failed to convert a value of type: " + com_google_android_gms_internal_zzag_zza.type);
                return zzaSN;
        }
    }
}
