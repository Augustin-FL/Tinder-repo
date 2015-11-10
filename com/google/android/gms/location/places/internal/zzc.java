package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzf.zzb;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.location.places.zzl.zza;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;

public class zzc implements GeoDataApi {

    /* renamed from: com.google.android.gms.location.places.internal.zzc.1 */
    class C12001 extends com.google.android.gms.location.places.zzl.zzc<zzd> {
        final /* synthetic */ AddPlaceRequest zzaEd;
        final /* synthetic */ zzc zzaEe;

        C12001(zzc com_google_android_gms_location_places_internal_zzc, com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc, GoogleApiClient googleApiClient, AddPlaceRequest addPlaceRequest) {
            this.zzaEe = com_google_android_gms_location_places_internal_zzc;
            this.zzaEd = addPlaceRequest;
            super(com_google_android_gms_common_api_Api_zzc, googleApiClient);
        }

        protected void zza(zzd com_google_android_gms_location_places_internal_zzd) throws RemoteException {
            com_google_android_gms_location_places_internal_zzd.zza(new zzl((com.google.android.gms.location.places.zzl.zzc) this, com_google_android_gms_location_places_internal_zzd.getContext()), this.zzaEd);
        }
    }

    /* renamed from: com.google.android.gms.location.places.internal.zzc.2 */
    class C12012 extends com.google.android.gms.location.places.zzl.zzc<zzd> {
        final /* synthetic */ zzc zzaEe;
        final /* synthetic */ String[] zzaEf;

        C12012(zzc com_google_android_gms_location_places_internal_zzc, com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc, GoogleApiClient googleApiClient, String[] strArr) {
            this.zzaEe = com_google_android_gms_location_places_internal_zzc;
            this.zzaEf = strArr;
            super(com_google_android_gms_common_api_Api_zzc, googleApiClient);
        }

        protected void zza(zzd com_google_android_gms_location_places_internal_zzd) throws RemoteException {
            com_google_android_gms_location_places_internal_zzd.zza(new zzl((com.google.android.gms.location.places.zzl.zzc) this, com_google_android_gms_location_places_internal_zzd.getContext()), Arrays.asList(this.zzaEf));
        }
    }

    /* renamed from: com.google.android.gms.location.places.internal.zzc.3 */
    class C12023 extends zza<zzd> {
        final /* synthetic */ zzc zzaEe;
        final /* synthetic */ LatLngBounds zzaEg;
        final /* synthetic */ AutocompleteFilter zzaEh;
        final /* synthetic */ String zzauM;

        C12023(zzc com_google_android_gms_location_places_internal_zzc, com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc, GoogleApiClient googleApiClient, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) {
            this.zzaEe = com_google_android_gms_location_places_internal_zzc;
            this.zzauM = str;
            this.zzaEg = latLngBounds;
            this.zzaEh = autocompleteFilter;
            super(com_google_android_gms_common_api_Api_zzc, googleApiClient);
        }

        protected void zza(zzd com_google_android_gms_location_places_internal_zzd) throws RemoteException {
            com_google_android_gms_location_places_internal_zzd.zza(new zzl((zza) this), this.zzauM, this.zzaEg, this.zzaEh);
        }
    }

    /* renamed from: com.google.android.gms.location.places.internal.zzc.4 */
    class C12034 extends zzb<zzd> {
        final /* synthetic */ zzc zzaEe;
        final /* synthetic */ String zzaEi;

        C12034(zzc com_google_android_gms_location_places_internal_zzc, com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc, GoogleApiClient googleApiClient, String str) {
            this.zzaEe = com_google_android_gms_location_places_internal_zzc;
            this.zzaEi = str;
            super(com_google_android_gms_common_api_Api_zzc, googleApiClient);
        }

        protected void zza(zzd com_google_android_gms_location_places_internal_zzd) throws RemoteException {
            com_google_android_gms_location_places_internal_zzd.zza(new zzf((zzb) this), this.zzaEi);
        }
    }

    public PendingResult<PlaceBuffer> addPlace(GoogleApiClient googleApiClient, AddPlaceRequest addPlaceRequest) {
        return googleApiClient.zzb(new C12001(this, Places.zzaDN, googleApiClient, addPlaceRequest));
    }

    public PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(GoogleApiClient googleApiClient, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) {
        return googleApiClient.zza(new C12023(this, Places.zzaDN, googleApiClient, str, latLngBounds, autocompleteFilter));
    }

    public PendingResult<PlaceBuffer> getPlaceById(GoogleApiClient googleApiClient, String... strArr) {
        boolean z = true;
        if (strArr == null || strArr.length < 1) {
            z = false;
        }
        zzx.zzZ(z);
        return googleApiClient.zza(new C12012(this, Places.zzaDN, googleApiClient, strArr));
    }

    public PendingResult<PlacePhotoMetadataResult> getPlacePhotos(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new C12034(this, Places.zzaDN, googleApiClient, str));
    }
}
