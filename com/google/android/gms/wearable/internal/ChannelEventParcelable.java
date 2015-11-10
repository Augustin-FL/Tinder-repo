package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public final class ChannelEventParcelable implements SafeParcelable {
    public static final Creator<ChannelEventParcelable> CREATOR;
    final int mVersionCode;
    final int type;
    final int zzaZP;
    final int zzaZQ;
    final ChannelImpl zzaZR;

    static {
        CREATOR = new zzm();
    }

    ChannelEventParcelable(int i, ChannelImpl channelImpl, int i2, int i3, int i4) {
        this.mVersionCode = i;
        this.zzaZR = channelImpl;
        this.type = i2;
        this.zzaZP = i3;
        this.zzaZQ = i4;
    }

    private static String zzkB(int i) {
        switch (i) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return "CHANNEL_OPENED";
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return "CHANNEL_CLOSED";
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return "INPUT_CLOSED";
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                return "OUTPUT_CLOSED";
            default:
                return Integer.toString(i);
        }
    }

    private static String zzkC(int i) {
        switch (i) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return "CLOSE_REASON_NORMAL";
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return "CLOSE_REASON_DISCONNECTED";
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return "CLOSE_REASON_REMOTE_CLOSE";
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return "CLOSE_REASON_LOCAL_CLOSE";
            default:
                return Integer.toString(i);
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ChannelEventParcelable[versionCode=" + this.mVersionCode + ", channel=" + this.zzaZR + ", type=" + zzkB(this.type) + ", closeReason=" + zzkC(this.zzaZP) + ", appErrorCode=" + this.zzaZQ + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    public void zza(ChannelListener channelListener) {
        switch (this.type) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                channelListener.onChannelOpened(this.zzaZR);
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                channelListener.onChannelClosed(this.zzaZR, this.zzaZP, this.zzaZQ);
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                channelListener.onInputClosed(this.zzaZR, this.zzaZP, this.zzaZQ);
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                channelListener.onOutputClosed(this.zzaZR, this.zzaZP, this.zzaZQ);
            default:
                Log.w("ChannelEventParcelable", "Unknown type: " + this.type);
        }
    }
}
