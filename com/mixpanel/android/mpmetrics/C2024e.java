package com.mixpanel.android.mpmetrics;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.mixpanel.android.mpmetrics.e */
class C2024e {
    private final String f2832a;
    private final String f2833b;
    private final Set<Integer> f2834c;
    private final Set<Integer> f2835d;
    private final List<Survey> f2836e;
    private final List<InAppNotification> f2837f;
    private final C2023a f2838g;
    private final AtomicBoolean f2839h;

    /* renamed from: com.mixpanel.android.mpmetrics.e.a */
    public interface C2023a {
        void m4712a(String str);
    }

    public C2024e(String str, String str2, C2023a c2023a) {
        this.f2832a = str;
        this.f2833b = str2;
        this.f2838g = c2023a;
        this.f2836e = new LinkedList();
        this.f2837f = new LinkedList();
        this.f2834c = new HashSet();
        this.f2835d = new HashSet();
        this.f2839h = new AtomicBoolean(false);
    }

    public String m4714a() {
        return this.f2832a;
    }

    public String m4717b() {
        return this.f2833b;
    }

    public boolean m4718c() {
        return this.f2839h.get();
    }

    public synchronized void m4715a(List<Survey> list, List<InAppNotification> list2) {
        Object obj = null;
        for (Survey survey : list) {
            Object obj2;
            int b = survey.m4632b();
            if (this.f2834c.contains(Integer.valueOf(b))) {
                obj2 = obj;
            } else {
                this.f2834c.add(Integer.valueOf(b));
                this.f2836e.add(survey);
                obj2 = 1;
            }
            obj = obj2;
        }
        for (InAppNotification inAppNotification : list2) {
            b = inAppNotification.m4603b();
            if (this.f2835d.contains(Integer.valueOf(b))) {
                obj2 = obj;
            } else {
                this.f2835d.add(Integer.valueOf(b));
                this.f2837f.add(inAppNotification);
                obj2 = 1;
            }
            obj = obj2;
        }
        if (!(obj == null || !m4719d() || this.f2838g == null)) {
            this.f2838g.m4712a(m4717b());
        }
    }

    public synchronized Survey m4713a(boolean z) {
        Survey survey;
        if (this.f2836e.isEmpty()) {
            survey = null;
        } else {
            survey = (Survey) this.f2836e.remove(0);
            if (z) {
                this.f2836e.add(this.f2836e.size(), survey);
            }
        }
        return survey;
    }

    public synchronized InAppNotification m4716b(boolean z) {
        InAppNotification inAppNotification;
        if (this.f2837f.isEmpty()) {
            inAppNotification = null;
        } else {
            inAppNotification = (InAppNotification) this.f2837f.remove(0);
            if (z) {
                this.f2837f.add(this.f2837f.size(), inAppNotification);
            }
        }
        return inAppNotification;
    }

    public synchronized boolean m4719d() {
        boolean z;
        z = (this.f2837f.isEmpty() && this.f2836e.isEmpty()) ? false : true;
        return z;
    }
}
