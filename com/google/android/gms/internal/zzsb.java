package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.facebook.stetho.BuildConfig;
import com.viewpagerindicator.C3169d.C3168f;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.LangUtils;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public interface zzsb {

    public static final class zza extends zzrr<zza> {
        public String[] zzbcv;
        public String[] zzbcw;
        public int[] zzbcx;
        public long[] zzbcy;

        public zza() {
            zzDy();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzsb_zza = (zza) obj;
            return (zzrv.equals(this.zzbcv, com_google_android_gms_internal_zzsb_zza.zzbcv) && zzrv.equals(this.zzbcw, com_google_android_gms_internal_zzsb_zza.zzbcw) && zzrv.equals(this.zzbcx, com_google_android_gms_internal_zzsb_zza.zzbcx) && zzrv.equals(this.zzbcy, com_google_android_gms_internal_zzsb_zza.zzbcy)) ? zza((zzrr) com_google_android_gms_internal_zzsb_zza) : false;
        }

        public int hashCode() {
            return ((((((((zzrv.hashCode(this.zzbcv) + 527) * 31) + zzrv.hashCode(this.zzbcw)) * 31) + zzrv.hashCode(this.zzbcx)) * 31) + zzrv.hashCode(this.zzbcy)) * 31) + zzDk();
        }

        protected int zzB() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int zzB = super.zzB();
            if (this.zzbcv == null || this.zzbcv.length <= 0) {
                i = zzB;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.zzbcv) {
                    if (str != null) {
                        i3++;
                        i2 += zzrq.zzfy(str);
                    }
                }
                i = (zzB + i2) + (i3 * 1);
            }
            if (this.zzbcw != null && this.zzbcw.length > 0) {
                i3 = 0;
                zzB = 0;
                for (String str2 : this.zzbcw) {
                    if (str2 != null) {
                        zzB++;
                        i3 += zzrq.zzfy(str2);
                    }
                }
                i = (i + i3) + (zzB * 1);
            }
            if (this.zzbcx != null && this.zzbcx.length > 0) {
                i3 = 0;
                for (int zzB2 : this.zzbcx) {
                    i3 += zzrq.zzls(zzB2);
                }
                i = (i + i3) + (this.zzbcx.length * 1);
            }
            if (this.zzbcy == null || this.zzbcy.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i4 < this.zzbcy.length) {
                i2 += zzrq.zzY(this.zzbcy[i4]);
                i4++;
            }
            return (i + i2) + (this.zzbcy.length * 1);
        }

        public zza zzB(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                int zzb;
                Object obj;
                int zzll;
                Object obj2;
                switch (zzCT) {
                    case C3374b.SmoothProgressBar_spbStyle /*0*/:
                        break;
                    case C3374b.SmoothProgressBar_spb_mirror_mode /*10*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 10);
                        zzCT = this.zzbcv == null ? 0 : this.zzbcv.length;
                        obj = new String[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzbcv, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.readString();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.readString();
                        this.zzbcv = obj;
                        continue;
                    case C3168f.Toolbar_collapseContentDescription /*18*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 18);
                        zzCT = this.zzbcw == null ? 0 : this.zzbcw.length;
                        obj = new String[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzbcw, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.readString();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.readString();
                        this.zzbcw = obj;
                        continue;
                    case C3168f.Theme_actionBarItemBackground /*24*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 24);
                        zzCT = this.zzbcx == null ? 0 : this.zzbcx.length;
                        obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzbcx, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zzbcx = obj;
                        continue;
                    case C3168f.Theme_actionMenuTextColor /*26*/:
                        zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zzbcx == null ? 0 : this.zzbcx.length;
                        obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzbcx, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zzbcx = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    case HTTP.SP /*32*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 32);
                        zzCT = this.zzbcy == null ? 0 : this.zzbcy.length;
                        obj = new long[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzbcy, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCV();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCV();
                        this.zzbcy = obj;
                        continue;
                    case C3168f.Theme_actionModePasteDrawable /*34*/:
                        zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCV();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zzbcy == null ? 0 : this.zzbcy.length;
                        obj2 = new long[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzbcy, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCV();
                            zzb++;
                        }
                        this.zzbcy = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzrp, zzCT)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zza zzDy() {
            this.zzbcv = zzsa.zzbcs;
            this.zzbcw = zzsa.zzbcs;
            this.zzbcx = zzsa.zzbcn;
            this.zzbcy = zzsa.zzbco;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            int i = 0;
            if (this.zzbcv != null && this.zzbcv.length > 0) {
                for (String str : this.zzbcv) {
                    if (str != null) {
                        com_google_android_gms_internal_zzrq.zzb(1, str);
                    }
                }
            }
            if (this.zzbcw != null && this.zzbcw.length > 0) {
                for (String str2 : this.zzbcw) {
                    if (str2 != null) {
                        com_google_android_gms_internal_zzrq.zzb(2, str2);
                    }
                }
            }
            if (this.zzbcx != null && this.zzbcx.length > 0) {
                for (int zzz : this.zzbcx) {
                    com_google_android_gms_internal_zzrq.zzz(3, zzz);
                }
            }
            if (this.zzbcy != null && this.zzbcy.length > 0) {
                while (i < this.zzbcy.length) {
                    com_google_android_gms_internal_zzrq.zzb(4, this.zzbcy[i]);
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzB(com_google_android_gms_internal_zzrp);
        }
    }

    public static final class zzb extends zzrr<zzb> {
        public String version;
        public String zzbcA;
        public int zzbcz;

        public zzb() {
            zzDz();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzsb_zzb = (zzb) obj;
            if (this.zzbcz != com_google_android_gms_internal_zzsb_zzb.zzbcz) {
                return false;
            }
            if (this.zzbcA == null) {
                if (com_google_android_gms_internal_zzsb_zzb.zzbcA != null) {
                    return false;
                }
            } else if (!this.zzbcA.equals(com_google_android_gms_internal_zzsb_zzb.zzbcA)) {
                return false;
            }
            if (this.version == null) {
                if (com_google_android_gms_internal_zzsb_zzb.version != null) {
                    return false;
                }
            } else if (!this.version.equals(com_google_android_gms_internal_zzsb_zzb.version)) {
                return false;
            }
            return zza((zzrr) com_google_android_gms_internal_zzsb_zzb);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbcA == null ? 0 : this.zzbcA.hashCode()) + ((this.zzbcz + 527) * 31)) * 31;
            if (this.version != null) {
                i = this.version.hashCode();
            }
            return ((hashCode + i) * 31) + zzDk();
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (this.zzbcz != 0) {
                zzB += zzrq.zzB(1, this.zzbcz);
            }
            if (!this.zzbcA.equals(BuildConfig.FLAVOR)) {
                zzB += zzrq.zzl(2, this.zzbcA);
            }
            return !this.version.equals(BuildConfig.FLAVOR) ? zzB + zzrq.zzl(3, this.version) : zzB;
        }

        public zzb zzC(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                switch (zzCT) {
                    case C3374b.SmoothProgressBar_spbStyle /*0*/:
                        break;
                    case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                        zzCT = com_google_android_gms_internal_zzrp.zzCW();
                        switch (zzCT) {
                            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                            case C3374b.SmoothProgressBar_spb_color /*1*/:
                            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                            case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                            case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                            case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                            case C3374b.SmoothProgressBar_spb_mirror_mode /*10*/:
                            case C3374b.SmoothProgressBar_spb_colors /*11*/:
                            case C3374b.SmoothProgressBar_spb_progressiveStart_activated /*12*/:
                            case C3374b.SmoothProgressBar_spb_background /*13*/:
                            case C3374b.SmoothProgressBar_spb_generate_background_with_colors /*14*/:
                            case C3168f.Toolbar_titleMarginBottom /*15*/:
                            case C3168f.Toolbar_maxButtonHeight /*16*/:
                            case LangUtils.HASH_SEED /*17*/:
                            case C3168f.Toolbar_collapseContentDescription /*18*/:
                            case C3168f.Toolbar_navigationIcon /*19*/:
                            case C3168f.Toolbar_navigationContentDescription /*20*/:
                            case C3168f.Theme_actionBarWidgetTheme /*21*/:
                            case C3168f.Theme_actionBarSize /*22*/:
                            case C3168f.Theme_actionBarDivider /*23*/:
                            case C3168f.Theme_actionBarItemBackground /*24*/:
                            case C3168f.Theme_actionMenuTextAppearance /*25*/:
                            case C3168f.Theme_actionMenuTextColor /*26*/:
                                this.zzbcz = zzCT;
                                break;
                            default:
                                continue;
                        }
                    case C3168f.Toolbar_collapseContentDescription /*18*/:
                        this.zzbcA = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    case C3168f.Theme_actionMenuTextColor /*26*/:
                        this.version = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzrp, zzCT)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzb zzDz() {
            this.zzbcz = 0;
            this.zzbcA = BuildConfig.FLAVOR;
            this.version = BuildConfig.FLAVOR;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            if (this.zzbcz != 0) {
                com_google_android_gms_internal_zzrq.zzz(1, this.zzbcz);
            }
            if (!this.zzbcA.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(2, this.zzbcA);
            }
            if (!this.version.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(3, this.version);
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzC(com_google_android_gms_internal_zzrp);
        }
    }

    public static final class zzc extends zzrr<zzc> {
        public byte[] zzbcB;
        public byte[][] zzbcC;
        public boolean zzbcD;

        public zzc() {
            zzDA();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzsb_zzc = (zzc) obj;
            return (Arrays.equals(this.zzbcB, com_google_android_gms_internal_zzsb_zzc.zzbcB) && zzrv.zza(this.zzbcC, com_google_android_gms_internal_zzsb_zzc.zzbcC) && this.zzbcD == com_google_android_gms_internal_zzsb_zzc.zzbcD) ? zza((zzrr) com_google_android_gms_internal_zzsb_zzc) : false;
        }

        public int hashCode() {
            return (((this.zzbcD ? 1231 : 1237) + ((((Arrays.hashCode(this.zzbcB) + 527) * 31) + zzrv.zza(this.zzbcC)) * 31)) * 31) + zzDk();
        }

        protected int zzB() {
            int i = 0;
            int zzB = super.zzB();
            if (!Arrays.equals(this.zzbcB, zzsa.zzbcu)) {
                zzB += zzrq.zzb(1, this.zzbcB);
            }
            if (this.zzbcC != null && this.zzbcC.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (i < this.zzbcC.length) {
                    byte[] bArr = this.zzbcC[i];
                    if (bArr != null) {
                        i3++;
                        i2 += zzrq.zzC(bArr);
                    }
                    i++;
                }
                zzB = (zzB + i2) + (i3 * 1);
            }
            return this.zzbcD ? zzB + zzrq.zzc(3, this.zzbcD) : zzB;
        }

        public zzc zzD(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                switch (zzCT) {
                    case C3374b.SmoothProgressBar_spbStyle /*0*/:
                        break;
                    case C3374b.SmoothProgressBar_spb_mirror_mode /*10*/:
                        this.zzbcB = com_google_android_gms_internal_zzrp.readBytes();
                        continue;
                    case C3168f.Toolbar_collapseContentDescription /*18*/:
                        int zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 18);
                        zzCT = this.zzbcC == null ? 0 : this.zzbcC.length;
                        Object obj = new byte[(zzb + zzCT)][];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzbcC, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.readBytes();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.readBytes();
                        this.zzbcC = obj;
                        continue;
                    case C3168f.Theme_actionBarItemBackground /*24*/:
                        this.zzbcD = com_google_android_gms_internal_zzrp.zzCX();
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzrp, zzCT)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzc zzDA() {
            this.zzbcB = zzsa.zzbcu;
            this.zzbcC = zzsa.zzbct;
            this.zzbcD = false;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            if (!Arrays.equals(this.zzbcB, zzsa.zzbcu)) {
                com_google_android_gms_internal_zzrq.zza(1, this.zzbcB);
            }
            if (this.zzbcC != null && this.zzbcC.length > 0) {
                for (byte[] bArr : this.zzbcC) {
                    if (bArr != null) {
                        com_google_android_gms_internal_zzrq.zza(2, bArr);
                    }
                }
            }
            if (this.zzbcD) {
                com_google_android_gms_internal_zzrq.zzb(3, this.zzbcD);
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzD(com_google_android_gms_internal_zzrp);
        }
    }

    public static final class zzd extends zzrr<zzd> {
        public String tag;
        public long zzbcE;
        public long zzbcF;
        public int zzbcG;
        public int zzbcH;
        public boolean zzbcI;
        public zze[] zzbcJ;
        public zzb zzbcK;
        public byte[] zzbcL;
        public byte[] zzbcM;
        public byte[] zzbcN;
        public zza zzbcO;
        public String zzbcP;
        public long zzbcQ;
        public zzc zzbcR;
        public byte[] zzbcS;
        public int zzbcT;
        public int[] zzbcU;

        public zzd() {
            zzDB();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzsb_zzd = (zzd) obj;
            if (this.zzbcE != com_google_android_gms_internal_zzsb_zzd.zzbcE || this.zzbcF != com_google_android_gms_internal_zzsb_zzd.zzbcF) {
                return false;
            }
            if (this.tag == null) {
                if (com_google_android_gms_internal_zzsb_zzd.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(com_google_android_gms_internal_zzsb_zzd.tag)) {
                return false;
            }
            if (this.zzbcG != com_google_android_gms_internal_zzsb_zzd.zzbcG || this.zzbcH != com_google_android_gms_internal_zzsb_zzd.zzbcH || this.zzbcI != com_google_android_gms_internal_zzsb_zzd.zzbcI || !zzrv.equals(this.zzbcJ, com_google_android_gms_internal_zzsb_zzd.zzbcJ)) {
                return false;
            }
            if (this.zzbcK == null) {
                if (com_google_android_gms_internal_zzsb_zzd.zzbcK != null) {
                    return false;
                }
            } else if (!this.zzbcK.equals(com_google_android_gms_internal_zzsb_zzd.zzbcK)) {
                return false;
            }
            if (!Arrays.equals(this.zzbcL, com_google_android_gms_internal_zzsb_zzd.zzbcL) || !Arrays.equals(this.zzbcM, com_google_android_gms_internal_zzsb_zzd.zzbcM) || !Arrays.equals(this.zzbcN, com_google_android_gms_internal_zzsb_zzd.zzbcN)) {
                return false;
            }
            if (this.zzbcO == null) {
                if (com_google_android_gms_internal_zzsb_zzd.zzbcO != null) {
                    return false;
                }
            } else if (!this.zzbcO.equals(com_google_android_gms_internal_zzsb_zzd.zzbcO)) {
                return false;
            }
            if (this.zzbcP == null) {
                if (com_google_android_gms_internal_zzsb_zzd.zzbcP != null) {
                    return false;
                }
            } else if (!this.zzbcP.equals(com_google_android_gms_internal_zzsb_zzd.zzbcP)) {
                return false;
            }
            if (this.zzbcQ != com_google_android_gms_internal_zzsb_zzd.zzbcQ) {
                return false;
            }
            if (this.zzbcR == null) {
                if (com_google_android_gms_internal_zzsb_zzd.zzbcR != null) {
                    return false;
                }
            } else if (!this.zzbcR.equals(com_google_android_gms_internal_zzsb_zzd.zzbcR)) {
                return false;
            }
            return (Arrays.equals(this.zzbcS, com_google_android_gms_internal_zzsb_zzd.zzbcS) && this.zzbcT == com_google_android_gms_internal_zzsb_zzd.zzbcT && zzrv.equals(this.zzbcU, com_google_android_gms_internal_zzsb_zzd.zzbcU)) ? zza((zzrr) com_google_android_gms_internal_zzsb_zzd) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzbcP == null ? 0 : this.zzbcP.hashCode()) + (((this.zzbcO == null ? 0 : this.zzbcO.hashCode()) + (((((((((this.zzbcK == null ? 0 : this.zzbcK.hashCode()) + (((((this.zzbcI ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((((int) (this.zzbcE ^ (this.zzbcE >>> 32))) + 527) * 31) + ((int) (this.zzbcF ^ (this.zzbcF >>> 32)))) * 31)) * 31) + this.zzbcG) * 31) + this.zzbcH) * 31)) * 31) + zzrv.hashCode(this.zzbcJ)) * 31)) * 31) + Arrays.hashCode(this.zzbcL)) * 31) + Arrays.hashCode(this.zzbcM)) * 31) + Arrays.hashCode(this.zzbcN)) * 31)) * 31)) * 31) + ((int) (this.zzbcQ ^ (this.zzbcQ >>> 32)))) * 31;
            if (this.zzbcR != null) {
                i = this.zzbcR.hashCode();
            }
            return ((((((((hashCode + i) * 31) + Arrays.hashCode(this.zzbcS)) * 31) + this.zzbcT) * 31) + zzrv.hashCode(this.zzbcU)) * 31) + zzDk();
        }

        protected int zzB() {
            int i;
            int i2 = 0;
            int zzB = super.zzB();
            if (this.zzbcE != 0) {
                zzB += zzrq.zzd(1, this.zzbcE);
            }
            if (!this.tag.equals(BuildConfig.FLAVOR)) {
                zzB += zzrq.zzl(2, this.tag);
            }
            if (this.zzbcJ != null && this.zzbcJ.length > 0) {
                i = zzB;
                for (zzrx com_google_android_gms_internal_zzrx : this.zzbcJ) {
                    if (com_google_android_gms_internal_zzrx != null) {
                        i += zzrq.zzc(3, com_google_android_gms_internal_zzrx);
                    }
                }
                zzB = i;
            }
            if (!Arrays.equals(this.zzbcL, zzsa.zzbcu)) {
                zzB += zzrq.zzb(6, this.zzbcL);
            }
            if (this.zzbcO != null) {
                zzB += zzrq.zzc(7, this.zzbcO);
            }
            if (!Arrays.equals(this.zzbcM, zzsa.zzbcu)) {
                zzB += zzrq.zzb(8, this.zzbcM);
            }
            if (this.zzbcK != null) {
                zzB += zzrq.zzc(9, this.zzbcK);
            }
            if (this.zzbcI) {
                zzB += zzrq.zzc(10, this.zzbcI);
            }
            if (this.zzbcG != 0) {
                zzB += zzrq.zzB(11, this.zzbcG);
            }
            if (this.zzbcH != 0) {
                zzB += zzrq.zzB(12, this.zzbcH);
            }
            if (!Arrays.equals(this.zzbcN, zzsa.zzbcu)) {
                zzB += zzrq.zzb(13, this.zzbcN);
            }
            if (!this.zzbcP.equals(BuildConfig.FLAVOR)) {
                zzB += zzrq.zzl(14, this.zzbcP);
            }
            if (this.zzbcQ != 180000) {
                zzB += zzrq.zze(15, this.zzbcQ);
            }
            if (this.zzbcR != null) {
                zzB += zzrq.zzc(16, this.zzbcR);
            }
            if (this.zzbcF != 0) {
                zzB += zzrq.zzd(17, this.zzbcF);
            }
            if (!Arrays.equals(this.zzbcS, zzsa.zzbcu)) {
                zzB += zzrq.zzb(18, this.zzbcS);
            }
            if (this.zzbcT != 0) {
                zzB += zzrq.zzB(19, this.zzbcT);
            }
            if (this.zzbcU == null || this.zzbcU.length <= 0) {
                return zzB;
            }
            i = 0;
            while (i2 < this.zzbcU.length) {
                i += zzrq.zzls(this.zzbcU[i2]);
                i2++;
            }
            return (zzB + i) + (this.zzbcU.length * 2);
        }

        public zzd zzDB() {
            this.zzbcE = 0;
            this.zzbcF = 0;
            this.tag = BuildConfig.FLAVOR;
            this.zzbcG = 0;
            this.zzbcH = 0;
            this.zzbcI = false;
            this.zzbcJ = zze.zzDC();
            this.zzbcK = null;
            this.zzbcL = zzsa.zzbcu;
            this.zzbcM = zzsa.zzbcu;
            this.zzbcN = zzsa.zzbcu;
            this.zzbcO = null;
            this.zzbcP = BuildConfig.FLAVOR;
            this.zzbcQ = 180000;
            this.zzbcR = null;
            this.zzbcS = zzsa.zzbcu;
            this.zzbcT = 0;
            this.zzbcU = zzsa.zzbcn;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public zzd zzE(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                int zzb;
                Object obj;
                switch (zzCT) {
                    case C3374b.SmoothProgressBar_spbStyle /*0*/:
                        break;
                    case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                        this.zzbcE = com_google_android_gms_internal_zzrp.zzCV();
                        continue;
                    case C3168f.Toolbar_collapseContentDescription /*18*/:
                        this.tag = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    case C3168f.Theme_actionMenuTextColor /*26*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 26);
                        zzCT = this.zzbcJ == null ? 0 : this.zzbcJ.length;
                        obj = new zze[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzbcJ, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new zze();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new zze();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zzbcJ = obj;
                        continue;
                    case C3168f.Theme_buttonBarStyle /*50*/:
                        this.zzbcL = com_google_android_gms_internal_zzrp.readBytes();
                        continue;
                    case C3168f.Theme_toolbarStyle /*58*/:
                        if (this.zzbcO == null) {
                            this.zzbcO = new zza();
                        }
                        com_google_android_gms_internal_zzrp.zza(this.zzbcO);
                        continue;
                    case C3168f.Theme_textColorSearchUrl /*66*/:
                        this.zzbcM = com_google_android_gms_internal_zzrp.readBytes();
                        continue;
                    case C3168f.Theme_listPopupWindowStyle /*74*/:
                        if (this.zzbcK == null) {
                            this.zzbcK = new zzb();
                        }
                        com_google_android_gms_internal_zzrp.zza(this.zzbcK);
                        continue;
                    case C3168f.Theme_listChoiceBackgroundIndicator /*80*/:
                        this.zzbcI = com_google_android_gms_internal_zzrp.zzCX();
                        continue;
                    case C3168f.Theme_colorSwitchThumbNormal /*88*/:
                        this.zzbcG = com_google_android_gms_internal_zzrp.zzCW();
                        continue;
                    case C3168f.Theme_buttonBarNeutralButtonStyle /*96*/:
                        this.zzbcH = com_google_android_gms_internal_zzrp.zzCW();
                        continue;
                    case C3168f.Theme_switchStyle /*106*/:
                        this.zzbcN = com_google_android_gms_internal_zzrp.readBytes();
                        continue;
                    case 114:
                        this.zzbcP = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    case 120:
                        this.zzbcQ = com_google_android_gms_internal_zzrp.zzCZ();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        if (this.zzbcR == null) {
                            this.zzbcR = new zzc();
                        }
                        com_google_android_gms_internal_zzrp.zza(this.zzbcR);
                        continue;
                    case 136:
                        this.zzbcF = com_google_android_gms_internal_zzrp.zzCV();
                        continue;
                    case 146:
                        this.zzbcS = com_google_android_gms_internal_zzrp.readBytes();
                        continue;
                    case 152:
                        zzCT = com_google_android_gms_internal_zzrp.zzCW();
                        switch (zzCT) {
                            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                            case C3374b.SmoothProgressBar_spb_color /*1*/:
                            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                                this.zzbcT = zzCT;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 160);
                        zzCT = this.zzbcU == null ? 0 : this.zzbcU.length;
                        obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzbcU, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zzbcU = obj;
                        continue;
                    case 162:
                        int zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zzbcU == null ? 0 : this.zzbcU.length;
                        Object obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzbcU, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zzbcU = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzrp, zzCT)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            int i = 0;
            if (this.zzbcE != 0) {
                com_google_android_gms_internal_zzrq.zzb(1, this.zzbcE);
            }
            if (!this.tag.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(2, this.tag);
            }
            if (this.zzbcJ != null && this.zzbcJ.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx : this.zzbcJ) {
                    if (com_google_android_gms_internal_zzrx != null) {
                        com_google_android_gms_internal_zzrq.zza(3, com_google_android_gms_internal_zzrx);
                    }
                }
            }
            if (!Arrays.equals(this.zzbcL, zzsa.zzbcu)) {
                com_google_android_gms_internal_zzrq.zza(6, this.zzbcL);
            }
            if (this.zzbcO != null) {
                com_google_android_gms_internal_zzrq.zza(7, this.zzbcO);
            }
            if (!Arrays.equals(this.zzbcM, zzsa.zzbcu)) {
                com_google_android_gms_internal_zzrq.zza(8, this.zzbcM);
            }
            if (this.zzbcK != null) {
                com_google_android_gms_internal_zzrq.zza(9, this.zzbcK);
            }
            if (this.zzbcI) {
                com_google_android_gms_internal_zzrq.zzb(10, this.zzbcI);
            }
            if (this.zzbcG != 0) {
                com_google_android_gms_internal_zzrq.zzz(11, this.zzbcG);
            }
            if (this.zzbcH != 0) {
                com_google_android_gms_internal_zzrq.zzz(12, this.zzbcH);
            }
            if (!Arrays.equals(this.zzbcN, zzsa.zzbcu)) {
                com_google_android_gms_internal_zzrq.zza(13, this.zzbcN);
            }
            if (!this.zzbcP.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(14, this.zzbcP);
            }
            if (this.zzbcQ != 180000) {
                com_google_android_gms_internal_zzrq.zzc(15, this.zzbcQ);
            }
            if (this.zzbcR != null) {
                com_google_android_gms_internal_zzrq.zza(16, this.zzbcR);
            }
            if (this.zzbcF != 0) {
                com_google_android_gms_internal_zzrq.zzb(17, this.zzbcF);
            }
            if (!Arrays.equals(this.zzbcS, zzsa.zzbcu)) {
                com_google_android_gms_internal_zzrq.zza(18, this.zzbcS);
            }
            if (this.zzbcT != 0) {
                com_google_android_gms_internal_zzrq.zzz(19, this.zzbcT);
            }
            if (this.zzbcU != null && this.zzbcU.length > 0) {
                while (i < this.zzbcU.length) {
                    com_google_android_gms_internal_zzrq.zzz(20, this.zzbcU[i]);
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzE(com_google_android_gms_internal_zzrp);
        }
    }

    public static final class zze extends zzrr<zze> {
        private static volatile zze[] zzbcV;
        public String key;
        public String value;

        public zze() {
            zzDD();
        }

        public static zze[] zzDC() {
            if (zzbcV == null) {
                synchronized (zzrv.zzbck) {
                    if (zzbcV == null) {
                        zzbcV = new zze[0];
                    }
                }
            }
            return zzbcV;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zzsb_zze = (zze) obj;
            if (this.key == null) {
                if (com_google_android_gms_internal_zzsb_zze.key != null) {
                    return false;
                }
            } else if (!this.key.equals(com_google_android_gms_internal_zzsb_zze.key)) {
                return false;
            }
            if (this.value == null) {
                if (com_google_android_gms_internal_zzsb_zze.value != null) {
                    return false;
                }
            } else if (!this.value.equals(com_google_android_gms_internal_zzsb_zze.value)) {
                return false;
            }
            return zza((zzrr) com_google_android_gms_internal_zzsb_zze);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.key == null ? 0 : this.key.hashCode()) + 527) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return ((hashCode + i) * 31) + zzDk();
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (!this.key.equals(BuildConfig.FLAVOR)) {
                zzB += zzrq.zzl(1, this.key);
            }
            return !this.value.equals(BuildConfig.FLAVOR) ? zzB + zzrq.zzl(2, this.value) : zzB;
        }

        public zze zzDD() {
            this.key = BuildConfig.FLAVOR;
            this.value = BuildConfig.FLAVOR;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public zze zzF(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                switch (zzCT) {
                    case C3374b.SmoothProgressBar_spbStyle /*0*/:
                        break;
                    case C3374b.SmoothProgressBar_spb_mirror_mode /*10*/:
                        this.key = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    case C3168f.Toolbar_collapseContentDescription /*18*/:
                        this.value = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    default:
                        if (!zza(com_google_android_gms_internal_zzrp, zzCT)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            if (!this.key.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(1, this.key);
            }
            if (!this.value.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(2, this.value);
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzF(com_google_android_gms_internal_zzrp);
        }
    }
}
