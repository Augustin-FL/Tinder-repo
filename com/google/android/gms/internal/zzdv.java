package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@zzgk
public class zzdv {
    private final Context mContext;
    private final VersionInfoParcel zzpa;
    private final Object zzpc;
    private final String zzxF;
    private zzb<zzbb> zzxG;
    private zzb<zzbb> zzxH;
    private zze zzxI;
    private int zzxJ;

    public interface zzb<T> {
        void zzc(T t);
    }

    /* renamed from: com.google.android.gms.internal.zzdv.1 */
    class C10641 implements Runnable {
        final /* synthetic */ zze zzxK;
        final /* synthetic */ zzdv zzxL;

        /* renamed from: com.google.android.gms.internal.zzdv.1.1 */
        class C10591 implements com.google.android.gms.internal.zzbb.zza {
            final /* synthetic */ zzbb zzxM;
            final /* synthetic */ C10641 zzxN;

            /* renamed from: com.google.android.gms.internal.zzdv.1.1.1 */
            class C10581 extends TimerTask {
                final /* synthetic */ C10591 zzxO;

                /* renamed from: com.google.android.gms.internal.zzdv.1.1.1.1 */
                class C10571 implements Runnable {
                    final /* synthetic */ C10581 zzxP;

                    C10571(C10581 c10581) {
                        this.zzxP = c10581;
                    }

                    public void run() {
                        this.zzxP.zzxO.zzxM.destroy();
                    }
                }

                C10581(C10591 c10591) {
                    this.zzxO = c10591;
                }

                public void run() {
                    synchronized (this.zzxO.zzxN.zzxL.zzpc) {
                        if (this.zzxO.zzxN.zzxK.getStatus() == -1 || this.zzxO.zzxN.zzxK.getStatus() == 1) {
                            return;
                        }
                        this.zzxO.zzxN.zzxK.reject();
                        zzhu.runOnUiThread(new C10571(this));
                        com.google.android.gms.ads.internal.util.client.zzb.m1002v("Could not receive loaded message in a timely manner. Rejecting.");
                    }
                }
            }

            C10591(C10641 c10641, zzbb com_google_android_gms_internal_zzbb) {
                this.zzxN = c10641;
                this.zzxM = com_google_android_gms_internal_zzbb;
            }

            public void zzcj() {
                new Timer().schedule(new C10581(this), (long) zza.zzxU);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdv.1.2 */
        class C10602 implements zzdg {
            final /* synthetic */ zzbb zzxM;
            final /* synthetic */ C10641 zzxN;

            C10602(C10641 c10641, zzbb com_google_android_gms_internal_zzbb) {
                this.zzxN = c10641;
                this.zzxM = com_google_android_gms_internal_zzbb;
            }

            public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
                synchronized (this.zzxN.zzxL.zzpc) {
                    if (this.zzxN.zzxK.getStatus() == -1 || this.zzxN.zzxK.getStatus() == 1) {
                        return;
                    }
                    this.zzxN.zzxL.zzxJ = 0;
                    this.zzxN.zzxL.zzxG.zzc(this.zzxM);
                    this.zzxN.zzxK.zzg(this.zzxM);
                    this.zzxN.zzxL.zzxI = this.zzxN.zzxK;
                    com.google.android.gms.ads.internal.util.client.zzb.m1002v("Successfully loaded JS Engine.");
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdv.1.3 */
        class C10613 implements zzdg {
            final /* synthetic */ zzbb zzxM;
            final /* synthetic */ C10641 zzxN;
            final /* synthetic */ zzic zzxQ;

            C10613(C10641 c10641, zzbb com_google_android_gms_internal_zzbb, zzic com_google_android_gms_internal_zzic) {
                this.zzxN = c10641;
                this.zzxM = com_google_android_gms_internal_zzbb;
                this.zzxQ = com_google_android_gms_internal_zzic;
            }

            public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
                synchronized (this.zzxN.zzxL.zzpc) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaD("JS Engine is requesting an update");
                    if (this.zzxN.zzxL.zzxJ == 0) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaD("Starting reload.");
                        this.zzxN.zzxL.zzxJ = 2;
                        this.zzxN.zzxL.zzdK();
                    }
                    this.zzxM.zzb("/requestReload", (zzdg) this.zzxQ.get());
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdv.1.4 */
        class C10634 extends TimerTask {
            final /* synthetic */ zzbb zzxM;
            final /* synthetic */ C10641 zzxN;

            /* renamed from: com.google.android.gms.internal.zzdv.1.4.1 */
            class C10621 implements Runnable {
                final /* synthetic */ C10634 zzxR;

                C10621(C10634 c10634) {
                    this.zzxR = c10634;
                }

                public void run() {
                    this.zzxR.zzxM.destroy();
                }
            }

            C10634(C10641 c10641, zzbb com_google_android_gms_internal_zzbb) {
                this.zzxN = c10641;
                this.zzxM = com_google_android_gms_internal_zzbb;
            }

            public void run() {
                synchronized (this.zzxN.zzxL.zzpc) {
                    if (this.zzxN.zzxK.getStatus() == -1 || this.zzxN.zzxK.getStatus() == 1) {
                        return;
                    }
                    this.zzxN.zzxK.reject();
                    zzhu.runOnUiThread(new C10621(this));
                    com.google.android.gms.ads.internal.util.client.zzb.m1002v("Could not receive loaded message in a timely manner. Rejecting.");
                }
            }
        }

        C10641(zzdv com_google_android_gms_internal_zzdv, zze com_google_android_gms_internal_zzdv_zze) {
            this.zzxL = com_google_android_gms_internal_zzdv;
            this.zzxK = com_google_android_gms_internal_zzdv_zze;
        }

        public void run() {
            zzbb zza = this.zzxL.zza(this.zzxL.mContext, this.zzxL.zzpa);
            zza.zza(new C10591(this, zza));
            zza.zza("/jsLoaded", new C10602(this, zza));
            zzic com_google_android_gms_internal_zzic = new zzic();
            zzdg c10613 = new C10613(this, zza, com_google_android_gms_internal_zzic);
            com_google_android_gms_internal_zzic.set(c10613);
            zza.zza("/requestReload", c10613);
            if (this.zzxL.zzxF.endsWith(".js")) {
                zza.zzs(this.zzxL.zzxF);
            } else if (this.zzxL.zzxF.startsWith("<html>")) {
                zza.zzu(this.zzxL.zzxF);
            } else {
                zza.zzt(this.zzxL.zzxF);
            }
            new Timer().schedule(new C10634(this, zza), (long) zza.zzxT);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdv.2 */
    class C10652 implements com.google.android.gms.internal.zzij.zzc<zzbb> {
        final /* synthetic */ zzdv zzxL;
        final /* synthetic */ zze zzxS;

        C10652(zzdv com_google_android_gms_internal_zzdv, zze com_google_android_gms_internal_zzdv_zze) {
            this.zzxL = com_google_android_gms_internal_zzdv;
            this.zzxS = com_google_android_gms_internal_zzdv_zze;
        }

        public void zza(zzbb com_google_android_gms_internal_zzbb) {
            synchronized (this.zzxL.zzpc) {
                this.zzxL.zzxJ = 0;
                if (!(this.zzxL.zzxI == null || this.zzxS == this.zzxL.zzxI)) {
                    com.google.android.gms.ads.internal.util.client.zzb.m1002v("New JS engine is loaded, marking previous one as destroyable.");
                    this.zzxL.zzxI.zzdO();
                }
                this.zzxL.zzxI = this.zzxS;
            }
        }

        public /* synthetic */ void zzc(Object obj) {
            zza((zzbb) obj);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdv.3 */
    class C10663 implements com.google.android.gms.internal.zzij.zza {
        final /* synthetic */ zzdv zzxL;
        final /* synthetic */ zze zzxS;

        C10663(zzdv com_google_android_gms_internal_zzdv, zze com_google_android_gms_internal_zzdv_zze) {
            this.zzxL = com_google_android_gms_internal_zzdv;
            this.zzxS = com_google_android_gms_internal_zzdv_zze;
        }

        public void run() {
            synchronized (this.zzxL.zzpc) {
                this.zzxL.zzxJ = 1;
                com.google.android.gms.ads.internal.util.client.zzb.m1002v("Failed loading new engine. Marking new engine destroyable.");
                this.zzxS.zzdO();
            }
        }
    }

    static class zza {
        static int zzxT;
        static int zzxU;

        static {
            zzxT = 60000;
            zzxU = StatusCodes.AUTH_DISABLED;
        }
    }

    public static class zzc<T> implements zzb<T> {
        public void zzc(T t) {
        }
    }

    public static class zzd extends zzik<zzbe> {
        private final Object zzpc;
        private final zze zzxV;
        private boolean zzxW;

        /* renamed from: com.google.android.gms.internal.zzdv.zzd.1 */
        class C10671 implements com.google.android.gms.internal.zzij.zzc<zzbe> {
            final /* synthetic */ zzd zzxX;

            C10671(zzd com_google_android_gms_internal_zzdv_zzd) {
                this.zzxX = com_google_android_gms_internal_zzdv_zzd;
            }

            public void zzb(zzbe com_google_android_gms_internal_zzbe) {
                com.google.android.gms.ads.internal.util.client.zzb.m1002v("Ending javascript session.");
                ((zzbf) com_google_android_gms_internal_zzbe).zzck();
            }

            public /* synthetic */ void zzc(Object obj) {
                zzb((zzbe) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdv.zzd.2 */
        class C10682 implements com.google.android.gms.internal.zzij.zzc<zzbe> {
            final /* synthetic */ zzd zzxX;

            C10682(zzd com_google_android_gms_internal_zzdv_zzd) {
                this.zzxX = com_google_android_gms_internal_zzdv_zzd;
            }

            public void zzb(zzbe com_google_android_gms_internal_zzbe) {
                com.google.android.gms.ads.internal.util.client.zzb.m1002v("Releasing engine reference.");
                this.zzxX.zzxV.zzdN();
            }

            public /* synthetic */ void zzc(Object obj) {
                zzb((zzbe) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdv.zzd.3 */
        class C10693 implements com.google.android.gms.internal.zzij.zza {
            final /* synthetic */ zzd zzxX;

            C10693(zzd com_google_android_gms_internal_zzdv_zzd) {
                this.zzxX = com_google_android_gms_internal_zzdv_zzd;
            }

            public void run() {
                this.zzxX.zzxV.zzdN();
            }
        }

        public zzd(zze com_google_android_gms_internal_zzdv_zze) {
            this.zzpc = new Object();
            this.zzxV = com_google_android_gms_internal_zzdv_zze;
        }

        public void release() {
            synchronized (this.zzpc) {
                if (this.zzxW) {
                    return;
                }
                this.zzxW = true;
                zza(new C10671(this), new com.google.android.gms.internal.zzij.zzb());
                zza(new C10682(this), new C10693(this));
            }
        }
    }

    public static class zze extends zzik<zzbb> {
        private final Object zzpc;
        private zzb<zzbb> zzxH;
        private boolean zzxY;
        private int zzxZ;

        /* renamed from: com.google.android.gms.internal.zzdv.zze.1 */
        class C10701 implements com.google.android.gms.internal.zzij.zzc<zzbb> {
            final /* synthetic */ zzd zzya;
            final /* synthetic */ zze zzyb;

            C10701(zze com_google_android_gms_internal_zzdv_zze, zzd com_google_android_gms_internal_zzdv_zzd) {
                this.zzyb = com_google_android_gms_internal_zzdv_zze;
                this.zzya = com_google_android_gms_internal_zzdv_zzd;
            }

            public void zza(zzbb com_google_android_gms_internal_zzbb) {
                com.google.android.gms.ads.internal.util.client.zzb.m1002v("Getting a new session for JS Engine.");
                this.zzya.zzg(com_google_android_gms_internal_zzbb.zzci());
            }

            public /* synthetic */ void zzc(Object obj) {
                zza((zzbb) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdv.zze.2 */
        class C10712 implements com.google.android.gms.internal.zzij.zza {
            final /* synthetic */ zzd zzya;
            final /* synthetic */ zze zzyb;

            C10712(zze com_google_android_gms_internal_zzdv_zze, zzd com_google_android_gms_internal_zzdv_zzd) {
                this.zzyb = com_google_android_gms_internal_zzdv_zze;
                this.zzya = com_google_android_gms_internal_zzdv_zzd;
            }

            public void run() {
                com.google.android.gms.ads.internal.util.client.zzb.m1002v("Rejecting reference for JS Engine.");
                this.zzya.reject();
            }
        }

        /* renamed from: com.google.android.gms.internal.zzdv.zze.3 */
        class C10733 implements com.google.android.gms.internal.zzij.zzc<zzbb> {
            final /* synthetic */ zze zzyb;

            /* renamed from: com.google.android.gms.internal.zzdv.zze.3.1 */
            class C10721 implements Runnable {
                final /* synthetic */ zzbb zzrt;
                final /* synthetic */ C10733 zzyc;

                C10721(C10733 c10733, zzbb com_google_android_gms_internal_zzbb) {
                    this.zzyc = c10733;
                    this.zzrt = com_google_android_gms_internal_zzbb;
                }

                public void run() {
                    this.zzyc.zzyb.zzxH.zzc(this.zzrt);
                    this.zzrt.destroy();
                }
            }

            C10733(zze com_google_android_gms_internal_zzdv_zze) {
                this.zzyb = com_google_android_gms_internal_zzdv_zze;
            }

            public void zza(zzbb com_google_android_gms_internal_zzbb) {
                zzhu.runOnUiThread(new C10721(this, com_google_android_gms_internal_zzbb));
            }

            public /* synthetic */ void zzc(Object obj) {
                zza((zzbb) obj);
            }
        }

        public zze(zzb<zzbb> com_google_android_gms_internal_zzdv_zzb_com_google_android_gms_internal_zzbb) {
            this.zzpc = new Object();
            this.zzxH = com_google_android_gms_internal_zzdv_zzb_com_google_android_gms_internal_zzbb;
            this.zzxY = false;
            this.zzxZ = 0;
        }

        public zzd zzdM() {
            zzd com_google_android_gms_internal_zzdv_zzd = new zzd(this);
            synchronized (this.zzpc) {
                zza(new C10701(this, com_google_android_gms_internal_zzdv_zzd), new C10712(this, com_google_android_gms_internal_zzdv_zzd));
                zzx.zzY(this.zzxZ >= 0);
                this.zzxZ++;
            }
            return com_google_android_gms_internal_zzdv_zzd;
        }

        protected void zzdN() {
            boolean z = true;
            synchronized (this.zzpc) {
                if (this.zzxZ < 1) {
                    z = false;
                }
                zzx.zzY(z);
                com.google.android.gms.ads.internal.util.client.zzb.m1002v("Releasing 1 reference for JS Engine");
                this.zzxZ--;
                zzdP();
            }
        }

        public void zzdO() {
            boolean z = true;
            synchronized (this.zzpc) {
                if (this.zzxZ < 0) {
                    z = false;
                }
                zzx.zzY(z);
                com.google.android.gms.ads.internal.util.client.zzb.m1002v("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.zzxY = true;
                zzdP();
            }
        }

        protected void zzdP() {
            synchronized (this.zzpc) {
                zzx.zzY(this.zzxZ >= 0);
                if (this.zzxY && this.zzxZ == 0) {
                    com.google.android.gms.ads.internal.util.client.zzb.m1002v("No reference is left (including root). Cleaning up engine.");
                    zza(new C10733(this), new com.google.android.gms.internal.zzij.zzb());
                } else {
                    com.google.android.gms.ads.internal.util.client.zzb.m1002v("There are still references to the engine. Not destroying.");
                }
            }
        }
    }

    public zzdv(Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.zzpc = new Object();
        this.zzxJ = 1;
        this.zzxF = str;
        this.mContext = context.getApplicationContext();
        this.zzpa = versionInfoParcel;
        this.zzxG = new zzc();
        this.zzxH = new zzc();
    }

    public zzdv(Context context, VersionInfoParcel versionInfoParcel, String str, zzb<zzbb> com_google_android_gms_internal_zzdv_zzb_com_google_android_gms_internal_zzbb, zzb<zzbb> com_google_android_gms_internal_zzdv_zzb_com_google_android_gms_internal_zzbb2) {
        this(context, versionInfoParcel, str);
        this.zzxG = com_google_android_gms_internal_zzdv_zzb_com_google_android_gms_internal_zzbb;
        this.zzxH = com_google_android_gms_internal_zzdv_zzb_com_google_android_gms_internal_zzbb2;
    }

    private zze zzdJ() {
        zze com_google_android_gms_internal_zzdv_zze = new zze(this.zzxH);
        zzhu.runOnUiThread(new C10641(this, com_google_android_gms_internal_zzdv_zze));
        return com_google_android_gms_internal_zzdv_zze;
    }

    protected zzbb zza(Context context, VersionInfoParcel versionInfoParcel) {
        return new zzbd(context, versionInfoParcel, null);
    }

    protected zze zzdK() {
        zze zzdJ = zzdJ();
        zzdJ.zza(new C10652(this, zzdJ), new C10663(this, zzdJ));
        return zzdJ;
    }

    public zzd zzdL() {
        zzd zzdM;
        synchronized (this.zzpc) {
            if (this.zzxI == null || this.zzxI.getStatus() == -1) {
                this.zzxJ = 2;
                this.zzxI = zzdK();
                zzdM = this.zzxI.zzdM();
            } else if (this.zzxJ == 0) {
                zzdM = this.zzxI.zzdM();
            } else if (this.zzxJ == 1) {
                this.zzxJ = 2;
                zzdK();
                zzdM = this.zzxI.zzdM();
            } else if (this.zzxJ == 2) {
                zzdM = this.zzxI.zzdM();
            } else {
                zzdM = this.zzxI.zzdM();
            }
        }
        return zzdM;
    }
}
