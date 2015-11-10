package com.tinder.base;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.tinder.utils.C3095y;
import java.lang.ref.WeakReference;

/* renamed from: com.tinder.base.b */
public class C2416b {
    protected boolean f4316a;
    protected WeakReference<AppCompatActivity> f4317b;
    protected int f4318c;
    @Nullable
    protected FragmentTransaction f4319d;

    public C2416b(AppCompatActivity appCompatActivity) {
        this.f4316a = true;
        this.f4318c = -1;
        this.f4317b = new WeakReference(appCompatActivity);
    }

    public void m6606a(int i) {
        this.f4318c = i;
    }

    @Nullable
    protected AppCompatActivity m6605a() {
        if (this.f4317b != null) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) this.f4317b.get();
            if (!(appCompatActivity == null || appCompatActivity.isFinishing())) {
                return appCompatActivity;
            }
        }
        return null;
    }

    @Nullable
    protected FragmentTransaction m6610b() {
        if (this.f4319d != null) {
            return this.f4319d;
        }
        AppCompatActivity a = m6605a();
        if (a == null) {
            return null;
        }
        FragmentTransaction beginTransaction = a.getSupportFragmentManager().beginTransaction();
        if (this.f4316a) {
            return beginTransaction;
        }
        this.f4319d = beginTransaction;
        return beginTransaction;
    }

    public void m6607a(@Nullable Fragment fragment) {
        if (fragment == null) {
            C3095y.m9479c("Attempted to add a NULL fragment!");
            C3095y.m9475b();
        } else if (this.f4318c == -1) {
            C3095y.m9479c("Attempted to add a fragment, but the default container has not been set. Set it using FragmentHelper.setDefaultContainer(int)");
            C3095y.m9475b();
        } else {
            FragmentTransaction b = m6610b();
            if (b != null) {
                b.add(this.f4318c, fragment);
                if (this.f4316a) {
                    b.commit();
                    return;
                }
                return;
            }
            C3095y.m9476b("Attempted to add fragment but failed to start a transaction (" + fragment.getClass().toString() + ')');
            C3095y.m9475b();
        }
    }

    public void m6608a(@Nullable Fragment fragment, String str) {
        if (fragment == null) {
            C3095y.m9479c("Attempted to add a NULL fragment!");
            C3095y.m9475b();
        } else if (this.f4318c == -1) {
            C3095y.m9479c("Attempted to add a fragment, but the default container has not been set. Set it using FragmentHelper.setDefaultContainer(int)");
            C3095y.m9475b();
        } else {
            FragmentTransaction b = m6610b();
            if (b != null) {
                b.add(this.f4318c, fragment, str);
                if (this.f4316a) {
                    b.commit();
                    return;
                }
                return;
            }
            C3095y.m9476b("Attempted to add fragment but failed to start a transaction (" + fragment.getClass().toString() + ')');
            C3095y.m9475b();
        }
    }

    public void m6611b(@Nullable Fragment fragment) {
        if (fragment == null) {
            C3095y.m9479c("Attempted to add a NULL fragment!");
            C3095y.m9475b();
        } else if (this.f4318c == -1) {
            C3095y.m9479c("Attempted to add a fragment, but the default container has not been set. Set it using FragmentHelper.setDefaultContainer(int)");
            C3095y.m9475b();
        } else {
            FragmentTransaction b = m6610b();
            if (b != null) {
                b.add(this.f4318c, fragment).addToBackStack(null);
                if (this.f4316a) {
                    b.commit();
                    return;
                }
                return;
            }
            C3095y.m9476b("Attempted to add fragment but failed to start a transaction (" + fragment.getClass().toString() + ')');
            C3095y.m9475b();
        }
    }

    public void m6609a(@Nullable Fragment fragment, String str, int i, int i2, int i3, int i4) {
        if (fragment == null) {
            C3095y.m9479c("Attempted to add a NULL fragment!");
            C3095y.m9475b();
        } else if (this.f4318c == -1) {
            C3095y.m9479c("Attempted to add a fragment, but the default container has not been set. Set it using FragmentHelper.setDefaultContainer(int)");
            C3095y.m9475b();
        } else {
            FragmentTransaction b = m6610b();
            if (b != null) {
                if (!(i == -1 || i2 == -1 || i3 == -1 || i4 == -1)) {
                    C3095y.m9471a("doin fragment animations");
                    b.setCustomAnimations(i, i2, i3, i4);
                }
                b.add(this.f4318c, fragment, str).addToBackStack(str);
                if (this.f4316a) {
                    b.commit();
                    return;
                }
                return;
            }
            C3095y.m9476b("Attempted to add fragment but failed to start a transaction (" + fragment.getClass().toString() + ')');
            C3095y.m9475b();
        }
    }

    @Nullable
    public Fragment m6604a(String str) {
        FragmentActivity a = m6605a();
        if (a != null) {
            return a.getSupportFragmentManager().findFragmentByTag(str);
        }
        return null;
    }

    public void m6612c(@Nullable Fragment fragment) {
        if (fragment == null) {
            C3095y.m9479c("Attempted to replace with a NULL fragment!");
            C3095y.m9475b();
        } else if (this.f4318c == -1) {
            C3095y.m9479c("Attempted to replace a fragment, but the default container has not been set. Set it using FragmentHelper.setDefaultContainer(int)");
            C3095y.m9475b();
        } else {
            if (!(this.f4317b == null || this.f4317b.get() == null)) {
                ((AppCompatActivity) this.f4317b.get()).getSupportFragmentManager().popBackStack(null, 1);
            }
            FragmentTransaction b = m6610b();
            if (b != null) {
                b.replace(this.f4318c, fragment);
                if (this.f4316a) {
                    b.commit();
                    return;
                }
                return;
            }
            C3095y.m9476b("Attempted to replace fragment but failed to start a transaction (" + fragment.getClass().toString() + ')');
            C3095y.m9475b();
        }
    }
}
