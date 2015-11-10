package com.tinder.fragments;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.fragments.FragmentAnchoredPopup.C2567a;
import com.tinder.managers.ManagerApp;
import com.tinder.p030d.C2430i;
import com.tinder.utils.C3095y;

public class ab extends C2567a {
    private FragmentAnchoredPopup f4851a;
    private Context f4852b;
    private C2430i f4853c;

    /* renamed from: com.tinder.fragments.ab.1 */
    class C26011 implements OnClickListener {
        final /* synthetic */ ab f4849a;

        C26011(ab abVar) {
            this.f4849a = abVar;
        }

        public void onClick(View view) {
            if (this.f4849a.f4853c != null) {
                this.f4849a.f4853c.m6750b(view);
            }
            this.f4849a.f4851a.m7071d();
        }
    }

    /* renamed from: com.tinder.fragments.ab.2 */
    class C26022 implements OnClickListener {
        final /* synthetic */ ab f4850a;

        C26022(ab abVar) {
            this.f4850a = abVar;
        }

        public void onClick(View view) {
            if (this.f4850a.f4853c != null) {
                this.f4850a.f4853c.m6749a(view);
            }
            this.f4850a.f4851a.m7071d();
        }
    }

    public void m7152a(FragmentAnchoredPopup fragmentAnchoredPopup, C2720t c2720t) {
        if (c2720t.getActivity() == null || fragmentAnchoredPopup.getActivity() == null) {
            C3095y.m9479c("Cannot configure a dialog when the recomendation fragment does not have an activity");
            return;
        }
        this.f4852b = fragmentAnchoredPopup.getActivity();
        this.f4851a = fragmentAnchoredPopup;
        this.f4851a.m7063a(80, R.id.superlike, Strategy.GAMEPAD, c2720t);
        this.f4851a.m7062a(this.f4851a.getResources().getColor(R.color.white));
        View b = this.f4851a.m7066b((int) R.id.dialog_top_view);
        if (b != null) {
            b.setVisibility(8);
        }
        b = this.f4851a.m7066b((int) R.id.dialog_top_bottom);
        if (b != null) {
            b.setPadding(0, 0, 0, 0);
        }
        if (ManagerApp.m7924o().m8724k() != null) {
            CharSequence format = String.format(this.f4852b.getResources().getString(R.string.superlike_first_use_title), new Object[]{ManagerApp.m7924o().m8724k().getName()});
            CharSequence format2 = String.format(this.f4852b.getResources().getString(R.string.superlike_first_use_body), new Object[]{r0.getName()});
            View inflate = View.inflate(this.f4851a.getActivity(), R.layout.dialog_superlike_content, null);
            ((TextView) inflate.findViewById(R.id.content_title)).setText(format);
            ((TextView) inflate.findViewById(R.id.content_text)).setText(format2);
            this.f4851a.setCenterView(inflate);
        }
        b = LayoutInflater.from(this.f4851a.getActivity()).inflate(R.layout.dialog_superlike_bottom, c2720t.m7698v(), false);
        b.findViewById(R.id.superlike_pos).setOnClickListener(new C26011(this));
        b.findViewById(R.id.superlike_neg).setOnClickListener(new C26022(this));
        this.f4851a.setBottomView(b);
        ImageButton imageButton = (ImageButton) this.f4851a.m7066b((int) R.id.superlike_icon);
        if (imageButton != null) {
            imageButton.setImageDrawable(ContextCompat.getDrawable(this.f4852b, R.drawable.recs_btn_superlike_enabled));
        }
        C3095y.m9471a("passport button null?:" + (imageButton == null));
    }

    public void m7151a(C2430i c2430i) {
        this.f4853c = c2430i;
    }
}
