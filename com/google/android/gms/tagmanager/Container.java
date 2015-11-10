package com.google.android.gms.tagmanager;

import android.content.Context;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.internal.zzaf.zzf;
import com.google.android.gms.internal.zzaf.zzi;
import com.google.android.gms.internal.zzaf.zzj;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqp.zzc;
import com.google.android.gms.internal.zzqp.zzg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final Context mContext;
    private final String zzaOS;
    private final DataLayer zzaOT;
    private zzcp zzaOU;
    private Map<String, FunctionCallMacroCallback> zzaOV;
    private Map<String, FunctionCallTagCallback> zzaOW;
    private volatile long zzaOX;
    private volatile String zzaOY;

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    private class zza implements com.google.android.gms.tagmanager.zzt.zza {
        final /* synthetic */ Container zzaOZ;

        private zza(Container container) {
            this.zzaOZ = container;
        }

        public Object zzd(String str, Map<String, Object> map) {
            FunctionCallMacroCallback zzeu = this.zzaOZ.zzeu(str);
            return zzeu == null ? null : zzeu.getValue(str, map);
        }
    }

    private class zzb implements com.google.android.gms.tagmanager.zzt.zza {
        final /* synthetic */ Container zzaOZ;

        private zzb(Container container) {
            this.zzaOZ = container;
        }

        public Object zzd(String str, Map<String, Object> map) {
            FunctionCallTagCallback zzev = this.zzaOZ.zzev(str);
            if (zzev != null) {
                zzev.execute(str, map);
            }
            return zzdf.zzBf();
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzj com_google_android_gms_internal_zzaf_zzj) {
        this.zzaOV = new HashMap();
        this.zzaOW = new HashMap();
        this.zzaOY = BuildConfig.FLAVOR;
        this.mContext = context;
        this.zzaOT = dataLayer;
        this.zzaOS = str;
        this.zzaOX = j;
        zza(com_google_android_gms_internal_zzaf_zzj.zziR);
        if (com_google_android_gms_internal_zzaf_zzj.zziQ != null) {
            zza(com_google_android_gms_internal_zzaf_zzj.zziQ);
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzc com_google_android_gms_internal_zzqp_zzc) {
        this.zzaOV = new HashMap();
        this.zzaOW = new HashMap();
        this.zzaOY = BuildConfig.FLAVOR;
        this.mContext = context;
        this.zzaOT = dataLayer;
        this.zzaOS = str;
        this.zzaOX = j;
        zza(com_google_android_gms_internal_zzqp_zzc);
    }

    private void zza(zzf com_google_android_gms_internal_zzaf_zzf) {
        if (com_google_android_gms_internal_zzaf_zzf == null) {
            throw new NullPointerException();
        }
        try {
            zza(zzqp.zzb(com_google_android_gms_internal_zzaf_zzf));
        } catch (zzg e) {
            zzbg.m1004e("Not loading resource: " + com_google_android_gms_internal_zzaf_zzf + " because it is invalid: " + e.toString());
        }
    }

    private void zza(zzc com_google_android_gms_internal_zzqp_zzc) {
        this.zzaOY = com_google_android_gms_internal_zzqp_zzc.getVersion();
        zzc com_google_android_gms_internal_zzqp_zzc2 = com_google_android_gms_internal_zzqp_zzc;
        zza(new zzcp(this.mContext, com_google_android_gms_internal_zzqp_zzc2, this.zzaOT, new zza(), new zzb(), zzex(this.zzaOY)));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.zzaOT.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", this.zzaOS));
        }
    }

    private synchronized void zza(zzcp com_google_android_gms_tagmanager_zzcp) {
        this.zzaOU = com_google_android_gms_tagmanager_zzcp;
    }

    private void zza(zzi[] com_google_android_gms_internal_zzaf_zziArr) {
        List arrayList = new ArrayList();
        for (Object add : com_google_android_gms_internal_zzaf_zziArr) {
            arrayList.add(add);
        }
        zzzD().zzs(arrayList);
    }

    private synchronized zzcp zzzD() {
        return this.zzaOU;
    }

    public boolean getBoolean(String str) {
        zzcp zzzD = zzzD();
        if (zzzD == null) {
            zzbg.m1004e("getBoolean called for closed container.");
            return zzdf.zzBd().booleanValue();
        }
        try {
            return zzdf.zzk((com.google.android.gms.internal.zzag.zza) zzzD.zzeS(str).getObject()).booleanValue();
        } catch (Exception e) {
            zzbg.m1004e("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzBd().booleanValue();
        }
    }

    public String getContainerId() {
        return this.zzaOS;
    }

    public double getDouble(String str) {
        zzcp zzzD = zzzD();
        if (zzzD == null) {
            zzbg.m1004e("getDouble called for closed container.");
            return zzdf.zzBc().doubleValue();
        }
        try {
            return zzdf.zzj((com.google.android.gms.internal.zzag.zza) zzzD.zzeS(str).getObject()).doubleValue();
        } catch (Exception e) {
            zzbg.m1004e("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzBc().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.zzaOX;
    }

    public long getLong(String str) {
        zzcp zzzD = zzzD();
        if (zzzD == null) {
            zzbg.m1004e("getLong called for closed container.");
            return zzdf.zzBb().longValue();
        }
        try {
            return zzdf.zzi((com.google.android.gms.internal.zzag.zza) zzzD.zzeS(str).getObject()).longValue();
        } catch (Exception e) {
            zzbg.m1004e("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzBb().longValue();
        }
    }

    public String getString(String str) {
        zzcp zzzD = zzzD();
        if (zzzD == null) {
            zzbg.m1004e("getString called for closed container.");
            return zzdf.zzBf();
        }
        try {
            return zzdf.zzg((com.google.android.gms.internal.zzag.zza) zzzD.zzeS(str).getObject());
        } catch (Exception e) {
            zzbg.m1004e("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzBf();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String str, FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.zzaOV) {
            this.zzaOV.put(str, functionCallMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String str, FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.zzaOW) {
            this.zzaOW.put(str, functionCallTagCallback);
        }
    }

    void release() {
        this.zzaOU = null;
    }

    public void unregisterFunctionCallMacroCallback(String str) {
        synchronized (this.zzaOV) {
            this.zzaOV.remove(str);
        }
    }

    public void unregisterFunctionCallTagCallback(String str) {
        synchronized (this.zzaOW) {
            this.zzaOW.remove(str);
        }
    }

    FunctionCallMacroCallback zzeu(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zzaOV) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.zzaOV.get(str);
        }
        return functionCallMacroCallback;
    }

    FunctionCallTagCallback zzev(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzaOW) {
            functionCallTagCallback = (FunctionCallTagCallback) this.zzaOW.get(str);
        }
        return functionCallTagCallback;
    }

    void zzew(String str) {
        zzzD().zzew(str);
    }

    zzah zzex(String str) {
        if (zzcb.zzAv().zzAw().equals(zza.CONTAINER_DEBUG)) {
        }
        return new zzbo();
    }

    String zzzC() {
        return this.zzaOY;
    }
}
