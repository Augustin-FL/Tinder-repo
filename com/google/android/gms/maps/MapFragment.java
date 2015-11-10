package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment {
    private final zzb zzaFU;
    private GoogleMap zzaFV;

    static class zza implements MapLifecycleDelegate {
        private final IMapFragmentDelegate zzaFW;
        private final Fragment zzamZ;

        /* renamed from: com.google.android.gms.maps.MapFragment.zza.1 */
        class C12181 extends com.google.android.gms.maps.internal.zzl.zza {
            final /* synthetic */ OnMapReadyCallback zzaFX;
            final /* synthetic */ zza zzaFY;

            C12181(zza com_google_android_gms_maps_MapFragment_zza, OnMapReadyCallback onMapReadyCallback) {
                this.zzaFY = com_google_android_gms_maps_MapFragment_zza;
                this.zzaFX = onMapReadyCallback;
            }

            public void zza(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                this.zzaFX.onMapReady(new GoogleMap(iGoogleMapDelegate));
            }
        }

        public zza(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.zzaFW = (IMapFragmentDelegate) zzx.zzv(iMapFragmentDelegate);
            this.zzamZ = (Fragment) zzx.zzv(fragment);
        }

        public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            try {
                this.zzaFW.getMapAsync(new C12181(this, onMapReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle bundle) {
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.zzamZ.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                com.google.android.gms.maps.internal.zzx.zza(bundle, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.zzaFW.onCreate(bundle);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.zzp(this.zzaFW.onCreateView(zze.zzx(layoutInflater), zze.zzx(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.zzaFW.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.zzaFW.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.zzaFW.onInflate(zze.zzx(activity), (GoogleMapOptions) bundle.getParcelable("MapOptions"), bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.zzaFW.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.zzaFW.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaFW.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.zzaFW.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IMapFragmentDelegate zzwO() {
            return this.zzaFW;
        }
    }

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private Activity mActivity;
        protected zzf<zza> zzaFZ;
        private final List<OnMapReadyCallback> zzaGa;
        private final Fragment zzamZ;

        zzb(Fragment fragment) {
            this.zzaGa = new ArrayList();
            this.zzamZ = fragment;
        }

        private void setActivity(Activity activity) {
            this.mActivity = activity;
            zzwP();
        }

        public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            if (zzrn() != null) {
                ((zza) zzrn()).getMapAsync(onMapReadyCallback);
            } else {
                this.zzaGa.add(onMapReadyCallback);
            }
        }

        protected void zza(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_MapFragment_zza) {
            this.zzaFZ = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_MapFragment_zza;
            zzwP();
        }

        public void zzwP() {
            if (this.mActivity != null && this.zzaFZ != null && zzrn() == null) {
                try {
                    MapsInitializer.initialize(this.mActivity);
                    IMapFragmentDelegate zzt = zzy.zzaF(this.mActivity).zzt(zze.zzx(this.mActivity));
                    if (zzt != null) {
                        this.zzaFZ.zza(new zza(this.zzamZ, zzt));
                        for (OnMapReadyCallback mapAsync : this.zzaGa) {
                            ((zza) zzrn()).getMapAsync(mapAsync);
                        }
                        this.zzaGa.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapFragment() {
        this.zzaFU = new zzb(this);
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions googleMapOptions) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googleMapOptions);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    @Deprecated
    public final GoogleMap getMap() {
        IMapFragmentDelegate zzwO = zzwO();
        if (zzwO == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = zzwO.getMap();
            if (map == null) {
                return null;
            }
            if (this.zzaFV == null || this.zzaFV.zzwD().asBinder() != map.asBinder()) {
                this.zzaFV = new GoogleMap(map);
            }
            return this.zzaFV;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        zzx.zzch("getMapAsync must be called on the main thread.");
        this.zzaFU.getMapAsync(onMapReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.zzaFU.setActivity(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzaFU.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = this.zzaFU.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.setClickable(true);
        return onCreateView;
    }

    public void onDestroy() {
        this.zzaFU.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.zzaFU.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.zzaFU.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", createFromAttributes);
        this.zzaFU.onInflate(activity, bundle2, bundle);
    }

    public void onLowMemory() {
        this.zzaFU.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.zzaFU.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaFU.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.zzaFU.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }

    protected IMapFragmentDelegate zzwO() {
        this.zzaFU.zzwP();
        return this.zzaFU.zzrn() == null ? null : ((zza) this.zzaFU.zzrn()).zzwO();
    }
}
