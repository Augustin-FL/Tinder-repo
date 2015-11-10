package com.google.android.m4b.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.m4b.maps.by.q;
import com.google.android.m4b.maps.by.t;
import com.google.android.m4b.maps.k.a;
import com.google.android.m4b.maps.k.b;
import com.google.android.m4b.maps.model.RuntimeRemoteException;

/* renamed from: com.google.android.m4b.maps.k */
public class C1479k extends Fragment {
    private final b f1434a;
    private c f1435b;

    public C1479k() {
        this.f1434a = new b(this);
    }

    public final c m2291a() {
        this.f1434a.a();
        t f = this.f1434a.b() == null ? null : ((a) this.f1434a.b()).f();
        if (f == null) {
            return null;
        }
        try {
            q a = f.a();
            if (a == null) {
                return null;
            }
            if (this.f1435b == null || this.f1435b.a().asBinder() != a.asBinder()) {
                this.f1435b = new c(a);
            }
            return this.f1435b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        b.a(this.f1434a, activity);
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        b.a(this.f1434a, activity);
        GoogleMapOptions a = GoogleMapOptions.a(activity, attributeSet);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", a);
        this.f1434a.a(activity, bundle2, bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1434a.a(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f1434a.a(layoutInflater, viewGroup, bundle);
    }

    public void onResume() {
        super.onResume();
        this.f1434a.c();
    }

    public void onPause() {
        this.f1434a.d();
        super.onPause();
    }

    public void onDestroyView() {
        this.f1434a.e();
        super.onDestroyView();
    }

    public void onDestroy() {
        this.f1434a.f();
        super.onDestroy();
    }

    public void onLowMemory() {
        this.f1434a.g();
        super.onLowMemory();
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(C1479k.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(C1479k.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f1434a.b(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
