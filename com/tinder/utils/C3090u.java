package com.tinder.utils;

import android.support.annotation.NonNull;
import com.google.android.m4b.maps.model.LatLng;

/* renamed from: com.tinder.utils.u */
public interface C3090u {

    /* renamed from: com.tinder.utils.u.a */
    public static class C3091a implements C3090u {
        @NonNull
        public LatLng m9459a(float f, @NonNull LatLng latLng, @NonNull LatLng latLng2) {
            return new LatLng(((latLng2.a - latLng.a) * ((double) f)) + latLng.a, ((latLng2.b - latLng.b) * ((double) f)) + latLng.b);
        }
    }

    @NonNull
    LatLng m9458a(float f, LatLng latLng, LatLng latLng2);
}
