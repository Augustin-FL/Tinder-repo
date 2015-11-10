package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Date;
import java.util.Set;

@Deprecated
/* renamed from: com.google.ads.mediation.b */
public class C0700b {
    private final Date f738a;
    private final Gender f739b;
    private final Set<String> f740c;
    private final boolean f741d;
    private final Location f742e;

    public C0700b(Date date, Gender gender, Set<String> set, boolean z, Location location) {
        this.f738a = date;
        this.f739b = gender;
        this.f740c = set;
        this.f741d = z;
        this.f742e = location;
    }
}
