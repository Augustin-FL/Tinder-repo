package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
    public static final zzi CREATOR;
    private int mColor;
    private final int mVersionCode;
    private float zzaGZ;
    private final List<LatLng> zzaHB;
    private boolean zzaHD;
    private boolean zzaHa;
    private float zzaHe;

    static {
        CREATOR = new zzi();
    }

    public PolylineOptions() {
        this.zzaHe = 10.0f;
        this.mColor = ViewCompat.MEASURED_STATE_MASK;
        this.zzaGZ = 0.0f;
        this.zzaHa = true;
        this.zzaHD = false;
        this.mVersionCode = 1;
        this.zzaHB = new ArrayList();
    }

    PolylineOptions(int i, List list, float f, int i2, float f2, boolean z, boolean z2) {
        this.zzaHe = 10.0f;
        this.mColor = ViewCompat.MEASURED_STATE_MASK;
        this.zzaGZ = 0.0f;
        this.zzaHa = true;
        this.zzaHD = false;
        this.mVersionCode = i;
        this.zzaHB = list;
        this.zzaHe = f;
        this.mColor = i2;
        this.zzaGZ = f2;
        this.zzaHa = z;
        this.zzaHD = z2;
    }

    public PolylineOptions add(LatLng latLng) {
        this.zzaHB.add(latLng);
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        this.zzaHB.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.zzaHB.add(add);
        }
        return this;
    }

    public PolylineOptions color(int i) {
        this.mColor = i;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean z) {
        this.zzaHD = z;
        return this;
    }

    public int getColor() {
        return this.mColor;
    }

    public List<LatLng> getPoints() {
        return this.zzaHB;
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

    public boolean isGeodesic() {
        return this.zzaHD;
    }

    public boolean isVisible() {
        return this.zzaHa;
    }

    public PolylineOptions visible(boolean z) {
        this.zzaHa = z;
        return this;
    }

    public PolylineOptions width(float f) {
        this.zzaHe = f;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public PolylineOptions zIndex(float f) {
        this.zzaGZ = f;
        return this;
    }
}
