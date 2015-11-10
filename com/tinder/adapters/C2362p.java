package com.tinder.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.tinder.fragments.C2657l;
import com.tinder.fragments.C2678n;
import com.tinder.model.Match;

/* renamed from: com.tinder.adapters.p */
public class C2362p extends FragmentStatePagerAdapter {
    private Match f4182a;
    private boolean f4183b;

    public C2362p(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Nullable
    public Fragment getItem(int i) {
        if (i == 0) {
            return new C2678n();
        }
        if (this.f4182a != null) {
            return C2657l.m7397a(this.f4182a, true);
        }
        return null;
    }

    public int getCount() {
        if (this.f4183b) {
            return 2;
        }
        return 1;
    }

    public int getItemPosition(Object obj) {
        if (obj instanceof C2678n) {
            return -1;
        }
        return -2;
    }

    public void m6440a(Match match) {
        this.f4182a = match;
    }

    public void m6441a(boolean z) {
        this.f4183b = z;
        notifyDataSetChanged();
    }
}
