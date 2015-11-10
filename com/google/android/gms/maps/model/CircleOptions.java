package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CircleOptions implements SafeParcelable {
    public static final zzb CREATOR;
    private final int mVersionCode;
    private LatLng zzaGU;
    private double zzaGV;
    private float zzaGW;
    private int zzaGX;
    private int zzaGY;
    private float zzaGZ;
    private boolean zzaHa;

    static {
        CREATOR = new zzb();
    }

    public CircleOptions() {
        this.zzaGU = null;
        this.zzaGV = 0.0d;
        this.zzaGW = 10.0f;
        this.zzaGX = ViewCompat.MEASURED_STATE_MASK;
        this.zzaGY = 0;
        this.zzaGZ = 0.0f;
        this.zzaHa = true;
        this.mVersionCode = 1;
    }

    CircleOptions(int i, LatLng latLng, double d, float f, int i2, int i3, float f2, boolean z) {
        this.zzaGU = null;
        this.zzaGV = 0.0d;
        this.zzaGW = 10.0f;
        this.zzaGX = ViewCompat.MEASURED_STATE_MASK;
        this.zzaGY = 0;
        this.zzaGZ = 0.0f;
        this.zzaHa = true;
        this.mVersionCode = i;
        this.zzaGU = latLng;
        this.zzaGV = d;
        this.zzaGW = f;
        this.zzaGX = i2;
        this.zzaGY = i3;
        this.zzaGZ = f2;
        this.zzaHa = z;
    }

    public CircleOptions center(LatLng latLng) {
        this.zzaGU = latLng;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int i) {
        this.zzaGY = i;
        return this;
    }

    public LatLng getCenter() {
        return this.zzaGU;
    }

    public int getFillColor() {
        return this.zzaGY;
    }

    public double getRadius() {
        return this.zzaGV;
    }

    public int getStrokeColor() {
        return this.zzaGX;
    }

    public float getStrokeWidth() {
        return this.zzaGW;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public float getZIndex() {
        return this.zzaGZ;
    }

    public boolean isVisible() {
        return this.zzaHa;
    }

    public CircleOptions radius(double d) {
        this.zzaGV = d;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.zzaGX = i;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.zzaGW = f;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.zzaHa = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public CircleOptions zIndex(float f) {
        this.zzaGZ = f;
        return this;
    }
}
