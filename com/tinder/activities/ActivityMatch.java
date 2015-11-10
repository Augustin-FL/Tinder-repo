package com.tinder.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tinder.base.ActivityBase;
import com.tinder.fragments.C2657l;
import com.tinder.model.Match;
import com.tinder.p030d.ab;

public class ActivityMatch extends ActivityBase implements ab {
    @Nullable
    private Match f3931a;
    private boolean f3932b;
    private boolean f3933c;
    private C2657l f3934e;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m5908T();
        if (getIntent() == null || getIntent().getExtras() == null) {
            finish();
            return;
        }
        this.f3931a = (Match) getIntent().getExtras().getSerializable("match");
        String string = getIntent().getExtras().getString("moment-id", null);
        if (this.f3931a != null) {
            this.f3934e = C2657l.m7398a(this.f3931a, false, string);
            m5923b(this.f3934e);
            return;
        }
        finish();
    }

    public void m6220a(Match match) {
        this.f3931a = match;
    }

    @Nullable
    public Match m6222p() {
        return this.f3931a;
    }

    public boolean m6223q() {
        return this.f3932b;
    }

    public boolean m6224r() {
        return this.f3933c;
    }

    public void m6225s() {
        this.f3933c = false;
    }

    public void m6221a(Match match, boolean z) {
        this.f3931a = match;
        this.f3932b = z;
    }

    public void m6226t() {
        onBackPressed();
    }

    public void m6227u() {
        if (this.f3934e != null) {
            this.f3934e.m7435c();
        }
    }

    public void m6219a(C2657l c2657l) {
        this.f3934e = c2657l;
    }

    public void m6228w() {
        onBackPressed();
    }
}
