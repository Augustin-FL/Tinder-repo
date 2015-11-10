package com.google.android.m4b.maps.p008k;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.facebook.stetho.BuildConfig;
import com.google.android.m4b.maps.bt.h;
import com.google.android.m4b.maps.f.c;
import com.google.android.m4b.maps.k.b;
import com.google.android.m4b.maps.k.g;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.m4b.maps.k.a */
public final class C1478a implements c {
    public static final b CREATOR;
    final int f1429a;
    final List<g> f1430b;
    private final String f1431c;
    private final boolean f1432d;
    private final Set<g> f1433e;

    static {
        CREATOR = new b();
    }

    C1478a(int i, List<g> list, String str, boolean z) {
        List emptyList;
        this.f1429a = i;
        if (list == null) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = Collections.unmodifiableList(list);
        }
        this.f1430b = emptyList;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        this.f1431c = str;
        this.f1432d = z;
        if (this.f1430b.isEmpty()) {
            this.f1433e = Collections.emptySet();
        } else {
            this.f1433e = Collections.unmodifiableSet(new HashSet(this.f1430b));
        }
    }

    @Deprecated
    public final String m2289a() {
        return this.f1431c;
    }

    public final boolean m2290b() {
        return this.f1432d;
    }

    @SuppressLint({"DefaultLocale"})
    public final String toString() {
        return h.a(this).a("types", this.f1433e).a("requireOpenNow", Boolean.valueOf(this.f1432d)).toString();
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1433e, Boolean.valueOf(this.f1432d)});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1478a)) {
            return false;
        }
        C1478a c1478a = (C1478a) obj;
        if (this.f1433e.equals(c1478a.f1433e) && this.f1432d == c1478a.f1432d) {
            return true;
        }
        return false;
    }

    public final int describeContents() {
        b bVar = CREATOR;
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        b bVar = CREATOR;
        b.a(this, parcel);
    }
}
