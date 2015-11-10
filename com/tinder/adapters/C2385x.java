package com.tinder.adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.tinder.fragments.C2629i;
import com.tinder.utils.C3095y;

/* renamed from: com.tinder.adapters.x */
public class C2385x extends FragmentStatePagerAdapter {
    private final int f4269a;

    public C2385x(FragmentManager fragmentManager, int i) {
        super(fragmentManager);
        this.f4269a = i;
    }

    @NonNull
    public Fragment getItem(int i) {
        C3095y.m9471a("position=" + i);
        return C2629i.m7270a(i);
    }

    public int getCount() {
        return this.f4269a;
    }
}
