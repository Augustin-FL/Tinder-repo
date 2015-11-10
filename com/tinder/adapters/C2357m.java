package com.tinder.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import com.tinder.enums.UserType;
import com.tinder.fragments.C2610d;
import com.tinder.fragments.C2611e;
import com.tinder.fragments.C2627j;
import com.tinder.fragments.C2628h;
import com.tinder.fragments.C2646k;
import com.tinder.fragments.C2668m;
import com.tinder.fragments.C2684o;
import com.tinder.fragments.C2720t;
import com.tinder.fragments.C2745x;
import com.tinder.managers.ManagerApp;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;
import com.tinder.views.FragmentTagPagerAdapter;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.adapters.m */
public class C2357m extends FragmentTagPagerAdapter {
    private static String f4171a;
    @Nullable
    private Fragment f4172b;
    @Nullable
    private C2668m f4173c;
    @Nullable
    private C2684o f4174d;

    public C2357m(FragmentManager fragmentManager) {
        super(fragmentManager);
        f4171a = "fragment recommendations";
    }

    private static Fragment m6416b(@NonNull String str) {
        if (str.equals("fragment recommendations")) {
            return new C2720t();
        }
        if (str.equals("FRAGMENT_LOADING")) {
            return new C2627j();
        }
        if (str.equals("fragment exhausted")) {
            return new C2628h();
        }
        if (str.equals("fragment view profile")) {
            return C2745x.m7751a(ManagerApp.m7922m().m8599d(), UserType.ME);
        }
        if (str.equals("fragment app settings")) {
            return new C2610d();
        }
        if (str.equals("discover off")) {
            return new C2611e();
        }
        C3095y.m9471a("Fragment tag not recognized " + str);
        return null;
    }

    public static String m6415a() {
        return f4171a;
    }

    @Nullable
    public Fragment getItem(int i) {
        switch (i) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                this.f4172b = C2357m.m6416b(f4171a);
                return this.f4172b;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                this.f4173c = new C2668m();
                return this.f4173c;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                this.f4174d = new C2684o();
                return this.f4174d;
            default:
                C3095y.m9471a("position not recognized " + i);
                return null;
        }
    }

    @Nullable
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        Object instantiateItem = super.instantiateItem(viewGroup, i);
        if (instantiateItem instanceof C2646k) {
            this.f4172b = (C2646k) instantiateItem;
        } else if (instantiateItem instanceof C2668m) {
            this.f4173c = (C2668m) instantiateItem;
        } else if (instantiateItem instanceof C2684o) {
            this.f4174d = (C2684o) instantiateItem;
        }
        C3077n.m9403a((Fragment) instantiateItem);
        return instantiateItem;
    }

    protected boolean isCorrectFragment(int i, Fragment fragment) {
        if (i != 0) {
            return true;
        }
        String str = f4171a;
        if (str.equals("fragment recommendations") && (fragment instanceof C2720t)) {
            return true;
        }
        if (str.equals("FRAGMENT_LOADING") && (fragment instanceof C2627j)) {
            return true;
        }
        if (str.equals("fragment exhausted") && (fragment instanceof C2628h)) {
            return true;
        }
        if (str.equals("discover off") && (fragment instanceof C2611e)) {
            return true;
        }
        return false;
    }

    public int getCount() {
        return 3;
    }

    public int getItemPosition(Object obj) {
        C3095y.m9471a("get item position called with : " + obj);
        return -2;
    }

    @Nullable
    public C2668m m6418b() {
        return this.f4173c;
    }

    @Nullable
    public Fragment m6419c() {
        return this.f4172b;
    }

    public void m6417a(String str) {
        if (this.f4172b == null || !f4171a.equals(str)) {
            f4171a = str;
            notifyDataSetChanged();
            C3095y.m9471a("setting main = " + str);
            return;
        }
        C3095y.m9471a("not adding " + str + " while " + f4171a);
    }

    @Nullable
    public C2684o m6420d() {
        return this.f4174d;
    }
}
