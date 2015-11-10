package com.tinder.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.activities.ActivityMain;
import com.tinder.fragments.C2599a;
import com.tinder.fragments.C2603b;
import com.tinder.fragments.C2607c;
import com.tinder.fragments.C2610d;
import com.tinder.fragments.C2720t;
import com.tinder.fragments.C2726u;
import com.tinder.fragments.C2728v;
import com.tinder.fragments.C2731w;
import com.tinder.p030d.af;
import com.tinder.utils.C3095y;
import java.util.HashMap;
import java.util.Map;

public class CustomActionBar extends RelativeLayout {
    private Context mCtx;
    @NonNull
    private final Map<Integer, String> mIconContentDescriptions;
    private ImageButton mIconLeft;
    private ImageButton mIconRightCenter;
    private ImageButton mIconRightLeft;
    private ImageButton mIconRightRight;
    private TextView mTextCenter;
    private TextView mTextCenterLeft;
    private String mTitleAddPhoto;
    private String mTitleAlbums;
    private View mViewSeparator;

    /* renamed from: com.tinder.views.CustomActionBar.1 */
    class C31031 implements af {
        C31031() {
        }

        public void onMenuItemClick(int i) {
            if (!(CustomActionBar.this.mCtx instanceof ActivityMain)) {
            }
        }
    }

    /* renamed from: com.tinder.views.CustomActionBar.2 */
    class C31042 implements af {
        C31042() {
        }

        public void onMenuItemClick(int i) {
            C3095y.m9471a("Menu button clicked");
            ((ActivityMain) CustomActionBar.this.mCtx).m6202j();
        }
    }

    /* renamed from: com.tinder.views.CustomActionBar.3 */
    class C31053 implements af {
        C31053() {
        }

        public void onMenuItemClick(int i) {
            if (!(CustomActionBar.this.mCtx instanceof ActivityMain)) {
            }
        }
    }

    /* renamed from: com.tinder.views.CustomActionBar.4 */
    class C31064 implements af {
        C31064() {
        }

        public void onMenuItemClick(int i) {
            ((ActivityMain) CustomActionBar.this.mCtx).m6202j();
        }
    }

    /* renamed from: com.tinder.views.CustomActionBar.5 */
    class C31075 implements af {
        C31075() {
        }

        public void onMenuItemClick(int i) {
            C3095y.m9469a();
            if (CustomActionBar.this.mCtx instanceof ActivityMain) {
                ((ActivityMain) CustomActionBar.this.mCtx).m6205m();
            }
        }
    }

    /* renamed from: com.tinder.views.CustomActionBar.6 */
    class C31086 implements OnClickListener {
        final /* synthetic */ af val$listenerMenuItemClick;
        final /* synthetic */ int val$resId;

        C31086(af afVar, int i) {
            this.val$listenerMenuItemClick = afVar;
            this.val$resId = i;
        }

        public void onClick(View view) {
            this.val$listenerMenuItemClick.onMenuItemClick(this.val$resId);
        }
    }

    /* renamed from: com.tinder.views.CustomActionBar.7 */
    class C31097 implements OnClickListener {
        final /* synthetic */ af val$listenerMenuItemClick;
        final /* synthetic */ int val$resId;

        C31097(af afVar, int i) {
            this.val$listenerMenuItemClick = afVar;
            this.val$resId = i;
        }

        public void onClick(View view) {
            this.val$listenerMenuItemClick.onMenuItemClick(this.val$resId);
        }
    }

    public CustomActionBar(@NonNull Context context) {
        super(context);
        init(context);
        this.mIconContentDescriptions = new HashMap(10);
        this.mIconContentDescriptions.put(Integer.valueOf(R.drawable.selector_actionbar_matches), "action_bar_icon_matches");
        this.mIconContentDescriptions.put(Integer.valueOf(R.drawable.selector_actionbar_menu), "action_bar_icon_menu");
        this.mIconContentDescriptions.put(Integer.valueOf(R.drawable.selector_actionbar_add), "action_bar_icon_add");
        this.mIconContentDescriptions.put(Integer.valueOf(R.drawable.selector_actionbar_back), "action_bar_icon_back");
        this.mIconContentDescriptions.put(Integer.valueOf(R.drawable.selector_actionbar_profile), "action_bar_icon_profile");
        this.mIconContentDescriptions.put(Integer.valueOf(R.drawable.selector_actionbar_edit), "action_bar_icon_edit");
        this.mIconContentDescriptions.put(Integer.valueOf(R.drawable.selector_actionbar_delete), "action_bar_icon_delete");
        this.mIconContentDescriptions.put(Integer.valueOf(R.drawable.selector_actionbar_swap), "action_bar_icon_swap");
        this.mIconContentDescriptions.put(Integer.valueOf(R.drawable.selector_actionbar_main), "action_bar_icon_main");
    }

    public static void setIcon(@NonNull ImageButton imageButton, int i) {
        imageButton.setImageResource(i);
    }

    private void init(Context context) {
        this.mCtx = context;
        inflate(this.mCtx, R.layout.view_actionbar, this);
        this.mIconLeft = (ImageButton) findViewById(R.id.item_left);
        this.mTextCenterLeft = (TextView) findViewById(R.id.item_text_centerLeft);
        this.mTextCenter = (TextView) findViewById(R.id.item_text_center);
        this.mIconRightLeft = (ImageButton) findViewById(R.id.item_right_left);
        this.mIconRightCenter = (ImageButton) findViewById(R.id.item_right_center);
        this.mIconRightRight = (ImageButton) findViewById(R.id.item_right_right);
        this.mViewSeparator = findViewById(R.id.view_separator);
        this.mTitleAlbums = getResources().getString(R.string.albums);
        this.mTitleAddPhoto = getResources().getString(R.string.add_a_photo);
    }

    public void setMenu(Object obj) {
        C3095y.m9471a("item=" + obj);
        this.mTextCenter.setVisibility(0);
        this.mTextCenterLeft.setOnClickListener(null);
        this.mIconRightCenter.setPadding(0, 0, 0, 0);
        if (obj instanceof C2610d) {
            C2610d c2610d = (C2610d) obj;
            this.mTextCenterLeft.setVisibility(0);
            this.mTextCenterLeft.setOnClickListener(c2610d);
            this.mViewSeparator.setVisibility(0);
            setTitle(this.mCtx.getString(R.string.settings));
            setHomeAsUpText(null);
            setIcon(this.mIconRightCenter, 0);
            setIcon(this.mIconRightRight, R.drawable.selector_actionbar_matches, new C31031());
        } else if (obj instanceof C2720t) {
            C3095y.m9471a("FragmentRecommendations");
            setIcon(this.mIconLeft, R.drawable.selector_actionbar_menu, new C31042());
            setHomeAsUpText(null);
            setTitle(null);
            setIcon(this.mIconRightRight, R.drawable.selector_actionbar_matches, new C31053());
        } else if (obj instanceof C2607c) {
            C2607c c2607c = (C2607c) obj;
            setIcon(this.mIconLeft, R.drawable.selector_actionbar_back, c2607c);
            this.mTextCenterLeft.setOnClickListener(c2607c);
            setHomeAsUpText(this.mTitleAlbums);
            setTitle(BuildConfig.FLAVOR);
            this.mIconRightRight.setVisibility(8);
        } else if (obj instanceof C2599a) {
            C2599a c2599a = (C2599a) obj;
            setIcon(this.mIconLeft, R.drawable.selector_actionbar_back, c2599a);
            this.mTextCenterLeft.setOnClickListener(c2599a);
            setHomeAsUpText(this.mTitleAddPhoto);
            setTitle(BuildConfig.FLAVOR);
            this.mIconRightRight.setVisibility(8);
        } else if (obj instanceof C2731w) {
            C2731w c2731w = (C2731w) obj;
            setIcon(this.mIconLeft, R.drawable.selector_actionbar_back, c2731w);
            this.mTextCenterLeft.setVisibility(0);
            this.mTextCenterLeft.setOnClickListener(c2731w);
            this.mTextCenterLeft.setText(R.string.phone_verification);
            setIcon(this.mIconRightRight, 0);
            setTitle(BuildConfig.FLAVOR);
        } else if (obj instanceof C2726u) {
            C2726u c2726u = (C2726u) obj;
            setIcon(this.mIconLeft, R.drawable.selector_actionbar_back, c2726u);
            this.mTextCenterLeft.setVisibility(0);
            this.mTextCenterLeft.setOnClickListener(c2726u);
            this.mTextCenterLeft.setText(R.string.phone_verification);
            setTitle(BuildConfig.FLAVOR);
        } else if (obj instanceof C2728v) {
            C2728v c2728v = (C2728v) obj;
            setIcon(this.mIconLeft, R.drawable.selector_actionbar_back, c2728v);
            this.mTextCenterLeft.setVisibility(0);
            this.mTextCenterLeft.setOnClickListener(c2728v);
            this.mTextCenterLeft.setText(R.string.choose_country);
            setTitle(BuildConfig.FLAVOR);
        } else if (obj instanceof C2603b) {
            C2603b c2603b = (C2603b) obj;
            setIcon(this.mIconLeft, R.drawable.selector_actionbar_back, c2603b);
            this.mTextCenterLeft.setVisibility(0);
            this.mTextCenterLeft.setOnClickListener(c2603b);
            this.mTextCenterLeft.setText(R.string.complete_profile);
            setIcon(this.mIconRightRight, 0);
            setTitle(BuildConfig.FLAVOR);
        } else {
            setIcon(this.mIconLeft, R.drawable.selector_actionbar_menu, new C31064());
            setHomeAsUpText(null);
            setTitle(null);
            setIcon(this.mIconRightCenter, 0);
            setIcon(this.mIconRightRight, R.drawable.selector_actionbar_matches, new C31075());
        }
    }

    public void setIcon(@NonNull ImageButton imageButton, int i, @NonNull af afVar) {
        imageButton.setImageResource(i);
        imageButton.setOnClickListener(new C31086(afVar, i));
        imageButton.setVisibility(0);
        imageButton.setContentDescription(getIconContentDescription(i));
    }

    private String getIconContentDescription(int i) {
        return (String) this.mIconContentDescriptions.get(Integer.valueOf(i));
    }

    public void setIconLeft(int i, @NonNull af afVar) {
        this.mIconLeft.setImageResource(i);
        this.mIconLeft.setOnClickListener(new C31097(afVar, i));
        this.mIconLeft.setVisibility(0);
        this.mIconLeft.setContentDescription(getIconContentDescription(i));
    }

    public void setTitle(@Nullable String str) {
        if (str == null) {
            this.mTextCenter.setBackgroundResource(R.drawable.actionbar_tinder_logo);
        } else {
            this.mTextCenter.setBackgroundResource(0);
        }
        this.mTextCenter.setText(str);
        this.mTextCenter.setVisibility(0);
    }

    public void setHomeAsUpText(String str) {
        this.mTextCenterLeft.setText(str);
    }

    public ImageButton getIconLeft() {
        return this.mIconLeft;
    }

    public TextView getTextHomeAsUp() {
        return this.mTextCenterLeft;
    }

    public TextView getTextCenter() {
        return this.mTextCenter;
    }

    public ImageButton getIconCenterRight() {
        return this.mIconRightCenter;
    }

    public ImageButton getIconRight() {
        return this.mIconRightRight;
    }
}
