package com.tinder.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import com.tinder.enums.UserType;
import com.tinder.fragments.C2745x;
import com.tinder.fragments.FragmentMessages;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;

/* renamed from: com.tinder.adapters.o */
public class C2361o extends FragmentStatePagerAdapter {
    private String f4178a;
    private boolean f4179b;
    private int f4180c;
    private C2745x f4181d;

    public C2361o(FragmentManager fragmentManager, String str) {
        super(fragmentManager);
        this.f4180c = 0;
        this.f4178a = str;
    }

    public void m6438a(int i) {
        this.f4180c = i;
    }

    @Nullable
    public Fragment getItem(int i) {
        Fragment a;
        if (i == 0) {
            a = FragmentMessages.m7094a(this.f4178a);
        } else {
            a = C2745x.m7751a(null, UserType.MATCH);
            a.m7816a(false);
        }
        C3077n.m9403a(a);
        return a;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        C3095y.m9471a("position = " + i);
        Object instantiateItem = super.instantiateItem(viewGroup, i);
        if (instantiateItem instanceof C2745x) {
            this.f4181d = (C2745x) instantiateItem;
        }
        C3077n.m9403a((Fragment) instantiateItem);
        return instantiateItem;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    public int getCount() {
        if (this.f4179b) {
            return 0;
        }
        return this.f4180c;
    }

    public int getItemPosition(Object obj) {
        if (this.f4179b) {
            return -2;
        }
        return -1;
    }

    public void m6437a() {
        this.f4179b = true;
        try {
            notifyDataSetChanged();
        } catch (Exception e) {
            C3095y.m9471a(e.getMessage());
        }
    }

    public C2745x m6439b() {
        return this.f4181d;
    }
}
