package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd.zza;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final zzc CREATOR;
    public static final float NO_DIMENSION = -1.0f;
    private final int mVersionCode;
    private float zzaGS;
    private float zzaGZ;
    private boolean zzaHa;
    private BitmapDescriptor zzaHc;
    private LatLng zzaHd;
    private float zzaHe;
    private float zzaHf;
    private LatLngBounds zzaHg;
    private float zzaHh;
    private float zzaHi;
    private float zzaHj;

    static {
        CREATOR = new zzc();
    }

    public GroundOverlayOptions() {
        this.zzaHa = true;
        this.zzaHh = 0.0f;
        this.zzaHi = 0.5f;
        this.zzaHj = 0.5f;
        this.mVersionCode = 1;
    }

    GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.zzaHa = true;
        this.zzaHh = 0.0f;
        this.zzaHi = 0.5f;
        this.zzaHj = 0.5f;
        this.mVersionCode = i;
        this.zzaHc = new BitmapDescriptor(zza.zzbk(iBinder));
        this.zzaHd = latLng;
        this.zzaHe = f;
        this.zzaHf = f2;
        this.zzaHg = latLngBounds;
        this.zzaGS = f3;
        this.zzaGZ = f4;
        this.zzaHa = z;
        this.zzaHh = f5;
        this.zzaHi = f6;
        this.zzaHj = f7;
    }

    private GroundOverlayOptions zza(LatLng latLng, float f, float f2) {
        this.zzaHd = latLng;
        this.zzaHe = f;
        this.zzaHf = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        this.zzaHi = f;
        this.zzaHj = f2;
        return this;
    }

    public GroundOverlayOptions bearing(float f) {
        this.zzaGS = ((f % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.zzaHi;
    }

    public float getAnchorV() {
        return this.zzaHj;
    }

    public float getBearing() {
        return this.zzaGS;
    }

    public LatLngBounds getBounds() {
        return this.zzaHg;
    }

    public float getHeight() {
        return this.zzaHf;
    }

    public BitmapDescriptor getImage() {
        return this.zzaHc;
    }

    public LatLng getLocation() {
        return this.zzaHd;
    }

    public float getTransparency() {
        return this.zzaHh;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public float getWidth() {
        return this.zzaHe;
    }

    public float getZIndex() {
        return this.zzaGZ;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.zzaHc = bitmapDescriptor;
        return this;
    }

    public boolean isVisible() {
        return this.zzaHa;
    }

    public GroundOverlayOptions position(LatLng latLng, float f) {
        boolean z = true;
        zzx.zza(this.zzaHg == null, (Object) "Position has already been set using positionFromBounds");
        zzx.zzb(latLng != null, (Object) "Location must be specified");
        if (f < 0.0f) {
            z = false;
        }
        zzx.zzb(z, (Object) "Width must be non-negative");
        return zza(latLng, f, NO_DIMENSION);
    }

    public GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        boolean z = true;
        zzx.zza(this.zzaHg == null, (Object) "Position has already been set using positionFromBounds");
        zzx.zzb(latLng != null, (Object) "Location must be specified");
        zzx.zzb(f >= 0.0f, (Object) "Width must be non-negative");
        if (f2 < 0.0f) {
            z = false;
        }
        zzx.zzb(z, (Object) "Height must be non-negative");
        return zza(latLng, f, f2);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        zzx.zza(this.zzaHd == null, "Position has already been set using position: " + this.zzaHd);
        this.zzaHg = latLngBounds;
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        boolean z = f >= 0.0f && f <= 1.0f;
        zzx.zzb(z, (Object) "Transparency must be in the range [0..1]");
        this.zzaHh = f;
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.zzaHa = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public GroundOverlayOptions zIndex(float f) {
        this.zzaGZ = f;
        return this;
    }

    IBinder zzxc() {
        return this.zzaHc.zzwB().asBinder();
    }
}
