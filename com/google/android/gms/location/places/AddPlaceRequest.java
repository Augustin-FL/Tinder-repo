package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddPlaceRequest implements SafeParcelable {
    public static final Creator<AddPlaceRequest> CREATOR;
    private final String mName;
    final int mVersionCode;
    private final LatLng zzaDh;
    private final List<Integer> zzaDi;
    private final String zzaDj;
    private final Uri zzaDk;
    private final String zzanu;

    static {
        CREATOR = new zzb();
    }

    AddPlaceRequest(int i, String str, LatLng latLng, String str2, List<Integer> list, String str3, Uri uri) {
        boolean z = false;
        this.mVersionCode = i;
        this.mName = zzx.zzcs(str);
        this.zzaDh = (LatLng) zzx.zzv(latLng);
        this.zzanu = zzx.zzcs(str2);
        this.zzaDi = new ArrayList((Collection) zzx.zzv(list));
        zzx.zzb(!this.zzaDi.isEmpty(), (Object) "At least one place type should be provided.");
        if (!(TextUtils.isEmpty(str3) && uri == null)) {
            z = true;
        }
        zzx.zzb(z, (Object) "One of phone number or URI should be provided.");
        this.zzaDj = str3;
        this.zzaDk = uri;
    }

    public AddPlaceRequest(String str, LatLng latLng, String str2, List<Integer> list, Uri uri) {
        this(str, latLng, str2, list, null, (Uri) zzx.zzv(uri));
    }

    public AddPlaceRequest(String str, LatLng latLng, String str2, List<Integer> list, String str3) {
        this(str, latLng, str2, list, zzx.zzcs(str3), null);
    }

    public AddPlaceRequest(String str, LatLng latLng, String str2, List<Integer> list, String str3, Uri uri) {
        this(0, str, latLng, str2, list, str3, uri);
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.zzanu;
    }

    public LatLng getLatLng() {
        return this.zzaDh;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.zzaDj;
    }

    public List<Integer> getPlaceTypes() {
        return this.zzaDi;
    }

    public Uri getWebsiteUri() {
        return this.zzaDk;
    }

    public String toString() {
        return zzw.zzu(this).zzg(ShareConstants.WEB_DIALOG_PARAM_NAME, this.mName).zzg("latLng", this.zzaDh).zzg("address", this.zzanu).zzg("placeTypes", this.zzaDi).zzg("phoneNumer", this.zzaDj).zzg("websiteUri", this.zzaDk).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
