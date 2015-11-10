package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

final class zzbi implements ChannelListener {
    private final String zzaZM;
    private final ChannelListener zzbaR;

    zzbi(String str, ChannelListener channelListener) {
        this.zzaZM = (String) zzx.zzv(str);
        this.zzbaR = (ChannelListener) zzx.zzv(channelListener);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbi)) {
            return false;
        }
        zzbi com_google_android_gms_wearable_internal_zzbi = (zzbi) obj;
        return this.zzbaR.equals(com_google_android_gms_wearable_internal_zzbi.zzbaR) && this.zzaZM.equals(com_google_android_gms_wearable_internal_zzbi.zzaZM);
    }

    public int hashCode() {
        return (this.zzaZM.hashCode() * 31) + this.zzbaR.hashCode();
    }

    public void onChannelClosed(Channel channel, int i, int i2) {
        this.zzbaR.onChannelClosed(channel, i, i2);
    }

    public void onChannelOpened(Channel channel) {
        this.zzbaR.onChannelOpened(channel);
    }

    public void onInputClosed(Channel channel, int i, int i2) {
        this.zzbaR.onInputClosed(channel, i, i2);
    }

    public void onOutputClosed(Channel channel, int i, int i2) {
        this.zzbaR.onOutputClosed(channel, i, i2);
    }
}
