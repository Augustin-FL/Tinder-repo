package com.tinder.adapters;

import android.animation.Animator.AnimatorListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import com.tinder.enums.UserType;
import com.tinder.fragments.C2610d;
import com.tinder.fragments.C2616f;
import com.tinder.fragments.C2646k;
import com.tinder.fragments.C2657l;
import com.tinder.fragments.C2684o;
import com.tinder.fragments.C2745x;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Match;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.List;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class ActivityMainPagerAdapter extends FragmentStatePagerAdapter {
    private C2646k f4042a;
    private Match f4043b;
    private List<ModalType> f4044c;

    public enum ModalType {
        NONE,
        MATCH,
        MY_MOMENTS,
        MY_PROFILE,
        APP_SETTINGS,
        DISCOVER_SETTINGS
    }

    public ActivityMainPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f4044c = new ArrayList();
    }

    @Nullable
    public Fragment getItem(int i) {
        C3095y.m9471a("position=" + i);
        switch (i) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return new C2646k();
            default:
                ModalType modalType = (ModalType) this.f4044c.get(i - 1);
                if (modalType == ModalType.MATCH && this.f4043b != null) {
                    return C2657l.m7396a(this.f4043b);
                }
                if (modalType == ModalType.MY_MOMENTS) {
                    return new C2684o();
                }
                if (modalType == ModalType.MY_PROFILE) {
                    return C2745x.m7751a(ManagerApp.m7922m().m8599d(), UserType.ME);
                }
                if (modalType == ModalType.APP_SETTINGS) {
                    return new C2610d();
                }
                if (modalType == ModalType.DISCOVER_SETTINGS) {
                    return new C2616f();
                }
                return null;
        }
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        C3095y.m9471a("position = " + i);
        Object instantiateItem = super.instantiateItem(viewGroup, i);
        if (instantiateItem instanceof C2646k) {
            this.f4042a = (C2646k) instantiateItem;
        }
        C3077n.m9403a((Fragment) instantiateItem);
        return instantiateItem;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        C3095y.m9471a("destroyItem position: " + i + " object: " + obj);
        if (obj instanceof C2657l) {
            ((C2657l) obj).m7437d();
        }
        try {
            super.destroyItem(viewGroup, i, obj);
        } catch (IllegalStateException e) {
        }
    }

    public int getCount() {
        return this.f4044c.size() + 1;
    }

    public int getItemPosition(Object obj) {
        if (obj instanceof C2646k) {
            return -1;
        }
        return -2;
    }

    @Nullable
    public C2646k m6350a() {
        return this.f4042a;
    }

    public void m6353a(C2646k c2646k) {
        this.f4042a = c2646k;
    }

    public void m6354a(@NonNull Match match) {
        C3095y.m9471a("match=" + match);
        this.f4044c.add(ModalType.MATCH);
        this.f4043b = match;
        notifyDataSetChanged();
    }

    public void m6355b() {
        C3095y.m9469a();
        this.f4044c.add(ModalType.MY_PROFILE);
        notifyDataSetChanged();
    }

    public void m6356c() {
        this.f4044c.add(ModalType.APP_SETTINGS);
        notifyDataSetChanged();
    }

    public void m6357d() {
        this.f4044c.add(ModalType.DISCOVER_SETTINGS);
        notifyDataSetChanged();
    }

    public void m6358e() {
        if (this.f4044c.size() != 0) {
            this.f4044c.remove(this.f4044c.size() - 1);
            notifyDataSetChanged();
        }
    }

    public void m6359f() {
        C3095y.m9469a();
        this.f4044c.clear();
        notifyDataSetChanged();
    }

    public void m6351a(float f) {
        if (this.f4042a != null) {
            this.f4042a.m7358a(f);
        }
    }

    public void m6352a(@NonNull AnimatorListener animatorListener) {
        if (this.f4042a != null) {
            this.f4042a.m7359a(animatorListener);
        }
    }

    public void m6360g() {
        if (this.f4042a != null) {
            this.f4042a.m7354D();
        }
    }

    public void m6361h() {
        if (this.f4042a != null) {
            this.f4042a.m7351A();
        }
    }
}
