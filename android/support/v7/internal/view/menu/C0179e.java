package android.support.v7.internal.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.appcompat.C0159R;
import android.support.v7.internal.view.menu.C0172m.C0170a;
import android.support.v7.internal.view.menu.C0174l.C0156a;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* renamed from: android.support.v7.internal.view.menu.e */
public class C0179e implements C0174l, OnItemClickListener {
    Context f109a;
    LayoutInflater f110b;
    C0180f f111c;
    ExpandedMenuView f112d;
    int f113e;
    int f114f;
    C0178a f115g;
    private int f116h;
    private C0156a f117i;
    private int f118j;

    /* renamed from: android.support.v7.internal.view.menu.e.a */
    private class C0178a extends BaseAdapter {
        final /* synthetic */ C0179e f107a;
        private int f108b;

        public /* synthetic */ Object getItem(int i) {
            return m87a(i);
        }

        public C0178a(C0179e c0179e) {
            this.f107a = c0179e;
            this.f108b = -1;
            m88a();
        }

        public int getCount() {
            int size = this.f107a.f111c.m145l().size() - this.f107a.f116h;
            return this.f108b < 0 ? size : size - 1;
        }

        public C0183h m87a(int i) {
            ArrayList l = this.f107a.f111c.m145l();
            int a = this.f107a.f116h + i;
            if (this.f108b >= 0 && a >= this.f108b) {
                a++;
            }
            return (C0183h) l.get(a);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.f107a.f110b.inflate(this.f107a.f114f, viewGroup, false);
            } else {
                inflate = view;
            }
            ((C0170a) inflate).m64a(m87a(i), 0);
            return inflate;
        }

        void m88a() {
            C0183h r = this.f107a.f111c.m151r();
            if (r != null) {
                ArrayList l = this.f107a.f111c.m145l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (((C0183h) l.get(i)) == r) {
                        this.f108b = i;
                        return;
                    }
                }
            }
            this.f108b = -1;
        }

        public void notifyDataSetChanged() {
            m88a();
            super.notifyDataSetChanged();
        }
    }

    public C0179e(Context context, int i) {
        this(i, 0);
        this.f109a = context;
        this.f110b = LayoutInflater.from(this.f109a);
    }

    public C0179e(int i, int i2) {
        this.f114f = i;
        this.f113e = i2;
    }

    public void initForMenu(Context context, C0180f c0180f) {
        if (this.f113e != 0) {
            this.f109a = new ContextThemeWrapper(context, this.f113e);
            this.f110b = LayoutInflater.from(this.f109a);
        } else if (this.f109a != null) {
            this.f109a = context;
            if (this.f110b == null) {
                this.f110b = LayoutInflater.from(this.f109a);
            }
        }
        this.f111c = c0180f;
        if (this.f115g != null) {
            this.f115g.notifyDataSetChanged();
        }
    }

    public C0172m m90a(ViewGroup viewGroup) {
        if (this.f112d == null) {
            this.f112d = (ExpandedMenuView) this.f110b.inflate(C0159R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f115g == null) {
                this.f115g = new C0178a(this);
            }
            this.f112d.setAdapter(this.f115g);
            this.f112d.setOnItemClickListener(this);
        }
        return this.f112d;
    }

    public ListAdapter m91a() {
        if (this.f115g == null) {
            this.f115g = new C0178a(this);
        }
        return this.f115g;
    }

    public void updateMenuView(boolean z) {
        if (this.f115g != null) {
            this.f115g.notifyDataSetChanged();
        }
    }

    public void m93a(C0156a c0156a) {
        this.f117i = c0156a;
    }

    public boolean onSubMenuSelected(C0195p c0195p) {
        if (!c0195p.hasVisibleItems()) {
            return false;
        }
        new C0181g(c0195p).m153a(null);
        if (this.f117i != null) {
            this.f117i.onOpenSubMenu(c0195p);
        }
        return true;
    }

    public void onCloseMenu(C0180f c0180f, boolean z) {
        if (this.f117i != null) {
            this.f117i.onCloseMenu(c0180f, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f111c.m123a(this.f115g.m87a(i), (C0174l) this, 0);
    }

    public boolean flagActionItems() {
        return false;
    }

    public boolean expandItemActionView(C0180f c0180f, C0183h c0183h) {
        return false;
    }

    public boolean collapseItemActionView(C0180f c0180f, C0183h c0183h) {
        return false;
    }

    public void m92a(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        if (this.f112d != null) {
            this.f112d.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public void m94b(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f112d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public int getId() {
        return this.f118j;
    }

    public Parcelable onSaveInstanceState() {
        if (this.f112d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        m92a(bundle);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        m94b((Bundle) parcelable);
    }
}
