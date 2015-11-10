package com.google.android.gms.internal;

import com.facebook.stetho.BuildConfig;
import com.viewpagerindicator.C3169d.C3168f;
import java.io.IOException;
import org.apache.http.util.LangUtils;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public interface zzag {

    public static final class zza extends zzrr<zza> {
        private static volatile zza[] zziT;
        public int type;
        public String zziU;
        public zza[] zziV;
        public zza[] zziW;
        public zza[] zziX;
        public String zziY;
        public String zziZ;
        public long zzja;
        public boolean zzjb;
        public zza[] zzjc;
        public int[] zzjd;
        public boolean zzje;

        public zza() {
            zzR();
        }

        public static zza[] zzQ() {
            if (zziT == null) {
                synchronized (zzrv.zzbck) {
                    if (zziT == null) {
                        zziT = new zza[0];
                    }
                }
            }
            return zziT;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzag_zza = (zza) obj;
            if (this.type != com_google_android_gms_internal_zzag_zza.type) {
                return false;
            }
            if (this.zziU == null) {
                if (com_google_android_gms_internal_zzag_zza.zziU != null) {
                    return false;
                }
            } else if (!this.zziU.equals(com_google_android_gms_internal_zzag_zza.zziU)) {
                return false;
            }
            if (!zzrv.equals(this.zziV, com_google_android_gms_internal_zzag_zza.zziV) || !zzrv.equals(this.zziW, com_google_android_gms_internal_zzag_zza.zziW) || !zzrv.equals(this.zziX, com_google_android_gms_internal_zzag_zza.zziX)) {
                return false;
            }
            if (this.zziY == null) {
                if (com_google_android_gms_internal_zzag_zza.zziY != null) {
                    return false;
                }
            } else if (!this.zziY.equals(com_google_android_gms_internal_zzag_zza.zziY)) {
                return false;
            }
            if (this.zziZ == null) {
                if (com_google_android_gms_internal_zzag_zza.zziZ != null) {
                    return false;
                }
            } else if (!this.zziZ.equals(com_google_android_gms_internal_zzag_zza.zziZ)) {
                return false;
            }
            return (this.zzja == com_google_android_gms_internal_zzag_zza.zzja && this.zzjb == com_google_android_gms_internal_zzag_zza.zzjb && zzrv.equals(this.zzjc, com_google_android_gms_internal_zzag_zza.zzjc) && zzrv.equals(this.zzjd, com_google_android_gms_internal_zzag_zza.zzjd) && this.zzje == com_google_android_gms_internal_zzag_zza.zzje) ? zza((zzrr) com_google_android_gms_internal_zzag_zza) : false;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((this.zziY == null ? 0 : this.zziY.hashCode()) + (((((((((this.zziU == null ? 0 : this.zziU.hashCode()) + ((this.type + 527) * 31)) * 31) + zzrv.hashCode(this.zziV)) * 31) + zzrv.hashCode(this.zziW)) * 31) + zzrv.hashCode(this.zziX)) * 31)) * 31;
            if (this.zziZ != null) {
                i2 = this.zziZ.hashCode();
            }
            hashCode = ((((((this.zzjb ? 1231 : 1237) + ((((hashCode + i2) * 31) + ((int) (this.zzja ^ (this.zzja >>> 32)))) * 31)) * 31) + zzrv.hashCode(this.zzjc)) * 31) + zzrv.hashCode(this.zzjd)) * 31;
            if (!this.zzje) {
                i = 1237;
            }
            return ((hashCode + i) * 31) + zzDk();
        }

        protected int zzB() {
            int i;
            int i2 = 0;
            int zzB = super.zzB() + zzrq.zzB(1, this.type);
            if (!this.zziU.equals(BuildConfig.FLAVOR)) {
                zzB += zzrq.zzl(2, this.zziU);
            }
            if (this.zziV != null && this.zziV.length > 0) {
                i = zzB;
                for (zzrx com_google_android_gms_internal_zzrx : this.zziV) {
                    if (com_google_android_gms_internal_zzrx != null) {
                        i += zzrq.zzc(3, com_google_android_gms_internal_zzrx);
                    }
                }
                zzB = i;
            }
            if (this.zziW != null && this.zziW.length > 0) {
                i = zzB;
                for (zzrx com_google_android_gms_internal_zzrx2 : this.zziW) {
                    if (com_google_android_gms_internal_zzrx2 != null) {
                        i += zzrq.zzc(4, com_google_android_gms_internal_zzrx2);
                    }
                }
                zzB = i;
            }
            if (this.zziX != null && this.zziX.length > 0) {
                i = zzB;
                for (zzrx com_google_android_gms_internal_zzrx22 : this.zziX) {
                    if (com_google_android_gms_internal_zzrx22 != null) {
                        i += zzrq.zzc(5, com_google_android_gms_internal_zzrx22);
                    }
                }
                zzB = i;
            }
            if (!this.zziY.equals(BuildConfig.FLAVOR)) {
                zzB += zzrq.zzl(6, this.zziY);
            }
            if (!this.zziZ.equals(BuildConfig.FLAVOR)) {
                zzB += zzrq.zzl(7, this.zziZ);
            }
            if (this.zzja != 0) {
                zzB += zzrq.zzd(8, this.zzja);
            }
            if (this.zzje) {
                zzB += zzrq.zzc(9, this.zzje);
            }
            if (this.zzjd != null && this.zzjd.length > 0) {
                int i3 = 0;
                for (int zzls : this.zzjd) {
                    i3 += zzrq.zzls(zzls);
                }
                zzB = (zzB + i3) + (this.zzjd.length * 1);
            }
            if (this.zzjc != null && this.zzjc.length > 0) {
                while (i2 < this.zzjc.length) {
                    zzrx com_google_android_gms_internal_zzrx3 = this.zzjc[i2];
                    if (com_google_android_gms_internal_zzrx3 != null) {
                        zzB += zzrq.zzc(11, com_google_android_gms_internal_zzrx3);
                    }
                    i2++;
                }
            }
            return this.zzjb ? zzB + zzrq.zzc(12, this.zzjb) : zzB;
        }

        public zza zzR() {
            this.type = 1;
            this.zziU = BuildConfig.FLAVOR;
            this.zziV = zzQ();
            this.zziW = zzQ();
            this.zziX = zzQ();
            this.zziY = BuildConfig.FLAVOR;
            this.zziZ = BuildConfig.FLAVOR;
            this.zzja = 0;
            this.zzjb = false;
            this.zzjc = zzQ();
            this.zzjd = zzsa.zzbcn;
            this.zzje = false;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            int i = 0;
            com_google_android_gms_internal_zzrq.zzz(1, this.type);
            if (!this.zziU.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(2, this.zziU);
            }
            if (this.zziV != null && this.zziV.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx : this.zziV) {
                    if (com_google_android_gms_internal_zzrx != null) {
                        com_google_android_gms_internal_zzrq.zza(3, com_google_android_gms_internal_zzrx);
                    }
                }
            }
            if (this.zziW != null && this.zziW.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx2 : this.zziW) {
                    if (com_google_android_gms_internal_zzrx2 != null) {
                        com_google_android_gms_internal_zzrq.zza(4, com_google_android_gms_internal_zzrx2);
                    }
                }
            }
            if (this.zziX != null && this.zziX.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx22 : this.zziX) {
                    if (com_google_android_gms_internal_zzrx22 != null) {
                        com_google_android_gms_internal_zzrq.zza(5, com_google_android_gms_internal_zzrx22);
                    }
                }
            }
            if (!this.zziY.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(6, this.zziY);
            }
            if (!this.zziZ.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(7, this.zziZ);
            }
            if (this.zzja != 0) {
                com_google_android_gms_internal_zzrq.zzb(8, this.zzja);
            }
            if (this.zzje) {
                com_google_android_gms_internal_zzrq.zzb(9, this.zzje);
            }
            if (this.zzjd != null && this.zzjd.length > 0) {
                for (int zzz : this.zzjd) {
                    com_google_android_gms_internal_zzrq.zzz(10, zzz);
                }
            }
            if (this.zzjc != null && this.zzjc.length > 0) {
                while (i < this.zzjc.length) {
                    zzrx com_google_android_gms_internal_zzrx3 = this.zzjc[i];
                    if (com_google_android_gms_internal_zzrx3 != null) {
                        com_google_android_gms_internal_zzrq.zza(11, com_google_android_gms_internal_zzrx3);
                    }
                    i++;
                }
            }
            if (this.zzjb) {
                com_google_android_gms_internal_zzrq.zzb(12, this.zzjb);
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzl(com_google_android_gms_internal_zzrp);
        }

        public zza zzl(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                int zzb;
                Object obj;
                int i;
                switch (zzCT) {
                    case C3374b.SmoothProgressBar_spbStyle /*0*/:
                        break;
                    case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                        zzCT = com_google_android_gms_internal_zzrp.zzCW();
                        switch (zzCT) {
                            case C3374b.SmoothProgressBar_spb_color /*1*/:
                            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                            case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                            case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                                this.type = zzCT;
                                break;
                            default:
                                continue;
                        }
                    case C3168f.Toolbar_collapseContentDescription /*18*/:
                        this.zziU = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    case C3168f.Theme_actionMenuTextColor /*26*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 26);
                        zzCT = this.zziV == null ? 0 : this.zziV.length;
                        obj = new zza[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziV, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new zza();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new zza();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zziV = obj;
                        continue;
                    case C3168f.Theme_actionModePasteDrawable /*34*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 34);
                        zzCT = this.zziW == null ? 0 : this.zziW.length;
                        obj = new zza[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziW, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new zza();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new zza();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zziW = obj;
                        continue;
                    case C3168f.Theme_dialogTheme /*42*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 42);
                        zzCT = this.zziX == null ? 0 : this.zziX.length;
                        obj = new zza[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziX, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new zza();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new zza();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zziX = obj;
                        continue;
                    case C3168f.Theme_buttonBarStyle /*50*/:
                        this.zziY = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    case C3168f.Theme_toolbarStyle /*58*/:
                        this.zziZ = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    case C3168f.Theme_textAppearanceSearchResultTitle /*64*/:
                        this.zzja = com_google_android_gms_internal_zzrp.zzCV();
                        continue;
                    case C3168f.Theme_listPreferredItemPaddingRight /*72*/:
                        this.zzje = com_google_android_gms_internal_zzrp.zzCX();
                        continue;
                    case C3168f.Theme_listChoiceBackgroundIndicator /*80*/:
                        int zzb2 = zzsa.zzb(com_google_android_gms_internal_zzrp, 80);
                        Object obj2 = new int[zzb2];
                        i = 0;
                        zzb = 0;
                        while (i < zzb2) {
                            if (i != 0) {
                                com_google_android_gms_internal_zzrp.zzCT();
                            }
                            int zzCW = com_google_android_gms_internal_zzrp.zzCW();
                            switch (zzCW) {
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
                                    zzCT = zzb + 1;
                                    obj2[zzb] = zzCW;
                                    break;
                                default:
                                    zzCT = zzb;
                                    break;
                            }
                            i++;
                            zzb = zzCT;
                        }
                        if (zzb != 0) {
                            zzCT = this.zzjd == null ? 0 : this.zzjd.length;
                            if (zzCT != 0 || zzb != obj2.length) {
                                Object obj3 = new int[(zzCT + zzb)];
                                if (zzCT != 0) {
                                    System.arraycopy(this.zzjd, 0, obj3, 0, zzCT);
                                }
                                System.arraycopy(obj2, 0, obj3, zzCT, zzb);
                                this.zzjd = obj3;
                                break;
                            }
                            this.zzjd = obj2;
                            break;
                        }
                        continue;
                    case C3168f.Theme_colorPrimaryDark /*82*/:
                        i = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            switch (com_google_android_gms_internal_zzrp.zzCW()) {
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
                                    zzCT++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (zzCT != 0) {
                            com_google_android_gms_internal_zzrp.zzln(zzb);
                            zzb = this.zzjd == null ? 0 : this.zzjd.length;
                            Object obj4 = new int[(zzCT + zzb)];
                            if (zzb != 0) {
                                System.arraycopy(this.zzjd, 0, obj4, 0, zzb);
                            }
                            while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                                int zzCW2 = com_google_android_gms_internal_zzrp.zzCW();
                                switch (zzCW2) {
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
                                        zzCT = zzb + 1;
                                        obj4[zzb] = zzCW2;
                                        zzb = zzCT;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.zzjd = obj4;
                        }
                        com_google_android_gms_internal_zzrp.zzlm(i);
                        continue;
                    case C3168f.Theme_alertDialogButtonGroupStyle /*90*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 90);
                        zzCT = this.zzjc == null ? 0 : this.zzjc.length;
                        obj = new zza[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzjc, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new zza();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new zza();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zzjc = obj;
                        continue;
                    case C3168f.Theme_buttonBarNeutralButtonStyle /*96*/:
                        this.zzjb = com_google_android_gms_internal_zzrp.zzCX();
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
    }
}
