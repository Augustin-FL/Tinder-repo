package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0708R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final zza CREATOR;
    private final int mVersionCode;
    private Boolean zzaFI;
    private Boolean zzaFJ;
    private int zzaFK;
    private CameraPosition zzaFL;
    private Boolean zzaFM;
    private Boolean zzaFN;
    private Boolean zzaFO;
    private Boolean zzaFP;
    private Boolean zzaFQ;
    private Boolean zzaFR;
    private Boolean zzaFS;
    private Boolean zzaFT;

    static {
        CREATOR = new zza();
    }

    public GoogleMapOptions() {
        this.zzaFK = -1;
        this.mVersionCode = 1;
    }

    GoogleMapOptions(int i, byte b, byte b2, int i2, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10) {
        this.zzaFK = -1;
        this.mVersionCode = i;
        this.zzaFI = zza.zza(b);
        this.zzaFJ = zza.zza(b2);
        this.zzaFK = i2;
        this.zzaFL = cameraPosition;
        this.zzaFM = zza.zza(b3);
        this.zzaFN = zza.zza(b4);
        this.zzaFO = zza.zza(b5);
        this.zzaFP = zza.zza(b6);
        this.zzaFQ = zza.zza(b7);
        this.zzaFR = zza.zza(b8);
        this.zzaFS = zza.zza(b9);
        this.zzaFT = zza.zza(b10);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0708R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(C0708R.styleable.MapAttrs_mapType)) {
            googleMapOptions.mapType(obtainAttributes.getInt(C0708R.styleable.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(C0708R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(C0708R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(C0708R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(C0708R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(C0708R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(C0708R.styleable.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(C0708R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(C0708R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(C0708R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(C0708R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(C0708R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(C0708R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(C0708R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(C0708R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(C0708R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(C0708R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(C0708R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(obtainAttributes.getBoolean(C0708R.styleable.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(C0708R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(C0708R.styleable.MapAttrs_uiMapToolbar, true));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.zzaFL = cameraPosition;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean z) {
        this.zzaFN = Boolean.valueOf(z);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.zzaFL;
    }

    public Boolean getCompassEnabled() {
        return this.zzaFN;
    }

    public Boolean getLiteMode() {
        return this.zzaFS;
    }

    public Boolean getMapToolbarEnabled() {
        return this.zzaFT;
    }

    public int getMapType() {
        return this.zzaFK;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.zzaFR;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.zzaFO;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.zzaFQ;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzaFJ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public Boolean getZOrderOnTop() {
        return this.zzaFI;
    }

    public Boolean getZoomControlsEnabled() {
        return this.zzaFM;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzaFP;
    }

    public GoogleMapOptions liteMode(boolean z) {
        this.zzaFS = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapToolbarEnabled(boolean z) {
        this.zzaFT = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapType(int i) {
        this.zzaFK = i;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean z) {
        this.zzaFR = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean z) {
        this.zzaFO = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean z) {
        this.zzaFQ = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean z) {
        this.zzaFJ = Boolean.valueOf(z);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public GoogleMapOptions zOrderOnTop(boolean z) {
        this.zzaFI = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean z) {
        this.zzaFM = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean z) {
        this.zzaFP = Boolean.valueOf(z);
        return this;
    }

    byte zzwE() {
        return zza.zze(this.zzaFI);
    }

    byte zzwF() {
        return zza.zze(this.zzaFJ);
    }

    byte zzwG() {
        return zza.zze(this.zzaFM);
    }

    byte zzwH() {
        return zza.zze(this.zzaFN);
    }

    byte zzwI() {
        return zza.zze(this.zzaFO);
    }

    byte zzwJ() {
        return zza.zze(this.zzaFP);
    }

    byte zzwK() {
        return zza.zze(this.zzaFQ);
    }

    byte zzwL() {
        return zza.zze(this.zzaFR);
    }

    byte zzwM() {
        return zza.zze(this.zzaFS);
    }

    byte zzwN() {
        return zza.zze(this.zzaFT);
    }
}
