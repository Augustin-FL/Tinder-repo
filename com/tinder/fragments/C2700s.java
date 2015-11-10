package com.tinder.fragments;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.tinder.R;
import com.tinder.managers.ManagerApp;
import com.tinder.p030d.C2430i;
import com.tinder.utils.C3045a;
import com.tinder.utils.al;
import com.tinder.views.PeekStack;

/* renamed from: com.tinder.fragments.s */
public class C2700s extends DialogFragment {
    protected SpringSystem f5233a;
    private ImageButton f5234b;
    private C2430i f5235c;
    private ImageView f5236d;
    private boolean f5237e;
    private View f5238f;
    private View f5239g;
    private int f5240h;
    private int f5241i;

    /* renamed from: com.tinder.fragments.s.1 */
    class C26951 implements OnClickListener {
        final /* synthetic */ C2700s f5226a;

        C26951(C2700s c2700s) {
            this.f5226a = c2700s;
        }

        public void onClick(View view) {
            this.f5226a.dismiss();
        }
    }

    /* renamed from: com.tinder.fragments.s.2 */
    class C26962 implements OnClickListener {
        final /* synthetic */ C2700s f5227a;

        C26962(C2700s c2700s) {
            this.f5227a = c2700s;
        }

        public void onClick(View view) {
            if (this.f5227a.f5235c != null) {
                this.f5227a.f5235c.m6749a(view);
            }
            this.f5227a.dismiss();
        }
    }

    /* renamed from: com.tinder.fragments.s.3 */
    class C26973 implements OnClickListener {
        final /* synthetic */ C2700s f5228a;

        C26973(C2700s c2700s) {
            this.f5228a = c2700s;
        }

        public void onClick(View view) {
            if (this.f5228a.f5235c != null) {
                this.f5228a.f5235c.m6750b(view);
            }
            this.f5228a.getDialog().dismiss();
        }
    }

    /* renamed from: com.tinder.fragments.s.4 */
    class C26984 extends SimpleSpringListener {
        final /* synthetic */ int f5229a;
        final /* synthetic */ C2700s f5230b;

        C26984(C2700s c2700s, int i) {
            this.f5230b = c2700s;
            this.f5229a = i;
        }

        public void onSpringUpdate(@NonNull Spring spring) {
            al.m9274a(this.f5230b.f5236d, (float) Math.min(1.0d, spring.getCurrentValue()));
            al.m9296c(this.f5230b.f5239g, (float) spring.getCurrentValue());
            this.f5230b.f5239g.setTranslationY((-(1.0f - ((float) spring.getCurrentValue()))) * ((float) this.f5229a));
        }

        public void onSpringAtRest(Spring spring) {
            this.f5230b.f5237e = false;
        }

        public void onSpringActivate(Spring spring) {
            this.f5230b.f5238f.setVisibility(0);
        }
    }

    /* renamed from: com.tinder.fragments.s.5 */
    class C26995 extends SimpleSpringListener {
        final /* synthetic */ int f5231a;
        final /* synthetic */ C2700s f5232b;

        C26995(C2700s c2700s, int i) {
            this.f5232b = c2700s;
            this.f5231a = i;
        }

        public void onSpringUpdate(@NonNull Spring spring) {
            al.m9274a(this.f5232b.f5236d, (float) Math.min(1.0d, spring.getCurrentValue()));
            al.m9296c(this.f5232b.f5239g, (float) spring.getCurrentValue());
            this.f5232b.f5239g.setTranslationY((1.0f - ((float) spring.getCurrentValue())) * ((float) this.f5231a));
        }

        public void onSpringAtRest(Spring spring) {
            this.f5232b.f5237e = false;
            this.f5232b.f5238f.setVisibility(8);
            this.f5232b.getDialog().dismiss();
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.superlike_reminder, viewGroup, false);
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5238f = view;
        this.f5236d = (ImageView) view.findViewById(R.id.dialog_background);
        this.f5239g = view.findViewById(R.id.dialog_popup_card_content);
        this.f5234b = (ImageButton) view.findViewById(R.id.profile_btn_superlike);
        View findViewById = view.findViewById(R.id.include_gamepad);
        if (findViewById != null) {
            findViewById.setBackgroundResource(0);
        }
        this.f5234b.setVisibility(0);
        this.f5234b.setOnClickListener(new C26951(this));
        this.f5240h = this.f5234b.getHeight();
        this.f5241i = al.m9285b(getActivity());
        view.findViewById(R.id.superlike_neg).setOnClickListener(new C26962(this));
        view.findViewById(R.id.superlike_pos).setOnClickListener(new C26973(this));
        if (ManagerApp.m7924o().m8724k() != null) {
            CharSequence format = String.format(getResources().getString(R.string.superlike_first_use_title), new Object[]{r0.getName()});
            CharSequence format2 = String.format(getResources().getString(R.string.superlike_first_use_body), new Object[]{r0.getName()});
            ((TextView) view.findViewById(R.id.content_title)).setText(format);
            ((TextView) view.findViewById(R.id.content_text)).setText(format2);
        }
        m7544a();
        m7547b();
    }

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getWindow().requestFeature(1);
        return onCreateDialog;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(-1, -1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    public void m7552a(C2430i c2430i) {
        this.f5235c = c2430i;
    }

    private void m7544a() {
        C3045a.m9203a(this.f5234b, 1.0f, (float) PeekStack.HEIGHT_PERCENT_OF_SCREEN, 200, 200);
        this.f5233a = SpringSystem.create();
    }

    private void m7547b() {
        m7551d().setCurrentValue(0.0d).setEndValue(1.0d).addListener(new C26984(this, m7548c()));
    }

    private int m7548c() {
        return (al.m9263a(this.f5234b).y + (this.f5240h / 2)) - (this.f5241i / 2);
    }

    public void dismiss() {
        if (!this.f5237e) {
            this.f5237e = true;
            int c = m7548c();
            Spring overshootClampingEnabled = m7551d().setCurrentValue(1.0d).setEndValue(0.0d).setOvershootClampingEnabled(true);
            this.f5238f.setVisibility(0);
            overshootClampingEnabled.addListener(new C26995(this, c));
        }
    }

    private Spring m7551d() {
        return this.f5233a.createSpring().setVelocity(200.0d).setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(42.0d, 7.0d));
    }
}
