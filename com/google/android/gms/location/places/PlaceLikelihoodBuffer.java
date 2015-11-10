package com.google.android.gms.location.places;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.internal.zzm;
import com.viewpagerindicator.C3169d.C3168f;
import org.apache.http.HttpStatus;

public class PlaceLikelihoodBuffer extends AbstractDataBuffer<PlaceLikelihood> implements Result {
    private final Context mContext;
    private final Status zzQA;
    private final int zzaDD;
    private final String zzaDy;

    public static class zza {
        static int zzhb(int i) {
            switch (i) {
                case HttpStatus.SC_CONTINUE /*100*/:
                case HttpStatus.SC_SWITCHING_PROTOCOLS /*101*/:
                case HttpStatus.SC_PROCESSING /*102*/:
                case C3168f.Theme_radioButtonStyle /*103*/:
                case C3168f.Theme_ratingBarStyle /*104*/:
                case C3168f.Theme_spinnerStyle /*105*/:
                    return i;
                default:
                    throw new IllegalArgumentException("invalid source: " + i);
            }
        }
    }

    public PlaceLikelihoodBuffer(DataHolder dataHolder, int i, Context context) {
        super(dataHolder);
        this.mContext = context;
        this.zzQA = PlacesStatusCodes.zzhg(dataHolder.getStatusCode());
        this.zzaDD = zza.zzhb(i);
        if (dataHolder == null || dataHolder.zznP() == null) {
            this.zzaDy = null;
        } else {
            this.zzaDy = dataHolder.zznP().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    public PlaceLikelihood get(int i) {
        return new zzm(this.zzYX, i, this.mContext);
    }

    public CharSequence getAttributions() {
        return this.zzaDy;
    }

    public Status getStatus() {
        return this.zzQA;
    }

    public String toString() {
        return zzw.zzu(this).zzg(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, getStatus()).zzg("attributions", this.zzaDy).toString();
    }
}
