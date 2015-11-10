package com.tinder.fragments;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;
import com.google.android.m4b.maps.C1479k;
import com.google.android.m4b.maps.a;
import com.google.android.m4b.maps.b;
import com.google.android.m4b.maps.c;
import com.google.android.m4b.maps.c$c;
import com.google.android.m4b.maps.c$d;
import com.google.android.m4b.maps.c$e;
import com.google.android.m4b.maps.l;
import com.google.android.m4b.maps.model.LatLng;
import com.google.android.m4b.maps.model.MarkerOptions;
import com.google.android.m4b.maps.model.o;
import com.tinder.R;
import com.tinder.activities.ActivityPassport;
import com.tinder.adapters.C2336f;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2898j;
import com.tinder.managers.ManagerApp;
import com.tinder.model.SparksEvent;
import com.tinder.model.TinderLocation;
import com.tinder.p030d.C2439z;
import com.tinder.p030d.bv;
import com.tinder.utils.C3090u;
import com.tinder.utils.C3090u.C3091a;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpStatus;

public class FragmentMap extends C1479k implements c$c, c$d, c$e, C2439z {
    private c f4768a;
    private C3090u f4769b;
    private C2336f f4770c;
    private List<o> f4771d;

    /* renamed from: com.tinder.fragments.FragmentMap.1 */
    class C25701 implements Runnable {
        final /* synthetic */ double f4752a;
        final /* synthetic */ double f4753b;
        final /* synthetic */ FragmentMap f4754c;

        C25701(FragmentMap fragmentMap, double d, double d2) {
            this.f4754c = fragmentMap;
            this.f4752a = d;
            this.f4753b = d2;
        }

        public void run() {
            SparksEvent sparksEvent = new SparksEvent("Passport.MapPinDrop");
            sparksEvent.put("pinLat", Double.valueOf(this.f4752a));
            sparksEvent.put("pinLon", Double.valueOf(this.f4753b));
            sparksEvent.put("myLocation", Boolean.valueOf(true));
            C2807a.m8056a(sparksEvent);
        }
    }

    /* renamed from: com.tinder.fragments.FragmentMap.2 */
    class C25712 implements Runnable {
        final /* synthetic */ LatLng f4755a;
        final /* synthetic */ TinderLocation f4756b;
        final /* synthetic */ FragmentMap f4757c;

        C25712(FragmentMap fragmentMap, LatLng latLng, TinderLocation tinderLocation) {
            this.f4757c = fragmentMap;
            this.f4755a = latLng;
            this.f4756b = tinderLocation;
        }

        public void run() {
            this.f4757c.m7084a(this.f4757c.m7080a(this.f4755a, false), this.f4756b);
        }
    }

    /* renamed from: com.tinder.fragments.FragmentMap.3 */
    class C25723 implements AnimatorUpdateListener {
        final /* synthetic */ o f4758a;
        final /* synthetic */ LatLng f4759b;
        final /* synthetic */ LatLng f4760c;
        final /* synthetic */ FragmentMap f4761d;

        C25723(FragmentMap fragmentMap, o oVar, LatLng latLng, LatLng latLng2) {
            this.f4761d = fragmentMap;
            this.f4758a = oVar;
            this.f4759b = latLng;
            this.f4760c = latLng2;
        }

        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            this.f4758a.a(this.f4761d.f4769b.m9458a(valueAnimator.getAnimatedFraction(), this.f4759b, this.f4760c));
        }
    }

    /* renamed from: com.tinder.fragments.FragmentMap.4 */
    class C25734 extends bv {
        final /* synthetic */ o f4762a;
        final /* synthetic */ FragmentMap f4763b;

        C25734(FragmentMap fragmentMap, o oVar) {
            this.f4763b = fragmentMap;
            this.f4762a = oVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f4762a.a(true);
            this.f4762a.d();
        }
    }

    /* renamed from: com.tinder.fragments.FragmentMap.5 */
    class C25745 implements Runnable {
        final /* synthetic */ LatLng f4764a;
        final /* synthetic */ FragmentMap f4765b;

        C25745(FragmentMap fragmentMap, LatLng latLng) {
            this.f4765b = fragmentMap;
            this.f4764a = latLng;
        }

        public void run() {
            SparksEvent sparksEvent = new SparksEvent("Passport.PinSelect");
            sparksEvent.put("newLat", Double.valueOf(this.f4764a.a));
            sparksEvent.put("newLon", Double.valueOf(this.f4764a.b));
            C2807a.m8056a(sparksEvent);
        }
    }

    /* renamed from: com.tinder.fragments.FragmentMap.6 */
    class C25756 implements Runnable {
        final /* synthetic */ LatLng f4766a;
        final /* synthetic */ FragmentMap f4767b;

        C25756(FragmentMap fragmentMap, LatLng latLng) {
            this.f4767b = fragmentMap;
            this.f4766a = latLng;
        }

        public void run() {
            SparksEvent sparksEvent = new SparksEvent("Passport.MapPinDrop");
            sparksEvent.put("pinLat", Double.valueOf(this.f4766a.a));
            sparksEvent.put("pinLon", Double.valueOf(this.f4766a.b));
            sparksEvent.put("myLocation", Boolean.valueOf(false));
            C2807a.m8056a(sparksEvent);
        }
    }

    public void onResume() {
        super.onResume();
        m7079e();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m7078d();
    }

    private void m7078d() {
        m7079e();
        this.f4769b = new C3091a();
        this.f4768a = m2291a();
        this.f4768a.a(3);
        l c = this.f4768a.c();
        c.b(true);
        c.a(false);
        c.c(true);
        this.f4768a.a(this);
        this.f4768a.a(this);
        this.f4768a.a(this);
        this.f4771d = new ArrayList();
        this.f4770c = new C2336f(ManagerApp.m7917h());
        this.f4768a.a(this.f4770c);
    }

    private void m7079e() {
        if (this.f4768a == null) {
            this.f4768a = ((C1479k) ((AppCompatActivity) getActivity()).getSupportFragmentManager().findFragmentById(R.id.fragment_map)).m2291a();
        }
    }

    public void m7087b() {
        double c = ManagerApp.m7913d().m8203c();
        double d = ManagerApp.m7913d().m8204d();
        LatLng latLng = new LatLng(c, d);
        AsyncTask.execute(new C25701(this, c, d));
        m7082a(latLng, HttpStatus.SC_BAD_REQUEST, true);
        C2898j.m8507a(latLng.a, latLng.b, this, m7080a(latLng, true));
    }

    public void m7082a(LatLng latLng, int i, boolean z) {
        a a;
        if (!z || this.f4768a.b().b >= 10.0f) {
            a = b.a(latLng);
        } else {
            a = b.a(latLng, 10.0f);
        }
        this.f4768a.a(a, i, null);
    }

    public void m7085a(@NonNull TinderLocation tinderLocation) {
        LatLng latLng = new LatLng(tinderLocation.getLatitude(), tinderLocation.getLongitude());
        m7082a(latLng, 850, true);
        new Handler().postDelayed(new C25712(this, latLng, tinderLocation), 850);
    }

    public o m7080a(LatLng latLng, boolean z) {
        m7089c();
        Point a = this.f4768a.d().a(latLng);
        a.y = 0;
        LatLng a2 = this.f4768a.d().a(a);
        if (z) {
            o a3 = this.f4768a.a(m7077b(a2));
            this.f4771d.add(a3);
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
            valueAnimator.setInterpolator(new DecelerateInterpolator());
            valueAnimator.setDuration(240);
            valueAnimator.addUpdateListener(new C25723(this, a3, a2, latLng));
            valueAnimator.addListener(new C25734(this, a3));
            valueAnimator.start();
            return a3;
        }
        a3 = this.f4768a.a(m7077b(latLng));
        this.f4771d.add(a3);
        a3.a(true);
        return a3;
    }

    public void m7084a(@Nullable o oVar, TinderLocation tinderLocation) {
        if (oVar != null && this.f4771d.contains(oVar)) {
            this.f4770c.m6380a(oVar, tinderLocation);
            if (oVar.c()) {
                oVar.d();
            }
        }
    }

    private MarkerOptions m7077b(LatLng latLng) {
        return new MarkerOptions().a(latLng).a(com.google.android.m4b.maps.model.b.a(R.drawable.passport_map_location_marker));
    }

    public void m7083a(@NonNull o oVar) {
        TinderLocation c = this.f4770c.m6382c(oVar);
        if (c.getCountryShort() == null || !c.getCountryShort().equals("\"Indeed...\"")) {
            AsyncTask.execute(new C25745(this, oVar.b()));
            ((ActivityPassport) getActivity()).m6268a(this.f4770c.m6382c(oVar));
            return;
        }
        Toast.makeText(getActivity(), "\"Indeed...\"", 0).show();
    }

    public void m7081a(@NonNull LatLng latLng) {
        this.f4768a.d().a(latLng);
        AsyncTask.execute(new C25756(this, latLng));
        m7082a(latLng, HttpStatus.SC_BAD_REQUEST, false);
        C2898j.m8507a(latLng.a, latLng.b, this, m7080a(latLng, true));
    }

    public void m7088b(@NonNull o oVar) {
        oVar.e();
    }

    public void m7090c(o oVar) {
    }

    public void m7091d(@NonNull o oVar) {
        LatLng b = oVar.b();
        m7082a(b, HttpStatus.SC_OK, false);
        this.f4770c.m6383d(oVar);
        oVar.d();
        C2898j.m8507a(b.a, b.b, this, oVar);
    }

    public void m7086a(TinderLocation tinderLocation, o oVar) {
        m7084a(oVar, tinderLocation);
    }

    public void m7092e(o oVar) {
        m7084a(oVar, new TinderLocation());
    }

    public void m7089c() {
        for (Object obj : this.f4771d) {
            obj.a();
            ManagerApp.m7915f().m5902a(obj);
        }
        this.f4771d.clear();
        this.f4770c.m6379a();
    }
}
