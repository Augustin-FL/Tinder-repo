package android.support.v7.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.C0159R;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: android.support.v7.internal.view.menu.f */
public class C0180f implements SupportMenu {
    private static final int[] f119d;
    CharSequence f120a;
    Drawable f121b;
    View f122c;
    private final Context f123e;
    private final Resources f124f;
    private boolean f125g;
    private boolean f126h;
    private C0151a f127i;
    private ArrayList<C0183h> f128j;
    private ArrayList<C0183h> f129k;
    private boolean f130l;
    private ArrayList<C0183h> f131m;
    private ArrayList<C0183h> f132n;
    private boolean f133o;
    private int f134p;
    private ContextMenuInfo f135q;
    private boolean f136r;
    private boolean f137s;
    private boolean f138t;
    private boolean f139u;
    private ArrayList<C0183h> f140v;
    private CopyOnWriteArrayList<WeakReference<C0174l>> f141w;
    private C0183h f142x;
    private boolean f143y;

    /* renamed from: android.support.v7.internal.view.menu.f.a */
    public interface C0151a {
        boolean onMenuItemSelected(C0180f c0180f, MenuItem menuItem);

        void onMenuModeChange(C0180f c0180f);
    }

    /* renamed from: android.support.v7.internal.view.menu.f.b */
    public interface C0171b {
        boolean invokeItem(C0183h c0183h);
    }

    static {
        f119d = new int[]{1, 4, 5, 3, 2, 0};
    }

    public C0180f(Context context) {
        this.f134p = 0;
        this.f136r = false;
        this.f137s = false;
        this.f138t = false;
        this.f139u = false;
        this.f140v = new ArrayList();
        this.f141w = new CopyOnWriteArrayList();
        this.f123e = context;
        this.f124f = context.getResources();
        this.f128j = new ArrayList();
        this.f129k = new ArrayList();
        this.f130l = true;
        this.f131m = new ArrayList();
        this.f132n = new ArrayList();
        this.f133o = true;
        m104e(true);
    }

    public C0180f m107a(int i) {
        this.f134p = i;
        return this;
    }

    public void m116a(C0174l c0174l) {
        m117a(c0174l, this.f123e);
    }

    public void m117a(C0174l c0174l, Context context) {
        this.f141w.add(new WeakReference(c0174l));
        c0174l.initForMenu(context, this);
        this.f133o = true;
    }

    public void m127b(C0174l c0174l) {
        Iterator it = this.f141w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0174l c0174l2 = (C0174l) weakReference.get();
            if (c0174l2 == null || c0174l2 == c0174l) {
                this.f141w.remove(weakReference);
            }
        }
    }

    private void m102d(boolean z) {
        if (!this.f141w.isEmpty()) {
            m140g();
            Iterator it = this.f141w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0174l c0174l = (C0174l) weakReference.get();
                if (c0174l == null) {
                    this.f141w.remove(weakReference);
                } else {
                    c0174l.updateMenuView(z);
                }
            }
            m141h();
        }
    }

    private boolean m100a(C0195p c0195p, C0174l c0174l) {
        boolean z = false;
        if (this.f141w.isEmpty()) {
            return false;
        }
        if (c0174l != null) {
            z = c0174l.onSubMenuSelected(c0195p);
        }
        Iterator it = this.f141w.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0174l c0174l2 = (C0174l) weakReference.get();
            if (c0174l2 == null) {
                this.f141w.remove(weakReference);
                z = z2;
            } else if (z2) {
                z = z2;
            } else {
                z = c0174l2.onSubMenuSelected(c0195p);
            }
            z2 = z;
        }
        return z2;
    }

    private void m103e(Bundle bundle) {
        if (!this.f141w.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator it = this.f141w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0174l c0174l = (C0174l) weakReference.get();
                if (c0174l == null) {
                    this.f141w.remove(weakReference);
                } else {
                    int id = c0174l.getId();
                    if (id > 0) {
                        Parcelable onSaveInstanceState = c0174l.onSaveInstanceState();
                        if (onSaveInstanceState != null) {
                            sparseArray.put(id, onSaveInstanceState);
                        }
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    private void m105f(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.f141w.isEmpty()) {
            Iterator it = this.f141w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0174l c0174l = (C0174l) weakReference.get();
                if (c0174l == null) {
                    this.f141w.remove(weakReference);
                } else {
                    int id = c0174l.getId();
                    if (id > 0) {
                        Parcelable parcelable = (Parcelable) sparseParcelableArray.get(id);
                        if (parcelable != null) {
                            c0174l.onRestoreInstanceState(parcelable);
                        }
                    }
                }
            }
        }
    }

    public void m113a(Bundle bundle) {
        m103e(bundle);
    }

    public void m125b(Bundle bundle) {
        m105f(bundle);
    }

    public void m131c(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View actionView = MenuItemCompat.getActionView(item);
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (MenuItemCompat.isActionViewExpanded(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((C0195p) item.getSubMenu()).m131c(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(m112a(), sparseArray);
        }
    }

    public void m136d(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(m112a());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View actionView = MenuItemCompat.getActionView(item);
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((C0195p) item.getSubMenu()).m136d(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    MenuItemCompat.expandActionView(item);
                }
            }
        }
    }

    protected String m112a() {
        return "android:menu:actionviewstates";
    }

    public void m114a(C0151a c0151a) {
        this.f127i = c0151a;
    }

    private MenuItem m97a(int i, int i2, int i3, CharSequence charSequence) {
        int d = C0180f.m101d(i3);
        MenuItem a = m96a(i, i2, i3, d, charSequence, this.f134p);
        if (this.f135q != null) {
            a.m159a(this.f135q);
        }
        this.f128j.add(C0180f.m95a(this.f128j, d), a);
        m128b(true);
        return a;
    }

    private C0183h m96a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0183h(this, i, i2, i3, i4, charSequence, i5);
    }

    public MenuItem add(CharSequence charSequence) {
        return m97a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return m97a(0, 0, 0, this.f124f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m97a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m97a(i, i2, i3, this.f124f.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f124f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0183h c0183h = (C0183h) m97a(i, i2, i3, charSequence);
        C0195p c0195p = new C0195p(this.f123e, this, c0183h);
        c0183h.m158a(c0195p);
        return c0195p;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f124f.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f123e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        m99a(m124b(i), true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeGroup(int r6) {
        /*
        r5 = this;
        r1 = 0;
        r3 = r5.m130c(r6);
        if (r3 < 0) goto L_0x002b;
    L_0x0007:
        r0 = r5.f128j;
        r0 = r0.size();
        r4 = r0 - r3;
        r0 = r1;
    L_0x0010:
        r2 = r0 + 1;
        if (r0 >= r4) goto L_0x0027;
    L_0x0014:
        r0 = r5.f128j;
        r0 = r0.get(r3);
        r0 = (android.support.v7.internal.view.menu.C0183h) r0;
        r0 = r0.getGroupId();
        if (r0 != r6) goto L_0x0027;
    L_0x0022:
        r5.m99a(r3, r1);
        r0 = r2;
        goto L_0x0010;
    L_0x0027:
        r0 = 1;
        r5.m128b(r0);
    L_0x002b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.view.menu.f.removeGroup(int):void");
    }

    private void m99a(int i, boolean z) {
        if (i >= 0 && i < this.f128j.size()) {
            this.f128j.remove(i);
            if (z) {
                m128b(true);
            }
        }
    }

    public void clear() {
        if (this.f142x != null) {
            m137d(this.f142x);
        }
        this.f128j.clear();
        m128b(true);
    }

    void m118a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f128j.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (C0183h) this.f128j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.m171f() && menuItem2.isCheckable()) {
                menuItem2.m164b(menuItem2 == menuItem);
            }
        }
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f128j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0183h c0183h = (C0183h) this.f128j.get(i2);
            if (c0183h.getGroupId() == i) {
                c0183h.m160a(z2);
                c0183h.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f128j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            C0183h c0183h = (C0183h) this.f128j.get(i2);
            if (c0183h.getGroupId() == i && c0183h.m166c(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            m128b(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f128j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0183h c0183h = (C0183h) this.f128j.get(i2);
            if (c0183h.getGroupId() == i) {
                c0183h.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.f143y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0183h) this.f128j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0183h c0183h = (C0183h) this.f128j.get(i2);
            if (c0183h.getItemId() == i) {
                return c0183h;
            }
            if (c0183h.hasSubMenu()) {
                MenuItem findItem = c0183h.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int m124b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0183h) this.f128j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int m130c(int i) {
        return m106a(i, 0);
    }

    public int m106a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((C0183h) this.f128j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public int size() {
        return this.f128j.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f128j.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m111a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.f125g = z;
        m128b(false);
    }

    private static int m101d(int i) {
        int i2 = (SupportMenu.CATEGORY_MASK & i) >> 16;
        if (i2 >= 0 && i2 < f119d.length) {
            return (f119d[i2] << 16) | (SupportMenu.USER_MASK & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    boolean m129b() {
        return this.f125g;
    }

    private void m104e(boolean z) {
        boolean z2 = true;
        if (!(z && this.f124f.getConfiguration().keyboard != 1 && this.f124f.getBoolean(C0159R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.f126h = z2;
    }

    public boolean m133c() {
        return this.f126h;
    }

    Resources m135d() {
        return this.f124f;
    }

    public Context m138e() {
        return this.f123e;
    }

    boolean m121a(C0180f c0180f, MenuItem menuItem) {
        return this.f127i != null && this.f127i.onMenuItemSelected(c0180f, menuItem);
    }

    public void m139f() {
        if (this.f127i != null) {
            this.f127i.onMenuModeChange(this);
        }
    }

    private static int m95a(ArrayList<C0183h> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C0183h) arrayList.get(size)).m162b() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m111a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = m122a(a, i2);
        }
        if ((i2 & 2) != 0) {
            m120a(true);
        }
        return z;
    }

    void m119a(List<C0183h> list, int i, KeyEvent keyEvent) {
        boolean b = m129b();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f128j.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0183h c0183h = (C0183h) this.f128j.get(i2);
                if (c0183h.hasSubMenu()) {
                    ((C0180f) c0183h.getSubMenu()).m119a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = b ? c0183h.getAlphabeticShortcut() : c0183h.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b && alphabeticShortcut == '\b' && i == 67)) && c0183h.isEnabled())) {
                    list.add(c0183h);
                }
            }
        }
    }

    C0183h m111a(int i, KeyEvent keyEvent) {
        List list = this.f140v;
        list.clear();
        m119a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (C0183h) list.get(0);
        }
        boolean b = m129b();
        for (int i2 = 0; i2 < size; i2++) {
            C0183h c0183h = (C0183h) list.get(i2);
            char alphabeticShortcut = b ? c0183h.getAlphabeticShortcut() : c0183h.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return c0183h;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return c0183h;
            }
            if (b && alphabeticShortcut == '\b' && i == 67) {
                return c0183h;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m122a(findItem(i), i2);
    }

    public boolean m122a(MenuItem menuItem, int i) {
        return m123a(menuItem, null, i);
    }

    public boolean m123a(MenuItem menuItem, C0174l c0174l, int i) {
        C0183h c0183h = (C0183h) menuItem;
        if (c0183h == null || !c0183h.isEnabled()) {
            return false;
        }
        boolean z;
        boolean a = c0183h.m161a();
        ActionProvider supportActionProvider = c0183h.getSupportActionProvider();
        if (supportActionProvider == null || !supportActionProvider.hasSubMenu()) {
            z = false;
        } else {
            z = true;
        }
        boolean expandActionView;
        if (c0183h.m178m()) {
            expandActionView = c0183h.expandActionView() | a;
            if (!expandActionView) {
                return expandActionView;
            }
            m120a(true);
            return expandActionView;
        } else if (c0183h.hasSubMenu() || z) {
            m120a(false);
            if (!c0183h.hasSubMenu()) {
                c0183h.m158a(new C0195p(m138e(), this, c0183h));
            }
            C0195p c0195p = (C0195p) c0183h.getSubMenu();
            if (z) {
                supportActionProvider.onPrepareSubMenu(c0195p);
            }
            expandActionView = m100a(c0195p, c0174l) | a;
            if (expandActionView) {
                return expandActionView;
            }
            m120a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                m120a(true);
            }
            return a;
        }
    }

    public final void m120a(boolean z) {
        if (!this.f139u) {
            this.f139u = true;
            Iterator it = this.f141w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0174l c0174l = (C0174l) weakReference.get();
                if (c0174l == null) {
                    this.f141w.remove(weakReference);
                } else {
                    c0174l.onCloseMenu(this, z);
                }
            }
            this.f139u = false;
        }
    }

    public void close() {
        m120a(true);
    }

    public void m128b(boolean z) {
        if (this.f136r) {
            this.f137s = true;
            return;
        }
        if (z) {
            this.f130l = true;
            this.f133o = true;
        }
        m102d(z);
    }

    public void m140g() {
        if (!this.f136r) {
            this.f136r = true;
            this.f137s = false;
        }
    }

    public void m141h() {
        this.f136r = false;
        if (this.f137s) {
            this.f137s = false;
            m128b(true);
        }
    }

    void m115a(C0183h c0183h) {
        this.f130l = true;
        m128b(true);
    }

    void m126b(C0183h c0183h) {
        this.f133o = true;
        m128b(true);
    }

    public ArrayList<C0183h> m142i() {
        if (!this.f130l) {
            return this.f129k;
        }
        this.f129k.clear();
        int size = this.f128j.size();
        for (int i = 0; i < size; i++) {
            C0183h c0183h = (C0183h) this.f128j.get(i);
            if (c0183h.isVisible()) {
                this.f129k.add(c0183h);
            }
        }
        this.f130l = false;
        this.f133o = true;
        return this.f129k;
    }

    public void m143j() {
        ArrayList i = m142i();
        if (this.f133o) {
            Iterator it = this.f141w.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                WeakReference weakReference = (WeakReference) it.next();
                C0174l c0174l = (C0174l) weakReference.get();
                if (c0174l == null) {
                    this.f141w.remove(weakReference);
                    i3 = i2;
                } else {
                    i3 = c0174l.flagActionItems() | i2;
                }
                i2 = i3;
            }
            if (i2 != 0) {
                this.f131m.clear();
                this.f132n.clear();
                i2 = i.size();
                for (int i4 = 0; i4 < i2; i4++) {
                    C0183h c0183h = (C0183h) i.get(i4);
                    if (c0183h.m174i()) {
                        this.f131m.add(c0183h);
                    } else {
                        this.f132n.add(c0183h);
                    }
                }
            } else {
                this.f131m.clear();
                this.f132n.clear();
                this.f132n.addAll(m142i());
            }
            this.f133o = false;
        }
    }

    public ArrayList<C0183h> m144k() {
        m143j();
        return this.f131m;
    }

    public ArrayList<C0183h> m145l() {
        m143j();
        return this.f132n;
    }

    public void clearHeader() {
        this.f121b = null;
        this.f120a = null;
        this.f122c = null;
        m128b(false);
    }

    private void m98a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = m135d();
        if (view != null) {
            this.f122c = view;
            this.f120a = null;
            this.f121b = null;
        } else {
            if (i > 0) {
                this.f120a = d.getText(i);
            } else if (charSequence != null) {
                this.f120a = charSequence;
            }
            if (i2 > 0) {
                this.f121b = ContextCompat.getDrawable(m138e(), i2);
            } else if (drawable != null) {
                this.f121b = drawable;
            }
            this.f122c = null;
        }
        m128b(false);
    }

    protected C0180f m110a(CharSequence charSequence) {
        m98a(0, charSequence, 0, null, null);
        return this;
    }

    protected C0180f m108a(Drawable drawable) {
        m98a(0, null, 0, drawable, null);
        return this;
    }

    protected C0180f m109a(View view) {
        m98a(0, null, 0, null, view);
        return this;
    }

    public CharSequence m146m() {
        return this.f120a;
    }

    public Drawable m147n() {
        return this.f121b;
    }

    public View m148o() {
        return this.f122c;
    }

    public C0180f m149p() {
        return this;
    }

    boolean m150q() {
        return this.f138t;
    }

    public boolean m134c(C0183h c0183h) {
        boolean z = false;
        if (!this.f141w.isEmpty()) {
            m140g();
            Iterator it = this.f141w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0174l c0174l = (C0174l) weakReference.get();
                if (c0174l == null) {
                    this.f141w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0174l.expandItemActionView(this, c0183h);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m141h();
            if (z) {
                this.f142x = c0183h;
            }
        }
        return z;
    }

    public boolean m137d(C0183h c0183h) {
        boolean z = false;
        if (!this.f141w.isEmpty() && this.f142x == c0183h) {
            m140g();
            Iterator it = this.f141w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0174l c0174l = (C0174l) weakReference.get();
                if (c0174l == null) {
                    this.f141w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0174l.collapseItemActionView(this, c0183h);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m141h();
            if (z) {
                this.f142x = null;
            }
        }
        return z;
    }

    public C0183h m151r() {
        return this.f142x;
    }

    public void m132c(boolean z) {
        this.f143y = z;
    }
}
