package com.tinder.managers;

import com.tinder.utils.C3095y;

/* renamed from: com.tinder.managers.o */
public class C2957o {
    private final C2958p f6253a;
    private boolean f6254b;
    private boolean f6255c;
    private boolean f6256d;
    private boolean f6257e;
    private boolean f6258f;
    private boolean f6259g;
    private float f6260h;
    private int f6261i;
    private int f6262j;
    private boolean f6263k;
    private boolean f6264l;
    private boolean f6265m;
    private boolean f6266n;
    private boolean f6267o;

    public C2957o() {
        C3095y.m9469a();
        this.f6253a = ManagerApp.m7914e();
        this.f6254b = this.f6253a.m8809M();
        this.f6263k = this.f6253a.m8813Q();
        this.f6264l = this.f6253a.m8814R();
        this.f6265m = this.f6253a.m8876u();
        this.f6266n = this.f6253a.m8880w();
        this.f6256d = this.f6253a.m8868q();
        this.f6257e = this.f6253a.m8870r();
        this.f6258f = this.f6253a.m8872s();
        this.f6259g = this.f6253a.m8874t();
        this.f6260h = this.f6253a.m8812P();
        this.f6262j = this.f6253a.m8811O();
        this.f6261i = this.f6253a.m8810N();
        this.f6255c = this.f6253a.m8807K();
        this.f6267o = this.f6253a.m8808L();
    }

    public boolean m8754a() {
        return this.f6259g;
    }

    public boolean m8757b() {
        return this.f6256d;
    }

    public void m8753a(boolean z) {
        this.f6256d = z;
        this.f6253a.m8853j(z);
    }

    public boolean m8759c() {
        return this.f6257e;
    }

    public void m8756b(boolean z) {
        this.f6257e = z;
        this.f6253a.m8856k(z);
    }

    public boolean m8761d() {
        return this.f6258f;
    }

    public void m8758c(boolean z) {
        this.f6258f = z;
        this.f6253a.m8858l(z);
    }

    public boolean m8763e() {
        return this.f6265m;
    }

    public void m8760d(boolean z) {
        this.f6265m = z;
        this.f6253a.m8860m(z);
    }

    public boolean m8765f() {
        return this.f6254b;
    }

    public void m8762e(boolean z) {
        this.f6254b = z;
        this.f6253a.m8873t(z);
    }

    public float m8766g() {
        C3095y.m9471a("distance=" + this.f6260h);
        return this.f6260h;
    }

    public void m8751a(float f) {
        C3095y.m9471a("distanceInMiles=" + f);
        this.f6260h = f;
        this.f6253a.m8824a(f);
    }

    public int m8768h() {
        return this.f6261i;
    }

    public void m8752a(int i) {
        this.f6261i = i;
        this.f6253a.m8834c(this.f6261i);
    }

    public int m8770i() {
        return this.f6262j;
    }

    public void m8755b(int i) {
        this.f6262j = i;
        this.f6253a.m8836d(i);
    }

    public void m8764f(boolean z) {
        C3095y.m9471a("areFemalesLiked=" + z);
        this.f6263k = z;
        this.f6253a.m8878v(z);
    }

    public boolean m8773j() {
        C3095y.m9471a("areFemalesLiked=" + this.f6263k);
        return this.f6263k;
    }

    public void m8767g(boolean z) {
        this.f6264l = z;
        this.f6253a.m8879w(z);
    }

    public boolean m8774k() {
        return this.f6264l;
    }

    public boolean m8775l() {
        return this.f6266n;
    }

    public void m8769h(boolean z) {
        this.f6266n = z;
        this.f6253a.m8862n(this.f6266n);
    }

    public boolean m8776m() {
        return this.f6255c;
    }

    public void m8771i(boolean z) {
        this.f6255c = z;
        this.f6253a.m8869r(z);
    }

    public boolean m8777n() {
        return this.f6267o;
    }

    public void m8772j(boolean z) {
        this.f6267o = z;
        this.f6253a.m8871s(z);
    }
}
