package com.google.android.m4b.maps.p011o;

import android.graphics.Color;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.m4b.maps.al.c;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.C1448m;
import com.google.android.m4b.maps.ay.ar;
import com.google.android.m4b.maps.bf.t;
import com.google.android.m4b.maps.bq.at;
import com.google.android.m4b.maps.model.CameraPosition;
import com.google.android.m4b.maps.model.CameraPosition.a;
import com.google.android.m4b.maps.model.LatLng;
import com.google.android.m4b.maps.model.LatLngBounds;
import com.google.android.m4b.maps.model.StreetViewPanoramaCamera;
import com.google.android.m4b.maps.model.StreetViewPanoramaLink;
import com.google.android.m4b.maps.p009m.C1485b;
import com.tinder.views.RangeSeekBar;

/* renamed from: com.google.android.m4b.maps.o.b */
public final class C1493b {
    public static C1485b m2358a(LatLng latLng) {
        return new C1485b(C1493b.m2354a(latLng.a), C1493b.m2354a(latLng.b));
    }

    public static C1440g m2363b(LatLng latLng) {
        return C1440g.m1923a(latLng.a, latLng.b);
    }

    public static LatLng m2360a(C1440g c1440g) {
        return new LatLng(c1440g.m1949b(), c1440g.m1953d());
    }

    public static CameraPosition m2359a(c cVar) {
        return new a().a(C1493b.m2360a(cVar.c())).a(cVar.a()).c(cVar.e()).b(cVar.d()).a();
    }

    public static int m2354a(double d) {
        return (int) Math.round(1000000.0d * d);
    }

    public static ar m2356a(LatLngBounds latLngBounds) {
        if (latLngBounds.b.b >= latLngBounds.a.b) {
            return ar.m1671a(new C1448m(C1493b.m2363b(latLngBounds.a), C1493b.m2363b(latLngBounds.b)));
        }
        return ar.m1671a(new C1448m(C1493b.m2363b(latLngBounds.a), C1493b.m2363b(latLngBounds.b).m1957e(new C1440g(1073741824, 0))));
    }

    public static int m2355a(int i) {
        int alpha = Color.alpha(i);
        return Color.argb(alpha, (Color.red(i) * alpha) / RangeSeekBar.INVALID_POINTER_ID, (Color.green(i) * alpha) / RangeSeekBar.INVALID_POINTER_ID, (Color.blue(i) * alpha) / RangeSeekBar.INVALID_POINTER_ID);
    }

    public static at m2357a(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        return new at(streetViewPanoramaCamera.c, (streetViewPanoramaCamera.b / BitmapDescriptorFactory.HUE_CYAN) + 0.5f, streetViewPanoramaCamera.a);
    }

    public static StreetViewPanoramaCamera m2361a(at atVar) {
        if (atVar == null) {
            return null;
        }
        return new StreetViewPanoramaCamera(atVar.e(), atVar.d(), atVar.b());
    }

    public static StreetViewPanoramaLink[] m2362a(t[] tVarArr) {
        if (tVarArr == null) {
            return null;
        }
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = new StreetViewPanoramaLink[tVarArr.length];
        for (int i = 0; i < tVarArr.length; i++) {
            streetViewPanoramaLinkArr[i] = new StreetViewPanoramaLink(tVarArr[i].c, tVarArr[i].a);
        }
        return streetViewPanoramaLinkArr;
    }
}
