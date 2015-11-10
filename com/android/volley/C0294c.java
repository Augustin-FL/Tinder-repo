package com.android.volley;

/* renamed from: com.android.volley.c */
public class C0294c implements C0293k {
    private final int f227a;
    private final float f228b;
    private int f229c;
    private int f230d;

    public C0294c() {
        this(2500, 1, 1.0f);
    }

    public C0294c(int i, int i2, float f) {
        this.f229c = i;
        this.f227a = i2;
        this.f228b = f;
    }

    public int m258a() {
        return this.f229c;
    }

    public int m260b() {
        return this.f230d;
    }

    public void m259a(VolleyError volleyError) throws VolleyError {
        this.f230d++;
        this.f229c = (int) (((float) this.f229c) + (((float) this.f229c) * this.f228b));
        if (!m261c()) {
            throw volleyError;
        }
    }

    protected boolean m261c() {
        return this.f230d <= this.f227a;
    }
}
