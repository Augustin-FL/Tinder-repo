package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;

public final class zzp extends OutputStream {
    private volatile zzl zzaZZ;
    private final OutputStream zzbab;

    /* renamed from: com.google.android.gms.wearable.internal.zzp.1 */
    class C13041 implements zzt {
        final /* synthetic */ zzp zzbac;

        C13041(zzp com_google_android_gms_wearable_internal_zzp) {
            this.zzbac = com_google_android_gms_wearable_internal_zzp;
        }

        public void zzb(zzl com_google_android_gms_wearable_internal_zzl) {
            this.zzbac.zzc(com_google_android_gms_wearable_internal_zzl);
        }
    }

    public zzp(OutputStream outputStream) {
        this.zzbab = (OutputStream) zzx.zzv(outputStream);
    }

    private IOException zza(IOException iOException) {
        zzl com_google_android_gms_wearable_internal_zzl = this.zzaZZ;
        if (com_google_android_gms_wearable_internal_zzl == null) {
            return iOException;
        }
        if (Log.isLoggable("ChannelOutputStream", 2)) {
            Log.v("ChannelOutputStream", "Caught IOException, but channel has been closed. Translating to ChannelIOException.", iOException);
        }
        return new ChannelIOException("Channel closed unexpectedly before stream was finished", com_google_android_gms_wearable_internal_zzl.zzaZP, com_google_android_gms_wearable_internal_zzl.zzaZQ);
    }

    public void close() throws IOException {
        try {
            this.zzbab.close();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void flush() throws IOException {
        try {
            this.zzbab.flush();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(int i) throws IOException {
        try {
            this.zzbab.write(i);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(byte[] bArr) throws IOException {
        try {
            this.zzbab.write(bArr);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.zzbab.write(bArr, i, i2);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    zzt zzCD() {
        return new C13041(this);
    }

    void zzc(zzl com_google_android_gms_wearable_internal_zzl) {
        this.zzaZZ = com_google_android_gms_wearable_internal_zzl;
    }
}
