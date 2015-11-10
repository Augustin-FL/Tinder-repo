package com.tinder.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.activities.ActivityMain;
import com.tinder.base.C2418c;
import com.tinder.dialogs.C2518s;
import com.tinder.enums.PhotoSizeUser;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2828c;
import com.tinder.managers.C2828c.C2587a;
import com.tinder.managers.C2958p;
import com.tinder.managers.ManagerApp;
import com.tinder.model.GlobalConfig;
import com.tinder.model.SparksEvent;
import com.tinder.model.User;
import com.tinder.model.UserMeta;
import com.tinder.p030d.ah;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.BlurredDrawable;
import com.tinder.views.VerifiedBadgeView;
import java.util.List;
import org.apache.http.protocol.HTTP;

public class FragmentSideMenu extends C2418c implements ah, C2281x {
    TextView f4813a;
    ImageView f4814b;
    View f4815c;
    ImageView f4816d;
    View f4817e;
    View f4818f;
    View f4819g;
    View f4820h;
    View f4821i;
    View f4822j;
    private VerifiedBadgeView f4823k;
    private BlurredDrawable f4824l;
    private int f4825m;
    private int f4826n;
    private C2518s f4827o;

    /* renamed from: com.tinder.fragments.FragmentSideMenu.1 */
    class C25851 implements OnClickListener {
        final /* synthetic */ FragmentSideMenu f4805a;

        C25851(FragmentSideMenu fragmentSideMenu) {
            this.f4805a = fragmentSideMenu;
        }

        public void onClick(View view) {
            C2807a.m8058a("Menu.Profile");
            ((ActivityMain) this.f4805a.getActivity()).m6214v();
        }
    }

    /* renamed from: com.tinder.fragments.FragmentSideMenu.2 */
    class C25862 implements OnClickListener {
        final /* synthetic */ FragmentSideMenu f4806a;

        C25862(FragmentSideMenu fragmentSideMenu) {
            this.f4806a = fragmentSideMenu;
        }

        public void onClick(View view) {
            C2807a.m8058a("Menu.Settings");
            ((ActivityMain) this.f4806a.getActivity()).m6162C();
        }
    }

    /* renamed from: com.tinder.fragments.FragmentSideMenu.3 */
    class C25893 implements OnClickListener {
        final /* synthetic */ FragmentSideMenu f4808a;

        /* renamed from: com.tinder.fragments.FragmentSideMenu.3.1 */
        class C25881 implements C2587a {
            final /* synthetic */ C25893 f4807a;

            C25881(C25893 c25893) {
                this.f4807a = c25893;
            }

            public void m7121a(String str) {
                ManagerApp.m7930u().m8492a(this.f4807a.f4808a.getActivity(), str);
            }
        }

        C25893(FragmentSideMenu fragmentSideMenu) {
            this.f4808a = fragmentSideMenu;
        }

        public void onClick(View view) {
            C2807a.m8056a(new SparksEvent("Menu.Faq"));
            ManagerApp.m7912c();
            C2828c.m8155a(new C25881(this));
        }
    }

    /* renamed from: com.tinder.fragments.FragmentSideMenu.4 */
    class C25904 implements OnClickListener {
        final /* synthetic */ FragmentSideMenu f4809a;

        C25904(FragmentSideMenu fragmentSideMenu) {
            this.f4809a = fragmentSideMenu;
        }

        public void onClick(View view) {
            C2807a.m8058a("Menu.Discovery");
            ((ActivityMain) this.f4809a.getActivity()).m6163D();
        }
    }

    /* renamed from: com.tinder.fragments.FragmentSideMenu.5 */
    class C25915 implements OnClickListener {
        final /* synthetic */ FragmentSideMenu f4810a;

        C25915(FragmentSideMenu fragmentSideMenu) {
            this.f4810a = fragmentSideMenu;
        }

        public void onClick(View view) {
            C2807a.m8058a("Menu.Share");
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType(HTTP.PLAIN_TEXT_TYPE);
            intent.putExtra("android.intent.extra.TEXT", this.f4810a.getString(R.string.share_text));
            this.f4810a.startActivity(Intent.createChooser(intent, this.f4810a.getString(R.string.share_dialog_title)));
        }
    }

    /* renamed from: com.tinder.fragments.FragmentSideMenu.6 */
    class C25926 implements OnClickListener {
        final /* synthetic */ FragmentSideMenu f4811a;

        C25926(FragmentSideMenu fragmentSideMenu) {
            this.f4811a = fragmentSideMenu;
        }

        public void onClick(View view) {
            if (!al.m9290b(this.f4811a.f4827o)) {
                this.f4811a.f4827o = new C2518s(this.f4811a.getActivity(), 0, "menu");
                this.f4811a.f4827o.show();
            }
        }
    }

    /* renamed from: com.tinder.fragments.FragmentSideMenu.7 */
    class C25937 implements OnClickListener {
        final /* synthetic */ FragmentSideMenu f4812a;

        C25937(FragmentSideMenu fragmentSideMenu) {
            this.f4812a = fragmentSideMenu;
        }

        public void onClick(View view) {
            if (!al.m9290b(this.f4812a.f4827o)) {
                this.f4812a.f4827o = new C2518s(this.f4812a.getActivity(), 1, "menu");
                this.f4812a.f4827o.show();
            }
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.view_side_menu, viewGroup, false);
        this.f4813a = (TextView) inflate.findViewById(R.id.txt_settings_my_name);
        this.f4814b = (ImageView) inflate.findViewById(R.id.img_settings_avatar);
        this.f4815c = inflate.findViewById(R.id.relative_settings_header);
        this.f4816d = (ImageView) inflate.findViewById(R.id.img_header_background);
        this.f4817e = inflate.findViewById(R.id.relative_app_settings);
        this.f4818f = inflate.findViewById(R.id.relative_discover_prefs);
        this.f4819g = inflate.findViewById(R.id.relative_faq);
        this.f4820h = inflate.findViewById(R.id.relative_share_tinder);
        this.f4821i = inflate.findViewById(R.id.relative_give_feedback);
        this.f4822j = inflate.findViewById(R.id.relative_rate_us);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        ManagerApp.m7911b().m8141b((ah) this);
        C3095y.m9469a();
        m7124b();
        m7125a();
    }

    public void onPause() {
        ManagerApp.m7911b().m8140a((ah) this);
        super.onPause();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    private void m7124b() {
        C3095y.m9469a();
        this.f4824l = new BlurredDrawable(getActivity());
        User d = ManagerApp.m7922m().m8599d();
        this.f4823k = (VerifiedBadgeView) getView().findViewById(R.id.verified_badge);
        this.f4823k.setFiltered(true);
        if (d != null) {
            this.f4823k.displayBadge(d);
            this.f4813a.setText(d.getName());
        }
        this.f4825m = getActivity().getResources().getDimensionPixelSize(R.dimen.menu_width);
        this.f4826n = getActivity().getResources().getDimensionPixelSize(R.dimen.settings_header_height);
        this.f4813a.setTag(this);
        al.m9270a(this.f4815c, 0.85f);
        this.f4815c.setOnClickListener(new C25851(this));
        this.f4817e.setOnClickListener(new C25862(this));
        this.f4819g.setOnClickListener(new C25893(this));
        this.f4818f.setOnClickListener(new C25904(this));
        this.f4820h.setOnClickListener(new C25915(this));
        this.f4822j.setOnClickListener(new C25926(this));
        this.f4821i.setOnClickListener(new C25937(this));
        List avatarUrlsForSize = d.getAvatarUrlsForSize(PhotoSizeUser.MED);
        if (!(avatarUrlsForSize == null || avatarUrlsForSize.isEmpty())) {
            Picasso.m8982a(getActivity()).m8990a((String) avatarUrlsForSize.get(0)).m9121a((int) R.dimen.settings_avatar_length, (int) R.dimen.settings_avatar_length).m9127b().m9124a(this.f4814b);
        }
        avatarUrlsForSize = d.getAvatarUrlsForSize(PhotoSizeUser.LARGE);
        if (avatarUrlsForSize != null && !avatarUrlsForSize.isEmpty()) {
            Picasso.m8982a(getActivity()).m8990a((String) avatarUrlsForSize.get(0)).m9129b(this.f4825m, this.f4826n).m9127b().m9126a((C2281x) this);
        }
    }

    public void m7125a() {
        boolean b = C2958p.m8782b();
        boolean c = C2958p.m8784c();
        C3095y.m9471a("show feedback option " + b + " show rate option " + c);
        if (b) {
            this.f4821i.setVisibility(0);
            this.f4822j.setVisibility(8);
        } else if (c) {
            this.f4822j.setVisibility(0);
            this.f4821i.setVisibility(8);
        } else {
            this.f4822j.setVisibility(8);
            this.f4821i.setVisibility(8);
        }
    }

    public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
        this.f4816d.setImageDrawable(this.f4824l);
        this.f4824l.blurBitmap(bitmap, 24);
    }

    public void onBitmapFailed(Drawable drawable) {
        C3095y.m9469a();
    }

    public void onPrepareLoad(Drawable drawable) {
        C3095y.m9469a();
    }

    public void m7126a(GlobalConfig globalConfig, UserMeta userMeta) {
        if (userMeta != null) {
            Object d = ManagerApp.m7922m().m8599d();
            if (d != null) {
                this.f4823k.displayBadge(d);
                this.f4813a.setText(d.getName());
            }
        }
    }
}
