package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrl.zza;
import com.google.android.gms.internal.zzrx;

public class PutDataMapRequest {
    private final DataMap zzaYT;
    private final PutDataRequest zzaYU;

    private PutDataMapRequest(PutDataRequest putDataRequest, DataMap dataMap) {
        this.zzaYU = putDataRequest;
        this.zzaYT = new DataMap();
        if (dataMap != null) {
            this.zzaYT.putAll(dataMap);
        }
    }

    public static PutDataMapRequest create(String str) {
        return new PutDataMapRequest(PutDataRequest.create(str), null);
    }

    public static PutDataMapRequest createFromDataMapItem(DataMapItem dataMapItem) {
        return new PutDataMapRequest(PutDataRequest.zzo(dataMapItem.getUri()), dataMapItem.getDataMap());
    }

    public static PutDataMapRequest createWithAutoAppendedId(String str) {
        return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(str), null);
    }

    public PutDataRequest asPutDataRequest() {
        zza zza = zzrl.zza(this.zzaYT);
        this.zzaYU.setData(zzrx.zzf(zza.zzbbp));
        int size = zza.zzbbq.size();
        int i = 0;
        while (i < size) {
            String num = Integer.toString(i);
            Asset asset = (Asset) zza.zzbbq.get(i);
            if (num == null) {
                throw new IllegalStateException("asset key cannot be null: " + asset);
            } else if (asset == null) {
                throw new IllegalStateException("asset cannot be null: key=" + num);
            } else {
                if (Log.isLoggable(DataMap.TAG, 3)) {
                    Log.d(DataMap.TAG, "asPutDataRequest: adding asset: " + num + " " + asset);
                }
                this.zzaYU.putAsset(num, asset);
                i++;
            }
        }
        return this.zzaYU;
    }

    public DataMap getDataMap() {
        return this.zzaYT;
    }

    public Uri getUri() {
        return this.zzaYU.getUri();
    }
}
