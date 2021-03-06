package com.google.android.gms.internal;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;

public class zzqd {
    private static boolean DEBUG;
    private static String TAG;
    private final Context mContext;
    private int zzaOA;
    private final WakeLock zzaOu;
    private WorkSource zzaOv;
    private final int zzaOw;
    private final String zzaOx;
    private boolean zzaOy;
    private int zzaOz;
    private final String zzafS;

    static {
        TAG = "WakeLock";
        DEBUG = false;
    }

    public zzqd(Context context, int i, String str) {
        this(context, i, str, null, null);
    }

    public zzqd(Context context, int i, String str, String str2, String str3) {
        this.zzaOy = true;
        zzx.zzh(str, "Wake lock name can NOT be empty");
        this.zzaOw = i;
        this.zzafS = str;
        this.zzaOx = str2;
        this.mContext = context.getApplicationContext();
        this.zzaOu = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zzma.zzaq(this.mContext)) {
            if (zzlz.zzcB(str3)) {
                if (zzd.zzacF && zzkq.isInitialized()) {
                    Log.e(TAG, "callingPackage is not supposed to be empty for wakelock " + this.zzafS + "!");
                    str3 = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE;
                } else {
                    str3 = context.getPackageName();
                }
            }
            this.zzaOv = zzma.zzj(context, str3);
            zzc(this.zzaOv);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzen(java.lang.String r9) {
        /*
        r8 = this;
        r0 = r8.zzep(r9);
        r5 = r8.zzi(r9, r0);
        r1 = DEBUG;
        if (r1 == 0) goto L_0x0068;
    L_0x000c:
        r1 = TAG;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Acquire:\n mWakeLockName: ";
        r2 = r2.append(r3);
        r3 = r8.zzafS;
        r2 = r2.append(r3);
        r3 = "\n mSecondaryName: ";
        r2 = r2.append(r3);
        r3 = r8.zzaOx;
        r2 = r2.append(r3);
        r3 = "\nmReferenceCounted: ";
        r2 = r2.append(r3);
        r3 = r8.zzaOy;
        r2 = r2.append(r3);
        r3 = "\nreason: ";
        r2 = r2.append(r3);
        r2 = r2.append(r9);
        r3 = "\nmOpenEventCount";
        r2 = r2.append(r3);
        r3 = r8.zzaOA;
        r2 = r2.append(r3);
        r3 = "\nuseWithReason: ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r3 = "\ntrackingName: ";
        r2 = r2.append(r3);
        r2 = r2.append(r5);
        r2 = r2.toString();
        android.util.Log.d(r1, r2);
    L_0x0068:
        monitor-enter(r8);
        r1 = r8.zzaOy;	 Catch:{ all -> 0x00a1 }
        if (r1 == 0) goto L_0x0077;
    L_0x006d:
        r1 = r8.zzaOz;	 Catch:{ all -> 0x00a1 }
        r2 = r1 + 1;
        r8.zzaOz = r2;	 Catch:{ all -> 0x00a1 }
        if (r1 == 0) goto L_0x007f;
    L_0x0075:
        if (r0 != 0) goto L_0x007f;
    L_0x0077:
        r0 = r8.zzaOy;	 Catch:{ all -> 0x00a1 }
        if (r0 != 0) goto L_0x009f;
    L_0x007b:
        r0 = r8.zzaOA;	 Catch:{ all -> 0x00a1 }
        if (r0 != 0) goto L_0x009f;
    L_0x007f:
        r0 = com.google.android.gms.common.stats.zzh.zzpL();	 Catch:{ all -> 0x00a1 }
        r1 = r8.mContext;	 Catch:{ all -> 0x00a1 }
        r2 = r8.zzaOu;	 Catch:{ all -> 0x00a1 }
        r2 = com.google.android.gms.common.stats.zzf.zza(r2, r5);	 Catch:{ all -> 0x00a1 }
        r3 = 7;
        r4 = r8.zzafS;	 Catch:{ all -> 0x00a1 }
        r6 = r8.zzaOw;	 Catch:{ all -> 0x00a1 }
        r7 = r8.zzaOv;	 Catch:{ all -> 0x00a1 }
        r7 = com.google.android.gms.internal.zzma.zzb(r7);	 Catch:{ all -> 0x00a1 }
        r0.zza(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x00a1 }
        r0 = r8.zzaOA;	 Catch:{ all -> 0x00a1 }
        r0 = r0 + 1;
        r8.zzaOA = r0;	 Catch:{ all -> 0x00a1 }
    L_0x009f:
        monitor-exit(r8);	 Catch:{ all -> 0x00a1 }
        return;
    L_0x00a1:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x00a1 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqd.zzen(java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzeo(java.lang.String r9) {
        /*
        r8 = this;
        r0 = r8.zzep(r9);
        r5 = r8.zzi(r9, r0);
        r1 = DEBUG;
        if (r1 == 0) goto L_0x0068;
    L_0x000c:
        r1 = TAG;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Release:\n mWakeLockName: ";
        r2 = r2.append(r3);
        r3 = r8.zzafS;
        r2 = r2.append(r3);
        r3 = "\n mSecondaryName: ";
        r2 = r2.append(r3);
        r3 = r8.zzaOx;
        r2 = r2.append(r3);
        r3 = "\nmReferenceCounted: ";
        r2 = r2.append(r3);
        r3 = r8.zzaOy;
        r2 = r2.append(r3);
        r3 = "\nreason: ";
        r2 = r2.append(r3);
        r2 = r2.append(r9);
        r3 = "\n mOpenEventCount";
        r2 = r2.append(r3);
        r3 = r8.zzaOA;
        r2 = r2.append(r3);
        r3 = "\nuseWithReason: ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r3 = "\ntrackingName: ";
        r2 = r2.append(r3);
        r2 = r2.append(r5);
        r2 = r2.toString();
        android.util.Log.d(r1, r2);
    L_0x0068:
        monitor-enter(r8);
        r1 = r8.zzaOy;	 Catch:{ all -> 0x00a3 }
        if (r1 == 0) goto L_0x0077;
    L_0x006d:
        r1 = r8.zzaOz;	 Catch:{ all -> 0x00a3 }
        r1 = r1 + -1;
        r8.zzaOz = r1;	 Catch:{ all -> 0x00a3 }
        if (r1 == 0) goto L_0x0080;
    L_0x0075:
        if (r0 != 0) goto L_0x0080;
    L_0x0077:
        r0 = r8.zzaOy;	 Catch:{ all -> 0x00a3 }
        if (r0 != 0) goto L_0x00a1;
    L_0x007b:
        r0 = r8.zzaOA;	 Catch:{ all -> 0x00a3 }
        r1 = 1;
        if (r0 != r1) goto L_0x00a1;
    L_0x0080:
        r0 = com.google.android.gms.common.stats.zzh.zzpL();	 Catch:{ all -> 0x00a3 }
        r1 = r8.mContext;	 Catch:{ all -> 0x00a3 }
        r2 = r8.zzaOu;	 Catch:{ all -> 0x00a3 }
        r2 = com.google.android.gms.common.stats.zzf.zza(r2, r5);	 Catch:{ all -> 0x00a3 }
        r3 = 8;
        r4 = r8.zzafS;	 Catch:{ all -> 0x00a3 }
        r6 = r8.zzaOw;	 Catch:{ all -> 0x00a3 }
        r7 = r8.zzaOv;	 Catch:{ all -> 0x00a3 }
        r7 = com.google.android.gms.internal.zzma.zzb(r7);	 Catch:{ all -> 0x00a3 }
        r0.zza(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x00a3 }
        r0 = r8.zzaOA;	 Catch:{ all -> 0x00a3 }
        r0 = r0 + -1;
        r8.zzaOA = r0;	 Catch:{ all -> 0x00a3 }
    L_0x00a1:
        monitor-exit(r8);	 Catch:{ all -> 0x00a3 }
        return;
    L_0x00a3:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x00a3 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqd.zzeo(java.lang.String):void");
    }

    private boolean zzep(String str) {
        return (TextUtils.isEmpty(str) || str.equals(this.zzaOx)) ? false : true;
    }

    private String zzi(String str, boolean z) {
        return this.zzaOy ? z ? str : this.zzaOx : this.zzaOx;
    }

    public void acquire(long j) {
        if (!zzlv.zzpR() && this.zzaOy) {
            Log.wtf(TAG, "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: " + this.zzafS);
        }
        zzen(null);
        this.zzaOu.acquire(j);
    }

    public boolean isHeld() {
        return this.zzaOu.isHeld();
    }

    public void release() {
        zzeo(null);
        this.zzaOu.release();
    }

    public void setReferenceCounted(boolean z) {
        this.zzaOu.setReferenceCounted(z);
        this.zzaOy = z;
    }

    public void zzc(WorkSource workSource) {
        if (zzma.zzaq(this.mContext) && workSource != null) {
            if (this.zzaOv != null) {
                this.zzaOv.add(workSource);
            } else {
                this.zzaOv = workSource;
            }
            this.zzaOu.setWorkSource(this.zzaOv);
        }
    }
}
