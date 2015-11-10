package com.tinder.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import com.tinder.fragments.C2688p;
import com.tinder.fragments.C2692q;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;

/* renamed from: com.tinder.adapters.q */
public class C2363q extends FragmentStatePagerAdapter {
    private boolean f4184a;
    private C2692q f4185b;
    private C2688p f4186c;

    public C2363q(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public Fragment getItem(int i) {
        if (i == 0) {
            this.f4186c = new C2688p();
            return this.f4186c;
        }
        this.f4185b = new C2692q();
        return this.f4185b;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        C3095y.m9471a("position = " + i);
        Object instantiateItem = super.instantiateItem(viewGroup, i);
        if (instantiateItem instanceof C2692q) {
            this.f4185b = (C2692q) instantiateItem;
        } else if (instantiateItem instanceof C2688p) {
            this.f4186c = (C2688p) instantiateItem;
        }
        C3077n.m9403a((Fragment) instantiateItem);
        return instantiateItem;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        C3095y.m9471a("destroyItem");
    }

    public int getCount() {
        if (this.f4184a) {
            return 0;
        }
        return 2;
    }

    public int getItemPosition(Object obj) {
        if (this.f4184a) {
            return -2;
        }
        return -1;
    }

    public C2688p m6442a() {
        return this.f4186c;
    }

    public C2692q m6443b() {
        return this.f4185b;
    }
}
