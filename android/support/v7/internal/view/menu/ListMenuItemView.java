package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.C0159R;
import android.support.v7.internal.view.menu.C0172m.C0170a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements C0170a {
    private C0183h f75a;
    private ImageView f76b;
    private RadioButton f77c;
    private TextView f78d;
    private CheckBox f79e;
    private TextView f80f;
    private Drawable f81g;
    private int f82h;
    private Context f83i;
    private boolean f84j;
    private int f85k;
    private Context f86l;
    private LayoutInflater f87m;
    private boolean f88n;

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f86l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0159R.styleable.MenuView, i, 0);
        this.f81g = obtainStyledAttributes.getDrawable(C0159R.styleable.MenuView_android_itemBackground);
        this.f82h = obtainStyledAttributes.getResourceId(C0159R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f84j = obtainStyledAttributes.getBoolean(C0159R.styleable.MenuView_preserveIconSpacing, false);
        this.f83i = context;
        obtainStyledAttributes.recycle();
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f81g);
        this.f78d = (TextView) findViewById(C0159R.id.title);
        if (this.f82h != -1) {
            this.f78d.setTextAppearance(this.f83i, this.f82h);
        }
        this.f80f = (TextView) findViewById(C0159R.id.shortcut);
    }

    public void m76a(C0183h c0183h, int i) {
        this.f75a = c0183h;
        this.f85k = i;
        setVisibility(c0183h.isVisible() ? 0 : 8);
        setTitle(c0183h.m157a((C0170a) this));
        setCheckable(c0183h.isCheckable());
        m77a(c0183h.m170e(), c0183h.m165c());
        setIcon(c0183h.getIcon());
        setEnabled(c0183h.isEnabled());
    }

    public void setForceShowIcon(boolean z) {
        this.f88n = z;
        this.f84j = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f78d.setText(charSequence);
            if (this.f78d.getVisibility() != 0) {
                this.f78d.setVisibility(0);
            }
        } else if (this.f78d.getVisibility() != 8) {
            this.f78d.setVisibility(8);
        }
    }

    public C0183h getItemData() {
        return this.f75a;
    }

    public void setCheckable(boolean z) {
        if (z || this.f77c != null || this.f79e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f75a.m171f()) {
                if (this.f77c == null) {
                    m74c();
                }
                compoundButton = this.f77c;
                compoundButton2 = this.f79e;
            } else {
                if (this.f79e == null) {
                    m75d();
                }
                compoundButton = this.f79e;
                compoundButton2 = this.f77c;
            }
            if (z) {
                int i;
                compoundButton.setChecked(this.f75a.isChecked());
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f79e != null) {
                this.f79e.setVisibility(8);
            }
            if (this.f77c != null) {
                this.f77c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f75a.m171f()) {
            if (this.f77c == null) {
                m74c();
            }
            compoundButton = this.f77c;
        } else {
            if (this.f79e == null) {
                m75d();
            }
            compoundButton = this.f79e;
        }
        compoundButton.setChecked(z);
    }

    public void m77a(boolean z, char c) {
        int i = (z && this.f75a.m170e()) ? 0 : 8;
        if (i == 0) {
            this.f80f.setText(this.f75a.m167d());
        }
        if (this.f80f.getVisibility() != i) {
            this.f80f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        int i = (this.f75a.m173h() || this.f88n) ? 1 : 0;
        if (i == 0 && !this.f84j) {
            return;
        }
        if (this.f76b != null || drawable != null || this.f84j) {
            if (this.f76b == null) {
                m73b();
            }
            if (drawable != null || this.f84j) {
                ImageView imageView = this.f76b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f76b.getVisibility() != 0) {
                    this.f76b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f76b.setVisibility(8);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f76b != null && this.f84j) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f76b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void m73b() {
        this.f76b = (ImageView) getInflater().inflate(C0159R.layout.abc_list_menu_item_icon, this, false);
        addView(this.f76b, 0);
    }

    private void m74c() {
        this.f77c = (RadioButton) getInflater().inflate(C0159R.layout.abc_list_menu_item_radio, this, false);
        addView(this.f77c);
    }

    private void m75d() {
        this.f79e = (CheckBox) getInflater().inflate(C0159R.layout.abc_list_menu_item_checkbox, this, false);
        addView(this.f79e);
    }

    public boolean m78a() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.f87m == null) {
            this.f87m = LayoutInflater.from(this.f86l);
        }
        return this.f87m;
    }
}
