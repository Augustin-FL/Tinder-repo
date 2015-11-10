package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
    public static final zzh CREATOR;
    private final int mVersionCode;
    private float zzaGW;
    private int zzaGX;
    private int zzaGY;
    private float zzaGZ;
    private final List<LatLng> zzaHB;
    private final List<List<LatLng>> zzaHC;
    private boolean zzaHD;
    private boolean zzaHa;

    static {
        CREATOR = new zzh();
    }

    public PolygonOptions() {
        this.zzaGW = 10.0f;
        this.zzaGX = ViewCompat.MEASURED_STATE_MASK;
        this.zzaGY = 0;
        this.zzaGZ = 0.0f;
        this.zzaHa = true;
        this.zzaHD = false;
        this.mVersionCode = 1;
        this.zzaHB = new ArrayList();
        this.zzaHC = new ArrayList();
    }

    PolygonOptions(int i, List<LatLng> list, List list2, float f, int i2, int i3, float f2, boolean z, boolean z2) {
        this.zzaGW = 10.0f;
        this.zzaGX = ViewCompat.MEASURED_STATE_MASK;
        this.zzaGY = 0;
        this.zzaGZ = 0.0f;
        this.zzaHa = true;
        this.zzaHD = false;
        this.mVersionCode = i;
        this.zzaHB = list;
        this.zzaHC = list2;
        this.zzaGW = f;
        this.zzaGX = i2;
        this.zzaGY = i3;
        this.zzaGZ = f2;
        this.zzaHa = z;
        this.zzaHD = z2;
    }

    public PolygonOptions add(LatLng latLng) {
        this.zzaHB.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.zzaHB.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.zzaHB.add(add);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : iterable) {
            arrayList.add(add);
        }
        this.zzaHC.add(arrayList);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int i) {
        this.zzaGY = i;
        return this;
    }

    public PolygonOptions geodesic(boolean z) {
        this.zzaHD = z;
        return this;
    }

    public int getFillColor() {
        return this.zzaGY;
    }

    public List<List<LatLng>> getHoles() {
        return this.zzaHC;
    }

    public List<LatLng> getPoints() {
        return this.zzaHB;
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

    public boolean isGeodesic() {
        return this.zzaHD;
    }

    public boolean isVisible() {
        return this.zzaHa;
    }

    public PolygonOptions strokeColor(int i) {
        this.zzaGX = i;
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        this.zzaGW = f;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.zzaHa = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public PolygonOptions zIndex(float f) {
        this.zzaGZ = f;
        return this;
    }

    List zzxe() {
        return this.zzaHC;
    }
}
