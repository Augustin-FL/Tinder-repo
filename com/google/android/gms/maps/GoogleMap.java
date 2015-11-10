package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzh;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.zzc;
import com.google.android.gms.maps.model.internal.zzf;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate zzaFp;
    private UiSettings zzaFq;

    /* renamed from: com.google.android.gms.maps.GoogleMap.10 */
    class AnonymousClass10 extends com.google.android.gms.maps.internal.zzm.zza {
        final /* synthetic */ OnMarkerClickListener zzaFD;
        final /* synthetic */ GoogleMap zzaFs;

        AnonymousClass10(GoogleMap googleMap, OnMarkerClickListener onMarkerClickListener) {
            this.zzaFs = googleMap;
            this.zzaFD = onMarkerClickListener;
        }

        public boolean zza(zzf com_google_android_gms_maps_model_internal_zzf) {
            return this.zzaFD.onMarkerClick(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.11 */
    class AnonymousClass11 extends com.google.android.gms.maps.internal.zzn.zza {
        final /* synthetic */ OnMarkerDragListener zzaFE;
        final /* synthetic */ GoogleMap zzaFs;

        AnonymousClass11(GoogleMap googleMap, OnMarkerDragListener onMarkerDragListener) {
            this.zzaFs = googleMap;
            this.zzaFE = onMarkerDragListener;
        }

        public void zzb(zzf com_google_android_gms_maps_model_internal_zzf) {
            this.zzaFE.onMarkerDragStart(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }

        public void zzc(zzf com_google_android_gms_maps_model_internal_zzf) {
            this.zzaFE.onMarkerDragEnd(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }

        public void zzd(zzf com_google_android_gms_maps_model_internal_zzf) {
            this.zzaFE.onMarkerDrag(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.12 */
    class AnonymousClass12 extends com.google.android.gms.maps.internal.zzg.zza {
        final /* synthetic */ OnInfoWindowClickListener zzaFF;
        final /* synthetic */ GoogleMap zzaFs;

        AnonymousClass12(GoogleMap googleMap, OnInfoWindowClickListener onInfoWindowClickListener) {
            this.zzaFs = googleMap;
            this.zzaFF = onInfoWindowClickListener;
        }

        public void zze(zzf com_google_android_gms_maps_model_internal_zzf) {
            this.zzaFF.onInfoWindowClick(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.13 */
    class AnonymousClass13 extends com.google.android.gms.maps.internal.zzd.zza {
        final /* synthetic */ InfoWindowAdapter zzaFG;
        final /* synthetic */ GoogleMap zzaFs;

        AnonymousClass13(GoogleMap googleMap, InfoWindowAdapter infoWindowAdapter) {
            this.zzaFs = googleMap;
            this.zzaFG = infoWindowAdapter;
        }

        public zzd zzf(zzf com_google_android_gms_maps_model_internal_zzf) {
            return zze.zzx(this.zzaFG.getInfoWindow(new Marker(com_google_android_gms_maps_model_internal_zzf)));
        }

        public zzd zzg(zzf com_google_android_gms_maps_model_internal_zzf) {
            return zze.zzx(this.zzaFG.getInfoContents(new Marker(com_google_android_gms_maps_model_internal_zzf)));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.1 */
    class C12081 extends com.google.android.gms.maps.internal.zzf.zza {
        final /* synthetic */ OnIndoorStateChangeListener zzaFr;
        final /* synthetic */ GoogleMap zzaFs;

        C12081(GoogleMap googleMap, OnIndoorStateChangeListener onIndoorStateChangeListener) {
            this.zzaFs = googleMap;
            this.zzaFr = onIndoorStateChangeListener;
        }

        public void onIndoorBuildingFocused() {
            this.zzaFr.onIndoorBuildingFocused();
        }

        public void zza(com.google.android.gms.maps.model.internal.zzd com_google_android_gms_maps_model_internal_zzd) {
            this.zzaFr.onIndoorLevelActivated(new IndoorBuilding(com_google_android_gms_maps_model_internal_zzd));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.2 */
    class C12092 extends com.google.android.gms.maps.internal.zzp.zza {
        final /* synthetic */ GoogleMap zzaFs;
        final /* synthetic */ OnMyLocationChangeListener zzaFt;

        C12092(GoogleMap googleMap, OnMyLocationChangeListener onMyLocationChangeListener) {
            this.zzaFs = googleMap;
            this.zzaFt = onMyLocationChangeListener;
        }

        public void zzq(zzd com_google_android_gms_dynamic_zzd) {
            this.zzaFt.onMyLocationChange((Location) zze.zzp(com_google_android_gms_dynamic_zzd));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.3 */
    class C12103 extends com.google.android.gms.maps.internal.zzo.zza {
        final /* synthetic */ GoogleMap zzaFs;
        final /* synthetic */ OnMyLocationButtonClickListener zzaFu;

        C12103(GoogleMap googleMap, OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
            this.zzaFs = googleMap;
            this.zzaFu = onMyLocationButtonClickListener;
        }

        public boolean onMyLocationButtonClick() throws RemoteException {
            return this.zzaFu.onMyLocationButtonClick();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.4 */
    class C12114 extends com.google.android.gms.maps.internal.zzj.zza {
        final /* synthetic */ GoogleMap zzaFs;
        final /* synthetic */ OnMapLoadedCallback zzaFv;

        C12114(GoogleMap googleMap, OnMapLoadedCallback onMapLoadedCallback) {
            this.zzaFs = googleMap;
            this.zzaFv = onMapLoadedCallback;
        }

        public void onMapLoaded() throws RemoteException {
            this.zzaFv.onMapLoaded();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.5 */
    class C12125 extends com.google.android.gms.maps.internal.zzw.zza {
        final /* synthetic */ GoogleMap zzaFs;
        final /* synthetic */ SnapshotReadyCallback zzaFw;

        C12125(GoogleMap googleMap, SnapshotReadyCallback snapshotReadyCallback) {
            this.zzaFs = googleMap;
            this.zzaFw = snapshotReadyCallback;
        }

        public void onSnapshotReady(Bitmap bitmap) throws RemoteException {
            this.zzaFw.onSnapshotReady(bitmap);
        }

        public void zzr(zzd com_google_android_gms_dynamic_zzd) throws RemoteException {
            this.zzaFw.onSnapshotReady((Bitmap) zze.zzp(com_google_android_gms_dynamic_zzd));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.6 */
    class C12146 extends com.google.android.gms.maps.internal.ILocationSourceDelegate.zza {
        final /* synthetic */ GoogleMap zzaFs;
        final /* synthetic */ LocationSource zzaFx;

        /* renamed from: com.google.android.gms.maps.GoogleMap.6.1 */
        class C12131 implements OnLocationChangedListener {
            final /* synthetic */ zzh zzaFy;
            final /* synthetic */ C12146 zzaFz;

            C12131(C12146 c12146, zzh com_google_android_gms_maps_internal_zzh) {
                this.zzaFz = c12146;
                this.zzaFy = com_google_android_gms_maps_internal_zzh;
            }

            public void onLocationChanged(Location location) {
                try {
                    this.zzaFy.zzc(location);
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }

        C12146(GoogleMap googleMap, LocationSource locationSource) {
            this.zzaFs = googleMap;
            this.zzaFx = locationSource;
        }

        public void activate(zzh com_google_android_gms_maps_internal_zzh) {
            this.zzaFx.activate(new C12131(this, com_google_android_gms_maps_internal_zzh));
        }

        public void deactivate() {
            this.zzaFx.deactivate();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.7 */
    class C12157 extends com.google.android.gms.maps.internal.zze.zza {
        final /* synthetic */ OnCameraChangeListener zzaFA;
        final /* synthetic */ GoogleMap zzaFs;

        C12157(GoogleMap googleMap, OnCameraChangeListener onCameraChangeListener) {
            this.zzaFs = googleMap;
            this.zzaFA = onCameraChangeListener;
        }

        public void onCameraChange(CameraPosition cameraPosition) {
            this.zzaFA.onCameraChange(cameraPosition);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.8 */
    class C12168 extends com.google.android.gms.maps.internal.zzi.zza {
        final /* synthetic */ OnMapClickListener zzaFB;
        final /* synthetic */ GoogleMap zzaFs;

        C12168(GoogleMap googleMap, OnMapClickListener onMapClickListener) {
            this.zzaFs = googleMap;
            this.zzaFB = onMapClickListener;
        }

        public void onMapClick(LatLng latLng) {
            this.zzaFB.onMapClick(latLng);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.9 */
    class C12179 extends com.google.android.gms.maps.internal.zzk.zza {
        final /* synthetic */ OnMapLongClickListener zzaFC;
        final /* synthetic */ GoogleMap zzaFs;

        C12179(GoogleMap googleMap, OnMapLongClickListener onMapLongClickListener) {
            this.zzaFs = googleMap;
            this.zzaFC = onMapLongClickListener;
        }

        public void onMapLongClick(LatLng latLng) {
            this.zzaFC.onMapLongClick(latLng);
        }
    }

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    private static final class zza extends com.google.android.gms.maps.internal.zzb.zza {
        private final CancelableCallback zzaFH;

        zza(CancelableCallback cancelableCallback) {
            this.zzaFH = cancelableCallback;
        }

        public void onCancel() {
            this.zzaFH.onCancel();
        }

        public void onFinish() {
            this.zzaFH.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate iGoogleMapDelegate) {
        this.zzaFp = (IGoogleMapDelegate) zzx.zzv(iGoogleMapDelegate);
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return new Circle(this.zzaFp.addCircle(circleOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        try {
            zzc addGroundOverlay = this.zzaFp.addGroundOverlay(groundOverlayOptions);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        try {
            zzf addMarker = this.zzaFp.addMarker(markerOptions);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return new Polygon(this.zzaFp.addPolygon(polygonOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return new Polyline(this.zzaFp.addPolyline(polylineOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        try {
            com.google.android.gms.maps.model.internal.zzh addTileOverlay = this.zzaFp.addTileOverlay(tileOverlayOptions);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.zzaFp.animateCamera(cameraUpdate.zzwB());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) {
        try {
            this.zzaFp.animateCameraWithDurationAndCallback(cameraUpdate.zzwB(), i, cancelableCallback == null ? null : new zza(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            this.zzaFp.animateCameraWithCallback(cameraUpdate.zzwB(), cancelableCallback == null ? null : new zza(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.zzaFp.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.zzaFp.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            com.google.android.gms.maps.model.internal.zzd focusedBuilding = this.zzaFp.getFocusedBuilding();
            return focusedBuilding != null ? new IndoorBuilding(focusedBuilding) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.zzaFp.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.zzaFp.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.zzaFp.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.zzaFp.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.zzaFp.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.zzaFq == null) {
                this.zzaFq = new UiSettings(this.zzaFp.getUiSettings());
            }
            return this.zzaFq;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.zzaFp.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.zzaFp.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.zzaFp.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.zzaFp.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.zzaFp.moveCamera(cameraUpdate.zzwB());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        try {
            this.zzaFp.setBuildingsEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setContentDescription(String str) {
        try {
            this.zzaFp.setContentDescription(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean z) {
        try {
            return this.zzaFp.setIndoorEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            try {
                this.zzaFp.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setInfoWindowAdapter(new AnonymousClass13(this, infoWindowAdapter));
    }

    public final void setLocationSource(LocationSource locationSource) {
        if (locationSource == null) {
            try {
                this.zzaFp.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setLocationSource(new C12146(this, locationSource));
    }

    public final void setMapType(int i) {
        try {
            this.zzaFp.setMapType(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean z) {
        try {
            this.zzaFp.setMyLocationEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        if (onCameraChangeListener == null) {
            try {
                this.zzaFp.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnCameraChangeListener(new C12157(this, onCameraChangeListener));
    }

    public final void setOnIndoorStateChangeListener(OnIndoorStateChangeListener onIndoorStateChangeListener) {
        if (onIndoorStateChangeListener == null) {
            try {
                this.zzaFp.setOnIndoorStateChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnIndoorStateChangeListener(new C12081(this, onIndoorStateChangeListener));
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        if (onInfoWindowClickListener == null) {
            try {
                this.zzaFp.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnInfoWindowClickListener(new AnonymousClass12(this, onInfoWindowClickListener));
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        if (onMapClickListener == null) {
            try {
                this.zzaFp.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnMapClickListener(new C12168(this, onMapClickListener));
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        if (onMapLoadedCallback == null) {
            try {
                this.zzaFp.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnMapLoadedCallback(new C12114(this, onMapLoadedCallback));
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        if (onMapLongClickListener == null) {
            try {
                this.zzaFp.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnMapLongClickListener(new C12179(this, onMapLongClickListener));
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (onMarkerClickListener == null) {
            try {
                this.zzaFp.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnMarkerClickListener(new AnonymousClass10(this, onMarkerClickListener));
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        if (onMarkerDragListener == null) {
            try {
                this.zzaFp.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnMarkerDragListener(new AnonymousClass11(this, onMarkerDragListener));
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        if (onMyLocationButtonClickListener == null) {
            try {
                this.zzaFp.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnMyLocationButtonClickListener(new C12103(this, onMyLocationButtonClickListener));
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        if (onMyLocationChangeListener == null) {
            try {
                this.zzaFp.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnMyLocationChangeListener(new C12092(this, onMyLocationChangeListener));
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        try {
            this.zzaFp.setPadding(i, i2, i3, i4);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean z) {
        try {
            this.zzaFp.setTrafficEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        snapshot(snapshotReadyCallback, null);
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback, Bitmap bitmap) {
        try {
            this.zzaFp.snapshot(new C12125(this, snapshotReadyCallback), (zze) (bitmap != null ? zze.zzx(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.zzaFp.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IGoogleMapDelegate zzwD() {
        return this.zzaFp;
    }
}
