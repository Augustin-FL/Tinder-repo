package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.VisibilityListener;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v7.internal.view.menu.C0172m.C0170a;
import android.support.v7.internal.widget.TintManager;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;
import com.facebook.stetho.BuildConfig;
import org.apache.http.protocol.HTTP;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: android.support.v7.internal.view.menu.h */
public final class C0183h implements SupportMenuItem {
    private static String f149w;
    private static String f150x;
    private static String f151y;
    private static String f152z;
    private final int f153a;
    private final int f154b;
    private final int f155c;
    private final int f156d;
    private CharSequence f157e;
    private CharSequence f158f;
    private Intent f159g;
    private char f160h;
    private char f161i;
    private Drawable f162j;
    private int f163k;
    private C0180f f164l;
    private C0195p f165m;
    private Runnable f166n;
    private OnMenuItemClickListener f167o;
    private int f168p;
    private int f169q;
    private View f170r;
    private ActionProvider f171s;
    private OnActionExpandListener f172t;
    private boolean f173u;
    private ContextMenuInfo f174v;

    /* renamed from: android.support.v7.internal.view.menu.h.1 */
    class C01821 implements VisibilityListener {
        final /* synthetic */ C0183h f148a;

        C01821(C0183h c0183h) {
            this.f148a = c0183h;
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            this.f148a.f164l.m115a(this.f148a);
        }
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m155a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m156a(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m163b(i);
    }

    C0183h(C0180f c0180f, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f163k = 0;
        this.f168p = 16;
        this.f169q = 0;
        this.f173u = false;
        this.f164l = c0180f;
        this.f153a = i2;
        this.f154b = i;
        this.f155c = i3;
        this.f156d = i4;
        this.f157e = charSequence;
        this.f169q = i5;
    }

    public boolean m161a() {
        if ((this.f167o != null && this.f167o.onMenuItemClick(this)) || this.f164l.m121a(this.f164l.m149p(), (MenuItem) this)) {
            return true;
        }
        if (this.f166n != null) {
            this.f166n.run();
            return true;
        }
        if (this.f159g != null) {
            try {
                this.f164l.m138e().startActivity(this.f159g);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.f171s == null || !this.f171s.onPerformDefaultAction()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.f168p & 16) != 0;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f168p |= 16;
        } else {
            this.f168p &= -17;
        }
        this.f164l.m128b(false);
        return this;
    }

    public int getGroupId() {
        return this.f154b;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f153a;
    }

    public int getOrder() {
        return this.f155c;
    }

    public int m162b() {
        return this.f156d;
    }

    public Intent getIntent() {
        return this.f159g;
    }

    public MenuItem setIntent(Intent intent) {
        this.f159g = intent;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.f161i;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f161i != c) {
            this.f161i = Character.toLowerCase(c);
            this.f164l.m128b(false);
        }
        return this;
    }

    public char getNumericShortcut() {
        return this.f160h;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f160h != c) {
            this.f160h = c;
            this.f164l.m128b(false);
        }
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f160h = c;
        this.f161i = Character.toLowerCase(c2);
        this.f164l.m128b(false);
        return this;
    }

    char m165c() {
        return this.f164l.m129b() ? this.f161i : this.f160h;
    }

    String m167d() {
        char c = m165c();
        if (c == '\u0000') {
            return BuildConfig.FLAVOR;
        }
        StringBuilder stringBuilder = new StringBuilder(f149w);
        switch (c) {
            case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                stringBuilder.append(f151y);
                break;
            case C3374b.SmoothProgressBar_spb_mirror_mode /*10*/:
                stringBuilder.append(f150x);
                break;
            case HTTP.SP /*32*/:
                stringBuilder.append(f152z);
                break;
            default:
                stringBuilder.append(c);
                break;
        }
        return stringBuilder.toString();
    }

    boolean m170e() {
        return this.f164l.m133c() && m165c() != '\u0000';
    }

    public SubMenu getSubMenu() {
        return this.f165m;
    }

    public boolean hasSubMenu() {
        return this.f165m != null;
    }

    void m158a(C0195p c0195p) {
        this.f165m = c0195p;
        c0195p.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f157e;
    }

    CharSequence m157a(C0170a c0170a) {
        return (c0170a == null || !c0170a.m65a()) ? getTitle() : getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f157e = charSequence;
        this.f164l.m128b(false);
        if (this.f165m != null) {
            this.f165m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.f164l.m138e().getString(i));
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f158f != null ? this.f158f : this.f157e;
        if (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f158f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f157e;
        }
        this.f164l.m128b(false);
        return this;
    }

    public Drawable getIcon() {
        if (this.f162j != null) {
            return this.f162j;
        }
        if (this.f163k == 0) {
            return null;
        }
        Drawable drawable = TintManager.getDrawable(this.f164l.m138e(), this.f163k);
        this.f163k = 0;
        this.f162j = drawable;
        return drawable;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f163k = 0;
        this.f162j = drawable;
        this.f164l.m128b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f162j = null;
        this.f163k = i;
        this.f164l.m128b(false);
        return this;
    }

    public boolean isCheckable() {
        return (this.f168p & 1) == 1;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f168p;
        this.f168p = (z ? 1 : 0) | (this.f168p & -2);
        if (i != this.f168p) {
            this.f164l.m128b(false);
        }
        return this;
    }

    public void m160a(boolean z) {
        this.f168p = (z ? 4 : 0) | (this.f168p & -5);
    }

    public boolean m171f() {
        return (this.f168p & 4) != 0;
    }

    public boolean isChecked() {
        return (this.f168p & 2) == 2;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f168p & 4) != 0) {
            this.f164l.m118a((MenuItem) this);
        } else {
            m164b(z);
        }
        return this;
    }

    void m164b(boolean z) {
        int i;
        int i2 = this.f168p;
        int i3 = this.f168p & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.f168p = i | i3;
        if (i2 != this.f168p) {
            this.f164l.m128b(false);
        }
    }

    public boolean isVisible() {
        if (this.f171s == null || !this.f171s.overridesItemVisibility()) {
            if ((this.f168p & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.f168p & 8) == 0 && this.f171s.isVisible()) {
            return true;
        } else {
            return false;
        }
    }

    boolean m166c(boolean z) {
        int i = this.f168p;
        this.f168p = (z ? 0 : 8) | (this.f168p & -9);
        if (i != this.f168p) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean z) {
        if (m166c(z)) {
            this.f164l.m115a(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f167o = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        return this.f157e.toString();
    }

    void m159a(ContextMenuInfo contextMenuInfo) {
        this.f174v = contextMenuInfo;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f174v;
    }

    public void m172g() {
        this.f164l.m126b(this);
    }

    public boolean m173h() {
        return this.f164l.m150q();
    }

    public boolean m174i() {
        return (this.f168p & 32) == 32;
    }

    public boolean m175j() {
        return (this.f169q & 1) == 1;
    }

    public boolean m176k() {
        return (this.f169q & 2) == 2;
    }

    public void m168d(boolean z) {
        if (z) {
            this.f168p |= 32;
        } else {
            this.f168p &= -33;
        }
    }

    public boolean m177l() {
        return (this.f169q & 4) == 4;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
            case C3374b.SmoothProgressBar_spb_color /*1*/:
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                this.f169q = i;
                this.f164l.m126b(this);
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public SupportMenuItem m156a(View view) {
        this.f170r = view;
        this.f171s = null;
        if (view != null && view.getId() == -1 && this.f153a > 0) {
            view.setId(this.f153a);
        }
        this.f164l.m126b(this);
        return this;
    }

    public SupportMenuItem m155a(int i) {
        Context e = this.f164l.m138e();
        m156a(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public View getActionView() {
        if (this.f170r != null) {
            return this.f170r;
        }
        if (this.f171s == null) {
            return null;
        }
        this.f170r = this.f171s.onCreateActionView(this);
        return this.f170r;
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public ActionProvider getSupportActionProvider() {
        return this.f171s;
    }

    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        if (this.f171s != null) {
            this.f171s.setVisibilityListener(null);
        }
        this.f170r = null;
        this.f171s = actionProvider;
        this.f164l.m128b(true);
        if (this.f171s != null) {
            this.f171s.setVisibilityListener(new C01821(this));
        }
        return this;
    }

    public SupportMenuItem m163b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        if (!m178m()) {
            return false;
        }
        if (this.f172t == null || this.f172t.onMenuItemActionExpand(this)) {
            return this.f164l.m134c(this);
        }
        return false;
    }

    public boolean collapseActionView() {
        if ((this.f169q & 8) == 0) {
            return false;
        }
        if (this.f170r == null) {
            return true;
        }
        if (this.f172t == null || this.f172t.onMenuItemActionCollapse(this)) {
            return this.f164l.m137d(this);
        }
        return false;
    }

    public SupportMenuItem setSupportOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        this.f172t = onActionExpandListener;
        return this;
    }

    public boolean m178m() {
        if ((this.f169q & 8) == 0) {
            return false;
        }
        if (this.f170r == null && this.f171s != null) {
            this.f170r = this.f171s.onCreateActionView(this);
        }
        if (this.f170r != null) {
            return true;
        }
        return false;
    }

    public void m169e(boolean z) {
        this.f173u = z;
        this.f164l.m128b(false);
    }

    public boolean isActionViewExpanded() {
        return this.f173u;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}
