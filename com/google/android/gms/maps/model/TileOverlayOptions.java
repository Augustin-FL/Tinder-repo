package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzi;
import com.google.android.gms.maps.model.internal.zzi.zza;

public final class TileOverlayOptions implements SafeParcelable {
    public static final zzo CREATOR;
    private final int mVersionCode;
    private float zzaGZ;
    private zzi zzaHH;
    private TileProvider zzaHI;
    private boolean zzaHJ;
    private boolean zzaHa;

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions.1 */
    class C12291 implements TileProvider {
        private final zzi zzaHK;
        final /* synthetic */ TileOverlayOptions zzaHL;

        C12291(TileOverlayOptions tileOverlayOptions) {
            this.zzaHL = tileOverlayOptions;
            this.zzaHK = this.zzaHL.zzaHH;
        }

        public Tile getTile(int i, int i2, int i3) {
            try {
                return this.zzaHK.getTile(i, i2, i3);
            } catch (RemoteException e) {
                return null;
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions.2 */
    class C12302 extends zza {
        final /* synthetic */ TileOverlayOptions zzaHL;
        final /* synthetic */ TileProvider zzaHM;

        C12302(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
            this.zzaHL = tileOverlayOptions;
            this.zzaHM = tileProvider;
        }

        public Tile getTile(int i, int i2, int i3) {
            return this.zzaHM.getTile(i, i2, i3);
        }
    }

    static {
        CREATOR = new zzo();
    }

    public TileOverlayOptions() {
        this.zzaHa = true;
        this.zzaHJ = true;
        this.mVersionCode = 1;
    }

    TileOverlayOptions(int i, IBinder iBinder, boolean z, float f, boolean z2) {
        this.zzaHa = true;
        this.zzaHJ = true;
        this.mVersionCode = i;
        this.zzaHH = zza.zzcX(iBinder);
        this.zzaHI = this.zzaHH == null ? null : new C12291(this);
        this.zzaHa = z;
        this.zzaGZ = f;
        this.zzaHJ = z2;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean z) {
        this.zzaHJ = z;
        return this;
    }

    public boolean getFadeIn() {
        return this.zzaHJ;
    }

    public TileProvider getTileProvider() {
        return this.zzaHI;
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

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.zzaHI = tileProvider;
        this.zzaHH = this.zzaHI == null ? null : new C12302(this, tileProvider);
        return this;
    }

    public TileOverlayOptions visible(boolean z) {
        this.zzaHa = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }

    public TileOverlayOptions zIndex(float f) {
        this.zzaGZ = f;
        return this;
    }

    IBinder zzxf() {
        return this.zzaHH.asBinder();
    }
}
